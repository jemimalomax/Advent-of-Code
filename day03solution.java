import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class day03solution {

    public static void main(String [] args){

        try{

            Scanner scan = new Scanner(System.in);
            File file = new File(scan.nextLine());
            ArrayList<String> inputList = new ArrayList<String>();
            Scanner sc = new Scanner(file);
            int numLines = 0;

            while(sc.hasNextLine()){
                inputList.add(sc.nextLine());
                numLines++;
            }

            int lineLength = (inputList.get(0)).length();


            char [] [] charArray = new char[numLines][lineLength];

            int i;

            for(i = 0; i < numLines; i++){
                charArray[i] = inputList.get(i).toCharArray();
            }

            int [] [] intArray = new int[lineLength][numLines];

            int col;
            int row;

            for(col = 0; col < lineLength; col++){
                for(row = 0; row < numLines; row++){
                    char ch = charArray[row][col];
                    int j = (ch - '0');
                    intArray[col][row] = j;
                }
            }

            int gammaZero = 0;
            int gammaOne = 0;
            int [] gammaArray = new int[lineLength];

            int cols;
            int rows;
        

            for(rows = 0; rows < lineLength; rows++){
                for(cols = 0; cols < numLines; cols++){
                    if(intArray[rows][cols] == 0){
                        gammaZero++;
                    } else{
                        gammaOne++;
                    }

                }
                if(gammaZero > gammaOne){
                    gammaArray[rows] = 0;
                } else{
                    gammaArray[rows] = 1;
                }
                gammaZero = 0;
                gammaOne = 0;
            }

            System.out.print("The gamma number is: ");
            for(int n = 0; n < gammaArray.length; n++){
                System.out.print(gammaArray[n] + " ");
            }

            System.out.println();

            int [] epsilonArray = new int[lineLength];

            for(int m = 0; m < gammaArray.length; m++){
                if(gammaArray[m] == 0){
                    epsilonArray[m] = 1;
                } else {
                    epsilonArray[m] = 0;
                }
            }

           System.out.print("The epsilon number is: ");

            for(int p = 0; p < epsilonArray.length; p++){
                System.out.print(epsilonArray[p] + " ");
            }

            int gammaDecimal = 0;
            int secondPower;
            int secondPowerEpsilon;
            int firstIndex = (gammaArray.length - 1);
            int epsilonDecimal = 0;

            int y = 0;

            for(int x = firstIndex; x >= 0; x--){
                if(gammaArray[x] == 1){
                secondPower = (int) Math.pow(2, y);
                gammaDecimal += secondPower;
                }
                if(epsilonArray[x] == 1){
                    secondPowerEpsilon = (int) Math.pow(2, y);
                    epsilonDecimal += secondPowerEpsilon;
                }
                y++;
            }

            int powerConsumption = (gammaDecimal * epsilonDecimal);


            System.out.println("The gamma decimal is: " + gammaDecimal);
            System.out.println("The epsilon decimal is: " + epsilonDecimal);
            System.out.println("The power consumption is: " + powerConsumption);

        } catch(Exception e){
            e.printStackTrace();;
        }
    }  
}

