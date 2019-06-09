/**
 * 
 */
package com.marcio.financialScheduler.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcio.financialScheduler.model.User;
import com.marcio.financialScheduler.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author marcio
 *
 */
@RestController
@RequestMapping("/api/users")
@Api(value="Financial Scheduller App API", description="Operations for managing user in the app")
@ApiResponses(value={
		@ApiResponse(code=200, message="OK"),
		@ApiResponse(code=401, message="NOT AUTHORIZED!"),
		@ApiResponse(code=403, message="FORBIDDEN!"),
		@ApiResponse(code=403, message="NOT FOUND")
})
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation(value="Get a list of registered users in the system.", response=Iterable.class)
	@GetMapping
	public Iterable<User> getUserList() {
		return this.service.getAll();
	}
	
	@ApiOperation(value="Search for a specific user in the system.", response=User.class)
	@GetMapping("/{id}")
	public User getUserByd(@PathVariable("id") Long id) {
		return this.service.getByUserId(id);
	}
	
	@ApiOperation(value="save a new user in the system.", response=User.class)
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return this.service.saveUser(user);
	}
	
	@ApiOperation(value="update an existing user in the system.", response=User.class)
	@PutMapping(value="/{id}")
	public User updateUser(@RequestBody User user, @PathVariable(value="id") Long id) {
		user.setId(id);
		return this.service.updateUser(user);
	}
	
	//disabled for now
	public String deleteUser(@Param(value="user") User user) {
		return this.service.deleteUser(user);
	}
}
