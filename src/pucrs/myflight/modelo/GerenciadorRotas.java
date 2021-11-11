package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorRotas {
    private ArrayList<Rota> rotas;

    public GerenciadorRotas(){
        rotas = new ArrayList<>();
    }

    public void adicionar(Rota rota){
        rotas.add(rota);
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
}
