import java.util.HashMap;

public class Fibonacci {
    private final int n;
    private final HashMap<Integer, Long> fibonacciSeries;

    public Fibonacci(int n) {
        this.n = n;
        this.fibonacciSeries = new HashMap<>();
    }

    public HashMap<Integer, Long> generateFibonacciSeries() {
        System.out.println("Serie Fibonacci generada con " + n + " numeros");
        for (int i = 0; i <= n; i++) {
            long fibonacciNumber = calculateFibonacci(i);
            fibonacciSeries.put(i, fibonacciNumber);
        }
        return fibonacciSeries;
    }

    private long calculateFibonacci(int num) {
        if (num <= 1) {
            return num;
        } else {
            if (fibonacciSeries.containsKey(num)) {
                return fibonacciSeries.get(num);
            } else {
                long fibonacciNumber = calculateFibonacci(num - 1) + calculateFibonacci(num - 2);
                fibonacciSeries.put(num, fibonacciNumber);
                return fibonacciNumber;
            }
        }
    }

    //ToString
    public String toString() {
        return "Fibonacci{" +
                "n=" + n +
                ", fibonacciSeries=" + fibonacciSeries +
                '}';
    }
}




