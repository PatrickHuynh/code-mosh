public class Main {
    public static void main(String[] args) {
        NonRepeatingChar nRC = new NonRepeatingChar();
        var j = nRC.firstNonRepeatingCharacter("a green apple");
        System.out.println(j);

        j = nRC.firstRepeatedCharacter("green apple");
        System.out.println(j);

        HashTable hashTable = new HashTable(5);
        hashTable.put(0,"a");
        hashTable.put(0,"b");
        hashTable.put(5,"b");
        hashTable.put(15,"b");
        hashTable.put(4,"c");
        hashTable.put(7,"d");
        hashTable.remove(5);
        String k = hashTable.get(4);
        System.out.println(k);
    }
}