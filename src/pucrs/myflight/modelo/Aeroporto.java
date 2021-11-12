package pucrs.myflight.modelo;

public class Aeroporto implements Comparable<Aeroporto>{
	private String codigo;
	private String nome;
	private Geo loc;
	
	/**
	 * 
	 * @param codigo código do aeroporto
	 * @param nome nome do aeroporto
	 * @param loc objeto Geo que representa a localização do aeroporto. Um objeto Geo possui 2 variáveis double para representar latitude e longitude.
	 * Aeroporto implementa a interface Comparable<Aeroporto>
	 */
	public Aeroporto(String codigo, String nome, Geo loc) {
		this.codigo = codigo;
		this.nome = nome;
		this.loc = loc;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Geo getLocal() {
		return loc;
	}
	
	/**
	 * O método compareTo da interface Comparable é implementado de forma a comparar a String nome de um objeto Aeroporto.
	 */
	@Override
	public int compareTo(Aeroporto o) {
		return this.getNome().compareTo(o.getNome());
	}
}
