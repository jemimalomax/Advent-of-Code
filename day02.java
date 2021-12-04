import java.io.File;
import java.util.Scanner;


/* Puzzle: you have an input file with lines e.g. forward 5 and need to find the final horizontal and vertical depth
*/

public class day02{

    public static void main(String [] args){

        try{

        Scanner sc  = new Scanner(System.in);

        File input = new File(sc.nextLine());

        Scanner scan = new Scanner(input);

        int depth = 0;

        int horizontal = 0;

        int amount = 0;

        int [] currPosition = new int[2];

        String instruction = null;

        while(scan.hasNext()){
            instruction = scan.next();
            amount = scan.nextInt();
            currPosition = move(instruction, amount, horizontal, depth);
            horizontal = currPosition[0];
            depth = currPosition[1];
            if(scan.hasNextLine()){
            scan.nextLine();
        }  
    }
        

        System.out.println("The horizontal position is: " + currPosition[0]);
        System.out.println("The depth position is: " + currPosition[1]);
        int positionMultiplied = (currPosition[0] * currPosition[1]);
        System.out.println("The multiplication value is: " + positionMultiplied);
        } catch (Exception e){
            System.out.println("cannot find your fucking file");
            e.printStackTrace();
        }
        
    }

    public static int [] move(String instruction, int amount, int horizontal, int depth){

        int [] dirArr = new int[2];

        if(instruction.equals("forward")){
            horizontal += amount;
        } else if(instruction.equals("back")){
            horizontal += amount;
        } else if(instruction.equals("up")){
            depth -= amount;
        } else if(instruction.equals("down")){
            depth += amount;
        } else{
            System.out.println("invalid instruction, skipping line!");
        }

        dirArr[0] = horizontal;
        dirArr[1] = depth;

        return dirArr;
    }
}