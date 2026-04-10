package com.ss.android.socialbase.appdownloader.vn.e;

/* JADX INFO: loaded from: classes4.dex */
public class v extends Exception {
    protected int bf;
    protected int d;
    protected Throwable e;

    public v(String str, p pVar, Throwable th) {
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
        if (pVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + pVar.tg() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        super(sb.toString());
        this.bf = -1;
        this.d = -1;
        if (pVar != null) {
            this.bf = pVar.d();
            this.d = pVar.vn();
        }
        this.e = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.e == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            this.e.printStackTrace();
        }
    }
}
