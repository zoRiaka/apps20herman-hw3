package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private Object[] begrray;
    private final MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator compar) {
        super(smartArray);
        begrray = smartArray.toArray();
        comparator = compar;
    }

    @Override
    public Object[] toArray() {
        Arrays.sort(begrray, comparator);
        return begrray;
    }

    @Override
    public String operationDescription() {
        return "All elements in array are sorted by comparator";
    }

    @Override
    public int size() {
        return begrray.length;
    }
}
