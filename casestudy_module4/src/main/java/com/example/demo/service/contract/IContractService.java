package com.example.demo.service.contract;

import com.example.demo.model.contract.Contract;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractService extends IGeneralService<Contract> {
    public Page<Contract> findAll(Pageable pageable);
}
