package diyarraylist;

import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){

        DIYarrayList<Integer> listint = new DIYarrayList<>();
        DIYarrayList<Integer> listint2 = new DIYarrayList<>();
        Integer[] elements1 = new Integer[100];
        Integer[] elements2 = new Integer[100];

        for (int i=0; i<100; i++) {
            elements1[i] = i;
            elements2[i]= i+100;
        }

        System.out.println("test addAll");
        System.out.println("listint's size before add: "+listint.size());
        Collections.addAll(listint, elements1);
        System.out.println("listint's size after add: "+listint.size()) ;
        Collections.addAll(listint2, elements2);
        System.out.println("test copy");
        Collections.copy(listint, listint2);
        for(Integer j : listint)
            System.out.println(j);


       System.out.println("test sorting id descent");
        Collections.sort(listint,new Comparator<Integer>(){
            public int compare(Integer e, Integer e1)
            {
                return e > e1 ? -1 : (e == e1 ? 0 : 1);
            }
        });

        for ( Integer j : listint)
            System.out.println(j);

    }
}
