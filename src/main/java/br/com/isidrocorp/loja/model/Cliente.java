package br.com.isidrocorp.loja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/* Objetivo de uma classe model:
 * mapear para um objeto java a estrutura da tabela do banco de dados
 * 
 * nossa classe java terá os atributos correspondentes às colunas de uma tabela e
 * precisamos fazer essa "configuração" de qual atributo corresponde a qual coluna
 * 
 * como fazemos isso? Através das anotaçõe específicas
 * 
 * @Entity e @Table para esepecificarmos classe <--> tabela
 * @Id, @GeneratedValue e @Column para especificarmos atributos <--> colunas
 */
@Entity // a classe cliente é mapeável para o banco
@Table(name = "cliente") // aqui eu faço o mapeamento para o nome da tabela
public class Cliente {
	@Id // mostro que o atributo codigo é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // digo que codigo é auto-increment
	@Column(name = "codigo") // especifico as definições das colunas
	private int codigo;
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	@Column(name = "email", nullable = false, length = 200, unique = true)
	private String email;
	@Column(name = "whatsapp", nullable = false, length = 20, unique = true)
	private String whatsapp;
	@Column(name = "endereco", length = 100)
	private String endereco;
	@Column(name = "numero")
	private int numero;
	@Column(name = "complemento", length = 50)
	private String complemento;
	@Column(name = "cidade", length = 50)
	private String cidade;
	@Column(name = "bairro", length = 50)
	private String bairro;
	@Column(name = "cep", length = 10)
	private String cep;

	public Cliente() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
