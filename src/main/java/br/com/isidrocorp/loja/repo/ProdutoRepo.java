package br.com.isidrocorp.loja.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.loja.model.Produto;

public interface ProdutoRepo extends CrudRepository<Produto, Integer> {
	
	@Query(" SELECT new br.com.isidrocorp.loja.model.Produto("
			 + "    p.codigo, p.nome, p.descricao, p.qtdEstoque,"
			 + "    p.preco, p.linkFoto, d.codDepto, d.nome) "
			 + " FROM Produto p INNER JOIN Departamento d "
			 + "    ON p.depto.codDepto = d.codDepto")
		public ArrayList<Produto> recuperarTudoCompleto();
}
