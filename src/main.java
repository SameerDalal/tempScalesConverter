import java.util.Scanner;

public class main {

    public static void main(String[] args){
        main m = new main();
        m.starterMethod();
    }
    final double KELVIN_FACTOR  = 273.15;
    final double RANKINE_FACTOR = 459.67;

    public void starterMethod(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the unit you would like to convert from: ");
        String from = scan.next();
        char fromUnit = from.charAt(0);

        System.out.println("Enter the unit you would like to convert to: ");
        String to = scan.next();
        char toUnit = to.charAt(0);


        System.out.println("Enter value: ");
        float value = scan.nextFloat();

        goTo(fromUnit,toUnit,value);





    }
    public void goTo(char fromUnit, char toUnit, float value){
        if (fromUnit == 'F' && toUnit == 'C'){
            System.out.println("\n"  + FtoC(value));
        } else if (fromUnit == 'C' && toUnit == 'F'){
            System.out.println("\n" + CtoF(value));
        } else if (fromUnit == 'C' && toUnit == 'K'){
            System.out.println(CtoK(value));
        } else if (fromUnit == 'K' && toUnit == 'C'){
            System.out.println(KtoC(value));
        } else if (fromUnit == 'F' && toUnit == 'R'){
            System.out.println(FtoR(value));
        } else if (fromUnit == 'R' && toUnit == 'F'){
            System.out.println(RtoF(value));
        } else if (fromUnit == 'R' && toUnit == 'K'){
            double convert1 = RtoF(value);
            double convert2 = FtoC(convert1);
            System.out.println(CtoK(convert2));
        } else if (fromUnit == 'K' && toUnit == 'R'){
            double convert1 = KtoC(value);
            double convert2 = CtoF(convert1);
            System.out.println(FtoR(convert2));
        } else if (fromUnit == 'F' && toUnit == 'K'){
            double convert1 = FtoC(value);
            System.out.println(CtoK(convert1));
        } else if (fromUnit == 'K' && toUnit == 'F'){
            double convert1 = KtoC(value);
            System.out.println(CtoF(convert1));
        } else if (fromUnit == 'C' && toUnit == 'R'){
            double convert1 = CtoF(value);
            System.out.println(FtoR(convert1));
        } else if (fromUnit == 'R' && toUnit == 'C'){
            double convert1 = RtoF(value);
            System.out.println(FtoC(convert1));
        }
    }
    public static double FtoC(double value){
        double answer = (((value-32)*5)/9);
        return answer;
    }
    public static double CtoF(double value){
        double answer = (((value*9)/5)+32);
        return answer;
    }
    public double CtoK(double value){
        double answer = value + KELVIN_FACTOR;
        return answer;
    }
    public double KtoC(double value){
        double answer = value - KELVIN_FACTOR;
        return answer;
    }
    public double FtoR(double value){
        double answer = value + RANKINE_FACTOR;
        return answer;
    }
    public double RtoF(double value){
        double answer = value - RANKINE_FACTOR;
        return answer;
    }
}
