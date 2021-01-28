/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje42deneme3;

import java.util.HashMap;
import java.util.Scanner;
/*
Roma rakamları yazılırken bazı kurallar vardır. Bunlar:
1-)Eğer ilk ifade ikinci ifadeden daha küçük ise ikinci ifadenin sayı değeri ilk 
ifadenin sayı değerinden çıkartılır. Örnek; IV 5-1=4
2-)Eğer ilk ifade ikinci ifadeden büyük ise o zaman iki ifade toplanır.
Örnek; CL 100+50=150
*/

/**
 *
 * @author oguzh
 */
public class PROJE42DENEME3 {
static String romanNumeral;
        static int decimalNum;
        static int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        static HashMap<Integer, String> map = new HashMap<Integer, String>();
        public static void main(String args[]) {
                PROJE42DENEME3 rmtoD = new PROJE42DENEME3();
                rmtoD .convertToDecimal();
                rmtoD .printRoman(romanNumeral);
                System.out.println("Enter the number : ");
		Scanner sc = new Scanner(System.in);
		int no = sc.nextInt();
		PROJE42DENEME3 in = new PROJE42DENEME3();
		int value=no;
		String sd = in.intToRoman(value);
		System.out.println(value+" ---> " + sd);
        }
        private static void setup()
	{
		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
	}
        public String intToRoman(int num)
	{
		setup();
		String result = new String();
		for (int i : bases)
		{
			while (num >= i)
			{
				result += map.get(i);
				num -= i;
			}
		}
		return result;
	}
 
        public void convertToDecimal () {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter a Roman number: ");
                romanNumeral = scan.nextLine();
                romanNumeral = romanNumeral.toUpperCase();
                
                int l=  romanNumeral.length();
                int num=0;
                int previousnum = 0;
                for (int i=l-1;i>=0;i--)
                { 
                        char x =  romanNumeral.charAt(i);
                        x = Character.toUpperCase(x);
                        switch(x)
                        {  
                                case 'I':
                                previousnum = num;
                                num = 1;
                                break;
                             case 'V':
                                     previousnum = num;
                                num = 5;
                                break;
                                case 'X':
                                        previousnum = num;
                                num = 10;
                                break;
                                case 'L':
                                        previousnum = num;
                                num = 50;
                                break;
                                case 'C':
                                        previousnum = num;
                                num = 100;
                                break;
                                case 'D':
                                        previousnum = num;
                                num = 500;
                                break;
                                case 'M':
                                        previousnum = num;
                                num = 1000;
                                break;
                        }           
                        if (num<previousnum)
                        {decimalNum= decimalNum-num;}
                         else
                        decimalNum= decimalNum+num;
                }
        }
        public static void printRoman (String romanNumeral){
                System.out.println ("The equivalent of the Roman numeral "+romanNumeral+" is "+decimalNum);
        }
        
 
       
        
        
}

    
    

