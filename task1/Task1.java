package task1;

public class Task1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Incorrect number of arguments. Usage: java Task1 arg0 arg1");
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int arrayOfNums[] = new int[n];

        for (int i = 1; i <= n; i++) {
            arrayOfNums[i - 1] = i;
        }

        int index = 0;
        int elems[] = new int[n / m];

        for (int i = 0; i < n / m; i++) {
            elems[i] = arrayOfNums[index];
            index = (index + m) % n;
        }
    }
}
