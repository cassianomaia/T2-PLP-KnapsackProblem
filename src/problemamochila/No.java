package problemamochila;
import java.util.ArrayList;

public class No {

	//Instance variables
	public int nivel;
	public ArrayList<Item> items;
	public float limite;
	public int lucro;
	public int peso;

	public No(int nivel, int peso, int lucro, ArrayList<Item> items) {	
        this.lucro = lucro;
        this.peso = peso;
        this.nivel=nivel;
        this.items = items;
	}

	public No(int nivel,int peso, int lucro, ArrayList<Item> items, float Limite) {
        this(nivel,peso, lucro,items);
        this.limite = Limite;
	}
        
	public int compararNos(No n) {
        if(this.limite > n.limite)
			return 1;
        else if(this.limite < n.limite)
			return -1;
        return 0;
	}

	public void setLimite(float b) {
		this.limite = b;
	}

	public void printNo() {
		System.out.println("Level: " + this.nivel + "Profit: " + this.lucro + "Weight: " + this.peso + "Bound: " + this.limite);
	}

	public float getLimite(Mochila s) {
		int j;
		int k;
		int pesoTotal;
		float resultado = 0;
		int pesoMax = s.pesoMax;
		ArrayList<Item> itemsMochila = s.items;
		if(this.nivel < 0)
			this.nivel = 0;
		
		//if(itemInKnapsack.get(this.nivel).peso>=pesoMax) {
		if(this.peso >= pesoMax) {
			return 0;
		}

		else {
			resultado = this.lucro;
			j=this.nivel+1;
			pesoTotal = this.peso;

			while( j<itemsMochila.size() && ((pesoTotal + itemsMochila.get(j).peso)<=pesoMax)) {
				pesoTotal += itemsMochila.get(j).peso;
				resultado += itemsMochila.get(j).lucro;
				j++;
			}
			k=j;

			if(k<itemsMochila.size())
				resultado+=(pesoMax-pesoTotal)*itemsMochila.get(k).lucro/itemsMochila.get(k).peso;
			return resultado;
		}
	}
}