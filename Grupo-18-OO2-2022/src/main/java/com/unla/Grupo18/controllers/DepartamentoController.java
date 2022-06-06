package com.unla.Grupo18.controllers;

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

import com.unla.Grupo18.entities.Departamento;
import com.unla.Grupo18.helpers.ViewRouteHelper;
import com.unla.Grupo18.services.IDepartamentoService;


@Controller
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	@Qualifier("departamentoService")
	private IDepartamentoService departamentoService;
	
	@GetMapping("/")
	public String crear(Model model) {
		Departamento departamento = new Departamento();
		model.addAttribute("titulo", "Formulario: Nuevo Departamento");
		model.addAttribute("departamento", departamento);

		return ViewRouteHelper.DEPARTAMENTO_CREAR;
	}
	
	@PostMapping("/")
	public String guardar(@Valid @ModelAttribute Departamento departamento,BindingResult result,Model model,RedirectAttributes attribute) {
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Formulario: Nuevo Departamento");
			model.addAttribute("departamento", departamento);
			System.out.println("Se encontraron Errores en el formulario!");
			return ViewRouteHelper.DEPARTAMENTO_CREAR;
			}
		departamentoService.save(departamento);
		System.out.println("Departamento guardado con exito!");
		attribute.addFlashAttribute("success","Departamento agregado con exito");
		return ViewRouteHelper.DEPARTAMENTO_REDIRECT;	
	}
	
	@GetMapping("/lista")
	public String listarDepartamentos(Model model) {
		List<Departamento> listado = departamentoService.getAll();
	    model.addAttribute("titulo", "Lista de Departamentos");
		model.addAttribute("lista", listado);
		return ViewRouteHelper.DEPARTAMENTO_LISTA;
	}
	
	
	@GetMapping("lista/edit/{id}")
	public String editar(@PathVariable("id") long id, Model model) {
		Departamento departamento = departamentoService.buscar(id); 
		model.addAttribute("titulo", "Editar departamento");
		model.addAttribute("departamento", departamento);
		return ViewRouteHelper.DEPARTAMENTO_CREAR;
	}
	
	@GetMapping("lista/delete/{id}")
	public String eliminar(@PathVariable("id") long id,RedirectAttributes attribute) {
		departamentoService.eliminar(id);
		System.out.println("Departamento eliminado con exito");
		attribute.addFlashAttribute("warning","Departamento eliminado con exito");
		return ViewRouteHelper.DEPARTAMENTO_REDIRECT_LISTA;
	}
	
	
}
