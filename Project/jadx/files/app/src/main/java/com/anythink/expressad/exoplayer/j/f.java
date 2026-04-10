package com.anythink.expressad.exoplayer.j;

import android.net.Uri;
import android.util.Base64;
import com.anythink.expressad.exoplayer.k.af;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes2.dex */
public final class f implements h {
    public static final String a = "data";
    private k b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f9662d;

    @Override // com.anythink.expressad.exoplayer.j.h
    public final long a(k kVar) throws com.anythink.expressad.exoplayer.t {
        this.b = kVar;
        Uri uri = kVar.f9667c;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new com.anythink.expressad.exoplayer.t("Unsupported scheme: ".concat(String.valueOf(scheme)));
        }
        String[] strArrA = af.a(uri.getSchemeSpecificPart(), ",");
        if (strArrA.length != 2) {
            throw new com.anythink.expressad.exoplayer.t("Unexpected URI format: ".concat(String.valueOf(uri)));
        }
        String str = strArrA[1];
        if (strArrA[0].contains(";base64")) {
            try {
                this.f9662d = Base64.decode(str, 0);
            } catch (IllegalArgumentException e2) {
                throw new com.anythink.expressad.exoplayer.t("Error while parsing Base64 encoded string: ".concat(String.valueOf(str)), e2);
            }
        } else {
            this.f9662d = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.f9662d.length;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final void b() {
        this.b = null;
        this.f9662d = null;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int length = this.f9662d.length - this.f9661c;
        if (length == 0) {
            return -1;
        }
        int iMin = Math.min(i3, length);
        System.arraycopy(this.f9662d, this.f9661c, bArr, i2, iMin);
        this.f9661c += iMin;
        return iMin;
    }

    @Override // com.anythink.expressad.exoplayer.j.h
    public final Uri a() {
        k kVar = this.b;
        if (kVar != null) {
            return kVar.f9667c;
        }
        return null;
    }
}
