package bean;

public class Calculator {
    public static float calculate(float soA, float soB, char phep ){
        switch (phep){
            case '+':
                return soA + soB;
            case '-':
                return soA - soB;
            case '*':
                return soA * soB;
            case '/':
                if(soB != 0)
                    return soA / soB;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
