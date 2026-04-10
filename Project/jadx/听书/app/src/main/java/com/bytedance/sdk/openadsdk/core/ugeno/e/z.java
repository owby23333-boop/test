package com.bytedance.sdk.openadsdk.core.ugeno.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.media3.common.C;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.g.z.g.dl;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.i;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.nativeexpress.uy;
import com.bytedance.sdk.openadsdk.core.p.z;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.e.gc;
import com.bytedance.sdk.openadsdk.core.ugeno.fo.dl;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.fv;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.un;
import com.bytedance.sdk.openadsdk.core.zw;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements uy, a, dl, gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.i.m f1349a;
    protected ViewGroup dl;
    protected com.bytedance.adsdk.ugeno.g.dl<View> e;
    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> fo;
    protected int fv;
    protected Context g;
    protected na gc;
    protected com.bytedance.adsdk.ugeno.g.dl<View> gz;
    protected Map<String, Object> i;
    private m io;
    protected g js;
    protected int ls;
    protected com.bytedance.sdk.openadsdk.core.ugeno.a.z m;
    protected int p;
    protected int pf;
    private boolean sy;
    protected InterfaceC0202z tb;
    private FrameLayout uf;
    protected JSONObject v;
    protected String wp;
    protected com.bytedance.sdk.openadsdk.core.ugeno.m.z z;
    private boolean iq = true;
    private boolean zw = true;
    protected AtomicInteger q = new AtomicInteger(2);
    protected AtomicInteger uy = new AtomicInteger();
    protected Map<Integer, Boolean> kb = new HashMap();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.e.z$z, reason: collision with other inner class name */
    public interface InterfaceC0202z {
        void z();
    }

    public abstract List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> wp();

    public z(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.i.m mVar, na naVar, String str, int i) {
        this.g = context;
        this.dl = viewGroup;
        this.f1349a = mVar;
        this.gc = naVar;
        this.wp = str;
        this.z = naVar.hh();
        m mVar2 = new m(this.g, this.f1349a, naVar, str, i);
        this.io = mVar2;
        mVar2.z((a) this);
        this.io.z((dl) this);
        if (this.gc.gm() != null) {
            this.io.z((gz) this);
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.a.z zVar) {
        this.m = zVar;
    }

    public void g(boolean z) {
        this.sy = z;
    }

    public void i() {
        try {
            this.fo = wp();
            gc.z(this.z, new gc.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.gc.z
                public void z(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        z.this.f1349a.z(-1, "template info load fail");
                        if (z.this.m != null) {
                            z.this.m.z(-1);
                            return;
                        }
                        return;
                    }
                    z zVar = z.this;
                    zVar.z(jSONObject, zVar.fo);
                }
            });
        } catch (Exception e) {
            this.f1349a.z(-3, e.getMessage());
            com.bytedance.sdk.openadsdk.core.ugeno.a.z zVar = this.m;
            if (zVar != null) {
                zVar.z(-3);
            }
        }
    }

    public boolean v() {
        com.bytedance.adsdk.ugeno.g.dl<T> dlVarA;
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.e;
        return (dlVar == null || (dlVarA = dlVar.a("interactionWebView")) == 0 || dlVarA.fo() == null || dlVarA.fo().getVisibility() != 0) ? false : true;
    }

    protected void z(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> list) {
        this.f1349a.g();
        this.io.z((uy) this);
        this.io.z(jSONObject, list, new e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.2
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(int i, String str) {
                if (z.this.m != null) {
                    z.this.m.z(i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.e
            public void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
                z.this.e = dlVar;
                z zVar = z.this;
                zVar.gz = zVar.io.z();
                z.this.dl.addView(dlVar.fo(), new FrameLayout.LayoutParams(dlVar.mc(), dlVar.un()));
                if (z.this.sy) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(oq.dl(z.this.g, 200.0f), oq.dl(z.this.g, 200.0f));
                    layoutParams.gravity = 17;
                    z.this.dl.addView(z.this.p(), layoutParams);
                }
                if (z.this.m != null) {
                    z.this.m.z(dlVar.fo());
                }
                com.bytedance.sdk.openadsdk.core.i.a.z(z.this.gc, z.this.wp, "ugeno_coin_eCommerce_page_show_success", (com.bytedance.sdk.openadsdk.m.z.z) null);
            }
        });
    }

    public void z(g gVar) {
        this.js = gVar;
        m mVar = this.io;
        if (mVar != null) {
            mVar.z(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View p() {
        this.uf = new FrameLayout(this.g);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(18.0f);
        gradientDrawable.setColor(Color.parseColor("#99000000"));
        gradientDrawable.setShape(0);
        this.uf.setBackground(gradientDrawable);
        final GifView gifView = new GifView(this.g);
        com.bytedance.sdk.openadsdk.gz.g.z(com.bytedance.sdk.openadsdk.core.gz.dl.z("shop_page_guide_gif.gif")).type(3).config(Bitmap.Config.RGB_565).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.3
            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i, String str, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls lsVar) {
                Object result = lsVar.getResult();
                try {
                    if (result instanceof byte[]) {
                        if (lsVar.isGif()) {
                            gifView.z((byte[]) result, false);
                        } else {
                            gifView.setImageDrawable(fv.z((byte[]) result, 0));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
        int iDl = oq.dl(this.g, 120.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDl, iDl);
        layoutParams.gravity = 17;
        layoutParams.bottomMargin = oq.dl(this.g, 10.0f);
        gifView.setLayoutParams(layoutParams);
        this.uf.addView(gifView);
        TextView textView = new TextView(this.g);
        textView.setText("需要浏览页面才能领取奖励");
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.SERIF, 1);
        textView.setTextColor(Color.parseColor("#ffffff"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.topMargin = oq.dl(this.g, 70.0f);
        textView.setLayoutParams(layoutParams2);
        this.uf.addView(textView);
        this.uf.setOnTouchListener(new com.bytedance.sdk.openadsdk.core.ugeno.fo.dl(this.g, new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.4
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fo.dl.z
            public void z() {
                if ((z.this.gz instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) && z.this.gz.fo() != null) {
                    ((RecyclerView) z.this.gz.fo()).g(1);
                }
                z zVar = z.this;
                zVar.z(zVar.gz);
                z.this.uf.setVisibility(8);
                com.bytedance.sdk.openadsdk.core.i.a.z(z.this.gc, "landingpage", "in_web_click", (com.bytedance.sdk.openadsdk.m.z.z) null);
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.fo.dl.z
            public void g() {
                z.this.uf.setVisibility(8);
            }
        }, 200));
        this.uf.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.5
            @Override // java.lang.Runnable
            public void run() {
                z.this.uf.setVisibility(8);
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        return this.uf;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.e.z$6, reason: invalid class name */
    class AnonymousClass6 extends fo {
        final /* synthetic */ com.bytedance.adsdk.ugeno.g.dl z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(String str, com.bytedance.adsdk.ugeno.g.dl dlVar) {
            super(str);
            this.z = dlVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.openadsdk.core.io.g.z(z.this.gc, z.this.v, new com.bytedance.sdk.openadsdk.core.js.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.6.1
                @Override // com.bytedance.sdk.openadsdk.core.js.dl
                public void z(boolean z, List<na> list, boolean z2) {
                    if (list == null || list.size() <= 0) {
                        if (z.this.q.get() <= 0) {
                            if (z.this.tb != null) {
                                z.this.tb.z();
                                return;
                            }
                            return;
                        } else {
                            z.this.z(AnonymousClass6.this.z);
                            z.this.q.decrementAndGet();
                            return;
                        }
                    }
                    z.this.ls = list.size();
                    z.this.p += list.size();
                    z.this.fv = z.this.pf();
                    na naVar = list.get(0);
                    if (naVar != null) {
                        z.this.v = naVar.rw();
                    }
                    final List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> listZ = z.this.z(list);
                    q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.6.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AnonymousClass6.this.z == null || !(AnonymousClass6.this.z instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.g.m)) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) AnonymousClass6.this.z).g(listZ);
                        }
                    });
                }
            }, z.this.gc.lw());
        }
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        com.bytedance.sdk.component.uy.e.g(new AnonymousClass6("shop_page", dlVar));
    }

    protected int pf() {
        int i;
        int i2 = this.ls;
        int i3 = this.pf;
        if (i2 < i3) {
            i = this.p - i2;
        } else {
            i = this.p - i3;
        }
        return Math.max(i, 0);
    }

    protected List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> z(List<na> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (na naVar : list) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl dlVar = new com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl();
            JSONObject jSONObjectKv = naVar.kv();
            try {
                jSONObjectKv.put("voice_btn_position", js.pf(this.gc));
            } catch (JSONException unused) {
            }
            dlVar.z(-2134548432);
            dlVar.z(jSONObjectKv);
            arrayList.add(dlVar);
        }
        return arrayList;
    }

    protected void z(final na naVar, final com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (TextUtils.equals(dlVar.x(), "mute")) {
            com.bytedance.adsdk.ugeno.g.z zVarGk = dlVar.gk();
            if (zVarGk != null) {
                com.bytedance.adsdk.ugeno.g.dl dlVarA = zVarGk.a("video_" + naVar.ou());
                if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) {
                    com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) dlVarA;
                    if (gVar.gz()) {
                        gVar.a(false);
                        if (dlVar instanceof com.bytedance.adsdk.ugeno.widget.image.g) {
                            ((com.bytedance.adsdk.ugeno.widget.image.g) dlVar).g(tb.dl(this.g, "tt_unmute"));
                            return;
                        }
                        return;
                    }
                    gVar.a(true);
                    if (dlVar instanceof com.bytedance.adsdk.ugeno.widget.image.g) {
                        ((com.bytedance.adsdk.ugeno.widget.image.g) dlVar).g(tb.dl(this.g, "tt_mute"));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (this.iq) {
            if (!com.bytedance.sdk.openadsdk.core.ugeno.uy.m(this.gc)) {
                z(this.gc, this.i);
            }
            com.bytedance.sdk.openadsdk.core.i.a.z(naVar, this.wp, "ugeno_coin_eCommerce_click_content", (com.bytedance.sdk.openadsdk.m.z.z) null);
            com.bytedance.sdk.openadsdk.core.i.a.z(naVar, this.wp, "page_click", (com.bytedance.sdk.openadsdk.m.z.z) null);
            this.iq = false;
        }
        z(naVar);
        if (this instanceof com.bytedance.sdk.openadsdk.core.ugeno.fo.a) {
            naVar.fo(1);
            na naVar2 = this.gc;
            if (naVar2 != null) {
                naVar.z(naVar2.hh());
            }
        }
        if (com.bytedance.sdk.openadsdk.core.g.z.g.dl.z(naVar, true)) {
            com.bytedance.sdk.openadsdk.core.g.z.g.dl dlVar2 = new com.bytedance.sdk.openadsdk.core.g.z.g.dl(naVar, this.g);
            dlVar2.z(new dl.g() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.7
                @Override // com.bytedance.sdk.openadsdk.core.g.z.g.dl.g
                public void z() {
                    q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (naVar == null || naVar.fb() == null) {
                                return;
                            }
                            hh.z(z.this.g, naVar.fb().a(), 0);
                        }
                    });
                    z.this.g(naVar, dlVar);
                }

                @Override // com.bytedance.sdk.openadsdk.core.g.z.g.dl.g
                public void z(final String str, final boolean z) {
                    q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z && "has_applied".equals(str)) {
                                hh.z(z.this.g, "你已领券，快去直播间下单吧", 0);
                            } else {
                                hh.z(z.this.g, "领券失败", 0);
                            }
                        }
                    });
                    z.this.g(naVar, dlVar);
                }
            });
            dlVar2.z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.8
                @Override // com.bytedance.sdk.openadsdk.core.g.z.g.dl.z
                public void z() {
                }
            });
            return;
        }
        g(naVar, dlVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(na naVar, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        String strG = eo.g(this.gc);
        com.bytedance.sdk.openadsdk.core.g.z zVar = new com.bytedance.sdk.openadsdk.core.g.z(this.g, naVar, strG, eo.g(strG));
        Map<String, Object> mapGc = ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).gc();
        mapGc.put("click_element_type", dlVar.x());
        Map<String, Object> map = this.i;
        if (map != null) {
            mapGc.putAll(map);
        }
        final String strMj = naVar.mj();
        com.bytedance.sdk.openadsdk.core.kb.g.a aVarG = com.bytedance.sdk.openadsdk.core.kb.gz.g(this.g, naVar, strG, false);
        ((com.bytedance.sdk.openadsdk.core.g.z.z.z) zVar.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z((com.bytedance.sdk.openadsdk.core.kb.g.dl) aVarG);
        zVar.z(null, new com.bytedance.sdk.openadsdk.core.iq.uy());
        if (aVarG != null) {
            aVarG.z(new com.bytedance.sdk.openadsdk.core.kb.g.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.e.z.9
                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z() {
                    z.C0193z.z(strMj, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void g(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void dl(long j, long j2, String str, String str2) {
                    if (j > 0) {
                        z.C0193z.z(strMj, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(long j, String str, String str2) {
                    z.C0193z.z(strMj, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.kb.g.z
                public void z(String str, String str2) {
                    z.C0193z.z(strMj, 6, 100);
                }
            });
        }
        Object obj = this.g;
        if (obj instanceof com.bytedance.sdk.openadsdk.core.gz.g) {
            ((com.bytedance.sdk.openadsdk.core.gz.g) obj).z(2);
        }
    }

    private void z(na naVar) {
        com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL;
        JSONObject jSONObjectG;
        i iVarZ;
        if (naVar == null || (zVarL = naVar.l()) == null || (jSONObjectG = zVarL.g()) == null || (iVarZ = i.z(jSONObjectG)) == null) {
            return;
        }
        if (iVarZ.dl() == 0 || iVarZ.dl() == 5) {
            naVar.z(iVarZ);
        }
    }

    public void z(JSONObject jSONObject) {
        na naVarZ;
        if (jSONObject == null || (naVarZ = com.bytedance.sdk.openadsdk.core.z.z(jSONObject)) == null) {
            return;
        }
        String strG = eo.g(this.gc);
        HashMap map = new HashMap();
        map.put("is_slide", this.uy);
        com.bytedance.sdk.openadsdk.core.i.a.z(naVarZ, strG, map, (Double) null);
        com.bytedance.sdk.openadsdk.core.l.z.z().a();
        na naVar = this.gc;
        un.z(naVar != null ? naVar.gc() : 0);
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (this.zw && this.uy.get() == 0) {
                return;
            }
            jSONObject2.put("is_slide", this.uy);
            jSONObject2.put(UMCrash.SP_KEY_TIMESTAMP, System.currentTimeMillis());
            com.bytedance.sdk.openadsdk.core.i.a.z(naVarZ, strG, "is_slide", jSONObject2, (com.bytedance.sdk.openadsdk.m.z.z) null);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    public void z(Map<String, Object> map) {
        this.i = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.gz
    public void g(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        na naVar = this.gc;
        if (naVar == null || naVar.gm() == null) {
            return;
        }
        dlVar.g(0);
    }

    public void ls() {
        na naVar = this.gc;
        un.g(naVar != null ? naVar.gc() : 0);
    }

    public void z(InterfaceC0202z interfaceC0202z) {
        this.tb = interfaceC0202z;
    }

    private void z(na naVar, Map<String, Object> map) {
        if (naVar == null) {
            return;
        }
        String strG = eo.g(naVar);
        int iGz = oq.gz(zw.getContext());
        com.bytedance.sdk.openadsdk.core.i.a.z("click", naVar, new fo.z().m(-1.0f).gc(-1.0f).a(-1.0f).dl(-1.0f).g(-1L).z(-1L).dl(-1).a(-1).gc(-1024).g(com.bytedance.sdk.openadsdk.core.uy.ls().dl() ? 1 : 2).z(iGz).z(oq.m(zw.getContext())).g(oq.e(zw.getContext())).z(), strG, true, map, -1, false);
    }
}
