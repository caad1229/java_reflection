package com.caad1229.testReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App 
{
    public static void main( String[] args ) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Refref obj =  new Refref();
        // methodオブジェクトを全て取得
        Method methods[] = obj.getClass().getDeclaredMethods();
        // 全てのメソッドを実行してみる
        for (int i=0; i<methods.length; i++) {
            Method method = methods[i];
            // 属性をアクセス可能に変更
            method.setAccessible(true);
            String n = method.getName();

            if (n.equals("funcVoid")) {
                method.invoke(obj, null);
                System.out.println( "method : " + n );
            } else if (n.equals("funcString")) {
                String  ret = (String) method.invoke(obj, new Object[]{"test"});
                System.out.println( "method : " + n  + " / ret : " + ret);
            } else if (n.equals("funcBoolean")) {
                Boolean ret = (Boolean)method.invoke(obj, new Object[]{new Boolean(true)});
                System.out.println( "method : " + n  + " / ret : " + ret);
            } else if (n.equals("funcInt")) {
                Integer ret = (Integer)method.invoke(obj, new Object[]{new Integer(10)});
                System.out.println( "method : " + n  + " / ret : " + ret);
            }
        }
    }
}
