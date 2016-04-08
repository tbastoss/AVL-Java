
public class Arvore {
	private No no;
	private No raiz;
	private No noResponsavel;
	private boolean isEmpty;	
	
	public Arvore (No no){
		this.no = no;
		this.raiz = this.no;
		this.noResponsavel = null;
		this.isEmpty = false;
	}

	/*busca atraves da chave do nó*/
	public No busca(int x){
		No pt = this.raiz;
		while (pt != null && pt.getChave() != x){
			if (x < pt.getChave())
				pt = pt.getFilhoDaEsquerda();
			else if (x > pt.getChave())
				pt = pt.getFilhoDaDireita();
		}
		return pt;		
	}
	
	public void inserir (No x){
		No y = null;
		No pt = this.raiz;
		if (busca(x.getChave()) == null){
			while (pt != null){
				y = pt;
				if (x.getChave() < pt.getChave())
					pt = pt.getFilhoDaEsquerda();
				else if (x.getChave() > pt.getChave())
					pt = pt.getFilhoDaDireita();
			}
			x.setPai(y);
			if (y == null){
				setRaiz(x);
				setNo(x);
				setEmpty(false);
			}
			else if(x.getChave() < y.getChave())
				y.setFilhoDaEsquerda(x);
			else if (x.getChave() > y.getChave())
				y.setFilhoDaDireita(x);
		}
	}
	
	public void impresaoEmOrdem(){
		
	}
	
	public No getNo() {
		return no;
	}

	public void setNo(No no) {
		this.no = no;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public No getNoResponsavel() {
		return noResponsavel;
	}

	public void setNoResponsavel(No noResponsavel) {
		this.noResponsavel = noResponsavel;
	}

	public boolean isEmpty() {
		return isEmpty;
	}

	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}
}
