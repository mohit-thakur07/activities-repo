package in.org.npci.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.org.npci.beans.Customer;
import in.org.npci.beans.LoanApplication;
import in.org.npci.service.CustomerService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("api")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerNewCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(200).body(customerService.registerNewCustomer(customer));
	}
	
	@GetMapping("/login")
	public ResponseEntity<Object> loginCustomer(@RequestBody Map<String, String> credentials) {
		Customer customer = customerService.validateCustomer(credentials.get("emailId"), credentials.get("password"));
		return ResponseEntity.status(200).body(customer);
	}
	
	@GetMapping("/loans")
	public ResponseEntity<Object> getAllLoanOptions() {
		return ResponseEntity.status(200).body(customerService.viewAllTypeOfLoans());
	}
	
	@GetMapping("/applyLoan")
	public ResponseEntity<Object> applyForNewLoan(@RequestBody LoanApplication loanApplication) {
		loanApplication.setStatus("pending");
		return ResponseEntity.status(200).body(customerService.applyForNewLoan(loanApplication));
	}
	
	@GetMapping("/loan/status/{customerId}")
	public ResponseEntity<Object> getLoanStatus(@PathVariable("customerId") int customerId) {
		return ResponseEntity.status(200).body(customerService.viewLoanApplications(customerId));
	}
}
