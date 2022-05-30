package com.unla.Grupo18.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo18.entities.Aula;
import com.unla.Grupo18.entities.Edificio;
import com.unla.Grupo18.entities.Espacio;
import com.unla.Grupo18.entities.Laboratorio;
import com.unla.Grupo18.entities.Tradicional;
import com.unla.Grupo18.entities.Usuario;
import com.unla.Grupo18.helpers.ViewRouteHelper;
import com.unla.Grupo18.services.IEspacioService;
import com.unla.Grupo18.services.IUsuarioService;

@Controller
@RequestMapping("/espacios")
public class EspacioController {
	@Autowired
	//@Qualifier("espacioService")
	private IEspacioService espacioService;
	
	@GetMapping("/lista")
	public String listarEspacios(Model model) {
		List<Espacio> listado = espacioService.getAll();
		List<Espacio> espaciosTradicional = new ArrayList<Espacio>();
		List<Espacio> espaciosLaboratorio = new ArrayList<Espacio>();
		for (Espacio e : listado) {
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
}
