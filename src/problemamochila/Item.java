package problemamochila;

public class Item {
    
    public int numero;
    public int lucro;
    public int peso;

    public Item(int numero, int lucro, int peso) {
	this.numero=numero;
        this.lucro=lucro;
	this.peso=peso;
    }

    public void printItem() {
	System.out.println("Item: " + this.numero + " Lucro: " + this.lucro + " Peso: " + this.peso);
    }
}
