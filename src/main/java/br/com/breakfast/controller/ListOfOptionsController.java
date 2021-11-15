package br.com.breakfast.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.breakfast.model.ListOfOptions;
import br.com.breakfast.repository.ListOfOptionsRepository;

@RestController
@RequestMapping("/listofoptions")
public class ListOfOptionsController {

	@Autowired
	private ListOfOptionsRepository repository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ListOfOptions salvar(@RequestBody @Valid ListOfOptions option) {
		System.out.println(option);
		return repository.save(option);
	}
	
	@GetMapping
    public List<ListOfOptions> listCollaborators() {
        return repository.findAll();
    }
}
