package com.yuewen;

/* JADX INFO: loaded from: classes17.dex */
public class eg4<T> extends fg4 {
    public T d;

    public static <T> eg4<T> a() {
        eg4<T> eg4Var = new eg4<>();
        eg4Var.f11125a = 0;
        return eg4Var;
    }

    public static <TValue> eg4<TValue> b(gl4<TValue> gl4Var) {
        if (gl4Var == null) {
            return null;
        }
        eg4<TValue> eg4Var = new eg4<>();
        eg4Var.f11125a = gl4Var.f11592a;
        eg4Var.f11126b = gl4Var.f11593b;
        eg4Var.d = gl4Var.c;
        return eg4Var;
    }
}
