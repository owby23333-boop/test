package com.ss.android.socialbase.downloader.vn;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class s {
    public static long bf(@NonNull List<zk> list) {
        long jD;
        long jTg;
        long j = 0;
        loop0: while (true) {
            jD = -1;
            jTg = -1;
            for (zk zkVar : list) {
                if (jD == -1) {
                    if (zkVar.e() > 0) {
                        jD = zkVar.d();
                        jTg = zkVar.tg();
                    }
                } else if (zkVar.d() > jTg) {
                    j += jTg - jD;
                    if (zkVar.e() > 0) {
                        jD = zkVar.d();
                        jTg = zkVar.tg();
                    }
                } else if (zkVar.tg() > jTg) {
                    jTg = zkVar.tg();
                }
            }
        }
        return (jD < 0 || jTg <= jD) ? j : j + (jTg - jD);
    }

    public static long e(@NonNull List<zk> list) {
        int size = list.size();
        long jGa = 0;
        for (int i = 0; i < size; i++) {
            zk zkVar = list.get(i);
            if (zkVar.d() > jGa) {
                break;
            }
            if (zkVar.ga() > jGa) {
                jGa = zkVar.ga();
            }
        }
        return jGa;
    }
}
