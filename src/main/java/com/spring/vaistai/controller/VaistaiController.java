package com.spring.vaistai.controller;

import com.spring.vaistai.model.User;
import com.spring.vaistai.model.Vaistai;
import com.spring.vaistai.service.SecurityService;
import com.spring.vaistai.service.UserService;
import com.spring.vaistai.service.VaistaiService;
import com.spring.vaistai.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@Controller
public class VaistaiController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/form";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    //*******************************************
    @Autowired
    @Qualifier("VaistaiService")
    private VaistaiService vaistaiService;

    @GetMapping({"/", "/form"})
    public String displayForm(Model model) {
        model.addAttribute("vaistai", new Vaistai());
        return "form";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/vaistas")
    String vaistas(@Valid @ModelAttribute("vaistai") Vaistai e, BindingResult br,
                      @RequestParam HashMap<String, String> vaistuSarasas, ModelMap modelMap) {
        if (br.hasErrors()) { // jei yra validacijos klaidų
            return "form";
        } else {
            String vaistoPav="";
            String vaistuGrupe="";
            String vaistoForma="";
            String veiklMedziaga="";
            double medziagosKiekis=0;

            // ModelMap objektas naudojamas siųsti reikšmę iš Spring MVC controller į JSP
            modelMap.put("vaistoPav", vaistoPav);
            modelMap.put("vaistuGrupe", vaistuGrupe);
            modelMap.put("vaistoForma", vaistoForma);
            modelMap.put("veiklMedziaga", veiklMedziaga);
            modelMap.put("medziagosKiekis", medziagosKiekis);

            // Kreipiamės į service, kuris kreipiasi į DAO ir išsaugo įrašą DB
            vaistaiService.save(new Vaistai(vaistoPav, vaistuGrupe, vaistoForma, veiklMedziaga, medziagosKiekis));

            return "vaistas";
        }
    }
    @RequestMapping(method = RequestMethod.GET, value = "/vaistuSarasas")
    public String getAllVaistai(Model model) {
        model.addAttribute("vaistuSarasas", vaistaiService.getAll());
        return "vaistuSarasas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rodyti{id}")
    public  String getById(@RequestParam("id") int id, Model model){
        model.addAttribute("vaistas", vaistaiService.getById(id));
        return "vaistas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trinti{id}")
    public  String delete(@RequestParam("id") int id, Model model){
        vaistaiService.delete(id);
        model.addAttribute("vaistuSarasas", vaistaiService.getAll());
        return "vaistuSarasas";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atnaujinti{id}")
    public  String update(@RequestParam("id") int id, Model model){
        model.addAttribute("vaistas", vaistaiService.getById(id));
        return "atnaujinti";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/atnaujintiVaista")
    public  String updateVaistai(@ModelAttribute ("vaistas") Vaistai vaistai){
        vaistaiService.update(vaistai);
        return "redirect:/rodyti?id=" + vaistai.getId();
    }

}
