package com.kwai.filedownloader.services;

import com.kwai.filedownloader.e.c;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements c.d {
    @Override // com.kwai.filedownloader.e.c.d
    public final int j(String str, String str2, boolean z2) {
        return k(str, str2, z2);
    }

    @Override // com.kwai.filedownloader.e.c.d
    public final int k(String str, String str2, boolean z2) {
        return com.kwai.filedownloader.e.f.el(z2 ? com.kwai.filedownloader.e.f.j("%sp%s@dir", str, str2) : com.kwai.filedownloader.e.f.j("%sp%s", str, str2)).hashCode();
    }
}
