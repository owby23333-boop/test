package com.anythink.core.common.e;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    private String a;
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7228c;

    public d(String str, String str2, int i2) {
        this.a = str;
        this.b = str2;
        this.f7228c = i2;
    }

    private String b() {
        return this.a;
    }

    private int c() {
        return this.f7228c;
    }

    public final String a() {
        return this.b;
    }

    public final boolean a(ai aiVar) {
        if (aiVar != null) {
            int i2 = aiVar.a;
            return i2 != 2 ? i2 == 3 && aiVar.c() == this.f7228c : aiVar.t().equals(this.a);
        }
        return false;
    }
}
