package Practica010;

public class Potencia {

    public int solution(int N, int exponente){
        int expo = (int) Math.pow(2, exponente);
        if (N % Math.pow(2, exponente) == 0){
            return N / expo;
        }else {
            return -2;
        }
    }

    public static void main(String[] args) {
        Potencia potencia = new Potencia();
        System.out.println(potencia.solution(24, 3));
    }
}
