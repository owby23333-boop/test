package com.bytedance.sdk.openadsdk.ats.z;

import com.bytedance.sdk.component.a.kb;
import com.bytedance.sdk.component.utils.wp;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g implements kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f909a;
    private Method dl;
    private Method g;
    private Method gc;
    private boolean m;
    private Class z;

    @Override // com.bytedance.sdk.component.a.kb
    public void set(String str, String str2) {
    }

    public g() {
        try {
            Class<?> clsLoadClass = getClass().getClassLoader().loadClass("android.os.SystemProperties");
            this.z = clsLoadClass;
            Method declaredMethod = clsLoadClass.getDeclaredMethod("get", String.class);
            this.g = declaredMethod;
            declaredMethod.setAccessible(true);
            this.m = true;
        } catch (Exception unused) {
            this.z = null;
            this.m = false;
        }
    }

    private Method z(String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = this.z.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception unused) {
            return null;
        }
    }

    private <T> T z(Method method, String str) {
        if (method == null) {
            return null;
        }
        try {
            return (T) method.invoke(this.z, str);
        } catch (Exception e) {
            wp.g("SystemPropRefect", "invoke failed", e);
            return null;
        }
    }

    public boolean z() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public String get(String str) {
        return (String) z(this.g, str);
    }

    @Override // com.bytedance.sdk.component.a.kb
    public int getInt(String str) {
        if (this.dl == null) {
            this.dl = z("getInt", String.class, Integer.TYPE);
        }
        Integer num = (Integer) z(this.dl, str);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public long getLong(String str) {
        if (this.f909a == null) {
            this.f909a = z("getLong", String.class, Long.TYPE);
        }
        Long l = (Long) z(this.f909a, str);
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public boolean getBoolean(String str) {
        if (this.gc == null) {
            this.gc = z("getBoolean", String.class, Boolean.TYPE);
        }
        Boolean bool = (Boolean) z(this.gc, str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
