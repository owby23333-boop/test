package com.bytedance.sdk.component.d.bf.e.bf;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class ga extends RuntimeException {
    private static final Method e;
    private IOException bf;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        e = declaredMethod;
    }

    public ga(IOException iOException) {
        super(iOException);
        this.bf = iOException;
    }

    public IOException e() {
        return this.bf;
    }

    public void e(IOException iOException) {
        e(iOException, this.bf);
        this.bf = iOException;
    }

    private void e(IOException iOException, IOException iOException2) {
        Method method = e;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
