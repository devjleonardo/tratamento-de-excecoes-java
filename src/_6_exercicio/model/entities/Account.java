package _6_exercicio.model.entities;

import _6_exercicio.model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withDraw(double amount) {
		validateWithDraw(amount);
		balance -= amount;
	}
	
	private void validateWithDraw(double amount) {
		if (amount > withdrawLimit) {
			throw new DomainException("Erro de saque: A quantia excede o limite de saque");
		}
		
		if (amount > balance) {
			throw new DomainException("Erro de saque: Saldo insuficiente");
		}
	}
	
}
