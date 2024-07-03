/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 3
*/
package test;

import service.RefTable;

public class RefTableTest
{
    RefTable obj;
    boolean status;

    public RefTableTest()
    {
        obj = new RefTable();
        status = true;
    }

    public void test()
    {
        try
        {
            //Test the total number of characters and indexs matches that of the reference table.
            int total = 43 - 0 + 1; //Total number of characters/indexes in the reference table.
            if(obj.getCharSize() != total)
            {
                status = false;
                System.out.printf("Test total characters in reference table:\tFAIL.\n");
            }
            if(obj.getIndexSize() != total)
            {
                status = false;
                System.out.printf("Test total indexes in reference table:\tFAIL.\n");
            }
            
            //Based on reference table, test whether the characters and their indexes are correct
            matchIndxToChar(0, 'A');
            matchIndxToChar(1, 'B');
            matchIndxToChar(2, 'C');
            matchIndxToChar(3, 'D');
            matchIndxToChar(4, 'E');
            matchIndxToChar(5, 'F');
            matchIndxToChar(6, 'G');
            matchIndxToChar(7, 'H');
            matchIndxToChar(8, 'I');
            matchIndxToChar(9, 'J');
            matchIndxToChar(10, 'K');
            matchIndxToChar(11, 'L');
            matchIndxToChar(12, 'M');
            matchIndxToChar(13, 'N');
            matchIndxToChar(14, 'O');
            matchIndxToChar(15, 'P');
            matchIndxToChar(16, 'Q');
            matchIndxToChar(17, 'R');
            matchIndxToChar(18, 'S');
            matchIndxToChar(19, 'T');
            matchIndxToChar(20, 'U');
            matchIndxToChar(21, 'V');
            matchIndxToChar(22, 'W');
            matchIndxToChar(23, 'X');
            matchIndxToChar(24, 'Y');
            matchIndxToChar(25, 'Z');
            matchIndxToChar(26, '0');
            matchIndxToChar(27, '1');
            matchIndxToChar(28, '2');
            matchIndxToChar(29, '3');
            matchIndxToChar(30, '4');
            matchIndxToChar(31, '5');
            matchIndxToChar(32, '6');
            matchIndxToChar(33, '7');
            matchIndxToChar(34, '8');
            matchIndxToChar(35, '9');
            matchIndxToChar(36, '(');
            matchIndxToChar(37, ')');
            matchIndxToChar(38, '*');
            matchIndxToChar(39, '+');
            matchIndxToChar(40, ',');
            matchIndxToChar(41, '-');
            matchIndxToChar(42, '.');
            matchIndxToChar(43, '/');

            //To output if all test passes.
            if(status)
            {
                System.out.printf("Unit test for RefTable:\tPASS.\n");
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void matchIndxToChar(int index, char character)
    {
        int num = obj.getIndex(character);
        char letter = obj.getChar(index);

        if(num == -1 || num != index)
        {
            status = false;
            System.out.printf(
                "Test \'%c\' in reference table:\tError in matching index.\n", character);
        }
        if(letter == '\0' || letter != character)
        {
            status = false;
            System.out.printf(
                "Test index %d in reference table:\tError in matching character.\n", index);
        }
    }
}