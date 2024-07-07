/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 2
*/
package main;

import test.*;
import service.Encoder;
import service.Decoder;

import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) {
        //To run test files
        // /*
        RefTableTest testfile1 = new RefTableTest();
        testfile1.test();

        DecoderTest testfile2 = new DecoderTest();
        testfile2.test();

        EncoderTest testfile3 = new EncoderTest();
        testfile3.test();
        // */

        Scanner input = new Scanner(System.in);
        boolean state = true;
        Encoder encoder = new Encoder();
        Decoder decoder = new Decoder();
        String plainText;
        String encodedText;

        while(state) {
            try {
                System.out.printf("Select option:\n1. Encode\n2. Decode\n3. Exit\n");
                int num = input.nextInt();
                input.nextLine(); //To consume next line feed that is ingnored in "input.nextInt()".

                switch(num) {
                    case 1:
                        System.out.printf("Enter Plain Text: ");
                        plainText = input.nextLine();
                        encodedText = encoder.encode(plainText);
                        System.out.printf("The encoded text of \"%s\": %s\n\n", plainText, 
                                encodedText);
                        break;
                    case 2:
                        System.out.printf("Enter Encoded Text: ");
                        encodedText = input.nextLine();
                        plainText = decoder.decode(encodedText);

                        if(plainText != null) {
                            System.out.printf("The plain text of \"%s\": %s\n\n", 
                                    encodedText, plainText);
                        }
                        else {
                            System.out.printf("Error: Encoded Text is invalid.\n\n");
                        }
                        break;
                    case 3:
                        state = false;
                        break;
                    default:
                        System.out.printf("Error: Invalid Input.\n\n");
                        break;
                }
            }
            catch (Exception e) {
                input.nextLine(); //To consume next line feed that is ingnored in "input.nextInt()".
                System.out.printf("Error has occurred. Re-try from beginning.\n\n");
            }
        }

        System.out.printf("End of Program.\n");
    }
}