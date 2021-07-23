package com.rahul.service;

import com.rahul.entities.IPO;
import com.rahul.repositories.IpoJPA;
import com.rahul.repositories.StockExchangeRepository;
import com.rahul.dtos.IPOResponse;
import com.rahul.entities.Company;
import com.rahul.repositories.CompanyRepository;
import com.rahul.repositories.IPORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class IPOService {

    @Autowired
    StockExchangeRepository stockExchangeRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    IPORepository ipoRepository;

    @Autowired
    IpoJPA ipoJPA;

    public ResponseEntity<IPOResponse> addIPO(com.rahul.dtos.IPO ipo)
    {
        IPOResponse ipoResponse = new IPOResponse();
        try {
            IPO ipoDetails = new IPO(ipo.getId(), ipo.getPrice(), ipo.getCountShares(), ipo.getOpeningDateTime(), ipo.getRemarks(), stockExchangeRepository.findById(ipo.getExchangeId()).get(), companyRepository.findById(ipo.getCompanyId()).get());
            Company companyIPO = companyRepository.findById(ipo.getCompanyId()).get();
            companyIPO.setListed(true);
            companyRepository.save(companyIPO);
            ipoRepository.save(ipoDetails);
            ipoResponse.setStatus(true);
            ipoResponse.setMessage("IPO Added Successfully");
            return ResponseEntity.ok(ipoResponse);
        }
        catch (Exception e)
        {
            System.out.println(e);
            ipoResponse.setStatus(false);
            ipoResponse.setError("Invalid Input");
            return new ResponseEntity<IPOResponse>(ipoResponse, HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity getIPO(int companyId) {
        try {
            return ResponseEntity.ok(ipoJPA.findByCompanyId(companyRepository.findById(companyId).get()));
        }
        catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt find ipo with company id "+companyId);
        }
    }

    public ResponseEntity updateIPO(com.rahul.dtos.IPO ipo){

        try {
            IPO ipoDetails = ipoRepository.findById(ipo.getId()).get();
            ipoDetails.setPrice(ipo.getPrice());
            ipoDetails.setCountShares(ipo.getCountShares());
            ipoDetails.setOpeningDateTime(ipo.getOpeningDateTime());
            ipoDetails.setRemarks(ipo.getRemarks());
            ipoRepository.save(ipoDetails);
            return ResponseEntity.ok("Updated Successfully");
        }
        catch (Exception e)
        {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt update");
        }
    }

    public ResponseEntity getChronology(){
        Iterable<IPO> allIPO = ipoRepository.findAll();
        List<Company> companyList = new ArrayList<>();
        for(IPO ipo:allIPO)
            companyList.add(ipo.getCompanyId());
        Collections.sort(companyList, new Comparator<Company>() {
            @Override
            public int compare(Company o1, Company o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return ResponseEntity.ok(companyList);
    }
}
