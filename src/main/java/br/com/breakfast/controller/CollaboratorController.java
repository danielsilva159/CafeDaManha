package br.com.breakfast.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.breakfast.model.Collaborator;
import br.com.breakfast.repository.CollaboratorRepository;

@RestController
@RequestMapping("/collaborator")
public class CollaboratorController {

	@Autowired
	private CollaboratorRepository collaborator;
	
	@GetMapping
    public List<Collaborator> listCollaborators() {
        return collaborator.findAll();
    }
	
	@GetMapping("/{idCollaborator}")
    public Optional<Collaborator> detailsCollaborator(@Validated @PathVariable long idCollaborator) {
        return collaborator.findById(idCollaborator);
    }
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public String  includeCollaborator(@Validated @RequestBody Collaborator c) {
		Collaborator co = collaborator.consultationCollaborator(c.getCpf());
		if(co == null) {
		 collaborator.save(c);
		 return "Colaborador salvo com sucesso";
		}else {
			return "Esse CPF já está cadastrado na base de dados com o usuário " + co.getName();
			
		}
    }
	
	@PutMapping("{id}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody Collaborator c) {
		System.out.println(c);
		collaborator.findById(id).map(co ->{
			c.setId(co.getId());
			c.getOptions().forEach(option -> option.setCollaborator(c));
			return collaborator.save(c);
			
		});
	}
	
	
	
	

}
