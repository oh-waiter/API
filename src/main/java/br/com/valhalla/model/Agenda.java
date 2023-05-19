package br.com.valhalla.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.com.valhalla.enuns.StatusEmail;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
@Data
@Entity
public class Agenda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	@NotEmpty(message = "O campo NOME não pode ser vazio!")
	private String nome;
	@NotEmpty(message = "O campo CPF não pode ser vazio!")
	private String CPF;
	@Email
	@NotEmpty(message = "O campo EMAIL não pode ser vazio!")
	private String email_to;
	@FutureOrPresent
	private LocalDate data;
	private LocalTime hora; 
	private LocalDateTime data_agendamento;
	@Min(1)
	private Integer qtd_pessoas;
	private StatusEmail status;
	
	
	

}
