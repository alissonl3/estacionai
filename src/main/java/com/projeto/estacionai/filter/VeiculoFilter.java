package com.projeto.estacionai.filter;


public class VeiculoFilter {
	
	public VeiculoFilter() {}
	
	public VeiculoFilter(String placa, String mensalista) {
		super();
		this.placa = placa;
		this.mensalista = mensalista;
	}
	private String placa;
	private String mensalista;
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMensalista() {
		return mensalista;
	}
	public void setMensalista(String mensalista) {
		this.mensalista = mensalista;
	}
	
	

}
