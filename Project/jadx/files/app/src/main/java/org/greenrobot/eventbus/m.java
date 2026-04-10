package org.greenrobot.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: SubscriberMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    final Method a;
    final ThreadMode b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Class<?> f21340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f21341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f21342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f21343f;

    public m(Method method, Class<?> cls, ThreadMode threadMode, int i2, boolean z2) {
        this.a = method;
        this.b = threadMode;
        this.f21340c = cls;
        this.f21341d = i2;
        this.f21342e = z2;
    }

    private synchronized void a() {
        if (this.f21343f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.f21340c.getName());
            this.f21343f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        a();
        m mVar = (m) obj;
        mVar.a();
        return this.f21343f.equals(mVar.f21343f);
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
