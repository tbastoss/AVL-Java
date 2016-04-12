
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
	
	//Insere o no x na arvore
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
				setNoResponsavel(null);
				setEmpty(false);
			}
			else if(x.getChave() < y.getChave())
				y.setFilhoDaEsquerda(x);
			else if (x.getChave() > y.getChave())
				y.setFilhoDaDireita(x);
		}
		else 
			System.out.println("elemento ja " + x.getChave() + " existente!");
	}
	
	//Calcular Fator de Balanceamento do no p
	public void calcular_fb(No p){
		if (p.getFilhoDaDireita() != null){
			p.setAlturaSubArDi(p.getFilhoDaDireita().getAltura());
		}
		else 
			p.setAlturaSubArDi(0);
		if (p.getFilhoDaEsquerda() != null){
			p.setAlturaSubArEsq(p.getFilhoDaEsquerda().getAltura());
		}
		else 
			p.setAlturaSubArEsq(0);
		p.setFb(p.getAlturaSubArDi() - p.getAlturaSubArEsq());
		p.setAltura(Math.max(p.getAlturaSubArDi(), p.getAlturaSubArEsq()) + 1);
	}
	
	//Rotação Direita
	
	//CASO 1.1: h(p.esq)>h(p.dir) e h(u.esq)>h(u.dir)
	public No rotacionar_dir (No p){
		No u = p.getFilhoDaEsquerda();
		
		p.setFilhoDaEsquerda(u.getFilhoDaDireita());
		if (p.getFilhoDaEsquerda() != null)
			p.getFilhoDaEsquerda().setPai(p);
		u.setFilhoDaDireita(p);
		p.setPai(p.getPai());
		p.setPai(u);
		
		calcular_fb(p);
		calcular_fb(u);
		if (u.getPai() != null){
			if (u.getChave() < u.getPai().getChave()){
				u.getPai().setFilhoDaEsquerda(u);
			}
			else if (u.getChave() > u.getPai().getChave()){
				u.getPai().setFilhoDaDireita(u);
			}
		}
		else 
			setRaiz(u);
		return u;
	}
	
	//CASO 2.1: h(p.esq)<h(p.dir) e h(z.esq)<h(z.dir)
	public No rotacionar_esq (No p){
		return null;
	}
	
	//Inicialmente pt eh raiz
	public void impressaoEmOrdem(No pt){	  
	  if (pt.getFilhoDaEsquerda() != null)
	 
			impressaoEmOrdem(pt.getFilhoDaEsquerda());
		System.out.println(pt.getChave());
		if (pt.getFilhoDaDireita() != null)
			impressaoEmOrdem(pt.getFilhoDaDireita());
	}/**/
	
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
