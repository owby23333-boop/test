package com.kwai.sodler.lib.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f<P extends a> {
    protected e aIF;
    protected String aIS;
    private final byte[] aIU;
    protected int aIX;
    protected int aIY;
    protected StringBuffer aIZ;
    protected String aJa;
    protected String aJb;
    protected boolean aJc;
    protected P aJd;
    protected com.kwai.sodler.lib.ext.b aJe;
    protected Throwable aJf;
    protected String aJg;
    protected boolean aJh;
    protected long aJi;
    protected List<com.kwai.sodler.lib.c.a> aJj;
    protected com.kwai.sodler.lib.c.b aJk;
    protected String asL;
    protected String mDownloadUrl;
    protected int mState;
    protected String mVersion;

    public f() {
        this.mState = -1;
        this.aIX = 0;
        this.aIU = new byte[0];
        this.aIZ = new StringBuffer(String.valueOf(this.mState));
    }

    public f(com.kwai.sodler.lib.c.b bVar) {
        this();
        this.aJk = bVar;
        this.aIS = bVar.aJy;
        this.mVersion = bVar.version;
        this.aJh = bVar.aJh;
        this.aJg = bVar.aJg;
    }

    private List<com.kwai.sodler.lib.c.a> at(String str, String str2) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.aIF.Je().fu(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str3 : list) {
                    if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str2) || !str2.equals(str3) || !this.aIF.Je().as(str, str3)) {
                        this.aIF.Je().ap(str, str3);
                    } else {
                        com.kwai.sodler.lib.c.a aVar = new com.kwai.sodler.lib.c.a();
                        aVar.aJy = str;
                        aVar.version = str3;
                        aVar.qX = true;
                        arrayList.add(aVar);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    @Nullable
    public final List<com.kwai.sodler.lib.c.a> JA() {
        return this.aJj;
    }

    @Nullable
    public final com.kwai.sodler.lib.c.b JB() {
        return this.aJk;
    }

    public final void JC() {
        String id = getId();
        if (TextUtils.isEmpty(id) || this.aJj != null) {
            return;
        }
        this.aJj = at(id, getVersion());
    }

    public final void JD() {
        dg(-3);
    }

    public final e Jo() {
        return this.aIF;
    }

    public final String Jp() {
        return this.aIZ.toString();
    }

    @Nullable
    public final Throwable Jq() {
        return this.aJf;
    }

    public final boolean Jr() {
        dg(-1);
        this.aJj = null;
        int i2 = this.aIX + 1;
        this.aIX = i2;
        return i2 <= this.aIY;
    }

    public final boolean Js() {
        return this.aJc;
    }

    public final int Jt() {
        return this.aIX;
    }

    @Nullable
    public final String Ju() {
        return !TextUtils.isEmpty(this.aJa) ? this.aJa : this.aJb;
    }

    @Nullable
    public final P Jv() {
        return this.aJd;
    }

    @Nullable
    public final com.kwai.sodler.lib.ext.b Jw() {
        return this.aJe;
    }

    public final boolean Jx() {
        return this.aJh;
    }

    public final String Jy() {
        return this.aJg;
    }

    public final String Jz() {
        return this.asL;
    }

    public final f a(e eVar) {
        this.aIF = eVar;
        return this;
    }

    public final void a(com.kwai.sodler.lib.ext.b bVar) {
        this.aJe = bVar;
    }

    @Deprecated
    public final void as(long j2) {
        this.aJi = j2;
    }

    public final void b(com.kwai.sodler.lib.c.b bVar) {
        this.aJk = bVar;
    }

    public final void c(P p2) {
        this.aJd = p2;
    }

    public final void cancel() {
        synchronized (this.aIU) {
            dg(-7);
        }
    }

    public final f dg(int i2) {
        synchronized (this.aIU) {
            this.mState = i2;
        }
        return fB(String.valueOf(i2));
    }

    public final void dh(int i2) {
        if (i2 > 0) {
            this.aIY = i2;
        }
    }

    public final f fB(String str) {
        if (!TextUtils.isEmpty(str)) {
            StringBuffer stringBuffer = this.aIZ;
            stringBuffer.append(" --> ");
            stringBuffer.append(str);
        }
        return this;
    }

    public final void fC(String str) {
        this.aJa = str;
    }

    public final void fD(String str) {
        this.aJb = str;
    }

    public final void fE(String str) {
        this.asL = str;
    }

    public final void fF(String str) {
        this.mDownloadUrl = str;
    }

    public abstract P fG(String str);

    public final void fy(String str) {
        this.mVersion = str;
    }

    @Nullable
    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Nullable
    public final String getId() {
        return this.aIS;
    }

    public final int getState() {
        int i2;
        synchronized (this.aIU) {
            i2 = this.mState;
        }
        return i2;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final boolean isCanceled() {
        return this.mState == -7;
    }

    public final f o(@NonNull Throwable th) {
        this.aJf = th;
        return fB(th.getLocalizedMessage());
    }

    public String toString() {
        return "PluginRequest{mId='" + this.aIS + "'}";
    }
}
