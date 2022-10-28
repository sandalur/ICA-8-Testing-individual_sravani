package org.example;
import java.util.*;
import java.io.*;
import java.io.File;

import static java.lang.Integer.parseInt;

@SuppressWarnings("ALL")
public class urinals {
    public static void getString() {
    }
    public static void main(String[] args) {
        getString();
        urinals obj=new urinals();
        Scanner textfile=new Scanner(System.in);
        System.out.println("Enter your choice: ");
        System.out.println("1.Keyboard input \n2.File Input");
        int choice=textfile.nextInt();

        if(choice==1)
        {
            System.out.println("Enter your input");
            String givenString=" ";
            givenString = textfile.next();
            int urinals_occupancy=countUrinals(givenString);
            System.out.println(urinals_occupancy);

        }else {
            obj.openFile("src/urinals.dat");
        }

    }
    public static Boolean goodString(String my_str) {// checks to  see if valid string
        String[] givenString=my_str.split("");

        boolean flag=true;
        for(int i=0; i<my_str.length()-1;i++) {
            if (my_str.charAt(i) == '1' && my_str.charAt(i + 1) == '1') {
                flag = false;
                break;
            }
        }
        return flag;
    }
    static int countUrinals(String my_str) {
        urinals obj= new urinals();

        boolean flag= obj.goodString(my_str);
        if(!flag){
            return -1;
        }
        String[] givenString= my_str.split("");
        int count=0;
        int givenString_length=givenString.length;
        int array_character[]= new int[givenString_length];
        for(int i=0;i<givenString.length;i++){
            array_character[i]= parseInt(String.valueOf(givenString[i]));
        }
        if(givenString_length==1){
            if(array_character[0]==0){
                count=1;
                array_character[0]=1;

            }

        }
        else{
            int j=0;
            if(array_character[j]==0 && array_character[j+1]!=1){
                array_character[j]=1;
                count=count+1;
            }
            for(j=1;j<givenString_length-1;j++){
                if(array_character[j]==0 && array_character[j+1]!=1 && array_character[j-1]!=1){
                    array_character[j]=1;
                    count++;
                }
            }
            if(array_character[j]==0 && array_character[j-1]!=1){
                count=count+1;
                array_character[j]=1;
            }
        }
        return count;
    }

    public int openFile(String filepath){
        try{
            urinals obj=new urinals();
            File file=new File(filepath);
            if(file==null)
                throw new IOException();
            Scanner textfile=new Scanner(file);
            while(textfile.hasNextLine()){
                String givenString=textfile.nextLine();
                System.out.println(givenString);
                if(givenString.equals("-1")){
                    break;
                }
                else{
                    int urinals_occupancy=obj.countUrinals(givenString);
                    System.out.println(urinals_occupancy);
                }

            }
            return 1;
        }
        catch(IOException e)
        {
            System.out.println("Error in opening file");
            e.printStackTrace();
            return 0;
        }

    }
    public void createFiles(String output,int urinals_occupancy){
        try {
            FileWriter inputfile = new FileWriter(output, true);
            if(inputfile==null)
                throw new IOException();
            BufferedWriter writer=new BufferedWriter(inputfile);
            if(writer==null)
                throw new IOException();

            writer.write(Integer.toString(urinals_occupancy));
            writer.newLine();
            writer.close();
        }
        catch(IOException e){
            System.out.println("Error opening output file");
            e.printStackTrace();
        }
    }

}
