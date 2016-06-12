package br.edu.ifmt.cba.java.compressao;

/*************************************************************************
 *  Compilation:  javac PictureDump.java
 *  Execution:    java PictureDump width height < file
 *  Dependencies: BinaryStdIn.java Picture.java
 *  Data file:    http://introcs.cs.princeton.edu/stdlib/abra.txt
 *  
 *  Reads in a binary file and writes out the bits as w-by-h picture,
 *  with the 1 bits in black and the 0 bits in white.
 *
 *  % more abra.txt 
 *  ABRACADABRA!
 *
 *  % java PictureDump 16 6 < abra.txt
 *
 *************************************************************************/
import java.awt.Color;

/** This program prints a bitstream. The 0 bits are represented by 
 * white spots and 1 bits by black spots.
 * <p>
 * Aditional documentation: see Section 5.5, p.811-815, of 
 * "Algorithms, 4th Edition", by Robert Sedgewick e Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */

public class PictureDump {

    /** Reads a binary file and writes out the bits as a
     * w-by-h picture. The 1 bits are black and 
     * the 0 bits are white. 
     * The dimensions w and h are command-line arguments.
     * <pre>
     * % more abra.txt 
     * ABRACADABRA!
     *
     * % java PictureDump 16 6 < abra.txt
     * </pre>
     */
    public static void main(String[] args) {
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);
        Picture pic = new Picture(width, height);
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pic.set(j, i, Color.RED);
                if (!BinaryStdIn.isEmpty()) {
                    count++;
                    boolean bit = BinaryStdIn.readBoolean();
                    if (bit) pic.set(j, i, Color.BLACK);
                    else     pic.set(j, i, Color.WHITE);
                }
            }
        }
        pic.show();
        StdOut.println(count + " bits");
    }
}
