import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {

    private LinkedList[] map;
    private int tableSize;

    private class KeyValuePair{
        private int key;
        private String value;
        private KeyValuePair(int keyInput, String valueInput){
            this.key = keyInput;
            this.value = valueInput;
        }
    }

    public HashTable(int size){
        map = new LinkedList[size];
        tableSize = size;
    }

    private boolean isAddressInitialised(int address){
        return map[address] != null;
    }

    private void initialiseAddress(int address){
        LinkedList<KeyValuePair> kVPair = new LinkedList();
        map[address] = kVPair;
    }

    private int hashAddress(int key){
        return key % tableSize;
    }

    // put
    public void put(int key, String value){
        int address = hashAddress(key);
        if (!isAddressInitialised(address))
            initialiseAddress(address);
        KeyValuePair kVPair = new KeyValuePair(key, value);
        LinkedList<KeyValuePair> mapList = map[address];
        for (KeyValuePair kvp : mapList){
            if (kvp.key == key){
                kvp.value = value;
                return;
            }
        }
        mapList.add(kVPair);
    }

    // get
    public String get(int key){
        int address = hashAddress(key);
        LinkedList<KeyValuePair> mapList = map[address];
        if (mapList != null) {
            for (KeyValuePair kvp: mapList){
                if (kvp.key == key) {
                    return kvp.value;
                }
            }
        }
        return null;
    }

    // remove
    public void remove(int key){
        int address = hashAddress(key);
        LinkedList<KeyValuePair> mapList = map[address];
        if (mapList == null)
            throw new IllegalStateException();
        
        for (int i = 0; i < mapList.size(); i++){
            KeyValuePair kvp = mapList.get(i);
            if (kvp.key == key){
                mapList.remove(i);
                return;
            }
        }
        throw new IllegalArgumentException("Key " + key + " not found");
    }

}
