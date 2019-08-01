package DynamicConnectivity;

import java.util.Scanner;

public class QuickFindUF {
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
    public QuickFindUF(int N){
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
        return find(p) == find(q);
    }



    public int find(int p){
        return id[p];
    }

    public void union(int p, int q){
        // Объединяем p и q в один компонент
        int pID = find(p);
        int qID = find(q);

        // Если p и q принадлежат одному компоненту то без изменений
        if(pID == qID) return;

        // Компонент переменовывается в q
        for (int i = 0; i < id.length; i++){
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        QuickFindUF dc = new QuickFindUF(N);

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
