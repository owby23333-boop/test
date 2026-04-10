package com.duokan.dkcategory.data.primary;

import com.duokan.dkcategory_export.data.CategoryTag;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class PrimaryListCoverTagBundle extends CategoryTag {
    public final List<PrimaryCoverTag> d;

    public PrimaryListCoverTagBundle(List<PrimaryCoverTag> items) {
        super(null, null);
        this.d = items;
    }

    public List<PrimaryCoverTag> f() {
        return this.d;
    }
}
