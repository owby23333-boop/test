package com.kwad.library.solder.lib.c;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Comparable<a> {
    public String arx;
    public boolean tq;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
