package org.example;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("ALL")
class urinalsTest {
    urinals test_object = new urinals();

    @Test
    void getString() {
    }

    @Test
    void main() {
    }

    @Test
    public void openFile() throws Exception {
        System.out.println("test for file existence");
        File file = new File("somefile.txt");
        boolean expectedRes = false;
        boolean actualRes = false;
        if (file.exists()) {
            actualRes = true;
        }
        assertEquals(expectedRes, actualRes);
        System.out.println("test for empty file");
        File file1 = new File("randomfile.txt");
        boolean expected1 = false;
        boolean actual1 = false;
        if (file1 == null) {
            actual1 = true;
        }
        assertEquals(expected1, actual1);
    }

    @Test
    void countUrinals() {
        System.out.println("====== Srilakshmi Sravani Andaluri == TEST THREE EXECUTED =======");
        assertEquals(-1, urinals.countUrinals("0110"));
        assertEquals(3, urinals.countUrinals("00000"));
        assertEquals(1, urinals.countUrinals("01000"));
        assertEquals(-1, urinals.countUrinals("011"));
        assertEquals(-1, urinals.countUrinals("01A1"));
        assertEquals(0, urinals.countUrinals("1001"));
    }

    @Test
    void goodString() {
        assertEquals(true, urinals.goodString("1010"));
        System.out.println("====== Srilakshmi Sravani Andaluri == TEST ONE EXECUTED =======");
        assertEquals(false, urinals.goodString("1100"));
        System.out.println("====== Srilakshmi Sravani Andaluri == TEST TWO EXECUTED =======");
        assertEquals(false, urinals.goodString("1a00"));
        System.out.println("Number Exception Handled");
    }

    @Test
    void createFiles() throws IOException {
        System.out.println("test for IO Exception");
        File file = new File("randomfile.txt");
        boolean expectedRes = false;
        boolean actualRes = false;
        if (file.exists()) {
            actualRes = true;
        }
        assertEquals(expectedRes, actualRes);

    }
}