package com.selfwork.intelligence.common;

import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BeanUtils
 *
 * @date 2015 /11/9
 */
public class BeanUtils {
    /**
     * The constant beanCopierMap.
     */

    public static Map<String, BeanCopier> beanCopierMap = new HashMap<>();

    /**
     * Copy.
     *
     * @param source the source
     * @param target the target
     */
    public static void copy(Object source, Object target) {
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }


    /**
     * Copy list list.
     *
     * @param <S>    the type parameter
     * @param <T>    the type parameter
     * @param source the source
     * @param cls    the cls
     * @return the list
     * @throws InstantiationException the instantiation exception
     * @throws IllegalAccessException the illegal access exception
     */
    public static <S, T> List<T> copyList(List<S> source, Class<T> cls)
            throws InstantiationException, IllegalAccessException {
        List<T> target = new ArrayList<>();
        if (null != source && source.size() > 0) {
            for (S s : source) {
                T t = cls.newInstance();
                copy(s, t);
                target.add(t);
            }
        }
        return target;
    }

    /**
     * Generate key string.
     *
     * @param classSource the class source
     * @param classTarget the class target
     * @return the string
     */
    private static String generateKey(Class<?> classSource, Class<?> classTarget) {
        return classSource.toString() + classTarget.toString();
    }

}
