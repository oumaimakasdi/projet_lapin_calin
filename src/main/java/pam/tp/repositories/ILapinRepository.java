package pam.tp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pam.tp.model.Lapin;

@Repository
public interface ILapinRepository extends CrudRepository<Lapin, Long>  {
	
}
