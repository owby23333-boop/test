package com.mibi.sdk.channel.wxpay;

import com.mibi.sdk.component.Constants;
import com.mibi.sdk.component.recharge.BaseRechargeMethodParser;
import com.mibi.sdk.component.recharge.RechargeMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class e extends BaseRechargeMethodParser {
    @Override // com.mibi.sdk.component.recharge.BaseRechargeMethodParser
    public RechargeMethod newRechargeMethod() {
        return new d();
    }

    @Override // com.mibi.sdk.component.recharge.BaseRechargeMethodParser, com.mibi.sdk.component.recharge.RechargeMethodParser
    public RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException {
        d dVar = (d) super.parse(str, jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        dVar.mMinMoneyValue = jSONObject2.getLong(Constants.KEY_RECHARGE_MINVALUE);
        dVar.mMaxMoneyValue = jSONObject2.getLong(Constants.KEY_RECHARGE_MAXVALUE);
        dVar.mWarnValue = jSONObject2.optLong(Constants.KEY_RECHARGE_WARN_VALUE);
        JSONArray jSONArray = jSONObject2.getJSONArray(Constants.KEY_RECHARGE_VALUES);
        for (int i = 0; i < jSONArray.length(); i++) {
            dVar.mMoneyValues.add(Long.valueOf(jSONArray.getLong(i)));
        }
        dVar.mMinMibiValue = dVar.mMinMoneyValue;
        dVar.mMaxMibiValue = dVar.mMaxMoneyValue;
        dVar.mWarnMibiValue = dVar.mWarnValue;
        dVar.mMibiValues = dVar.mMoneyValues;
        return dVar;
    }
}
