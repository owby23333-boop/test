package com.anythink.expressad.exoplayer.g.b;

import com.anythink.expressad.exoplayer.g.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements a.InterfaceC0191a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9110g;

    public h(String str) {
        this.f9110g = (String) com.anythink.expressad.exoplayer.k.a.a(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f9110g;
    }
}
