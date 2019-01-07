package com.bokeka.hub.utils;

import java.lang.reflect.ParameterizedType;

import androidx.annotation.NonNull;

/**
 * @author daixin 2019/1/7
 * @website bokeka.com
 */
public class TUtil {
    public static <T> T getNewInstance(Object object, int i) {
        checkNotNull(object);
        try {
            return ((Class<T>) ((ParameterizedType) (object.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i])
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T getInstance(Object object, int i) {
        if (object != null) {
            return (T) ((ParameterizedType) object.getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[i];
        }
        return null;
    }

    public static @NonNull
    <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }
}

