package ua.edu.ucu;

import java.util.Arrays;
import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        System.out.println(sa.toArray());
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        System.out.println(sa.toArray());
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]
        System.out.println(sa.toArray());

//         Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {
        int year = 2;
        int average = 4;
        SmartArray studentsArray = new BaseArray(students);
        studentsArray = new DistinctDecorator(studentsArray);

        MyPredicate myPredicate = new MyPredicate() {
            @Override
            public boolean test(Object student) {
                if (((Student) student).getYear() == year && ((Student) student).getGPA() >= average) {
                        return true;
                    }
                return false;
            }
        };

        studentsArray = new FilterDecorator(studentsArray, myPredicate);


        MyComparator myComparator = new MyComparator() {
            @Override
            public int compare(Object student1, Object student2) {
                String st2 = ((Student) student2).getSurname();
                return ((Student) student1).getSurname().compareTo(st2);
            }
        };

        studentsArray = new SortDecorator(studentsArray, myComparator);

        MyFunction myFunction = new MyFunction() {
            @Override
            public Object apply(Object student) {
                return ((Student) student).getSurname() + " " + ((Student) student).getName();
            }
        };

        studentsArray = new MapDecorator(studentsArray, myFunction);
        studentsArray = new DistinctDecorator(studentsArray);

        // Hint: to convert Object[] to String[] - use the following code
        Object[] result = studentsArray.toArray();
        return Arrays.copyOf(result, result.length, String[].class);

    }
}
