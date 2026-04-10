package com.duokan.reader.domain.store;

import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreFictionInfo extends DkStoreAbsBookInfo {
    public List<String> dkfreeNewTags;
    public boolean mAnonymousTrial;
    public int mChargeChapterBeginId;
    public String mListenerCount;
    public String mPlayCount;
    public double mQmssScore;
    public int mReadNum;
    public String mSpeaker;
    public String[] mAuthorIds = new String[0];
    public String mRights = null;
    public int mRightId = 0;
    public String mDescription = null;
    public Date mUpdated = new Date();
    public String mLatest = null;
    public String mLatestId = null;
    public int mChapterCount = 0;
    public long mWordCount = 0;
    public boolean mFinish = false;
    public boolean mOnSale = true;
    public String mTypeId = "";
    public int mPageLevel = 0;
    public int mPrice = 0;
    public float mSpecial = -1.0f;
    public boolean mHasAds = false;
    public int mAdTime = -1;
    public boolean mIsVipFree = false;
    public boolean mIsVipDiscount = false;
    public int mClick = 0;
    public int mRiseCount = 0;
    public int mEncrypt = 1;
    public DkStoreFictionCategoryInfo[] mCategories = new DkStoreFictionCategoryInfo[0];
    public int mAllowDiscount = 0;
    public String mRecExtra = "";
}
