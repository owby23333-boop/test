package com.liulishuo.filedownloader.d0;

import com.liulishuo.filedownloader.h0.c;

/* JADX INFO: compiled from: DefaultConnectionCountAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements c.a {
    @Override // com.liulishuo.filedownloader.h0.c.a
    public int a(int i2, String str, String str2, long j2) {
        if (j2 < 1048576) {
            return 1;
        }
        if (j2 < 5242880) {
            return 2;
        }
        if (j2 < 52428800) {
            return 3;
        }
        return j2 < 104857600 ? 4 : 5;
    }
}
