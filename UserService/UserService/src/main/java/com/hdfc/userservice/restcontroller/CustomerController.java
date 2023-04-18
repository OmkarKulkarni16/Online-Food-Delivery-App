package com.hdfc.userservice.restcontroller;

import com.hdfc.userservice.dto.CustomerDTO;
import com.hdfc.userservice.entity.Customer;
import com.hdfc.userservice.exceptions.CustomerNotFoundException;
import com.hdfc.userservice.exceptions.validations.ValidationException;
import com.hdfc.userservice.service.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    String regexForCustomerName = "^([A-Z][a-z]*((\\s)))+[A-Z][a-z]*$";
    String regexForCustomerEmail = "^(.+)@(.+)$";
    String regexForCustomerNumber = "^(\\+91|\\+91\\-|0)?[789]\\d{9}$";
    @Autowired
    ICustomerService customerService;


    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomers(@Valid @RequestBody CustomerDTO customerDto) throws CustomerNotFoundException, ValidationException {
        logger.info("Customer Details = " + customerDto.getCustomerName());


        if (customerDto.getCustomerName().matches(regexForCustomerName) && customerDto.getCustomerEmail().matches(regexForCustomerEmail) && customerDto.getCustomerPhoneNumber().matches(regexForCustomerNumber) && customerDto.getCustomerDeliveryAddress().length() > 0) {
            Customer customer1 = customerService.addCustomer(customerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(customer1);

        } else {
            throw new ValidationException();
        }

    }

    @GetMapping("/getRatingBy/{customerId}")
    public ResponseEntity<Customer> getRatingByCustomerId(@PathVariable int customerId) throws CustomerNotFoundException {
        Customer customer = customerService.getRatingByCustomerId(customerId);
        return ResponseEntity.ok(customer);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> allCustomer = customerService.getAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }

    @PutMapping("/update-customer")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody CustomerDTO customerDto) throws ValidationException {
        if (customerDto.getCustomerName().matches(regexForCustomerName) && customerDto.getCustomerEmail().matches(regexForCustomerEmail) && customerDto.getCustomerPhoneNumber().matches(regexForCustomerNumber) && customerDto.getCustomerDeliveryAddress().length() > 0){
            Customer customer1 = customerService.updateCustomer(customerDto);
            return ResponseEntity.status(HttpStatus.OK).body(customer1);
        }else {
            throw new ValidationException();
        }


    }

    @DeleteMapping("/delete-by/{customerId}")
    public ResponseEntity<String> deleteById(@PathVariable int customerId) throws CustomerNotFoundException {
        if (customerService.existById(customerId)) {
            customerService.deleteCustomerById(customerId);
            return ResponseEntity.status(HttpStatus.GONE).body("Customer Got Deleted Successfully");
        } else {
            throw new CustomerNotFoundException("Customer Not With ID = " + customerId);
        }

    }


    @GetMapping("/getCustomerBy/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
        Customer customer = customerService.getByCustomerId(customerId);
        return ResponseEntity.ok(customer);
    }

}
