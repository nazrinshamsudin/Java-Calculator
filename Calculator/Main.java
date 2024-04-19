package Calculator;

public class Main {

    public static void main(String[] args){
        int num1 =5;
        int num2 = 7;

        System.out.println("Addition:" + Calculator.add(num1, num2));
        System.out.println("Subtraction:" + Calculator.subtract(num1, num2));
        System.out.println("Multiplication:" + Calculator.multiply(num1, num2));

        try{
            System.out.println("Division:" + Calculator.divide(num1, num2));
        } catch(ArithmeticException e) {
            System.out.println("Error:" + e.getMessage());
        }

    }
















    
}
