package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;
import static org.junit.Assert.*;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	AccountService accountService = new AccountServiceImpl(accountRepository);

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test()
	public void checkValidInitialAccount() throws InsufficientInitialBalanceException {
		assertNotNull(accountService.createAccount(1111, 1000));
	}
	@Test()
	public void checkValidAccountNumberException() throws InvalidAccountNumberException {
		assertEquals(accountService.showBalance(4444),4444);
	}

	@Test(expected = InsufficientInitialBalanceException.class)
	public void checkInvalidInitialAccount() throws InsufficientInitialBalanceException {
		accountService.createAccount(1111, 100);
	}

	@Test(expected = InvalidAccountNumberException.class)
	public void checkInvalidAccountNumberException() throws InvalidAccountNumberException {
		accountService.showBalance(0);
	}

}
