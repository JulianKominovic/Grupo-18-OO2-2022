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
import com.unla.Grupo18.entities.Perfiles;
import com.unla.Grupo18.entities.Tradicional;
import com.unla.Grupo18.entities.Usuario;
import com.unla.Grupo18.helpers.ViewRouteHelper;
import com.unla.Grupo18.services.IAulaService;
import com.unla.Grupo18.services.IEdificioService;
import com.unla.Grupo18.services.ILaboratorioService;
import com.unla.Grupo18.services.ITradicionalService;

@Controller
@RequestMapping("/aulas")
public class AulaController {
	@Autowired
	private IEdificioService edificioService;
	@Autowired
	private ITradicionalService tradicionalService;
	@Autowired
	private ILaboratorioService laboratorioService;
	@Autowired
	private IAulaService aulaService;

	
	@GetMapping("/lista")
	public String listarEspacios(Model model) {
		List<Aula> listado = aulaService.getAll();
		List<Aula> aulasTradicional = new ArrayList<Aula>();
		List<Aula> aulasLaboratorio = new ArrayList<Aula>();
		for (Aula a : listado) {
			if(a instanceof Tradicional) {
				aulasTradicional.add(a);
			}
			if(a instanceof Laboratorio) {
				aulasLaboratorio.add(a);
			}
		}
		model.addAttribute("titulo", "Lista de aulas");
		model.addAttribute("tituloTradicional", "Tradicional");
		model.addAttribute("tituloLaboratorio", "Laboratorio");
		model.addAttribute("aulasTradicional", aulasTradicional);
		model.addAttribute("aulasLaboratorio", aulasLaboratorio);
		return "aula/lista";
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		aulaService.eliminar(id);
		System.out.println("Aula eliminada con exito");
		attribute.addFlashAttribute("warning","Aula eliminada con exito");
		return "redirect:/aulas/lista";
	}
	
	@GetMapping("/crear/tradicional")
	public String crearTradicional(Model model) {
		Tradicional tradicional = new Tradicional();
		List<Edificio> edificios = edificioService.getAll();
		model.addAttribute("titulo", "Nueva aula");
		model.addAttribute("edificios", edificios);
		model.addAttribute("tradicional", tradicional);
		return "aula/crearTradicional";
	}
	
	@PostMapping("/crear/tradicional")
	public String guardarTradicional( @Valid @ModelAttribute Tradicional tradicional, BindingResult result,Model model,RedirectAttributes attribute) {
		if(validaLogica(tradicional)) {
			System.out.println("Se introdujo un valor imposible.");
			attribute.addFlashAttribute("error","Se introdujo un valor que no es posible.");
			return "redirect:/aulas/lista";
		}
		if(validaRepetidos(tradicional)) {
			System.out.println("Ya existe un aula con esas caracteristicas.");
			attribute.addFlashAttribute("error","Ya existe un aula con esas caracteristicas.");
			return "redirect:/aulas/lista";
		}
		tradicionalService.save(tradicional);
		System.out.println("Aula guardada con exito!");
		attribute.addFlashAttribute("success","Aula agregada con exito");
		return "redirect:/aulas/lista";
	}
	
	@GetMapping("/crear/laboratorio")
	public String crearLaboratorio(Model model) {
		Laboratorio laboratorio = new Laboratorio();
		List<Edificio> edificios = edificioService.getAll();
		model.addAttribute("titulo", "Nueva Aula");
		model.addAttribute("edificios", edificios);
		model.addAttribute("laboratorio", laboratorio);
		return "aula/crearLaboratorio";
	}
	
	@PostMapping("/crear/laboratorio")
	public String guardarLaboratorio(@Valid @ModelAttribute Laboratorio laboratorio, BindingResult result,Model model,RedirectAttributes attribute) {
		if(validaLogica(laboratorio)) {
			System.out.println("Se introdujo un valor imposible.");
			attribute.addFlashAttribute("error","Se introdujo un valor que no es posible.");
			return "redirect:/aulas/lista";
		}
		if(validaRepetidos(laboratorio)) {
			System.out.println("Ya existe un aula con esas caracteristicas.");
			attribute.addFlashAttribute("error","Ya existe un aula con esas caracteristicas.");
			return "redirect:/aulas/lista";
		}
		laboratorioService.save(laboratorio);
		System.out.println("Aula guardada con exito!");
		attribute.addFlashAttribute("success","Aula agregada con exito");
		return "redirect:/aulas/lista";
	}
	
	@GetMapping("lista/edit/{id}")
	public String editarTradicional(@PathVariable("id") long id, Model model) {
		Tradicional tradicional = tradicionalService.buscar(id);
		Laboratorio laboratorio = laboratorioService.buscar(id);
		List<Edificio> edificios = edificioService.getAll();
		model.addAttribute("titulo", "Editar aula");
		model.addAttribute("edificios", edificios);
		model.addAttribute("tradicional", tradicional);
		model.addAttribute("laboratorio", laboratorio);
		if(aulaService.buscar(id) instanceof Tradicional) {
			return "aula/crearTradicional";
		}
		else {
			return "aula/crearLaboratorio";
		}
	}
	
	public boolean validaRepetidos(Aula aula) {
		boolean repetido = false;
		List<Aula> listado = aulaService.getAll();
		for (Aula a : listado) {
			if(aula.equals(a)) {
				repetido = true;
			}
		}
		return repetido;
	}
	
	public boolean validaLogica(Aula aula) {
		boolean ilogico = false;
		if(aula instanceof Tradicional) { //validaciones de aula tradicional
			Tradicional auxAula = (Tradicional)aula;
			if(auxAula.getNumero() <= 0 || auxAula.getNumero() > 100) {
				ilogico = true;
			}
			if(auxAula.getCantBancos() <= 0 || auxAula.getCantBancos() > 100) {
				ilogico = true;
			}
		}
		if(aula instanceof Laboratorio) { //validaciones de aula laboratorio
			Laboratorio auxAula = (Laboratorio)aula;
			if(auxAula.getNumero() <= 0 || auxAula.getNumero() > 100) {
				ilogico = true;
			}
			if(auxAula.getCantPC() <= 0 || auxAula.getCantPC() > 100) {
				ilogico = true;
			}
			if(auxAula.getCantSillas() <= 0 || auxAula.getCantSillas() > 100) {
				ilogico = true;
			}
		}
		return ilogico;
	}
}
