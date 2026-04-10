package com.duokan.reader.domain.store;

import android.text.TextUtils;
import com.mibi.sdk.component.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DkFictionChapterDiscountInfo extends DkStoreItemInfo {
    public String mChapterId;
    public int mDiscount;
    public long mEndTime;
    public int mOldPrice;
    public int mPrice;
    public long mStartTime;

    public DkFictionChapterDiscountInfo(JSONObject jSONObject) {
        this.mChapterId = null;
        this.mPrice = 0;
        this.mOldPrice = 0;
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mDiscount = 0;
        if (TextUtils.isEmpty(jSONObject.toString())) {
            return;
        }
        try {
            this.mChapterId = jSONObject.optString("chapter_id");
            this.mPrice = jSONObject.optInt("price");
            this.mOldPrice = jSONObject.optInt("old_price");
            this.mStartTime = jSONObject.optLong("created");
            this.mEndTime = jSONObject.optLong("expired");
            this.mDiscount = jSONObject.optInt(Constants.KEY_RECHARGE_DISCOUNT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("chapter_id", this.mChapterId);
            jSONObject.put("price", this.mPrice);
            jSONObject.put("old_price", this.mOldPrice);
            jSONObject.put("created", this.mStartTime);
            jSONObject.put("expired", this.mEndTime);
            jSONObject.put(Constants.KEY_RECHARGE_DISCOUNT, this.mDiscount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
