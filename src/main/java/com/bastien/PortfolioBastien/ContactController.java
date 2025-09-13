package com.bastien.PortfolioBastien;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {


    @PostMapping("/contact")
    public String handleContactForm(
            @Valid @ModelAttribute ContactMessage contactMessage,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "contact"; // Renvoie la page avec les messages d'erreur
        }

        // Affiche les données dans la console
        System.out.println("Nom : " + contactMessage.getName());
        System.out.println("Email : " + contactMessage.getEmail());
        System.out.println("Message : " + contactMessage.getMessage());

        // Redirection avec confirmation
        redirectAttributes.addAttribute("sent", "true");
        return "redirect:/contact";
    }
}