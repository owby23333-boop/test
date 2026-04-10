package com.duokan.reader.domain.store;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.document.epub.EpubCharAnchor;
import com.duokan.reader.ui.general.ExpandableTextView;
import com.yuewen.oh0;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes3.dex */
public class DkCloudIdeaItemInfo extends DkStoreItemInfo {
    public String mIdeaId = "";
    public String mIdeaDataId = "";
    public EpubCharAnchor mStartAnchor = null;
    public EpubCharAnchor mEndAnchor = null;
    public long mModifyTime = 0;
    public User mUser = new User();
    public int mLikeCount = 0;
    public boolean mLiked = false;
    public String mRefContent = "";
    public String mIdeaContent = "";
    public int mCommentCount = 0;
    public String mProvince = "";
    public boolean mExpanded = false;
    public LinkedList<oh0> mIdeaComments = new LinkedList<>();
    private final ExpandableTextView.f ideaFoldStatus = new ExpandableTextView.f(true);

    public ExpandableTextView.f getIdeaFoldStatus() {
        return this.ideaFoldStatus;
    }
}
