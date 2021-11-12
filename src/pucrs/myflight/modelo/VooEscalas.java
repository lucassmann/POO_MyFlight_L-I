package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo
{
    private Duration duracao;
    private Rota rota;
    private Rota rotaFinal;

    // Construtor
    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime datahora, Duration duracao) {
        super(datahora); // chama o construtor de Voo
        this.rota = rota;
        this.duracao = duracao;
        this.rotaFinal = rotaFinal;
     }

    @Override
    public String toString() {
       return super.getStatus() + " " + super.getDatahora() + "("+this.duracao+"): " + this.rota + " -> " + rotaFinal;
    }

    @Override
    public Rota getRota() { return rotaFinal; }

    @Override
    public Duration getDuracao() {
        return this.duracao;
    }
}