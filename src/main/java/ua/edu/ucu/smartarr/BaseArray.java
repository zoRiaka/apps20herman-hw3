package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] baseArray;

    public BaseArray(Object[] array) {
        baseArray = array;
    }

    @Override
    public Object[] toArray() {
        return baseArray;
    }

    @Override
    public String operationDescription() {
        return "The array is not changed";
    }

    @Override
    public int size() {
        return baseArray.length;
    }
}
