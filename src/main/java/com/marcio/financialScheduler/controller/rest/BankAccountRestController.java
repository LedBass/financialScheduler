/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.financialScheduler.model.BankAccount;
import com.marcio.financialScheduler.model.User;
import com.marcio.financialScheduler.service.BankAccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author marcio
 *
 */
@RestController
@RequestMapping("/api/bank-accounts")
@Api(value="Financial Scheduller App API", description="Operations for managing bank accounts in the app."
		+ " You can see a list of existing bank accounts in the app, create new bank accounts and modify"
		+ " them, keep in mind that in order to create a new bank account, a valid user must be provided"
		+ " at the moment of creation.")
@ApiResponses(value= {
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=401, message="NOT AUTHORIZED!"),
		@ApiResponse(code=403, message="FORBIDDEN!"),
		@ApiResponse(code=403, message="NOT FOUND")
})
public class BankAccountRestController {
	
	@Autowired
	private BankAccountService service;
	
	@ApiOperation(value="Get a list of available Bank Accounts in the system", response=List.class)
	@GetMapping
	public List<BankAccount> getBankAccountList() {
		return this.service.getAll();
	}
	
	@ApiOperation(value="Get a list of available Bank Accounts owned by a certain user in the system", response=List.class)
	@GetMapping("/user/{userId}")
	public List<BankAccount> getBankAccountByUser(@PathVariable("userId") Long userId) {
		return this.service.getByUserId(userId);
	}
	
//	@ApiOperation(value="Save a new bank account in the system. Remember, you need a valid user as owner of the new account", response=BankAccount.class)
//	@PostMapping deactivated for now
	public BankAccount saveNew(@RequestBody BankAccount bankAccount,
			@Param("user") User user) {
		return this.service.save(bankAccount, user);
	}
	
//	@ApiOperation(value="Update an existing bank account in the system.", response=BankAccount.class)
//	@PutMapping(value="/{id}") deactivated for now
	public BankAccount update(@RequestBody BankAccount bankAccount, @PathVariable(value="id") Long id) {
		bankAccount.setId(id);
		return this.service.update(bankAccount);
	}
	
	//Disabled for now
	public String delete (@Param("bankAccount") BankAccount bankAccount) {
		return this.service.delete(bankAccount);
	}
}
