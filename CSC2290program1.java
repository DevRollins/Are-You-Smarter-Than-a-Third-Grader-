
/**
 *
 * @author lvlca
 */
import java.util.*;

public class CSC2290program1 {
    // Devin Rollins
    // 11 February 2022
    // drollins1108@gmail.com
    // CSC 2290-001
    // Are You Smarter Than a Third Grader?
    /*
    “I will practice academic and personal integrity and excellence of character and expect the same 
from others.” 
As an academic community, Florida Southern College is firmly committed to honor and integrity 
in the pursuit of knowledge.  Therefore, as a member of this academic community, each student 
acknowledges  responsibility  for  his  or  her  actions  and  commits  to  the  highest  standards  of 
integrity.  In doing so through this Honor Code, each student makes a covenant with the college 
not to engage in any form of academic dishonesty, fraud, cheating, or theft.  Further information 
on the Honor Code is available in the current Catalog. 
      
     */
    /**
     */
    public static int additionCounter = 0; // Variables indicating the amount of times that each choice have been played
    public static int subtractionCounter = 0;
    public static int multiplicationCounter = 0;
    public static int divisionCounter = 0;
    public static int guessGameCounter = 0;
    public static int mathPracticeCounter = 0;
    public static float totalPracticeTime = 0; // Variable that indicates the total amount of practice time
    public static int additionHighScore = 0; // Variable that indicates the high scores
    public static int subtractionHighScore = 0;
    public static int multiplicationHighScore = 0;
    public static int divisionHighScore = 0;
    public static float guessGameHighScore = 0;
    public static float timeOnApp = 0;

    public static void showMainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println(" |       Are You Smarter Than a Third Grader        | ");
        System.out.println(" |--------------------------------------------------|");
        System.out.println(" |  1. Math Practice                                |");
        System.out.println(" |  2. Race to the Finish (Addition)                |");
        System.out.println(" |  3. Race to the Finish (Subtraction)             |");
        System.out.println(" |  4. Race to the Finish (Multiplication)          |");
        System.out.println(" |  5. Race to the Finish (Division)                |");
        System.out.println(" |  6. Guess the Number                             |");
        System.out.println(" |  7. Exit                                         |");
        System.out.println(" ---------------------------------------------------");
        System.out.print(" Enter your choice: ");
    }   //End of showMainMenu()

    // Practice Menu
    public static void showMathPracticeMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println(" |        Let's Practice Some Math Questions        |");
        System.out.println(" |--------------------------------------------------|");
        System.out.println(" |  1. Addition                                     |");
        System.out.println(" |  2. Subtraction                                  |");
        System.out.println(" |  3. Multiplication                               |");
        System.out.println(" |  4. Division                                     |");
        System.out.println(" |  5. Return to Main Menu                          |");
        System.out.println(" ---------------------------------------------------");
        System.out.print(" Enter your choice: ");
    }   //end of showMathPracticeMenu()

    // Read and Verify Choice
    public static int readAndVerifyChoice(Scanner input, int numChoices) {
        while (true) {
            String userInput = input.nextLine();
            int length = userInput.length();
            if (length != 1 || Integer.parseInt(userInput) == 0) {  //If length of user input is not 1, prompt them to try again
                System.out.println();
                System.out.println("Invalid choice. Please try again.");
                System.out.print(" Enter your choice: ");
            } else if (containsOnlyDigits(userInput)) { //If the user's input passes the previous parameter and contains only digits, return that choice
                int userInt = Integer.parseInt(userInput);
                if (userInt <= numChoices && userInt >= 1) {
                    return userInt;
                } else { // Fail cases that work as a "Catch all"
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
                    System.out.print(" Enter your choice: ");
                }
            } else if (!Character.isDigit(userInput.charAt(0))) {
                System.out.println();
                System.out.println("Invalid choice. Please try again.");
            } else {
                System.out.println();
                System.out.println("Invalid choice. Please try again.");
                System.out.print(" Enter your choice: ");
            }
        }
    }   // End of readAndVerifyChoice()

    // Contains Only Digits 
    public static boolean containsOnlyDigits(String userin) {
        boolean digits = true;  //assume that the input is only digits
        int length = userin.length();
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(userin.charAt(i)) == false || userin.equals("")) {
                digits = false; // check if the user's inputis empty or not a digit
            }
        }
        return digits;
    }   //End of containsOnlyDigits() 

    // Read and Verify Int 
    public static int readAndVerifyInt(Scanner in, int num1, int num2, String op) {
        while (true) {
            System.out.printf("%d %s %d = ", num1, op, num2);
            String userSays = in.nextLine();
            if (containsOnlyDigits(userSays) == false || userSays.length() < 1) {
                System.out.println("");
                System.out.println("Invalid entry.Please try again");
                System.out.println("");

            } 
            else if (userSays.contains(".") || userSays.contains(",") || userSays.contains("=")) {
                System.out.println("");
                System.out.println("Invalid entry. Please try again.");  
                System.out.println("");
            }
            else {
                return Integer.parseInt(userSays); //If user's input is an integer, return it to the callee
            }
        }
    }   //End of readAndVerifyInt()

    public static void mathPractice(Scanner in, Random rng) {
        while (true) {
            showMathPracticeMenu();
            long startTime = System.currentTimeMillis(); // Start timer 
            int choice = readAndVerifyChoice(in, 5);
            if (choice == 1) {
                int counter = 0;
                while (true) { // addition 
                    System.out.println("");
                    System.out.println("Here are five Addition questions to practice:");
                    System.out.println("");
                    for (int i = 1; i < 6; i++) {
                        int randomnum1 = 1 + rng.nextInt(12); // Set range for random numbers 
                        int randomnum2 = 1 + rng.nextInt(12);
                        System.out.printf("%d. ", i);
                        int answer = readAndVerifyInt(in, randomnum1, randomnum2, "+"); // If it's not an int, give error message
                        int correct = randomnum1 + randomnum2; // Initialize correct answer 
                        if (answer != correct) {
                            System.out.println("Incorrect. The correct answer is:");
                            System.out.printf("%d + %d = %d", randomnum1, randomnum2, correct); // If the answer is wrong, give right answer
                            System.out.println("");
                        } else if (answer == correct) {   //Check if user's input is correct
                            System.out.println("Correct!");
                            counter++;
                            System.out.println("");
                        }
                    }
                    System.out.printf("\nYou got %d out of 5 correct.\n", counter);
                    System.out.println("You can now practice some more or return to the Main Menu");
                    break;
                }
            } // End of addition practice
            else if (choice == 2) {
                int counter = 0;
                while (true) { // Subtraction
                    System.out.println("");
                    System.out.println("Here are five Subtraction questions to practice:");
                    System.out.println("");
                    for (int i = 1; i < 6; i++) {
                        int randomnum1 = 1 + rng.nextInt(12);
                        int randomnum2 = 1 + rng.nextInt(12);
                        int temp;
                        if (randomnum2 > randomnum1) { // If random number 1 is larger than random number 2, swap them
                            temp = randomnum1;
                            randomnum1 = randomnum2;
                            randomnum2 = temp;
                        }
                        int correct = randomnum1 - randomnum2; // Set correct answer
                        System.out.printf("%d. ", i);
                        int answer = readAndVerifyInt(in, randomnum1, randomnum2, "-");
                        if (answer != correct) {
                            System.out.println("Incorrect. The correct answer is:");
                            System.out.printf("%d - %d = %d", randomnum1, randomnum2, correct);
                            System.out.println("\n");
                        } else if (answer == correct) {
                            System.out.println("Correct!");
                            counter++;
                            System.out.println("");
                        }
                    }
                    System.out.printf("\nYou got %d out of 5 correct.\n", counter);
                    System.out.println("You can now practice some more or return to the Main Menu");
                    break; // Break back into the practice menu
                }
            } // End of subtraction practice
            else if (choice == 3) {
                int counter = 0;
                while (true) { // Multiplication
                    System.out.println("");
                    System.out.println("Here are five Multiplication questions to practice:");
                    System.out.println("");
                    for (int i = 1; i < 6; i++) {
                        int randomnum1 = 1 + rng.nextInt(12);
                        int randomnum2 = 1 + rng.nextInt(12);
                        int correct = randomnum1 * randomnum2;
                        System.out.printf("%d. ", i);
                        int answer = readAndVerifyInt(in, randomnum1, randomnum2, "x");
                        if (answer != correct) {
                            System.out.println("Incorrect. The correct answer is:");
                            System.out.printf("%d x %d = %d", randomnum1, randomnum2, correct);
                            System.out.println();
                        } else if (answer == correct) {
                            System.out.println("Correct!");
                            counter++;
                            System.out.println("");
                        }
                    }
                    System.out.printf("\nYou got %d out of 5 correct.\n", counter);
                    System.out.println("You can now practice some more or return to the Main Menu");
                    break;
                }
            } //End of multiplication practice
            else if (choice == 4) {
                int counter = 0;
                while (true) { //Division
                    System.out.println("");
                    System.out.println("Here are five Division questions to practice:");
                    System.out.println("");
                    for (int i = 1; i < 6; i++) {
                        int randomnum1 = 1 + rng.nextInt(12);
                        int randomnum2 = 1 + rng.nextInt(12);
                        int dividend = randomnum1 * randomnum2;
                        int correct = dividend / randomnum1;
                        System.out.printf("%d. ", i);
                        int answer = readAndVerifyInt(in, dividend, randomnum1, "/");
                        if (answer != correct) {
                            System.out.println("Incorrect. The correct answer is:");
                            System.out.printf("%d / %d = %d", dividend, randomnum1, correct);
                            System.out.println();
                        } else if (answer == correct) {
                            System.out.println("Correct!");
                            counter++;
                            System.out.println("");
                        }
                    }
                    System.out.printf("\nYou got %d out of 5 correct.\n", counter);
                    System.out.println("You can now practice some more or return to the Main Menu");
                    break;
                }
            } //End of division practice 
            else if (choice == 5) { // Return to main menu
                System.out.println();
                long endTime = System.currentTimeMillis(); // Move to end
                float totalTime = (endTime - startTime) / (float) 1000;
                totalPracticeTime += totalTime;
                int totalMinutes = (int) (totalPracticeTime / 60);
                int totalSeconds = (int) (totalPracticeTime - totalMinutes);
                break;
            }
        }
    }

    // Display the race to the finish menu
    public static void displayRaceToFinishMenu(String op) {
        System.out.println();
        if (op.equals("+")) {
            System.out.println("-----------------------------------------------------");
            System.out.println(" |                Race to the Finish               | ");
            System.out.println(" |-------------------------------------------------| ");
            System.out.println(" |  You have 10 seconds to answer as many          | ");
            System.out.println(" |  addition questions as possible.                | ");
            System.out.println(" |  Both the Questions and the Timer will start    | ");
            System.out.println(" |  once you type anything and click \"Enter\"       | ");
            System.out.println("-----------------------------------------------------");
        } else if (op.equals("-")) {
            System.out.println();
            System.out.println("-----------------------------------------------------");
            System.out.println(" |                Race to the Finish               | ");
            System.out.println(" |-------------------------------------------------| ");
            System.out.println(" |  You have 10 seconds to answer as many          | ");
            System.out.println(" |  subtraction questions as possible.             | ");
            System.out.println(" |  Both the Questions and the Timer will start    | ");
            System.out.println(" |  once you type anything and click \"Enter\"       | ");
            System.out.println("-----------------------------------------------------");
        } else if (op.equals("x")) {
            System.out.println();
            System.out.println("-----------------------------------------------------");
            System.out.println(" |                Race to the Finish               | ");
            System.out.println(" |-------------------------------------------------| ");
            System.out.println(" |  You have 10 seconds to answer as many          | ");
            System.out.println(" |  multiplication questions as possible.          | ");
            System.out.println(" |  Both the Questions and the Timer will start    | ");
            System.out.println(" |  once you type anything and click \"Enter\"       | ");
            System.out.println("-----------------------------------------------------");
        } else if (op.equals("/")) {
            System.out.println();
            System.out.println("-----------------------------------------------------");
            System.out.println(" |                Race to the Finish               | ");
            System.out.println(" |-------------------------------------------------| ");
            System.out.println(" |  You have 10 seconds to answer as many          | ");
            System.out.println(" |  division questions as possible.                | ");
            System.out.println(" |  Both the Questions and the Timer will start    | ");
            System.out.println(" |  once you type anything and click \"Enter\"       | ");
            System.out.println("-----------------------------------------------------");
        }
    }   //End of displayRaceToFinishMenu()

    // Race to the finish 
    public static void raceToTheFinish(Scanner in, Random rng, String op) {
        while (true) {
            if (op.equals("+")) {
                int counter = 0;
                System.out.println();
                displayRaceToFinishMenu("+");
                // Pause for user to press enter
                in.nextLine();
                System.out.println();
                long startTime = System.currentTimeMillis(); // Start timer 
                while (true) {
                    int randomnum1 = 1 + rng.nextInt(12);
                    int randomnum2 = 1 + rng.nextInt(12);
                    int correct = randomnum1 + randomnum2;
                    int answer = readAndVerifyInt(in, randomnum1, randomnum2, "+");
                    if (answer != correct) { //Check if answer is incorrect 
                        System.out.println("Incorrect.");
                    } else {
                        System.out.println("Correct.");
                        counter++;
                    }
                    long endTime = System.currentTimeMillis(); // Stop the timer
                    float totalTime = (endTime - startTime) / (float) 1000; // Set timer to seconds
                    if (totalTime >= 10) {
                        System.out.println();
                        System.out.println("You didn't quite get that last answer in quick enough.");
                        System.out.println("Time is up! Let's see how you did...");
                        System.out.println();
                        additionCounter++;  //Increment the amount of times addition has been ran up
                        counter--;  //Decrement the amount of answers by one given that user was shown a question they couldn't answer

                        if (additionCounter <= 1) {
                            additionHighScore = counter;    //Set high score to the counter if its user's first time playing
                            System.out.printf("This was your first time playing. As such, your\n"
                                    + "%d questions answered in 10 seconds is currently your best!", counter);
                            System.out.println();
                            break;
                        } else if (counter < additionHighScore) { //User did not beat their high score
                            System.out.printf("Good effort, but you'll have to try harder to beat\n"
                                    + "your best score of %d questions answered.", additionHighScore);
                            System.out.println();
                            break;
                        } else if (counter > additionHighScore) { //User beat their high score
                            System.out.printf("Your score of %d questions answered just beat the previous\n"
                                    + "best score of %d. Awesome job!", counter, additionHighScore);
                            System.out.println();
                            additionHighScore = counter;
                            break;
                        }
                        break;  //Break into main menu
                    }
                }
            } else if (op.equals("-")) {
                int counter = 0;
                System.out.println();
                displayRaceToFinishMenu("-");
                // Pause for user to press enter
                in.nextLine();
                System.out.println();
                long startTime = System.currentTimeMillis(); // Start timer 
                while (true) {
                    int randomnum1 = 1 + rng.nextInt(12);
                    int randomnum2 = 1 + rng.nextInt(12);
                    if (randomnum1 < randomnum2) {
                        int temp = randomnum1;
                        randomnum1 = randomnum2;
                        randomnum2 = temp;
                    }
                    int correct = randomnum1 - randomnum2;
                    int answer = readAndVerifyInt(in, randomnum1, randomnum2, "-");
                    if (answer != correct) {
                        System.out.println("Incorrect.");
                    } else {
                        System.out.println("Correct.");
                        counter++;
                    }
                    long endTime = System.currentTimeMillis(); // Move to end
                    float totalTime = (endTime - startTime) / (float) 1000;
                    if (totalTime >= 10) {
                        System.out.println();
                        System.out.println("You didn't quite get that last answer in quick enough.");
                        System.out.println("Time is up! Let's see how you did...");
                        System.out.println();
                        subtractionCounter++;
                        counter--;

                        if (subtractionCounter <= 1) {
                            subtractionHighScore = counter;
                            System.out.printf("This was your first time playing. As such, your\n"
                                    + "%d questions answered in 10 seconds is currently your best!", counter);
                            System.out.println();
                            break;
                        } else if (counter < subtractionHighScore) {
                            System.out.printf("Good effort, but you'll have to try harder to beat\n"
                                    + "your best score of %d questions answered.", subtractionHighScore);
                            System.out.println();
                            break;
                        } else if (counter > subtractionHighScore) {
                            System.out.printf("Your score of %d questions answered just beat the previous\n"
                                    + "best score of %d. Awesome job!", counter, subtractionHighScore);
                            System.out.println();
                            subtractionHighScore = counter;
                            break;
                        }
                        break;
                    }
                }
            } else if (op.equals("x")) {
                int counter = 0;
                System.out.println();
                displayRaceToFinishMenu("x");
                // Pause for user to press enter
                in.nextLine();
                System.out.println();
                long startTime = System.currentTimeMillis(); // Start timer 
                while (true) {
                    int randomnum1 = 1 + rng.nextInt(12);
                    int randomnum2 = 1 + rng.nextInt(12);
                    int correct = randomnum1 * randomnum2;
                    int answer = readAndVerifyInt(in, randomnum1, randomnum2, "x");
                    if (answer != correct) {
                        System.out.println("Incorrect.");
                    } else {
                        System.out.println("Correct.");
                        counter++;
                    }
                    long endTime = System.currentTimeMillis(); // Move to end
                    float totalTime = (endTime - startTime) / (float) 1000;
                    if (totalTime >= 10) {
                        System.out.println();
                        System.out.println("You didn't quite get that last answer in quick enough.");
                        System.out.println("Time is up! Let's see how you did...");
                        System.out.println();
                        multiplicationCounter++;
                        counter--;

                        if (multiplicationCounter <= 1) {
                            multiplicationHighScore = counter;
                            System.out.printf("This was your first time playing. As such, your\n"
                                    + "%d questions answered in 10 seconds is currently your best!", counter);
                            System.out.println();
                            break;
                        } else if (counter < multiplicationHighScore) {
                            System.out.printf("Good effort, but you'll have to try harder to beat\n"
                                    + "your best score of %d questions answered.", multiplicationHighScore);
                            System.out.println();
                            break;
                        } else if (counter > multiplicationHighScore) {
                            System.out.printf("Your score of %d questions answered just beat the previous\n"
                                    + "best score of %d. Awesome job!", counter, multiplicationHighScore);
                            System.out.println();
                            multiplicationHighScore = counter;
                            break;
                        }
                        break;
                    }
                }
            } else if (op.equals("/")) {
                int counter = 0;
                System.out.println();
                displayRaceToFinishMenu("/");
                // Pause for user to press enter
                in.nextLine();
                System.out.println();
                long startTime = System.currentTimeMillis(); // Start timer 
                while (true) {
                    int randomnum1 = 1 + rng.nextInt(12);
                    int randomnum2 = 1 + rng.nextInt(12);
                    int dividend = randomnum1 * randomnum2;
                    int correct = dividend / randomnum2;
                    int answer = readAndVerifyInt(in, dividend, randomnum2, "/");
                    if (answer != correct) {
                        System.out.println("Incorrect.");
                    } else {
                        System.out.println("Correct.");
                        counter++;
                    }
                    long endTime = System.currentTimeMillis(); // Move to end
                    float totalTime = (endTime - startTime) / (float) 1000;
                    if (totalTime >= 10) {
                        System.out.println();
                        System.out.println("You didn't quite get that last answer in quick enough.");
                        System.out.println("Time is up! Let's see how you did...");
                        System.out.println();
                        divisionCounter++;
                        counter--;

                        if (divisionCounter <= 1) {
                            divisionHighScore = counter;
                            System.out.printf("This was your first time playing. As such, your\n"
                                    + "%d questions answered in 10 seconds is currently your best!", counter);
                            System.out.println();
                            break;
                        } else if (counter < divisionHighScore) {
                            System.out.printf("Good effort, but you'll have to try harder to beat\n"
                                    + "your best score of %d questions answered.", divisionHighScore);
                            System.out.println();
                            break;
                        } else if (counter > divisionHighScore) {
                            System.out.printf("Your score of %d questions answered just beat the previous\n"
                                    + "best score of %d. Awesome job!", counter, divisionHighScore);
                            System.out.println();
                            divisionHighScore = counter;
                            break;
                        }
                        break;  //Break into race to finish menu
                    }
                }
            }
            break;  //Break into main menu
        }
    }   //End of raceToTheFinish()

    // Display Guess Menu
    public static void displayGuessMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------");
        System.out.println(" |        How Quickly Can You Guess My Number        |");
        System.out.println(" |---------------------------------------------------|");
        System.out.println(" |  Let's play the childhood number guessin game!    |");
        System.out.println(" |  I'll choose a number between 1 and 100. Your     |");
        System.out.println(" |  job is to guess my number as quickly as you      |");
        System.out.println(" |  can. Can you beat the best previous time?        |");
        System.out.println(" |                                                   |");
        System.out.println(" |       ---Timer starts once you hit\"Enter\"---      |");
        System.out.println("------------------------------------------------------");
    }   //End of displayGuessMenu()

    // Number Guessing Game 
    public static float numberGuessingGame(Scanner in, Random rng) {
        while (true) {
            displayGuessMenu();
            int randomnum = 1 + rng.nextInt(100);   //Randomly generate a number between 1- 100
            in.nextLine();
            System.out.println();
            long startTime = System.currentTimeMillis(); // Start timer 
            while (true) {
                System.out.println();
                System.out.print("Enter your guess (between 1 and 100): "); //Prompt user to guess
                int guess = readAndVerifyGuess(in);
                System.out.println();
                if (guess < randomnum) {    //Check if user's guess is too high or low
                    System.out.println("Your guess is too low.");
                } else if (guess > randomnum) {
                    System.out.println("Your guess is too high.");
                } else {
                    long endTime = System.currentTimeMillis(); // Stop timer when user has guessed the correct number 
                    float totalTime = (endTime - startTime) / (float) 1000;
                    System.out.println("You guessed the correct number!");
                    System.out.printf("Total time taken: %.1f", totalTime);
                    System.out.println();
                    guessGameCounter++; // Increment times playing guessing game up

                    if (guessGameCounter <= 1) {
                        guessGameHighScore = totalTime;
                        System.out.printf("\nThis was your first time playing. As such, your time of "
                                + "%.1f is the current best time!", guessGameHighScore);
                        System.out.println();
                        break;
                    } else if (guessGameHighScore <= totalTime) {
                        System.out.printf("Great effort, but you'll have to try harder to beat your best time "
                                + "of %.1f seconds.", guessGameHighScore);
                        System.out.println();
                        break;
                    } else if (guessGameHighScore > totalTime) {
                        System.out.printf("\nYou just beat your previous best time of %.1f seconds!\n", guessGameHighScore);
                        guessGameHighScore = totalTime;
                        System.out.printf("The new best time is now %.1f seconds.", guessGameHighScore);
                        System.out.println();
                        break;
                    }
                }
            }
            return guessGameHighScore;// Once the user guesses the number, the user breaks out of the guessing game
        }
    }   //End of numberGuessingGame()

    // Read and Verify Guess 
    public static int readAndVerifyGuess(Scanner in) {
        while (true) {
            String guess = in.nextLine();
            if (containsOnlyDigits(guess) == false || guess.length() < 1) {  //Check if user guess contains strings or empty
                System.out.println("Invalid entry. Try again");
            } else {
                return Integer.parseInt(guess);
            }
        }
    }   //End of readAndVerifyGuess()

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random rng = new Random(777);
        long startTime = System.currentTimeMillis(); // Start timer
        while (true) {
            showMainMenu();
            int choice = readAndVerifyChoice(input, 7);
            if (choice == 1) {
                mathPracticeCounter++;
                mathPractice(input, rng);
            } else if (choice == 2) {
                raceToTheFinish(input, rng, "+");
            } else if (choice == 3) {
                raceToTheFinish(input, rng, "-");
            } else if (choice == 4) {
                raceToTheFinish(input, rng, "x");
            } else if (choice == 5) {
                raceToTheFinish(input, rng, "/");
            } else if (choice == 6) {
                numberGuessingGame(input, rng);
            } else if (choice == 7) {
                long endTime = System.currentTimeMillis(); // Move to end
                float totalTime = (endTime - startTime) / (float) 1000;
                String stats;
                System.out.println("");
                System.out.print("\n Do you want to see stats from the app today (yes/no): ");

                stats = input.nextLine();

                if (stats.equals("yes")) {
                    //Do stuff
                    System.out.println("");
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
                    System.out.println("Stats from your visit today:");
                    System.out.println("");
                    int practiceMins = (int) (totalPracticeTime / 60);
                    int practiceSecs = (int) (totalPracticeTime - practiceMins * 60);
                    if (mathPracticeCounter == 0) {
                        System.out.println("1. Time spent on Math Practice: not attempted");
                    } else {
                        System.out.printf("1. Time spent on Math Practice: %d minute(s) and %d second(s)", practiceMins, practiceSecs); // Math Practice Counter        
                    }
                    System.out.println("");
                    System.out.println("2. Most questions answered in 10 seconds:"); // Counters
                    
                    //Subtraction Race to Finish Counter
                    System.out.print("   Addition:       ");    // If addition was attempted, print the high score
                    if (additionCounter == 0) {
                        System.out.println("not attempted");    // Otherwise, print "not attempted"
                    } else {
                        System.out.print(additionHighScore);
                    }

                    //Subtraction Race to Finish Counter
                    System.out.print("   Subtraction:    ");    // If subtraction was attempted, print the high score.
                    if (subtractionCounter == 0) {
                        System.out.println("not attempted");    // Otherwise, print "not attempted"
                    } else {
                        System.out.println(subtractionHighScore);
                    }

                    //Multiplication Race to Finish Counter
                    System.out.print("   Multiplication: ");    // If multiplication was attempted, print the high score
                    if (multiplicationCounter == 0) {
                        System.out.println("not attempted");    // Otherwise, print "not attempted" 
                    } else {
                        System.out.println(multiplicationHighScore);
                    }

                    //Division Race to Finish Counter
                    System.out.print("   Division:       ");    // If division was attempted, print the high score
                    if (divisionCounter == 0) {
                        System.out.println("not attempted");    // Otherwise, print "not attempted"
                    } else {
                        System.out.println(divisionHighScore);
                    }
                    System.out.println("");
                    if (guessGameCounter == 0) {
                        System.out.println("3. Best time for guessing the secret number: not attempted");
                    } else {
                        System.out.printf("3. Best time for guessing the secret number: %d", guessGameHighScore);
                    }
                    System.out.println("");
                    totalTime = totalTime + totalPracticeTime;
                    int minutes = (int) (totalTime / 60);
                    int seconds = (int) (totalTime - minutes * 60); 
                    System.out.printf("Total time spent using app: %d minute(s) and %d second(s)", minutes, seconds);
                    System.out.println("");
                    System.out.println("Hope this was fun!");
                } else {
                    System.out.println("");
                    System.out.println("\n Hope this was fun!");    // Say goodbye to user
                }
                break;
            }
        }
    }   //End of main 
}   //End of class 
