package Lab_1;

public class journal_1 {

    static void t1(int[] array) {
        int min, max;
        min = max = array[0];
        System.out.print("\nTask : 1\nValues: [ ");
        for (int valu : array) {
            System.out.print(valu + " ");
            if (min > valu)
                min = valu;
            if (max < valu)
                max = valu;
        }
        System.out.println("]\nMinimum Value : " + min);
        System.out.println("Maximum Value : " + max);
    }
    static void t2(int[] array) {
        System.out.print("\nTask : 2\nBefore: [ ");
        for (int valu : array) {
            System.out.print(valu + " ");
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int a = array[i];
            while ((j > 0) && (array[j - 1] > a)) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = a;
        }
        System.out.print("]\nAfter: [ ");
        for (int valu : array) {
            System.out.print(valu + " ");
        }
        System.out.println("]");
    }
    static void t3() {
        int x=5,y=6;
        System.out.println("\nTask : 3\nBefore");
        System.out.println("X="+x);
        System.out.println("Y="+y);
        x=x+y;
        y=x-y;
        x=x-y;
        System.out.println("\nAfter");
        System.out.println("X="+x);
        System.out.println("Y="+y);
    }
    public static void main(String[] args) {
        int[] array = { 5, 0, 2, 7, 1 };
        t1(array);
        t2(array);
        t3();
    }
}
