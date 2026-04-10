package com.bytedance.sdk.openadsdk.core.sy.dl;

import android.content.Context;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.ats.a;
import com.bytedance.sdk.openadsdk.core.sy.fo;
import com.bytedance.sdk.openadsdk.core.sy.g;
import com.bytedance.sdk.openadsdk.core.sy.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends uy implements g {
    private static volatile z z;
    private AtomicBoolean g = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String g() {
        return "network";
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.uy
    public JSONObject g(Context context) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.uy
    public void z(int i, fo foVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.uy
    public boolean z() {
        return true;
    }

    private z() {
    }

    public static z dl() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String z(String str) {
        return a.z(g()).get(a(), "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(String str, String str2) {
        a.z(g()).put(str, str2);
    }

    public static String a() {
        return "q_" + Calendar.getInstance().get(11) + (v.a(zw.getContext()) ? "w" : "c");
    }
}
