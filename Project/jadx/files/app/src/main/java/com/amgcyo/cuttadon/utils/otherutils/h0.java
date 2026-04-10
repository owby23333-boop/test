package com.amgcyo.cuttadon.utils.otherutils;

import androidx.annotation.NonNull;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: compiled from: ParameterizedTypeImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class h0 implements ParameterizedType {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Class f4396s;

    public h0(Class cls) {
        this.f4396s = cls;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NonNull
    public Type[] getActualTypeArguments() {
        return new Type[]{this.f4396s};
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return null;
    }

    @Override // java.lang.reflect.ParameterizedType
    @NonNull
    public Type getRawType() {
        return List.class;
    }
}
