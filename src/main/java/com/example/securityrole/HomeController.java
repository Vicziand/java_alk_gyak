package com.example.securityrole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.ArrayList;
import java.util.List;
@Controller
public class HomeController {


    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/home")
    public String user() {
        return "user";
    }



    @GetMapping("/admin/home")
    public String admin(Model model) {
        return "admin";
    }


    @GetMapping("/registration")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new User());
        return "registration";
    }
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/registration_proc")
    public String reg(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("message", "Az email már foglalt!");
                return "regError";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
// Regisztrációkor minden felhasználónak Vendég szerepet adunk:
        user.setRole("ROLE_Vendeg");
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "regSucces";
    }

    @Autowired private FilmRepo filmRepo;
    @GetMapping("/film")
    public String rendeles(Model model) {
        List<Film> filmek = new ArrayList<>();
        for (Film film : filmRepo.findAll()) {
            filmek.add(film);
        }
        model.addAttribute("filmek", filmek);
        return "film";
    }

    @GetMapping("/kapcsolat")
    public String kapcsolat(Model model) {
        model.addAttribute("kapcs", new Kapcsolat());
        return "kapcsolat";
    }
    @Autowired private KapcsolatRepo kapcsolatRepo;
    @PostMapping(value="/ment")
    public String mentKapcs(@ModelAttribute Kapcsolat kapcsolat, RedirectAttributes redirAttr, String username, Authentication authentication){
        kapcsolat.setFelado("Guest");
        if (authentication != null && authentication.isAuthenticated()){
            kapcsolat.setFelado(authentication.getName());
        }

        kapcsolatRepo.save(kapcsolat);
        redirAttr.addFlashAttribute("uzenet","Az üzenet küldése sikeres! ID="+kapcsolat.getId());
        return "redirect:/";
    }

    @Autowired private UzenetRepo uzenetRepo;
    @GetMapping("/admin/uzenetek")
    public String uzenetek(Model model){
        List<Uzenet> uzenets = uzenetRepo.findAllOrderByCreatedAtDesc();
        model.addAttribute("uzenets", uzenets);
        return "uzenetek";
    }
}
