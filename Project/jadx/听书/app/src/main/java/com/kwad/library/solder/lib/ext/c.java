package com.kwad.library.solder.lib.ext;

import android.os.Build;
import com.kuaishou.weapon.p0.bi;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final int aqS;
    private final String arg;
    private final String arh;
    private final String ari;
    private final String arj;
    private final String ark;
    private final String arl;
    private final String arm;
    private final boolean arn;
    private final boolean aro;
    private final boolean arp;
    private ExecutorService arq;
    private String arr;
    private byte[] ars;
    private boolean art;
    private int aru;

    /* synthetic */ c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2, byte b) {
        this(z, z2, str, str2, str3, str4, str5, str6, str7, i, str8, bArr, z3, z4, executorService, i2);
    }

    private c(boolean z, boolean z2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, byte[] bArr, boolean z3, boolean z4, ExecutorService executorService, int i2) {
        this.aqS = i;
        this.arg = str2;
        this.arh = str3;
        this.ari = str4;
        this.arj = str5;
        this.ark = str6;
        this.arl = str7;
        this.arm = str;
        this.arn = z;
        this.aro = z2;
        this.arr = str8;
        this.ars = bArr;
        this.art = z3;
        this.arp = z4;
        this.arq = executorService;
        this.aru = i2;
    }

    public final int getRetryCount() {
        return this.aqS;
    }

    public final int An() {
        return this.aru;
    }

    public final String Ao() {
        return this.arg;
    }

    public final String Ap() {
        return this.arh;
    }

    public final String Aq() {
        return this.ari;
    }

    public final String Ar() {
        return this.arj;
    }

    public final String As() {
        return this.ark;
    }

    public final String At() {
        return this.arl;
    }

    public final boolean Au() {
        return this.aro;
    }

    public final boolean Av() {
        return this.arp;
    }

    public final ExecutorService Aw() {
        return this.arq;
    }

    public static class a {
        private static final String arv;
        private String arm;
        private boolean arp;
        private ExecutorService arq;
        private String arr;
        private byte[] ars;
        private boolean art;
        private int arw;
        private int aqS = 3;
        private String arg = "sodler";
        private String arh = "code-cache";
        private String ari = "lib";
        private String arj = "temp";
        private String arl = arv;
        private String ark = bi.k;
        private boolean aro = false;
        private boolean arn = false;

        static {
            arv = Ax() ? "base-1_apk" : "base-1.apk";
        }

        private static boolean Ax() {
            return Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32;
        }

        public final a bZ(String str) {
            this.arg = str;
            return this;
        }

        public final a cj(int i) {
            if (i > 0) {
                this.aqS = i;
            }
            return this;
        }

        public final a bk(boolean z) {
            this.art = false;
            return this;
        }

        public final a bl(boolean z) {
            this.arp = z;
            return this;
        }

        public final a a(ExecutorService executorService) {
            this.arq = executorService;
            return this;
        }

        public final a ck(int i) {
            this.arw = i;
            return this;
        }

        public final c Ay() {
            return new c(this.arn, this.aro, this.arm, this.arg, this.arh, this.ari, this.arj, this.ark, this.arl, this.aqS, this.arr, this.ars, this.art, this.arp, this.arq, this.arw, (byte) 0);
        }
    }
}
