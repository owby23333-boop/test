package com.bytedance.adsdk.ugeno.z.z;

import android.animation.PropertyValuesHolder;
import android.graphics.Canvas;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    private String dl;
    protected com.bytedance.adsdk.ugeno.g.dl g;
    protected JSONObject z;

    public abstract List<PropertyValuesHolder> dl();

    public abstract void g();

    public abstract void z(int i, int i2);

    public abstract void z(Canvas canvas);

    public z(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
        this.z = jSONObject;
        this.g = dlVar;
        z();
    }

    public void z() {
        this.dl = this.z.optString("type");
        g();
    }

    public String a() {
        return this.dl;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.z.z.z$z, reason: collision with other inner class name */
    public static class C0054z {
        public static z z(com.bytedance.adsdk.ugeno.g.dl dlVar, JSONObject jSONObject) {
            if (dlVar == null || jSONObject == null) {
                return null;
            }
            String strOptString = jSONObject.optString("type");
            strOptString.hashCode();
            switch (strOptString) {
                case "stretch":
                    return new gc(dlVar, jSONObject);
                case "ripple":
                    return new g(dlVar, jSONObject);
                case "rub_in":
                    return new dl(dlVar, jSONObject);
                case "shine":
                    return new a(dlVar, jSONObject);
                default:
                    return null;
            }
        }
    }
}
