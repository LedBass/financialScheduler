/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.financialScheduler.dto.TransactionDTO;
import com.marcio.financialScheduler.model.Transaction;
import com.marcio.financialScheduler.service.TransactionService;
import com.marcio.financialScheduler.util.LocalDateConverterUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author marcio
 *
 */
@RestController
@RequestMapping("/api/transactions")
@Api(value="Financial Scheduller App API", description="Operations for managing transactions"
		+ " in the app. you can consult previous made transactions, create new transaction "
		+ "and modify existing transactions")
@ApiResponses(value= {
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=401, message="NOT AUTHORIZED!"),
		@ApiResponse(code=403, message="FORBIDDEN!"),
		@ApiResponse(code=403, message="NOT FOUND")
})
public class TransactionRestController {
	
	@Autowired
	private TransactionService service;
	
	@ApiOperation(value="Get a list of all transactions made in the system.", response=List.class)
	@GetMapping
	public List<Transaction> getAll() {
		return this.service.getAll();
	}
	
	@ApiOperation(value="Get a list of all transactions made by a certain user in the system using the id of the user.", response=List.class)
	@GetMapping("/user/{userId}")
	public List<Transaction> getByUserId(@PathVariable("userId") Long userId) {
		return this.service.getByUserId(userId);
	}
	
	@ApiOperation(value="Get a list of all transactions made by thru a certain bank account used as source "
			+ "of the transaction in the system using the id of the bank account.", response=List.class)
	@GetMapping("/sourceAccount/{sourceAccountId}")
	public List<Transaction> getBySourceAccountId(@PathVariable("sourceAccountId") Long userId) {
		return this.service.getBySourceAccountId(userId);
	}
	
	@ApiOperation(value="Get a list of all transactions sent to a certain bank account "
			+ "of the transaction in the system using the id of the bank account.", response=List.class)
	@GetMapping("/destAccount/{destAccountId}")
	public List<Transaction> getByDestinationAccountId(@PathVariable("destAccountId") Long userId) {
		return this.service.getByDestinationAccountId(userId);
	}
	
	@ApiOperation(value="Get a list of all transactions that followed the rules of a certain type of "
			+ "transaction using the id of the type of transaction.", response=List.class)
	@GetMapping("/transactionType/{transactionTypeId}")
	public List<Transaction> getByTransactionTypeId(@PathVariable("transactionTypeId") Long userId) {
		return this.service.getByTransactionTypeId(userId);
	}
	
	@ApiOperation(value="Save a new transaction in the system, the response can be a representation of the transaction "
			+ "indicating the success of the transaction or a string containg an error message", response=Object.class)
	@PostMapping
	public Object save(@RequestBody TransactionDTO transactionDTO) {
		
		return this.service.save(transactionDTO);
	}
	
	@ApiOperation(value="Update an existing transaction in the system, the response can be a representation of the transaction "
			+ "indicating the success of the transaction or a string containg an error message", response=Object.class)
	@PutMapping(value="/{id}")
	public Object update(@RequestBody Transaction transaction, @PathVariable("id") Long id) {
		transaction.setId(id);
		return this.service.update(transaction);
	}
	
	@ApiOperation(value="Get a list of all transactions made in a certain date.", response=List.class)
	@GetMapping(value="/by_submit/{date}")
	public List<Transaction> getBySubmitDate(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		return this.service.getByLocalDate(false, converterUtil.convertToEntityAttribute(date));
	}
	
	@ApiOperation(value="Get a list of all transactions scheduled to a certain date.", response=List.class)
	@GetMapping(value="/by_schedule/{date}")
	public List<Transaction> getByScheduleDate(@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date) {
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		return this.service.getByLocalDate(true, converterUtil.convertToEntityAttribute(date));
	}
}
