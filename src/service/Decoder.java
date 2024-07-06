/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 3
*/
package service;

import service.RefTable;

public class Decoder {
    RefTable table;

    public Decoder() {
        table = new RefTable();
    }

    public String decode(String encodedText) {
        char[] arr = encodedText.toCharArray();
        int keyIndex = table.getIndex(arr[0]);
        
        //True if key is not in reference table.
        if(keyIndex == -1) {
            return null;
        }
        
        String plainText = "";
        
        for(int i = 1; i < arr.length; i++) {
            int encodeIndex = table.getIndex(arr[i]);

            //True if encoded character exists in reference table.
            if(encodeIndex != -1) {
                //Get index of plain text
                int plainIndex = encodeIndex + keyIndex;
                //To wrap around plain text index if it exceeds number of elements in reference table.
                plainIndex %= table.getCharSize();

                plainText += table.getChar(plainIndex);
            }
            else {
                plainText += arr[i];
            }
        }

        return plainText;
    }
}