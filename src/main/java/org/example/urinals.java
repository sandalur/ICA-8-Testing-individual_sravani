package org.example;

public class urinals {
    static void getString() {
        System.out.println("First Method not implemented!");
    }
    static void openFile() {
        System.out.println("Second Method not implemented!");
    }
    static void countUrinals() {
        System.out.println("Third Method not implemented!");
    }
    static Boolean goodString(String my_str) {// checks to see if valid string
        for(int i=1; i<my_str.length();i++){
            if(my_str.charAt(i)!=0 && my_str.charAt(i)!=1){
                return false;
            }
            else if(my_str.charAt(i)==0 && my_str.charAt(i+1)==1){
                return true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        getString();
        openFile();
        countUrinals();


    }
}
