package lotto;

import java.util.Random;
import java.util.Scanner;

public class lotto {
	
	public static void main(String[] args) {
		
		//get data from the user
		String numberFromUser[] = getEnteredNumbers();
		
		//hold a raffle
		int lotto[] = doLotto();
		
		//check the match
		int matchedNumbers = comparation(numberFromUser,lotto);
		
		//output the result
		String AllNumOfLotto = ConvertArrToText(lotto);
		
		 
		
		System.out.println("In loto compare ("+ AllNumOfLotto + "): "+ matchedNumbers);
		System.out.println("Your winnings are : " + matchedNumbers * 200 + "$" );
		
	}
	
	public static String[] getEnteredNumbers () {
		
		System.out.println("Enter 8 numbers from 1 to 54");
		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		scan.close();
		String arrOfEnteredNumbers[] = numbers.split(" ");
		return arrOfEnteredNumbers;
	}
	
	public static int[] doLotto() {
		
		
		int arrOfRandNumbers[] = new int[8];
		Random rand = new Random();
				
		
			
		for (int i=0; i<8; i ++) {
			
			int thisNum = rand.nextInt(54)+1;
			boolean match = false;
			for (int j: arrOfRandNumbers) {
				if(j == thisNum) {
					i--;
					match = true;
					break;
					
				}
			}
			if(!match) {
				arrOfRandNumbers[i]=thisNum;
			}
		}
		return arrOfRandNumbers;
	}
	
	public static int comparation(String arrOfEnteredNumbers[],int arrOfRandNumbers[]) {
		
		int countOfMatch = 0;
		for(int k=0; k<arrOfEnteredNumbers.length; k++) {
			int number = Integer.parseInt(arrOfEnteredNumbers[k]);
			for (int thisWinningNum: arrOfRandNumbers) {
				if(number==thisWinningNum) {
					countOfMatch++;
				}
			}
		
		}
		return countOfMatch;					
	}
	
	public static String ConvertArrToText(int arrOfRandNumbers[]) {
		String allNumbers="";
		for(int num:arrOfRandNumbers) {
			allNumbers = allNumbers + num + " ";
		}
		return allNumbers;
	}
	
}



