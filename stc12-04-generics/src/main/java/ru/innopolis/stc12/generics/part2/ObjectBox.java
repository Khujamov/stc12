package ru.innopolis.stc12.generics.part2;


import org.apache.log4j.Logger;
import ru.innopolis.stc12.generics.exceptions.MyCustomException;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ObjectBox<T> {
    private static Logger logger = Logger.getLogger(ObjectBox.class);
    Set<T> enterSet;

    public ObjectBox(Set<T> enterSet) {
        this.enterSet = enterSet;
    }

    public ObjectBox() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectBox<?> objectBox = (ObjectBox<?>) o;
        return Objects.equals(this.enterSet, objectBox.enterSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enterSet);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "enterSet=" + this.enterSet +
                '}';
    }

    void addObject(T obj) {
        this.enterSet.add(obj);
    }

    void removeObject(T obj) {
        this.enterSet.remove(obj);
    }

    void dump() {
        logger.info(this.toString());
    }

    public int summator() throws MyCustomException {
        int result = 0;
        if (this.enterSet.iterator().next() instanceof Number) {

            for (T num : this.enterSet) {
                result +=  Integer.parseInt(num.toString());
            }
        } else throw new MyCustomException();
        return result;
    }

    public Set<Integer> splitter(int divider) throws MyCustomException {
        Set<Integer> result = new TreeSet<>();
        if (this.enterSet.iterator().next() instanceof Number) {
            for (T num : this.enterSet) {
                result.add(((Number) num).intValue() / divider);
            }
        } else throw new MyCustomException();
        return result;
    }
}
