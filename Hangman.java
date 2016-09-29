/**
 * Created by Lenovo on 29-Sep-16.
 */
public class Hangman {
    String word;
    int tries;
    String dashed;
    int maxTries;
    public Hangman(String word){
        this.word = word;
        this.tries = 0;
        this.dashed = "";
        this.maxTries = 2*(word.length());
        dashIt(word);
        //System.out.println(dashed);
    }

    private void dashIt(String word){
        for(int i = 0; i < word.length(); i++){
            dashed += "_";
        }
    }


    public String enterGuess(String guess){
        if(tries > maxTries){
            return "Sorry you have used up all the allowed tries! the word was " + word;
        }
        if(guess.length() > 1){
            return "Enter only one letter!";
        }
        else if(checkLetter(guess)){
            tries ++;
            if(hasWon()){
                return "You have guessed correctly and have WON! \n" + dashed + "\n took you " + tries + " tries.";
            }
            return "You guessed correctly! \n" + dashed;
        }
        else{
            tries ++;
            return "You guessed incorrectly! \n" + dashed;
        }
    }

    public String getDashed(){
        return dashed;
    }

    private boolean checkLetter(String guess){
        boolean exists = false;
        for(int i=0; i< word.length(); i++ ){
            if(word.charAt(i) == guess.charAt(0)){

               // dashed = dashed.replace(word.charAt(i),guess.charAt(0));

                dashed = dashed.substring(0,i) + guess.charAt(0) + dashed.substring(i+1);
                exists = true;
            }
        }
        if(exists){
            return true;
        }
        else{
            return false;
        }
    }


    private boolean hasWon(){
        if(word.equals(dashed)){
            return true;
        }
        else{
            return false;
        }
    }


}
