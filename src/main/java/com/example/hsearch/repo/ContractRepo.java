package com.example.hsearch.repo;

import com.example.hsearch.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepo extends JpaRepository<Contract, Long> {
}
