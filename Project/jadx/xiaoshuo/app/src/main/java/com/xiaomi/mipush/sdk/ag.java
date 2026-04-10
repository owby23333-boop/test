package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.k;
import com.xiaomi.push.bj;

/* JADX INFO: loaded from: classes8.dex */
public class ag {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        k.a aVarM182a = k.m182a(dVar);
        if (aVarM182a == null || TextUtils.isEmpty(aVarM182a.f7441a) || TextUtils.isEmpty(aVarM182a.f7442b)) {
            return null;
        }
        return (AbstractPushManager) bj.a(aVarM182a.f7441a, aVarM182a.f7442b, context);
    }
}
