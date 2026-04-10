package com.kwad.components.ad.reward.c;

/* JADX INFO: loaded from: classes3.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static int STATUS_NONE = 2;
    public static int uk = 1;
    public static int ul = 3;
    public int um;
    public int un;

    public b() {
        this.um = STATUS_NONE;
    }

    public b(int i) {
        this.um = 1;
    }

    public final int getType() {
        return this.um;
    }

    public final int hY() {
        return this.un;
    }

    public final void aa(int i) {
        this.un = i;
    }
}
