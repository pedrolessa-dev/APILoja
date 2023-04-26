package br.com.isidrocorp.loja.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.loja.model.Departamento;

public interface DepartamentoRepo extends CrudRepository<Departamento, Integer> {
	public ArrayList<Departamento> findByOrderByNome();
	public ArrayList<Departamento> findByNomeContaining(String nome);
}
