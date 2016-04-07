
public class No {
	private int chave;
	private int fb;
	private No filhoDaEsquerda;
	private No filhoDaDireita;
	private No father;
	
	public No(int chave){
		this.chave = chave;
		this.fb = 0;
		this.filhoDaEsquerda = null;
		this.filhoDaDireita = null;
		this.father = null;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getFb() {
		return fb;
	}

	public void setFb(int fb) {
		this.fb = fb;
	}

	public No getFilhoDaEsquerda() {
		return filhoDaEsquerda;
	}

	public void setFilhoDaEsquerda(No filhoDaEsquerda) {
		this.filhoDaEsquerda = filhoDaEsquerda;
	}

	public No getFilhoDaDireita() {
		return filhoDaDireita;
	}

	public void setFilhoDaDireita(No filhoDaDireita) {
		this.filhoDaDireita = filhoDaDireita;
	}

	public No getPai() {
		return father;
	}

	public void setPai(No pai) {
		this.father = pai;
	}
}
