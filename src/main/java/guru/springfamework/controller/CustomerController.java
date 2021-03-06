package guru.springfamework.controller;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/customer/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> allCustomer() {
        return new ResponseEntity<CustomerListDTO>(new CustomerListDTO(customerService.getAllCustomers()),HttpStatus.OK);
    }


    @GetMapping("name")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name) {
        return new ResponseEntity<CustomerDTO>(customerService.getCustomer(name),HttpStatus.OK);
    }
}
