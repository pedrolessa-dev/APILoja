package br.com.isidrocorp.loja.services.cliente;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.loja.model.Cliente;
import br.com.isidrocorp.loja.repo.ClienteRepo;

@Component
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepo repo;

	@Override
	public ArrayList<Cliente> exibirTodos() {
		return (ArrayList<Cliente>) repo.findByOrderByNome();
	}

	@Override
	public Cliente exibirPeloCodigo(int codigo) {
		return repo.findById(codigo).orElse(null);
	}

	@Override
	public ArrayList<Cliente> exibirPeloNome(String palavraChave) {
		return (ArrayList<Cliente>) repo.findByNomeContaining(palavraChave);
	}

	@Override
	public Cliente adiconarCliente(Cliente novo) {
		return repo.save(novo);
	}

	@Override
	public Cliente atualizarCliente(Cliente c) {
		if (c.getCodigo() == 0) {
			return null;
		}
		return repo.save(c);
	}

	@Override
	public boolean excluirCliente(int codigo) {
		if (repo.existsById(codigo)) {
			repo.deleteById(codigo);
			return true;
		}
		return false;
	}
}
