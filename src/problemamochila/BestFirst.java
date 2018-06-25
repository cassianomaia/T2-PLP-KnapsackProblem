package problemamochila;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirst {
	PriorityQueue<No> q;
	Mochila s;
	public BestFirst(Mochila s) {
		this.q = new PriorityQueue<No>();
		this.s = s;
	}

	public No ResolucaoBestFirst() {
		ArrayList<Item> itemsMochila = s.items;
		int numItems=itemsMochila.size();
		int pesoMax = s.pesoMax;
		int lucroMax = 0;

		No v = new No(0,0,0,new ArrayList<Item>());
		No u;

		v.setLimite(v.getLimite(this.s));
		No lucroMaxNo = v;

		q.add(v);
		while(!(q.isEmpty())) {
			ArrayList<Item> nosPais = new ArrayList<Item>();

			No tempNo = q.peek();
			q.remove();

			if(tempNo.limite > lucroMax)
			{

				nosPais.addAll(tempNo.items);

				u = new No(tempNo.nivel+1,tempNo.peso + itemsMochila.get(tempNo.nivel+1).peso , tempNo.lucro + itemsMochila.get(tempNo.nivel+1).lucro, nosPais);

				u.setLimite(u.getLimite(this.s));  	

				u.items.add(itemsMochila.get(u.nivel));
				if(u.peso <= pesoMax && u.lucro > lucroMax) {	
					lucroMax = u.lucro;
					lucroMaxNo = u;
				}

				if(u.limite > lucroMax && u.nivel < numItems-1) {
					q.add(u);
				}

				tempNo.nivel++;
				tempNo.setLimite(tempNo.getLimite(this.s));
                                
				//if(tempNo.limite > lucroMax && u.nivel < numItems-1) {
				//	q.add(tempNo);
				//}
			}
		}
		return lucroMaxNo;
	}
}