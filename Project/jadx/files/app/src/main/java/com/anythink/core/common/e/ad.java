package com.anythink.core.common.e;

import com.anythink.core.api.ATAdInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ad {
    private com.anythink.core.common.f b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, Object> f7133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f7134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, String> f7135e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7136f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f7138h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f7137g = "";
    final Object a = new Object();

    public final Object a() {
        return this.a;
    }

    public final com.anythink.core.common.f b() {
        return this.b;
    }

    public final Map<String, Object> c() {
        return this.f7133c;
    }

    public final d d() {
        return this.f7134d;
    }

    public final boolean e() {
        return this.f7136f;
    }

    public final String f() {
        return this.f7137g;
    }

    public final void a(com.anythink.core.common.f fVar) {
        this.b = fVar;
    }

    public final void b(String str, String str2) {
        if (this.f7138h == null) {
            this.f7138h = new ConcurrentHashMap(2);
        }
        this.f7138h.put(str, str2);
    }

    public final void a(Map<String, Object> map) {
        this.f7133c = map;
    }

    public final void a(String str, Object obj) {
        if (this.f7133c == null) {
            this.f7133c = new ConcurrentHashMap(2);
        }
        this.f7133c.put(str, obj);
    }

    public final String b(String str) {
        Map<String, String> map = this.f7138h;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final void a(ATAdInfo aTAdInfo) {
        if (aTAdInfo != null) {
            this.f7134d = new d(aTAdInfo.getAdsourceId(), aTAdInfo.getShowId(), aTAdInfo.getNetworkFirmId());
        } else {
            this.f7134d = null;
        }
    }

    public final String a(String str) {
        if (this.f7135e == null) {
            this.f7135e = new ConcurrentHashMap(2);
        }
        return this.f7135e.remove(str);
    }

    public final void a(String str, String str2) {
        if (this.f7135e == null) {
            this.f7135e = new ConcurrentHashMap(2);
        }
        this.f7135e.put(str, str2);
    }

    public final void a(boolean z2) {
        this.f7136f = z2;
    }

    public final void a(Object[] objArr) {
        this.f7137g = com.anythink.core.common.k.h.a(objArr);
    }
}
