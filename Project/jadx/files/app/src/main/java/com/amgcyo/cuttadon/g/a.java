package com.amgcyo.cuttadon.g;

import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.ShelfCategory;

/* JADX INFO: compiled from: BookShelfClickListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    void moreClickListener(MkBook mkBook);

    void onItemCategoryClick(ShelfCategory shelfCategory);

    void onItemCategoryLongClick(ShelfCategory shelfCategory);

    void onItemClick(MkBook mkBook);
}
