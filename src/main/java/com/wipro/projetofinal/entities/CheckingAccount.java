package com.wipro.projetofinal.entities;

public class CheckingAccount extends Account {

	public CheckingAccount(Double balance, String holder, String cpf) {
		super(balance, holder, cpf);
	}

	/*
	 * O saque só poderá ser realizado se o saldo da conta for maior ou igual ao
	 * valor que se quer retirá.
	 */
	@Override
	public void withdraw(double amount) {
		if (this.balance >= amount) {
			super.withdraw(amount);
		} else {
			System.out.println("Saldo Insuficiente!");
		}
	}
	
	@Override
	public String toString() {
		if (creditCard !=null) {
		return "\n======= Conta Corrente ====== \n" + "Número da conta = " + accountNumber + "\n" + "Saldo = " + balance
				+ "\n" + "Cliente = " + holder + "\n" + "CPF = " + cpf + "\n"+creditCard.toString();
		}else {
		return "\n======= Conta Corrente ====== \n" + "Número da conta = " + accountNumber + "\n" + "Saldo = " + balance
				+ "\n" + "Cliente = " + holder + "\n" + "CPF = " + cpf + "\n"+"Cartão de crédito: vazio";
		}

}
