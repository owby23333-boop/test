package com.bytedance.sdk.openadsdk.core.ugeno.fo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.ugeno.e.gc;
import com.bytedance.sdk.openadsdk.core.ugeno.uy;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.openadsdk.core.ugeno.e.z implements l.z {
    private boolean hh;
    private final Handler io;
    private com.bytedance.sdk.openadsdk.core.ugeno.component.video.g iq;
    private AtomicBoolean l;
    private long sy;
    private com.bytedance.sdk.openadsdk.core.js.dl uf;
    private boolean zw;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void a(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int dl() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void dl(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void e() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void fo() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int g() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void g(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gc() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void uy() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long z() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(boolean z) {
    }

    public g(Context context, ViewGroup viewGroup, m mVar, na naVar, String str, int i) {
        super(context, viewGroup, mVar, naVar, str, i);
        this.zw = false;
        this.io = new l(Looper.getMainLooper(), this);
        this.hh = true;
        this.l = new AtomicBoolean();
        this.sy = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.z
    public void i() {
        try {
            this.pf = uy.z(this.gc);
            JSONObject jSONObjectRw = this.gc.rw();
            this.uf = new com.bytedance.sdk.openadsdk.core.js.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fo.g.1
                @Override // com.bytedance.sdk.openadsdk.core.js.dl
                public void z(boolean z, List<na> list, boolean z2) {
                    if (!z) {
                        if (g.this.q.get() <= 0) {
                            g.this.f1349a.z(-3, "ad meta info load fail");
                            if (g.this.m != null) {
                                g.this.m.z(-3);
                                return;
                            }
                            return;
                        }
                        g.this.q.get();
                        g.this.q.decrementAndGet();
                        g.this.i();
                        return;
                    }
                    if (list == null || list.size() <= 0) {
                        if (g.this.q.get() <= 0) {
                            if (g.this.m != null) {
                                g.this.m.z(-2);
                                return;
                            }
                            return;
                        } else {
                            g.this.q.get();
                            g.this.q.decrementAndGet();
                            g.this.i();
                            return;
                        }
                    }
                    g.this.g(list);
                }
            };
            boolean z = false;
            if ((this.gc == null || this.gc.l() == null || this.gc.l().dl() == null || this.gc.l().dl().optInt("use_gnd_prefetch", 0) == 1) && com.bytedance.sdk.openadsdk.core.playable.g.z().z(this.gc, this.uf)) {
                z = true;
            }
            if (z) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.io.g.z(this.gc, jSONObjectRw, this.uf, this.gc.lw());
        } catch (Exception e) {
            if (this.q.get() <= 0) {
                this.f1349a.z(-3, e.getMessage());
                if (this.m != null) {
                    this.m.z(-3);
                    return;
                }
                return;
            }
            this.q.get();
            this.q.decrementAndGet();
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(List<na> list) {
        this.ls = list.size();
        this.p = list.size();
        this.fv = pf();
        na naVar = list.get(0);
        if (naVar != null) {
            this.v = naVar.rw();
        }
        this.fo = z(list);
        gc.z(this.z, new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fo.g.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.gc.z
            public void z(JSONObject jSONObject) {
                if (jSONObject == null) {
                    g.this.f1349a.z(-1, "template info load fail");
                    if (g.this.m != null) {
                        g.this.m.z(-1);
                        return;
                    }
                    return;
                }
                g gVar = g.this;
                gVar.z(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl>) gVar.fo);
            }
        });
    }

    public void dl(boolean z) {
        this.zw = z;
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = this.iq;
        if (gVar != null) {
            gVar.a(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.z
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> wp() {
        this.fo = new ArrayList();
        JSONObject jSONObjectKv = this.gc.kv();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", "android");
            jSONObjectKv.put("env_info", jSONObject);
        } catch (JSONException e) {
            wp.z(e);
        }
        this.fo.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl(jSONObjectKv, -2134548432));
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void z(int i, int i2) {
        if (i2 > 0) {
            this.uy.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void z(RecyclerView recyclerView, int i) {
        if (uy.g(this.gc)) {
            a(i);
        }
    }

    public void a(int i) {
        if (i == 0) {
            if (this.l.get()) {
                return;
            }
            this.io.sendEmptyMessageDelayed(10081, 5000L);
        } else {
            if (this.l.get()) {
                if (this.js != null) {
                    this.js.g();
                }
                this.l.set(false);
            }
            this.io.removeMessages(10081);
            this.io.removeMessages(10082);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl dlVar2) {
        if (dlVar2 == null || dlVar2.z() == null) {
            return;
        }
        int iHashCode = dlVar2.z().hashCode();
        if (this.kb.get(Integer.valueOf(iHashCode)) != null && this.kb.containsKey(Integer.valueOf(iHashCode)) && this.kb.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        z(dlVar2.z());
        if (i == this.fv) {
            z(dlVar);
        }
        this.kb.put(Integer.valueOf(iHashCode), Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("is_slide", 1);
        } catch (JSONException e) {
            wp.z(e);
        }
        if (this.uy.get() == 1) {
            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, this.wp, "ugeno_coin_eCommerce_is_slide", jSONObject);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void gc(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        JSONObject jSONObjectUy;
        if (dlVar == null || (jSONObjectUy = dlVar.uy()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.dl dlVarA = dlVar.a("video_".concat(String.valueOf(jSONObjectUy.optInt("image_mode"))));
        if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) dlVarA;
            this.iq = gVar;
            gVar.a(this.zw);
            this.iq.jq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void m(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        JSONObject jSONObjectUy;
        if (dlVar == null || (jSONObjectUy = dlVar.uy()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.dl dlVarA = dlVar.a("video_".concat(String.valueOf(jSONObjectUy.optInt("image_mode"))));
        if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) dlVarA).yx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.dl
    public void dl(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        na naVarZ;
        if (dlVar == null) {
            return;
        }
        if (dlVar.uy().has("ugen_sub_meta")) {
            naVarZ = com.bytedance.sdk.openadsdk.core.z.z(dlVar.uy().optJSONObject("ugen_sub_meta"));
        } else {
            naVarZ = com.bytedance.sdk.openadsdk.core.z.z(dlVar.uy());
        }
        if (naVarZ != null) {
            z(naVarZ, dlVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = this.iq;
        if (gVar == null) {
            wp.a("BasePageInflater", "onChangeVideoState,mVideoComponent is null !!!!!!!!!!!!");
        } else if (i == 2) {
            gVar.f();
        } else if (i == 3) {
            gVar.sv();
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        if (i == 10081) {
            if (this.js != null) {
                this.js.z();
                this.l.set(true);
                z(tb.z(this.g, "tt_ecomm_page_reward_slide_tip"));
                this.io.sendEmptyMessageDelayed(10082, 6000L);
                return;
            }
            return;
        }
        if (i != 10082) {
            return;
        }
        if (this.l.get()) {
            z(tb.z(this.g, "tt_ecomm_page_reward_slide_tip"));
            this.io.sendEmptyMessageDelayed(10082, 6000L);
        } else {
            this.io.removeMessages(10082);
        }
    }

    public void z(String str) {
        if (this.dl == null || !this.dl.isShown()) {
            return;
        }
        hh.g(this.g, str, 0, 49, 0, 60);
    }

    public void p() {
        ScrollView scrollView = new ScrollView(this.g);
        LinearLayout linearLayout = new LinearLayout(this.g);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(this.g);
        tb.z(this.g, "tt_ecomm_page_backup_img", imageView);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = oq.dl(this.g, 10.0f);
        layoutParams.leftMargin = oq.dl(this.g, 10.0f);
        layoutParams.rightMargin = oq.dl(this.g, 10.0f);
        linearLayout.addView(imageView, layoutParams);
        ImageView imageView2 = new ImageView(this.g);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        tb.z(this.g, "tt_ecomm_page_backup_img", imageView2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = oq.dl(this.g, 10.0f);
        layoutParams2.leftMargin = oq.dl(this.g, 10.0f);
        layoutParams2.rightMargin = oq.dl(this.g, 10.0f);
        linearLayout.addView(imageView2, layoutParams2);
        scrollView.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
        this.dl.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    public void fv() {
        js();
        if (this.hh) {
            this.hh = false;
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.START, this.sy);
                jSONObject.put(TtmlNode.END, System.currentTimeMillis());
            } catch (JSONException e) {
                wp.z(e);
            }
            com.bytedance.sdk.openadsdk.core.i.a.z(this.gc, "landingpage", "agg_stay_page", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fo.g.3
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject2) throws JSONException {
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            });
        }
    }

    public void js() {
        Handler handler = this.io;
        if (handler != null) {
            handler.removeMessages(10081);
            this.io.removeMessages(10082);
        }
    }

    public void tb() {
        this.io.removeMessages(10082);
    }

    public void q() {
        if (uy.g(this.gc)) {
            this.io.sendEmptyMessageDelayed(10081, 5000L);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.z
    public void ls() {
        super.ls();
        com.bytedance.sdk.openadsdk.core.playable.g.z().g(this.gc);
        js();
    }
}
