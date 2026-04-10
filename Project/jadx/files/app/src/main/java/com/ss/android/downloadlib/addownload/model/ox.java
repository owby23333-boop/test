package com.ss.android.downloadlib.addownload.model;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    public String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18011h;
    public String hj;
    public String ko;
    public String lz;
    public long mb;
    public long ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f18012u;
    public final List<Pair<String, String>> ww = new ArrayList();

    public static long mb(long j2, long j3) {
        return j2 > 0 ? j2 : j3;
    }

    public long mb() {
        return mb(this.mb, this.ox);
    }
}
