package com.xiaomi.ad;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.ad.common.util.HashUtils;
import com.xiaomi.ad.common.util.MLog;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public class q {
    public static final String TAG = "BaseAdManager";
    public Context mContext;
    public String mTagId;
    public String mTriggerId;

    public q(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mTagId = str.trim();
        }
        this.mContext = context.getApplicationContext();
        this.mTriggerId = generateTriggerId();
    }

    public String generateTriggerId() {
        Random random = new Random(System.nanoTime());
        try {
            return HashUtils.getMd5(UUID.randomUUID().toString() + ":" + random.nextLong());
        } catch (Exception e) {
            MLog.e(TAG, "Failed to create trigger id", e);
            return HashUtils.getMd5(Long.toString(random.nextLong()));
        }
    }

    public void onCreate() {
        MLog.d(TAG, "Start track action: PAGE_VIEW");
    }
}
