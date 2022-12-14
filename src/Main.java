public class Main {

    /*
        Use the following methods:
            .length()
            .substring(start,finish) doesn't include finish
            .substring(start) goes to the end
            .indexOf(someString)
            someString.equals(otherString)
     */
    public static void main(String[] args) {
        System.out.println(VowelCount("This is a string."));
        System.out.println("Correct output: 4");
        System.out.println(VowelCount(""));
        System.out.println("Correct output: 0");
        System.out.println(VowelCount("AEIOU"));
        System.out.println("Correct output: 5");
        System.out.println(VowelCount("A/EI$&^*$OU56408"));
        System.out.println("Correct output: 5");
        ///////////////////////////////////////////

        System.out.println(VowelRemover("Remove all of the vowels."));
        System.out.println("Correct output: Rmv ll f th vwls.");
        System.out.println(VowelRemover("I don't know."));
        System.out.println("Correct output: Rmv ll f th vwls.");
        System.out.println();
        ///////////////////////////////////////////
        System.out.println(ContainsSubstring("Sentence","ten"));
        System.out.println("Sentence contains ten: true");
        System.out.println(ContainsSubstring("Lanyard","yard"));
        System.out.println("Lanyard contains yard: true");
        System.out.println();
        ///////////////////////////////////////////
        System.out.println(ReverseString("ABCDEF"));
        System.out.println("Correct output: FEDCBA");

        ///////////////////////////////////////////
        System.out.println(PalindromeChecker("level"));
        System.out.println("Correct output: true");
    }

    /**
     * Count the vowels (a,e,i,o,u) in the input string regardless of case
     * @param input String
     * @return vowel count int
     */
    public static int VowelCount(String input){
        int length = input.length();
        String lowerCaseInput = input.toLowerCase();
        int count = 0;
        for(int i = 0; i<length; i++){
            String letter = lowerCaseInput.substring(i,i+1);
            if(letter.equals("a")||letter.equals("e")||letter.equals("i")
            ||letter.equals("o")||letter.equals("u")){
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a string with all vowels removed regardless of case
     * @param input String
     * @return String with no vowels
     */
    public static String VowelRemover(String input){
        /*
        Solution 1: using regex
        String newString = input.replaceAll("[aeiouAEIOU]","");
        return newString;*/

        /*
        Solution 2*/
        int length = input.length();
        String noVowels = "";
        for(int i = 0; i<length; i++){
            String letter = input.substring(i,i+1);
            if(!(letter.toLowerCase().equals("a")||letter.toLowerCase().equals("e")||letter.toLowerCase().equals("i")
                    ||letter.toLowerCase().equals("o")||letter.toLowerCase().equals("u"))){
                noVowels = noVowels + letter;
            }
        }
        return noVowels;

        /*
        Smith's Solution
        String output = "";
        for(int i = 0; i<input.length(); i++){
            String letter = input.substring(i,i+1).toLowerCase();
            if(!letter.equals("a") && !letter.equals("e") && !letter.equals("i") && !letter.equals("o") && !letter.equals("u")){
                output += input.substring(i,i+1);
            }
        }
        return output;*/

    }

    /**
     * Determine if a substring target is contained in a given string
     * @param input - Given string
     * @param target - String being looked for
     * @return true if target found, false otherwise
     */
    public static boolean ContainsSubstring(String input, String target){
        /* Method 1 - similar to AP Classroom */
        int inputLength = input.length();
        int targetLength = target.length();
        int maxLength = inputLength - targetLength;
        for(int i = 0; i<= maxLength; i++){
            String currentPortion = input.substring(i,i+targetLength);
            if(currentPortion.equals(target)){
                return true;
            }
        }
        return false;

        /* Method 2
        return input.contains(target);
        return input.toLowerCase().contains(target.toLowerCase()) //if not case sensitive
        */


        /* Method 3
        return input.indexOf(target) >= 0;*/
    }

    /**
     * Reverses a given string
     * @param input String
     * @return reversed input String
     */
    public static String ReverseString(String input){
        String output = "";
        int inputLength = input.length();
        for(int i = inputLength-1; i>=0; i--){
            String singleChar = input.substring(i,i+1);
            output = output + singleChar;
        }
        return output;
    }

    /**
     * Determines if a given string is palindrome
     * @param input String
     * @return true if given string is a palindrome, false otherwise
     */
    public static boolean PalindromeChecker(String input){

        return input.equals(ReverseString(input));
    }
}
