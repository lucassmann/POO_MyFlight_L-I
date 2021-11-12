package pucrs.myflight.modelo;

public class Aeronave implements Contavel{
	private String codigo;
	private String descricao;
	private static int count=0;
	
	/**
	 * 
	 * @param codigo código da aeronave.
	 * @param descricao descrição da aeronave. 
	 * 
	 * Os dados utilizados para popular os objetos estão armazenados nos arquivos .dat da pasta data.
	 */
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