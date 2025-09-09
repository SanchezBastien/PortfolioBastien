package com.bastien.PortfolioBastien;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Validated
public class ContactController {

    private static final Logger log = LoggerFactory.getLogger(ContactController.class);

    public static class ContactMessage {
        @NotBlank public String name;
        @NotBlank @Email public String email;
        @NotBlank public String message;
    }

    @PostMapping("/contact")
    public String handle(@ModelAttribute @Validated ContactMessage m, RedirectAttributes ra) {
        log.info("Message contact de {} <{}>: {}", m.name, m.email, m.message);
        ra.addAttribute("sent", "1");
        return "redirect:/#contact";
    }
}
