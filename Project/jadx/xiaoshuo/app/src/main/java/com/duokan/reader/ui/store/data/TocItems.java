package com.duokan.reader.ui.store.data;

import com.duokan.reader.ui.store.data.FictionDetailItem;
import com.duokan.reader.ui.store.data.cms.Data;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TocItems extends Data {
    private List<FictionDetailItem.TocItem> toc;

    public List<FictionDetailItem.TocItem> getData() {
        return this.toc;
    }

    public void setData(List<FictionDetailItem.TocItem> list) {
        this.toc = list;
    }
}
