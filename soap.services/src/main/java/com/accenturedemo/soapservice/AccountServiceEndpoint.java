package com.accenturedemo.soapservice;

import org.springframework.stereotype.Service;

import com.blog.demo.webservices.accountservice.Account;
import com.blog.demo.webservices.accountservice.AccountDetailsRequest;
import com.blog.demo.webservices.accountservice.AccountDetailsResponse;
import com.blog.demo.webservices.accountservice.EnumAccountStatus;
import com.blog.demo.webservices.accountservice.ObjectFactory;
import com.briansdevblog.accounts.AccountService;

@Service
public class AccountServiceEndpoint implements AccountService {
	
	  @Override
	  public AccountDetailsResponse getAccountDetails(AccountDetailsRequest parameters) {
	    
		ObjectFactory factory = new ObjectFactory();
	   
	    AccountDetailsResponse response = factory.createAccountDetailsResponse();
	    Account account = factory.createAccount();
	    account.setAccountNumber("007");
	    account.setAccountStatus(EnumAccountStatus.ACTIVE);
	    account.setAccountName("Spring 1.5.1.Release");
	    account.setAccountBalance(0909.2);
	    response.setAccountDetails(account);
	    return response;
	  }

}
