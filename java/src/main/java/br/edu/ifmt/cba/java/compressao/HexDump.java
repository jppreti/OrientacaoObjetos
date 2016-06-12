package br.edu.ifmt.cba.java.compressao;

/*************************************************************************
 *  Compilation:  javac HexDump.java
 *  Execution:    java HexDump < file
 *  Dependencies: BinaryStdIn.java
 *  Data file:    http://introcs.cs.princeton.edu/stdlib/abra.txt
 *  
 *  Reads in a binary file and writes out the bytes in hex, 16 per line.
 *
 *  % more abra.txt
 *  ABRACADABRA!
 *
 *  % java HexDump 16 < abra.txt
 *  41 42 52 41 43 41 44 41 42 52 41 21
 *  96 bits
 *
 *
 *  Remark
 *  --------------------------
 *   - Similar to the Unix utilities od (octal dump) or hexdump (hexadecimal dump).
 *
 *  % od -t x1 < abra.txt 
 *  0000000 41 42 52 41 43 41 44 41 42 52 41 21
 *  0000014
 *
 *************************************************************************/

/** This program prints a bitstream representing each block of 8 bits
 *  in hexadecimal notation.
 *  The program is similar to the Unix utilities od (octal dump) 
 *  and hexdump (hexadecimal dump):
 *  <pre>
 *  % od -t x1 < abra.txt 
 *  0000000 41 42 52 41 43 41 44 41 42 52 41 21
 *  0000014
 *  </pre>
 *  Aditional documentation: see Section 5.5, p.811-815, of 
 *  "Algorithms, 4th Edition", by Robert Sedgewick e Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */

public class HexDump {

    /** Reads a binary file and writes out the bits,
     * N per line (N is a command-line argument),
     * representing each block of 8 bits in hexadecimal notation..
     * <pre>
     * % more abra.txt 
     * ABRACADABRA!
     *
     * % java HexDump 16 < abra.txt
     * 41 42 52 41 43 41 44 41 42 52 41 21
     * 96 bits
     * </pre>
     */
    public static void main(String[] args) {
        int BYTES_PER_LINE = 16;
        if (args.length == 1) {
            BYTES_PER_LINE = Integer.parseInt(args[0]);
        }

        int i;
        for (i = 0; !BinaryStdIn.isEmpty(); i++) {
            if (BYTES_PER_LINE == 0) { BinaryStdIn.readChar(); continue; }
            if (i == 0) StdOut.printf("");
            else if (i % BYTES_PER_LINE == 0) StdOut.printf("\n", i);
            else StdOut.print(" ");
            char c = BinaryStdIn.readChar();
            StdOut.printf("%02x", c & 0xff);
        }
        if (BYTES_PER_LINE != 0) StdOut.println();
        StdOut.println((i*8) + " bits");
    }
}
