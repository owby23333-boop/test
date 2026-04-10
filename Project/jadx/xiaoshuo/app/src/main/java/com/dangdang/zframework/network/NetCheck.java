package com.dangdang.zframework.network;

import android.content.Context;
import com.dangdang.zframework.utils.NetUtil;

/* JADX INFO: loaded from: classes10.dex */
public class NetCheck {
    public static boolean checkMobile = true;
    public static boolean checkWifi = true;
    public static Context mContext;

    public static boolean checkNet() {
        Context context = mContext;
        if (context != null) {
            return NetUtil.isNetworkConnected(context);
        }
        return true;
    }

    public static void init(Context context) {
        if (mContext == null) {
            mContext = context;
        }
    }
}
