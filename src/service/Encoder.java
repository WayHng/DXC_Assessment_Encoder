/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 3
*/
package service;

import service.RefTable;

import java.lang.Math;

public class Encoder {
    RefTable table;

    public Encoder() {
        table = new RefTable();
    }

    public String encode(String plainText) {
        //Generate a random key from the reference table to use for the encoding.
        int keyIndex = (int)(Math.floor(Math.random() * 100) % (43 - 0 + 1));
        //Add key to encoded text.
        String encodeText = "" + table.getChar(keyIndex);
        char[] textArr = plainText.toCharArray();

        for(int i = 0; i < textArr.length; i++) {
            int plainIndex = table.getIndex(textArr[i]);

            //True if the plain text character exists in reference table.
            if(plainIndex != -1) {
                //Get index of encoded text.
                int encodeIndex = plainIndex - keyIndex;

                //To wrap around encode text index if it is negative
                if(encodeIndex < 0) {
                    encodeIndex += table.getCharSize();
                }

                encodeText += table.getChar(encodeIndex);
            }
            else {
                encodeText += textArr[i];
            }
        }

        return encodeText;
    }
}