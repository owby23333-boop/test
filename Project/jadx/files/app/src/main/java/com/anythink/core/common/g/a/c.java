package com.anythink.core.common.g.a;

import com.anythink.core.common.g.a.d.AnonymousClass1;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f7442d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f7443e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f7444f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f7445g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f7446h = 4;
    private final int a = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected int f7447i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f7448j;

    public interface a {
        void a(Object obj);

        void a(Throwable th);
    }

    public final void a(int i2, String str) {
        this.f7447i = i2;
        this.f7448j = str;
    }

    public void a(String str, String str2, String str3, int i2) {
    }

    public abstract int c();

    public abstract int d();

    public abstract byte[] e();

    public abstract boolean f();

    protected final JSONObject g() {
        return com.anythink.core.common.g.c.a(h());
    }

    protected int h() {
        return 0;
    }

    protected static byte[] a(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes(com.anythink.expressad.foundation.g.a.bN));
            gZIPOutputStream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static JSONObject a() {
        return com.anythink.core.common.g.c.a();
    }

    public final void a(a aVar) {
        com.anythink.core.common.k.b.a.a().a((com.anythink.core.common.k.b.b) d.a().new AnonymousClass1(this, aVar), 4);
    }
}
