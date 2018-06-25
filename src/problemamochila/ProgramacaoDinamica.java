package problemamochila;
import java.util.ArrayList;

public class ProgramacaoDinamica {
    public Mochila m;
    
    public ProgramacaoDinamica(Mochila m)
    {   
    	this.m = m;
    }
    
    public Mochila ResolucaoDinamica() {
       ArrayList<Item> items = m.items; 
       m.items = new ArrayList<Item>();
       
       int[][] solucao_otima = new int[items.size()][m.pesoMax+1];
       int[][] items_solucao_otima = new int[items.size()][m.pesoMax+1];
       
       solucao_otima[0][0] = 0;
        for(int a = 0; a < m.pesoMax; a++) {
            solucao_otima[0][a] = 0;
        }
        
        for(int i = 1; i < solucao_otima.length; i++) {
            for(int j = 1; j < solucao_otima[i].length; j++) {
            	if(items.get(i).peso <= j && items.get(i).lucro + solucao_otima[i-1][j-items.get(i).peso] >= solucao_otima[i-1][j]) {
                    solucao_otima[i][j] = (items.get(i).lucro + solucao_otima[i-1][j-items.get(i).peso]);
                    items_solucao_otima[i][j] = 1;
		}
    		else {
                    solucao_otima[i][j] = solucao_otima[i-1][j];
                    items_solucao_otima[i][j] = 0;
                }
            }
        }
        int peso = m.pesoMax;
    	int contador = 0;
    	for(int i = items.size()-1; i >= 0 ; i--) {
    		if(items_solucao_otima[i][peso] == 1) {
                m.items.add(items.get(i));
                peso -= items.get(i).peso;
                contador += items.get(i).peso;
    		}
    	}
    	m.setLucro(solucao_otima[items.size()-1][m.pesoMax]);
        return m;
    }
}
