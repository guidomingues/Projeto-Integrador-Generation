package br.com.ecommerce.meuAtelie.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 3, max =80, message = "Nome deve ser inserido, de 3 até 80 caracteres" )
	private String nomeCompleto;
	
	@NotNull
	@Size(min = 2, max =200, message = "Endereço deve ser inserido, de 2 até 200 caracteres" )
	private String endereco;
	
	@CPF
	@NotNull
	private String cpf;
	
	@NotNull
	@Size(min = 3, max =45, message = "Usúario deve ser inserido, de 3 até 45 caracteres")
	private String nomeUsuario;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	private String senha;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({ "usuario", "produto" })
	private List<VendaModel> vendas = new ArrayList<>();

	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({ "usuario"})
	private List<ProdutoModel> produto = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<VendaModel> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaModel> vendas) {
		this.vendas = vendas;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<VendaModel> getVenda() {
		return vendas;
	}

	public void setVenda(List<VendaModel> vendas) {
		this.vendas = vendas;
	}

	public List<ProdutoModel> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoModel> produto) {
		this.produto = produto;
	}

	
}
