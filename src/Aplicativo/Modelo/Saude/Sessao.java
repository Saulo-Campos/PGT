package Aplicativo.Modelo.Saude;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import Aplicativo.Modelo.Pessoa.Cliente;

/**
 *
 * @author saulo
 */
@Entity
public class Sessao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String descricao;
	private Cliente cliente;
	private String ativa;

	public Sessao() {
	}

	public Sessao(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Sessao(Long id, String nome, String descricao, String ativa) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.ativa = ativa;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Sessao)) {
			return false;
		}
		Sessao other = (Sessao) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Ddelicia.Modelo.Pessoal.[ id=" + id + " ]";
	}

}
