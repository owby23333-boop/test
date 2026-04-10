package com.bytedance.mapplog.util;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final String a;
    private final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String[] f13908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13910e;

    public static class b {
        private String a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String[] f13911c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String[] f13912d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f13913e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f13914f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f13915g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f13916h;

        public b a(String str) {
            this.a = str;
            return this;
        }

        public b a(String[] strArr) {
            this.f13911c = strArr;
            return this;
        }

        public a a() {
            return new a(this);
        }

        public b b(String str) {
            this.b = str;
            return this;
        }

        public b b(String[] strArr) {
            this.f13912d = strArr;
            return this;
        }

        public b c(String str) {
            this.f13913e = str;
            return this;
        }

        public b d(String str) {
            this.f13914f = str;
            return this;
        }

        public b e(String str) {
            this.f13916h = str;
            return this;
        }
    }

    private a(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.f13908c = bVar.f13911c;
        String[] unused = bVar.f13912d;
        this.f13909d = bVar.f13913e;
        this.f13910e = bVar.f13914f;
        String unused2 = bVar.f13915g;
        String unused3 = bVar.f13916h;
    }

    public String a() {
        return this.f13910e;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String[] d() {
        return this.f13908c;
    }

    public String e() {
        return this.f13909d;
    }
}
