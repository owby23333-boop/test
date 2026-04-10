package com.mibi.sdk.component.recharge;

import com.mibi.sdk.common.CommonConstants;
import com.mibi.sdk.common.exception.PaymentException;
import com.mibi.sdk.common.utils.MibiLog;
import com.mibi.sdk.component.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BaseRechargeMethodParser implements RechargeMethodParser {
    private static final String TAG = "BaseRechargeMhdParser";

    public abstract RechargeMethod newRechargeMethod();

    @Override // com.mibi.sdk.component.recharge.RechargeMethodParser
    public RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException {
        RechargeMethod rechargeMethodNewRechargeMethod = newRechargeMethod();
        rechargeMethodNewRechargeMethod.mChannel = jSONObject.getString("channel");
        rechargeMethodNewRechargeMethod.mTitle = jSONObject.getString("title");
        rechargeMethodNewRechargeMethod.mContentHint = jSONObject.optString(Constants.KEY_RECHARGE_CONTENT_HINT);
        rechargeMethodNewRechargeMethod.mDiscountDesc = jSONObject.optString(Constants.KEY_RECHARGE_DISCOUNT_DESC);
        rechargeMethodNewRechargeMethod.mDiscountRate = jSONObject.optDouble(Constants.KEY_RECHARGE_DISCOUNT, 1.0d);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(CommonConstants.KEY_ENTRY);
        if (jSONObjectOptJSONObject != null) {
            EntryData entryData = new EntryData();
            rechargeMethodNewRechargeMethod.mContentHintEntryData = entryData;
            try {
                entryData.parseEntryData(jSONObjectOptJSONObject);
            } catch (PaymentException e) {
                MibiLog.e(TAG, "BaseRechargeMethodParser PaymentException ", e);
            }
        }
        return rechargeMethodNewRechargeMethod;
    }
}
