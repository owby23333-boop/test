package com.xiaomi.ad.mediation;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MMAdBaseAdapter {
    public static final String TAG = "MMAdBaseAdapter";
    public String mAppId;
    public Context mContext;

    public MMAdBaseAdapter(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.mAppId = str;
    }

    public abstract String getDspName();
}
