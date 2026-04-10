package com.mibi.sdk.channel.alipay;

import com.mibi.sdk.component.Constants;
import com.mibi.sdk.component.recharge.BaseRechargeMethodParser;
import com.mibi.sdk.component.recharge.RechargeMethod;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public class c extends BaseRechargeMethodParser {
    @Override // com.mibi.sdk.component.recharge.BaseRechargeMethodParser
    public RechargeMethod newRechargeMethod() {
        return new b();
    }

    @Override // com.mibi.sdk.component.recharge.BaseRechargeMethodParser, com.mibi.sdk.component.recharge.RechargeMethodParser
    public RechargeMethod parse(String str, JSONObject jSONObject) throws JSONException {
        b bVar = (b) super.parse(str, jSONObject);
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        bVar.mMinMoneyValue = jSONObject2.getLong(Constants.KEY_RECHARGE_MINVALUE);
        bVar.mMaxMoneyValue = jSONObject2.getLong(Constants.KEY_RECHARGE_MAXVALUE);
        bVar.mWarnValue = jSONObject2.optLong(Constants.KEY_RECHARGE_WARN_VALUE);
        JSONArray jSONArray = jSONObject2.getJSONArray(Constants.KEY_RECHARGE_VALUES);
        for (int i = 0; i < jSONArray.length(); i++) {
            bVar.mMoneyValues.add(Long.valueOf(jSONArray.getLong(i)));
        }
        bVar.mMinMibiValue = bVar.mMinMoneyValue;
        bVar.mMaxMibiValue = bVar.mMaxMoneyValue;
        bVar.mWarnMibiValue = bVar.mWarnValue;
        bVar.mMibiValues = bVar.mMoneyValues;
        return bVar;
    }
}
