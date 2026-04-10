package com.anythink.core.common.res.a;

import android.text.TextUtils;
import com.anythink.core.common.a.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.k.f;
import com.anythink.core.common.res.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.anythink.core.common.res.image.b {
    final String a;
    public com.anythink.core.common.res.a.b b;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<AbstractC0170a> f7884j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f7885k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f7886l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f7887m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f7888n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7889o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f7890p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f7891q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f7892r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f7893s;

    /* JADX INFO: renamed from: com.anythink.core.common.res.a.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0170a {
        public abstract void a(String str, String str2);

        public abstract boolean a(int i2, long j2, long j3);
    }

    public static abstract class b {
        public abstract void a(long j2, long j3, long j4, long j5, long j6);

        public abstract void a(String str, String str2, long j2, long j3, long j4, long j5);
    }

    public a(String str) {
        super(str);
        this.a = a.class.getSimpleName();
        this.f7887m = 0;
        this.f7888n = 1;
        this.f7886l = -1;
        this.f7884j = new ArrayList();
        this.b = new com.anythink.core.common.res.a.b();
        this.f7890p = 0;
        this.f7891q = 0L;
        this.f7893s = false;
        this.f7889o = 0;
    }

    private synchronized boolean b(int i2) {
        if (this.f7893s) {
            return true;
        }
        if (this.b.f7894c == 2) {
            if (i2 >= this.b.a) {
                return false;
            }
        }
        return true;
    }

    private int g() {
        return this.f7889o;
    }

    private void h() {
        String strA = d.a(n.a().g()).a(4);
        if (TextUtils.isEmpty(strA)) {
            b("", "without saveDirectory");
            return;
        }
        File file = new File(strA);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f7892r = d.a(n.a().g()).b(4, f.a(this.f7928c));
        File file2 = new File(this.f7892r);
        if (file2.exists()) {
            this.f7891q = file2.length();
        }
    }

    private boolean i() {
        int i2 = this.f7890p;
        if (i2 != 100) {
            return this.f7889o == 0 && i2 < 100;
        }
        a(i2, this.f7891q);
        b(this.f7890p, this.f7891q);
        return false;
    }

    private synchronized void j() {
        this.f7884j.clear();
    }

    @Override // com.anythink.core.common.res.image.b
    protected final Map<String, String> a() {
        return null;
    }

    public final synchronized void a(com.anythink.core.common.res.a.b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7928c);
        sb.append(" setVideoUrlLoaderConfig: mReadyRate:");
        sb.append(bVar.a);
        sb.append(",mVideoCtnType:");
        sb.append(bVar.f7894c);
        if (this.b.a < bVar.a) {
            this.b.a = bVar.a;
        }
        if (this.b.f7894c != 1) {
            this.b.f7894c = bVar.f7894c;
        }
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void b() {
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void c() {
        this.f7889o = 0;
    }

    public final void e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7928c);
        sb.append(" startRequest: canStartLoader():");
        sb.append(i());
        if (i()) {
            h();
            this.f7889o = 1;
            d();
        }
    }

    public final void f() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7928c);
        sb.append(" startRequest: resumeRequest():");
        sb.append(i());
        this.f7893s = true;
        if (i()) {
            h();
            this.f7889o = 1;
            d();
        }
    }

    private void b(int i2, long j2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7928c);
        sb.append(" notifyDownloadFinish: downloadRate:");
        sb.append(i2);
        if (i2 == 100) {
            j.a().a(this.f7928c, this.f7892r, this.f7934i, j2, i2, true);
            b bVar = this.f7885k;
            if (bVar != null) {
                bVar.a(this.f7934i, this.f7930e, this.f7932g, this.f7931f, this.f7933h);
            }
        }
    }

    public final synchronized void a(AbstractC0170a abstractC0170a) {
        if (!this.f7884j.contains(abstractC0170a)) {
            this.f7884j.add(abstractC0170a);
        }
    }

    private void a(b bVar) {
        this.f7885k = bVar;
    }

    private synchronized void b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7928c);
        sb.append(" notifyLoadFailed: errorCode:");
        sb.append(str);
        sb.append(",errorMsg:");
        sb.append(str2);
        this.f7889o = 0;
        Iterator<AbstractC0170a> it = this.f7884j.iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
        j();
        if (this.f7885k != null) {
            this.f7885k.a(str, str2, this.f7934i, this.f7930e, this.f7931f, this.f7933h);
        }
    }

    private void a(int i2) {
        this.f7889o = i2;
    }

    private synchronized void a(int i2, long j2) {
        if (this.f7886l != i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f7928c);
            sb.append(" notifyDownloadProcess:");
            sb.append(i2);
            this.f7886l = i2;
        }
        Iterator<AbstractC0170a> it = this.f7884j.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().a(i2, j2, this.f7934i)) {
                boolean z3 = i2 != 100;
                it.remove();
                z2 = z3;
            }
        }
        j.a().a(this.f7928c, this.f7892r, this.f7934i, j2, i2, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v0, types: [long] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v4 */
    @Override // com.anythink.core.common.res.image.b
    protected final boolean a(InputStream inputStream) {
        ?? r3;
        FileOutputStream fileOutputStream;
        boolean z2 = false;
        if (!TextUtils.isEmpty(this.f7892r)) {
            ?? r02 = 0;
            try {
                r3 = this.f7891q;
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (r3 > 0) {
                    inputStream.skip(this.f7891q);
                    fileOutputStream = new FileOutputStream(this.f7892r, true);
                    double d2 = this.f7891q;
                    Double.isNaN(d2);
                    double d3 = d2 * 1.0d;
                    double d4 = this.f7934i;
                    Double.isNaN(d4);
                    this.f7890p = (int) ((d3 / d4) * 100.0d);
                    a(this.f7890p, this.f7891q);
                } else {
                    fileOutputStream = new FileOutputStream(this.f7892r);
                    this.f7890p = 0;
                }
                r02 = fileOutputStream;
                r3 = 2048;
                byte[] bArr = new byte[2048];
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 == -1 || !b(this.f7890p)) {
                        break;
                    }
                    r02.write(bArr, 0, i2);
                    this.f7891q += (long) i2;
                    double d5 = this.f7891q;
                    Double.isNaN(d5);
                    double d6 = d5 * 1.0d;
                    double d7 = this.f7934i;
                    Double.isNaN(d7);
                    this.f7890p = (int) ((d6 / d7) * 100.0d);
                    a(this.f7890p, this.f7891q);
                }
                r02.close();
                try {
                    r02.close();
                } catch (Throwable unused) {
                }
                z2 = true;
            } catch (Throwable th2) {
                th = th2;
                r02 = r3;
                try {
                    th.printStackTrace();
                    if (r02 != 0) {
                        try {
                            r02.close();
                        } catch (Throwable unused2) {
                        }
                    }
                } catch (Throwable th3) {
                    if (r02 != 0) {
                        try {
                            r02.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th3;
                }
            }
        }
        b(this.f7890p, this.f7891q);
        return z2;
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(com.anythink.core.common.k.b.b bVar) {
        com.anythink.core.common.k.b.a.a().a(bVar, 5);
    }

    @Override // com.anythink.core.common.res.image.b
    protected final void a(String str, String str2) {
        b(str, str2);
    }
}
