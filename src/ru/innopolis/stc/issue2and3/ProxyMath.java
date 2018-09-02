package ru.innopolis.stc.issue2and3;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class ProxyMath implements InvocationHandler {
    private MathInterface mathInterface;

    public ProxyMath(MathInterface mathInterface) {
        this.mathInterface = mathInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //Class clazz = mathInterface.getClass();
        Object result = null;
        if (mathInterface.getClass().getAnnotation(Logged.class) != null) {
            Date date = new Date();
            System.out.println(date.toString() + ":" + "We call method " + method.getName());
            result = method.invoke(mathInterface, args);
        }
        if (mathInterface.getClass().getDeclaredAnnotationsByType(ClearData.class) != null) {
            if (method.getName() == "clearData") {
                Field field = mathInterface.getClass().getDeclaredField("pi");
                field.setAccessible(true);
                field.set(mathInterface, 0);
                field.setAccessible(false);
                System.out.println("Clear data");
                result = method.invoke(mathInterface, args);
            }
        }
        if (result != null) {
            return result;
        } else {
            return method.invoke(mathInterface, args);
        }
    }
}

