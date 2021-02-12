package com.example.hsearch;

import com.example.hsearch.model.Contract;
import com.example.hsearch.model.Customer;
import com.example.hsearch.repo.ContractRepo;
import com.example.hsearch.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class HsearchApplication implements CommandLineRunner {

    private final CustomerRepo customerRepo;
    private final ContractRepo contractRepo;

    public static void main(String[] args) {
        SpringApplication.run(HsearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var cust1 = new Customer();
        cust1.setCustomerNumber(123L);
        cust1.setFirstName("Hans");
        cust1.setLastName("Wurst");
        log.info("cust1");
        customerRepo.save(cust1);

        var cust2 = new Customer();
        cust2.setCustomerNumber(234L);
        cust2.setFirstName("Peter");
        cust2.setLastName("Pan");
        log.info("cust2");
        customerRepo.save(cust2);

        var contr1 = new Contract();
        contr1.setContractNumber("123");
        contr1.setCustomer(cust1);
        cust1.setContracts(List.of(contr1));
        log.info("contr1");
        contractRepo.save(contr1);

        var contr2 = new Contract();
        contr2.setContractNumber("234");
        contr2.setCustomer(cust2);
        cust2.setContracts(List.of(contr2));
        log.info("contr2");
        contractRepo.save(contr2);

    }
}
