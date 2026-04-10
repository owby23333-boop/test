package com.duokan.reader.domain.store;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreFictionChapterInfo extends DkStoreItemInfo {
    public long mChapterUpdateTime;
    public long mDuration;
    public boolean mFree;
    public String mOuterId;
    public String mChapterId = null;
    public String mTitle = null;
    public String mSha1 = "";
    public String mUrl = "";
    public int mPrice = 0;
    public int mBasePrice = 0;
    public Date mUpdatedDate = new Date();
    public long mWordCount = 0;
    public boolean mVisible = true;
    public int mSize = 0;
}
