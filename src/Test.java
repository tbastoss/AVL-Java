
public class Test {
	public static void main (String[] args){
		No a = new No (45);
		No b = new No (30);
		No c = new No (18);
		No d = new No (60);
		No e = new No (81);
		No f = new No (36);
		No g = new No (101);
		No h = new No (5);
		No i = new No (8);
		No j = new No (3);
		No k = new No (6);
		
		Arvore t = new Arvore (a);
		
		t.inserir_AVL(b);
		t.inserir_AVL(c);
		t.inserir_AVL(d);
		t.inserir_AVL(e);
		t.inserir_AVL(f);
		t.inserir_AVL(g);
		t.inserir_AVL(h);
		t.inserir_AVL(i);
		t.inserir_AVL(j);
		//t.inserir_AVL(k);
		
		
		
		t.impressaoEmOrdem(t.getRaiz());
		System.out.println();
		System.out.println(t.getRaiz().getChave());
		
		
	}
}
