package br.com.breakfast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.breakfast.model.BreakfastOptions;
import br.com.breakfast.model.Collaborator;
import br.com.breakfast.repository.BreakfastOptionsRepository;

@RestController
@RequestMapping("/breakFastOptions")
public class BreakFastOptionsController {

	@Autowired
	private BreakfastOptionsRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
    public BreakfastOptions incluirBreakfastOptions(@Validated @RequestBody BreakfastOptions b) {
       return repository.save(b);
    }
}
