package com.ss.android.socialbase.appdownloader.m.z;

import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes4.dex */
public class gz extends Exception {
    protected int dl;
    protected int g;
    protected Throwable z;

    public gz(String str, e eVar, Throwable th) {
        super((str == null ? "" : str + " ") + (eVar == null ? "" : "(position:" + eVar.a() + ") ") + (th != null ? "caused by: " + th : ""));
        this.g = -1;
        this.dl = -1;
        if (eVar != null) {
            this.g = eVar.dl();
            this.dl = eVar.m();
        }
        this.z = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.z == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            wp.z(this.z);
        }
    }
}
