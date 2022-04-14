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

	public void addAccount(Account account) {

		if (!ValidationAccount.existNumberCPF(account.getCpf(), this.accounts)) {
			this.accounts.add(account);
			System.out.println("Adicionado com sucesso !!");
		} else {
			if (ValidationAccount.getNumberOfAccounts(account.getCpf(), this.accounts) < 2) {
				String className = account.getClass().getName();
				if (!ValidationAccount.existClassNameAccount(className, this.accounts)) {
					this.accounts.add(account);
					System.out.println("Adicionado com sucesso !!");
				} else {
					System.out.println("j� existe uma conta com esse CPF.");
				}

			} else {
				System.out.println("j� existe uma conta com esse CPF.");
			}

		}
	}

	public void removeAccount(Integer numberAccount) {

		for (Account account : accounts) {
			if (account.getAccountNumber() == numberAccount) {
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
