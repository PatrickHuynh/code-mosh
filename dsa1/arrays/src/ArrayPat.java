public class ArrayPat {
    public static int[] thisArray;

    public ArrayPat(int len) {
        thisArray = new int[len];
    }

    public void print (){
        for (int i = 0; i < thisArray.length; i++){
            System.out.println(thisArray[i]);
        }
    }
    public static void insert(int number){
        int[] newArray = new int[thisArray.length+1];
        int i = 0;
        for (int num: thisArray){
            newArray[i] = thisArray[i];
            i++;
        }
        newArray[newArray.length-1] = number;
        thisArray = newArray;
    }
    public static void removeAt(int idx){
        if (idx < 0 || idx >= (thisArray.length-1)){
            throw new IllegalArgumentException();
        }
        int[] newArray;
        if (thisArray.length-1 == 0){
            thisArray = new int[0];
            return;
        }
        newArray = new int[thisArray.length-1];
        int j = 0;
        for (int i=0; i < thisArray.length; i++){
            if (i != idx) {
                newArray[j] = thisArray[i];
                j++;
            }
        }
        thisArray = newArray;
    }
    public static int indexOf(int number){
        for (int i = 0; i < thisArray.length; i++){
            if (thisArray[i]==number)
                return i;
        }
        return -1;
    }

    public static int max(){
        int currentNumber = thisArray[0];
        for (int num: thisArray){
            if (currentNumber < num){
                currentNumber = num;
            }
        }
        return currentNumber;
    }

    public static int[] intersect(int[] inputArray){
        int[] commonItems = new int[inputArray.length + thisArray.length];
        int countItems = 0;
        for (int numA: thisArray){
            for (int numB: inputArray){
                if (numA == numB){
                    commonItems[countItems] = numA;
                    countItems++;
                }
            }
        }
        int[] outputArray = new int[countItems];
        for (int i = 0; i < countItems; i++){
            outputArray[i] = commonItems[i];
        }
        return outputArray;
    }

    public static void reverse(){
        int[] newArray = new int[thisArray.length];
        int j = 0;
        for (int i = thisArray.length-1; i >= 0; i--){
            newArray[j] = thisArray[i];
            j++;
        }
        thisArray = newArray;
    }

    public static void insertAt(int item, int idx){
        int[] newArray = new int[thisArray.length+1];
        int j = 0;
        for (int i = 0; i < newArray.length; i++){
            if (j != idx) {
                newArray[i] = thisArray[j];
                j++;
            } else {
                newArray[i] = item;
            }
        }
        thisArray = newArray;
    }
}
