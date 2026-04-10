package com.anythink.expressad.foundation.g.f.d;

import com.anythink.expressad.foundation.g.f.i;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<T> extends i<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10538c = e.class.getSimpleName();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f10539d;

    public e(int i2, String str, String str2, com.anythink.expressad.foundation.g.f.e<T> eVar) {
        super(i2, str, eVar);
        this.f10539d = str2;
    }

    @Override // com.anythink.expressad.foundation.g.f.i
    public final byte[] h() {
        try {
            if (this.f10539d == null) {
                return null;
            }
            return this.f10539d.getBytes(com.anythink.expressad.foundation.g.a.bN);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
