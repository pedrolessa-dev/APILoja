package br.com.isidrocorp.loja.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.isidrocorp.loja.model.Cliente;

/* Objetivo da interface REPO
 * Ser a interface que oferece as funcionalidades para o famos CRUD
 * 	C - Create / Inserção (insert into)
 *  R - Read   / Recuperação (select)
 *  U - Uptate / Atualização (update)
 *  D - Delete / Remoção (delete)
 *  
 *  No caso, sempre herdamos da CrudRepository (podemos depois pensar na JPARepository)
 *  que oferece uma série de funcionalidades próprias
 * 		- save(objeto) - para inserir/atualizar
 * 		- findAll() - select sem Where
 * 		- findById(id) - select com where da chave primária
 * 		- count() - contador de registros
 * 		- existsById(id) - somente retorna se existe ou não registro com aquela chave
 * 		- deleteById(id) - delete com where da chave primária
 */
public interface ClienteRepo extends CrudRepository<Cliente, Integer> {
	public ArrayList<Cliente> findByOrderByNome();
	public ArrayList<Cliente> findByNomeContaining(String nome);
}
