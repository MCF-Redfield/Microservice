package com.redfield.model;

import java.util.Date;

public class User
{
	private Integer id;
	private String nome;
	private Date dataNasc;
	
	public User(Integer id, String nome, Date dataNasc) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNasc = dataNasc;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	
}
