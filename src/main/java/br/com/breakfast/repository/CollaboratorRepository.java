package br.com.breakfast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.breakfast.model.Collaborator;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
	
	@Query("select c from Collaborator c where c.cpf = ?1")
	Collaborator consultationCollaborator(String cpf);

}
