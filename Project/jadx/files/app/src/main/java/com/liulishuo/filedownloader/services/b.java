package com.liulishuo.filedownloader.services;

import com.liulishuo.filedownloader.h0.c;

/* JADX INFO: compiled from: DefaultIdGenerator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements c.d {
    @Override // com.liulishuo.filedownloader.h0.c.d
    public int a(int i2, String str, String str2, boolean z2) {
        return a(str, str2, z2);
    }

    @Override // com.liulishuo.filedownloader.h0.c.d
    public int a(String str, String str2, boolean z2) {
        return z2 ? com.liulishuo.filedownloader.h0.f.n(com.liulishuo.filedownloader.h0.f.a("%sp%s@dir", str, str2)).hashCode() : com.liulishuo.filedownloader.h0.f.n(com.liulishuo.filedownloader.h0.f.a("%sp%s", str, str2)).hashCode();
    }
}
