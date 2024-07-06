/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 6
*/
package test;

import service.Decoder;

public class DecoderTest {
    Decoder decoder;
    boolean status;

    public DecoderTest() {
        decoder = new Decoder();
        status = true;
    }

    public void test() {
        try {
            //From given document.
            String plainText = "HELLO WORLD";
            String encodedText = "BGDKKN VNQKC";

            if(!plainText.equals(decoder.decode(encodedText))) {
                System.out.printf("Test Decode %s:\tFAIL\n", encodedText);
                status = false;
            }

            //From given document.
            encodedText = "FC/GGJ RJMG.";

            if(!plainText.equals(decoder.decode(encodedText))) {
                System.out.printf("Test Decode %s:\tFAIL\n", encodedText);
                status = false;
            }

            if(decoder.decode("~asdf") != null) {
                System.out.printf("Test Decode Symbol Not in Table:\tFAIL\n");
                status = false;
            }

            plainText = "12applesPIE";
            encodedText = "A12applesPIE";

            if(!plainText.equals(decoder.decode(encodedText))) {
                System.out.printf("Test Decode %s:\tFAIL\n", encodedText);
                status = false;
            }

            plainText = "AbCdE";
            encodedText = "/BbDdF";

            if(!plainText.equals(decoder.decode(encodedText))) {
                System.out.printf("Test Decode %s:\tFAIL\n", encodedText);
                status = false;
            }

            //To output if all test passes.
            if(status) {
                System.out.printf("Unit test for Decoder:\tPASS.\n");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}