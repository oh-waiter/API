package br.com.valhalla.service;

import java.time.LocalDateTime;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.valhalla.enuns.StatusEmail;
import br.com.valhalla.model.Agenda;
import br.com.valhalla.repository.AgendaRepository;


@Service
public class AgendaService {
	
	@Autowired
	AgendaRepository repository;
	
	
	@Autowired
	JavaMailSender mailSender;
	
	public Agenda create(Agenda obj) {
		String destinatario1 = obj.getEmail_to();
		String assunto = "Horário Agendado";
		String mensagen1 = "Sua reserva para o Dia: "+obj.getData()+ 
				" e no seguinte Horário: "+ obj.getHora()+"."+"\n"+
		" Foi agendada com sucesso,"
				+ "aguarde a confirmação de sua mesa.";
		String mensagen2 = "O cliente,/n"+ obj.getNome()+ "portador do CPF: "+ obj.getCPF()+ "./n"+
				"Agendou uma mesa com capacidade de "+obj.getQtd_pessoas()+ " cadeiras" + "para a seguinte Data: "
				+obj.getData()+ " e seguinte Horário:"+obj.getHora()+ ".";

		try {
			obj.setData_agendamento(LocalDateTime.now());
			enviarEmail(destinatario1, assunto, mensagen1);
			obj.setStatus(StatusEmail.SENT);
		} catch (MailException e) {
			obj.setStatus(StatusEmail.ERROR);
		}
		return repository.save(obj);
	}
	
	//public Agenda agendarReservaDeMesa(Agenda agenda) {
	//	SimpleMailMessage msg = new SimpleMailMessage();
	//	agenda.setNome(agenda.getNome());
	//	agenda.setCPF(agenda.getCPF());
	//	agenda.setEmail_to(agenda.getEmail_to());
	//	agenda.setData_hora(agenda.getData_hora());
	//	agenda.setQtd_pessoas(agenda.getQtd_pessoas());
	//	String destinatario1 = agenda.getEmail_to();
	//	String destinatario2 = msg.getFrom();
	//	String assunto = "Horário Agendado";
	//	String mensagen1 = "Sua reserva para o Dia e hoário: "+agenda.getData_hora()+ "."+"/n Foi agendada com sucesso,"
	//			+ "aguarde a confirmação de sua mesa.";
	//	String mensagen2 = "O cliente,/n"+ agenda.getNome()+ "portador do CPF: "+ agenda.getCPF()+ "./n"+
	//			"Agendou uma mesa com capacidade de "+agenda.getQtd_pessoas()+ " cadeiras" + "para a seguinte Data e hora: "
	//			+agenda.getData_hora()+ ".";
	//	enviarEmail(destinatario1, assunto, mensagen1);
	//	enviarEmail(destinatario2, assunto, mensagen2);
	//	return repository.save(agenda);
		
	//}
	
	private void enviarEmail(String email, String assunto, String mensagem) {
			SimpleMailMessage msg = new SimpleMailMessage();
			msg.setTo(email);
			msg.setSubject(assunto);
			msg.setText(mensagem);
			mailSender.send(msg);
		
	}
	
	

}
