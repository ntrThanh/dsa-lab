package hus.dsa.datastructure.lz77;


public class LZ77 {
    /**
     * This function takes an input array t, the current position in the array,
     * and the size of the window. It returns the largest Occurrence found in the window.
     * Don't forget that the current character is not in the window.
     * @param t
     * @param currentPosition
     * @param windowSize
     * @return an occurrence
     */

    public static Occurrence longestOccurrence(int[] t, int currentPosition, int windowSize) {
        // TODO: Your code here

        return null;
    }

    /**
     * Computes the length of the compressed array.
     * @param t
     * @param windowSize
     * @return the length of the compressed array.
     */
    public static int length(int[] t, int windowSize) {
        // TODO: Your code here

        return 0;
    }

    /**
     * Compresses an array t.
     * @param t
     * @param windowSize
     * @return an array of Element.
     */
    public static Element[] compress(int[] t, int windowSize) {
        // TODO: Your code here
        return null;
    }

    /**
     * Prints out the compression array.
     * @param t
     */
    public static void printCompression(Element[] t) {
        StringBuilder sb = new StringBuilder(1024);
        for (Element e : t) {
            sb.append(e.toString());
        }
        System.out.println(sb);
    }

    /**
     * Computes the length of the decompressed data, given the
     * compressed data.
     * @param t
     * @return a length
     */
    public static int lengthInverse(Element[] t) {

        return 0;
    }

    /**
     * Decompresses data.
     * @param t
     * @return an array representing decompressed data
     */
    public static int[] decompress(Element[] t) {
        // TODO: Your code here


        return null;
    }

    /**
     * Copy the characters of array t1, going from start1 to start1 + len - 1
     * to the array t2, starting from position start2.
     * @param t1
     * @param t2
     * @param start1
     * @param len
     * @param start2
     */
    static void blit(int[] t1, int[] t2, int start1, int len, int start2) {
        // TODO: Your code here
    }

    public static void printDecompression(int[] t) {
        for (int i : t) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}

class Element {
    Occurrence o;
    int s;

    Element(Occurrence o, int s) {
        this.o = o;
        this.s = s;
    }

    @Override
    public String toString() {
        return o.toString() + s;
    }
}

class Occurrence {
    int retour;
    int size;

    Occurrence (int retour, int size) {
        this.retour = retour;
        this.size = size;
    }

    @Override
    public String toString() {
        return "(" + retour + "," + size + ")";
    }
}

