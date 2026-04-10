package com.duokan.reader.domain.account;

import android.text.TextUtils;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class User implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public String mIconUrl;
    public boolean mIsVip;
    public String mNickName;
    public String mUserId;

    public static void copy(User user, User user2) {
        user2.mUserId = user.mUserId;
        user2.mNickName = user.mNickName;
        user2.mIconUrl = user.mIconUrl;
        user2.mIsVip = user.mIsVip;
    }

    public static User valueOfMiUserCard(JSONObject jSONObject) {
        User user = new User();
        try {
            user.mUserId = jSONObject.optString("userId");
            String strOptString = jSONObject.optString("miliaoNick");
            if (TextUtils.isEmpty(strOptString)) {
                user.mNickName = user.mUserId;
            } else {
                user.mNickName = strOptString;
            }
            String strOptString2 = jSONObject.optString("miliaoIcon");
            user.mIconUrl = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                user.mIconUrl = user.mIconUrl.trim();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public String getAliasForDisplay() {
        return !TextUtils.isEmpty(this.mNickName) ? this.mNickName : this.mUserId;
    }

    public void updateUserInfo(User user) {
        if (user != null) {
            this.mNickName = user.mNickName;
            this.mIconUrl = user.mIconUrl;
        }
    }

    public void copy(User user) {
        this.mUserId = user.mUserId;
        this.mNickName = user.mNickName;
        this.mIconUrl = user.mIconUrl;
        this.mIsVip = user.mIsVip;
    }
}
