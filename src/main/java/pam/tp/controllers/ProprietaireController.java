package pam.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pam.tp.dataManagementServices.IProprietaireService;

@Controller
@RequestMapping("/proprietaires") 
public class ProprietaireController {

    @Autowired
    private IProprietaireService proprietaireService; 

    @GetMapping
    public String listeProprietaires(Model model) {
        model.addAttribute("tousLesProprios", proprietaireService.getAllProprietaires());
        return "ListeProprietaires"; 
    }

    @GetMapping("/ajouter")
    public String formulaireAjout() {
        return "formulaireProprietaire";
    }

    @PostMapping("/enregistrer")
    public String enregistrerProprietaire(@RequestParam String prenom, 
                                          @RequestParam String nom, 
                                          @RequestParam String adresse) {
        
        proprietaireService.addPProprietaire(prenom, nom, adresse);
        
        return "redirect:/proprietaires";
    }

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
