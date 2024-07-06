/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 6
*/
package test;

import service.Encoder;
import service.RefTable;

public class EncoderTest {
    Encoder encoder;
    RefTable table;
    boolean status;

    public Encoder() {
        encoder = new Encoder();
        table = new RefTable();
        status = true;
    }

    public void test() {
        String plainText = "HELLO, WORLD"
    }
}