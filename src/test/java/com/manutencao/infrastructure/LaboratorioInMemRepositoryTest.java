package com.manutencao.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.manutencao.mock.LaboratorioMock;
import com.manutencao.model.Status;
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
	public void deve_alterar_e_obter_lista_de_laboratorios() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		repository.save(laboratorio);
		
		final Laboratorio laboratorioSalvo = repository.getBy(laboratorio.getId());
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo).isEqualTo(laboratorio);
		
		final Laboratorio laboratorioAlterado = Laboratorio.clone(laboratorioSalvo);
		laboratorioAlterado.setStatus(Status.INATIVO);
		
		repository.save(laboratorioAlterado);
		
		final Laboratorio resultado = repository.getBy(laboratorioAlterado.getId());
		
		assertThat(resultado).isNotNull();
		assertThat(resultado).isNotEqualTo(laboratorioSalvo);
		
		final List<Laboratorio> laboratorios = repository.list();
		
		assertThat(laboratorios).isNotNull().isNotEmpty().hasSize(1);
	}
	
	@Test
	public void deve_listar_laboratorios_ativos() {
		final Laboratorio laboratorioAtivo = LaboratorioMock.obterLaboratorio();
		repository.save(laboratorioAtivo);
		
		final Laboratorio laboratorioInativo = LaboratorioMock.obterLaboratorio();
		laboratorioInativo.setStatus(Status.INATIVO);
		repository.save(laboratorioInativo);
		
		final List<Laboratorio> laboratorios = repository.list();
		assertThat(laboratorios).isNotNull().isNotEmpty().hasSize(2);
		
		final List<Laboratorio> laboratoriosAtivos = repository.listByStatus(Status.ATIVO);
		assertThat(laboratoriosAtivos).isNotNull().isNotEmpty().hasSize(1);
	}
	
	@Test
	public void deve_deletar_laboratorio() {
		final Laboratorio laboratorio = LaboratorioMock.obterLaboratorio();
		repository.save(laboratorio);
		
		final Laboratorio laboratorioSalvo = repository.getBy(laboratorio.getId());
		
		assertThat(laboratorioSalvo).isNotNull();
		assertThat(laboratorioSalvo).isEqualTo(laboratorio);
		
		assertThat(repository.list()).isNotNull().isNotEmpty().hasSize(1);
		
		repository.delete(laboratorio.getId());
		
		assertThat(repository.list()).isNotNull().isEmpty();
	}
	
	@Test
	public void deve_retornar_null_quanto_consultar_laboratorio_inexistente() {
		final Laboratorio laboratorioSalvo = repository.getBy("test");
		assertThat(laboratorioSalvo).isNull();
	}

}
