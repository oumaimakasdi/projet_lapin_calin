package pam.tp.dataManagementServices;

import pam.tp.model.Lapin;


public interface ILapinService {
	public void addLapin(String nom, Long idpapa , Long idmaman, Long idPropositaire);
	Iterable<Lapin> getAllLapins();
	void deleteLapin(Long idLapin);
	Lapin getLapinById(Long idLapin);

}
