package com.kingsoft.iciba.sdk2.a;

import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public abstract class c {
    private String Q;
    protected int Z;
    private String ab;
    protected String[] ad;
    public int[] ae;
    protected String P = "";
    private boolean R = false;
    protected int S = -1;
    private int T = 0;
    protected String[] U = null;
    protected int[] V = null;
    protected String[] W = null;
    protected Integer[] X = null;
    public char[] Y = null;
    private boolean aa = false;
    private boolean ac = false;

    public c(String str) {
        this.ab = null;
        this.Q = str;
        this.ab = this.Q + "capword" + File.separator;
    }

    public abstract int a(int i);

    public final void a(boolean z) {
        this.R = z;
    }

    public abstract int b(int i);

    public final void b(boolean z) {
        this.aa = z;
    }

    public final void c(boolean z) {
        this.ac = z;
    }

    public final int d(int i) {
        if (this.T == i && !this.ac) {
            return 2;
        }
        this.T = i;
        return b(i);
    }

    public final boolean g() {
        return this.R;
    }

    public final boolean h() {
        return this.R && this.aa;
    }

    public final String i() {
        return this.Q;
    }

    public final String j() {
        return this.Q + "info.txt";
    }

    public final String k() {
        return this.Q + "count.idx";
    }

    public final String l() {
        return this.Q + "index.lix";
    }

    public final String m() {
        return this.Q + this.T + ".dix";
    }

    public final String n() {
        return this.Q + this.T + ".idx";
    }

    public final void o(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length >= 3) {
            this.P = strArrSplit[0];
            Integer.valueOf(strArrSplit[2]).intValue();
            this.S = Integer.valueOf(strArrSplit[3]).intValue();
        }
    }

    public final String p() {
        return this.Q + this.T + ".lix";
    }

    public final String q() {
        return this.ab + this.T + ".idx";
    }

    public final String r() {
        return this.ab + this.T + ".lix";
    }

    public final String s() {
        return this.ab + "count.idx";
    }

    public final String t() {
        return this.ab + "index.lix";
    }

    public final boolean u() {
        return this.ac;
    }

    public final int c(int i) {
        if (this.T == i && !this.ac) {
            return 2;
        }
        this.T = i;
        return a(i);
    }

    public final String o() {
        return this.ab + this.T + ".dix";
    }
}
