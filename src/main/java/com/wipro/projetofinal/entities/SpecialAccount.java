package com.wipro.projetofinal.entities;

public class SpecialAccount extends Account {

	private Double limit;

	public SpecialAccount(Double balance, String holder, Double limit, String cpf) {
		super(balance, holder, cpf);
		this.limit = limit;
	}

	/*
	 * O saque só poderá ser realizado se o saldo da conta somado com o limite for
	 * maior ou igual ao valor que se quer retirá.
	 */
	@Override
	public void withdraw(double amount) {
		if ((this.balance + this.limit) >= amount) {
			super.withdraw(amount);
		} else {
			System.out.println("Saldo Insuficiente!");
		}
	}
	
	public String toString() {
		return "======= Conta Especial ====== \n"
				+ "Número da conta = " + accountNumber + "\n"
				+ "Saldo = " + balance + "\n" 
				+ "Cliente = " + holder + "\n" 
				+ "CPF =" + cpf + "\n" 
				+ "Limite da conta = " + limit + "\n"; 
	}
}

