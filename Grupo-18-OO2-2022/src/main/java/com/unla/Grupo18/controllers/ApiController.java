package com.unla.Grupo18.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unla.Grupo18.entities.Aula;
import com.unla.Grupo18.entities.Carrera;
import com.unla.Grupo18.entities.Curso;
import com.unla.Grupo18.entities.Edificio;
import com.unla.Grupo18.entities.Espacio;
import com.unla.Grupo18.entities.Final;
import com.unla.Grupo18.entities.Materia;
import com.unla.Grupo18.entities.NotaPedido;
import com.unla.Grupo18.models.requests.PostNotaPedido;
import com.unla.Grupo18.services.IAulaService;
import com.unla.Grupo18.services.ICarreraService;
import com.unla.Grupo18.services.IEdificioService;
import com.unla.Grupo18.services.IEspacioService;
import com.unla.Grupo18.services.IMateriaService;
import com.unla.Grupo18.services.INotaPedidoService;
import com.unla.Grupo18.util.NotaPedidoStatusEnum;

@Controller
@RequestMapping("/api")
public class ApiController {

	Logger logger = LoggerFactory.getLogger(ApiController.class);

	@Autowired
	private IEdificioService edificioService;

	@Autowired
	private IAulaService aulaService;

	@Autowired
	private ICarreraService carreraService;

	@Autowired
	private IMateriaService materiaService;

	@Autowired
	private INotaPedidoService notaService;

	@Autowired
	private IEspacioService espacioService;

	@GetMapping("/edificio")
	public ResponseEntity<List<Edificio>> getAllEdificio() {
		return new ResponseEntity<>(edificioService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/aulas/{id_edificio}")
	public ResponseEntity<List<Aula>> getAulaByEdificio(@PathVariable Long id_edificio) {
		return new ResponseEntity<>(aulaService.getAulasByEdificio(id_edificio), HttpStatus.OK);
	}

	@GetMapping("/carreras")
	public ResponseEntity<List<Carrera>> getCarreras() {
		return new ResponseEntity<>(carreraService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/materias/{id_carrera}")
	public ResponseEntity<List<Materia>> getMateriasByCarrera(@PathVariable Long id_carrera) {
		return new ResponseEntity<>(materiaService.getMateriasByCarrera(id_carrera), HttpStatus.OK);
	}

	@GetMapping("/nota-pedido")
	public ResponseEntity<List<NotaPedido>> getAllNotes() {
		return new ResponseEntity<>(notaService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/nota-pedido/accept/{id}")
	public ResponseEntity<NotaPedido> accept(@PathVariable Long id) {
		return new ResponseEntity<>(notaService.aceptarPedido(id), HttpStatus.OK);
	}

	@GetMapping("/nota-pedido/reject/{id}")
	public ResponseEntity<NotaPedido> reject(@PathVariable Long id) {
		return new ResponseEntity<>(notaService.rechazarPedido(id), HttpStatus.OK);
	}

	@PostMapping("/nota-pedido")
	@ResponseBody
	public ResponseEntity<String> createNotaPedido(@RequestBody @Valid PostNotaPedido body) {

		ResponseEntity<String> response = null;

		try {

			for (LocalDate date : body.getFechas_multiples()) {

				NotaPedido nota = null;
				// CHECKEO SI LA NOTA PEDIDO ES PARA UN FINAL O CURSO
				if (body.getCodCurso() != null) {
					nota = new Curso();
					((Curso) nota).setCodCurso(body.getCodCurso());
				} else {
					nota = new Final();
					((Final) nota).setFechaExamen(date);
				}
				// SETEANDO LAS PROPS EN COMUN
				nota.setFechaInicioPedido(LocalDateTime.now());
				nota.setCantEstudiantes(body.getCantEstudiantes());
				nota.setObservaciones(body.getObservaciones());
				nota.setMateria(materiaService.buscar(body.getMateria()));
				nota.setStatus(NotaPedidoStatusEnum.ESPERANDO);

				Espacio espacio = new Espacio();
				espacio.setAula(aulaService.getAulaById(body.getAulaNumero()));
				espacio.setLibre(false);
				espacio.setTurno(body.getTurno());
				espacio.setFecha(date);

				try {
					nota.setEspacio(espacioService.save(espacio));
				} catch (Exception e) {
					System.out.println("Espacio save falló");
					e.printStackTrace();
					response = new ResponseEntity<>("FAILED - 500", HttpStatus.BAD_REQUEST);
				}

				// GUARDADO

				try {
					if (body.getCodCurso() != null) {
						notaService.save((Curso) nota);
					} else {
						notaService.save((Final) nota);
					}
				} catch (Exception e) {
					System.out.println("Fallo al guardar la nota");
					e.printStackTrace();
					response = new ResponseEntity<>("FAILED - 500", HttpStatus.BAD_REQUEST);
				}
			}

		} catch (Exception e) {
			System.out.println("ERROR AL GUARDAR EL ESPACIO");
			System.out.println(e);
			response = new ResponseEntity<>("FAILED - 500", HttpStatus.BAD_REQUEST);
		}

		response = new ResponseEntity<>("OK - 200", HttpStatus.OK);
		return response;
	}

}
