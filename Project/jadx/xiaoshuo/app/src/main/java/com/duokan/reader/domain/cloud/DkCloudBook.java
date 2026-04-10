package com.duokan.reader.domain.cloud;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudBook extends DkCloudJsonItem {
    private String mBookName;
    private DkCloudBookFormat mBookType;
    private final String mBookUuid;

    public enum DkCloudBookFormat implements Serializable {
        TXT,
        EPUB
    }

    public DkCloudBook(String str) {
        super(0L);
        this.mBookName = null;
        this.mBookType = null;
        this.mBookUuid = str;
    }

    public DkCloudBookFormat getBookType() {
        return this.mBookType;
    }

    public String getBookUuid() {
        return this.mBookUuid;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public String getCloudId() {
        return this.mBookUuid;
    }

    public String getTitle() {
        return this.mBookName;
    }

    @Override // com.duokan.reader.domain.cloud.DkCloudItem
    public DkCloudItem merge(DkCloudItem dkCloudItem) {
        return null;
    }

    public void setBookType(DkCloudBookFormat dkCloudBookFormat) {
        this.mBookType = dkCloudBookFormat;
    }

    public void setTitle(String str) {
        this.mBookName = str;
    }

    public DkCloudBook(DkCloudBook dkCloudBook) {
        super(dkCloudBook);
        this.mBookName = null;
        this.mBookType = null;
        this.mBookUuid = dkCloudBook.mBookUuid;
        this.mBookName = dkCloudBook.mBookName;
        this.mBookType = dkCloudBook.mBookType;
    }
}
