package com.duokan.reader.domain.store;

import com.duokan.reader.domain.account.User;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class FavBookListInfo implements Serializable {
    private static final long serialVersionUID = 1;
    public String mBookListId = "";
    public String mTitle = "";
    public String mCover = "";
    public String mSummary = "";
    public int mCommentCount = 0;
    public String mBookCover = "";
    public String mCreator = "";
    public String mCreatorPic = "";
    public String mCreatorName = "";
    public int mFavCount = 0;
    public long mFavTime = 0;
    public long mCreateTime = 0;
    public User mUser = new User();
}
