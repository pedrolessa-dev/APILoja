package br.com.isidrocorp.loja.services.departamento;

import java.util.ArrayList;

import br.com.isidrocorp.loja.model.Departamento;

public interface IDepartamentoService {
	public ArrayList<Departamento> exibirTodos();
	public Departamento exibirPeloCodigo(int codigo);
	public Departamento cadastrarNovoDepartamento(Departamento novo);
	public Departamento atualizarDepartamento(Departamento d);
}
