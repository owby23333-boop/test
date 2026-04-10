package com.bytedance.sdk.component.d.bf.e.ga;

import okhttp3.internal.http2.Header;

/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final com.bytedance.sdk.component.d.e.vn p;
    public final com.bytedance.sdk.component.d.e.vn v;
    final int zk;
    public static final com.bytedance.sdk.component.d.e.vn e = com.bytedance.sdk.component.d.e.vn.e(":");
    public static final com.bytedance.sdk.component.d.e.vn bf = com.bytedance.sdk.component.d.e.vn.e(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.component.d.e.vn d = com.bytedance.sdk.component.d.e.vn.e(Header.TARGET_METHOD_UTF8);
    public static final com.bytedance.sdk.component.d.e.vn tg = com.bytedance.sdk.component.d.e.vn.e(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.component.d.e.vn ga = com.bytedance.sdk.component.d.e.vn.e(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.component.d.e.vn vn = com.bytedance.sdk.component.d.e.vn.e(Header.TARGET_AUTHORITY_UTF8);

    public d(String str, String str2) {
        this(com.bytedance.sdk.component.d.e.vn.e(str), com.bytedance.sdk.component.d.e.vn.e(str2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.p.equals(dVar.p) && this.v.equals(dVar.v);
    }

    public int hashCode() {
        return ((527 + this.p.hashCode()) * 31) + this.v.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.d.bf.e.d.e("%s: %s", this.p.e(), this.v.e());
    }

    public d(com.bytedance.sdk.component.d.e.vn vnVar, String str) {
        this(vnVar, com.bytedance.sdk.component.d.e.vn.e(str));
    }

    public d(com.bytedance.sdk.component.d.e.vn vnVar, com.bytedance.sdk.component.d.e.vn vnVar2) {
        this.p = vnVar;
        this.v = vnVar2;
        this.zk = vnVar.p() + 32 + vnVar2.p();
    }
}
