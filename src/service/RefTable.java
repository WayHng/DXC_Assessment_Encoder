/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 3
*/
package service;

import java.util.Map;
import java.util.HashMap;

public class RefTable
{
    //String with all of the elements on the reference table to shift for encoding and decoding.
    final String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()*+,-./";

    char[] arr;
    Map<Character, Integer> map = new HashMap<>();

    public RefTable()
    {
        arr = table.toCharArray();

        for(int i = 0; i < arr.length; i++)
        {
            map.put(arr[i], i);
        }
    }

    /**
     * Method to get the corresponding character from the reference table using the given index.
     * Return '\0' if index is invalid, else return Char;
     */
    public char getChar(int index)
    {
        //True if index is out of bounds.
        if(index < 0 || index >= arr.length)
        {
            return '\0';
        }
        else
        {
            return arr[index];
        }
    }

    /**
     * Method to get the index of the given character from the reference table.
     * Returns -1 if character is NOT in the reference table, return Int.
     */
    public int getIndex(char character)
    {
        //True if map has a key that is the same as the given character.
        if(map.containsKey(character))
        {
            return map.get(character);
        }
        else
        {
            return -1;
        }
    }

    public int getCharSize()
    {
        return arr.length;
    }

    public int getIndexSize()
    {
        return map.size();
    }
}