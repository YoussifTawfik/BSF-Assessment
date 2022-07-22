package com.bsf.assessment.service.client;

import com.bsf.assessment.entity.Client;
import com.bsf.assessment.repository.BSFBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private BSFBaseRepository<Client,Long> clientRepository;

    public void addClient(){

    }
}
