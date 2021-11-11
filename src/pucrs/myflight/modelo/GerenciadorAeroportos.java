package pucrs.myflight.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class GerenciadorAeroportos {
    private ArrayList<Aeroporto> aeroportos;

    public GerenciadorAeroportos(){
        aeroportos = new ArrayList<>();
    }

    public void adicionar(Aeroporto aero){
        aeroportos.add(aero);
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
}
