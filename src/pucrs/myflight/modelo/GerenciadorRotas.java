package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    public GerenciadorRotas() throws IOException{
        rotas = new ArrayList<>();
        this.carregaDados();
    }

    public void adicionar(Rota rota){
        rotas.add(rota);
    }

    public void remover(Rota rota){
        rotas.remove(rota);
    }

    public ArrayList<Rota> listarTodas(){
        return this.rotas;
    }

    public ArrayList<Rota> buscarPorOrigem(Aeroporto orig){
        ArrayList<Rota> aux = new ArrayList<>();
        for(Rota rota : rotas){
            if(rota.getOrigem().getCodigo().equals(orig.getCodigo())){
                aux.add(rota);
            }
        }
        return aux;
    }

    public void sort(){
        Collections.sort(rotas);
    }

    public void carregaDados() throws IOException {
		GerenciadorAeronaves gerAeronaves = new GerenciadorAeronaves();
        GerenciadorAeroportos gerAeroportos = new GerenciadorAeroportos();
        GerenciadorCias gerCias = new GerenciadorCias();
		Path pathCias = Paths.get("src/pucrs/myflight/data/routes.dat");
		try (Scanner sc = new Scanner(Files.newBufferedReader(pathCias, Charset.forName("utf8")))) {
		sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
		String header = sc.nextLine(); // pula cabeçalho
		String airline, from, to, codeshare, stops, equipment;
		while (sc.hasNext()) {
			airline = sc.next();
			from = sc.next();
            to = sc.next();
            codeshare = sc.next();
            stops = sc.next();
            equipment = sc.next();
            if(equipment.contains(" ")){
                String[] listaAvioes = equipment.split(" ");
                for (int i = 0; i >= Arrays.asList(listaAvioes).size(); i++){
                    CiaAerea ciaAux = gerCias.buscarCodigo(airline);
                    Aeroporto aeroportoFromAux = gerAeroportos.buscarPorCodigo(from);
                    Aeroporto aeroportoToAux = gerAeroportos.buscarPorCodigo(to);
                    Aeronave aeronaveAux = gerAeronaves.buscarPorCodigo(listaAvioes[i]);
                    Rota rotaAux = new Rota(ciaAux, aeroportoFromAux, aeroportoToAux, aeronaveAux);
                    this.rotas.add(rotaAux);

                }
            }
            else{
                CiaAerea ciaAux = gerCias.buscarCodigo(airline);
                Aeroporto aeroportoFromAux = gerAeroportos.buscarPorCodigo(from);
                Aeroporto aeroportoToAux = gerAeroportos.buscarPorCodigo(to);
                Aeronave aeronaveAux = gerAeronaves.buscarPorCodigo(equipment);
                Rota rotaAux = new Rota(ciaAux, aeroportoFromAux, aeroportoToAux, aeronaveAux);
                this.rotas.add(rotaAux);
            }
		}
		}
		catch (IOException x) {
		System.err.format("Erro de E/S: %s%n", x);
		}

	}
}
