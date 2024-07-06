/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 6
*/
package test;

import service.Encoder;
import service.Decoder;

public class EncoderTest {
    Encoder encoder;
    Decoder decoder;
    boolean status;

    public EncoderTest() {
        encoder = new Encoder();
        decoder = new Decoder();
        status = true;
    }

    public void test() {
        try {
            String plainText = "HELLO, WORLD";
            String encodedText = encoder.encode(plainText);
            
            //As key is random, the Decoder is required for testing.
            if(!plainText.equals(decoder.decode(encodedText))) {
                System.out.printf("Test Encode %s:\tFAIL\n", plainText);
                status = false;
            }

            plainText = "123applePIE!";
            encodedText = encoder.encode(plainText);
            
            //As key is random, the Decoder is required for testing.
            if(!plainText.equals(decoder.decode(encodedText))) {
                System.out.printf("Test Encode %s:\tFAIL\n", plainText);
                status = false;
            }

            //To output if all test passes.
            if(status) {
                System.out.printf("Unit test for Encoder:\tPASS.\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}