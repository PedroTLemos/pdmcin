package Bruno;
public class Pericia {
	private String nome;
	private int ID;
	
	public Pericia(String nome, int ID) {
		this.nome = nome;
		this.ID = ID;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void change(String newinfo) {
		this.nome = newinfo;
	}
}