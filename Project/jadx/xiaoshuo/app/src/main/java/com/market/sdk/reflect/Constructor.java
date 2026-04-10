package com.market.sdk.reflect;

/* JADX INFO: loaded from: classes7.dex */
public class Constructor {
    private java.lang.reflect.Constructor mCons;

    private Constructor(java.lang.reflect.Constructor constructor) {
        this.mCons = constructor;
    }

    public static Constructor of(Class<?> cls, String str) throws java.lang.NoSuchMethodException {
        return new Constructor(null);
    }

    public Object newInstance(Object... objArr) throws java.lang.IllegalArgumentException {
        return null;
    }
}
