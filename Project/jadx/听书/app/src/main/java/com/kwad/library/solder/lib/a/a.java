package com.kwad.library.solder.lib.a;

import android.content.Context;
import com.kwad.library.solder.lib.i;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    protected File aqK;
    protected String aqL;
    protected String aqM;
    private final String aqP;
    protected com.kwad.library.solder.lib.c.b aqQ;
    protected String mVersion;
    private final byte[] aqO = new byte[0];
    private boolean aqN = false;
    protected com.kwad.library.solder.lib.ext.c aqp = i.zS().zM();

    protected abstract void i(Context context, String str);

    public a(String str) {
        this.aqP = str;
        this.aqL = str;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.aqP + "'}";
    }

    public final a a(com.kwad.library.solder.lib.c.b bVar) {
        this.aqQ = bVar;
        return this;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final void bS(String str) {
        this.mVersion = str;
    }

    public final boolean isLoaded() {
        boolean z;
        if (this.aqN) {
            return true;
        }
        synchronized (this.aqO) {
            z = this.aqN;
        }
        return z;
    }

    public final String getId() {
        return this.aqM;
    }

    public final void bT(String str) {
        this.aqM = str;
    }

    private void zW() {
        if (this.aqN) {
            return;
        }
        synchronized (this.aqO) {
            this.aqN = true;
        }
    }

    public final String zX() {
        return this.aqP;
    }

    public final void bU(String str) {
        this.aqL = str;
    }

    public final String zY() {
        com.kwad.library.solder.lib.c.b bVar = this.aqQ;
        if (bVar != null) {
            return bVar.arA;
        }
        return null;
    }

    public final void n(Context context, String str) {
        i(context, str);
        zW();
    }
}
