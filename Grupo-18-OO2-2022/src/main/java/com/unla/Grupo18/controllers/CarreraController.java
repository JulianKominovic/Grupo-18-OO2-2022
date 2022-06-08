package com.unla.Grupo18.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; 
import com.unla.Grupo18.entities.Carrera;
import com.unla.Grupo18.entities.Departamento;
import com.unla.Grupo18.entities.Perfiles;
import com.unla.Grupo18.helpers.ViewRouteHelper;
import com.unla.Grupo18.services.ICarreraService;
import com.unla.Grupo18.services.IDepartamentoService;
import com.unla.Grupo18.services.IPerfilesService;
import com.unla.Grupo18.services.implementation.DepartamentoService;

@Controller
@RequestMapping("/carrera")
public class CarreraController {
	
	@Autowired
	@Qualifier("carreraService")
	private ICarreraService carreraService; 
	
	@Autowired
	@Qualifier("departamentoService")
	private IDepartamentoService departamentoService;
	
	@GetMapping("/")
	public String crear (Model model) {
		Carrera carrera = new Carrera();
		List<Departamento> departamento = departamentoService.getAll();
		//List<Departamento> departamentos = new ArrayList<Perfiles>();
		model.addAttribute("titulo", "Formulario: Nueva Carrera");
		model.addAttribute("carrera", carrera);
		model.addAttribute("departamento",departamento);
		
		return ViewRouteHelper.CARRERA_CREAR;
	}
	
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Carrera carrera,BindingResult result,Model model,RedirectAttributes attribute) {
		carreraService.save(carrera);
		System.out.println("Carrera guardada con exito!");
		attribute.addFlashAttribute("success", "Carrera agregada con exito");
		return ViewRouteHelper.CARRERA_REDIRECT;	
	}
	
	@GetMapping("/lista")
	public String listarCarreras(Model model) {
		List<Carrera> listado = carreraService.getAll();
		model.addAttribute("titulo","Lista de carreras");
		model.addAttribute("lista",listado);
		return ViewRouteHelper.CARRERA_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id")long id,Model model) {
		Carrera carrera = carreraService.buscar(id);
		List<Departamento> departamento = departamentoService.getAll();
		model.addAttribute("titulo", "Editar carrera");
		model.addAttribute("carrera", carrera);
		model.addAttribute("departamento",departamento);
		return ViewRouteHelper.CARRERA_CREAR;
	}
	 @GetMapping("lista/delete/{id}")
	 public String eliminar(@PathVariable("id")long id,RedirectAttributes attribute) {
		 carreraService.eliminar(id);
		 System.out.println("Carrera eliminada con exito");
		 attribute.addFlashAttribute("warning","Carrera eliminado con exito");
		 return ViewRouteHelper.CARRERA_REDIRECT_LISTA; 
	 }
	
	
}
