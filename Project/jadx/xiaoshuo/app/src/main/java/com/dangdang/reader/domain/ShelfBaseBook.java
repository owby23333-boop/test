package com.dangdang.reader.domain;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class ShelfBaseBook extends BaseBook {
    private static final long serialVersionUID = 1;
    protected int isFull;
    protected int isHide;
    protected String mAuthorityId;
    protected String mBookJson;
    protected long mBooksize;
    protected String mBuyType;
    protected String mExpColumn1;
    protected String mExpColumn2;
    protected String mExpColumn3;
    protected GroupType mGroupType;
    protected long mId;
    protected String mUserId;
    protected String mUserName;

    public String bookJsonGet(String str) {
        try {
            return new JSONObject(this.mBookJson).optString(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void bookJsonPut(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = TextUtils.isEmpty(this.mBookJson) ? new JSONObject() : new JSONObject(this.mBookJson);
            jSONObject.put(str, str2);
            setBookJson(jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getAuthorityId() {
        return this.mAuthorityId;
    }

    public String getBookJson() {
        return this.mBookJson;
    }

    public long getBookSize() {
        return this.mBooksize;
    }

    public String getBuyType() {
        return this.mBuyType;
    }

    public String getExpColumn1() {
        return this.mExpColumn1;
    }

    public String getExpColumn2() {
        return this.mExpColumn2;
    }

    public String getExpColumn3() {
        return this.mExpColumn1;
    }

    public GroupType getGroupType() {
        return this.mGroupType;
    }

    public long getId() {
        return this.mId;
    }

    public int getIsFull() {
        return this.isFull;
    }

    public String getUserId() {
        String str = this.mUserId;
        return str == null ? "" : str;
    }

    public String getUserName() {
        String str = this.mUserName;
        return str == null ? "" : str;
    }

    public int isHide() {
        return this.isHide;
    }

    public void setAuthorityId(String str) {
        this.mAuthorityId = str;
    }

    public void setBookJson(String str) {
        this.mBookJson = str;
    }

    public void setBookSize(long j) {
        this.mBooksize = j;
    }

    public void setBuyType(String str) {
        this.mBuyType = str;
    }

    public void setExpColumn1(String str) {
        this.mExpColumn1 = str;
    }

    public void setExpColumn2(String str) {
        this.mExpColumn2 = str;
    }

    public void setExpColumn3(String str) {
        this.mExpColumn3 = str;
    }

    public void setGroupType(GroupType groupType) {
        this.mGroupType = groupType;
    }

    public void setHide(int i) {
        this.isHide = i;
    }

    public void setId(long j) {
        this.mId = j;
    }

    public void setIsFull(int i) {
        this.isFull = i;
    }

    public void setUserId(String str) {
        if (str == null) {
            str = "";
        }
        this.mUserId = str;
    }

    public void setUserName(String str) {
        if (str == null) {
            str = "";
        }
        this.mUserName = str;
    }
}
