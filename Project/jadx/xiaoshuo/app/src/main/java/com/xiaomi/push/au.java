package com.xiaomi.push;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
class au implements aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Class<?> f151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Method f153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Method f7804b = null;
    private Method c = null;
    private Method d = null;

    public au(Context context) {
        this.f7803a = context;
        a(context);
    }

    private void a(Context context) {
        try {
            Class<?> clsA = C0855r.a(context, "com.android.id.impl.IdProviderImpl");
            this.f151a = clsA;
            this.f152a = clsA.newInstance();
            this.f7804b = this.f151a.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui load class error", e);
        }
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public boolean mo195a() {
        return (this.f151a == null || this.f152a == null) ? false : true;
    }

    @Override // com.xiaomi.push.aq
    /* JADX INFO: renamed from: a */
    public String mo194a() {
        return a(this.f7803a, this.f7804b);
    }

    private String a(Context context, Method method) {
        Object obj = this.f152a;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a("miui invoke error", e);
            return null;
        }
    }
}
