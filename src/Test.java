
public class Test {
	public static void main (String[] args){
		No a = new No (45);
		No b = new No (30);
		No c = new No (18);
		No d = new No (3);
		No e = new No (81);
		
		Arvore t = new Arvore (a);
		
		t.inserir_AVL(b);
		t.impressaoEmOrdem(t.getRaiz());
		System.out.println();
		
		t.inserir_AVL(c);
		t.impressaoEmOrdem(t.getRaiz());
		System.out.println();
		System.out.println(t.getNoResponsavel().getChave());
		
		
	}
}
