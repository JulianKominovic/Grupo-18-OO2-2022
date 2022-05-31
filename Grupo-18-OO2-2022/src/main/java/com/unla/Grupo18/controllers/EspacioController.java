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
import com.unla.Grupo18.entities.Edificio;
import com.unla.Grupo18.entities.Espacio;
import com.unla.Grupo18.entities.Laboratorio;
import com.unla.Grupo18.entities.Tradicional;
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
	private ITradicionalService tradicionalService;
	@Autowired
	private ILaboratorioService laboratorioService;
	
	@GetMapping("/lista")
	public String listarEspacios(Model model) {
		List<Espacio> listado = espacioService.getAll();
		List<Espacio> espaciosTradicional = new ArrayList<Espacio>();
		List<Espacio> espaciosLaboratorio = new ArrayList<Espacio>();
		for (Espacio e : listado) {
			if(!LocalDate.now().isBefore(e.getFecha())) { //borro aula y espacio una vez pasada la fecha
				if(e.getAula() instanceof Tradicional) {
					tradicionalService.eliminar(e.getAula().getId());
				}
				if(e.getAula() instanceof Laboratorio) {
					laboratorioService.eliminar(e.getAula().getId());
				}
				espacioService.eliminar(e.getId());
			}
			if(e.getAula() instanceof Tradicional) {
				espaciosTradicional.add(e);
			}
			if(e.getAula() instanceof Laboratorio) {
				espaciosLaboratorio.add(e);
			}
		}
		model.addAttribute("titulo", "Lista de espacios");
		model.addAttribute("tituloTradicional", "Tradicional");
		model.addAttribute("tituloLaboratorio", "Laboratorio");
		model.addAttribute("espaciosTradicional", espaciosTradicional);
		model.addAttribute("espaciosLaboratorio", espaciosLaboratorio);
		return "espacio/lista";
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		if(espacioService.buscar(id).getAula() instanceof Tradicional) { //elimino el aula que contiene el espacio
			tradicionalService.eliminar(espacioService.buscar(id).getAula().getId());
		}
		if(espacioService.buscar(id).getAula() instanceof Laboratorio) {
			laboratorioService.eliminar(espacioService.buscar(id).getAula().getId());
		}
		espacioService.eliminar(id); //elimino el espacio
		System.out.println("Espacio eliminado con exito");
		attribute.addFlashAttribute("warning","Espacio eliminado con exito");
		return "redirect:/espacios/lista";
	}
	
	@GetMapping("/crear/tradicional")
	public String crearTradicional(Model model) {
		Espacio espacio = new Espacio();
		Tradicional tradicional = new Tradicional();
		List<Edificio> edificios = edificioService.getAll();
		model.addAttribute("titulo", "Nuevo Espacio");
		model.addAttribute("espacio", espacio);
		model.addAttribute("edificios", edificios);
		model.addAttribute("tradicional", tradicional);
		return "espacio/crearTradicional";
	}
	
	@PostMapping("/crear/tradicional")
	public String guardarTradicional(@Valid @ModelAttribute Espacio espacio,BindingResult result,Model model,RedirectAttributes attribute, @Valid @ModelAttribute Tradicional tradicional) {
		espacio.setAula(tradicional);
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
		tradicionalService.save(tradicional);
		espacioService.save(espacio);
		System.out.println("Espacio guardado con exito!");
		attribute.addFlashAttribute("success","Espacio agregado con exito");
		return "redirect:/espacios/lista";
	}
	
	@GetMapping("/crear/laboratorio")
	public String crearLaboratorio(Model model) {
		Espacio espacio = new Espacio();
		Laboratorio laboratorio = new Laboratorio();
		List<Edificio> edificios = edificioService.getAll();
		model.addAttribute("titulo", "Nuevo Espacio");
		model.addAttribute("espacio", espacio);
		model.addAttribute("edificios", edificios);
		model.addAttribute("laboratorio", laboratorio);
		return "espacio/crearLaboratorio";
	}
	
	@PostMapping("/crear/laboratorio")
	public String guardarLaboratorio(@Valid @ModelAttribute Espacio espacio,BindingResult result,Model model,RedirectAttributes attribute, @Valid @ModelAttribute Laboratorio laboratorio) {
		espacio.setAula(laboratorio);
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
		laboratorioService.save(laboratorio);
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
		if(espacio.getAula() instanceof Tradicional) { //validaciones de aula tradicional
			Tradicional auxAula = (Tradicional)espacio.getAula();
			if(auxAula.getNumero() < 0 || auxAula.getNumero() > 100) {
				ilogico = true;
			}
			if(auxAula.getCantBancos() < 0 || auxAula.getCantBancos() > 100) {
				ilogico = true;
			}
		}
		if(espacio.getAula() instanceof Laboratorio) { //validaciones de aula laboratorio
			Laboratorio auxAula = (Laboratorio)espacio.getAula();
			if(auxAula.getNumero() < 0 || auxAula.getNumero() > 100) {
				ilogico = true;
			}
			if(auxAula.getCantPC() < 0 || auxAula.getCantPC() > 100) {
				ilogico = true;
			}
			if(auxAula.getCantSillas() < 0 || auxAula.getCantSillas() > 100) {
				ilogico = true;
			}
		}
		if(espacio.getFecha()==null || !espacio.getFecha().isAfter(LocalDate.now())) { //validaciones de fecha
			ilogico = true;
		}
		return ilogico;
	}
}
