package main.java.com.altsed.spring.controller;

import main.java.com.altsed.spring.dao.VesselVacancyDAO;
import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import main.java.com.altsed.spring.service.VesselVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/vacancies")
public class VacancyController {

    @Autowired
    private VesselVacancyService vesselVacancyService;

    @GetMapping("/list")
    public String listVacancies (Model theModel){
        List<Vacancy> vacancies = vesselVacancyService.getVacancies();
        theModel.addAttribute("vacancies", vacancies);

        return "list-vacancies";
    }
    @GetMapping("/positions")
    public String listPositions (Model theModel){
        List<Position> positions = vesselVacancyService.getPositions();
        theModel.addAttribute("positions", positions);

        return "list-positions";
    }
    @GetMapping("/vessels")
    public String listVessels (Model theModel){
        List<Vessel> vessels = vesselVacancyService.getVessels();
        theModel.addAttribute("vessels", vessels);

        return "list-vessels";
    }

}
