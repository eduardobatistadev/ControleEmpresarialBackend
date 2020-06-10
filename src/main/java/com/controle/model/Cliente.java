package com.controle.model;

import java.awt.List;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private int cep;
	
	private String rua;
	
	private String cidade;
	
	private String baiiro;
	
	private String numeroCasa;
	
	private Date dt_nasc;
	
	private String email;
	
	private String img;
	
	@OneToMany(mappedBy = "cliente", 
	cascade = {CascadeType.PERSIST, 
			   CascadeType.MERGE, 
			   CascadeType.DETACH, 
			   CascadeType.REFRESH})
	private Set<Projeto> projetos;
	
	// método para relacionamento bi-direcional
	public void add(Projeto tempProjeto) {
		if (projetos == null) {
			projetos = (Set<Projeto>) new List();
		}
		projetos.add(tempProjeto);		
		tempProjeto.setCliente(this);
	}
	

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cpf, int cep, String rua, String cidade, String baiiro,
			String numeroCasa, Date dt_nasc, String email, String img, Set<Projeto> projetos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.baiiro = baiiro;
		this.numeroCasa = numeroCasa;
		this.dt_nasc = dt_nasc;
		this.email = email;
		this.img = img;
		this.projetos = projetos;
	}





	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBaiiro() {
		return baiiro;
	}
	public void setBaiiro(String baiiro) {
		this.baiiro = baiiro;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cep=" + cep + ", rua=" + rua + ", cidade="
				+ cidade + ", baiiro=" + baiiro + ", numeroCasa=" + numeroCasa + ", dt_nasc=" + dt_nasc + ", email="
				+ email + ", img=" + img + ", projetos=" + projetos + "]";
	}

	
	
	
	
}