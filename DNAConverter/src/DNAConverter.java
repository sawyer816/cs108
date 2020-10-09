/**
 * Program 4 - DNAConverter
 * This program has two methods One creates a RNA file out of a given DNA file
 * the other uses a given RNA file and Table to make a protein file.
 * @author Sawyer Thompson
 * @date 03/08/20
 * CS 108 Section - 1
 */

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DNAConverter {
    /**
     * @name DNA2RNA
     * @param DNAFile
     * @param RNAFile
     * @throws NoSuchElementException
     * Given a DNA file, this method opens it, and then writes to an RNA file
     * by replacing certain letters that are matched from DNA to RNA.
     */
    public static File DNA2RNA (String DNAFile, String RNAFile)
            throws FileNotFoundException {
        //creates files and ways to open and write to them
        File DNA = new File(DNAFile);
        Scanner open = new Scanner(DNA);
        File RNA = new File(RNAFile);
        PrintWriter convert = new PrintWriter(RNA);
        while (open.hasNextLine()){
            String message = open.nextLine();
            //runs through each line and checks if certain letters are found
            //and then are replaced when writing the the RNA File
            for (int i = 0; i < message.length(); i++) {
                char c = message.charAt(i);
                if(c=='T') {
                    convert.print('A');
                }
                else if(c=='A'){
                    convert.print('U');
                }
                else if(c=='C'){
                    convert.print('G');
                }
                else if(c=='G'){
                    convert.print('C');
                }
                else{
                    throw new NoSuchElementException("Not a DNA character");
                }
            }
            //add new line
            convert.println();
        }
        //end and close files
        convert.flush();
        convert.close();
        return RNA;
    }

    /**
     * @name RNA2Protein
     * @param RNAFile
     * @param ProteinFile
     * @param RNA2ProteinTable
    //  * @throws RuntimeException("Invalid RNA length")
     * This program reads both an RNA file and 2ProteinTable in order to create
     * a protein file.
     */
    public static void RNA2Protein (String RNAFile, String ProteinFile,
                             String RNA2ProteinTable)
            throws FileNotFoundException {
        //Creates files and both ways to read and write them.
        File Table = new File(RNA2ProteinTable);
        Scanner open = new Scanner(Table);
        File RNA = new File(RNAFile);
        Scanner R = new Scanner(RNA);
        File Protein = new File(ProteinFile);
        PrintWriter convert = new PrintWriter(Protein);
        ArrayList<String> row = new ArrayList<String>();
        ArrayList<String> col = new ArrayList<String>();
        while(open.hasNextLine()){
            //puts each part of the table file into separate arraylists
            String whole = open.nextLine();
            String first = whole.substring(0,3);
            String second = whole.substring(4);
            row.add(first);
            col.add(second);
        }
        while (R.hasNextLine()){
            String next = R.nextLine();
            if(next.length() % 3 != 0){
                //ensures the RNA length is a multiple of 3
                throw new RuntimeException("Invalid RNA length");
            }
            for (int i = 0; i < next.length(); i+=3) {
                //breaks each line into groups of 3 letters
                String newest = "";
                if(i+3<=next.length()) {
                    newest = next.substring(i, i + 3);
                }
                //pulls out each group and checks if it matches the table.
                for (int j = 0; j < row.size(); j++) {
                    if(newest.equals(row.get(j))){
                        convert.print(col.get(j));
                    }
                }
            }
            //adds new line
            convert.println();
        }
        //ends program
        convert.flush();
        convert.close();
    }

    //Test
    public static void main(String[] args) throws FileNotFoundException {
        String DNA = args[0];
        String RNA = "hi";
        String proteinFile = "protein";
        String table = args[1];
        DNA2RNA(DNA, RNA);
        RNA2Protein(RNA,proteinFile, table);
    }
}