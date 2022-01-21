import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        main m = new main();
        m.starterMethod();

    }
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
        System.out.println(coord1 + "\n" + coord2);
        goTo(coord1, coord2, value);
    }

    public void goTo(int x, int y, double amt) {
        String[][][] addOrMultiplyMatrix = {{{"M","M","M"},        {"A","M","M"},     {"M","A","M"},   {"M","M","M"}},
                                            {{"S","M","M"},        {"M","M","M"},     {"M","A","M"},   {"S","M","M"}},
                                            {{"S","M","M"},        {"S","M","M"},     {"M","M","M"},   {"S","M","M"}},
                                            {{"M","M","M"},        {"S","M","A"},     {"A","M","M"},   {"M","M","M"}}};
        double[][][] conversionRatios =    {{{1.0,1.0,1.0},        {459.67,1.0,1.0},  {1.8,491.67},    {1.8,1.0,1.0}},
                                            {{457.67,1.0,1.0},     {1.0,1.0,1.0},     {1.8,32,1.0},    {273,1.0,1.0}},
                                            {{491.67,0.55,1.0},    {32,.55,1.0},      {1.0,1.0,1.0},   {273,1.0,1.0}},
                                            {{.55,1.0,1.0},        {32,.55,273.},     {273,1.0,1.0},   {1.0,1.0,1.0}}};


        for (int z = 0; z < 3; z++) {
            if (addOrMultiplyMatrix[y][x][z] == "M") {
                amt = conversionRatios[y][x][z] * amt;
            }
            if (addOrMultiplyMatrix[y][x][z] == "S"){
                amt = amt - conversionRatios[y][x][z];
            }
            if (addOrMultiplyMatrix[y][x][z] == "A"){
                amt = amt + conversionRatios[y][x][z];
            }
        }

        System.out.println(amt);
    }
}
