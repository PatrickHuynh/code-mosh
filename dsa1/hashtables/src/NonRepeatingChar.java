import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NonRepeatingChar {
    public Character firstNonRepeatingCharacter(String str){
        Map<Character, Integer> map = new HashMap<>();
        var charArray = str.toCharArray();
        for (Character chr : charArray){
            var count = map.containsKey(chr) ? map.get(chr) : 0;
            map.put(chr, count+1);
        }
        for (Character chr: charArray){
            if (map.get(chr) == 1)
                return chr;
        }
        return Character.MIN_VALUE;
    }

    public Character firstRepeatedCharacter(String str){
        Set<Character> charSet = new HashSet<>();
        for (Character chr : str.toCharArray()){
            if (charSet.contains(chr))
                return chr;
            charSet.add(chr);
        }
        return Character.MIN_VALUE;
    }
}
