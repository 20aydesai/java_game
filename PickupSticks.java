import java.util.*;

public class PickupSticks {
	int sticks = 31; //Initialize the sticks variable with max no.of sticks
	int money = 0; // money is the virtual dollar amount player earn upon winning the game
	int psticks; // psticks is the number of sticks the player has

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Rules for the game
		System.out.printf("Let's play Pickup Sticks!" + "\n");
		System.out.printf("You may pickup either 1 or 2 sticks." + "\n");
		System.out.printf("Whoever picks up the last stick loses the game!" + "\n");
		System.out.printf(
				"If you win the first level you win $200 virtual money and will be allowed to move to the 2nd level." + "\n");
		System.out.printf(
				"If you win the 2nd level, you win $400 virtual money and will be allowed to move to the 3rd level." + "\n");
		System.out.printf(
				"If you win the 3rd level, you win $600 virtual money and will be allowed to move to the 4th level." + "\n");
		System.out.printf("If you win the 4th level, you win $800 virtual money" + "\n");
		
		//Get users Input if they are ready to play the game
		System.out.printf("******ARE YOU READY????******* " + "\n");
		System.out.printf("Type 'Y' if you are ready to play the game." + "\n");
		Scanner in = new Scanner(System.in);
		char yesOrNo = in.next().charAt(0);
	
		if ((yesOrNo == 'Y') || (yesOrNo == 'y')) {
			PickupSticks pickupsticks = new PickupSticks();
			pickupsticks.level1();
			in.close();
		}
	}
	
	public int level1() {
		// Level1 
		// For the last 1 stick the computer would not pick random but will pick only
		// one stick
		System.out.printf("******Welcome to level 1******" + "\n");
		
		while (sticks > 0) {
			int csticks = 0; //Initialize - Number of sticks the computer has 

			System.out.printf("There are " + sticks + " sticks" + "\n");

			//If only one sticks left computer can pickup only one stick
			if (sticks == 1) {
				csticks = 1;
				sticks = sticks - csticks;
				System.out.printf("The computer removed " + csticks + " stick" + "\n");

			} else {
				csticks = (int) (Math.random() * 2 + 1);// Number of sticks the computer picked

				sticks = sticks - csticks; //subtract the no. of sticks computer picked from total
				System.out.printf("The computer removed " + csticks + " sticks" + "\n");
			}
			if (sticks <= 0) {
				System.out.printf("You won the game!" + "\n");
				money = money + 200; //Add virtual dollars to the winner
				System.out.printf("You made virtual $" + money + "\n");

				// Asks user if they want to go to level 2
				Scanner in = new Scanner(System.in);
				System.out.printf("Type 'Y' if you are ready to play the next level, Level2" + "\n");
				char yesOrNo = in.next().charAt(0);
				if ((yesOrNo == 'Y') || (yesOrNo == 'y')) {
					PickupSticks pickupsticks = new PickupSticks();
					pickupsticks.level2();
					in.close();
				}
				break;
			}

			System.out.printf("There are " + sticks + " sticks" + "\n");

			Scanner reader;

			while (true) {

				try {
					System.out.print("Type the number of sticks you want to remove 1 or 2" + "\n");
					reader = new Scanner(System.in);
					
					//Let player know to enter 1 or 2 only if he/she entered any other number
					do {
						psticks = reader.nextInt();
						System.out.printf("Please select the number 1 or 2" + "\n");

					} while ((psticks > 2) || (psticks <= 0));

					System.out.printf("You removed " + psticks + " sticks" + "\n");
					sticks = sticks - psticks; //subtract the sticks from the total sticks that a player picked

					break;
				} catch (InputMismatchException | NumberFormatException ex) {
					System.out.printf("I said an Integer..." + "\n");
				}
			}
			//If player lose the game, the level re-start 
			if (sticks <= 0) {
				System.out.printf("You lost the game!" + "\n");
				System.out.printf("Try again" + "\n");
				sticks = 31;
			}
		}
		return 1;
	}

	public int level2() {
		// Level 2
		// For the last 2 sticks the computer would not pick random but will pick only
		// one stick
		Scanner reader = new Scanner(System.in);

		System.out.printf("******Welcome to level 2******" + "\n");
		sticks = 31;
		while (sticks > 0) {

			System.out.printf("There are " + sticks + " sticks" + "\n");

			//computer will pick only one stick when only 1 or 2 sticks left
			if ((sticks == 2) || (sticks == 1)) {
				int csticks = 1;
				sticks = sticks - csticks;
				System.out.printf("The computer removed " + csticks + " stick" + "\n");
			} else {
				int csticks = (int) (Math.random() * 2 + 1);// csticks is the number of sticks the computer has

				sticks = sticks - csticks;
				System.out.printf("The computer removed " + csticks + " sticks" + "\n");
			}
			if (sticks <= 0) {
				System.out.printf("You won the game!" + "\n");
				money = money + 400; //Add virtual money to player's total amount when player wins
				System.out.printf("You made virtual $" + money + "\n");

				// ask player if he/she wants to go to level 3
				Scanner in = new Scanner(System.in);
				System.out.printf("Type 'Y' if you are ready to play the next level" + "\n");
				
				char yesOrNo = in.next().charAt(0);
				if ((yesOrNo == 'Y') || (yesOrNo == 'y')) {
					PickupSticks pickupsticks = new PickupSticks();
					pickupsticks.level3();
					in.close();
				}

				break; //Exit the game if 'Y' is not entered

			}

			System.out.printf("There are " + sticks + " sticks" + "\n");

			while (true) {

				try {
					System.out.printf("Type the number of sticks you want to remove 1 or 2" + "\n");
					reader = new Scanner(System.in);
					//Let player know to enter 1 or 2 only if he/she entered any other number
					do {

						psticks = reader.nextInt();
						System.out.printf("Please select the number 1 or 2" + "\n");

					} while ((psticks > 2) || (psticks <= 0));

					System.out.printf("You removed " + psticks + " sticks" + "\n");
					sticks = sticks - psticks; //subtract the no. of sticks from total sticks 

					break;
				} 
					//IF by mistake anything entered other than the number will ask player to enter number and not break the game
					catch (InputMismatchException | NumberFormatException ex) {
					System.out.printf("I said an Integer..." + "\n");
				}
			}
			//If Player lose the game, the level will re-start
			if (sticks <= 0) {
				System.out.printf("The player lost!" + "\n");
				System.out.printf("Try again." + "\n");
				sticks = 31;
			}
		}

		return 1;
	}

	public int level3() {
		// level 3
		// When the last 3 sticks left the computer will pick 2
		Scanner reader = new Scanner(System.in);

		{
			System.out.printf("******Welcome to level 3******" + "\n");
			sticks = 31;
			while (sticks > 0) {
				int csticks = 0;
				System.out.printf("There are " + sticks + " sticks" + "\n");
				if ((sticks == 2) || (sticks == 1)) {
					csticks = 1;
					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " stick" + "\n");

				} else if (sticks == 3) {
					csticks = 2;
					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " sticks" + "\n");

				} else {
					csticks = (int) (Math.random() * 2 + 1);// csticks is the number of sticks the computer has

					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " sticks" + "\n");
				}

				if (sticks <= 0) {
					System.out.printf("You won the game!" + "\n");
					money = money + 600;
					System.out.printf("You made virtual $" + money + "\n");

					// Ask player if he/she wants to go to level 4

					Scanner in = new Scanner(System.in);
					System.out.printf("Type 'Y' if you are ready to play the next level" + "\n");
					char yesOrNo = in.next().charAt(0);
					if ((yesOrNo == 'Y') || (yesOrNo == 'y')) {
						PickupSticks pickupsticks = new PickupSticks();
						pickupsticks.level4();
						in.close();
					}

					break; //Exit the game

				}
				System.out.printf("There are " + sticks + " sticks" + "\n");

				while (true) {

					try {
						System.out.printf("Type the number of sticks you want to remove 1 or 2" + "\n");
						reader = new Scanner(System.in);
						
						//Let player know to enter 1 or 2 only if he/she entered any other number
						do {

							psticks = reader.nextInt();
							System.out.printf("Please select the number 1 or 2" + "\n");

						} while ((psticks > 2) || (psticks <= 0));

						System.out.printf("You removed " + psticks + " sticks" + "\n");
						sticks = sticks - psticks;

						break;
					}
					//IF by mistake anything entered other than the number will ask player to enter number and not break the game
					catch (InputMismatchException | NumberFormatException ex) {
						System.out.printf("I said an Integer..." + "\n");
					}
				}

				if (sticks <= 0) {
					System.out.printf("You lost the game!" + "\n");
					System.out.printf("Try again" + "\n");
					sticks = 31;

				}
			}
		}
		return 1;
	}

	public int level4() {
		// level 4
		// When the last 5 sticks left the computer will pick 1
		Scanner reader = new Scanner(System.in);

		{
			System.out.printf("******Welcome to level 4******" + "\n");
			sticks = 31;
			while (sticks > 0) {
				int csticks = 0;
				System.out.printf("There are " + sticks + " sticks" + "\n");
				if ((sticks == 2) || (sticks == 1)) {
					csticks = 1;
					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " stick" + "\n");

				} else if (sticks == 3) {
					csticks = 2;
					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " sticks" + "\n");

				} else if (sticks == 5) {
					csticks = 1;
					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " sticks" + "\n");

				}

				else {
					csticks = (int) (Math.random() * 2 + 1);// csticks is the number of sticks the computer has

					sticks = sticks - csticks;
					System.out.printf("The computer removed " + csticks + " sticks" + "\n");
				}

				if (sticks <= 0) {
					System.out.printf("Congratulations! You completed all fourl levels of the game!" + "\n");
					money = money + 800; //Add virtual money to players total amount
					System.out.printf("You made virtual $" + money + "ENJOY!"+"\n");

					System.exit(0);

				}

				System.out.printf("There are " + sticks + " sticks" + "\n");

				while (true) {

					try {
						System.out.printf("Type the number of sticks you want to remove 1 or 2" + "\n");
						reader = new Scanner(System.in);
						//Let player know to enter 1 or 2 only if he/she entered any other number
						do {

							psticks = reader.nextInt();
							System.out.printf("Please select the number 1 or 2" + "\n");

						} while ((psticks > 2) || (psticks <= 0));

						System.out.printf("You removed " + psticks + " sticks" + "\n");
						sticks = sticks - psticks;

						break;
					}
					//IF by mistake anything entered other than the number will ask player to enter number and not break the game
					catch (InputMismatchException | NumberFormatException ex) {
						System.out.printf("I said an Integer..." + "\n");
					}
				}
				//If player lose the game, re-start the level
				if (sticks <= 0) {
					System.out.printf("You lost the game!" + "\n");
					System.out.printf("Try again" + "\n");
					sticks = 31;

				}

			}
		}
		return 1;
	}

}