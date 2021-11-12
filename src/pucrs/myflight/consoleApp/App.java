package pucrs.myflight.consoleApp;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import pucrs.myflight.modelo.CiaAerea;
import pucrs.myflight.modelo.GerenciadorAeronaves;
import pucrs.myflight.modelo.GerenciadorAeroportos;
import pucrs.myflight.modelo.GerenciadorCias;
import pucrs.myflight.modelo.GerenciadorRotas;
import pucrs.myflight.modelo.Rota;
import pucrs.myflight.modelo.VooDireto;

/**
 * Projeto myFlight
 * Disciplina de POO
 * @author Lucas Pereira Assmann
 * @author Israel Segalin
*/
public class App {

	/**
	 * O método main testa o projeto, utilizando das classes de modelos, gerenciadores e dados para criar um voo e imprimir uma informação do mesmo no terminal.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("\nMyFlight project...");

		GerenciadorRotas gerRotas = new GerenciadorRotas();
		GerenciadorAeronaves gerAeronaves = new GerenciadorAeronaves();
        GerenciadorAeroportos gerAeroportos = new GerenciadorAeroportos();
        GerenciadorCias gerCias = new GerenciadorCias();
		
		LocalDateTime datahora = LocalDateTime.of(2016, 8, 12, 12, 0, 0);
		Duration duracao = Duration.ofHours(1);
		VooDireto voodir = new VooDireto(gerRotas.listarTodas().get(1), datahora, duracao);
		System.out.println(voodir.getRota().getCia().getNome()); //FUNCIONA!!!!!!!!  \o/
		
	}
}