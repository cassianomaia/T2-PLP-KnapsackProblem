package problemamochila;
import java.util.ArrayList;

public class main {
    public static void main(String[] argv) {
        int pesoTotal=0;
        Item item1 = new Item(1, 100, 14);
        Item item2 = new Item(2,  22,  8);
        Item item3 = new Item(3,  30,  6);
        Item item4 = new Item(4, 100, 10);
        Item item5 = new Item(5,  40, 12);
        Item item6 = new Item(6,  50, 20);
        Item item7 = new Item(7,  40, 15);
        Item item8 = new Item(8,  30, 20);
        ArrayList<Item> lista = new ArrayList<Item>(9);
        lista.add(0, new Item(0,0,0)); //Item zero nunca é utilizado
        lista.add(1, item1);
        lista.add(2, item2);
        lista.add(3, item3);
        lista.add(4, item4);
        lista.add(5, item5);
        lista.add(6, item6);
        lista.add(7, item7);
        lista.add(8, item8);
        
        Mochila m = new Mochila(70, lista);
        
        
        System.out.print("Resolução com programação dinâmica:\n\n");
        ProgramacaoDinamica solucao_pd = new ProgramacaoDinamica(m);
        Mochila solucao_final_pd = solucao_pd.ResolucaoDinamica();
        System.out.println("Items na mochila:");
        for(Item i: solucao_final_pd.items) {
            i.printItem();
            pesoTotal+=i.peso;
        }
        System.out.println("Lucro Total: " + solucao_final_pd.lucro);
        System.out.println("Peso total:"+pesoTotal);

        //-----------------------------------------------------//
        pesoTotal = 0;
        System.out.print("\n\nResolução com algoritmo guloso:\n\n");
        BestFirst solucao_best = new BestFirst(m);
        No solucao_final_bestfirst = solucao_best.ResolucaoBestFirst();
        System.out.println("Items na mochila:");
        for(Item i: solucao_final_bestfirst.items) {
            i.printItem();
            pesoTotal+=i.peso;
        }
        System.out.println("Lucro Total: " + solucao_final_bestfirst.lucro);
        System.out.println("Peso total:"+pesoTotal);
    }
}
