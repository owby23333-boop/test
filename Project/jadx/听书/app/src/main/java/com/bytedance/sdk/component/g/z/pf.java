package com.bytedance.sdk.component.g.z;

/* JADX INFO: loaded from: classes2.dex */
public class pf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f719a;
    public uy dl;
    private String g;
    public byte[] gc;
    public z m;
    private String z;

    public enum z {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public pf() {
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public pf(uy uyVar, String str, z zVar) {
        this.dl = uyVar;
        this.f719a = str;
        this.m = zVar;
    }

    public pf(uy uyVar, byte[] bArr, String str, String str2, z zVar) {
        this.dl = uyVar;
        this.gc = bArr;
        this.g = str;
        this.z = str2;
        this.m = zVar;
    }

    public pf(uy uyVar, byte[] bArr, z zVar) {
        this.dl = uyVar;
        this.gc = bArr;
        this.m = zVar;
    }

    public static pf z(uy uyVar, String str) {
        return new pf(uyVar, str, z.STRING_TYPE);
    }

    public static pf z(uy uyVar, byte[] bArr) {
        return new pf(uyVar, bArr, z.BYTE_ARRAY_TYPE);
    }

    public static pf z(uy uyVar, byte[] bArr, String str, String str2) {
        return new pf(uyVar, bArr, str, str2, z.FILE_TYPE);
    }
}
