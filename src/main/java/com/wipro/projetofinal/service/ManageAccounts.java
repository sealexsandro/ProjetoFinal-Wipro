package com.wipro.projetofinal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.wipro.projetofinal.entities.Account;
import com.wipro.projetofinal.entities.CreditCard;


public class ManageAccounts {

	private List<Account> accounts = new ArrayList<Account>();

	private Random random = new Random();

	public ManageAccounts() {

	}

	/*
	 * Pela regra que implementamos, N�o se pode adicionar uma nova para um mesmo
	 * CPF, o que faz sentido para n�o criarmos duas ou mais contas correntes para
	 * um mesmo CPF. No entanto, acredito que uma pessoa com o mesmo CPF pode ter
	 * uma conta especial e uma corrente, se for o caso disso, o m�todo abaixo deve
	 * ser modificado.
	 */
	public void addAccount(Account account) {
		if (!ValidationAccount.existNumberCPF(account.getCpf(), this.accounts)) {
			this.accounts.add(account);
		}
	}

	/*
	 * Aten��o !!! Se a l�gica do addCount for modificada, o m�todo abaixo tamb�m
	 * ser�
	 */
	public void removeAccount(String cpf) {

		for (Account account : accounts) {
			if (account.getCpf().equals(cpf)) {
				accounts.remove(account);
				break;
			}
		}
	}

	public String randomNumberCreditCard() {
		String numberCreditCard = "";

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				numberCreditCard += Integer.toString(random.nextInt(10));
			}
			numberCreditCard += " ";
		}
		return numberCreditCard;
	}

	public String randomNumberCVV() {

		String numberCVV = "";

		for (int i = 0; i < 3; i++) {
			numberCVV += Integer.toString(random.nextInt(10));
		}

		return numberCVV;
	}

	public void activateCreditCard(Account account) {
		String numberCard;
		while (true) {
			numberCard = this.randomNumberCreditCard();
			if (!ValidationCreditCard.existNumberCreditCard(numberCard, accounts)) {
				break;
			}
		}

		String numberCVV = this.randomNumberCVV();

		CreditCard creditCard = new CreditCard(numberCard, numberCVV);
		account.assignCreditCard(creditCard);
	}

	public String showAccount(String cpf) {
//		var conta = accounts.indexOf(accounts.stream().filter((account) -> account.getCpf() == cpf));
//		List<Account> conts = (List<Account>) accounts;
//		Account index = conts.(accounts.stream().filter((account) -> account.getCpf() == cpf));

//		if(conts.get(index) == null) {
//			return "Conta Inexistente!";
		// }else {
		// return conts.get(index).toString();
		// }

		for (Account account : accounts) {
			if (account.getCpf().equals(cpf)) {
				return account.toString();
			}
		}

		return "Conta Inexistente!";
	}

	public void showAllAccounts() {

		System.out.println("\tTodas as Contas");
		System.out.println("------------------------------------------");
		for (Account conta : this.accounts) {
			System.out.println(conta.toString());
		}
		System.out.println("-------------------------------------------");

	}
}
