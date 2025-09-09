package com.bastien.PortfolioBastien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PagesController {

    // --- Données communes (entête, contact…) ---
    private void common(Model model) {
        model.addAttribute("name", "Bastien SANCHEZ");
        model.addAttribute("title", "Développeur informatique");
        model.addAttribute("tagline", "Java • Spring Boot • MVC • Tests");

        model.addAttribute("contact", Map.of(
                "email", "sanchez.bastien34@gmail.com",
                "phone", "07 87 39 83 95",
                "address", "1 Impasse des Hespérides, 34110 Frontignan"
        ));
    }

    // --- Données de contenu (tu peux les déplacer en service plus tard) ---
    private List<String> skills() {
        return List.of(
                "Java, Spring Boot, MVC, SOLID, UML",
                "Git/GitHub, IntelliJ IDEA, Maven",
                "Tests : JUnit, Javadoc",
                "SQL & NoSQL",
                "UX design (sens produit)"
        );
    }
    private List<String> softSkills() {
        return List.of(
                "Gestion de données",
                "Analyse & résolution de problèmes",
                "Rigueur & attention aux détails",
                "Gestion de projets",
                "Communication & collaboration",
                "Adaptabilité & apprentissage continu"
        );
    }
    private List<Map<String, Object>> experiences() {
        return List.of(
                Map.of("role", "Préventeur HSE (CDIC)",
                        "company", "BP — Dépôt pétrolier Seveso seuil haut",
                        "dates", "≈ 6 mois",
                        "bullets", List.of(
                                "Pilotage prévention HSE sur site classé Seveso",
                                "Suivi d’indicateurs et gestion des risques"
                        )),
                Map.of("role", "Responsable Qualité Adjoint (CDD)",
                        "company", "Smurfit Kappa",
                        "dates", "≈ 6 mois",
                        "bullets", List.of(
                                "Système qualité en production d’emballages papier",
                                "Amélioration continue et conformité"
                        )),
                Map.of("role", "Qualiticien (CDI)",
                        "company", "Inovie Biomed",
                        "dates", "≈ 3 ans",
                        "bullets", List.of(
                                "Qualité en laboratoire de biologie médicale",
                                "Fiabilité des données et procédures"
                        ))
        );
    }
    private List<Map<String, String>> education() {
        return List.of(
                Map.of("label", "Développeur d’application Java — OpenClassrooms", "details", "Parcours 1 an"),
                Map.of("label", "Bachelor Responsable QHSE — CESI (alternance)", "details", ""),
                Map.of("label", "BTS Métiers de la Chimie — Lycée Sainte-Marie (alternance)", "details", "")
        );
    }

    // --- Routes ---

    @GetMapping("/")
    public String root() { return "redirect:/a-propos"; }

    @GetMapping("/a-propos")
    public String aPropos(Model model) {
        common(model);
        model.addAttribute("about", """
Aujourd’hui en reconversion vers le développement Java (formation OpenClassrooms),
je m’appuie sur un socle scientifique et analytique solide, une vraie rigueur
et le goût de la résolution de problèmes.
""");
        return "apropos";
    }

    @GetMapping("/competences")
    public String competences(Model model) {
        common(model);
        model.addAttribute("skills", skills());
        model.addAttribute("expertise", softSkills());
        model.addAttribute("languages", List.of("Français : langue maternelle", "Anglais : C1"));
        model.addAttribute("interests", List.of("Sciences & technologies", "Handball", "Voyages"));
        return "competences";
    }

    @GetMapping("/experiences")
    public String experiencesPage(Model model) {
        common(model);
        model.addAttribute("experiences", experiences());
        return "experiences";
    }

    @GetMapping("/formation")
    public String formation(Model model) {
        common(model);
        model.addAttribute("education", education());
        return "formation";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        common(model);
        return "contact";
    }
}
