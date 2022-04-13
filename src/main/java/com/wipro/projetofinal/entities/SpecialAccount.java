package com.wipro.projetofinal.entities;

public class SpecialAccount extends Account {

	private Double limit;

	public SpecialAccount(Double balance, String holder, Double limit, String cpf) {
		super(balance, holder, cpf);
		this.limit = limit;
	}

	/*
	 * O saque s� poder� ser realizado se o saldo da conta somado com o limite for
	 * maior ou igual ao valor que se quer retir�.
	 */
	@Override
	public void withdraw(double amount) {
		if ((this.balance + this.limit) >= amount) {
			super.withdraw(amount);
		} else {
			System.out.println("Saldo Insuficiente!");
		}
	}
}
