
package com.manutencao.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.manutencao.event.RecursoCriadoEvent;
import com.manutencao.model.laboratorio.CadastroLaboratorioRequest;
import com.manutencao.model.laboratorio.Laboratorio;
import com.manutencao.model.laboratorio.LaboratorioTranslator;
import com.manutencao.service.laboratorio.AtualizaLaboratorioService;
import com.manutencao.service.laboratorio.CadastroLaboratorioService;
import com.manutencao.service.laboratorio.ConsultaLaboratorioService;
import com.manutencao.service.laboratorio.DeletaLaboratorioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/laboratorio")
@Api(tags = {"laboratorio"})
public class LaboratorioController {
	
	private ConsultaLaboratorioService consultaLaboratorioService;
	private CadastroLaboratorioService salvaLaboratorioService;
	private AtualizaLaboratorioService atualizaLaboratorioService;
	private DeletaLaboratorioService deletaLaboratorioService;
	private ApplicationEventPublisher publisher;
	
	@Autowired
	public LaboratorioController(ConsultaLaboratorioService consultaLaboratorioService, 
							CadastroLaboratorioService salvaLaboratorioService,
							AtualizaLaboratorioService atualizaLaboratorioService,
							DeletaLaboratorioService deletaLaboratorioService,
							ApplicationEventPublisher publisher) {
		this.consultaLaboratorioService = consultaLaboratorioService;
		this.salvaLaboratorioService = salvaLaboratorioService;
		this.atualizaLaboratorioService = atualizaLaboratorioService;
		this.deletaLaboratorioService = deletaLaboratorioService;
		this.publisher = publisher;
	}
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de laboratório ativos")
	public ResponseEntity<List<Laboratorio>> listarLaboratoriosAtivos() {
		return ResponseEntity.ok(consultaLaboratorioService.obterLaboratoriosAtivos());
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo laboratório")
	public ResponseEntity<Laboratorio> cadastrar(@RequestBody CadastroLaboratorioRequest request, HttpServletResponse response) {
		Laboratorio laboratorio = LaboratorioTranslator.translate(request);
		Laboratorio laboratorioSalvo = salvaLaboratorioService.salvar(laboratorio);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, laboratorioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(laboratorioSalvo);
	}
	
	@PutMapping()
	@ApiOperation(value = "Atualiza um laboratório existente")
	public ResponseEntity<Laboratorio> atualizar(@RequestBody Laboratorio laboratorio) {
		try {
			Laboratorio laboratorioSalvo = atualizaLaboratorioService.atualizar(laboratorio);
			return ResponseEntity.ok(laboratorioSalvo);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Remove um laboratório ativo.")
	public void remover(@PathVariable String id) {
		deletaLaboratorioService.remover(id);
	}
}
