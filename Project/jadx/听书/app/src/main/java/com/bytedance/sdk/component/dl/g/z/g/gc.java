package com.bytedance.sdk.component.dl.g.z.g;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class gc extends RuntimeException {
    private static final Method z;
    private IOException g;

    static {
        Method declaredMethod;
        try {
            declaredMethod = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
            declaredMethod = null;
        }
        z = declaredMethod;
    }

    public gc(IOException iOException) {
        super(iOException);
        this.g = iOException;
    }

    public IOException z() {
        return this.g;
    }

    public void z(IOException iOException) {
        z(iOException, this.g);
        this.g = iOException;
    }

    private void z(IOException iOException, IOException iOException2) {
        Method method = z;
        if (method != null) {
            try {
                method.invoke(iOException, iOException2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }
}
