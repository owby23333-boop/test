package com.duokan.dkcategory.data.primary;

import com.duokan.dkcategory_export.data.CategoryTag;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class PrimaryTextTagBundle extends CategoryTag {
    public final List<PrimaryTextTag> d;

    public PrimaryTextTagBundle(List<PrimaryTextTag> items) {
        super(null, null);
        this.d = items;
    }

    public List<PrimaryTextTag> f() {
        return this.d;
    }
}
