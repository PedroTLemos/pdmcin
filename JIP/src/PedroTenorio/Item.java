package PedroTenorio;

public class Item {
	
	private String nome;
	private String descricao;
	
	public Item(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
