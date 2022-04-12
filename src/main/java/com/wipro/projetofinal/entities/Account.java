package sprint1.entities;

import java.util.Calendar;

public abstract class Account {

	protected static Integer count = 1;
	protected Integer accountNumber;
	protected Double balance;
	protected String holder;
	protected String cpf;
	protected Calendar createdDate;
	protected CreditCard creditCard;

	public Account(Double balance, String holder, String cpf) {
		this.accountNumber = count;
		count++;
		this.balance = balance;
		this.holder = holder;
		this.cpf = cpf;
		this.createdDate = Calendar.getInstance();
	}

	public void withdraw(double amount) {   // Método de saque
		this.balance -= amount;
	}

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void deposit(double amount) {
		if (amount > 0.0) {
			this.balance += amount;
		} else {
			System.out.println("Valor Invalido!");
		}
	}

	/*
	  O método abaixo serve para atribuir uma nova instancia de cartão de crédito
	  ao atributo creditCard da classe
	 */
	public void assignCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public String getName() {
		return holder;
	}

	public String getCpf() {
		return cpf;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	

}
