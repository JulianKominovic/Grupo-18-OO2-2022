package com.unla.Grupo18.controllers;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unla.Grupo18.entities.Perfiles;
import com.unla.Grupo18.helpers.ViewRouteHelper;
import com.unla.Grupo18.services.IPerfilesService;

@Controller
@RequestMapping("/perfiles")
public class PerfilController {
	
	@Autowired
	@Qualifier("perfilesService")
	private IPerfilesService perfilesService;
	
	
	@GetMapping("/")
	public String crear(Model model) {
		Perfiles perfil = new Perfiles();
		model.addAttribute("titulo", "Nuevo Perfil");
		model.addAttribute("perfil", perfil);
		return ViewRouteHelper.PERFIL_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Perfiles perfil,BindingResult result,Model model,RedirectAttributes attribute) {
		if(perfilesService.getByRol(perfil.getRol())!=null) {
			FieldError error = new FieldError("perfil", "rol", "Ya existe un perfil con ese rol");
			result.addError(error);
		}
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Nuevo Perfil");
			model.addAttribute("perfil", perfil);
			System.out.println("Se encontraron Errores en el Perfil!");
			return ViewRouteHelper.PERFIL_REDIRECT_LISTA;
		}
		perfil.setDeshabilitado(true);
		perfilesService.save(perfil);
		System.out.println("Perfil guardado con exito!");
		attribute.addFlashAttribute("success","Perfil agregado con exito");
		return ViewRouteHelper.PERFIL_REDIRECT_LISTA;	
	}
		
	@GetMapping("/lista")
	public String listarClientes(Model model) {
		List<Perfiles> listado = perfilesService.getAll();
		List<Perfiles> perfiles = new ArrayList<Perfiles>();
		listado = perfilesService.getAll();
		for (Perfiles p : listado) {
			if (p.isDeshabilitado() == true) {
				perfiles.add(p);
			}
		}
		model.addAttribute("titulo","Lista de Perfiles");
		model.addAttribute("lista",perfiles);
		return ViewRouteHelper.PERFIL_LISTA;
	}
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id, Model model) {
		Perfiles perfil = perfilesService.buscar(id); 
		model.addAttribute("titulo", "Editar perfil");
		model.addAttribute("perfil", perfil);
		return ViewRouteHelper.PERFIL_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		Perfiles perfil = perfilesService.buscar(id);
		perfil.setDeshabilitado(false);
		perfilesService.save(perfil);
		System.out.println("Perfil eliminado con exito");
		attribute.addFlashAttribute("warning","Perfil eliminado con exito");
		return ViewRouteHelper.PERFIL_REDIRECT_LISTA;
	}
	
}
