package br.com.isidrocorp.loja.services.produto;

import java.util.ArrayList;

import br.com.isidrocorp.loja.model.Produto;

public interface IProdutoService {
	public ArrayList<Produto> exibirTodos();
	public Produto cadastrarNovoProduto(Produto novo);
	public Produto exibirPeloCodigo(int codigo);
	public Produto alterarProduto(Produto p);
	public boolean excluirProduto(int codigo);
}
