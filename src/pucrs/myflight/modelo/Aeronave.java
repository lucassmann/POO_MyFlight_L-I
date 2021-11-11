package pucrs.myflight.modelo;

public class Aeronave implements Contavel{
	private String codigo;
	private String descricao;
	private static int count=0;
	
	public Aeronave(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
		count++;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}

	@Override
	public int size() {
		return count;
	}
}