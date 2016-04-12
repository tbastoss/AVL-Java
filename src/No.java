
public class No {
	private int chave;
	private int fb;
	private int altura;
	private int alturaSubArDi;
	private int alturaSubArEsq;
	private No filhoDaEsquerda;
	private No filhoDaDireita;
	private No pai;
	
	public No(int chave){
		this.chave = chave;
		this.fb = 0;
		this.altura = 1;
		this.alturaSubArDi = 0;
		this.alturaSubArEsq = 0;
		this.filhoDaEsquerda = null;
		this.filhoDaDireita = null;
		this.pai = null;
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
	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAlturaSubArDi() {
		return alturaSubArDi;
	}

	public void setAlturaSubArDi(int alturaSubArDi) {
		this.alturaSubArDi = alturaSubArDi;
	}

	public int getAlturaSubArEsq() {
		return alturaSubArEsq;
	}

	public void setAlturaSubArEsq(int alturaSubArEsq) {
		this.alturaSubArEsq = alturaSubArEsq;
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
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}
}
