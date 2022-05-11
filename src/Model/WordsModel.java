package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordsModel {
     public static ArrayList<String> list = new ArrayList<>();
     
    public static void ReadFile() throws FileNotFoundException{

try (Scanner s = new Scanner(new FileReader("src/Application/wordle5.txt"))) {
    while (s.hasNext()) {
        list.add(s.nextLine());
    }
   
}
   
   
   }   
   
        
 
}
