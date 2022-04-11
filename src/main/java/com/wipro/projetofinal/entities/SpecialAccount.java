package com.wipro.projetofinal.entities;

public class SpecialAccount extends Account {

	private Double limit;

	public SpecialAccount(Double balance, String holder, Double limit, String cpf) {
		super(balance, holder, cpf);
		this.limit = limit;
	}

	/*
	 * O saque so pode ser realizado se o saldo da conta somado com o limite for
	 * maior ou igual ao valor que se quer retirar.
	 */
	@Override
	public void withdraw(double amount) {
		if ((this.balance + this.limit) >= amount) {
			super.withdraw(amount);
		} else {
			System.out.println("Saldo Insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		return "SpecialAccount [limit=" + limit + ", AccountNumber=" + getAccountNumber() + ", holder="
				+ getHolder() + ", balance=" + getBalance() + ", cpf=" + getCpf() + "]";
	}
}
