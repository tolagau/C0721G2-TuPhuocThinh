package com.example.demo.service.contract;

import com.example.demo.model.contract.ContractDetail;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IContractDetailService extends IGeneralService<ContractDetail> {
    Page<ContractDetail> findAll(Pageable pageable);
}
