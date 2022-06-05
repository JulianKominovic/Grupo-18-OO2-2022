package com.unla.Grupo18.models.requests;

public enum FrecuenciaFechasEnum {

	UNA_SEMANA_AL_MES("1DE4"), DOS_SEMANAS_AL_MES("2DE4"), TODAS_LAS_SEMANAS("4DE4");

	private String value;

	private FrecuenciaFechasEnum(String value) {
		this.value = value;
	}

	public String getFrecuenciaFechas() {
		return value;
	}

}