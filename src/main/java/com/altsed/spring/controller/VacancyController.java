package main.java.com.altsed.spring.controller;

import main.java.com.altsed.spring.dao.VesselVacancyDAO;
import main.java.com.altsed.spring.entity.Position;
import main.java.com.altsed.spring.entity.Vacancy;
import main.java.com.altsed.spring.entity.Vessel;
import main.java.com.altsed.spring.service.VesselVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
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

    @GetMapping("/showFormForAddPosition")
    public String showFormForAddPosition (Model theModel){
        Position thePosition = new Position();
        theModel.addAttribute("position", thePosition);
        return "add-position";
    }

    @PostMapping("/savePosition")
    public String savePosition (@ModelAttribute("position") Position thePosition){
        vesselVacancyService.savePosition(thePosition);

        return "redirect:/vacancies/positions";

    }

    @GetMapping("/showFormForAddVessel")
    public String showFormForAddVessel (Model theModel){
        Vessel theVessel = new Vessel();
        theModel.addAttribute("vessel", theVessel);
        return "add-vessel";
    }

    @PostMapping("/saveVessel")
    public String saveVessel (@ModelAttribute("vessel") Vessel theVessel){
        vesselVacancyService.saveVessel(theVessel);

        return "redirect:/vacancies/vessels";

    }

    @GetMapping("/showFormForAddVacancy")

    public String showFormForAddVacancy (Model theModel){
        Vacancy theVacancy = new Vacancy();

        theModel.addAttribute("vacancy", theVacancy);
   //     theModel.addAttribute("vessels", vesselVacancyService.getVessel("Vessel{id=6, name='Explorer', vesselType='Boat', engineType='wind', enginePower='12HP'}"));
        theModel.addAttribute("vessels", vesselVacancyService.getVessels());

        theModel.addAttribute("positions", vesselVacancyService.getPositions());

        return "add-vacancy";
    }

    @PostMapping("/saveVacancy")
    public String saveVacancy (@ModelAttribute("vacancy") Vacancy theVacancy){

        vesselVacancyService.saveVacancy(theVacancy);
        return "redirect:/vacancies/list";

    }




}
