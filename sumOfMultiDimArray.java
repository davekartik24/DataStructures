
import java.io.*;
import java.util.*;



public class sumOfMultiDimArray {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        int[][] array = new int[6][6];
        
        for(int i = 0; i < 6; i++) {
            
            for (int j = 0; j < 6; j++) {
                
                array[i][j] = scan.nextInt();
            }
        }
        
        int maxSum = -9;
        int value = 0;
        
        for(int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 4; j++) {
                
                value = array[i][j] + array[i][j+1] + array[i][j+2]
                        + array[i+1][j+1] 
                        + array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
                
                if(maxSum < value) {
                    
                    maxSum = value;
                }
                            
            }
        }
        
        System.out.println(maxSum);
    }

}