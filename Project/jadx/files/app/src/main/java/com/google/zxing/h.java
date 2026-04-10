package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private final String a;
    private final byte[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private i[] f16208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BarcodeFormat f16209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<ResultMetadataType, Object> f16210e;

    public h(String str, byte[] bArr, i[] iVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, iVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public BarcodeFormat a() {
        return this.f16209d;
    }

    public byte[] b() {
        return this.b;
    }

    public Map<ResultMetadataType, Object> c() {
        return this.f16210e;
    }

    public i[] d() {
        return this.f16208c;
    }

    public String e() {
        return this.a;
    }

    public String toString() {
        return this.a;
    }

    public h(String str, byte[] bArr, i[] iVarArr, BarcodeFormat barcodeFormat, long j2) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, iVarArr, barcodeFormat, j2);
    }

    public void a(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f16210e == null) {
            this.f16210e = new EnumMap(ResultMetadataType.class);
        }
        this.f16210e.put(resultMetadataType, obj);
    }

    public h(String str, byte[] bArr, int i2, i[] iVarArr, BarcodeFormat barcodeFormat, long j2) {
        this.a = str;
        this.b = bArr;
        this.f16208c = iVarArr;
        this.f16209d = barcodeFormat;
        this.f16210e = null;
    }

    public void a(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f16210e;
            if (map2 == null) {
                this.f16210e = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void a(i[] iVarArr) {
        i[] iVarArr2 = this.f16208c;
        if (iVarArr2 == null) {
            this.f16208c = iVarArr;
            return;
        }
        if (iVarArr == null || iVarArr.length <= 0) {
            return;
        }
        i[] iVarArr3 = new i[iVarArr2.length + iVarArr.length];
        System.arraycopy(iVarArr2, 0, iVarArr3, 0, iVarArr2.length);
        System.arraycopy(iVarArr, 0, iVarArr3, iVarArr2.length, iVarArr.length);
        this.f16208c = iVarArr3;
    }
}
