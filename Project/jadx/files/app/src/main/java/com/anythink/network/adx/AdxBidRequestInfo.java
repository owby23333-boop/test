package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.a.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdxBidRequestInfo extends ATBidRequestInfo {
    JSONObject a = new JSONObject();

    public AdxBidRequestInfo(Context context, String str) {
        try {
            this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.SUPPORT_TEMPLATE_VERSION, 1);
            d dVarB = e.a(context).b(str);
            if (dVarB != null) {
                int iAu = dVarB.au();
                if (iAu > 0) {
                    List<com.anythink.core.common.a.d> listA = b.a().a(iAu);
                    if (listA.size() > 0) {
                        this.a.put(d.a.P, a(listA));
                    }
                }
                int iAt = dVarB.at();
                if (iAt > 0) {
                    List<com.anythink.core.common.a.d> listB = b.a().b(iAt);
                    if (listB.size() > 0) {
                        this.a.put(d.a.O, a(listB));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    private static JSONObject a(List<com.anythink.core.common.a.d> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            HashMap map = new HashMap();
            for (com.anythink.core.common.a.d dVar : list) {
                List arrayList = (List) map.get(dVar.a());
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    map.put(dVar.a(), arrayList);
                }
                arrayList.add(dVar.b());
            }
            for (Map.Entry entry : map.entrySet()) {
                jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void fillAdAcceptType() {
        try {
            if (this.a != null) {
                this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY));
            }
        } catch (Throwable unused) {
        }
    }

    public void fillBannerData(Map<String, Object> map) {
        try {
            String string = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE).toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            String[] strArrSplit = string.split("x");
            int i2 = Integer.parseInt(strArrSplit[0]);
            int i3 = Integer.parseInt(strArrSplit[1]);
            this.a.put("ad_width", i2);
            this.a.put("ad_height", i3);
            this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.ADP_ACCEPT_TYPE, new JSONArray(ATAdConst.AD_SUPPORT_TYPE_ARRAY));
        } catch (Throwable unused) {
        }
    }

    public void fillInterstitial(Map<String, Object> map) {
        try {
            if (map.containsKey("unit_type")) {
                String stringFromMap = ATInitMediation.getStringFromMap(map, "unit_type");
                if (!TextUtils.isEmpty(stringFromMap)) {
                    this.a.put("unit_type", Integer.parseInt(stringFromMap));
                }
                if (TextUtils.equals(ATInitMediation.getStringFromMap(map, "inter_type", "1"), "1")) {
                    fillAdAcceptType();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void fillSplashData() {
        try {
            this.a.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.GET_OFFER, 2);
            fillAdAcceptType();
        } catch (Throwable unused) {
        }
    }

    @Override // com.anythink.core.api.ATBidRequestInfo
    public JSONObject toRequestJSONObject() {
        return this.a;
    }
}
