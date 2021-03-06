package pucrs.myflight.modelo;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() throws IOException {
		empresas = new ArrayList<>();
		this.carregaDados();
	}

	public void adicionar(CiaAerea cia){
		empresas.add(cia);
	}

	public void remover(CiaAerea cia){
		empresas.remove(cia);
	}

	public ArrayList<CiaAerea> listarTodas(){
		return this.empresas;
	} 

	//Buscar funciona, mas dá NullPointerException se não encontra. Outra opção seria retornar uma CiaAerea vazia.
	public CiaAerea buscarCodigo(String cod){
		for (CiaAerea cia : empresas){
			if (cia.getCodigo().equals(cod)){
				return cia;
			}
		}
		return null;
	}
	
	//Buscar funciona, mas dá NullPointerException se não encontra. Outra opção seria retornar uma CiaAerea vazia.
	//modelagem especifica argumento cod, mas faria mais sentido chamar de nome
	public CiaAerea buscarNome(String cod){
		for (CiaAerea cia : empresas){
			if (cia.getNome().equals(cod)){
				return cia;
			}
		}
		return null;
	} 	

	public void carregaDados() throws IOException {
		
		Path pathCias = Paths.get("src/pucrs/myflight/data/airlines.dat");
		try (Scanner sc = new Scanner(Files.newBufferedReader(pathCias, Charset.forName("utf8")))) {
		sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
		String header = sc.nextLine(); // pula cabeçalho
		String airlineid, airlinename;
		GerenciadorAeronaves gerAero = new GerenciadorAeronaves();
		gerAero.carregaDados();
		while (sc.hasNext()) {
			airlineid = sc.next();
			airlinename = sc.next();
			CiaAerea cia = new CiaAerea(airlineid, airlinename);
			empresas.add(cia);
		}
		}
		catch (IOException x) {
		System.err.format("Erro de E/S: %s%n", x);
		}

	}
}
