package com.bytedance.sdk.openadsdk.core.sy.a;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.openadsdk.core.dl.a;
import com.bytedance.sdk.openadsdk.core.sy.fo;
import com.bytedance.sdk.openadsdk.core.sy.g;
import com.bytedance.sdk.openadsdk.core.sy.kb;
import com.bytedance.sdk.openadsdk.core.sy.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z extends uy implements g {
    private static volatile z g;
    private AtomicBoolean z = new AtomicBoolean(false);

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String g() {
        return MediationConstant.RIT_TYPE_SPLASH;
    }

    private z() {
    }

    public static z dl() {
        if (g == null) {
            synchronized (z.class) {
                if (g == null) {
                    g = new z();
                }
            }
        }
        return g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.uy
    public void z(int i, fo foVar) {
        if (com.bytedance.sdk.openadsdk.core.uy.ls().vm()) {
            try {
                Field[] declaredFields = foVar.dl().getClass().getDeclaredFields();
                for (int i2 = 0; i2 < declaredFields.length; i2++) {
                    declaredFields[i2].setAccessible(true);
                    declaredFields[i2].get(foVar.dl());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.uy
    public JSONObject g(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_name", "common");
            jSONObject.put("business_type", 2);
            jSONObject.put("general_params", new JSONObject());
        } catch (Exception e) {
            e.getMessage();
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.uy
    public boolean z() {
        return kb.dl();
    }

    public void a() {
        e.g(new com.bytedance.sdk.component.uy.fo("pity_splopt") { // from class: com.bytedance.sdk.openadsdk.core.sy.a.z.1
            @Override // java.lang.Runnable
            public void run() {
                z.this.m();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            AtomicBoolean atomicBoolean = this.z;
            if (atomicBoolean == null || atomicBoolean.getAndSet(true)) {
                return;
            }
            z(zw.getContext());
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public static void gc() {
        dl().a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            return a.z().iq();
        }
        return com.bytedance.sdk.openadsdk.ats.a.z(g()).get(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.sy.g
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("spl_load_strategy".equalsIgnoreCase(str)) {
            a.z().ls(str2);
        } else {
            com.bytedance.sdk.openadsdk.ats.a.z(g()).put(str, str2);
        }
    }
}
