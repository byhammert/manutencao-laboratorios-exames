package com.manutencao.infrastructure;

import java.util.List;

import com.manutencao.model.Status;
import com.manutencao.model.laboratorio.Laboratorio;

public interface LaboratorioRepository {
	
	void save(Laboratorio laboratorio);
	Laboratorio getBy(String id);
	List<Laboratorio> list();
	List<Laboratorio> listByStatus(Status status);
	void delete(String id);

}
