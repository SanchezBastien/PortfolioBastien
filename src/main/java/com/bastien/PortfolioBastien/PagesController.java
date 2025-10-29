package com.bastien.PortfolioBastien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PagesController {

    private void common(Model model) {
        model.addAttribute("name", "Bastien SANCHEZ");
        model.addAttribute("title", "Développeur Java");
        model.addAttribute("contact", Map.of(
                "email", "sanchez.bastien34@gmail.com",
                "phone", "07 87 39 83 95"
        ));
    }

    private List<String> hardSkills() {
        return List.of(
                "DevOps, Java 21, API Streams, CI/CD, Spring Security, MongoDB, MySQL, NoSQL",
                "Spring Boot (Web MVC, Validation, DevTools), Thymeleaf",
                "Tests : JUnit 5, tests d’intégration, TDD",
                "Maven, gestion des dépendances",
                "Bases de données : SQL (PostgreSQL/MySQL), NoSQL, Spring Data",
                "Web : HTML5, CSS3, notions d’accessibilité",
                "Architecture : MVC, Microservices, principes SOLID, UML",
                "CI/CD : Git, GitHub Action, Gitlab, Docker"
        );
    }
    private List<String> tools() { return List.of("IntelliJ IDEA /", " Git & GitHub /", " Maven /", " Postman /", " Docker (basics) /", " Trello / Jira "); }
    private List<String> softSkills() {
        return List.of(
                "Rigueur & sens de la qualité (expérience qualité/HSE)",
                "Analyse et résolution de problèmes",
                "Communication claire & travail en équipe",
                "Autonomie, fiabilité, respect des délais",
                "Curiosité technique & apprentissage continu"
        );
    }
    private List<Map<String, Object>> experiences() {
        return List.of(
                Map.of("role","Préventeur HSE (CDIC)","company","BP — Dépôt pétrolier Seveso seuil haut","dates","≈ 6 mois",
                        "bullets", List.of(
                                "Pilotage prévention HSE sur site Seveso (sens process & conformité).",
                                "Mise en place et suivi d’indicateurs (KPI) : fréquence incidents, contrôles périodiques.",
                                "Coordination des actions correctives avec les équipes opérationnelles.",
                                "Compétences transposables : rigueur, gestion du risque, suivi de workflow.")),
                Map.of("role","Responsable Qualité Adjoint (CDD)","company","Smurfit Kappa","dates","≈ 6 mois",
                        "bullets", List.of(
                                "Amélioration continue en production (5S, analyse de causes, plans d’action).",
                                "Animation qualité auprès d’équipes pluridisciplinaires.",
                                "Mise en place et suivi de tableaux de bord.",
                                "Compétences transposables : mesure, itération, documentation claire.")),
                Map.of("role","Qualiticien (CDI)","company","Inovie Biomed","dates","≈ 3 ans",
                        "bullets", List.of(
                                "Gestion de processus qualité en laboratoire de biologie médicale.",
                                "Standardisation de procédures, fiabilité des données & traçabilité.",
                                "Préparation/participation à des audits internes & externes.",
                                "Compétences transposables : traçabilité, exigence qualité, documentation."))
        );
    }
    private List<Map<String, String>> education() {
        return List.of(
                Map.of("label","Développeur d’application Java — OpenClassrooms","details","Parcours professionnalisant : Java, Spring, tests, bonnes pratiques."),
                Map.of("label","Bachelor Responsable QHSE — CESI (alternance)","details","Qualité, sécurité, projets en environnement industriel."),
                Map.of("label","BTS Métiers de la Chimie — Lycée Sainte-Marie (alternance)","details","Rigueur expérimentale, méthodes & analyse.")
        );
    }

    @GetMapping("/") public String root() { return "redirect:/a-propos"; }

    @GetMapping("/a-propos")
    public String aPropos(Model model) {
        common(model);
        model.addAttribute("active", "apropos");
        model.addAttribute("aboutIntro", """
        Fort d'une licence en programmation java, j’apporte une approche orientée qualité, sécurité et tests, avec une exigence constante de lisibilité du code et de performance.
        Mon objectif : comprendre les besoins, concevoir des solutions fiables et les livrer avec soin.
""");
        return "apropos";
    }

    @GetMapping("/competences")
    public String competences(Model model) {
        common(model);
        model.addAttribute("active", "competences");
        model.addAttribute("skills", hardSkills());
        model.addAttribute("tools", tools());
        model.addAttribute("expertise", softSkills());
        model.addAttribute("languages", List.of("Français : langue maternelle", "Anglais : C1 (technique & conversationnel)"));
        return "competences";
    }

    @GetMapping("/experiences")
    public String experiencesPage(Model model) {
        common(model);
        model.addAttribute("active", "experiences");
        model.addAttribute("experiences", experiences());
        model.addAttribute("highlights", List.of(
                "Mise en place de métriques : démarche compatible KPI/dev (logs, indicateurs, tests).",
                "Culture de la conformité et du « process » : utile pour la qualité logicielle.",
                "Habitude du travail transversal et de la communication claire."
        ));
        return "experiences";
    }

    @GetMapping("/formation")
    public String formation(Model model) {
        common(model);
        model.addAttribute("active", "formation");
        model.addAttribute("education", education());
        model.addAttribute("selfLearning", List.of(
                "Katas (exercices) pour pratiquer les bases du langage et l’algorithmie.",
                "Veille régulière : docs officielles, blogs techniques, projets perso."
        ));
        return "formation";
    }

    @GetMapping("/projet")
    public String projet(Model model) {
        common(model); // Ajoute les variables communes (nom, titre, tagline, etc.)
        model.addAttribute("active", "projet"); // Pour gérer le menu actif
        model.addAttribute("projectTitle", "Application Bancaire Web - Pay My Buddy");
        model.addAttribute("projectDescription", "Projet réalisé dans le cadre de la formation OpenClassrooms : Développeur d'application Java.");
        return "projet";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        common(model);
        model.addAttribute("active", "contact");
        model.addAttribute("contactIntro", "Envie d’échanger ? Je réponds rapidement par email et par téléphone.");
        return "contact";
    }

    @GetMapping("/parcours")
    public String parcours(Model model) {
        model.addAttribute("name", "Bastien SANCHEZ");
        model.addAttribute("title", "Développeur Java");
        model.addAttribute("active", "parcours");
        return "parcours";
    }
}
