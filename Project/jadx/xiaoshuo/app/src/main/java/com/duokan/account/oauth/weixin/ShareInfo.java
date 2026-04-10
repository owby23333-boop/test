package com.duokan.account.oauth.weixin;

import android.graphics.Bitmap;
import com.duokan.login.ShareType;
import com.yuewen.rm3;

/* JADX INFO: loaded from: classes10.dex */
public class ShareInfo {
    private String mPlatform;
    private String mTitle = "";
    private String mDescription = "";
    private String mUrl = "";
    private String mPicUrl = "";
    private String mAppletUrl = "";
    private String mAppletPicUrl = "";
    private String mImageData = "";
    private String[] mTraceIds = new String[0];
    private Bitmap mBitmap = null;
    private boolean mIsAudioBook = false;
    private boolean mShareLink = false;
    private boolean mToFriends = false;
    private boolean mNeedChangeId = false;
    private String[] mBooksId = new String[0];
    private boolean mShareToMiniProgram = false;
    private rm3 mCallBack = null;
    private ShareType mShareType = ShareType.NORMAL;

    public String getAppletPicUrl() {
        return this.mAppletPicUrl;
    }

    public String getAppletUrl() {
        return this.mAppletUrl;
    }

    public Bitmap getBitmap() {
        return this.mBitmap;
    }

    public String[] getBooksId() {
        return this.mBooksId;
    }

    public rm3 getCallBack() {
        return this.mCallBack;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getImageData() {
        return this.mImageData;
    }

    public String getPicUrl() {
        return this.mPicUrl;
    }

    public String getPlatform() {
        return this.mPlatform;
    }

    public ShareType getShareType() {
        return this.mShareType;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String[] getTraceIds() {
        return this.mTraceIds;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public boolean isAudioBook() {
        return this.mIsAudioBook;
    }

    public boolean isNeedChangeId() {
        return this.mNeedChangeId;
    }

    public boolean isShareLink() {
        return this.mShareLink;
    }

    public boolean isShareToMiniProgram() {
        return this.mShareToMiniProgram;
    }

    public boolean isToFriends() {
        return this.mToFriends;
    }

    public void setAppletPicUrl(String str) {
        this.mAppletPicUrl = str;
    }

    public void setAppletUrl(String str) {
        this.mAppletUrl = str;
    }

    public void setAudioBook(boolean z) {
        this.mIsAudioBook = z;
    }

    public void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    public void setBooksId(String[] strArr) {
        this.mBooksId = strArr;
    }

    public void setCallBack(rm3 rm3Var) {
        this.mCallBack = rm3Var;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setImageData(String str) {
        this.mImageData = str;
    }

    public void setNeedChangeId(boolean z) {
        this.mNeedChangeId = z;
    }

    public void setPicUrl(String str) {
        this.mPicUrl = str;
    }

    public void setPlatform(String str) {
        this.mPlatform = str;
    }

    public void setShareLink(boolean z) {
        this.mShareLink = z;
    }

    public void setShareToMiniProgram(boolean z) {
        this.mShareToMiniProgram = z;
    }

    public void setShareType(ShareType shareType) {
        this.mShareType = shareType;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setToFriends(boolean z) {
        this.mToFriends = z;
    }

    public void setTraceIds(String[] strArr) {
        this.mTraceIds = strArr;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }
}
