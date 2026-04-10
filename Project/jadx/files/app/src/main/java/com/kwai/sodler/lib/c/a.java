package com.kwai.sodler.lib.c;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Comparable<a> {
    public String aJy;
    public boolean qX;
    public String version;

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull a aVar) {
        return aVar.version.compareTo(this.version);
    }
}
