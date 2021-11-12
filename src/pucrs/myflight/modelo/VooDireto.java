package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo{
    private Duration duracao;
    private Rota rota;
    
    // Construtor
    public VooDireto(Rota rota, LocalDateTime datahora, Duration duracao) {
        super(datahora); // chama o construtor de Voo
        this.rota = rota;
        this.duracao = duracao;
     }

    @Override
    public String toString() {
        return super.getStatus() + " " + super.getDatahora() + "("+this.duracao+"): " + this.rota;
    }

    @Override
    public Rota getRota() {
        return this.rota;
    }

    @Override
    public Duration getDuracao() {
        return this.duracao;
    }
}