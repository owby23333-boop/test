package com.duokan.reader.domain.store;

import com.duokan.reader.domain.document.epub.EpubCharAnchor;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudIdeaInfo extends DkStoreItemInfo {
    public String mIdeaId = "";
    public String mIdeaDataId = "";
    public EpubCharAnchor mStartAnchor = null;
    public EpubCharAnchor mEndAnchor = null;
    public long mCreateTime = 0;
    public long mModifyTime = 0;
    public String mSample = "";
    public String mNoteText = "";
    public boolean mIsPublic = false;
}
