package com.bytedance.sdk.openadsdk.core.component.reward;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdSlot;
import com.bytedance.sdk.openadsdk.core.a.cv;
import com.bytedance.sdk.openadsdk.core.a.dt;
import com.dangdang.reader.domain.GroupType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
class bf {
    private String e;

    public bf(String str) {
        this.e = TextUtils.isEmpty(str) ? "" : str;
    }

    private String bf() {
        return this.e + "_adslot_preload";
    }

    private String e() {
        return this.e + "_adslot";
    }

    private String p(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.e + "_cache_" + str;
    }

    public boolean d(String str) {
        try {
            return cv.e(p(str)).bf("has_played", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    public void ga(String str) {
        try {
            cv.e(p(str)).bf();
        } catch (Throwable unused) {
        }
    }

    public int tg(String str) {
        try {
            return cv.e(p(str)).bf("data_sdk_version", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public TTAdSlot vn(String str) {
        try {
            return dt.e(cv.e(e()).bf(str, (String) null));
        } catch (Throwable unused) {
            return null;
        }
    }

    public long bf(String str) {
        try {
            return cv.e(p(str)).bf(GroupType.TypeColumn.CREATE_TIME, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public String e(String str) {
        try {
            return cv.e(p(str)).bf("material_data", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public void bf(TTAdSlot tTAdSlot) {
        if (tTAdSlot != null) {
            try {
                if (TextUtils.isEmpty(tTAdSlot.getCodeId())) {
                    return;
                }
                cv.e(bf()).e("preload_data", dt.e(tTAdSlot).toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void e(String str, String str2) {
        try {
            com.bytedance.sdk.component.vn.e eVarE = cv.e(p(str));
            eVarE.e("has_played", false);
            eVarE.e(GroupType.TypeColumn.CREATE_TIME, System.currentTimeMillis());
            eVarE.e("material_data", str2);
            eVarE.e("data_sdk_version", 5438);
        } catch (Throwable unused) {
        }
    }

    public void e(TTAdSlot tTAdSlot) {
        if (tTAdSlot != null) {
            try {
                if (TextUtils.isEmpty(tTAdSlot.getCodeId())) {
                    return;
                }
                cv.e(e()).e(tTAdSlot.getCodeId(), dt.e(tTAdSlot).toString());
            } catch (Throwable unused) {
            }
        }
    }

    public void e(TTAdSlot tTAdSlot, String str) {
        if (tTAdSlot != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                JSONObject jSONObjectE = dt.e(tTAdSlot);
                jSONObjectE.put(dt.tg, str);
                cv.e(e()).e(str, jSONObjectE.toString());
            } catch (Throwable unused) {
            }
        }
    }

    public TTAdSlot e(boolean z) {
        try {
            com.bytedance.sdk.component.vn.e eVarE = cv.e(bf());
            String strBf = eVarE.bf("preload_data", (String) null);
            if (z) {
                eVarE.bf();
            }
            return dt.e(strBf);
        } catch (Throwable unused) {
            return null;
        }
    }
}
