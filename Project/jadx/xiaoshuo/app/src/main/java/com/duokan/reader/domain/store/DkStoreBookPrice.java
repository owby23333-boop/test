package com.duokan.reader.domain.store;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreBookPrice implements Serializable {
    public String mBookUuid = null;
    public String mBookTitle = null;
    public int mNewPrice = 0;
    public int mPrice = 0;

    public boolean equals(Object obj) {
        return obj instanceof DkStoreBookPrice ? this.mBookUuid.equals(((DkStoreBookPrice) obj).mBookUuid) : super.equals(obj);
    }
}
