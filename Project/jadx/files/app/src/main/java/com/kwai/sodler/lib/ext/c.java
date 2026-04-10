package com.kwai.sodler.lib.ext;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private final int aIY;
    private final String aJl;
    private final String aJm;
    private final String aJn;
    private final String aJo;
    private final String aJp;
    private final String aJq;
    private final String aJr;
    private final boolean aJs;
    private final boolean aJt;
    private final boolean aJu;
    private String aJv;
    private byte[] aJw;
    private boolean aJx;

    public static class a {
        private String aJr;
        private boolean aJu;
        private String aJv;
        private byte[] aJw;
        private boolean aJx;
        private int aIY = 3;
        private String aJl = "sodler";
        private String aJm = "code-cache";
        private String aJn = "lib";
        private String aJo = "temp";
        private String aJq = "base-1.apk";
        private String aJp = ".tmp";
        private boolean aJt = false;
        private boolean aJs = false;

        public final c JM() {
            return new c(this.aJs, this.aJt, this.aJr, this.aJl, this.aJm, this.aJn, this.aJo, this.aJp, this.aJq, this.aIY, this.aJv, this.aJw, this.aJx, this.aJu, (byte) 0);
        }

        public final a bQ(boolean z2) {
            this.aJx = false;
            return this;
        }

        public final a bR(boolean z2) {
            this.aJu = z2;
            return this;
        }

        public final a di(int i2) {
            if (i2 > 0) {
                this.aIY = i2;
            }
            return this;
        }

        public final a fH(@NonNull String str) {
            this.aJl = str;
            return this;
        }
    }

    private c(boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z4, boolean z5) {
        this.aIY = i2;
        this.aJl = str2;
        this.aJm = str3;
        this.aJn = str4;
        this.aJo = str5;
        this.aJp = str6;
        this.aJq = str7;
        this.aJr = str;
        this.aJs = z2;
        this.aJt = z3;
        this.aJv = str8;
        this.aJw = bArr;
        this.aJx = z4;
        this.aJu = z5;
    }

    /* synthetic */ c(boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i2, String str8, byte[] bArr, boolean z4, boolean z5, byte b) {
        this(z2, z3, str, str2, str3, str4, str5, str6, str7, i2, str8, bArr, z4, z5);
    }

    public final String JE() {
        return this.aJl;
    }

    public final String JF() {
        return this.aJm;
    }

    public final String JG() {
        return this.aJn;
    }

    public final String JH() {
        return this.aJo;
    }

    public final String JI() {
        return this.aJp;
    }

    public final String JJ() {
        return this.aJq;
    }

    public final boolean JK() {
        return this.aJt;
    }

    public final boolean JL() {
        return this.aJu;
    }

    public final int getRetryCount() {
        return this.aIY;
    }
}
