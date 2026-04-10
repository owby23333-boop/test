package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private List<String> g;
    private String z;

    public e(Map<String, Object> map) {
        this.z = "";
        this.g = new ArrayList();
        try {
            this.z = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.g = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.g.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    public String z() {
        return this.z;
    }

    public List<String> g() {
        return this.g;
    }
}
