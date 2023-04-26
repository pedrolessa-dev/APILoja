package br.com.isidrocorp.loja.services.departamento;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.isidrocorp.loja.model.Departamento;
import br.com.isidrocorp.loja.repo.DepartamentoRepo;

@Component
public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	private DepartamentoRepo repo;

	@Override
	public ArrayList<Departamento> exibirTodos() {
		return (ArrayList<Departamento>) repo.findAll();
	}

	@Override
	public Departamento exibirPeloCodigo(int codigo) {
		return repo.findById(codigo).orElse(null);
	}

	@Override
	public Departamento cadastrarNovoDepartamento(Departamento novo) {
		return repo.save(novo);
	}

	@Override
	public Departamento atualizarDepartamento(Departamento d) {
		if (d.getCodDepto() == 0) {
			return null;
		}
		return repo.save(d);
	}

}
