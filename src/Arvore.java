
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
	private No inserir (No x){
		No retorno = null;
		No y = null;
		No pt = busca(x.getChave());
		if (pt == null){
			retorno = x;
			pt = getRaiz();
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
			return retorno;
		}
		else 
			return retorno;
	}
	
	//Procedimento para inserir na AVL
	public boolean inserir_AVL(No x){
		No pt = inserir(x);
		boolean retorno = false;
		boolean desregulou;
		if (pt != null){
			desregulou = verificar_fb_no(pt.getPai());
			if (desregulou == false)
				return true;
			else if (desregulou == true){
				if (getNoResponsavel().getFb() == -2){ /*CASO 1*/
						/*if(getNoResponsavel().getFilhoDaEsquerda().getAltura() > getNoResponsavel().getFilhoDaDireita().getAltura() && getNoResponsavel().getFilhoDaEsquerda().getFilhoDaEsquerda().getAltura() > getNoResponsavel().getFilhoDaEsquerda().getFilhoDaDireita().getAltura()) //Rotação Direita        h(p.esq)>h(p.dir) e h(u.esq)>h(u.dir))
							rotacionar_dir(getNoResponsavel());
						else if (getNoResponsavel().getFilhoDaEsquerda().getAltura() > getNoResponsavel().getFilhoDaDireita().getAltura() && getNoResponsavel().getFilhoDaEsquerda().getFilhoDaEsquerda().getAltura() < getNoResponsavel().getFilhoDaEsquerda().getFilhoDaDireita().getAltura()) // Rotação Direita Dupla    h(p.esq)>h(p.dir) e h(u.esq)<h(u.dir)
							rotacionar_dir_dup(getNoResponsavel());/**/
						if (getNoResponsavel().getFilhoDaEsquerda().getFb() == 1) //rotação direita dupla
							rotacionar_esq(getNoResponsavel().getFilhoDaEsquerda());
						setNoResponsavel(rotacionar_dir(getNoResponsavel()));
				}
				else if (getNoResponsavel().getFb() == 2){ //CASO 2
					/*if(getNoResponsavel().getFilhoDaEsquerda().getAltura() < getNoResponsavel().getFilhoDaDireita().getAltura() && getNoResponsavel().getFilhoDaDireita().getFilhoDaEsquerda().getAltura() < getNoResponsavel().getFilhoDaDireita().getFilhoDaDireita().getAltura()) //Rotação Esquerda h(p.esq)<h(p.dir) e h(z.esq)<h(z.dir)
						rotacionar_esq(getNoResponsavel());
					else if(getNoResponsavel().getFilhoDaEsquerda().getAltura() < getNoResponsavel().getFilhoDaDireita().getAltura() && getNoResponsavel().getFilhoDaDireita().getFilhoDaEsquerda().getAltura() > getNoResponsavel().getFilhoDaDireita().getFilhoDaDireita().getAltura()) //Rotação Dupla Esquerda h(p.esq)<h(p.dir) e h(z.esq)>h(z.dir)
						rotacionar_esq_dup(getNoResponsavel());/**/
					if (getNoResponsavel().getFilhoDaDireita().getFb() == -1)
						rotacionar_dir(getNoResponsavel().getFilhoDaDireita());
					setNoResponsavel(rotacionar_esq(getNoResponsavel()));/**/
				}
				retorno = verificar_fb_no(pt.getPai()); /**POSSÍVEL PROBLEMA  -> trocar pt por "getNoResponsavel()"*/
			}
		}
		return retorno;
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
	
	//Verificação do Balanceamento da AVL
	public boolean verificar_fb_no(No pt){ /**Onde devo colocar pra ele setar o nó responsável pra poder usar nas rotação?*/
		if (pt == null)
			return false;
		else 
			calcular_fb(pt);
		if (pt.getFb() < -1 || pt.getFb() > 1){
			setNoResponsavel(pt);
			return true;			
		}
		else {
			//if (pt.getFb() < -2 || pt.getFb() > 2)
				//setNoResponsavel(pt);
			pt = pt.getPai();
			return verificar_fb_no(pt);
		}
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
	
	//Rotação Esquerda
	//CASO 2.1: h(p.esq)<h(p.dir) e h(z.esq)<h(z.dir)
	public No rotacionar_esq (No p){
		No z = p.getFilhoDaDireita();
		
		p.setFilhoDaDireita(z.getFilhoDaEsquerda());
		if (p.getFilhoDaDireita() != null)
			p.getFilhoDaDireita().setPai(p);
		z.setFilhoDaEsquerda(p);
		z.setPai(p.getPai());
		p.setPai(z);
		
		calcular_fb(p);
		calcular_fb(z);
		if(z.getPai() != null){
			if (z.getChave() > z.getPai().getChave())
				z.getPai().setFilhoDaDireita(z);
			else if (z.getChave() < z.getPai().getChave())
				z.getPai().setFilhoDaEsquerda(z);
		}
		else 
			setRaiz(z);
		return z;
	}
	
	//Rotação Dupla Direita
	//CASO 1.2: h(p.esq)>h(p.dir) e h(u.esq)<h(u.dir)
	public No rotacionar_dir_dup(No p){
		No retorno = null;
		No u = p.getFilhoDaEsquerda();
		rotacionar_esq(u);
		retorno = rotacionar_dir(p);
		return retorno;
	}
	
	//Rotação Dupla Esquerda
	//CASO 2.2: h(p.esq)<h(p.dir) e h(z.esq)>h(z.dir)
	public No rotacionar_esq_dup(No p){
		No retorno = null;
		No z = p.getFilhoDaDireita();
		rotacionar_dir(z);
		retorno = rotacionar_esq(p);
		return retorno;
	}
	
	//Inicialmente pt eh raiz
	public void impressaoEmOrdem (No pt){	  
	  if (pt.getFilhoDaEsquerda() != null)
		impressaoEmOrdem(pt.getFilhoDaEsquerda());
	  System.out.print(pt.getChave() + "(" + pt.getFb() + ")");
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
