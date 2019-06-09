/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.financialScheduler.model.TransactionType;
import com.marcio.financialScheduler.service.TransactionTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author marcio
 *
 */
@RestController
@RequestMapping("/api/transaction_types")
@Api(value="Financial Scheduller App API", description="Operations for managing type of "
		+ "transactions in the app, you can see what are the current types of transactions"
		+ " available at the moment, modify existing ones and create new transaction types.")
@ApiResponses(value={
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=401, message="NOT AUTHORIZED!"),
		@ApiResponse(code=403, message="FORBIDDEN!"),
		@ApiResponse(code=403, message="NOT FOUND")
})
public class TransactionTypeRestController {
	
	@Autowired
	private TransactionTypeService service;
	
	@ApiOperation(value="Search for a specific type of transaction in the system by it's name.", response=TransactionType.class)
	@GetMapping("/type/{type}")
	public TransactionType getByTransactionType(@PathVariable("type") String type) {
		return this.service.getByTransactionType(type);
	}
	
	@ApiOperation(value="Search for a specific type of transaction in the system by it's database id.", response=TransactionType.class)
	@GetMapping("/{id}")
	public TransactionType getById(@PathVariable("id") Long id) {
		return this.service.getById(id);
	}
	
	@ApiOperation(value="Get a list of all available types of transaction in the system.", response=List.class)
	@GetMapping
	public List<TransactionType> getAll() {
		return this.service.getAll();
	}
	
//	@ApiOperation(value="Save a new type of transaction in the system.", response=TransactionType.class)
//	@PostMapping deactivated for now
	public TransactionType save(@RequestBody TransactionType transactionType) {
		return this.service.save(transactionType);
	}
	
//	@ApiOperation(value="Update an existing type of transaction in the system.", response=TransactionType.class)
//	@PutMapping(value="{id}") deactivated for now
	public TransactionType update(@RequestBody TransactionType transactionType, @PathVariable("id") Long id) {
		transactionType.setId(id);
		return this.service.update(transactionType);
	}
}
