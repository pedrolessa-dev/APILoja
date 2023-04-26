package br.com.isidrocorp.loja.services.cliente;

import java.util.ArrayList;

import br.com.isidrocorp.loja.model.Cliente;

public interface IClienteService {
	public ArrayList<Cliente> exibirTodos();
	public Cliente exibirPeloCodigo(int codigo);
	public ArrayList<Cliente> exibirPeloNome(String palavraChave);
	public Cliente adiconarCliente(Cliente novo);
	public Cliente atualizarCliente(Cliente c);
	public boolean excluirCliente(int codigo);
}
