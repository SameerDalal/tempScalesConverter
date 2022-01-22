import java.sql.SQLOutput;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        main m = new main();
        m.starterMethod();

    }
    public void starterMethod() {
        System.out.println("Rankine, Fahrenheit, Celsius, and Kelvin");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the unit you would like to convert from: ");
        String from = scan.next();
        char fromUnit = from.charAt(0);
    // takes the input of what you would like to convert to and gets the first character of that string
        System.out.println("Enter the unit you would like to convert to: ");
        String to = scan.next();
        char toUnit = to.charAt(0);
    // takes the input of what you would like to convert to and gets the first character of that string


        System.out.println("Enter value: ");
        float value = scan.nextFloat();
        scan.close();
    // takes the numerical value of what you would like to convert.

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
    // creates two coordinate points based on the index array.
        goTo(coord1, coord2, value);
    }

    public void goTo(int x, int y, double amt) {
        String[][][] findMatrix =          {{{"M","M","M"},        {"A","M","M"},     {"M","A","M"},   {"M","M","M"}},
                                            {{"S","M","M"},        {"M","M","M"},     {"M","A","M"},   {"S","M","M"}},
                                            {{"S","M","M"},        {"S","M","M"},     {"M","M","M"},   {"S","M","M"}},
                                            {{"M","M","M"},        {"S","M","A"},     {"A","M","M"},   {"M","M","M"}}};
        double[][][] conversionRatios =    {{{1.0,1.0,1.0},        {459.67,1.0,1.0},  {1.8,491.67},    {1.8,1.0,1.0}},
                                            {{457.67,1.0,1.0},     {1.0,1.0,1.0},     {1.8,32,1.0},    {273,1.0,1.0}},
                                            {{491.67,0.55,1.0},    {32,.55,1.0},      {1.0,1.0,1.0},   {273,1.0,1.0}},
                                            {{.55,1.0,1.0},        {32,.55,273.},     {273,1.0,1.0},   {1.0,1.0,1.0}}};

    // coordinate points are then used to in the 'findMatrix' matrix to identify what operation of calculation needs to be done
    // then those same coordinate points are used in the 'conversionRatios' matrix to identify the values that the value inputted needs to
    // be multiplied, added, or subtracted from.
        for (int z = 0; z < 3; z++) {
            switch(findMatrix[y][x][z]){
                case("M"):
                    amt = conversionRatios[y][x][z] * amt;
                    break;
                case("S"):
                    amt = amt - conversionRatios[y][x][z];
                    break;
                case("A"):
                    amt = amt + conversionRatios[y][x][z];
                    break;
            }
        }/*
    this code runs through 'findMatrix' to find the calculations needed to be done, and 'conversionRatios' is used to find the value of the
    multiplying, adding, or subtracting operators, which is determined using the switch case statement.
    which is determined using the switch case statement.
    This is all under a for loop that runs 3 times because some conversions require 3 steps to get the final answer.
    */
        System.out.println("Your converted temperature: " + amt);

    }
}
