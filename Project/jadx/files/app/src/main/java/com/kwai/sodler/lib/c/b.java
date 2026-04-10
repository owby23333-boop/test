package com.kwai.sodler.lib.c;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Comparable<b> {
    public boolean It;
    public long aJA;
    public String aJB;
    public boolean aJC = false;
    public boolean aJD = true;
    public HashMap<String, String> aJE = new HashMap<>(10);
    public List<String> aJF;
    public List<String> aJG;
    public ClassLoader aJH;
    public String aJg;
    public boolean aJh;
    public String aJy;
    public String aJz;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull b bVar) {
        return -this.version.compareTo(bVar.version);
    }

    public final String toString() {
        return "RemotePluginInfo{pluginId='" + this.aJy + "', version='" + this.version + "', downloadUrl='" + this.aJz + "', fileSize=" + this.aJA + ", enable=" + this.It + ", md5sum='" + this.aJB + "', onlyWifiDownload=" + this.aJC + ", onlyWifiRetryDownload=" + this.aJD + ", soMd5s=" + this.aJE + ", hostPackages=" + this.aJF + ", hostInterfaces=" + this.aJG + '}';
    }
}
