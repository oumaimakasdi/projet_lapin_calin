package pam.tp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pam.tp.dataManagementServices.ILapinService;
import pam.tp.dataManagementServices.IProprietaireService;
import pam.tp.model.Lapin;


@Controller
@RequestMapping("/lapins")
public class LapinController {
	@Autowired
	private ILapinService lapinService;
	@Autowired
	private IProprietaireService proprietaireService;
	@GetMapping
	public String getAllLapins(Model model)
	{
		Iterable<Lapin> liste = lapinService.getAllLapins();
		model.addAttribute("TousLesLapins", liste);
		return "affichagelapins";
	}
	@GetMapping("/deleteLapin/{id}")
	public String supprimerLapin(@PathVariable("id") Long id, Model model)
	{
		String result;
        try {
            lapinService.deleteLapin(id);
            result = "redirect:/lapins";
        } catch (DataIntegrityViolationException dive) {
			System.out.println("FK constraint prevents deleting Lapin with ID " + id + ": " + dive.getMessage());
            result = "redirect:/lapins?alert=deleteError";
        }
        return result;
    }
	@GetMapping("/ajouter")
	public String afficherFormulaire(Model model)
	{
  	  	model.addAttribute("proprietaires", proprietaireService.getAllProprietaires());
    	model.addAttribute("TousLesLapins", lapinService.getAllLapins()); 
		return "formulaireLapin";
	}
	@PostMapping("/enregistrer") 
	public String enregistrerLeLapin(
    @RequestParam String nom,        
    @RequestParam(required = false) Long idPapa, 
    @RequestParam(required = false) Long idMaman,  
    @RequestParam Long idProprio     
) {
    lapinService.addLapin(nom, idPapa, idMaman, idProprio);
    
    return "redirect:/lapins";
}
}
