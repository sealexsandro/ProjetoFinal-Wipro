package com.wipro.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.projetofinal.entities.CheckingAccount;
import com.wipro.projetofinal.service.ManageAccounts;


@SpringBootApplication
public class ProjetofinalWiproApplication {
	
	public static void implementacaoManual() {
		/*
		CheckingAccount contaCorrente1 = new CheckingAccount(0.0, "Mario", "529.982.247-25");
		CheckingAccount contaCorrente2 = new CheckingAccount(0.0, "Joao", "529.982.247-27");
		CheckingAccount contaCorrente3 = new CheckingAccount(0.0, "Ana Beatriz", "529.982.247-28");
		//	CheckingAccount contaCorrente3 = new CheckingAccount(0.0, "Maria", "529.982.247-25");
		//	CheckingAccount contaCorrente4 = new CheckingAccount(0.0, "Neves", "529.982.247-25");
		
		SpecialAccount contaEspecial1 = new SpecialAccount(0.0,"Freddy",300.00,"529.982.247-29");

		ManageAccounts gerenciaContas = new ManageAccounts();

		gerenciaContas.addAccount(contaCorrente1);
		gerenciaContas.addAccount(contaCorrente2);
		gerenciaContas.addAccount(contaCorrente3);
		gerenciaContas.addAccount(contaEspecial1);

		// Imprimir todas as contas
		gerenciaContas.showAllAccounts();

		// Buscar conta por cpf
		System.out.println(gerenciaContas.showAccount("529.982.247-278"));

		// remover uma conta
		gerenciaContas.removeAccount("529.982.247-27");
//
		// Imprimir todas as contas
		gerenciaContas.showAllAccounts();

		// Deve retornar null, porque a conta não "tem" um cartão de credito instanciado
		System.out.println("Antes de adicionar creditCard: " + contaCorrente1.getCreditCard());

		gerenciaContas.activateCreditCard(contaCorrente1);

		System.out.println("Depois de adicionar creditCard: " + contaCorrente1.getCreditCard());
		
		
		/*teste conta especial
		contaEspecial1.deposit(200);
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		
		contaEspecial1.withdraw(100);
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		
		contaEspecial1.withdraw(100);
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		
		contaEspecial1.withdraw(100);
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		
		contaEspecial1.withdraw(200);
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		
		contaEspecial1.withdraw(15);
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		*/
		
		/*teste conta corrente
		contaCorrente1.deposit(200);
		System.out.println(gerenciaContas.showAccount("529.982.247-25"));
		
		contaCorrente1.withdraw(100);		
		System.out.println(gerenciaContas.showAccount("529.982.247-25"));
		
		contaCorrente1.withdraw(100);		
		System.out.println(gerenciaContas.showAccount("529.982.247-25"));
		
		contaCorrente1.withdraw(100);		
		System.out.println(gerenciaContas.showAccount("529.982.247-25"));
		*/
		
		/*try {
		    contaCorrente1.deposit(-1);
		    
			contaCorrente1.withdraw(10);
		}catch(ErrorTypes e) {
			System.err.println(e.getMessage());
		}
		System.out.println(gerenciaContas.showAccount("529.982.247-25"));
		*/
		
		/* saques
		contaCorrente1.withdraw(10);
		
		contaEspecial1.withdraw(300);
		
		System.out.println(gerenciaContas.showAccount("529.982.247-29"));
		
		contaEspecial1.withdraw(10);
		
		*/
	}

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
		System.out.println("[4] Sair");
		System.out.println("************************************************");
		System.out.println("Escolha uma opção:");
		Scanner leia = new Scanner(System.in);
		op = leia.nextInt();
		switch(op) {
		case 1:
			System.out.println("Quanto deseja depositar?");
			valor = leia.nextDouble();
			a.deposit(valor);
			break;
		case 2:
			System.out.println("Quanto deseja sacar?");
			valor = leia.nextDouble();
			a.withdraw(valor);
			break;
		case 3:
			ma.activateCreditCard(a);
			System.out.println("Cartão Ativado com sucesso");
			break;
		case 4:
			return "voltando para o menu principal";
		
		default:
			System.err.println("Escolha uma opção válida");
			break;
		}
		
		}while(op != 4);
		return "voltando para o menu principal";
	}
	
	public static void showMenu() {

		System.out.println("************************************************");
		System.out.println("\t\t Wipro Banking\n \t\t Menu de opções \t\t\t");
		System.out.println("************************************************");
		System.out.println("[1] Criar conta");
		System.out.println("[2] Consultar uma conta");
		System.out.println("[3] Consultar todas as contas");
		System.out.println("[4] Sair");
		System.out.println("************************************************");
		System.out.println("Escolha uma opção:");
	}

	public static void main(String[] args) {
		// Não apaguem esta linha de baixo
//		SpringApplication.run(ProjetofinalWiproApplication.class, args);

		
		ManageAccounts ma = new ManageAccounts();
		
		Scanner leia = new Scanner(System.in);
		String nome,cpf;
		int op,tipoConta,numberAccount;
		char decision = ' ';
		
		do {
			
			showMenu();			
			op = leia.nextInt();
			
			switch(op) {
				
			case 1:
				System.out.println("***************************************");
				System.out.println("Escolha o tipo de conta: [1] Conta corrente [2] Conta especial");
				tipoConta = leia.nextInt();
				
				
				while(tipoConta != 1 && tipoConta != 2) {
					System.out.println("Escolha o tipo de conta: [1] Conta corrente [2] Conta especial");
					tipoConta = leia.nextInt();
				}		
				
				System.out.println("Digite o nome do cliente:");
				leia.nextLine();
				nome = leia.nextLine();				
				System.out.println("Digite o cpf do cliente:");
				cpf = leia.next();
				
				while(!ValidationAccount.isCPF(cpf)) {					
					System.out.println("O mer irmão, presta atenção! Digite um cpf válido:");
					cpf = leia.next();
					//666.88.996-7-false
					//888.888.888-67-true
				}				
				
				if(tipoConta == 1) {					
					CheckingAccount cc = new CheckingAccount(0.0,nome,cpf);
					
					System.out.println("\n"+cc.toString()+"\n");
					
				
					System.out.println("Confirma os dados? [S][s]sim [N][n]não");
					
					decision =  leia.next().charAt(0);
					
					if(decision == 'S' || decision == 's') {
						System.out.print("");
						if(ma.addAccount(cc) == "Adicionado com sucesso !!") {
							System.out.print("Conta corrente foi adicionada com sucesso !!\n"); 
							menuOperacoes(cc,ma);
						}
						else if (ma.addAccount(cc) == "já existe uma conta com esse CPF.") {
							System.out.print("Já existe uma conta corrente com esse CPF, favor informar outro.\n");
							cc = null;
						}
					}else {
						System.out.println("Conta não criada");
						cc = null;
					}	
					
				}else if(tipoConta == 2) {
					SpecialAccount sa = new SpecialAccount(0.0,nome,300.0,cpf);
					System.out.println("\n"+sa.toString()+"\n");
					
					System.out.println("Confirma os dados? [S][s]sim [N][n]não");
					decision =  leia.next().charAt(0);
					if(decision == 'S' || decision == 's') {
						if(ma.addAccount(sa) == "Adicionado com sucesso !!") {
							System.out.print("Conta especial foi adicionada com sucesso !!\n"); 
							menuOperacoes(sa,ma);
						}
						else if (ma.addAccount(sa) == "já existe uma conta com esse CPF.") {
							System.out.print("Já existe uma conta especial com esse CPF, favor informar outro.\n");
							sa = null;
						}
					}else {
						System.out.println("Conta não criada");
						sa = null;
					}	
				}				
				break;
				
			case 2:
				System.out.println("Digite o número da conta:");
				numberAccount = leia.nextInt();
				System.out.println(""+ma.showAccount(numberAccount)+"");
				break;
				
			case 3:
				ma.showAllAccounts();
				break;	
				
			case 4:	
				break;
				
			default:
				System.err.println("Escolha uma opção seu jeca!");
				break;
			}			
			
		}while(op != 4);
	}

}
