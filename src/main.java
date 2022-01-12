import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        main m = new main();
        m.starterMethod();

    }

    final double KELVIN_FACTOR = 273.15;
    final double RANKINE_FACTOR = 459.67;

    public void starterMethod() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the unit you would like to convert from: ");
        String from = scan.next();
        char fromUnit = from.charAt(0);

        System.out.println("Enter the unit you would like to convert to: ");
        String to = scan.next();
        char toUnit = to.charAt(0);


        System.out.println("Enter value: ");
        float value = scan.nextFloat();
        scan.close();

        char[] index = {'R', 'F', 'C', 'K'};
        int coord1 = 0;
        for (int i = 0; i < 4; i++) {
            if (fromUnit == index[i]) {
                coord1 = i;
            }
        }
        int coord2 = 0;
        for (int j = 0; j < 4; j++) {
            if (toUnit == index[j]) {
                coord2 = j;
            }
        }
        goTo(coord1, coord2, value);


    }

    public void goTo(int x, int y, double amt) {
        char[][] addOrMultiplyMatrix = {{}};
        double[][] conversionRatios = {{1.00,459.67,491.67,1.8},
                                       {-457.67,1.00,35.6,}};

    }
}
