package task4;

public class Task4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Incorrect number of args. Usage: java Task4.java test_file");
        }

        int[] nums = fileReader(args[0]);
        int moves = findMinimum(nums);
        System.out.println(moves);
    }

    private static int[] fileReader(String fileName) {

    }

    private static int findMinimum(int[] nums) {

    }
}
