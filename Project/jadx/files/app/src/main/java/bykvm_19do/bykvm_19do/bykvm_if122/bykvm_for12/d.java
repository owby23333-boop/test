package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d {
    protected String a;
    protected String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected String f1681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected String f1682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f1683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f1684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f1685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f1686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f1687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f1688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected String f1689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected String f1690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected String f1691m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected int f1692n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected String f1693o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected String f1694p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected int f1695q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected long f1696r;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected String f1699u;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f1697s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f1698t = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected Map<String, Object> f1700v = new HashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f1701w = -1;

    protected d() {
    }

    public static d b() {
        return new d();
    }

    public long a() {
        return this.f1701w;
    }

    public d a(int i2) {
        this.f1691m = String.valueOf(i2);
        return this;
    }

    public d a(long j2) {
        this.f1696r = j2;
        return this;
    }

    public d a(String str) {
        this.f1682d = str;
        return this;
    }

    public d a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.f1700v.put(str, obj);
        }
        return this;
    }

    public d a(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.f1700v.putAll(map);
        }
        return this;
    }

    public d b(int i2) {
        this.f1695q = i2;
        return this;
    }

    public d b(long j2) {
        this.f1701w = j2;
        return this;
    }

    public d b(String str) {
        this.f1681c = str;
        return this;
    }

    public d c(int i2) {
        this.f1692n = i2;
        return this;
    }

    public d c(long j2) {
        this.f1687i = j2;
        return this;
    }

    public d c(String str) {
        this.f1684f = str;
        return this;
    }

    public d d(int i2) {
        this.f1693o = String.valueOf(i2);
        return this;
    }

    public d d(String str) {
        this.f1689k = str;
        return this;
    }

    public d e(int i2) {
        this.f1697s = i2;
        return this;
    }

    public d e(String str) {
        this.a = str;
        return this;
    }

    public d f(int i2) {
        this.f1694p = String.valueOf(i2);
        return this;
    }

    public d f(String str) {
        this.f1699u = str;
        return this;
    }

    public d g(int i2) {
        this.f1698t = i2;
        return this;
    }

    public d g(String str) {
        this.b = str;
        return this;
    }

    public d h(String str) {
        this.f1683e = str;
        return this;
    }

    public d i(String str) {
        this.f1686h = str;
        return this;
    }

    public d j(String str) {
        this.f1685g = str;
        return this;
    }

    public d k(String str) {
        this.f1688j = str;
        return this;
    }
}
