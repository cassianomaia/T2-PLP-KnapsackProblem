/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemamochila;

import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 *
 * @author Cassiano Maia
 */
public class AlgGuloso {
    public Mochila m;
    public AlgGuloso(Mochila m)
    {   
    	this.m = m;
    }
    public Mochila ResolucaoGuloso() {

        HeapSort h = new HeapSort();
        int[] OGPrices = Arrays.copyOf(prices, numItems);

        h.heapSort(prices);
//        System.out.println(Arrays.toString(prices));

        //rearrange weight list accordingly
        orderedWeights = newWeights(prices, OGPrices, weight, numItems);
//        System.out.println(Arrays.toString(orderedWeights));

        //fill the knapsack using the greedy idea
        currentWeight = 0;
        int w =0;
        while(currentWeight <= capacity && w < numItems){
            if(orderedWeights[w] <= (capacity - currentWeight)) {
//                    System.out.print(prices[w] + " ");
                currentWeight += orderedWeights[w];
                maxValue += prices[w];

            }
            w++;
        }
        return maxValue;
    }

    public static int[] newWeights(int[] newPrices, int[] OGPrices, int[] weight, int numItems){
        for(int j = 0; j < numItems; j++){
            int i = 0;
            boolean found = false;
            while (!found && i <numItems){
                if(newPrices[j] == OGPrices[i]){
                    OGPrices [i] = Integer.MAX_VALUE;
                    orderedWeights[j] = weight[i];
                    found = true;
                }
                i++;
            }
        }
        return orderedWeights;
    }
}
