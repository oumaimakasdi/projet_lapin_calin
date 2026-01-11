package pam.tp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pam.tp.model.Proprietaire;

@Repository
public interface IProprietaireRepository extends CrudRepository<Proprietaire, Long>  {
    
}
