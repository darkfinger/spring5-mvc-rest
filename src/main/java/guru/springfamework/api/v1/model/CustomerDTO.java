package guru.springfamework.api.v1.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class CustomerDTO {

    private Long id;
    private String firstname;
    private String lastname;
}
