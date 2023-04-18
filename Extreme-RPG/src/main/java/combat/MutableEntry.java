package combat;

public class MutableEntry<K, V,J> {//implements Map.Entry<K, V> {
    private K key;
    private V value;

    private J massage;


    public MutableEntry(K key, V value, J massage) {
        this.key = key;
        this.value = value;
        this.massage = massage;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
    public J getMassage() {
        return massage;
    }

    public void setValue(V value) {
        V oldValue = this.value;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }
    public void setMassage(J massage) {
        this.massage = massage;
    }
}
