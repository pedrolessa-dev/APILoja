package br.com.isidrocorp.loja.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.loja.dto.MensagemErro;
import br.com.isidrocorp.loja.model.Cliente;
import br.com.isidrocorp.loja.services.cliente.IClienteService;

/* Objetivo da classe Controller:
 * 	ser a "interface" (classe que está entre o usuário final e a nossa lógica)
 *  para mapear URLs e Métodos HTTP para métodos Java, ou seja
 *  dado um método HTTP (Get, Post, Put, Delete) e uma URL, ele "sabe" qual 
 *  método da classe vai executar e como ele vai retornar isso
 */

@RestController
public class ClienteController {
	@Autowired
	private IClienteService service;

	/*
	 * Neste método vamos acessar o findAll do Repo para retornar todos os clientes
	 * cadastrados no banco
	 */
	@GetMapping("/clientes")
	public ArrayList<Cliente> recuperarTodos() {
		return service.exibirTodos();
	}

	/*
	 * aqui queremos recuperar informações específicas de um Cliente, a partir do
	 * seu código, ou seja, recuperar um único Cliente, passando o código do cliente
	 * na própria URL através de uma variável nomeada pelo {}
	 */
	@GetMapping("/clientes/{codigo}")
	public ResponseEntity<Cliente> recuperarPeloCodigo(@PathVariable int codigo) {
		Cliente c = service.exibirPeloCodigo(codigo);
		if (c != null) {
			return ResponseEntity.ok(c);
		}
		return ResponseEntity.status(404).build();
	}

	/*
	 * vamos criar agora um mecanismo de busca de clientes por nome como isso
	 * funciona? A diferença do /clientes/codigo para este é que aqui vamos ter uma
	 * URL diferente: /clientes/busca e também teremos um parâmetro de URL. Como?
	 * Desta forma:
	 * 
	 * /clientes/busca?palavra=XXXXXX (onde esse XXXX é o termo que queremos
	 * pesquisar)
	 */
	@GetMapping("/clientes/busca")
	public ResponseEntity<?> recuperarPeloNome(@RequestParam(name = "palavra") String palavra) {
		ArrayList<Cliente> lista = service.exibirPeloNome(palavra);
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.status(404).body(new MensagemErro(1235, "Cliente " + palavra + " não encontrado."));
	}

	/*
	 * aqui vamos usar o método POST para ter um endpoint que nos permita cadastrar
	 * um novo cliente. Como faremos isso? Vamos declarar um parâmetro do tipo
	 * cliente no método e para testar precisaremos do
	 * Postman/Insomnia/VSCode+ThunderClient
	 */
	@PostMapping("/clientes")
	public ResponseEntity<?> adicionarNovoo(@RequestBody Cliente c) {
		Cliente res = service.adiconarCliente(c);
		if (res != null) {
			return ResponseEntity.status(201).body(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1236, "Erro ao adicionar o cliente."));
	}

	/*
	 * neste método vamos atualizar um cliente através da operação PUT enviamos
	 * também um objeto do tipo cliente, mas perceba que tanto o POST quanto o PUT
	 * usam o mesmo método: SAVE
	 * 
	 * qual a diferença entre eles? - se enviamos um objeto SEM chave primária -
	 * INSERT - se enviamos um objeto COM chave primária - UPDATE
	 */
	@PutMapping("/clientes")
	public ResponseEntity<?> atualizarDados(@RequestBody Cliente c) {
		Cliente res = service.atualizarCliente(c);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1237, "Erro ao atualizar o cliente."));
	}

	/*
	 * o método DELETEBYID não retorna nem sucesso nem falha. O que podemos fazer
	 * então para apagar um registro de forma segura? Antes de efetivamente
	 * apagá-lo, verificamos se ele existe na base se existir, ok! apagamos, senão
	 * enviamos um 404
	 */
	@DeleteMapping("/clientes/{codigo}")
	public ResponseEntity<?> removerCliente(@PathVariable int codigo) {
		if (service.excluirCliente(codigo)) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.status(404).body(new MensagemErro(1234, "Código " + codigo + " não encotrado."));
	}
}
