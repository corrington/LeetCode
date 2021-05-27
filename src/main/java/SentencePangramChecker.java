import java.util.HashSet;
import java.util.Set;

public class SentencePangramChecker {
    
    // the big and slow version
    public boolean checkIfPangram2(String sentence) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            uniqueChars.add(c);
            if (uniqueChars.size() == 26) return true;
        } // for
        return false;
    } // checkIfPangram()

    // the small and ultra fast version
    public boolean checkIfPangram(String sentence) {
        if ((sentence == null) || (sentence.length() < 26)) return false;

        int[] charsCount = new int[26];
        int uniqueLettersFound = 0;

        for(char ch : sentence.toCharArray()){
            if(charsCount[ch - 'a'] == 0){
                charsCount[ch - 'a']++;
                uniqueLettersFound++;
                if (uniqueLettersFound == 26) return true;
            } // if
        } // for ch

        return false;

    } // checkIfPangram()

} // class SentencePangramChecker
