package com.unla.Grupo18.models;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class FinalModel extends NotaPedidoModel {
	private LocalDateTime fechaExamen;
}
