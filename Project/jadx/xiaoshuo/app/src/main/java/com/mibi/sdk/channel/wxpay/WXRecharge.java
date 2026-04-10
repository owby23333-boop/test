package com.mibi.sdk.channel.wxpay;

import android.content.Context;
import android.content.Intent;
import com.mibi.sdk.component.recharge.Recharge;
import com.mibi.sdk.component.recharge.RechargeMethodParser;

/* JADX INFO: loaded from: classes13.dex */
public class WXRecharge implements Recharge {
    public static final String CHANNEL = "WXPAY";

    @Override // com.mibi.sdk.component.recharge.Recharge
    public boolean available(Context context) {
        return true;
    }

    @Override // com.mibi.sdk.component.recharge.Recharge
    public String getChannel() {
        return "WXPAY";
    }

    @Override // com.mibi.sdk.component.recharge.Recharge
    public Intent getEntryIntent(boolean z) {
        return new Intent("com.mibi.sdk.action.WXPAY");
    }

    @Override // com.mibi.sdk.component.recharge.Recharge
    public RechargeMethodParser getParser() {
        return new e();
    }
}
