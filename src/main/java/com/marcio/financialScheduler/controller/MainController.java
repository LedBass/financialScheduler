/**
 * 
 */
package com.marcio.financialScheduler.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.marcio.financialScheduler.dto.TransactionDTO;
import com.marcio.financialScheduler.model.Transaction;
import com.marcio.financialScheduler.model.User;
import com.marcio.financialScheduler.service.BankAccountService;
import com.marcio.financialScheduler.service.TransactionService;
import com.marcio.financialScheduler.service.UserService;
import com.marcio.financialScheduler.util.LocalDateConverterUtil;

/**
 * @author marcio
 *
 */
@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private BankAccountService bankService;
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/")
	public String start(Model model) {
		List<User> users = (List<User>) this.userService.getAll();
		
		if (null != users) {
			model.addAttribute("users", users);
		}
		return "start";
	}
	
	@GetMapping("/principal/{userId}")
	public String main(Model model, @PathVariable(value="userId") Long userId) {
		User user = this.userService.getByUserId(userId);
		
		if (null != user) {
			model.addAttribute("user", user);
			model.addAttribute("account", bankService.getById(userId));
			return "main";
			
		} else {
			model.addAttribute("errorMessage", "Usuário não encontrado!");
			return "error";
		}
	}
	
	@GetMapping("/principal/transactions/new/{userId}")
	public ModelAndView newTransaction(Model model, @PathVariable(value="userId") Long userId) {
		User user = this.userService.getByUserId(userId);
		model.addAttribute("user", user);
		model.addAttribute("sourceAccount", bankService.getById(userId));
		TransactionDTO transactionDTO = new TransactionDTO();
		ModelAndView modelAndView = new ModelAndView("newTransaction", "transactionDTO", transactionDTO);
		return modelAndView;
	}
	
	@PostMapping("/principal/transactions/new/submit")
	public ModelAndView submitNewTransaction(Model model, @Valid @ModelAttribute("transactionDTO") TransactionDTO transactionDTO,
			BindingResult bindingResult) {
		LocalDate correctDate = transactionDTO.getScheduleDate();
		
		correctDate = correctDate.plusDays(1); //Workaround to correct the always one day off with datepicker in date type form input
		LocalDateConverterUtil converterUtil = new LocalDateConverterUtil();
		transactionDTO.setScheduleDate(converterUtil.convertToDatabaseColumn(correctDate));
		
		Object transaction = this.transactionService.save(transactionDTO);
		
		if (transaction instanceof Transaction) {
			Transaction toReturn = (Transaction) transaction;
			model.addAttribute("transaction", toReturn);
			return new ModelAndView(new RedirectView("/principal/transactions/details/" + toReturn.getId()));
			
		} else {
			model.addAttribute("errorMessage", transaction);
			return new ModelAndView(new RedirectView("error"));
		}
	}
	
	@GetMapping("/principal/transactions/details/{transactionId}")
	public String transactionDetails(Model model, @PathVariable(value="transactionId") Long transactionId) {
		Transaction transaction = this.transactionService.getById(transactionId);
		
		if (null != transaction) {
			model.addAttribute("transaction", transaction);
			return "transactionDetails";
			
		} else {
			model.addAttribute("errorMessage", "Transação não encontrada!");
			return "error";
		}
	}
	
	@GetMapping("/principal/transactions/list/{userId}")
	public String transactionList(Model model, @PathVariable(value="userId") Long userId) {
		User user = this.userService.getByUserId(userId);
		
		if (null != user) {
			model.addAttribute("user", user);
			model.addAttribute("account", bankService.getById(userId));
			model.addAttribute("transactions", transactionService.getByUserId(userId));
			return "transactionList";
			
		} else {
			model.addAttribute("errorMessage", "Usuário não encontrado!");
			return "error";
		}
	}
}
