package com.anythink.core.common;

import com.anythink.core.api.AdError;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends IllegalStateException {
    public AdError a;
    public String b;

    public e(AdError adError, String str) {
        this.a = adError;
        this.b = str;
    }
}
