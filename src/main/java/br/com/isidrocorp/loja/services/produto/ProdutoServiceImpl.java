package br.com.isidrocorp.loja.services.produto;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.loja.model.Produto;
import br.com.isidrocorp.loja.repo.ProdutoRepo;

@Component
public class ProdutoServiceImpl implements IProdutoService {
	@Autowired
	private ProdutoRepo repo;

	@Override
	public ArrayList<Produto> exibirTodos() {
		return (ArrayList<Produto>) repo.findAll();
	}

	@Override
	public Produto cadastrarNovoProduto(Produto novo) {
		return repo.save(novo);
	}

	@Override
	public Produto exibirPeloCodigo(int codigo) {
		return repo.findById(codigo).orElse(null);
	}

	@Override
	public Produto alterarProduto(Produto p) {
		if (p.getCodigo() == 0) {
			return null;
		}
		return repo.save(p);
	}

	@Override
	public boolean excluirProduto(int codigo) {
		if (repo.existsById(codigo)) {
			repo.deleteById(codigo);
			return true;
		}
		return false;
	}
}
