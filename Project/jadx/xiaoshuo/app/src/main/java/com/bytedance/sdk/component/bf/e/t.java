package com.bytedance.sdk.component.bf.e;

/* JADX INFO: loaded from: classes.dex */
public class t {
    private String bf;
    public m d;
    private String e;
    public byte[] ga;
    public String tg;
    public e vn;

    public enum e {
        STRING_TYPE,
        BYTE_ARRAY_TYPE,
        FILE_TYPE
    }

    public t() {
    }

    public String bf() {
        return this.bf;
    }

    public String e() {
        return this.e;
    }

    public t(m mVar, String str, e eVar) {
        this.d = mVar;
        this.tg = str;
        this.vn = eVar;
    }

    public static t e(m mVar, String str) {
        return new t(mVar, str, e.STRING_TYPE);
    }

    public static t e(m mVar, byte[] bArr) {
        return new t(mVar, bArr, e.BYTE_ARRAY_TYPE);
    }

    public static t e(m mVar, byte[] bArr, String str, String str2) {
        return new t(mVar, bArr, str, str2, e.FILE_TYPE);
    }

    public t(m mVar, byte[] bArr, String str, String str2, e eVar) {
        this.d = mVar;
        this.ga = bArr;
        this.bf = str;
        this.e = str2;
        this.vn = eVar;
    }

    public t(m mVar, byte[] bArr, e eVar) {
        this.d = mVar;
        this.ga = bArr;
        this.vn = eVar;
    }
}
