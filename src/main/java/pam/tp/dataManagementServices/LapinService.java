package pam.tp.dataManagementServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pam.tp.model.Lapin;
import pam.tp.repositories.ILapinRepository;
import pam.tp.repositories.IProprietaireRepository;

@Service
public class LapinService implements ILapinService {
	
	@Autowired
	 private ILapinRepository LapinRepo;
	
	@Autowired
	 private IProprietaireRepository ProprietaireRepo;
	
	 public void addLapin(String nom,  Long idPapa, Long idMaman, Long idPropositaire)
	{
		Lapin lapin = new Lapin();
		lapin.setNom(nom);
		if (idPapa != null) {
  		  LapinRepo.findById(idPapa).ifPresent(p -> lapin.setPapa(p));
		}
		if (idMaman != null) {
    		LapinRepo.findById(idMaman).ifPresent(m -> lapin.setMaman(m));
		}
		if (idPropositaire != null) {
    		ProprietaireRepo.findById(idPropositaire).ifPresent(prop -> lapin.setProprietaire(prop));
	}
		LapinRepo.save(lapin);
	}

	 @Override
	 public Iterable<Lapin> getAllLapins() {
		 return LapinRepo.findAll();
	 }

		 @Override
		 public void deleteLapin(Long idLapin) {
			LapinRepo.deleteById(idLapin);
		 }
	
		 @Override
		 public Lapin getLapinById(Long idLapin) {
			return LapinRepo.findById(idLapin).orElse(null);
		 }
	}