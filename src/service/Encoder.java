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
            encodeIndex = table.getIndex(textArr(i));

            //True if the plain text character exists in reference table.
            if(encodeIndex != -1) {
                encodeText += table.getChar(keyIndex + encodeIndex);
            }
            else {
                encodeText += textArr[i];
            }
        }

        return encodeText;
    }
}