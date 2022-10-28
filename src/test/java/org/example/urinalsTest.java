package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {
    urinals test_object=new urinals();

    @Test
    void getString() {
    }

    @Test
    void openFile() {
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