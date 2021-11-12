package pucrs.myflight.modelo;

import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos() throws IOException{
        aeroportos = new ArrayList<>();
        this.carregaDados();
    }

    public void adicionar(Aeroporto aero){
        aeroportos.add(aero);
    }

    public void remover(Aeroporto aero){
        aeroportos.remove(aero);
    }

    public ArrayList<Aeroporto> listarTodos(){
        return this.aeroportos;
    }

    public Aeroporto buscarPorCodigo(String cod){
        for (Aeroporto aero : aeroportos){
            if (aero.getCodigo().equals(cod)){
                return aero;
            }
        }
        return null;
    }

    public void sort(){
        Collections.sort(aeroportos);
    }

    public void carregaDados() throws IOException {
		
		Path pathCias = Paths.get("src/pucrs/myflight/modelo/airports.dat");
		try (Scanner sc = new Scanner(Files.newBufferedReader(pathCias, Charset.forName("utf8")))) {
		sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
		String header = sc.nextLine(); // pula cabeçalho
		String iatacode, airportname, pais;
		while (sc.hasNext()) {
			iatacode = sc.next();
			Double latitude = Double.parseDouble(sc.next());
            Double longitude = Double.parseDouble(sc.next());
            airportname = sc.next();
            pais = sc.next();
            Geo geo = new Geo(latitude, longitude);
			Aeroporto aeroporto = new Aeroporto(iatacode, airportname, geo);
            aeroportos.add(aeroporto);
		}
		}
		catch (IOException x) {
		System.err.format("Erro de E/S: %s%n", x);
		}

	}
}
