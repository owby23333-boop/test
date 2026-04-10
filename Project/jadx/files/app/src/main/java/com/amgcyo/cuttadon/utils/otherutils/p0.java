package com.amgcyo.cuttadon.utils.otherutils;

import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import java.util.Comparator;

/* JADX INFO: compiled from: SortComparator.java */
/* JADX INFO: loaded from: classes.dex */
public class p0 implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((MkAreaCodeBean) obj).getWord().compareTo(((MkAreaCodeBean) obj2).getWord());
    }
}
