package br.com.isidrocorp.loja.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.loja.dto.MensagemErro;
import br.com.isidrocorp.loja.model.Departamento;
import br.com.isidrocorp.loja.services.departamento.IDepartamentoService;

@RestController
public class DepartamentoController {
	@Autowired
	private IDepartamentoService service;

	@GetMapping("/departamentos")
	public ArrayList<Departamento> exibirTodos() {
		return (ArrayList<Departamento>) service.exibirTodos();
	}

	@GetMapping("/departamentos/{codDepto}")
	public ResponseEntity<?> exibirPeloCodigo(@PathVariable int codDepto) {
		Departamento d = service.exibirPeloCodigo(codDepto);
		if (d != null) {
			return ResponseEntity.ok(d);
		}
		return ResponseEntity.status(404).body(new MensagemErro(1543, "Código " + codDepto + " não encontrado."));
	}

	@PostMapping("/departamentos")
	public ResponseEntity<?> adicionarDepartamento(@RequestBody Departamento d) {
		Departamento res = service.cadastrarNovoDepartamento(d);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1544, "Erro ao criar este departamento."));
	}

	@PutMapping("/departamentos")
	public ResponseEntity<?> atualizarDepartamento(@RequestBody Departamento d) {
		Departamento res = service.atualizarDepartamento(d);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1545, "Erro ao atualizar os dados."));
	}
}
