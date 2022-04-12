package com.MisterInfo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aparelhos")
public class Aparelhos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private String modeloAparelho;
	private boolean statusAparelho;
	private int numeroOs;
	
	public Aparelhos() {

	}
	
	public Aparelhos(Long id, String modeloAparelho, boolean statusAparelho, int numeroOs) {
		this.id = id;
		this.modeloAparelho = modeloAparelho;
		this.statusAparelho = statusAparelho;
		this.numeroOs = numeroOs;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModeloAparelho() {
		return modeloAparelho;
	}
	public void setModeloAparelho(String modeloAparelho) {
		this.modeloAparelho = modeloAparelho;
	}
	public boolean getStatusAparelho() {
		return statusAparelho;
	}
	public void setStatusAparelho(boolean statusAparelho) {
		this.statusAparelho = statusAparelho;
	}
	public int getNumeroOs() {
		return numeroOs;
	}
	public void setNumeroOs(int numeroOs) {
		this.numeroOs = numeroOs;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
