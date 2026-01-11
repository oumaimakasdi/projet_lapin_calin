package pam.tp.dataManagementServices;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pam.tp.model.Proprietaire;
import pam.tp.repositories.IProprietaireRepository;

@Service
public class ProprietaireService implements IProprietaireService{

	@Autowired
	IProprietaireRepository proprietaireRepo;
		
	public void addPProprietaire(String nom, String prenom, String adresse)
	{
		Proprietaire p = new Proprietaire();
		p.setNom(nom);
		p.setPrenom(prenom);
		p.setAdresse(adresse);
		proprietaireRepo.save(p);
	}

	public  Iterable<Proprietaire> getAllProprietaires() {
		return proprietaireRepo.findAll();
	}
	public void deleteById(Long id) {
		proprietaireRepo.deleteById(id);
	}
	
}
