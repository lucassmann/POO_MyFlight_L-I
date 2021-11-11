package pucrs.myflight.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class GerenciadorVoos {
    private ArrayList<Voo> voos;

    public GerenciadorVoos(){
        voos = new ArrayList<>();
    }

    public void adicionar(Voo voo){
        voos.add(voo);
    }

    public void remover(Voo voo){
        voos.remove(voo);
    }

    public ArrayList<Voo> listarTodos(){
        return this.voos;
    }

    public ArrayList<Voo> buscarData(LocalDate data){
       ArrayList<Voo> aux = new ArrayList<>();
       for(Voo voo : voos){
           if(voo.getDatahora().toLocalDate().equals(data)){
               aux.add(voo);
           }
       }
       return aux;
        
    }

    
}
