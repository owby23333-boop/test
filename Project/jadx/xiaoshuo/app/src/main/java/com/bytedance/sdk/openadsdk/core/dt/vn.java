package com.bytedance.sdk.openadsdk.core.dt;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes10.dex */
public class vn {
    private List<String> bf;
    private String e;

    public vn(Map<String, Object> map) {
        this.e = "";
        this.bf = new ArrayList();
        try {
            this.e = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.bf = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.bf.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> bf() {
        return this.bf;
    }

    public String e() {
        return this.e;
    }
}
