package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;

    public GerenciadorAeronaves() throws IOException{
        aeronaves = new ArrayList<>();
        this.carregaDados();
    }

    public void adicionar(Aeronave aviao){
        aeronaves.add(aviao);
    }

    public void remover(Aeronave aviao){
        aeronaves.remove(aviao);
    }

    public ArrayList<Aeronave> listarTodas(){
        return this.aeronaves;
    }

    public Aeronave buscarPorCodigo(String cod){
        for(Aeronave aviao : aeronaves){
            if(aviao.getCodigo().equals(cod)){
                return aviao;
            }
        }
        return null;
    }

    public void carregaDados() throws IOException {
		
		Path pathCias = Paths.get("src/pucrs/myflight/data/equipment.dat");
		try (Scanner sc = new Scanner(Files.newBufferedReader(pathCias, Charset.forName("utf8")))) {
		sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
		String header = sc.nextLine(); // pula cabeçalho
		String equipmentid, description, capacity;
		while (sc.hasNext()) {
			equipmentid = sc.next();
            description = sc.next();
            capacity = sc.next();
            Aeronave aero = new Aeronave(equipmentid, description);
            aeronaves.add(aero);
		}
		}
		catch (IOException x) {
		System.err.format("Erro de E/S: %s%n", x);
		}

	}
}
