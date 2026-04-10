package com.umeng.analytics.pro;

import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bd;
import java.io.Serializable;

/* JADX INFO: compiled from: TBase.java */
/* JADX INFO: loaded from: classes4.dex */
public interface aw<T extends aw<?, ?>, F extends bd> extends Serializable {
    void clear();

    aw<T, F> deepCopy();

    F fieldForId(int i);

    void read(bv bvVar) throws bc;

    void write(bv bvVar) throws bc;
}
