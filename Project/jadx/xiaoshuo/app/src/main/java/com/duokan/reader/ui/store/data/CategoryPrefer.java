package com.duokan.reader.ui.store.data;

import com.alipay.sdk.m.y.l;
import com.duokan.reader.ui.store.data.cms.Data;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class CategoryPrefer extends Data {
    public int count;
    public List<Integer> items;
    public String msg;
    public int result;
    public String traceId;

    public boolean isSuccess() {
        return this.result == 0;
    }

    public String toString() {
        return "CategoryPrefer{count = '" + this.count + "',traceId = '" + this.traceId + "',items = '" + this.items + "',result = '" + this.result + "',msg = '" + this.msg + '\'' + l.d;
    }
}
