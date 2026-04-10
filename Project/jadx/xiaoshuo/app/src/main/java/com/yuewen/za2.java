package com.yuewen;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: classes3.dex */
public class za2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f20722a = 1000;

    public static String a(long j) {
        if (j < 10000) {
            return String.valueOf(j);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(j / 10000);
        long j2 = j % 10000;
        if (j2 > 0) {
            sb.append(Consts.DOT);
            long j3 = j2 / 1000;
            if (j3 > 0) {
                sb.append(j3);
            } else {
                sb.append("1");
            }
        }
        sb.append("万");
        return sb.toString();
    }
}
