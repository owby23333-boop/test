package com.bytedance.sdk.component.dl.g.z.gc;

import okhttp3.internal.http2.Header;

/* JADX INFO: loaded from: classes2.dex */
public final class dl {
    public final com.bytedance.sdk.component.dl.z.m e;
    final int fo;
    public final com.bytedance.sdk.component.dl.z.m gz;
    public static final com.bytedance.sdk.component.dl.z.m z = com.bytedance.sdk.component.dl.z.m.z(":");
    public static final com.bytedance.sdk.component.dl.z.m g = com.bytedance.sdk.component.dl.z.m.z(Header.RESPONSE_STATUS_UTF8);
    public static final com.bytedance.sdk.component.dl.z.m dl = com.bytedance.sdk.component.dl.z.m.z(Header.TARGET_METHOD_UTF8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.sdk.component.dl.z.m f665a = com.bytedance.sdk.component.dl.z.m.z(Header.TARGET_PATH_UTF8);
    public static final com.bytedance.sdk.component.dl.z.m gc = com.bytedance.sdk.component.dl.z.m.z(Header.TARGET_SCHEME_UTF8);
    public static final com.bytedance.sdk.component.dl.z.m m = com.bytedance.sdk.component.dl.z.m.z(Header.TARGET_AUTHORITY_UTF8);

    public dl(String str, String str2) {
        this(com.bytedance.sdk.component.dl.z.m.z(str), com.bytedance.sdk.component.dl.z.m.z(str2));
    }

    public dl(com.bytedance.sdk.component.dl.z.m mVar, String str) {
        this(mVar, com.bytedance.sdk.component.dl.z.m.z(str));
    }

    public dl(com.bytedance.sdk.component.dl.z.m mVar, com.bytedance.sdk.component.dl.z.m mVar2) {
        this.e = mVar;
        this.gz = mVar2;
        this.fo = mVar.e() + 32 + mVar2.e();
    }

    public boolean equals(Object obj) {
        if (obj instanceof dl) {
            dl dlVar = (dl) obj;
            if (this.e.equals(dlVar.e) && this.gz.equals(dlVar.gz)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.e.hashCode() + 527) * 31) + this.gz.hashCode();
    }

    public String toString() {
        return com.bytedance.sdk.component.dl.g.z.dl.z("%s: %s", this.e.z(), this.gz.z());
    }
}
