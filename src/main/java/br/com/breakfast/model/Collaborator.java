package br.com.breakfast.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="TB_COLLABORATOR")
public class Collaborator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	@Column(length = 11, unique = true)
	private String cpf;
	@OneToMany(mappedBy = "collaborator", targetEntity = BreakfastOptions.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<BreakfastOptions> options;
}
