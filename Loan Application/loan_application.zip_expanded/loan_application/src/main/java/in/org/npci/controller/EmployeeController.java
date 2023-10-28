package in.org.npci.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.org.npci.beans.Employee;
import in.org.npci.beans.LoanApplication;
import in.org.npci.service.EmployeeService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/admin/api")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/login")
	public ResponseEntity<Object> loginEmployee(@RequestBody Map<String, String> credentials) {
		Employee employee = employeeService.validateEmployee(credentials.get("emailId"), credentials.get("password"));
		return ResponseEntity.status(200).body(employee);
	}
	
	@GetMapping("/applications")
	public ResponseEntity<Object> getAllLoanApplications() {
		return ResponseEntity.status(200).body(employeeService.viewAllLoanApplications());
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<Object> updateLoanApllicationStatus(@RequestBody LoanApplication loanApplication) {
		return ResponseEntity.status(200).body(employeeService.updateLoanApplicationStatus(loanApplication));
	}
	
	@GetMapping("/creditScore/{pan}")
	public ResponseEntity<Object> checkCustomerCreditScore(@PathVariable("pan") String pan) {
		return ResponseEntity.status(200).body(employeeService.viewCreditScoreOfCustomer(pan));
	}
}
