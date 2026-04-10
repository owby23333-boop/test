package com.anythink.expressad.videocommon.b;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.anythink.expressad.foundation.h.v;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.videocommon.b.h;
import com.anythink.expressad.videocommon.b.j;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final String a = "ending_page_source";
    public static final String b = "ending_page_save_time";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12172c = "H5DownLoadManager";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile i f12173f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f12174d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentMap<String, com.anythink.expressad.videocommon.b.d> f12175e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private m f12176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j f12177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12178i = false;

    public interface a {
        void a(String str);

        void a(String str, String str2);
    }

    public interface b extends a {
    }

    public interface c {
        void a();

        void a(String str);

        void a(byte[] bArr, String str);
    }

    public interface d extends a {
    }

    private i() {
        try {
            this.f12176g = m.a();
            this.f12177h = j.a.a;
            this.f12174d = new CopyOnWriteArrayList<>();
            this.f12175e = new ConcurrentHashMap();
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(f12172c, th.getMessage(), th);
        }
    }

    private void c(final String str, final a aVar) {
        try {
            com.anythink.expressad.foundation.h.o.d(f12172c, "download url:".concat(String.valueOf(str)));
            if (this.f12174d.contains(str)) {
                return;
            }
            this.f12174d.add(str);
            h.a.a.a(new com.anythink.expressad.foundation.g.g.a() { // from class: com.anythink.expressad.videocommon.b.i.1
                @Override // com.anythink.expressad.foundation.g.g.a
                public final void a() {
                    if (TextUtils.isEmpty(i.this.f12177h.b(str))) {
                        g.a(str, new c() { // from class: com.anythink.expressad.videocommon.b.i.1.1
                            @Override // com.anythink.expressad.videocommon.b.i.c
                            public final void a() {
                            }

                            @Override // com.anythink.expressad.videocommon.b.i.c
                            public final void a(byte[] bArr, String str2) {
                                try {
                                    i.this.f12174d.remove(str2);
                                    if (bArr == null || bArr.length <= 0) {
                                        return;
                                    }
                                    if (i.this.f12177h.a(str2, bArr)) {
                                        if (aVar != null) {
                                            aVar.a(str2);
                                        }
                                    } else if (aVar != null) {
                                        aVar.a(str2, "save file failed");
                                    }
                                } catch (Exception e2) {
                                    if (com.anythink.expressad.a.a) {
                                        e2.printStackTrace();
                                    }
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.a(str2, e2.getMessage());
                                    }
                                }
                            }

                            @Override // com.anythink.expressad.videocommon.b.i.c
                            public final void a(String str2) {
                                try {
                                    i.this.f12174d.remove(str);
                                    if (aVar != null) {
                                        aVar.a(str, str2);
                                    }
                                } catch (Exception e2) {
                                    if (com.anythink.expressad.a.a) {
                                        e2.printStackTrace();
                                    }
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.a(str, str2);
                                    }
                                }
                            }
                        });
                        return;
                    }
                    i.this.f12174d.remove(str);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(str);
                    }
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void b() {
                }

                @Override // com.anythink.expressad.foundation.g.g.a
                public final void c() {
                }
            });
        } catch (Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }

    private String d(String str) {
        j jVar = this.f12177h;
        return jVar != null ? jVar.a(str) : str;
    }

    private static String e(String str) {
        try {
            Object objB = v.b(com.anythink.expressad.foundation.b.a.b().d(), a.concat(String.valueOf(str)), "");
            if (objB == null || !(objB instanceof String)) {
                return null;
            }
            String str2 = (String) objB;
            if (w.b(str2)) {
                return str2;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static long f(String str) {
        try {
            Object objB = v.b(com.anythink.expressad.foundation.b.a.b().d(), b.concat(String.valueOf(str)), 0L);
            if (objB != null && (objB instanceof Long)) {
                return ((Long) objB).longValue();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0L;
    }

    private static void g(String str) {
        try {
            v.a(com.anythink.expressad.foundation.b.a.b().d(), b.concat(String.valueOf(str)), Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h(String str) {
        b(str, (a) null);
    }

    public static i a() {
        if (f12173f == null) {
            synchronized (i.class) {
                if (f12173f == null) {
                    f12173f = new i();
                }
            }
        }
        return f12173f;
    }

    private void b(String str, d dVar) {
        try {
            if (!TextUtils.isEmpty(this.f12176g.a(str))) {
                if (dVar != null) {
                    dVar.a(str);
                }
            } else if (!this.f12175e.containsKey(str)) {
                com.anythink.expressad.videocommon.b.d dVar2 = new com.anythink.expressad.videocommon.b.d(this.f12175e, this.f12176g, dVar, str);
                this.f12175e.put(str, dVar2);
                g.a(str, dVar2);
            } else {
                com.anythink.expressad.videocommon.b.d dVar3 = this.f12175e.get(str);
                if (dVar3 != null) {
                    dVar3.a(dVar);
                }
            }
        } catch (Exception e2) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public final String a(String str) {
        m mVar = this.f12176g;
        if (mVar != null) {
            return mVar.a(str);
        }
        return null;
    }

    public final String c(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri uri = Uri.parse(str);
                String path = uri.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (path.toLowerCase().endsWith(".zip")) {
                    return a(str);
                }
                return this.f12177h != null ? this.f12177h.a(str) : str;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public final void a(String str, a aVar) {
        c(str, aVar);
    }

    private static void a(String str, String str2) {
        try {
            com.anythink.expressad.foundation.h.o.b(f12172c, "sourceContent:".concat(String.valueOf(str)));
            v.a(com.anythink.expressad.foundation.b.a.b().d(), a.concat(String.valueOf(str2)), str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void b(String str, a aVar) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                String path = Uri.parse(str).getPath();
                if (!TextUtils.isEmpty(path)) {
                    if (path.toLowerCase().endsWith(".zip")) {
                        a(str, (d) aVar);
                        return;
                    } else {
                        c(str, aVar);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (aVar != null) {
            aVar.a(str, "The URL does not contain a path ");
        }
    }

    private void a(String str, d dVar) {
        try {
            if (!TextUtils.isEmpty(this.f12176g.a(str))) {
                if (dVar != null) {
                    dVar.a(str);
                }
            } else {
                if (this.f12175e.containsKey(str)) {
                    com.anythink.expressad.videocommon.b.d dVar2 = this.f12175e.get(str);
                    if (dVar2 != null) {
                        dVar2.a(dVar);
                        return;
                    }
                    return;
                }
                com.anythink.expressad.videocommon.b.d dVar3 = new com.anythink.expressad.videocommon.b.d(this.f12175e, this.f12176g, dVar, str);
                this.f12175e.put(str, dVar3);
                g.a(str, dVar3);
            }
        } catch (Exception e2) {
            if (dVar != null) {
                dVar.a(str, "downloadzip failed");
            }
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public final void b(String str) {
        c(str, null);
    }
}
