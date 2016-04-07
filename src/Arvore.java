
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
	public No busca(int x, No pt){ /*pt, na primeira interação deve ser a raiz da arvore*/
		if (pt == null || pt.getChave() == x)
			return pt;
		if (x < pt.getChave())
			return busca(x, pt.getFilhoDaEsquerda());
		else 
			return busca(x, pt.getFilhoDaDireita());		
	}
	
	public void inserir (No insert){
		
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
