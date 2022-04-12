package sprint1.entities;

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
	

	public String toString() {
		return "======= Conta Corrente ====== \n"
				+ "Número da conta = " + accountNumber + "\n"
				+ "Saldo = " + balance + "\n" 
				+ "Cliente = " + holder + "\n" 
				+ "CPF = " + cpf  + "\n" ;
	}

}
