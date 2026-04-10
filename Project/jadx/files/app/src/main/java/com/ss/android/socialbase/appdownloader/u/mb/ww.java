package com.ss.android.socialbase.appdownloader.u.mb;

/* JADX INFO: loaded from: classes3.dex */
public class ww extends Exception {
    protected int b;
    protected Throwable mb;
    protected int ox;

    public ww(String str, ko koVar, Throwable th) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (koVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + koVar.hj() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        super(sb.toString());
        this.ox = -1;
        this.b = -1;
        if (koVar != null) {
            this.ox = koVar.b();
            this.b = koVar.u();
        }
        this.mb = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.mb == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.mb.printStackTrace();
        }
    }
}
