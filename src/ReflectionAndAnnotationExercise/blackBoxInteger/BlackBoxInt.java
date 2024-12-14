package ReflectionAndAnnotationExercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class BlackBoxInt {

    private static final int DEFAULT_VALUE = 0;

    private int innerValue;

    private BlackBoxInt(int innerValue) {
        this.innerValue = innerValue;
    }

    private BlackBoxInt() {
        this.innerValue = DEFAULT_VALUE;
    }

    private void add(int addend) {
        this.innerValue += addend;
    }

    private void subtract(int subtrahend) {
        this.innerValue -= subtrahend;
    }

    private void multiply(int multiplier) {
        this.innerValue *= multiplier;
    }

    private void divide(int divider) {
        this.innerValue /= divider;
    }

    private void leftShift(int shifter) {
        this.innerValue <<= shifter;
    }

    private void rightShift(int shifter) {
        this.innerValue >>= shifter;
    }

    public static class Main {

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            try {
                Constructor<BlackBoxInt> defaultConstructor = BlackBoxInt.class.getDeclaredConstructor();
                defaultConstructor.setAccessible(true);
                BlackBoxInt object = defaultConstructor.newInstance();
                Field field = BlackBoxInt.class.getDeclaredField("innerValue");
                field.setAccessible(true);

                String input;
                while (!"END".equals(input = scan.nextLine())) {

                    String methodName = input.split("_")[0];
                    int parameter = Integer.parseInt(input.split("_")[1]);

                    Method method = BlackBoxInt.class.getDeclaredMethod(methodName, int.class);
                    method.setAccessible(true);
                    method.invoke(object, parameter);

                    System.out.println((int) field.get(object));
                }
            } catch (IllegalAccessException
                     | InstantiationException
                     | NoSuchMethodException
                     | InvocationTargetException
                     | NoSuchFieldException e) {

                e.printStackTrace();
            }
        }
    }
}