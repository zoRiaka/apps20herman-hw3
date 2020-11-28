package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{
    private Object[] begrray;
    private final MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        begrray = smartArray.toArray();
        function = myFunction;
    }

    @Override
    public Object[] toArray() {
        Object[] newAr = new Object[size()];
        for (int i = 0; i < begrray.length; i++) {
            newAr[i] = function.apply(begrray[i]);
        }
        return newAr;
    }

    @Override
    public String operationDescription() {
        return "All elements in array are mapped using MyFunction.";
    }

    @Override
    public int size() {
        return begrray.length;
    }
}
