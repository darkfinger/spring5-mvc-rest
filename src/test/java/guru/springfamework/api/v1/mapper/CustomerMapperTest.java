package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.Assert.*;

public class CustomerMapperTest {

    private final Long ID=1L;
    private final String NAME="david";
    private final String FNAME="kaps";

    CustomerMapper customerMapper= CustomerMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void customerToCustomerDTO() {
        //given
        Customer customer=new Customer();
        customer.setId(ID);
        customer.setLastname(NAME);
        customer.setFirstname(FNAME);

        //when
        CustomerDTO customerDTO=customerMapper.customerToCustomerDTO(customer);
        //then
        assertEquals(customer.getFirstname(),customerDTO.getFirstname());
        assertEquals(FNAME,customerDTO.getFirstname());
    }
}