package com.unla.Grupo18.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unla.Grupo18.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/nota-pedido")
public class NotaPedidoController {

	@GetMapping("")
	public String index() {
		return ViewRouteHelper.NOTA_PEDIDO_LISTA;
	}

	@GetMapping("/create")
	public String create() {
		return ViewRouteHelper.NOTA_PEDIDO_CREAR;
	}

}
