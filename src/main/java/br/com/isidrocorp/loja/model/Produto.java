package br.com.isidrocorp.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_produto")
	private int codigo;
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	@Column(name = "descricao", columnDefinition = "TEXT")
	private String descricao;
	@Column(name = "qtd_estoque")
	private int qtdEstoque;
	@Column(name = "preco")
	private double preco;
	@Column(name = "link_foto", length = 255)
	private String linkFoto;
	@ManyToOne // Muitos produtos em 1 departamento
	@JoinColumn(name = "cod_depto") // @JoinColumn é para a chave estrangeira
	private Departamento depto;

	public Produto() {
	}

	public Produto(int codigo, String nome, String descricao, int qtdEstoque, double preco, String linkFoto,
			int codDepto, String nomeDepto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.preco = preco;
		this.linkFoto = linkFoto;
		this.depto = new Departamento();
		this.depto.setCodDepto(codDepto);
		this.depto.setNome(nomeDepto);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

}
