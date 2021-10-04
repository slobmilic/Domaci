package zadatak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Nedelja {
    public static int[] sortedZeros (int[] arr){
        int[] arrNew = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arrNew[count] = arr[i];
                count++;
            }
        }
        return arrNew;
    }


    public static void main(String[] args) {
        try{
        BufferedWriter writer = new BufferedWriter(new FileWriter("randomTests.txt"));
            for (int i = 0; i < 1000; i++) {
                int[] x = new int[(int) (Math.random() * 20)];
                for (int j = 0; j < x.length; j++) {
                    x[j] = (int) (Math.random() * 100);
                }
                writer.write("assertEquals(new int[]{" + Arrays.toString(sortedZeros(x)).replaceAll("]", "").replaceAll("\\[", "") + "}, Nedelja.sortedZeros(new int[]{" + Arrays.toString(x).replaceAll("]", "").replaceAll("\\[", "") + "}));");
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
}
