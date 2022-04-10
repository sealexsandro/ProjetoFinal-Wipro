package com.wipro.projetofinal.entities;

import java.util.Calendar;

import com.wipro.projetofinal.entities.enums.CardLevel;


public class CreditCard {

	private String cardNumber;
	private Double limit;
	private String cvv;
//	private Date expirationDate;
	private Calendar expirationDate;
	private String flag;
	private CardLevel cardLevel;

	private Boolean ativo;

	public CreditCard() {
		this.ativo = false;
	}

	public CreditCard(String cardNumber, String cvv) {
		this.ativo = true;
		this.cardNumber = cardNumber;
		this.limit = 300.0;
		this.cvv = cvv;
		this.expirationDate = Calendar.getInstance();
		this.expirationDate.add(Calendar.YEAR, 6); // A validade ser� contada da data atual somado com mais 6 anos
		this.flag = "MASTERCARD";
		this.cardLevel = CardLevel.BRONZE;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Double getLimit() {
		return limit;
	}

	public String getCvv() {
		return cvv;
	}

	public Calendar getExpirationDate() {
		return expirationDate;
	}

	public String getFlag() {
		return flag;
	}

	public CardLevel getCardLevel() {
		return cardLevel;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	@Override
	public String toString() {
		int mes = this.expirationDate.get(Calendar.MONTH) + 1;
		int ano = this.expirationDate.get(Calendar.YEAR) + 1;

		String expirationDate = "" + mes + "/" + ano;

		return "CreditCard [cardNumber=" + cardNumber + ", limit=" + limit + ", cvv=" + cvv + ", expirationDate= " + expirationDate
				+ ", flag=" + flag + ", cardLevel=" + cardLevel + ", ativo=" + ativo + "]";
	}

}
