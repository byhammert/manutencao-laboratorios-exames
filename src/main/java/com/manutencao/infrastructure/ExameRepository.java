package com.manutencao.infrastructure;

import java.util.List;

import com.manutencao.model.Status;
import com.manutencao.model.exame.Exame;

public interface ExameRepository {
	
	void save(Exame exame);
	Exame getBy(String id);
	List<Exame> list();
	List<Exame> listByStatus(Status status);
	void delete(String id);

}
