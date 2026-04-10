package com.amgcyo.cuttadon.utils.otherutils;

import com.amgcyo.cuttadon.api.entity.comic.SearchHotkeyBean;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchHotKeyComparator.java */
/* JADX INFO: loaded from: classes.dex */
public class j0 implements Comparator<SearchHotkeyBean> {
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(SearchHotkeyBean searchHotkeyBean, SearchHotkeyBean searchHotkeyBean2) {
        return Integer.compare(searchHotkeyBean2.getKeyWord().length(), searchHotkeyBean.getKeyWord().length());
    }
}
