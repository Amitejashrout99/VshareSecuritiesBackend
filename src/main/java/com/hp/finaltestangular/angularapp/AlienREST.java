package com.hp.finaltestangular.angularapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class AlienREST
{


    @Autowired
    alienrepo repo;


    @GetMapping(path="Aliens",produces = {"application/json"})
    @ResponseBody
    public List<alien> get_all_aliens()
    {
        /*List<alien> all_aliens= new ArrayList<>();
        all_aliens.add(new alien(2,"omm"));
        all_aliens.add(new alien(3,"tom"));
        all_aliens.add(new alien(4,"som"));*/

        //m.addAttribute("result",repo.findAll());
        List<alien> all_aliens= repo.findAll();

        return all_aliens;

        //return "show_aliens";
    }

    @PostMapping(path="Aliens",consumes = {"application/json"})
    @ResponseBody
    public alien add_alien( @RequestBody alien al)
    {
        repo.save(al);
        return al;
    }

    @GetMapping("Aliens/{aid}")
    @ResponseBody
    public alien get_particular_alien(@PathVariable("aid") int alid)
    {
        alien al= repo.findById(alid).orElse(new alien(0,""));
        return al;
    }

}
