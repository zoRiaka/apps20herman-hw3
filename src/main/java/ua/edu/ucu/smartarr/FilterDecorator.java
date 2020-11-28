package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private Object[] begrray;
    private MyPredicate predicate;
    private int newLenght;

    public FilterDecorator(SmartArray smartArr, MyPredicate myPredicate) {
        super(smartArr);
        begrray = smartArray.toArray();
        predicate = myPredicate;
    }

    @Override
    public Object[] toArray() {
        Object[] newAr = new Object[size()];
        int newSize = 0;
        for (int i = 0; i < begrray.length; i++) {
            if(predicate.test(begrray[i])) {
                newAr[newSize] = begrray[i];
                newSize++;
            }
        }
        newLenght = newSize;
        return newAr;
    }

    @Override
    public String operationDescription() {
        return "All elements in array satisfy MyPredicate.";
    }

    @Override
    public int size() {
        int newSize = 0;
        for (int i = 0; i < begrray.length; i++) {
            if(predicate.test(begrray[i])) {
                newSize++;
            }
        }
        newLenght = newSize;
        return newLenght;
    }
}
