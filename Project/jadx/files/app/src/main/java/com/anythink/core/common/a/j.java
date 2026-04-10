package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.core.common.c.m;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j {
    private static volatile j b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f6761e;
    final String a = j.class.getSimpleName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f6762f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private m f6759c = m.a(com.anythink.core.common.c.c.a(n.a().g()));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Integer> f6760d = new HashMap();

    /* JADX INFO: renamed from: com.anythink.core.common.a.j$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ i a;

        AnonymousClass2(i iVar) {
            this.a = iVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                File file = new File(this.a.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
            j.this.f6759c.c(this.a.a());
        }
    }

    private j() {
        this.f6761e = 209715200L;
        this.f6761e = n.a().d(4);
    }

    public final void b() {
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.j.1
            @Override // java.lang.Runnable
            public final void run() {
                new ArrayList();
                j jVar = j.this;
                jVar.f6762f = jVar.f6759c.c();
                StringBuilder sb = new StringBuilder("recycleSpace check curDownloadedVideoFileSize:");
                sb.append(j.this.f6762f);
                sb.append(",MAX_VIDEO_CACHE_SIZE:");
                sb.append(j.this.f6761e);
                if (j.this.f6762f > j.this.f6761e) {
                    List<i> listD = j.this.f6759c.d();
                    new StringBuilder("recycleSpace start to delete video file,file list size:").append(listD.size());
                    for (i iVar : listD) {
                        try {
                            File file = new File(iVar.b());
                            if (file.exists()) {
                                file.delete();
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (!TextUtils.isEmpty(iVar.a())) {
                                String strA = iVar.a();
                                j.this.f6760d.remove(strA);
                                com.anythink.core.common.res.a.c.a().b(strA);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        });
    }

    public final long c() {
        return this.f6761e;
    }

    public final long d() {
        return this.f6762f;
    }

    public static j a() {
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    b = new j();
                }
            }
        }
        return b;
    }

    public final synchronized int b(String str) {
        if (this.f6760d.containsKey(str) && this.f6760d.get(str) != null) {
            return this.f6760d.get(str).intValue();
        }
        i iVarA = this.f6759c.a(str);
        if (iVarA == null || iVarA.c() <= 0) {
            return 0;
        }
        File file = new File(iVarA.b());
        if (!file.exists() || file.length() < iVarA.e()) {
            if (iVarA != null) {
                com.anythink.core.common.k.b.a.a().a(new AnonymousClass2(iVarA));
            }
            return 0;
        }
        this.f6760d.put(str, Integer.valueOf(iVarA.c()));
        this.f6759c.b(str);
        return iVarA.c();
    }

    private void a(i iVar) {
        if (iVar == null) {
            return;
        }
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass2(iVar));
    }

    public final void a(final String str, final String str2, final long j2, final long j3, final int i2, boolean z2) {
        this.f6760d.put(str, Integer.valueOf(i2));
        if (z2) {
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.common.a.j.3
                @Override // java.lang.Runnable
                public final void run() {
                    j.this.f6759c.a(str, str2, j2, j3, i2);
                }
            });
        }
    }

    public final i a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f6759c.a(str);
    }

    public final synchronized boolean a(String str, int i2) {
        return b(str) >= i2;
    }
}
