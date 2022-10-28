package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    urinals test_object=new urinals();

    @Test
    void getString() {
    }

    @Test
    public void openFile() throws Exception {
        System.out.println("test for file existence");
        File file = new File("somefile.txt");
        boolean expectedRes = false;
        boolean actualRes = false;
        if (file.exists()){
            actualRes = true;
        }
        assertEquals(expectedRes, actualRes);
        System.out.println("test for empty file");
        File file1 = new File("urinals.dat.txt");
        boolean expected1 = false;
        boolean actual1 = false;
        if (file1==null){
            actual1 = true;
        }
        assertEquals(expected1, actual1);
    }

    @Test
    void countUrinals() {
        System.out.println("====== Srilakshmi Sravani Andaluri == TEST THREE EXECUTED =======");
        assertEquals( -1,urinals.countUrinals("0110"));
        assertEquals( 3,urinals.countUrinals("00000"));
        assertEquals( 1,urinals.countUrinals("01000"));
        assertEquals( -1,urinals.countUrinals("011"));
        assertEquals( 0,urinals.countUrinals("1001"));
    }

    @Test
    void goodString() {
        assertEquals( true, urinals.goodString("1010"));
        System.out.println("====== Srilakshmi Sravani Andaluri == TEST ONE EXECUTED =======");

        assertEquals(false, urinals.goodString("1100"));
        System.out.println("====== Srilakshmi Sravani Andaluri == TEST TWO EXECUTED =======");
    }

    @Test
    void main() {
    }
}