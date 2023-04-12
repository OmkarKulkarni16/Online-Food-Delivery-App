package com.hdfc.userservice.restcontroller;

import com.hdfc.userservice.dto.CustomerDTO;
import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;
import com.hdfc.userservice.exceptions.validations.PhoneNumberException;
import com.hdfc.userservice.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;


    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomers(@RequestBody CustomerDTO customerDto) throws PhoneNumberException {

             Customer customer1 = customerService.addCustomer(customerDto);
             return ResponseEntity.status(HttpStatus.CREATED).body(customer1);


    }

   @GetMapping("/getById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);

   }

   @GetMapping("/getAll")
    public  ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer =  customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
   }

   @PutMapping("/update-customer")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDto){
        Customer customer1 = customerService.updateCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.OK).body(customer1);

   }

   @DeleteMapping("/delete-by/{customerId}")
    public ResponseEntity<String> deleteById(@PathVariable int customerId){
        customerService.deleteCustomerById(customerId);
        return ResponseEntity.status(HttpStatus.GONE).body("Customer Got Deleted Successfully");
   }
}
