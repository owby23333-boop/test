package com.duokan.reader.domain.store;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class DkStoreBookInfo extends DkStoreAbsBookInfo {
    public static final String PLATFORM = "Android";
    public int mSource = 1;
    public String mSourceId = null;
    public String[] mAuthorIds = new String[0];
    public String[] mEditors = new String[0];
    public String mDescription = null;
    public int mPrice = 0;
    public int mNewPrice = 0;
    public Date mExpirationDate = null;
    public int mWeight = 0;
    public boolean mHasChangeLog = false;
    public float mAverageScore = 0.0f;
    public int mScoreCount = 0;
    public int mCommentCount = -1;
    public String mExpandInfo = null;
    public boolean mAndroidPlatformValid = true;
    public long mLimitedTime = 0;
    public String mRevision = null;
    public long mTime = 0;
    public boolean mIsVipFree = false;
}
