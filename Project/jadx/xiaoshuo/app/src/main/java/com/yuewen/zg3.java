package com.yuewen;

import android.os.Binder;
import android.util.Log;
import android.util.SparseBooleanArray;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes12.dex */
public abstract class zg3<T> implements InvocationHandler {
    public static final String c = "SecurityLayer";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final di1 f20769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseBooleanArray f20770b = new SparseBooleanArray();

    public zg3(di1<T> di1Var) {
        this.f20769a = di1Var;
    }

    public final synchronized void a() throws SecurityException {
        boolean zValueAt;
        int callingUid = Binder.getCallingUid();
        int iIndexOfKey = this.f20770b.indexOfKey(callingUid);
        if (iIndexOfKey < 0) {
            zValueAt = c(callingUid);
            this.f20770b.put(callingUid, zValueAt);
        } else {
            zValueAt = this.f20770b.valueAt(iIndexOfKey);
        }
        Log.v(c, String.format("check permission, uid = %s, permission %s", Integer.valueOf(callingUid), Boolean.valueOf(zValueAt)));
        if (!zValueAt) {
            throw new SecurityException();
        }
    }

    public T b(Class<T> cls) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{cls}, this);
    }

    public abstract boolean c(int i);

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        a();
        Object objA = this.f20769a.a();
        if (objA != null) {
            return method.invoke(objA, objArr);
        }
        throw new ClassNotFoundException();
    }
}
