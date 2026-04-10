package com.bytedance.sdk.openadsdk.core.fo.z.z.z;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bytedance.sdk.openadsdk.core.fo.z.z.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1062a;
    private Context dl;
    private View e;
    private na g;
    private String gc;
    private Map<String, Object> gz;
    private int m;
    private com.bytedance.sdk.openadsdk.core.fo.z.z.z z;

    public static boolean z(int i) {
        switch (i) {
            case 101:
            case 102:
            case 103:
            case 104:
                return true;
            default:
                return false;
        }
    }

    public m(na naVar, Context context, String str, String str2) {
        this.g = naVar;
        this.dl = context;
        this.f1062a = str;
        this.gc = str2;
        g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.fo.z.z.z
    public boolean z(Map<String, Object> map) {
        boolean z = z();
        g();
        if (z) {
            return true;
        }
        HashMap map2 = new HashMap(2);
        map2.put("event_tag", this.f1062a);
        if (!TextUtils.isEmpty(this.gc)) {
            map2.put("dpa_tag", this.gc);
        }
        if ((com.bytedance.sdk.openadsdk.core.live.g.z().z(this.dl, this.g, map2) & 255) == 0) {
            return true;
        }
        com.bytedance.sdk.openadsdk.core.fo.z.z.z zVar = this.z;
        return zVar != null && zVar.z(map);
    }

    private boolean z() {
        if (this.m < 2) {
            return false;
        }
        HashMap map = new HashMap(2);
        if (z(this.m)) {
            map.put("live_saas_param_interaction_type", Integer.valueOf(this.m));
        }
        map.put("event_tag", this.f1062a);
        String str = this.gc;
        if (str != null) {
            map.put("dpa_tag", str);
        }
        if (this.gz == null) {
            this.gz = new HashMap();
        }
        com.bytedance.sdk.openadsdk.core.live.g.z().z(this.e, this.g.mg(), map, this.gz);
        int iZ = com.bytedance.sdk.openadsdk.core.live.g.z().z(this.dl, this.g, map);
        int i = iZ & 255;
        int i2 = (iZ & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
        if (i2 > 0) {
            this.gz.put("click_saas_action", Integer.valueOf(i2));
        }
        return i == 0;
    }

    public void g(Map<String, Object> map) {
        this.gz = map;
    }

    private void g() {
        na naVar = this.g;
        if (naVar != null) {
            this.m = naVar.wm();
        } else {
            this.m = -1;
        }
    }

    public void g(int i) {
        this.m = i;
    }

    public void z(View view) {
        this.e = view;
    }
}
