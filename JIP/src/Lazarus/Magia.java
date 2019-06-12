public class Magia {
	private String nome;
	private int id;

	public Magia(String nome) {
		this.nome = null;
		this.id = 0;
	}

	public int getid() {
		return this.id;
	}

	public String getnome() {
		return this.nome;
	}

	public void mudar(String novonome) {
		this.nome = novonome;
	}
}