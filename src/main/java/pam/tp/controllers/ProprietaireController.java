package pam.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pam.tp.dataManagementServices.IProprietaireService;

@Controller
@RequestMapping("/proprietaires") // Toutes les URLs de ce contrôleur commenceront par /proprietaires
public class ProprietaireController {

    @Autowired
    private IProprietaireService proprietaireService; // Utilisation de l'interface

    // --- LIRE : Afficher la liste des propriétaires ---
    @GetMapping
    public String listeProprietaires(Model model) {
        model.addAttribute("tousLesProprios", proprietaireService.getAllProprietaires());
        return "ListeProprietaires"; // Vers src/main/resources/templates/listeProprietaires.html
    }

    // --- CRÉER : Afficher le formulaire d'ajout d'un humain ---
    @GetMapping("/ajouter")
    public String formulaireAjout() {
        return "formulaireProprietaire";
    }

    // --- CRÉER : Traiter l'enregistrement des données du formulaire ---
    @PostMapping("/enregistrer")
    public String enregistrerProprietaire(@RequestParam String prenom, 
                                          @RequestParam String nom, 
                                          @RequestParam String adresse) {
        
        proprietaireService.addPProprietaire(prenom, nom, adresse);
        
        // On redirige vers la liste pour voir le nouveau propriétaire apparaître
        return "redirect:/proprietaires";
    }

    // --- SUPPRIMER : Supprimer un propriétaire ---
    @GetMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
		String result;
        try {
            proprietaireService.deleteById(id);
            result = "redirect:/proprietaires";
        } catch (DataIntegrityViolationException dive) {
            System.out.println("FK constraint prevents deleting Proprietaire with ID " + id + ": " + dive.getMessage());
            result = "redirect:/proprietaires?alert=deleteError";
        }
        return result;
    }
}
