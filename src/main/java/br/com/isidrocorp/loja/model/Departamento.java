package br.com.isidrocorp.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_depto")
	private int codDepto;
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;

	public Departamento() {
	}

	public int getCodDepto() {
		return codDepto;
	}

	public void setCodDepto(int codDepto) {
		this.codDepto = codDepto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
