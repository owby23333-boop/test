package com.ss.android.socialbase.downloader.kb;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class pf {
    public static long z(List<fo> list) {
        int size = list.size();
        long jGc = 0;
        for (int i = 0; i < size; i++) {
            fo foVar = list.get(i);
            if (foVar.dl() > jGc) {
                break;
            }
            if (foVar.gc() > jGc) {
                jGc = foVar.gc();
            }
        }
        return jGc;
    }

    public static long g(List<fo> list) {
        long jDl;
        long jA;
        long j = 0;
        loop0: while (true) {
            jDl = -1;
            jA = -1;
            for (fo foVar : list) {
                if (jDl == -1) {
                    if (foVar.z() > 0) {
                        jDl = foVar.dl();
                        jA = foVar.a();
                    }
                } else if (foVar.dl() > jA) {
                    j += jA - jDl;
                    if (foVar.z() > 0) {
                        jDl = foVar.dl();
                        jA = foVar.a();
                    }
                } else if (foVar.a() > jA) {
                    jA = foVar.a();
                }
            }
        }
        return (jDl < 0 || jA <= jDl) ? j : j + (jA - jDl);
    }
}
