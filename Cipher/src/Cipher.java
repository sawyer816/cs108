/**
 *  Program #3
 *  This program codes and decodes a Caesar Cipher.
 *  It throw exceptions to catch errors throughout reading and writing files.
 *  CS108-1
 *  02/24/20
 *  @author  Sawyer Thompson
 */
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Cipher {

    public static final int NUM_LETTERS = 26;
    public static final int ENCODE = 1;
    public static final int DECODE = 2;
    public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws FileNotFoundException /* FIX ME */  {
        // Check args length, if error, print usage message and exit
        if(args.length>=3) {
            // Extract input args to variables
            String inputFilename = args[0];
            String key = args[1];
            int action = Integer.parseInt(args[2]);
            Scanner input = openInput(inputFilename);
            String outputFilename = getOutputFilename(inputFilename, action);
            PrintWriter output = openOutput(outputFilename);
            //Checks for right action input.
            if(action!=1 && action !=2){
                System.out.println("Option " + action + " is not valid");
                output.close();
            }
            while (input.hasNextLine()) {
                //makes message into the file input.
                String message = input.nextLine().toLowerCase();
                String newMessage = "";
                //ensures the key is constantly run through the data given by the file.
                while (message.length()>key.length()){
                    key+= key;
                }

                //Shifts the letters around and adds them to a newMessage.
                for (int i = 0; i < message.length(); i++) {
                    char c = (message.charAt(i));
                    if(action==1){
                        c =shiftUpByK(c, alphabet.indexOf(key.charAt(i)));
                    }
                    else if(action==2){
                       c = shiftDownByK(c, alphabet.indexOf(key.charAt(i)));
                    }
                    newMessage += c;
                }
                //adds the new message to output.
                output.write(newMessage);
            }
            //closes output & input.
            input.close();
            output.close();
        }
        //exits if args is less than 3.
        else{
            System.out.println("no");
            System.exit(1);
        }
    }

    /**
     * Open input for reading
     *
     * @param filename
     * @return Scanner
     * @throws FileNotFoundException
     */
    private static Scanner openInput(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        return scan;
    }

    /**
     * Open output for writing
     *
     * @param filename
     * @return PrintWriter
     * @throws FileNotFoundException
     */
    private static PrintWriter openOutput(String filename) throws FileNotFoundException{
        File outputs = new File(filename);
        PrintWriter print = new PrintWriter(outputs);
        return print;
    }

    /**
     * Encode letter by some offset d
     *
     * @param c  input character
     * @param offset  amount to shift character value
     * @return char  encoded character
     */
    public static char shiftUpByK(char c, int offset) {
        if ('a' <= c && c <= 'z')
            return (char) ('a' + (c - 'a' + offset) % NUM_LETTERS);
        if ('A' <= c && c <= 'Z')
            return (char) ('A' + (c - 'A' + offset) % NUM_LETTERS);
        return c; // don't encrypt if not an ic character
    }

    /**
     * Decode letter by some offset d
     *
     * @param c  input character
     * @param offset  amount to shift character value
     * @return char  decoded character
     */
    public static char shiftDownByK(char c, int offset) {
        if(alphabet.indexOf(c)>-1) {
            int f = c - 97;
            System.out.println(f);
            f -= offset;
            System.out.println(f);
            if (f < 0) {
                f += NUM_LETTERS;
            }
            c = (char) (f + 97);
            f = c;
            System.out.println(f);
        }
        return c;
    }


    /**
     * Changes file extension to ".coded" or ".decoded"
     *
     * @param filename
     * @return String new filename or null if action is illegal
     */
    private static String changeDecoded(String filename) {
        return filename+".decoded";
    }
    private static String changeCoded(String filename) {
        return filename+".coded";
    }

    private static String getOutputFilename(String inputFilename, int action) {
        if(action==1){
            return changeCoded(inputFilename);
        }
        else if(action==2)
        {
            return changeDecoded(inputFilename);
        }
        return null;

    }

    public String getInfo() {
        return "Program 3, Sawyer Thompson";
    }

}