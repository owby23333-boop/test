package com.yuewen;

import fm.qingting.qtsdk.entity.UserToken;

/* JADX INFO: loaded from: classes2.dex */
public class yq2 {
    public static UserToken a(wq2 wq2Var) {
        UserToken userToken = new UserToken();
        userToken.setAccessToken(wq2Var.f19586a);
        userToken.setRefreshToken(wq2Var.f19587b);
        userToken.setExpiresIn(Integer.valueOf(wq2Var.d));
        userToken.setUserId(wq2Var.c);
        return userToken;
    }
}
