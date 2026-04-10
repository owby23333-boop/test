package com.github.gzuliyujiang.oaid.g;

import android.annotation.SuppressLint;
import android.content.Context;
import com.github.gzuliyujiang.oaid.OAIDException;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: XiaomiImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class q implements com.github.gzuliyujiang.oaid.d {
    private final Context a;
    private Class<?> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f14894c;

    @SuppressLint({"PrivateApi"})
    public q(Context context) {
        this.a = context;
        try {
            this.b = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f14894c = this.b.newInstance();
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
        }
    }

    private String b() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.f14894c, this.a);
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public boolean a() {
        return this.f14894c != null;
    }

    @Override // com.github.gzuliyujiang.oaid.d
    public void a(com.github.gzuliyujiang.oaid.c cVar) {
        if (this.a == null || cVar == null) {
            return;
        }
        if (this.b == null || this.f14894c == null) {
            cVar.a(new OAIDException("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new OAIDException("OAID query failed");
            }
            com.github.gzuliyujiang.oaid.e.a("OAID query success: " + strB);
            cVar.a(strB);
        } catch (Exception e2) {
            com.github.gzuliyujiang.oaid.e.a(e2);
            cVar.a(e2);
        }
    }
}
