package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooVariasEscalas extends Voo{

    private Duration duracao;
    private Rota rota;
    private Rota rota2;
    private Rota rota3;
    private Rota rotaFinal;

    // Construtor
    public VooVariasEscalas(Rota rota, Rota rota2, Rota rota3, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
        super(datahora); // chama o construtor de Voo
        this.duracao = duracao;
        this.rotaFinal = rotaFinal;
    }

    @Override
    public String toString() {
        return super.getStatus() + " " + super.getDatahora() + "("+this.duracao+"): " + this.rota + " -> " + rota2 + " -> "+ rota3 + " -> " + rotaFinal;
    }

    
    @Override
    public Rota getRota() { 
            return this.rotaFinal; 
    }

    @Override
    public Duration getDuracao() {
        return this.duracao;
    }    



    // private Rota rotaFinal;

    // // Construtor
    // public VooVariasEscalas(Rota rota, Rota rota2, Rota rota3, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
    //     super(rota, datahora, duracao); // chama o construtor de Voo
    //     this.rota2 = rota2;
    //     this.rota3 = rota3;
    //     this.rotaFinal = rotaFinal;
    //  }

    // public Rota getRotaFinal() { return rotaFinal; }

    // @Override
    // public String toString() {
    //    return super.toString() + " -> " + rota2 + " -> "+ rota3 + " -> " + rotaFinal;
    // }
    
}
