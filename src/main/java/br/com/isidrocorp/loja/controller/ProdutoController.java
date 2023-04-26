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
import org.springframework.web.bind.annotation.RestController;

import br.com.isidrocorp.loja.dto.MensagemErro;
import br.com.isidrocorp.loja.model.Produto;
import br.com.isidrocorp.loja.services.produto.IProdutoService;

@RestController
public class ProdutoController {
	@Autowired
	private IProdutoService service;
	
	@GetMapping("/produtos")
	public ArrayList<Produto> exibirTodos() {
//		return (ArrayList<Produto>) repo.findAll();
		return service.exibirTodos();
	}
	
	@GetMapping("/produtos/{codigo}")
	public ResponseEntity<?> exibirPeloCodigo(@PathVariable int codigo) {
		Produto p = service.exibirPeloCodigo(codigo);
		if (p != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.status(404).body(new MensagemErro(1564, "Produto não encontrado"));
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<?> adicionarProduto(@RequestBody Produto p) {
		Produto res = service.cadastrarNovoProduto(p);
		if (res != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1565, "Erro ao cadastrar o produto"));
	}
	
	@PutMapping("/produtos")
	public ResponseEntity<?> alterarProduto(@RequestBody Produto p) {
		Produto res = service.alterarProduto(p);
		if (res != null) {
			return ResponseEntity.ok(p);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1566, "Erro ao alterar o produto"));
	}
	
	@DeleteMapping("/produtos/{codigo}")
	public ResponseEntity<?> excluirProduto(@RequestBody int codigo){
		if (service.excluirProduto(codigo)) {
			return ResponseEntity.ok(null);
		}
		return ResponseEntity.status(400).body(new MensagemErro(1567, "Erro ao excluir o produto."));
	}
}
