package guru.springfamework.service;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.mapper.CustomerMapperImpl;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    private final Long ID=1L;
    private final String NAME="david";
    private final String FNAME="kaps";
    private CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService=new CustomerServiceImpl(customerRepository,CustomerMapper.INSTANCE);
    }

    @Test
    public void getAllCustomers() {
        //given
        List<Customer> categories = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(categories);

        //when
        List<CustomerDTO> categoryDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, categoryDTOS.size());
    }

    @Test
    public void getCustomer() throws Exception {

        //given
        Customer customer=new Customer();
        customer.setId(ID);
        customer.setLastname(NAME);
        customer.setFirstname(FNAME);

        when(customerRepository.findByLastname(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerFound=customerService.getCustomer(customer.getLastname());

        //then
        assertEquals(NAME,customerFound.getLastname());
    }
}