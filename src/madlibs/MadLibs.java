/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package madlibs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dylan
 */
public class MadLibs {

    Scanner scanner = new Scanner(System.in);
    String story;
    String name;
    String adjective1, adjective2, adjective3;
    String noun1, noun2, noun3;
    String adverb;
    String randomNum;
    Random rand = new Random();
    Boolean noun1Set, noun2Set, adj1Set, adj2Set = false;

    //access files using relative file paths
    File adjectives = new File("src/files/28K adjectives.txt");
    File nouns = new File("src/files/91K nouns.txt");
    File adverbs = new File("src/files/6K adverbs.txt");

    //Getters
    public String getStory() {
        return story;
    }

    public String getName() {
        return name;
    }

    public String getAdjective1() {
        return adjective1;
    }

    public String getAdjective2() {
        return adjective2;
    }

    public String getAdjective3() {
        return adjective3;
    }

    public String getNoun1() {
        return noun1;
    }

    public String getNoun2() {
        return noun2;
    }

    public String getNoun3() {
        return noun3;
    }

    public String getAdverb() {
        return adverb;
    }

    public String getRandomNum() {
        return randomNum;
    }

    //Setters
    public void setStory(String newStory) {
        this.story = newStory;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAdjective1(String newAdj1) throws FileNotFoundException {
        try {
            checkAdjective(newAdj1);
            this.adjective1 = newAdj1;
            noun1Set = true;
        } catch (NullPointerException a) {
            System.err.println("Invalid entry");
            enterAdjective1();
        }
    }

    public void setAdjective2(String newAdj2) throws FileNotFoundException {
        try {
            checkAdjective(newAdj2);
            this.adjective2 = newAdj2;
            noun1Set = true;
        } catch (NullPointerException a) {
            System.err.println("Invalid entry");
            enterAdjective2();
        }
    }

    public void setAdjective3(String newAdj3) throws FileNotFoundException {
        try {
            checkAdjective(newAdj3);
            this.adjective1 = newAdj3;
            noun1Set = true;
        } catch (NullPointerException a) {
            System.err.println("Invalid entry");
            enterAdjective3();
        }
    }

    //check if entered adjective is valid
    public void checkAdjective(String adjInput) throws FileNotFoundException {
        Scanner nounScan = new Scanner(adjectives);
        String currentAdjective = "";
        while (nounScan.hasNextLine()) {//scan entire document
            try {
                currentAdjective = nounScan.next();
                if (currentAdjective.equals(adjInput)) {
                    break;
                }
            } catch (NoSuchElementException e) {
                //print error message with red text
                System.out.println("\033[1;31m" + "Invalid input, '" + adjInput + "' is not an adjective");
                //ask the user for input again if original entry is invalid
                if (adj1Set == false) {
                    enterAdjective1();
                } else if (adj2Set == false) {
                    enterAdjective2();
                } else {
                    enterAdjective3();
                }
            }
        }
    }

    public void setNoun1(String newNoun1) throws FileNotFoundException {
        try {
            checkNoun(newNoun1);
            this.noun1 = newNoun1;
            noun1Set = true;
        } catch (NullPointerException a) {
            System.err.println("Invalid entry");
            enterNoun1();
        }
    }

    public void setNoun2(String newNoun2) throws FileNotFoundException {
        try {
            checkNoun(newNoun2);
            this.noun2 = newNoun2;
            noun1Set = true;
        } catch (NullPointerException a) {
            System.err.println("Invalid entry");
            enterNoun2();
        }
    }

    public void setNoun3(String newNoun3) throws FileNotFoundException {
        try {
            checkNoun(newNoun3);
            this.noun3 = newNoun3;
            noun1Set = true;
        } catch (NullPointerException a) {
            System.err.println("Invalid entry");
            enterNoun3();
        }
    }

    //check if entered noun is valid
    public void checkNoun(String nounInput) throws FileNotFoundException {
        Scanner nounScan = new Scanner(nouns);
        String currentNoun = "";
        while (nounScan.hasNextLine()) {//scan entire document
            try {
                currentNoun = nounScan.next();
                if (currentNoun.equals(nounInput)) {
                    break;
                }
            } catch (NoSuchElementException e) {
                //print error message with red text
                System.out.println("\033[1;31m" + "Invalid input, '" + nounInput + "' is not a noun");
                //ask the user for input again if original entry is invalid
                if (noun1Set == false) {
                    enterNoun1();
                } else if (noun2Set == false) {
                    enterNoun2();
                } else {
                    enterNoun3();
                }
            }
        }
    }

    public void setAdverb(String newAdverb) throws FileNotFoundException {
        checkAdverb(newAdverb);
        this.adverb = newAdverb;
    }

    //check whether adverb is valid
    public void checkAdverb(String adverbInput) throws FileNotFoundException {
        Scanner advScan = new Scanner(adverbs);
        String currentAdverb = "";
        while (advScan.hasNextLine()) {//scan entire documen
            try {
                currentAdverb = advScan.next();
                if (currentAdverb.equals(adverbInput)) {
                    break;
                }
            } catch (NoSuchElementException e) {
                //ask the user for input again if original entry is invalid
                System.out.println("\033[1;31m" + "Invalid input, '" + adverbInput + "' is not an adverb");
                enterAdverb();
            }
        }
    }

    public void setRandomNums() {
        int num = Math.abs(rand.nextInt() % 50);
        int index = 0;
        int[] numberHolder = new int[3];
        while (index < numberHolder.length) {
            numberHolder[index] = num + index;
            index++;
        }
        randomNum = "approximately " + numberHolder[0];
    }

    public void printInstrunctions() {
        System.out.println("Welcome to Mad Libs; to play, enter the following "
                + "words \n"
                + "correctly and a story will be generated using your input.");
    }

    public void enterName() {
        System.out.println("Enter a name: ");
        setName(scanner.nextLine());
    }

    public void enterNoun1() throws FileNotFoundException {
        System.out.println("Enter noun 1: ");
        setNoun1(scanner.nextLine());
    }

    public void enterNoun2() throws FileNotFoundException {
        System.out.println("Enter noun 2: ");
        setNoun2(scanner.nextLine());
    }

    public void enterNoun3() throws FileNotFoundException {
        System.out.println("Enter noun 3: ");
        setNoun3(scanner.nextLine());
    }

    public void enterAdjective1() throws FileNotFoundException {
        System.out.println("Enter adjective 1: ");
        setAdjective1(scanner.nextLine());
    }

    public void enterAdjective2() throws FileNotFoundException {
        System.out.println("Enter adjective 2: ");
        setAdjective2(scanner.nextLine());
    }

    public void enterAdjective3() throws FileNotFoundException {
        System.out.println("Enter adjective 3: ");
        setAdjective3(scanner.nextLine());
    }

    public void enterAdverb() throws FileNotFoundException {
        System.out.println("Enter an adjverb: ");
        setAdverb(scanner.nextLine());
    }

    public void constructStory() {
        String story;
        int num = Math.abs(rand.nextInt() % 3);
        switch (num) {
            case 0:
                //story 1
                // story from http://www.redkid.net/cgi-bin/madlibs/dogs.pl
                story = "If I had a puppy I'd name it " + getName()
                        + " It has often been said that \"a dog is a man's best "
                        + getNoun1() + ". Dogs\n" + "are very " + getAdjective1()
                        + " and can be taught many " + getAdjective2() + " tricks. A dog can "
                        + "be trained to carry a " + getNoun2() + " in its mouth.\n"
                        + "And if you throw its " + getNoun3() + ", it will run and fetch "
                        + "it. Dogs\n" + "will also bark " + getAdverb() + " if someone "
                        + "tries to break into your\n" + "house during the night."
                        + " One of the most popular canine pets\n"
                        + "today is the Spaniel. Spaniels have curly \n"
                        + "coats and " + getAdjective3() + " ears. They also live to be "
                        + getRandomNum() + " years old. ";
                setStory(story);
                break;
            case 1:
                //story 2
                // story from http://www.redkid.net/cgi-bin/madlibs/dogs.pl
                story = "If I had a puppy I'd name it " + getName()
                        + " It has often been said that \"a dog is a man's best "
                        + getNoun1() + ". Dogs\n" + "are very " + getAdjective1()
                        + " and can be taught many " + getAdjective2() + " tricks. A dog can "
                        + "be trained to carry a " + getNoun2() + " in its mouth.\n"
                        + "And if you throw its " + getNoun3() + ", it will run and fetch "
                        + "it. Dogs\n" + "will also bark " + getAdverb() + " if someone "
                        + "tries to break into your\n" + "house during the night."
                        + " One of the most popular canine pets\n"
                        + "today is the Spaniel. Spaniels have curly \n"
                        + "coats and " + getAdjective3() + " ears. They also live to be "
                        + getRandomNum() + " years old. ";
                setStory(story);
                break;
            default:
                //story 3
                // story from http://www.redkid.net/cgi-bin/madlibs/dogs.pl
                story = "If I had a puppy I'd name it " + getName()
                        + " It has often been said that \"a dog is a man's best "
                        + getNoun1() + ". Dogs\n" + "are very " + getAdjective1()
                        + " and can be taught many " + getAdjective2() + " tricks. A dog can "
                        + "be trained to carry a " + getNoun2() + " in its mouth.\n"
                        + "And if you throw its " + getNoun3() + ", it will run and fetch "
                        + "it. Dogs\n" + "will also bark " + getAdverb() + " if someone "
                        + "tries to break into your\n" + "house during the night."
                        + " One of the most popular canine pets\n"
                        + "today is the Spaniel. Spaniels have curly \n"
                        + "coats and " + getAdjective3() + " ears. They also live to be "
                        + getRandomNum() + " years old. ";
                setStory(story);
                break;
        }
    }

    public void play() throws FileNotFoundException {
        enterName();
        enterNoun1();
        enterNoun2();
        enterNoun3();
        enterAdjective1();
        enterAdjective2();
        enterAdjective3();
        enterAdverb();
        setRandomNums();
        constructStory();
        System.out.print(getStory());
    }

    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        MadLibs game = new MadLibs();
        game.printInstrunctions();
        game.play();
    }
}
