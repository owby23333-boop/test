package com.duokan.reader.domain.store;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreAbsBook extends DkStoreItem {
    protected final DkStoreAbsBookInfo mAbsBookInfo;

    public DkStoreAbsBook(DkStoreAbsBookInfo dkStoreAbsBookInfo) {
        this.mAbsBookInfo = dkStoreAbsBookInfo;
    }

    public String getBookUuid() {
        return this.mAbsBookInfo.mBookUuid;
    }

    public String getCoverUri() {
        return this.mAbsBookInfo.mCoverUri;
    }

    public String getDescription() {
        return this.mAbsBookInfo.mSummary;
    }

    public String getNameLine() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mAbsBookInfo.mAuthors) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public String getTitle() {
        return this.mAbsBookInfo.mTitle;
    }

    public boolean supportTip() {
        return this.mAbsBookInfo.mSupportTip;
    }
}
