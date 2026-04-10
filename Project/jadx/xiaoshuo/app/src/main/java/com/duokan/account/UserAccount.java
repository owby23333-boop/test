package com.duokan.account;

import android.content.Context;
import android.text.TextUtils;
import com.duokan.account.MiAccount;
import com.yuewen.e3;
import com.yuewen.h84;
import com.yuewen.wq2;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public abstract class UserAccount extends a {
    public UserAccount(e3 e3Var) {
        super(e3Var);
    }

    public static Map<String, String> V(String str, String str2) {
        HashMap map = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            map.put("user_id", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            map.put("token", str2);
        }
        return map;
    }

    public abstract void R(Context context, String str, MiAccount.h hVar);

    public abstract void S();

    public wq2 T() {
        return null;
    }

    public abstract h84 U();

    public abstract void W();

    public void X(wq2 wq2Var) {
    }
}
