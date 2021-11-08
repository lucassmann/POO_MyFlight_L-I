package pucrs.myflight.modelo;

import java.util.ArrayList;

public class GerenciadorCias {
	private ArrayList<CiaAerea> empresas;
	
	public GerenciadorCias() {
		empresas = new ArrayList<>();
	}

	public void adicionar(CiaAerea cia){
		empresas.add(cia);
	}

	public ArrayList<CiaAerea> listarTodas(){
		return this.empresas;
	} 

	//Buscar funciona, mas dá NullPointerException se não encontra. Outra opção seria retornar uma CiaAerea vazia.
	public CiaAerea buscarCodigo(String cod){
		for (CiaAerea cia : empresas){
			if (cia.getCodigo().equals(cod)){
				return cia;
			}
		}
		return null;
	}
	
	//Buscar funciona, mas dá NullPointerException se não encontra. Outra opção seria retornar uma CiaAerea vazia.
	//modelagem especifica argumento cod, mas faria mais sentido chamar de nome
	public CiaAerea buscarNome(String cod){
		for (CiaAerea cia : empresas){
			if (cia.getNome().equals(cod)){
				return cia;
			}
		}
		return null;
	} 	
}
