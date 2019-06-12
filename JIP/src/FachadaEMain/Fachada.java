package FachadaEMain;
import Bruno.*;
import Didier.*;
import Lazarus.*;
import Nilo.*;
import PedroTenorio.*;

public class Fachada {
	
	private CadastroTracos tracos;
	private CadastrarPericia pericias;
	private CadastroAtributos atributos;
	private CadastroItens itens;
	private CadastrarMagia magias;
	
	public void cadastrarTraco(Traco traco) throws TracoJaCadastradoException{
		if(!this.tracos.existe(traco.getNome())) {
			this.tracos.cadastrar(traco);
		}
		else {
			throw new TracoJaCadastradoException(traco.getNome());
		}
	}
	
	public void removerTraco(String nome) throws TracoNaoEncontradoException {
		this.tracos.remover(nome);
	}
	
	public void atualizarTraco(Traco traco) throws TracoNaoEncontradoException{
		this.tracos.atualizar(traco);
	}
	
	public boolean existeTraco(String nome) {
		return this.tracos.existe(nome);
	}
	
	public Traco procurarTraco(String nome) throws TracoNaoEncontradoException{
		return this.tracos.procurar(nome);
	}
	
	public void cadastrarPericia(String info) throws JCException {
		this.pericias.cadastrar(info);
	}
	
	public void removerPericia(String info) throws NEException {
		this.pericias.remove(info);
	}
	
	public boolean existePericia(String info) {
		return this.pericias.existe(info);
	}
	
	public void atualizarPericia(Pericia informacaoAtualizada) throws NEException{
		this.pericias.atualizar(informacaoAtualizada);
	}
	
	public Pericia procurarPericia(String info) throws NEException {
		return this.pericias.procurar(info);
	}
	
	public void cadastrarAtributo(Atributo atributo) throws AtributoJaCadastradoException{
		if(!this.atributos.existe(atributo.getNome())) {
			this.atributos.cadastrar(atributo);
		}else {
			throw new AtributoJaCadastradoException(atributo);
		}
	}
	
	public void atributo_dizerClasseERaca(String classe, String raca) throws CNEException, ANEException{
		this.atributos.dizerClasseERaca(classe, raca);
	}
	
	public void atualizar(Atributo atributo) throws ANEException{
		this.atributos.atualizar(atributo);
	}
	
	public void removerAtributo(String atributo) throws ANEException{
		this.atributos.remover(atributo);
	}
	
	public void procurarAtributo(String atributo) throws ANEException{
		this.atributos.procurar(atributo);
	}
	
	public boolean existeAtributo(String nome) {
		return this.atributos.existe(nome);
	}
	
	public String saidaAtributo(String inicial) {
		return this.atributos.saida(inicial);
	}
	
	public void cadastrarItem(Item item) throws ItemJaCadastradoException{
		if(!this.itens.existe(item.getNome())) {
			this.itens.cadastrar(item);
		} else {
			throw new ItemJaCadastradoException();
		}
	}
	
	public void atualizarItem(Item item) throws ItemNaoEncontradoException{
		this.itens.atualizar(item);
	}
	
	public void removerItem(String nome) throws ItemNaoEncontradoException{
		this.itens.remover(nome);
	}
	
	public void procurarItem(String nome) throws ItemNaoEncontradoException{
		this.itens.procurar(nome);
	}
	
	public boolean existeItem(String nome) {
		return this.itens.existe(nome);
	}
	
	public void cadastrarMagia(Magia magia) throws MagiaJaExistenteException {
		if (this.magias.existe(magia.getnome())) {
			throw new MagiaJaExistenteException(magia.getnome());
		}
		this.magias.cadastrar(magia);
	}
	
	public Magia procurarMagia(String nome) throws MagiaNaoEncontradaException {
		return this.magias.procurar(nome);
	}
	
	public void removerMagia(String nome) throws MagiaNaoEncontradaException {
		this.magias.remover(nome);
	}
	
	public boolean existe(String nome){
		return this.magias.existe(nome);
	}
	
	public void atualizarMagia(Magia magianova) throws MagiaNaoEncontradaException {
		this.magias.atualizar(magianova);
	}
}
