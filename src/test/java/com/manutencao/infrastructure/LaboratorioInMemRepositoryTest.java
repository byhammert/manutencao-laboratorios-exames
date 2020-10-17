package com.manutencao.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.laboratorio.Laboratorio;

public class LaboratorioInMemRepositoryTest {
	
	private LaboratorioInMemRepository repository;
	
	@BeforeEach
	public void setup() {
		repository = new LaboratorioInMemRepository();
	}
	
	@Test
	public void deve_cadastrar_e_obter_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		repository.save(laboratorio);
		
		final Laboratorio laboratorioSalvo = repository.getBy(laboratorio.getId());
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo).isEqualTo(laboratorio);
	}
	
	@Test
	public void deve_retornar_null_quanto_consultar_laboratorio_inexistente() {
		final Laboratorio laboratorioSalvo = repository.getBy("test");
		assertThat(laboratorioSalvo).isNull();
	}

}
