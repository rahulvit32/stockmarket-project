package com.rahul.controller;

import com.rahul.service.CompanyDetailService;
import com.rahul.entities.Company;
import com.rahul.entities.Stock;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/company")
@RestController
public class CompanyDetailController {

    @Autowired
    CompanyDetailService companyDetailService;

    @GetMapping("/all")
    @ApiOperation(value = "Gets all registered companies and associated details",
                  notes = "Get Request to get all details",
                  response = Iterable.class)
    public Iterable<Company> getAllCompanies(){
        return companyDetailService.getCompany();
    }

    @GetMapping("/specific/{companyName}")
    @ApiOperation(value = "Gets company details using company name",
                  notes = "Get Specific Company Details",
                  response = ResponseEntity.class)
    public ResponseEntity getCompanyData(@PathVariable String companyName){
        return companyDetailService.getCompanyDetails(companyName).size()>0?ResponseEntity.ok(companyDetailService.getCompanyDetails(companyName).get(0)):ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Company with name "+companyName+" not found");
    }

    @GetMapping("/{companyId}/{exchangeID}/{periodFrom}/{periodTo}/{periodicity}")
    @ApiOperation(value = "Gets company details of a specific period",
                  notes = "Get Company Details during a period and specify periodicity",
                  response = ResponseEntity.class)
    public ResponseEntity retrievePeriodData(@PathVariable String companyId,@PathVariable String exchangeID, @PathVariable String periodFrom, @PathVariable String  periodTo, @PathVariable int periodicity)
    {
        List<Stock> stocks = companyDetailService.retrievePeriodData(companyId, exchangeID, periodFrom, periodTo, periodicity);
        return stocks.size() == 0? ResponseEntity.status(HttpStatus.NOT_FOUND).body("No stocks found with given parameters"):ResponseEntity.ok(stocks);
    }

    @GetMapping("/viewPattern/{pattern}")
    @ApiOperation(value = "Gets names of companies using pattern",
                  notes = "Get Pattern and return matching companies",
                  response = ResponseEntity.class)
    public ResponseEntity getCompanyNames(@PathVariable String pattern){
        List<Company> companyNames = companyDetailService.getCompanyNames(pattern);
        return ResponseEntity.ok(companyNames);
    }

    @PostMapping("/add")
    @ApiOperation(value = "Adds company",
                  notes = "Add Company to DB and needs Company class",
                  response = ResponseEntity.class)
    public ResponseEntity addCompany(@RequestBody Company company)
    {
        return companyDetailService.addCompany(company);
    }

    @DeleteMapping("/{code}")
    @ApiOperation(value = "Deletes company",
                  notes = "Deletes company from db using path variable code",
                  response = ResponseEntity.class)
    public ResponseEntity deleteCompany(@PathVariable Integer code){
        return companyDetailService.deleteCompany(code);
    }
}
