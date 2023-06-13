import java.util.HashMap;
import java.util.Scanner;

public class Fibonacci {
    private final int valor;
    private final HashMap<Integer, Integer> fibonacciSeries;
    private Scanner input = new Scanner(System.in);

    // Constructores
    public Fibonacci() {
        this(46);
    }

    public Fibonacci(int valor) {
        this.valor = valor;
        this.fibonacciSeries = new HashMap<>();
        generateFibonacciSeries(valor);
    }

    public int getValorList() {
        System.out.println("Ingrese la posición del número que desea obtener: ");
        int position = input.nextInt();
        int fibonacciNumber = generateFibonacciNumber(position);
        System.out.println("El número que está en la posición " + position + " es: " + fibonacciNumber);
        return fibonacciNumber;
    }

    // Método recursivo para calcular el número de Fibonacci
    public int generateFibonacciNumber(int n) {
        if (fibonacciSeries.containsKey(n)) {
            return fibonacciSeries.get(n);
        } else {
            int fibonacciNumber = generateFibonacciNumber(n - 1) + generateFibonacciNumber(n - 2);
            fibonacciSeries.put(n, fibonacciNumber);
            return fibonacciNumber;
        }
    }

    public void buscarNumeroEnSerie() {
        System.out.println("Qué número desea buscar en la serie de Fibonacci: ");
        int numero = input.nextInt();
        int posicion = buscarPosicionNumero(numero, 0);

        if (posicion != -1) {
            System.out.println("El número " + numero + " se encuentra en la serie de Fibonacci en la posición " + posicion);
        } else {
            System.out.println("El número " + numero + " no se encuentra en la serie de Fibonacci.");
        }
    }

    // Método recursivo para buscar la posición de un número en la serie de Fibonacci
    public int buscarPosicionNumero(int numero, int posicion) {
        if (posicion > valor) {
            return -1;
        }

        int fibonacciNumber = generateFibonacciNumber(posicion);
        if (fibonacciNumber == numero) {
            return posicion;
        } else {
            return buscarPosicionNumero(numero, posicion + 1);
        }
    }

    // Generar la serie de Fibonacci
    public void generateFibonacciSeries(int n) {
        fibonacciSeries.put(0, 0);
        fibonacciSeries.put(1, 1);

        generateFibonacciNumber(n);
    }

    @Override
    public String toString() {
        return "Fibonacci " + valor;
    }
}