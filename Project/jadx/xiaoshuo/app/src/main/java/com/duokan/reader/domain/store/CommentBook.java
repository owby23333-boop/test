package com.duokan.reader.domain.store;

/* JADX INFO: loaded from: classes3.dex */
public class CommentBook extends DkStoreAbsBook {
    private int mRate;
    private String mTag;

    public CommentBook(DkStoreAbsBookInfo dkStoreAbsBookInfo) {
        super(dkStoreAbsBookInfo);
        this.mRate = 0;
        this.mTag = "";
    }

    public int getBookRate() {
        return this.mRate;
    }

    public String getTag() {
        return this.mTag;
    }

    public void setBookRate(int i) {
        this.mRate = i;
    }

    public void setTag(String str) {
        this.mTag = str;
    }
}
