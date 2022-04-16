package com.wipro.projetofinal;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.projetofinal.entities.Account;
import com.wipro.projetofinal.entities.CheckingAccount;
import com.wipro.projetofinal.entities.SpecialAccount;
import com.wipro.projetofinal.service.ManageAccounts;
import com.wipro.projetofinal.service.ValidationAccount;

@SpringBootApplication
public class ProjetofinalWiproApplication {


	public static String menuOperacoes(Account a, ManageAccounts ma) {
		int op;
		Double valor;

		do {
			System.out.println("************************************************");
			System.out.println("\t\t Wipro Banking\n \t\t Menu de opções \t\t\t");
			System.out.println("************************************************");
			System.out.println("[1] Depositar");
			System.out.println("[2] Sacar");
			System.out.println("[3] Habilitar cartão de crédito");
			System.out.println("[4] Mostrar saldo");
			System.out.println("[5] Sair");
			System.out.println("************************************************");
			System.out.println("Escolha uma opção:");
			Scanner leia = new Scanner(System.in);
			op = leia.nextInt();
			switch (op) {
			case 1:
				System.out.println("Quanto deseja depositar?");
				valor = leia.nextDouble();
				a.deposit(valor);
				System.out.println("Seu saldo é de :  R$" + a.getBalance());

				break;
			case 2:
				System.out.println("Quanto deseja sacar?");
				valor = leia.nextDouble();
				a.withdraw(valor);
				System.out.println("Seu saldo é de : R$" + a.getBalance());
				break;
			case 3:
				ma.activateCreditCard(a);
				System.out.println("Cartão Ativado com sucesso");
				break;

			case 4:
				System.out.println("Seu saldo é de :  R$" + a.getBalance());
				break;

			case 5:
				return "voltando para o menu principal";

			default:
				System.err.println("Escolha uma opção válida");
				break;
			}

		} while (op != 5);
		return "voltando para o menu principal";
	}

	public static void showMenu() {

		System.out.println("************************************************");
		System.out.println("\t\t Wipro Banking\n \t\t Menu de opções \t\t\t");
		System.out.println("************************************************");
		System.out.println("[1] Criar conta");
		System.out.println("[2] Consultar uma conta");
		System.out.println("[3] Consultar todas as contas");
		System.out.println("[4] Remover uma conta");
		System.out.println("[5] Sair");
		System.out.println("************************************************");
		System.out.println("Escolha uma opção:");
	}

	public static void main(String[] args) {
		// Não apaguem esta linha de baixo
//		SpringApplication.run(ProjetofinalWiproApplication.class, args);

		ManageAccounts ma = new ManageAccounts();

		Scanner leia = new Scanner(System.in);
		String nome, cpf;
		int op, tipoConta, numberAccount;
		char decision = ' ';

		do {

			showMenu();
			op = leia.nextInt();

			switch (op) {

			case 1:
				System.out.println("***************************************");
				System.out.println("Escolha o tipo de conta: [1] Conta corrente [2] Conta especial");
				tipoConta = leia.nextInt();

				while (tipoConta != 1 && tipoConta != 2) {
					System.out.println("Escolha o tipo de conta: [1] Conta corrente [2] Conta especial");
					tipoConta = leia.nextInt();
				}

				System.out.println("Digite o nome do cliente:");
				leia.nextLine();
				nome = leia.nextLine();
				System.out.println("Digite o cpf do cliente:");
				cpf = leia.next();

				while (!ValidationAccount.isCPF(cpf)) {
					System.out.println("CPF inválido. Favor digite um cpf válido:");
					cpf = leia.next();
					// 666.88.996-7-false
					// 888.888.888-67-true
				}

				if (tipoConta == 1) {
					CheckingAccount cc = new CheckingAccount(0.0, nome, cpf);

					System.out.println("\n" + cc.toString() + "\n");

					System.out.println("Confirma os dados? [S][s]sim [N][n]não");

					decision = leia.next().charAt(0);

					if (decision == 'S' || decision == 's') {
						if (ma.addAccount(cc) == "Adicionado com sucesso !!") {
							System.out.print("Conta corrente foi adicionada com sucesso !!\n");
							menuOperacoes(cc, ma);
						} else if (ma.addAccount(cc) == "já existe uma conta com esse CPF.") {
							System.out.print("Já existe uma conta corrente com esse CPF, favor informar outro.\n");
							cc = null;
						}
					} else {
						System.out.println("Conta não criada");
						cc = null;
					}

				} else if (tipoConta == 2) {
					SpecialAccount sa = new SpecialAccount(0.0, nome, 300.0, cpf);
					System.out.println("\n" + sa.toString() + "\n");

					System.out.println("Confirma os dados? [S][s]sim [N][n]não");
					decision = leia.next().charAt(0);
					if (decision == 'S' || decision == 's') {
						if (ma.addAccount(sa) == "Adicionado com sucesso !!") {
							System.out.print("Conta especial foi adicionada com sucesso !!\n");
							menuOperacoes(sa, ma);
						} else if (ma.addAccount(sa) == "já existe uma conta com esse CPF.") {
							System.out.print("Já existe uma conta especial com esse CPF, favor informar outro.\n");
							sa = null;
						}
					} else {
						System.out.println("Conta não criada");
						sa = null;
					}
				}
				break;

			case 2:
				System.out.println("Digite o número da conta:");
				numberAccount = leia.nextInt();
				System.out.println("" + ma.showAccount(numberAccount) + "");

				break;

			case 3:
				ma.showAllAccounts();
				break;

			case 4:
				System.out.println("Digite o número da conta:");
				numberAccount = leia.nextInt();
				System.out.println("" + ma.removeAccount(numberAccount) + "");

				break;

			case 5:
				System.out.println("Banco Fechado !");
				break;

			default:
				System.err.println("Favor escolha uma das opções válidas.");
				break;
			}

		} while (op != 5);
	}
}
