package org.example;
import java.util.*;
import java.io.*;
import java.io.File;

import static java.lang.Integer.parseInt;

@SuppressWarnings("ALL")
public class urinals {
    public static void main(String[] args) {
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

        boolean flag=true;
        if(my_str.contains("11"))
        {
            return flag=false;
        }

        for(int i=0; i<=my_str.length()-1;i++){
            int a=my_str.charAt(i);
            if ((a!=48 && a!=49) ) {
                flag = false;
                break;
            }
        }
        return flag;
    }
    static int countUrinals(String my_str) {
        urinals obj= new urinals();
        boolean flag= obj.goodString(my_str);
//        System.out.println(flag);
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

    public void openFile(String filepath){
        try{
            //String outputfile="src/rule.txt";
            int counter=1;
            File outputfile = new File("src/rule.txt");
            while (outputfile.exists()){
                outputfile= new File("src/rule"+counter+".txt");
                counter++;
            }
            System.out.println("New file created with name: "+outputfile.getName());
            urinals obj=new urinals();
            //Read from input file
            File newfile=new File(filepath);

            if(newfile==null)
                throw new IOException();
            if(!newfile.exists())
                throw new FileNotFoundException();
            Scanner sc=new Scanner(newfile);
            while(sc.hasNextLine()){
                String givenString=sc.nextLine();
                if(givenString.equals("-1"))
                    break;

                int urinals_occupancy=obj.countUrinals(givenString);
                obj.createFiles(outputfile.getPath(),urinals_occupancy);

            }
        } catch(FileNotFoundException f){
            System.out.println("Error in opening file");
            f.printStackTrace();

        } catch(IOException e)
        {
            System.out.println("File is empty");
            e.printStackTrace();

        }


    }
    public void createFiles(String output,int urinals_occupancy){
        try {
            FileWriter inputfile = new FileWriter(output, true);
            BufferedWriter writerbuffer=new BufferedWriter(inputfile);
            if(inputfile==null || writerbuffer==null)
                throw new IOException();

            writerbuffer.write(Integer.toString(urinals_occupancy));
            writerbuffer.newLine();
            writerbuffer.close();
        }
        catch(IOException e){
            System.out.println("Error opening output file");
            e.printStackTrace();
        }
    }

}
