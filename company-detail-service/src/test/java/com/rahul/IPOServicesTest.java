package com.rahul;

import com.rahul.controller.IPOController;
import com.rahul.repositories.CompanyRepository;
import com.rahul.repositories.IPORepository;
import com.rahul.repositories.StockExchangeRepository;
import com.rahul.service.CompanyDetailService;
import com.rahul.service.IPOService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IPOServicesTest {

    @Autowired
    private IPOController ipoController;

    @Autowired
    private IPOService ipoService;

    @Autowired
    private StockExchangeRepository stockExchangeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private IPORepository ipoRepository;

    @Autowired
    CompanyDetailService companyDetailService;

    @Before
    public void init(){
    }

    public void addIPOTests(){
    }

    public void getIPOTests(){

    }


}
