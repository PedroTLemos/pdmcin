package PedroTenorio;

public class ItemArmadura extends Item{
	
	private int incremento;
	private String efeito;
	
	public ItemArmadura(String nome, String descricao, int incremento, String efeito) {
		super(nome, descricao);
		this.incremento = incremento;
		this.efeito = efeito;
	}
	
	public int getIncremento() {
		return this.incremento;
	}
	
	public String getEfeito() {
		return this.efeito;
	}
	
	public void setIncremento(int incremento) {
		this.incremento = incremento;
	}
	
	public void setEfeito(String efeito) {
		this.efeito = efeito;
	}

}
