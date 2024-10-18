package br.itb.tcc.educai;

import br.itb.tcc.educai.model.Laudo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EducaiApplication {

	public static void main(String[] args) {


		SpringApplication.run(EducaiApplication.class, args);

		System.out.println("Hello World - Meu primeiro projeto Educai Spring");

		Laudo p1 = new Laudo();
		
		p1.setRm_aluno(9999);
		p1.validarLaudo();
		System.out.println("Id do aluno: "+ p1.getRm_aluno() + "Informação:"  + p1.getMensagemErro());



	}

}
