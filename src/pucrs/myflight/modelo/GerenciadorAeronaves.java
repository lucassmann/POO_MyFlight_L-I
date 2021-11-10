package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorAeronaves {
    private ArrayList<Aeronave> aeronaves;

    public GerenciadorAeronaves(){
        aeronaves = new ArrayList<>();   
    }

    public void adicionar(Aeronave aviao){
        aeronaves.add(aviao);
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
}
