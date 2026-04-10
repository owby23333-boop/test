package com.google.zxing.r.c;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.g;

/* JADX INFO: compiled from: QRCode.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private Mode a;
    private ErrorCorrectionLevel b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f16367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f16368d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f16369e;

    public static boolean b(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public b a() {
        return this.f16369e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.f16367c);
        sb.append("\n maskPattern: ");
        sb.append(this.f16368d);
        if (this.f16369e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f16369e);
        }
        sb.append(">>\n");
        return sb.toString();
    }

    public void a(Mode mode) {
        this.a = mode;
    }

    public void a(ErrorCorrectionLevel errorCorrectionLevel) {
        this.b = errorCorrectionLevel;
    }

    public void a(g gVar) {
        this.f16367c = gVar;
    }

    public void a(int i2) {
        this.f16368d = i2;
    }

    public void a(b bVar) {
        this.f16369e = bVar;
    }
}
