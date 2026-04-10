package com.mibi.sdk.payment;

import android.content.Context;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeManager;

/* JADX INFO: loaded from: classes15.dex */
class ChannelManager {
    private static final String TAG = "ChannelManager";
    private static final String MIPAY_CHANNEL_ENTRY = "com.mibi.sdk.channel.mipay.MipayRecharge";
    private static final String ALIPAY_CHANNEL_ENTRY = "com.mibi.sdk.channel.alipay.AlipayRecharge";
    private static final String WXPAY_CHANNEL_ENTRY = "com.mibi.sdk.channel.wxpay.WXRecharge";
    private static final String UNIONPAY_CHANNEL_ENTRY = "com.mibi.sdk.channel.unionpay.UnionPayRecharge";
    private static final String UNIONMIPAY_CHANNEL_ENTRY = "com.mibi.sdk.channel.unionpay.UnionMiPayRecharge";
    private static final String[] ENTRYS = {MIPAY_CHANNEL_ENTRY, ALIPAY_CHANNEL_ENTRY, WXPAY_CHANNEL_ENTRY, UNIONPAY_CHANNEL_ENTRY, UNIONMIPAY_CHANNEL_ENTRY};

    public static void registerRechargeChannels(Context context) {
        for (String str : ENTRYS) {
            tryAddEntry(str);
        }
        tryInitUnionMiPay(context);
    }

    private static void tryAddEntry(String str) {
        try {
            RechargeManager.get().registRecharge((Recharge) Class.forName(str).newInstance());
            MibiLog.d(TAG, str + " is added to rechage manager");
        } catch (ClassNotFoundException unused) {
            MibiLog.e(TAG, str + " is not found");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    private static void tryInitUnionMiPay(Context context) {
        if (RechargeManager.get().getRecharge(Payment.PAY_CHANNEL_UNIONMIPAY) != null) {
            try {
                Class.forName("com.mibi.sdk.channel.unionpay.UnionPayUtil").getMethod("init", Context.class).invoke(null, context);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
