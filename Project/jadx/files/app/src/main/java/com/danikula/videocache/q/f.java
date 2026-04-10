package com.danikula.videocache.q;

import android.text.TextUtils;
import com.danikula.videocache.m;

/* JADX INFO: compiled from: Md5FileNameGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements c {
    private String a(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return (iLastIndexOf == -1 || iLastIndexOf <= str.lastIndexOf(47) || (iLastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(iLastIndexOf + 1, str.length());
    }

    @Override // com.danikula.videocache.q.c
    public String generate(String str) {
        String strA = a(str);
        String strA2 = m.a(str);
        if (TextUtils.isEmpty(strA)) {
            return strA2;
        }
        return strA2 + "." + strA;
    }
}
