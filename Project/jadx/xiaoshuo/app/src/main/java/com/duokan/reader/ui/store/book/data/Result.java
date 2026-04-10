package com.duokan.reader.ui.store.book.data;

import com.duokan.reader.ui.store.data.cms.Data;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Result<T extends Data> implements Serializable {
    public List<T> data;
    public T item;
    public List<T> items;
    public boolean more;
    public String msg;
    public int result;
    public int total;

    public boolean isSuccess() {
        return this.result == 0;
    }
}
