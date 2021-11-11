package pucrs.myflight.consoleApp;

import java.io.IOException;

import pucrs.myflight.modelo.Geo;
import pucrs.myflight.modelo.GerenciadorCias;

public class App {

	public static void main(String[] args) throws IOException {
		System.out.println("\nMyFlight project...");


		GerenciadorCias.carregaDados("airlines.dat");
	}
}