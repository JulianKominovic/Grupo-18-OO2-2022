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
import com.unla.Grupo18.entities.Materia;
import com.unla.Grupo18.helpers.ViewRouteHelper;
import com.unla.Grupo18.services.ICarreraService;
import com.unla.Grupo18.services.IMateriaService;

@Controller
@RequestMapping("/materia")
public class MateriaController {
	
	@Autowired
	@Qualifier("materiaService")
	private IMateriaService  materiaService; 
	
	@Autowired
	@Qualifier("carreraService")
	private ICarreraService carreraService;
	
	@GetMapping("/")
	public String crear (Model model) {
		Materia materia = new Materia();
		List<Carrera> carrera = carreraService.getAll();
		//List<Carrera> carreras = new ArrayList<Carrera>();
		//System.out.println("AQUI    "+carrera);
		model.addAttribute("titulo", "Formulario: Nueva Materia");
		model.addAttribute("materia", materia);
		model.addAttribute("carreras",carrera);
		return ViewRouteHelper.MATERIA_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Materia materia,BindingResult result,Model model,RedirectAttributes attribute) {
		System.out.println("MATERIA=========== "+materia);
		materiaService.save(materia);
		System.out.println("Materia guardada con exito!");
		attribute.addFlashAttribute("success", "Materia agregada con exito");
		return ViewRouteHelper.MATERIA_REDIRECT;
	}
	
	@GetMapping("/lista")
	public String listarMaterias(Model model) {
		List<Materia> listado = materiaService.getAll();
		model.addAttribute("titulo","Lista de materias");
		model.addAttribute("lista",listado);
		return ViewRouteHelper.MATERIA_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id")long id,Model model) {
		Materia materia = materiaService.buscar(id);
		List<Carrera> carrera = carreraService.getAll();
		model.addAttribute("titulo", "Editar materia");
		model.addAttribute("materia", materia);
		model.addAttribute("carreras",carrera);
		return ViewRouteHelper.MATERIA_CREAR;
	}
	 @GetMapping("lista/delete/{id}")
	 public String eliminar(@PathVariable("id")long id,RedirectAttributes attribute) {
		 materiaService.eliminar(id);
		 System.out.println("Materia eliminada con exito");
		 attribute.addFlashAttribute("warning","Materia eliminado con exito");
		 return ViewRouteHelper.MATERIA_REDIRECT_LISTA; 
	 }
	
}
