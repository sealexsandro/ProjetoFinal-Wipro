package sprint1.service;

import java.util.List;

import sprint1.entities.Account;

public class ValidationCreditCard {

	public static boolean existNumberCreditCard(String number, List<Account> accounts) {

		for (Account account : accounts) {
			if(account.getCreditCard() != null) {
				if (account.getCreditCard().getCardNumber().equals(number)) {
					return true;
				}				
			}
		}
		return false;
	}

}
