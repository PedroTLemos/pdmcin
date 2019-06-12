package PedroTenorio;

public class ItemConsumivel extends Item{
	
	private String efeito;
	
	public ItemConsumivel(String nome, String descricao, String efeito) {
		super(nome, descricao);
		this.efeito = efeito;
	}
	
	public String getEfeito() {
		return this.efeito;
	}
	
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}
	

}
