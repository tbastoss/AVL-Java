
public class Test {
	public static void main (String[] args){
		No a = new No (6);
		No b = new No (3);
		No c = new No (4);
		No d = new No (9);
		No e = new No (7);
		
		Arvore t = new Arvore (a);
		
		t.inserir(b);
		t.inserir(c);
		t.inserir(d);
		t.inserir(e);	
		
		t.impressaoEmOrdem(t.getRaiz());
		
		No erro = new No (7);
		t.inserir(erro);
		
		t.impressaoEmOrdem(t.getRaiz());
	}
}
