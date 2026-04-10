package com.tencent.mm.opensdk.diffdev.a;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes4.dex */
public enum d {
    UUID_EXPIRED(402),
    UUID_CANCELED(403),
    UUID_SCANED(404),
    UUID_CONFIRM(TTAdConstant.LANDING_PAGE_TYPE_CODE),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(500);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7249a;

    d(int i) {
        this.f7249a = i;
    }

    public int a() {
        return this.f7249a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f7249a;
    }
}
