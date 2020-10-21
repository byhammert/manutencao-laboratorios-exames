
package com.manutencao.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.manutencao.exceptionhandler.NotFoundExcetion;
import com.manutencao.model.exame.AlteraExameRequest;
import com.manutencao.model.exame.CadastroExameRequest;
import com.manutencao.model.exame.Exame;
import com.manutencao.model.exame.ExameTranslator;
import com.manutencao.service.exame.AtualizaExameService;
import com.manutencao.service.exame.CadastroExameService;
import com.manutencao.service.exame.ConsultaExameService;
import com.manutencao.service.exame.DeletaExameService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/exame")
@Api(tags = {"api/exame"})
public class ExameController {
	
	private ConsultaExameService consultaExameService;
	private CadastroExameService salvaExameService;
	private AtualizaExameService atualizaExameService;
	private DeletaExameService deletaExameService;
	
	@Autowired
	public ExameController(ConsultaExameService consultaExameService, 
							CadastroExameService salvaExameService,
							AtualizaExameService atualizaExameService,
							DeletaExameService deletaExameService) {
		this.consultaExameService = consultaExameService;
		this.salvaExameService = salvaExameService;
		this.atualizaExameService = atualizaExameService;
		this.deletaExameService = deletaExameService;
	}
	
	@GetMapping()
	@ApiOperation(value = "Retorna a lista de exames ativos")
	public ResponseEntity<List<Exame>> listarExamesAtivos() {
		return ResponseEntity.ok(consultaExameService.obterExamesAtivos());
	}
	
	@PostMapping
	@ApiOperation(value = "Cadastra um novo exame")
	public ResponseEntity<Exame> cadastrar(@RequestBody CadastroExameRequest request, HttpServletResponse response) {
		request.validarCampos();
		Exame exame = ExameTranslator.translate(request);
		Exame exameSalvo = salvaExameService.salvar(exame);
		return ResponseEntity.status(HttpStatus.CREATED).body(exameSalvo);
	}
	
	@PutMapping()
	@ApiOperation(value = "Atualiza um exame existente")
	public ResponseEntity<Exame> atualizar(@RequestBody AlteraExameRequest request) {
		request.validarCampos();
		try {
			Exame exame = ExameTranslator.translate(request);
			Exame exameSalvo = atualizaExameService.atualizar(exame);
			return ResponseEntity.ok(exameSalvo);
		} catch (NotFoundExcetion e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value = "Remove um exame ativo.")
	public void remover(@PathVariable String id) {
		deletaExameService.remover(id);
	}
}
