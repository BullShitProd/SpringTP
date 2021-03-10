package com.example.demoWebService.Service;

import com.example.demoWebService.Entity.Van;
import com.example.demoWebService.repository.VanRepository;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VanService {

    VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
        this.vanRepository.save(new Van("1111", "Peugeot", 50, 10));
        this.vanRepository.save(new Van("2222", "Opel", 50, 10));
    }

    @RequestMapping(value = "/vans", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Van> listOfVans(){

        List<Van> vans = new ArrayList<Van>();
        vanRepository.findAll().forEach(vans::add);
        return vans;
    }

    @PostMapping("/vans")
    public String addVan(@RequestBody Van van) throws Exception{
        vanRepository.save(van);

        return "Add van success";
    }

    @RequestMapping(value = "/vans/{plateNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Van aVan(@PathVariable("plateNumber") String plateNumber) throws Exception{
        List<Van> vans = new ArrayList<Van>();

        vanRepository.findAll().forEach(vans::add);

        for(Van van : vans) {
            if(van.getPlateNumber().equals(plateNumber)) {
                return van;
            }
        }

        return null;
    }


}
