package com.bastien.PortfolioBastien;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ContactController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/contact")
    public String handleContactForm(
            @Valid @ModelAttribute ContactMessage contactMessage,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "contact";
        }

        // Envoi de l'email
        emailService.sendContactEmail(
                contactMessage.getName(),
                contactMessage.getEmail(),
                contactMessage.getMessage()
        );

        redirectAttributes.addAttribute("sent", "true");
        return "redirect:/contact";
    }
}
