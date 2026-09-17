package Aula17;

public class CalcApp {
    
    public static void main(String[] args) {
        calculadora calc = new  calculadora();

        System.out.println(calc.somar(10, 5));
        System.out.println(calc.somar(3, 4, 5));
        System.out.println(calc.somar(10.5, 6.8));

    }
}

