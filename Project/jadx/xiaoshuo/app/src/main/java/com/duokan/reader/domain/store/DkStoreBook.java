package com.duokan.reader.domain.store;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreBook extends DkStoreAbsBook {
    protected final DkStoreBookInfo mBookInfo;

    public DkStoreBook(DkStoreBookInfo dkStoreBookInfo) {
        super(dkStoreBookInfo);
        this.mBookInfo = dkStoreBookInfo;
    }

    public String[] getAuthorIds() {
        return this.mBookInfo.mAuthorIds;
    }

    public String getAuthorLine() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mBookInfo.mAuthors) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public String[] getAuthors() {
        return this.mBookInfo.mAuthors;
    }

    public float getAverageScore() {
        return this.mBookInfo.mAverageScore;
    }

    public int getCommentCount() {
        return this.mBookInfo.mCommentCount;
    }

    public String getEditorLine() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.mBookInfo.mEditors) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public String[] getEditors() {
        return this.mBookInfo.mEditors;
    }

    public String getExpandInfo() {
        return this.mBookInfo.mExpandInfo;
    }

    public Date getExpirationDate() {
        return this.mBookInfo.mExpirationDate;
    }

    public long getLimitedTime() {
        return this.mBookInfo.mLimitedTime;
    }

    @Override // com.duokan.reader.domain.store.DkStoreAbsBook
    public String getNameLine() {
        String[] strArr = this.mBookInfo.mAuthors;
        return (strArr == null || strArr.length <= 0) ? getEditorLine() : getAuthorLine();
    }

    public int getNewPrice() {
        return this.mBookInfo.mNewPrice;
    }

    public int getPrice() {
        return this.mBookInfo.mPrice;
    }

    public int getScoreCount() {
        return this.mBookInfo.mScoreCount;
    }

    public int getSource() {
        return this.mBookInfo.mSource;
    }

    public String getSourceId() {
        return this.mBookInfo.mSourceId;
    }

    public long getTime() {
        return this.mBookInfo.mTime;
    }

    public int getWeight() {
        return this.mBookInfo.mWeight;
    }

    public boolean hasChangeLog() {
        return this.mBookInfo.mHasChangeLog;
    }

    public boolean isAndroidPlatformValid() {
        return this.mBookInfo.mAndroidPlatformValid;
    }

    public boolean isFree() {
        return getNewPrice() == 0;
    }

    public boolean isVipFree() {
        return this.mBookInfo.mIsVipFree;
    }
}
