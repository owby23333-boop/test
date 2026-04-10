package com.anythink.expressad.exoplayer.e.a;

import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.e.m;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8980f = "TrackEncryptionBox";
    public final boolean a;

    @Nullable
    public final String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.a f8981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f8982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f8983e;

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public k(boolean z2, @Nullable String str, int i2, byte[] bArr, int i3, int i4, @Nullable byte[] bArr2) {
        int i5 = 1;
        com.anythink.expressad.exoplayer.k.a.a((i2 == 0) ^ (bArr2 == null));
        this.a = z2;
        this.b = str;
        this.f8982d = i2;
        this.f8983e = bArr2;
        if (str != null) {
            byte b = -1;
            switch (str.hashCode()) {
                case 3046605:
                    if (str.equals(com.anythink.expressad.exoplayer.b.be)) {
                        b = 2;
                    }
                    break;
                case 3046671:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bg)) {
                        b = 3;
                    }
                    break;
                case 3049879:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bd)) {
                        b = 0;
                    }
                    break;
                case 3049895:
                    if (str.equals(com.anythink.expressad.exoplayer.b.bf)) {
                        b = 1;
                    }
                    break;
            }
            if (b != 0 && b != 1) {
                if (b == 2 || b == 3) {
                    i5 = 2;
                } else {
                    String str2 = "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.";
                }
            }
        }
        this.f8981c = new m.a(i5, bArr, i3, i4);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        byte b = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(com.anythink.expressad.exoplayer.b.be)) {
                    b = 2;
                }
                break;
            case 3046671:
                if (str.equals(com.anythink.expressad.exoplayer.b.bg)) {
                    b = 3;
                }
                break;
            case 3049879:
                if (str.equals(com.anythink.expressad.exoplayer.b.bd)) {
                    b = 0;
                }
                break;
            case 3049895:
                if (str.equals(com.anythink.expressad.exoplayer.b.bf)) {
                    b = 1;
                }
                break;
        }
        if (b == 0 || b == 1) {
            return 1;
        }
        if (b == 2 || b == 3) {
            return 2;
        }
        String str2 = "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.";
        return 1;
    }
}
