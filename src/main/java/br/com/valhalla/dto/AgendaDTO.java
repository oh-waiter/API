package br.com.valhalla.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;



public class AgendaDTO {
	@NotEmpty(message = "O campo NOME não pode ser vazio!")
	private String nome;
	@NotEmpty(message = "O campo CPF não pode ser vazio!")
	private String CPF;
	@Email
	@NotEmpty(message = "O campo EMAIL não pode ser vazio!")
	private String emailTo;
	@FutureOrPresent
	private LocalDate data;
	@FutureOrPresent
	private LocalTime hora;
	@Min(1)
	private Integer qtdPessoas;

}
