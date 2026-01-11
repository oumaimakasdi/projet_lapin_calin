package pam.tp.dataManagementServices;

import pam.tp.model.Proprietaire;

public interface IProprietaireService {

    public void addPProprietaire(String nom, String prenom, String adresse);

    public Iterable<Proprietaire> getAllProprietaires();

    public void deleteById(Long id);
}
