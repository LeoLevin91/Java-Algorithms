package DynamicConnectivity;

import java.util.Scanner;

public class QuickUnionUF {
    /*
     * Необходимые методы:
     *   +1) Инициализатор компонент
     *   +2) Возврат колличества компонент
     *   3) Добавление связей union
     *   4) Определение идентификатора компоненты find
     *   +5) определение связности connected
     * */

    // Индексация узлами
    private int[] id;
    // Колличество компонент
    private int count;

    // Инициализация узлов
    public QuickUnionUF(int N){
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public int getCount() {
        return count;
    }

    public boolean connected(int p, int q){
        return root(p) == root(q);
    }



    public int root(int p){
        while(p != id[p]){
            p = id[p];
        }
        return  p;
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        id[i] = j;
        count--;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        QuickUnionUF dc = new QuickUnionUF(N);

        while(true){
            int p = scan.nextInt();
            int q = scan.nextInt();
            if(p == -1 || q == -1){
                break;
            }
            if(dc.connected(p, q)) continue;
            dc.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println(dc.getCount() + " компонентов");
    }
}
