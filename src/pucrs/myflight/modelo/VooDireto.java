package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo{
    
    // Construtor
    public VooDireto(Rota rota, LocalDateTime datahora, Duration duracao) {
        super(rota, datahora, duracao); // chama o construtor de Voo
     }

    @Override
    public String toString() {
       return super.toString();
    }
}