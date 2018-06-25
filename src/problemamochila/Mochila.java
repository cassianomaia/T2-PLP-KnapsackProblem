package problemamochila;
import java.util.ArrayList;

public class Mochila {
    	public int pesoMax;
	public int peso;
	public ArrayList<Item> items;
	public int lucro;

	public Mochila(int pesoMax, ArrayList<Item> i)
	{
            this.pesoMax = pesoMax;
            this.items = i;
            this.lucro = 0;
	}

	public void setLucro(int lucro) {
            this.lucro = lucro;
	}

	public void setPeso(int w) {
            this.peso = w;
	}

	public void calcularLucro() {
            int counter = 0;
            for(Item i: items)
		counter+=i.lucro;
            this.lucro = counter;
	}

	public void calcularPeso() {
            int counter = 0;
            for(Item i: items) 
		counter+=i.peso;
            this.peso = counter;
        }
}
