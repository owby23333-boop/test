package com.mibi.sdk.component.recharge;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes13.dex */
public class RechargeManager {
    private static final RechargeManager sInstance = new RechargeManager();
    private ArrayList<Recharge> mRecharges = new ArrayList<>();
    private HashMap<String, Recharge> mRechargeMap = new HashMap<>();

    private RechargeManager() {
    }

    public static RechargeManager get() {
        return sInstance;
    }

    public String getChannels(Context context) {
        StringBuilder sb = new StringBuilder();
        for (Recharge recharge : this.mRecharges) {
            if (recharge.available(context)) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(recharge.getChannel());
            }
        }
        return sb.toString();
    }

    public Recharge getRecharge(String str) {
        return this.mRechargeMap.get(str);
    }

    public void registRecharge(Recharge recharge) {
        if (this.mRechargeMap.get(recharge.getChannel()) != null) {
            return;
        }
        this.mRecharges.add(recharge);
        this.mRechargeMap.put(recharge.getChannel(), recharge);
    }

    public void removeRecharge(String str) {
        Recharge rechargeRemove;
        if (!this.mRechargeMap.containsKey(str) || (rechargeRemove = this.mRechargeMap.remove(str)) == null) {
            return;
        }
        this.mRecharges.remove(rechargeRemove);
    }
}
