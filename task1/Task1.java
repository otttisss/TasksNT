package task1;

public class Task1 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Task1.java <n> <m>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        if (n <= 0 || m <= 0) {
            System.out.println("Error: Both n and m should be greater than 0.");
            return;
        }

        int[] arrayOfNums = new int[n * m];
        int count = 1;
        int currentIndex = 1;
        System.out.print(currentIndex);

        for (int i = 0; i < arrayOfNums.length - 1; i++) {
            if ((i + 1) % m == 0) {
                if (count == 1) {
                    break;
                }
                System.out.print(count);
                arrayOfNums[i] = count;
                i++;
            }
            if (count == n) {
                arrayOfNums[i] = n;
                count = 1;
            } else {
                arrayOfNums[i] = count;
                count++;
            }
        }
        System.out.println();
    }
}
