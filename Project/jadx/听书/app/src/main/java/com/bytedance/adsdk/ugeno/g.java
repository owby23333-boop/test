package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.swiper.Swiper;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class g extends com.bytedance.adsdk.ugeno.g.z<Swiper> {
    private float bw;
    private float cb;
    private com.bytedance.adsdk.ugeno.g.dl dh;
    private boolean dt;
    private JSONArray gy;
    private boolean k;
    private float o;
    private float te;
    private String wo;
    private boolean wx;
    private int xf;
    private int xo;
    private String yt;
    private float zb;
    private float zd;

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(JSONObject jSONObject) {
    }

    public g(Context context) {
        super(context);
        this.k = true;
        this.wx = true;
        this.cb = 0.0f;
        this.o = 2000.0f;
        this.yt = "normal";
        this.dt = true;
        this.xo = Color.parseColor("#666666");
        this.xf = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public View z() {
        this.gc = new Swiper(this.g);
        ((Swiper) this.gc).z((dl) this);
        return this.gc;
    }

    @Override // com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        JSONArray jSONArray = this.gy;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((Swiper) this.gc).a((int) this.zb).gc((int) this.zd).m((int) this.te).dl(this.dt).g(this.xf).dl(this.xo).g(this.yt).a(this.k).z(this.bw).z(this.wx).z((int) this.o).dl(this.dt);
        for (int i = 0; i < this.gy.length(); i++) {
            pf pfVar = new pf(this.g);
            pfVar.z(this.u);
            com.bytedance.adsdk.ugeno.g.dl<View> dlVarG = pfVar.g(this.dh.l(), null);
            pfVar.g(this.gy.optJSONObject(i));
            ((Swiper) this.gc).z(dlVarG);
        }
        if (this.wx) {
            ((Swiper) this.gc).g();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        this.dh = dlVar;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "delayStart":
                this.cb = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case "indicatorColor":
                this.xo = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "nextMargin":
                this.te = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case "effect":
                this.yt = str2;
                break;
            case "direction":
                this.wo = str2;
                break;
            case "indicator":
                this.dt = com.bytedance.adsdk.ugeno.m.dl.z(str2, true);
                break;
            case "previousMargin":
                this.zd = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case "loop":
                this.k = com.bytedance.adsdk.ugeno.m.dl.z(str2, true);
                break;
            case "speed":
                this.o = com.bytedance.adsdk.ugeno.m.dl.z(str2, 500.0f);
                break;
            case "pageCount":
                this.bw = com.bytedance.adsdk.ugeno.m.dl.z(str2, 1.0f);
                break;
            case "pageMargin":
                this.zb = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case "indicatorSelectedColor":
                this.xf = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case "autoplay":
                this.wx = com.bytedance.adsdk.ugeno.m.dl.z(str2, true);
                break;
            case "dataList":
                this.gy = com.bytedance.adsdk.ugeno.m.g.z(str2, (JSONArray) null);
                break;
        }
    }
}
