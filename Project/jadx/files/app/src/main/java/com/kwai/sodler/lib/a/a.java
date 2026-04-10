package com.kwai.sodler.lib.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwai.sodler.lib.i;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    protected File aIQ;
    protected String aIR;
    protected String aIS;
    private final String aIV;
    protected com.kwai.sodler.lib.c.b aIW;
    protected String mVersion;
    private final byte[] aIU = new byte[0];
    private boolean aIT = false;
    protected com.kwai.sodler.lib.ext.c aIq = i.IZ().Jb();

    public a(String str) {
        this.aIV = str;
        this.aIR = str;
    }

    private void Jk() {
        if (this.aIT) {
            return;
        }
        synchronized (this.aIU) {
            this.aIT = true;
        }
    }

    public final String Jl() {
        return this.aIV;
    }

    public final String Jm() {
        com.kwai.sodler.lib.c.b bVar = this.aIW;
        if (bVar != null) {
            return bVar.aJB;
        }
        return null;
    }

    public final a a(@NonNull com.kwai.sodler.lib.c.b bVar) {
        this.aIW = bVar;
        return this;
    }

    protected abstract void at(Context context, String str);

    public final void av(Context context, String str) {
        at(context, str);
        Jk();
    }

    public final void fA(String str) {
        this.aIR = str;
    }

    public final void fy(String str) {
        this.mVersion = str;
    }

    public final void fz(String str) {
        this.aIS = str;
    }

    public final String getId() {
        return this.aIS;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isLoaded() {
        boolean z2;
        if (this.aIT) {
            return true;
        }
        synchronized (this.aIU) {
            z2 = this.aIT;
        }
        return z2;
    }

    public String toString() {
        return "Plugin{, ApkPath = '" + this.aIV + "'}";
    }
}
