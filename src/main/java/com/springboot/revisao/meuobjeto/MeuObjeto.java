package com.springboot.revisao.meuobjeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class MeuObjeto {
	
	@Id
	@SequenceGenerator(
			name="meuobjeto_sequence",
			sequenceName="meuobjeto_sequence",
			allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "meuobjeto_sequence"
	)
	private Long id;
	private String nome;
	private Integer numero;
	
	public MeuObjeto( ) {
	}	
	
	// OBS: Esse construtor não é para ser utilizado na criação 
	// pois o id é gerado automaticamente
	public MeuObjeto(Long id, String nome, Integer numero) {
		this.id = id;
		this.nome = nome;
		this.numero = numero;
	}
	
	public MeuObjeto( String nome, Integer numero) {
		this.nome = nome;
		this.numero = numero;
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
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	@Override
	public String toString() {
		return "MeuObjeto [id=" + id + ", nome=" + nome + ", numero=" + numero + "]";
	}
	
}

