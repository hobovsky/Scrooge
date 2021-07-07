package com.mysoft.scrooge.service;

import com.mysoft.scrooge.model.Register;
import com.mysoft.scrooge.persistence.RegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepo;

    @Autowired
    public RegisterServiceImpl(RegisterRepository registerRepo) {
        this.registerRepo = registerRepo;
    }

    @Override
    public String ping() {
        return "PONG!";
    }

    /*
    TODO: specify ordering of returned registers
     */
    @Override
    public List<Register> getBalance() {
        Iterable<Register> iterable =  registerRepo.findAll();
        List<Register> allRegisters = new ArrayList<>();
        iterable.forEach(allRegisters::add);
        return allRegisters;
    }
}
