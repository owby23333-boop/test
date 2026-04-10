package com.anythink.core.common;

import android.content.Context;
import java.lang.reflect.Method;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static final int a = 35;
    public static final String b = "isDefaultOffer";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile s f7936g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Method f7937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Method f7938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Method f7939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Method f7940f;

    private s() {
        try {
            Class<?> cls = Class.forName("com.anythink.network.myoffer.MyOfferAPI");
            this.f7937c = cls.getDeclaredMethod("preloadTopOnOffer", Context.class, com.anythink.core.common.e.t.class);
            this.f7938d = cls.getDeclaredMethod("getOutOfCapOfferIds", Context.class);
            this.f7939e = cls.getDeclaredMethod("getDefaultOfferId", Context.class, String.class);
            this.f7940f = cls.getDeclaredMethod("checkOffersOutOfCap", Context.class, String.class);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static s a() {
        if (f7936g == null) {
            synchronized (s.class) {
                if (f7936g == null) {
                    f7936g = new s();
                }
            }
        }
        return f7936g;
    }

    public final String b(Context context, String str) {
        try {
            return this.f7939e != null ? this.f7939e.invoke(null, context, str).toString() : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final boolean c(Context context, String str) {
        try {
            if (this.f7940f != null) {
                return ((Boolean) this.f7940f.invoke(null, context, str)).booleanValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    public final void a(Context context, String str) {
        try {
            if (this.f7937c != null) {
                com.anythink.core.common.e.t tVar = new com.anythink.core.common.e.t();
                tVar.a = str;
                this.f7937c.invoke(null, context, tVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final JSONArray a(Context context) {
        try {
            if (this.f7938d != null) {
                return new JSONArray(this.f7938d.invoke(null, context).toString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return new JSONArray();
    }
}
