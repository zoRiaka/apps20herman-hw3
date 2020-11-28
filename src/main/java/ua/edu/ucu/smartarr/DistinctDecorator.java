package ua.edu.ucu.smartarr;

import java.util.Arrays;
import java.util.LinkedHashSet;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    private Object[] begrray;

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        begrray = smartArray.toArray();
    }

    @Override
    public Object[] toArray() {
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>(Arrays.asList(begrray));
        Object[] withoutDuplicates = linkedHashSet.toArray(new Object[] {});
        return withoutDuplicates;
    }

    @Override
    public String operationDescription() {
        return "All elements in array are unique.";
    }

    @Override
    public int size() {
        return new DistinctDecorator(smartArray).toArray().length;
    }
}
