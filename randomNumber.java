import java.util.*;

class randomNumber{
	public static void main(String[] args){
		int reply = 1;
		do{	

			System.out.println("What is the highest number you wish to have as the random number?");
			int high = input();
			high++;
			System.out.println("How many people are playing?");
			int n = input();

			double[] numbers = new double[n];

			for(int i = 0; i < numbers.length; i++){
				int ayy = (int) (Math.random()* high);
				numbers[i] = ayy;
				//			System.out.print(numbers[i] + " ");
			}

			int[] numTries = new int[n];
			for(int k = 0; k < n; k++){
				numTries[k] = 0;
			}
			do{
				for (int j = 0; j < n; j++){

					if (numbers[j] != 66.6){
						System.out.println("Player " + (j+1) + ", guess a number");
						int guess = input();

						if (guess == numbers[j]){
							System.out.println("CORRECT");
							numTries[j] = numTries[j] + 1;
							numbers[j] = 66.6;
						}
						else if (guess > numbers[j]){
							System.out.println("Too High");
							numTries[j] = numTries[j] + 1;
						}
						else if (guess < numbers[j]){
							System.out.println("Too Low");
							numTries[j] = numTries[j] + 1;
						}
					}
				}
			}while (!everyoneGuessRight(numbers));
			//print tries
			int min = numTries[0];
			int indexOfMin = 0;
			for (int r = 0; r < numTries.length; r++){
				System.out.println("Player " + (r+1) + " guessed " + numTries[r] + " times.");
				if (numTries[r] < min){
					min = numTries[r];
					indexOfMin = r;
				}
			}
			//wins
			System.out.println("Player " + (indexOfMin+1) + " wins!");
			System.out.println("");
			System.out.println("Do you want to play again? (1 for Yes, 0 for No)");
			reply = input();
			if (reply == 0){
				System.out.println("Sweet, have a great day!");
			}
		}while (reply == 1);
	}


	public static int input() {
		Scanner my_input = new Scanner(System.in);
		return my_input.nextInt();
	}

	public static boolean everyoneGuessRight(double[] num){
		int z = 0;
		for (int i = 0; i < num.length; i++){
			if (num[i] == 66.6){
				z++;
			}
		}
		if (z == num.length){
			return true;
		}
		else {
			return false;
		}
	}


}