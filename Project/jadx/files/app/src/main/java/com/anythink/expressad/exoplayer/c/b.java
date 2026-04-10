package com.anythink.expressad.exoplayer.c;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.anythink.expressad.exoplayer.k.af;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public byte[] a;
    public byte[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f8721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f8722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f8726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f8727j;

    @TargetApi(24)
    private static final class a {
        private final MediaCodec.CryptoInfo a;
        private final MediaCodec.CryptoInfo.Pattern b;

        /* synthetic */ a(MediaCodec.CryptoInfo cryptoInfo, byte b) {
            this(cryptoInfo);
        }

        private void a(int i2, int i3) {
            this.b.set(i2, i3);
            this.a.setPattern(this.b);
        }

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.a = cryptoInfo;
            this.b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        static /* synthetic */ void a(a aVar, int i2, int i3) {
            aVar.b.set(i2, i3);
            aVar.a.setPattern(aVar.b);
        }
    }

    public b() {
        this.f8726i = af.a >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.f8727j = af.a >= 24 ? new a(this.f8726i, (byte) 0) : null;
    }

    @TargetApi(16)
    private static MediaCodec.CryptoInfo b() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void c() {
        MediaCodec.CryptoInfo cryptoInfo = this.f8726i;
        cryptoInfo.numSubSamples = this.f8723f;
        cryptoInfo.numBytesOfClearData = this.f8721d;
        cryptoInfo.numBytesOfEncryptedData = this.f8722e;
        cryptoInfo.key = this.b;
        cryptoInfo.iv = this.a;
        cryptoInfo.mode = this.f8720c;
        if (af.a >= 24) {
            a.a(this.f8727j, this.f8724g, this.f8725h);
        }
    }

    public final void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f8723f = i2;
        this.f8721d = iArr;
        this.f8722e = iArr2;
        this.b = bArr;
        this.a = bArr2;
        this.f8720c = i3;
        this.f8724g = i4;
        this.f8725h = i5;
        int i6 = af.a;
        if (i6 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.f8726i;
            cryptoInfo.numSubSamples = this.f8723f;
            cryptoInfo.numBytesOfClearData = this.f8721d;
            cryptoInfo.numBytesOfEncryptedData = this.f8722e;
            cryptoInfo.key = this.b;
            cryptoInfo.iv = this.a;
            cryptoInfo.mode = this.f8720c;
            if (i6 >= 24) {
                a.a(this.f8727j, this.f8724g, this.f8725h);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo a() {
        return this.f8726i;
    }
}
