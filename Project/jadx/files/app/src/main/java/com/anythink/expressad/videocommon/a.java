package com.anythink.expressad.videocommon;

import android.text.TextUtils;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.foundation.d.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String a = "TemplateWebviewCache";
    private static ConcurrentHashMap<String, C0226a> b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12122c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12123d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12124e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12125f = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12126g = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12127h = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12128i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12129j = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static ConcurrentHashMap<String, C0226a> f12130k = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: com.anythink.expressad.videocommon.a$a, reason: collision with other inner class name */
    public static class C0226a {
        private WindVaneWebView a;
        private boolean b;

        public final WindVaneWebView a() {
            return this.a;
        }

        public final String b() {
            WindVaneWebView windVaneWebView = this.a;
            return windVaneWebView != null ? (String) windVaneWebView.getTag() : "";
        }

        public final boolean c() {
            return this.b;
        }

        public final void a(WindVaneWebView windVaneWebView) {
            this.a = windVaneWebView;
        }

        public final void a(String str) {
            WindVaneWebView windVaneWebView = this.a;
            if (windVaneWebView != null) {
                windVaneWebView.setTag(str);
            }
        }

        public final void a(boolean z2) {
            this.b = z2;
        }
    }

    public static C0226a a(String str) {
        if (f12127h.containsKey(str)) {
            return f12127h.get(str);
        }
        if (f12128i.containsKey(str)) {
            return f12128i.get(str);
        }
        if (f12129j.containsKey(str)) {
            return f12129j.get(str);
        }
        if (f12130k.containsKey(str)) {
            return f12130k.get(str);
        }
        return null;
    }

    public static void b(String str) {
        if (f12127h.containsKey(str)) {
            f12127h.remove(str);
        }
        if (f12129j.containsKey(str)) {
            f12129j.remove(str);
        }
        if (f12128i.containsKey(str)) {
            f12128i.remove(str);
        }
        if (f12130k.containsKey(str)) {
            f12130k.remove(str);
        }
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            f12127h.clear();
        } else {
            for (String str2 : f12127h.keySet()) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    f12127h.remove(str2);
                }
            }
        }
        f12128i.clear();
    }

    public static void d(String str) {
        for (Map.Entry<String, C0226a> entry : f12127h.entrySet()) {
            if (entry.getKey().contains(str)) {
                f12127h.remove(entry.getKey());
            }
        }
    }

    public static void e(String str) {
        for (Map.Entry<String, C0226a> entry : f12128i.entrySet()) {
            if (entry.getKey().contains(str)) {
                f12128i.remove(entry.getKey());
            }
        }
    }

    private static void f(String str) {
        for (Map.Entry<String, C0226a> entry : f12129j.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                f12129j.remove(entry.getKey());
            }
        }
    }

    private static void g(String str) {
        for (Map.Entry<String, C0226a> entry : f12130k.entrySet()) {
            if (entry.getKey().startsWith(str)) {
                f12130k.remove(entry.getKey());
            }
        }
    }

    private static void c() {
        f12127h.clear();
    }

    public static void a(String str, C0226a c0226a, boolean z2, boolean z3) {
        if (z2) {
            if (z3) {
                f12128i.put(str, c0226a);
                return;
            } else {
                f12127h.put(str, c0226a);
                return;
            }
        }
        if (z3) {
            f12130k.put(str, c0226a);
        } else {
            f12129j.put(str, c0226a);
        }
    }

    public static void b() {
        f12129j.clear();
        f12130k.clear();
    }

    public static void b(int i2, c cVar) {
        if (cVar == null) {
            return;
        }
        try {
            String strAa = cVar.aa();
            if (i2 == 94) {
                if (cVar.A()) {
                    if (f12122c != null) {
                        f12122c.remove(strAa);
                        return;
                    }
                    return;
                } else {
                    if (f12125f != null) {
                        f12125f.remove(strAa);
                        return;
                    }
                    return;
                }
            }
            if (i2 != 287) {
                if (b != null) {
                    b.remove(strAa);
                }
            } else if (cVar.A()) {
                if (f12123d != null) {
                    f12123d.remove(strAa);
                }
            } else if (f12126g != null) {
                f12126g.remove(strAa);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void a() {
        f12127h.clear();
        f12128i.clear();
    }

    private static void a(String str, boolean z2, boolean z3) {
        if (z2) {
            if (z3) {
                for (Map.Entry<String, C0226a> entry : f12128i.entrySet()) {
                    if (entry.getKey().startsWith(str)) {
                        f12128i.remove(entry.getKey());
                    }
                }
                return;
            }
            for (Map.Entry<String, C0226a> entry2 : f12127h.entrySet()) {
                if (entry2.getKey().startsWith(str)) {
                    f12127h.remove(entry2.getKey());
                }
            }
            return;
        }
        if (z3) {
            for (Map.Entry<String, C0226a> entry3 : f12130k.entrySet()) {
                if (entry3.getKey().startsWith(str)) {
                    f12130k.remove(entry3.getKey());
                }
            }
            return;
        }
        for (Map.Entry<String, C0226a> entry4 : f12129j.entrySet()) {
            if (entry4.getKey().startsWith(str)) {
                f12129j.remove(entry4.getKey());
            }
        }
    }

    public static void b(int i2) {
        try {
            if (i2 == 94) {
                if (f12125f != null) {
                    f12125f.clear();
                }
            } else if (i2 != 287) {
                if (b != null) {
                    b.clear();
                }
            } else if (f12126g != null) {
                f12126g.clear();
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static C0226a a(int i2, c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            String strAa = cVar.aa();
            if (i2 != 94) {
                if (i2 != 287) {
                    if (b != null && b.size() > 0) {
                        return b.get(strAa);
                    }
                } else if (cVar.A()) {
                    if (f12123d != null && f12123d.size() > 0) {
                        return f12123d.get(strAa);
                    }
                } else if (f12126g != null && f12126g.size() > 0) {
                    return f12126g.get(strAa);
                }
            } else if (cVar.A()) {
                if (f12122c != null && f12122c.size() > 0) {
                    return f12122c.get(strAa);
                }
            } else if (f12125f != null && f12125f.size() > 0) {
                return f12125f.get(strAa);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static void b(int i2, String str, C0226a c0226a) {
        try {
            if (i2 == 94) {
                if (f12125f == null) {
                    f12125f = new ConcurrentHashMap<>();
                }
                f12125f.put(str, c0226a);
            } else if (i2 != 287) {
                if (b == null) {
                    b = new ConcurrentHashMap<>();
                }
                b.put(str, c0226a);
            } else {
                if (f12126g == null) {
                    f12126g = new ConcurrentHashMap<>();
                }
                f12126g.put(str, c0226a);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    private static ConcurrentHashMap<String, C0226a> a(int i2, boolean z2) {
        if (i2 == 94) {
            return z2 ? f12122c : f12125f;
        }
        if (i2 != 287) {
            return b;
        }
        return z2 ? f12123d : f12126g;
    }

    public static void a(int i2) {
        try {
            if (i2 != 94) {
                if (i2 != 287) {
                    return;
                }
                if (f12123d != null) {
                    f12123d.clear();
                }
            } else if (f12122c != null) {
                f12122c.clear();
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(int i2, String str, C0226a c0226a) {
        try {
            if (i2 == 94) {
                if (f12122c == null) {
                    f12122c = new ConcurrentHashMap<>();
                }
                f12122c.put(str, c0226a);
            } else {
                if (i2 != 287) {
                    return;
                }
                if (f12123d == null) {
                    f12123d = new ConcurrentHashMap<>();
                }
                f12123d.put(str, c0226a);
            }
        } catch (Exception e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
        }
    }
}
