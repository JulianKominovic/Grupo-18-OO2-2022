package com.unla.Grupo18.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.Grupo18.entities.Aula;
import com.unla.Grupo18.entities.Edificio;
import com.unla.Grupo18.entities.Espacio;
import com.unla.Grupo18.entities.Laboratorio;
import com.unla.Grupo18.entities.Tradicional;
import com.unla.Grupo18.services.IAulaService;
import com.unla.Grupo18.services.IEdificioService;
import com.unla.Grupo18.services.IEspacioService;
import com.unla.Grupo18.services.ILaboratorioService;
import com.unla.Grupo18.services.ITradicionalService;


@Controller
@RequestMapping("/espacios")
public class EspacioController {
	@Autowired
	private IEspacioService espacioService;
	@Autowired
	private IEdificioService edificioService;
	@Autowired
	private IAulaService aulaService;
	
	@GetMapping("/lista")
	public String listarEspacios(Model model) {
		List<Espacio> listado = espacioService.getAll();
		List<Espacio> espacios = new ArrayList<Espacio>();
		for (Espacio e : listado) {
			if(!LocalDate.now().isBefore(e.getFecha())) { 
				espacioService.eliminar(e.getId());
			}
			espacios.add(e);
		}
		model.addAttribute("titulo", "Lista de espacios");
		model.addAttribute("espacios", espacios);
		return "espacio/lista";
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		espacioService.eliminar(id); //elimino el espacio
		System.out.println("Espacio eliminado con exito");
		attribute.addFlashAttribute("warning","Espacio eliminado con exito");
		return "redirect:/espacios/lista";
	}
	
	@GetMapping("/crear")
	public String crear(Model model) {
		Espacio espacio = new Espacio();
		List<Aula> aulas = aulaService.getAll();
		model.addAttribute("titulo", "Nuevo Espacio");
		model.addAttribute("espacio", espacio);
		model.addAttribute("aulas", aulas);
		return "espacio/crear";
	}
	
	@PostMapping("/crear")
	public String guardar(@Valid @ModelAttribute Espacio espacio,BindingResult result,Model model,RedirectAttributes attribute) {
		espacio.setLibre(true);
		
		if(validaLogica(espacio)) {
			System.out.println("Se introdujo un valor imposible.");
			attribute.addFlashAttribute("error","Se introdujo un valor que no es posible.");
			return "redirect:/espacios/lista";
		}
		if(validaRepetidos(espacio)) {
			System.out.println("Ya existe un espacio con esas caracteristicas.");
			attribute.addFlashAttribute("error","Ya existe un espacio con esas caracteristicas.");
			return "redirect:/espacios/lista";
		}
		
		espacioService.save(espacio);
		System.out.println("Espacio guardado con exito!");
		attribute.addFlashAttribute("success","Espacio agregado con exito");
		return "redirect:/espacios/lista";
	}
		
	public boolean validaRepetidos(Espacio espacio) {
		boolean repetido = false;
		List<Espacio> listado = espacioService.getAll();
		for (Espacio e : listado) {
			if(espacio.equals(e)) {
				repetido = true;
			}
		}
		return repetido;
	}
	public boolean validaLogica(Espacio espacio) {
		boolean ilogico = false;
		if(espacio.getFecha()==null || !espacio.getFecha().isAfter(LocalDate.now())) { //validaciones de fecha
			ilogico = true;
		}
		return ilogico;
	}
}
