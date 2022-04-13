package com.wipro.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wipro.projetofinal.entities.CheckingAccount;
import com.wipro.projetofinal.service.ManageAccounts;

@SpringBootApplication
public class ProjetofinalWiproApplication {

	public static void main(String[] args) {
		// Não apaguem esta linha de baixo
//		SpringApplication.run(ProjetofinalWiproApplication.class, args);

		CheckingAccount contaCorrente1 = new CheckingAccount(0.0, "Mario", "529.982.247-25");
		CheckingAccount contaCorrente2 = new CheckingAccount(0.0, "Joao", "529.982.247-27");
		CheckingAccount contaCorrente3 = new CheckingAccount(0.0, "Ana Beatriz", "529.982.247-28");
		// CheckingAccount contaCorrente3 = new CheckingAccount(0.0, "Maria",
		// "529.982.247-25");
		// CheckingAccount contaCorrente4 = new CheckingAccount(0.0, "Neves",
		// "529.982.247-25");

		ManageAccounts gerenciaContas = new ManageAccounts();

		gerenciaContas.addAccount(contaCorrente1);
		gerenciaContas.addAccount(contaCorrente2);
		gerenciaContas.addAccount(contaCorrente3);

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

	}

}
