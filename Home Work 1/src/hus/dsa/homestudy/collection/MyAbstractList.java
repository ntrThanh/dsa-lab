package hus.dsa.homestudy.collection;

public abstract class MyAbstractList<T> implements MyList<T> {
    protected int size;

    public MyAbstractList() {
        size = 0;
    }

    public void checkBoundaries(int limit) {
        if (limit > size || limit < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(get(i) + "\t");
        }

        return stringBuilder.append("\n").toString();
    }
}
