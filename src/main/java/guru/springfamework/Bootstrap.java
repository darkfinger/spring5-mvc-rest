package guru.springfamework;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        Customer dav = new Customer();
        dav.setId(1L);
        dav.setFirstname("David");
        dav.setLastname("oft");

        Customer kaps = new Customer();
        kaps.setId(2L);
        kaps.setFirstname("kaps");
        kaps.setLastname("le deu");

        Customer kiki = new Customer();
        kiki.setId(3L);
        kiki.setFirstname("kiki");
        kiki.setLastname("drake");

        customerRepository.save(dav);
        customerRepository.save(kaps);
        customerRepository.save(kiki);


        System.out.println("Data Loaded = " + categoryRepository.count() );
        System.out.println("Data Loaded = " + customerRepository.count() );
    }
}
