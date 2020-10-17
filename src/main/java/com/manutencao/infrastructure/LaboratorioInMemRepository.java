package com.manutencao.infrastructure;

import java.util.LinkedHashMap;
import java.util.Map;

import com.manutencao.model.laboratorio.Laboratorio;

public class LaboratorioInMemRepository implements LaboratorioRepository{
	
	private final Map<String, Laboratorio> map = new LinkedHashMap<>();

	@Override
	public void save(Laboratorio laboratorio) {
		map.put(laboratorio.getId(), laboratorio);
	}

}
