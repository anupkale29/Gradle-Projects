package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		// TODO Auto-generated method stub
		Account account=null;
		if(amount<500){
			throw new InsufficientInitialBalanceException();
		}else{
			account=new Account();
			account.setAccountNumber(accountNumber);
			account.setAmount(amount);
		}
		return account;
	}

	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		if(accountNumber==0){
			throw new InvalidAccountNumberException();
		}
		return accountNumber;
	}

}
