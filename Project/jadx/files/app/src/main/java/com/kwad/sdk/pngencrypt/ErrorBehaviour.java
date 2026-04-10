package com.kwad.sdk.pngencrypt;

/* JADX INFO: loaded from: classes3.dex */
public enum ErrorBehaviour {
    STRICT(0),
    LENIENT1_CRC(1),
    LENIENT2_ANCILLARY(3),
    SUPER_LENIENT(5);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f16966c;

    ErrorBehaviour(int i2) {
        this.f16966c = i2;
    }
}
