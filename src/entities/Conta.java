package entities;

import exceptions.ExcecaoNegocios;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaldo;

	public Conta() { // possibilidade de instanciar a classe sem argumento
	}

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaldo) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaldo = limiteSaldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getLimiteSaldo() {
		return limiteSaldo;
	}

	public void setLimiteSaldo(Double limiteSaldo) {
		this.limiteSaldo = limiteSaldo;
	}

	public void deposito(double quantia) {
		saldo += quantia;
	}

	public void saque(double quantia) {
		validaSaque(quantia);
		saldo -= quantia;
	}
	// void - ela lança a exceção se acontecer algo, caso contrário não faz nada.
	private void validaSaque(double quantia) { // bom p/ capturar exceções específicas p/ tratame..
		if (quantia > getLimiteSaldo()) { // limiteSaque
			throw new ExcecaoNegocios("Erro de saque: A quantia excede o limite de saque");
		}
		if (quantia > getSaldo()) {
			throw new ExcecaoNegocios("Erro de saque: Saldo insuficiente");
		}

	}

}
