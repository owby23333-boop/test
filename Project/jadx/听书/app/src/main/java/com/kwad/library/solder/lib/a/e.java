package com.kwad.library.solder.lib.a;

import android.text.TextUtils;
import com.kwad.library.solder.lib.a.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e<P extends a> {
    protected int aqS;
    protected String aqU;
    protected String aqV;
    protected boolean aqW;
    protected P aqX;
    protected com.kwad.library.solder.lib.ext.b aqY;
    protected Throwable aqZ;
    protected String aqj;
    protected d aqz;
    protected String ara;
    protected boolean arb;
    protected long arc;
    protected String ard;
    protected List<com.kwad.library.solder.lib.c.a> are;
    protected com.kwad.library.solder.lib.c.b arf;
    protected String mDownloadUrl;
    protected String mVersion;
    protected int mState = -1;
    protected int aqR = 0;
    private final byte[] aqO = new byte[0];
    protected StringBuffer aqT = new StringBuffer(String.valueOf(this.mState));

    public abstract P bY(String str);

    public e(com.kwad.library.solder.lib.c.b bVar) {
        this.arf = bVar;
        this.aqj = bVar.arx;
        this.mVersion = bVar.version;
        this.ard = bVar.arA;
        this.arb = bVar.arb;
        this.ara = bVar.ara;
        this.arc = bVar.arz;
        this.mDownloadUrl = bVar.ary;
    }

    public final String getVersion() {
        return this.mVersion;
    }

    public final void bS(String str) {
        this.mVersion = str;
    }

    public final e a(d dVar) {
        this.aqz = dVar;
        return this;
    }

    public final d zZ() {
        return this.aqz;
    }

    public final int getState() {
        int i;
        synchronized (this.aqO) {
            i = this.mState;
        }
        return i;
    }

    public final String Aa() {
        return this.aqT.toString();
    }

    public final e ch(int i) {
        synchronized (this.aqO) {
            this.mState = i;
        }
        return bV(String.valueOf(i));
    }

    public final void cancel() {
        synchronized (this.aqO) {
            ch(0);
        }
    }

    public final boolean isCanceled() {
        return this.mState == 0;
    }

    public final e bV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aqT.append(" --> ").append(str);
        }
        return this;
    }

    public final Throwable Ab() {
        return this.aqZ;
    }

    public final e j(Throwable th) {
        this.aqZ = th;
        return bV(th.getLocalizedMessage());
    }

    public final boolean Ac() {
        ch(-1);
        this.are = null;
        int i = this.aqR + 1;
        this.aqR = i;
        return i <= this.aqS;
    }

    public final void ci(int i) {
        if (i > 0) {
            this.aqS = i;
        }
    }

    public final String Ad() {
        return this.aqj;
    }

    public final boolean Ae() {
        return this.aqW;
    }

    public final int Af() {
        return this.aqR;
    }

    public final String Ag() {
        if (!TextUtils.isEmpty(this.aqU)) {
            return this.aqU;
        }
        return this.aqV;
    }

    public final void bW(String str) {
        this.aqU = str;
    }

    public final void bX(String str) {
        this.aqV = str;
    }

    public final void c(P p) {
        this.aqX = p;
    }

    public final com.kwad.library.solder.lib.ext.b Ah() {
        return this.aqY;
    }

    public final void a(com.kwad.library.solder.lib.ext.b bVar) {
        this.aqY = bVar;
    }

    public final boolean Ai() {
        return this.arb;
    }

    public final String Aj() {
        return this.ara;
    }

    public final String Ak() {
        return this.ard;
    }

    public final String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public final com.kwad.library.solder.lib.c.b Al() {
        return this.arf;
    }

    public final List<com.kwad.library.solder.lib.c.a> Am() {
        String strAd = Ad();
        if (!TextUtils.isEmpty(strAd) && this.are == null) {
            this.are = b(strAd, getVersion(), Ak());
        }
        return this.are;
    }

    private List<com.kwad.library.solder.lib.c.a> b(String str, String str2, String str3) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(this.aqz.zP().bO(str));
            if (file.exists() && (list = file.list()) != null && list.length != 0) {
                for (String str4 : list) {
                    if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2) && str2.equals(str4)) {
                        if (this.aqz.zP().a(str, str4, str3)) {
                            com.kwad.library.solder.lib.c.a aVar = new com.kwad.library.solder.lib.c.a();
                            aVar.arx = str;
                            aVar.version = str4;
                            aVar.tq = true;
                            arrayList.add(aVar);
                        } else {
                            this.aqz.zP().E(str, str4);
                        }
                    } else {
                        this.aqz.zP().E(str, str4);
                    }
                }
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public String toString() {
        return "PluginRequest{mId='" + this.aqj + "'}";
    }
}
