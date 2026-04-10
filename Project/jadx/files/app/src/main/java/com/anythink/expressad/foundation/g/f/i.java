package com.anythink.expressad.foundation.g.f;

import com.anythink.expressad.foundation.h.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i<T> implements Comparable<i<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10582c = i.class.getSimpleName();
    protected ConcurrentHashMap<String, String> a;
    protected e<T> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f10584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f10585f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private j f10586g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f10587h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l f10588i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Object f10589j;

    public interface a {
        public static final int a = 0;
        public static final int b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f10590c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f10591d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f10592e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f10593f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f10594g = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f10595h = 7;
    }

    public class b {
        public static final int a = 1;
        public static final int b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f10596c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f10597d = 4;

        private b() {
        }
    }

    public i(int i2, String str, e<T> eVar) {
        this.a = new ConcurrentHashMap<>();
        this.b = null;
        this.f10587h = false;
        this.f10584e = str;
        this.f10583d = i2;
        this.b = eVar;
        this.f10588i = new com.anythink.expressad.foundation.g.f.b();
    }

    protected static com.anythink.expressad.foundation.g.f.a.a a(com.anythink.expressad.foundation.g.f.a.a aVar) {
        return aVar;
    }

    private int p() {
        Integer num = this.f10585f;
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    private static void q() {
    }

    private static void r() {
    }

    public final int a() {
        return this.f10583d;
    }

    protected abstract k<T> a(com.anythink.expressad.foundation.g.f.f.c cVar);

    public void a(OutputStream outputStream) {
    }

    public final Object b() {
        return this.f10589j;
    }

    public final void c() {
        j jVar = this.f10586g;
        if (jVar != null) {
            jVar.b(this);
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        i iVar = (i) obj;
        int iJ = j();
        int iJ2 = iVar.j();
        return iJ == iJ2 ? this.f10585f.intValue() - iVar.f10585f.intValue() : iJ2 - iJ;
    }

    public final String d() {
        return this.f10584e;
    }

    public final void e() {
        this.f10587h = true;
    }

    public final boolean f() {
        return this.f10587h;
    }

    public final Map<String, String> g() {
        return this.a;
    }

    public byte[] h() {
        return null;
    }

    public void i() {
        a("Connection", com.anythink.expressad.foundation.d.c.cf);
        a("Charset", "UTF-8");
    }

    public int j() {
        return 2;
    }

    public final int k() {
        return this.f10588i.b();
    }

    public final l l() {
        return this.f10588i;
    }

    public final void m() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.c();
        }
    }

    public final void n() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
    }

    public final void o() {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10587h ? "[X] " : "[ ] ");
        sb.append(this.f10584e);
        sb.append(" ");
        sb.append(j());
        sb.append(" ");
        sb.append(this.f10585f);
        return sb.toString();
    }

    public final void a(e<T> eVar) {
        this.b = eVar;
    }

    public final void b(com.anythink.expressad.foundation.g.f.a.a aVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private i<?> a(Object obj) {
        this.f10589j = obj;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(l lVar) {
        this.f10588i = lVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(j jVar) {
        this.f10586g = jVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i<?> a(int i2) {
        this.f10585f = Integer.valueOf(i2);
        return this;
    }

    public final void a(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    private void a(String str) {
        this.a.remove(str);
    }

    public i(String str) {
        this.a = new ConcurrentHashMap<>();
        this.b = null;
        this.f10587h = false;
        this.f10584e = str;
        this.f10583d = 0;
        this.f10588i = new com.anythink.expressad.foundation.g.f.b();
    }

    public byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar, c cVar) {
        return bVar.c() != null ? a(bVar) : new byte[0];
    }

    private static byte[] a(com.anythink.expressad.foundation.g.f.f.b bVar) throws Throwable {
        InputStream inputStreamC;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStreamC = bVar.c();
            try {
                InputStream gZIPInputStream = (!com.anythink.expressad.foundation.g.f.g.e.b(bVar.b()) || (inputStreamC instanceof GZIPInputStream)) ? inputStreamC : new GZIPInputStream(inputStreamC);
                try {
                    if (gZIPInputStream != null) {
                        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int i2 = gZIPInputStream.read(bArr);
                                if (i2 == -1) {
                                    break;
                                }
                                byteArrayOutputStream2.write(bArr, 0, i2);
                            }
                            byte[] byteArray = byteArrayOutputStream2.toByteArray();
                            if (gZIPInputStream != null) {
                                try {
                                    gZIPInputStream.close();
                                } catch (IOException e2) {
                                    o.d(f10582c, e2.getMessage());
                                }
                            }
                            byteArrayOutputStream2.close();
                            return byteArray;
                        } catch (Throwable th) {
                            inputStreamC = gZIPInputStream;
                            th = th;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (inputStreamC != null) {
                                try {
                                    inputStreamC.close();
                                } catch (IOException e3) {
                                    o.d(f10582c, e3.getMessage());
                                    throw th;
                                }
                            }
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            throw th;
                        }
                    }
                    throw new com.anythink.expressad.foundation.g.f.a.a(7, null);
                } catch (Throwable th2) {
                    inputStreamC = gZIPInputStream;
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStreamC = null;
        }
    }

    public final void a(k<T> kVar) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(kVar);
        }
    }

    public final void a(long j2, long j3) {
        e<T> eVar = this.b;
        if (eVar != null) {
            eVar.a(j2, j3);
        }
    }

    private int a(i<T> iVar) {
        int iJ = j();
        int iJ2 = iVar.j();
        return iJ == iJ2 ? this.f10585f.intValue() - iVar.f10585f.intValue() : iJ2 - iJ;
    }

    public final void a(String str, String str2) {
        this.a.remove(str);
        this.a.put(str, str2);
    }
}
