package com.bytedance.adsdk.ugeno.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.adsdk.ugeno.dl.e;
import com.bytedance.adsdk.ugeno.dl.fo;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.g.a;
import com.bytedance.adsdk.ugeno.dl.g.gc;
import com.bytedance.adsdk.ugeno.dl.i;
import com.bytedance.adsdk.ugeno.dl.iq;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.p;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.adsdk.ugeno.dl.uy;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.g.z;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.adsdk.ugeno.m.z;
import com.bytedance.adsdk.ugeno.z;
import com.bytedance.adsdk.ugeno.z.m;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.qmuiteam.qmui.skin.QMUISkinValueBuilder;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl<T extends View> implements View.OnTouchListener, com.bytedance.adsdk.ugeno.dl, fv.g, fv.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JSONObject f239a;
    protected float b;
    private boolean bb;
    protected float bm;
    protected boolean bv;
    private GradientDrawable bw;
    private boolean by;
    private long c;
    private boolean cb;
    private com.bytedance.adsdk.ugeno.dl.z dh;
    protected JSONObject dl;
    private boolean dt;
    protected z<ViewGroup> e;
    protected float ec;
    protected int eo;
    protected float f;
    protected v fo;
    private String fp;
    protected float fv;
    protected Context g;
    protected boolean gb;
    protected T gc;
    protected float gk;
    private iq gm;
    protected float gp;
    private float gw;
    private String gy;
    protected fo.z gz;
    protected float h;
    private boolean he;
    protected float hh;
    protected com.bytedance.adsdk.ugeno.gc.fo hn;

    @Deprecated
    private gc hy;
    protected float i;
    protected boolean io;
    protected boolean iq;
    protected boolean j;
    protected float ja;
    private boolean jc;
    protected boolean jq;
    protected float js;
    private boolean jz;
    private boolean k;
    protected String kb;
    private i kp;
    protected float l;
    private JSONObject li;
    protected uy lk;
    protected boolean lq;
    protected float ls;

    @Deprecated
    private a.z lt;
    protected boolean lw;
    protected z.C0047z ly;
    protected z<ViewGroup> m;
    protected boolean mc;
    protected m me;
    private boolean mj;
    private boolean mn;
    protected boolean n;
    protected float na;
    protected float nb;
    protected float nh;
    private com.bytedance.adsdk.ugeno.gc.z.z no;
    private boolean o;
    protected String oq;
    private boolean oz;
    protected float p;
    private boolean pd;
    protected float pf;
    protected float q;
    protected String qd;
    protected float r;
    protected ViewGroup.LayoutParams rv;
    protected Map<Integer, ls> s;
    protected float sd;
    protected tb sf;
    protected boolean sv;
    protected float sy;
    protected float t;
    protected float tb;
    protected com.bytedance.adsdk.ugeno.z.z tc;

    @Deprecated
    private com.bytedance.adsdk.ugeno.dl.g.dl te;
    protected float tf;
    protected boolean ti;
    protected fv u;
    protected boolean uf;
    protected boolean un;
    protected boolean uy;
    protected float v;
    protected float vm;
    protected float vo;
    private boolean vt;
    protected ImageView.ScaleType wj;
    protected float wn;
    private boolean wo;
    protected String wp;
    private boolean wx;
    protected boolean x;
    private boolean xf;
    protected boolean xl;
    private boolean xo;
    protected float y;
    private boolean yt;
    protected e yw;
    protected int yx;
    protected float yz;
    private boolean z;

    @Deprecated
    private com.bytedance.adsdk.ugeno.dl.g.m zb;

    @Deprecated
    private com.bytedance.adsdk.ugeno.dl.g.g zd;
    protected boolean zw;
    protected int zx;
    protected float zz;

    protected void na() {
    }

    protected void xl() {
    }

    public T z() {
        return null;
    }

    public dl(Context context) {
        this(context, null);
    }

    public dl(Context context, z<ViewGroup> zVar) {
        this.i = -2.0f;
        this.v = -2.0f;
        this.qd = "solid";
        this.zx = 0;
        this.lw = true;
        this.nh = 0.0f;
        this.r = 0.0f;
        this.yz = 0.0f;
        this.bm = 1.0f;
        this.sd = 1.0f;
        this.tf = 1.0f;
        this.ja = 0.0f;
        this.wn = 0.0f;
        this.nb = 0.0f;
        this.zz = 0.0f;
        this.vo = 1.0f;
        this.xo = true;
        this.by = true;
        this.jc = false;
        this.he = false;
        this.mj = false;
        this.gw = 12.0f;
        this.g = context;
        this.m = zVar;
        this.s = new HashMap();
        this.bw = new GradientDrawable();
        this.gc = (T) z();
    }

    public T fo() {
        return this.gc;
    }

    public void g(JSONObject jSONObject) {
        this.f239a = jSONObject;
        kb();
    }

    public void z(JSONObject jSONObject) {
        this.f239a = jSONObject;
        kb();
        JSONObject jSONObject2 = this.dl;
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        z<ViewGroup> zVar = this.m;
        z.C0045z c0045zGz = zVar instanceof z ? zVar.gz() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strZ = com.bytedance.adsdk.ugeno.a.g.z(this.dl.optString(next), jSONObject);
            z(next, strZ);
            if (c0045zGz != null) {
                c0045zGz.z(this.g, next, strZ);
            }
        }
        if (c0045zGz != null) {
            z(c0045zGz.z());
        }
        if (this.li == null || this.f239a == null) {
            return;
        }
        try {
            if (h()) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("i18n", this.li);
                this.f239a.put("xNode", jSONObject3);
                return;
            }
            this.f239a.put("i18n", this.li);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    public JSONObject uy() {
        return this.f239a;
    }

    public void kb() {
        this.mj = this.f239a.optBoolean("gesture_through_enable", false);
    }

    public void g() {
        uf();
        wp();
        g(this.zx);
        e();
        gz();
        com.bytedance.adsdk.ugeno.gc.fo foVar = this.hn;
        if (foVar != null) {
            foVar.z();
            this.hn.g();
            this.hn.dl();
        }
        this.gc.setOnTouchListener(this);
        sv();
        ViewGroup viewGroup = (ViewGroup) this.gc.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(!this.xo);
        }
        com.bytedance.adsdk.ugeno.z.z zVar = this.tc;
        if (zVar != null) {
            zVar.a();
        }
        m mVar = this.me;
        if (mVar != null) {
            mVar.z();
        }
        com.bytedance.adsdk.ugeno.gc.fo foVar2 = this.hn;
        if (foVar2 != null) {
            foVar2.a();
        }
        if (this.u == null || !z(22)) {
            return;
        }
        this.u.z(this.s.get(22), this, this);
    }

    protected void wp() {
        this.gc.setPadding((int) (this.lq ? this.hh : this.sy), (int) (this.un ? this.h : this.sy), (int) (this.mc ? this.l : this.sy), (int) (this.ti ? this.gk : this.sy));
    }

    private void e() {
        if (this.z) {
            this.gc.setTranslationX(this.r);
        }
        if (this.wo) {
            this.gc.setTranslationY(this.yz);
        }
        if (this.k) {
            this.gc.setScaleX(this.sd);
        }
        if (this.wx) {
            this.gc.setScaleY(this.tf);
        }
        if (this.cb) {
            this.gc.setRotation(this.ja);
        }
        if (this.o) {
            this.gc.setRotationX(this.wn);
        }
        if (this.yt) {
            this.gc.setRotationY(-this.nb);
        }
        if (this.dt) {
            this.gc.setAlpha(this.vo);
        }
        float f = this.zz;
        if (f != 0.0f) {
            this.gc.setRotation(f);
        }
        if (this.cb || this.o || this.yt) {
            this.gc.setCameraDistance(10000.0f);
        }
    }

    public float i() {
        return this.r;
    }

    public float v() {
        return this.yz;
    }

    public float pf() {
        return this.sd;
    }

    public float ls() {
        return this.tf;
    }

    public float p() {
        return this.wn;
    }

    public float fv() {
        return this.nb;
    }

    public float js() {
        return this.zz;
    }

    public float tb() {
        return this.vo;
    }

    public float q() {
        return this.gp;
    }

    @Deprecated
    private void gz() {
        a aVarA;
        this.gc.setVisibility(this.zx);
        float f = this.zz;
        if (f != 0.0f) {
            this.gc.setRotation(f);
        }
        fo.z zVar = this.gz;
        if (zVar != null && TextUtils.isEmpty(zVar.g())) {
            this.gc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.g.dl.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (dl.this.lk == null || !dl.this.by) {
                        return;
                    }
                    dl.this.lk.z(dl.this);
                }
            });
        } else if (z(1) && !this.vt) {
            this.gc.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.adsdk.ugeno.g.dl.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (dl.this.u == null || !dl.this.by) {
                        return;
                    }
                    fv fvVar = dl.this.u;
                    ls lsVar = dl.this.s.get(1);
                    dl dlVar = dl.this;
                    fvVar.z(lsVar, dlVar, dlVar);
                }
            });
        }
        if (this.u != null && z(4)) {
            if (z(1)) {
                this.pd = true;
                this.hy = new gc(this.g, this.s.get(4), this.s.get(1), this.pd, gb());
            } else {
                this.hy = new gc(this.g, this.s.get(4), this.pd, gb());
            }
        }
        if (this.u != null && z(1) && this.vt) {
            this.te = new com.bytedance.adsdk.ugeno.dl.g.dl(this.g, this.s.get(1));
        }
        jq();
        if (this.u != null && z(3) && (aVarA = com.bytedance.adsdk.ugeno.a.z().a()) != null) {
            a.z zVar2 = this.lt;
            if (zVar2 != null) {
                zVar2.g();
            }
            a.z zVarZ = aVarA.z(this.g, this);
            this.lt = zVarZ;
            zVarZ.z(this.gw);
            this.lt.z();
            this.lt.z(new a.g() { // from class: com.bytedance.adsdk.ugeno.g.dl.3
                @Override // com.bytedance.adsdk.ugeno.dl.g.a.g
                public void z(int i) {
                    dl.this.lt.g();
                    if (dl.this.gc.isShown() && dl.this.u != null && i == 1) {
                        fv fvVar = dl.this.u;
                        ls lsVar = dl.this.s.get(3);
                        dl dlVar = dl.this;
                        fvVar.z(lsVar, dlVar, dlVar);
                    }
                }
            });
        }
        if (this.u != null && z(9)) {
            com.bytedance.adsdk.ugeno.dl.g.m mVar = new com.bytedance.adsdk.ugeno.dl.g.m(this.g, this.s.get(9), this);
            this.zb = mVar;
            mVar.z(this.u);
        }
        if (z(10)) {
            com.bytedance.adsdk.ugeno.dl.g.g gVar = new com.bytedance.adsdk.ugeno.dl.g.g(this.g, this.s.get(10), this);
            this.zd = gVar;
            gVar.z(this.u);
        }
    }

    private void jq() {
        ls lsVar;
        if (this.u == null || !z(18) || (lsVar = this.s.get(18)) == null) {
            return;
        }
        JSONObject jSONObjectDl = lsVar.dl();
        if (jSONObjectDl != null) {
            try {
                jSONObjectDl.put("rotateZ", com.bytedance.adsdk.ugeno.a.g.z(jSONObjectDl.optString("rotateZ"), this.f239a));
            } catch (JSONException unused) {
            }
        }
        this.u.z(lsVar, this, this);
    }

    private void sv() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.kb);
        this.gc.setContentDescription(sb);
    }

    public void z(iq iqVar) {
        this.gm = iqVar;
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void gc() {
        if (this.dh != null) {
            i iVar = new i(this.gc, this.dh);
            this.kp = iVar;
            iVar.z();
        }
        com.bytedance.adsdk.ugeno.z.z zVar = this.tc;
        if (zVar != null) {
            zVar.z();
        }
        m mVar = this.me;
        if (mVar != null) {
            mVar.g();
        }
        iq iqVar = this.gm;
        if (iqVar != null) {
            iqVar.a();
        }
        com.bytedance.adsdk.ugeno.gc.fo foVar = this.hn;
        if (foVar != null) {
            foVar.gc();
        }
        if (this.zd != null && z(10)) {
            this.zd.z();
        }
        if (this.zb != null && z(9)) {
            this.zb.z();
        }
        gc gcVar = this.hy;
        if (gcVar != null) {
            gcVar.z();
        }
        this.c = System.currentTimeMillis();
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void m() {
        i iVar = this.kp;
        if (iVar != null) {
            iVar.g();
        }
        com.bytedance.adsdk.ugeno.z.z zVar = this.tc;
        if (zVar != null) {
            zVar.dl();
        }
        m mVar = this.me;
        if (mVar != null) {
            mVar.dl();
        }
        iq iqVar = this.gm;
        if (iqVar != null) {
            iqVar.gc();
        }
        a.z zVar2 = this.lt;
        if (zVar2 != null) {
            zVar2.g();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void z(boolean z) {
        iq iqVar = this.gm;
        if (iqVar != null) {
            iqVar.z(z);
        }
    }

    public fv iq() {
        return this.u;
    }

    public long zw() {
        return this.c;
    }

    public void g(boolean z) {
        this.vt = z;
    }

    public boolean z(int i) {
        Map<Integer, ls> map = this.s;
        return map != null && map.containsKey(Integer.valueOf(i));
    }

    public void g(int i) {
        ViewParent viewParent = (ViewGroup) this.gc.getParent();
        if (viewParent instanceof g) {
            ((g) viewParent).dl(this.gc, i);
        } else {
            this.gc.setVisibility(i);
        }
    }

    public void z(tb tbVar) {
        this.sf = tbVar;
    }

    public void z(fv fvVar) {
        this.u = fvVar;
    }

    public void dl(JSONObject jSONObject) {
        this.dl = jSONObject;
    }

    public JSONObject io() {
        return this.dl;
    }

    protected void uf() {
        BitmapDrawable bitmapDrawable;
        Bitmap bitmapZ;
        if (TextUtils.isEmpty(this.oq)) {
            if (this.n) {
                z(this.ly);
                return;
            } else {
                this.bw.setColor(this.eo);
                dl(this.eo);
                return;
            }
        }
        if (this.oq.startsWith("local://")) {
            String strReplace = this.oq.replace("local://", "");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = this.xl ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
                options.inPurgeable = true;
                options.inInputShareable = true;
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(this.g.getResources().openRawResource(com.bytedance.adsdk.ugeno.m.a.g(this.g, strReplace)), null, options);
                if (this.xl && (bitmapZ = gz.z(this.g, bitmapDecodeStream, (int) this.na)) != null) {
                    bitmapDrawable = new BitmapDrawable(this.g.getResources(), bitmapZ);
                    z(bitmapDrawable);
                    return;
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.g.getResources(), bitmapDecodeStream);
                    bitmapDrawable = bitmapDrawable2;
                    z(bitmapDrawable);
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        sy();
    }

    protected void sy() {
        e eVar = this.yw;
        if (eVar != null) {
            eVar.z();
        }
        com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, this.oq, new z.InterfaceC0053z() { // from class: com.bytedance.adsdk.ugeno.g.dl.4
            @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
            public void z(final Bitmap bitmap) {
                if (bitmap == null) {
                    if (dl.this.yw != null) {
                        e eVar2 = dl.this.yw;
                        dl dlVar = dl.this;
                        eVar2.g(dlVar, dlVar.oq);
                        return;
                    }
                    return;
                }
                if (dl.this.yw != null) {
                    e eVar3 = dl.this.yw;
                    dl dlVar2 = dl.this;
                    eVar3.z(dlVar2, dlVar2.oq);
                }
                if (dl.this.xl) {
                    final Bitmap bitmapZ = gz.z(dl.this.g, bitmap, (int) dl.this.na);
                    if (bitmapZ != null) {
                        gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.g.dl.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                dl.this.z(new BitmapDrawable(bitmapZ));
                            }
                        });
                        return;
                    }
                    return;
                }
                gz.z(new Runnable() { // from class: com.bytedance.adsdk.ugeno.g.dl.4.2
                    @Override // java.lang.Runnable
                    public void run() {
                        dl.this.z(new BitmapDrawable(bitmap));
                    }
                });
            }
        });
    }

    protected void z(z.C0047z c0047z) {
        if (c0047z == null) {
            return;
        }
        this.bw.setShape(0);
        if (c0047z != null) {
            this.bw.setOrientation(c0047z.z);
            if (Build.VERSION.SDK_INT >= 29) {
                this.bw.setColors(c0047z.g, c0047z.dl);
            } else {
                this.bw.setColors(c0047z.g);
            }
        }
        yx();
        f();
        this.gc.setBackground(this.bw);
    }

    protected void dl(int i) {
        this.bw.setShape(0);
        this.bw.setColor(i);
        yx();
        f();
        this.gc.setBackground(this.bw);
    }

    private void f() {
        if (TextUtils.equals("dashed", this.qd)) {
            GradientDrawable gradientDrawable = this.bw;
            float f = this.f;
            gradientDrawable.setStroke((int) f, this.yx, 3.0f * f, f);
        } else {
            if (TextUtils.equals("dotted", this.qd)) {
                GradientDrawable gradientDrawable2 = this.bw;
                float f2 = this.f;
                gradientDrawable2.setStroke((int) f2, this.yx, f2 / 2.0f, f2);
                return;
            }
            this.bw.setStroke((int) this.f, this.yx);
        }
    }

    private void yx() {
        float f = this.bv ? this.t : this.gp;
        float f2 = this.gb ? this.y : this.gp;
        float f3 = this.jq ? this.vm : this.gp;
        float f4 = this.sv ? this.ec : this.gp;
        this.bw.setCornerRadii(new float[]{f, f, f2, f2, f4, f4, f3, f3});
    }

    protected void z(Drawable drawable) {
        this.gc.setBackground(drawable);
    }

    public void z(ViewGroup.LayoutParams layoutParams) {
        T t = this.gc;
        if (t != null) {
            t.setLayoutParams(layoutParams);
        }
        this.rv = layoutParams;
    }

    public ViewGroup.LayoutParams hh() {
        return this.rv;
    }

    public void z(boolean z, boolean z2) {
        if (this.gc != null) {
            z(this.rv);
            if (z) {
                a((int) this.i);
            }
            if (z2) {
                gc((int) this.v);
            }
        }
    }

    public void z(fo.z zVar) {
        this.gz = zVar;
    }

    public fo.z l() {
        return this.gz;
    }

    public dl<T> a(String str) {
        return z(str);
    }

    protected dl<T> z(String str) {
        if (TextUtils.isEmpty(this.kb) || !TextUtils.equals(this.kb, str)) {
            return null;
        }
        return this;
    }

    public dl<T> gc(String str) {
        return g(str);
    }

    protected dl<T> g(String str) {
        if (TextUtils.isEmpty(this.wp) || !TextUtils.equals(this.wp, str)) {
            return null;
        }
        return this;
    }

    public dl<T> m(String str) {
        return dl(str);
    }

    protected dl<T> dl(String str) {
        if (uy(str) != null) {
            return this;
        }
        return null;
    }

    public void dl(boolean z) {
        this.uy = z;
    }

    public boolean h() {
        return this.uy;
    }

    public z gk() {
        return this.m;
    }

    public void z(z zVar) {
        this.m = zVar;
    }

    public void e(String str) {
        this.kb = str;
    }

    public String x() {
        return this.kb;
    }

    public void gz(String str) {
        this.wp = str;
    }

    public String lq() {
        return this.wp;
    }

    public int mc() {
        return (int) this.i;
    }

    public int un() {
        return (int) this.v;
    }

    public v ti() {
        return this.fo;
    }

    public void z(v vVar) {
        this.fo = vVar;
    }

    public boolean eo() {
        return this.lw;
    }

    public void z(uy uyVar) {
        this.lk = uyVar;
    }

    public int oq() {
        return this.eo;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1964681502:
                if (str.equals("clickable")) {
                    b = 0;
                }
                break;
            case -1901681170:
                if (str.equals("onRenderSuccess")) {
                    b = 1;
                }
                break;
            case -1721943862:
                if (str.equals("translateX")) {
                    b = 2;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    b = 3;
                }
                break;
            case -1501175880:
                if (str.equals("paddingLeft")) {
                    b = 4;
                }
                break;
            case -1375815020:
                if (str.equals("minWidth")) {
                    b = 5;
                }
                break;
            case -1351184668:
                if (str.equals("onDelay")) {
                    b = 6;
                }
                break;
            case -1337252761:
                if (str.equals("onShake")) {
                    b = 7;
                }
                break;
            case -1337126126:
                if (str.equals("onSlide")) {
                    b = 8;
                }
                break;
            case -1336288090:
                if (str.equals("onTimer")) {
                    b = 9;
                }
                break;
            case -1335874424:
                if (str.equals("onTwist")) {
                    b = 10;
                }
                break;
            case -1332194002:
                if (str.equals(QMUISkinValueBuilder.BACKGROUND)) {
                    b = 11;
                }
                break;
            case -1291329255:
                if (str.equals(d.ar)) {
                    b = 12;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    b = 13;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    b = 14;
                }
                break;
            case -1221029593:
                if (str.equals(MediaFormat.KEY_HEIGHT)) {
                    b = 15;
                }
                break;
            case -1081309778:
                if (str.equals("margin")) {
                    b = 16;
                }
                break;
            case -1044792121:
                if (str.equals("marginTop")) {
                    b = 17;
                }
                break;
            case -1013407967:
                if (str.equals("onDown")) {
                    b = Ascii.DC2;
                }
                break;
            case -933876756:
                if (str.equals("backgroundDrawable")) {
                    b = 19;
                }
                break;
            case -925180581:
                if (str.equals("rotate")) {
                    b = Ascii.DC4;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b = Ascii.NAK;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b = Ascii.SYN;
                }
                break;
            case -806339567:
                if (str.equals("padding")) {
                    b = Ascii.ETB;
                }
                break;
            case -681357156:
                if (str.equals("triggerFunc")) {
                    b = Ascii.CAN;
                }
                break;
            case -289173127:
                if (str.equals("marginBottom")) {
                    b = Ascii.EM;
                }
                break;
            case -133587431:
                if (str.equals("minHeight")) {
                    b = Ascii.SUB;
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    b = Ascii.ESC;
                }
                break;
            case 3176990:
                if (str.equals("i18n")) {
                    b = Ascii.FS;
                }
                break;
            case 3373707:
                if (str.equals("name")) {
                    b = Ascii.GS;
                }
                break;
            case 87811796:
                if (str.equals("backgroundImageBlur")) {
                    b = Ascii.RS;
                }
                break;
            case 90130308:
                if (str.equals("paddingTop")) {
                    b = Ascii.US;
                }
                break;
            case 94750088:
                if (str.equals("click")) {
                    b = 32;
                }
                break;
            case 105871684:
                if (str.equals("onTap")) {
                    b = 33;
                }
                break;
            case 108285963:
                if (str.equals("ratio")) {
                    b = 34;
                }
                break;
            case 109250890:
                if (str.equals("scale")) {
                    b = 35;
                }
                break;
            case 113126854:
                if (str.equals(MediaFormat.KEY_WIDTH)) {
                    b = 36;
                }
                break;
            case 202355100:
                if (str.equals("paddingBottom")) {
                    b = 37;
                }
                break;
            case 314070383:
                if (str.equals("animations")) {
                    b = 38;
                }
                break;
            case 320386138:
                if (str.equals("onLoadMore")) {
                    b = 39;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    b = 40;
                }
                break;
            case 529642498:
                if (str.equals("overflow")) {
                    b = 41;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    b = 42;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    b = 43;
                }
                break;
            case 713848971:
                if (str.equals("paddingRight")) {
                    b = 44;
                }
                break;
            case 722830999:
                if (str.equals("borderColor")) {
                    b = 45;
                }
                break;
            case 737768677:
                if (str.equals("borderStyle")) {
                    b = 46;
                }
                break;
            case 741115130:
                if (str.equals("borderWidth")) {
                    b = 47;
                }
                break;
            case 843948038:
                if (str.equals("onExposure")) {
                    b = 48;
                }
                break;
            case 975087886:
                if (str.equals("marginRight")) {
                    b = 49;
                }
                break;
            case 1052832078:
                if (str.equals("translate")) {
                    b = 50;
                }
                break;
            case 1087723621:
                if (str.equals("onAnimation")) {
                    b = 51;
                }
                break;
            case 1118509956:
                if (str.equals("animation")) {
                    b = 52;
                }
                break;
            case 1151851515:
                if (str.equals("animatorSet")) {
                    b = 53;
                }
                break;
            case 1158381436:
                if (str.equals("onPullToRefresh")) {
                    b = 54;
                }
                break;
            case 1287124693:
                if (str.equals(TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    b = 55;
                }
                break;
            case 1292595405:
                if (str.equals("backgroundImage")) {
                    b = 56;
                }
                break;
            case 1301532860:
                if (str.equals("backgroundScale")) {
                    b = 57;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    b = 58;
                }
                break;
            case 1384173149:
                if (str.equals("rotateX")) {
                    b = 59;
                }
                break;
            case 1384173150:
                if (str.equals("rotateY")) {
                    b = 60;
                }
                break;
            case 1384173151:
                if (str.equals("rotateZ")) {
                    b = Base64.padSymbol;
                }
                break;
            case 1490730380:
                if (str.equals("onScroll")) {
                    b = 62;
                }
                break;
            case 1671308008:
                if (str.equals("disable")) {
                    b = Utf8.REPLACEMENT_BYTE;
                }
                break;
            case 1685004456:
                if (str.equals("onLongTap")) {
                    b = SignedBytes.MAX_POWER_OF_TWO;
                }
                break;
            case 1941332754:
                if (str.equals("visibility")) {
                    b = 65;
                }
                break;
            case 1970934485:
                if (str.equals("marginLeft")) {
                    b = 66;
                }
                break;
            case 1997542747:
                if (str.equals("availability")) {
                    b = 67;
                }
                break;
        }
        switch (b) {
            case 0:
                this.by = com.bytedance.adsdk.ugeno.m.dl.z(str2, true);
                break;
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 18:
            case 33:
            case 39:
            case 48:
            case 51:
            case 54:
            case 62:
            case 64:
                g(str, str2);
                break;
            case 2:
                this.z = true;
                this.r = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case 3:
                this.wo = true;
                this.yz = gz.z(this.g, com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f));
                break;
            case 4:
                this.hh = gz.z(this.g, str2);
                this.lq = true;
                break;
            case 5:
                this.tb = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 11:
            case 55:
                if (com.bytedance.adsdk.ugeno.m.z.dl(str2)) {
                    this.n = true;
                    this.ly = com.bytedance.adsdk.ugeno.m.z.g(str2);
                } else {
                    this.eo = com.bytedance.adsdk.ugeno.m.z.z(str2, 0);
                    this.n = false;
                }
                break;
            case 12:
                this.hn = com.bytedance.adsdk.ugeno.gc.fo.z(this, str2);
                break;
            case 13:
                this.dt = true;
                this.vo = com.bytedance.adsdk.ugeno.m.dl.z(str2, 1.0f);
                break;
            case 14:
                this.t = gz.z(this.g, str2);
                this.bv = true;
                break;
            case 15:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.v = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.v = -2.0f;
                } else {
                    this.v = gz.z(this.g, str2);
                }
                this.he = true;
                break;
            case 16:
                this.pf = gz.z(this.g, str2);
                break;
            case 17:
                this.fv = gz.z(this.g, str2);
                this.io = true;
                break;
            case 19:
            case 56:
                this.oq = str2;
                break;
            case 20:
                this.cb = true;
                this.ja = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 21:
                this.k = true;
                this.sd = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 22:
                this.wx = true;
                this.tf = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 23:
                this.sy = gz.z(this.g, str2);
                this.x = true;
                break;
            case 24:
                this.fp = str2;
                break;
            case 25:
                this.js = gz.z(this.g, str2);
                this.uf = true;
                break;
            case 26:
                this.q = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 27:
                this.kb = str2;
                break;
            case 28:
                this.li = com.bytedance.adsdk.ugeno.m.g.z(str2, (JSONObject) null);
                break;
            case 29:
                this.wp = str2;
                break;
            case 30:
                float fZ = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                this.na = fZ;
                if (fZ > 0.0f) {
                    this.xl = true;
                }
                break;
            case 31:
                this.h = gz.z(this.g, str2);
                this.un = true;
                break;
            case 32:
                this.gy = str2;
                break;
            case 34:
                this.b = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 35:
                this.k = true;
                this.wx = true;
                float[] fArrDl = com.bytedance.adsdk.ugeno.z.a.dl(str2);
                this.sd = fArrDl[0];
                this.tf = fArrDl[1];
                break;
            case 36:
                if (TextUtils.equals(str2, "match_parent")) {
                    this.i = -1.0f;
                } else if (TextUtils.equals(str2, "wrap_content")) {
                    this.i = -2.0f;
                } else {
                    this.i = gz.z(this.g, str2);
                }
                this.jc = true;
                break;
            case 37:
                this.gk = gz.z(this.g, str2);
                this.ti = true;
                break;
            case 38:
                List<com.bytedance.adsdk.ugeno.z.dl> listZ = com.bytedance.adsdk.ugeno.z.a.z(str2, this.f239a);
                if (listZ != null && !listZ.isEmpty()) {
                    this.me = new m(this.g, this, listZ);
                    break;
                }
                break;
            case 40:
                this.y = gz.z(this.g, str2);
                this.gb = true;
                break;
            case 41:
                this.xo = wp(str2);
                break;
            case 42:
                this.vm = gz.z(this.g, str2);
                this.jq = true;
                break;
            case 43:
                this.ec = gz.z(this.g, str2);
                this.sv = true;
                break;
            case 44:
                this.l = gz.z(this.g, str2);
                this.mc = true;
                break;
            case 45:
                this.yx = com.bytedance.adsdk.ugeno.m.z.z(str2);
                break;
            case 46:
                this.qd = str2;
                break;
            case 47:
                this.f = gz.z(this.g, str2);
                break;
            case 49:
                this.p = gz.z(this.g, str2);
                this.zw = true;
                break;
            case 50:
                this.z = true;
                this.wo = true;
                float[] fArrDl2 = com.bytedance.adsdk.ugeno.z.a.dl(str2);
                this.r = gz.z(this.g, fArrDl2[0]);
                this.yz = gz.z(this.g, fArrDl2[1]);
                break;
            case 52:
                try {
                    this.tc = new com.bytedance.adsdk.ugeno.z.z(this.g, this, com.bytedance.adsdk.ugeno.z.a.z(new JSONObject(str2), this.f239a));
                } catch (JSONException e) {
                    wp.z(e);
                    return;
                }
                break;
            case 53:
                this.dh = com.bytedance.adsdk.ugeno.dl.z.z(str2, this);
                break;
            case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                this.j = true;
                this.wj = kb(str2);
                break;
            case 58:
                this.gp = gz.z(this.g, str2);
                break;
            case 59:
                this.o = true;
                this.wn = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 60:
                this.yt = true;
                this.nb = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 61:
                this.zz = com.bytedance.adsdk.ugeno.m.dl.z(str2, 0.0f);
                break;
            case 63:
                this.xf = com.bytedance.adsdk.ugeno.m.dl.z(str2, false);
                break;
            case 65:
                if (TextUtils.equals("visible", str2)) {
                    this.zx = 0;
                } else if (TextUtils.equals("invisible", str2)) {
                    this.zx = 4;
                } else if (TextUtils.equals("gone", str2) || TextUtils.equals("hidden", str2)) {
                    this.zx = 8;
                }
                this.gc.setVisibility(this.zx);
                break;
            case 66:
                this.ls = gz.z(this.g, str2);
                this.iq = true;
                break;
            case 67:
                this.lw = !TextUtils.equals(str2, "unavailable");
                break;
        }
    }

    private ImageView.ScaleType kb(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.wj = ImageView.ScaleType.CENTER;
                break;
            case "fit":
                this.wj = ImageView.ScaleType.FIT_CENTER;
                break;
            case "crop":
                this.wj = ImageView.ScaleType.CENTER_CROP;
                break;
            default:
                this.wj = ImageView.ScaleType.FIT_XY;
                break;
        }
        return this.wj;
    }

    private boolean wp(String str) {
        return TextUtils.isEmpty(str) || !TextUtils.equals(str, "hidden");
    }

    protected void g(String str, String str2) {
        if (TextUtils.isEmpty(str2) || this.s == null) {
            return;
        }
        try {
            int type = p.z(str).getType();
            ls lsVar = new ls();
            lsVar.z(type);
            lsVar.z(this);
            JSONObject jSONObject = new JSONObject(str2);
            if (type == 3) {
                try {
                    this.gw = Float.parseFloat(com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("shakeAmplitude"), this.f239a));
                } catch (NumberFormatException unused) {
                    this.gw = 12.0f;
                }
            }
            fv fvVar = this.u;
            if (!(fvVar instanceof com.bytedance.adsdk.ugeno.dl.z.g)) {
                z(type, jSONObject, lsVar);
            } else if (!((com.bytedance.adsdk.ugeno.dl.z.g) fvVar).z()) {
                z(type, jSONObject, lsVar);
            } else {
                lsVar.z(jSONObject);
                this.s.put(Integer.valueOf(type), lsVar);
            }
        } catch (JSONException unused2) {
        }
    }

    @Deprecated
    protected void z(int i, JSONObject jSONObject, ls lsVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("success");
        if (jSONObjectOptJSONObject != null) {
            ls lsVar2 = new ls();
            lsVar2.z(jSONObjectOptJSONObject);
            lsVar2.z(this);
            lsVar.z(lsVar2);
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("fail");
        if (jSONObjectOptJSONObject2 != null) {
            ls lsVar3 = new ls();
            lsVar3.z(jSONObjectOptJSONObject2);
            lsVar3.z(this);
            lsVar.g(lsVar3);
        }
        lsVar.z(jSONObject);
        this.s.put(Integer.valueOf(i), lsVar);
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void dl() {
        if (this.gm == null || this.mn) {
            return;
        }
        this.mn = true;
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void a() {
        if (this.gm == null || this.oz) {
            return;
        }
        this.oz = true;
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public int[] z(int i, int i2) {
        if (this.b > 0.0f) {
            if (this.jc) {
                int size = View.MeasureSpec.getSize(i);
                float f = this.b;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (size / f), 1073741824);
                }
            } else if (this.he) {
                int size2 = View.MeasureSpec.getSize(i2);
                float f2 = this.b;
                if (f2 != 0.0f) {
                    i = View.MeasureSpec.makeMeasureSpec((int) (size2 * f2), 1073741824);
                }
            }
        }
        if (this.gm != null && !this.jz) {
            this.jz = true;
        }
        return new int[]{i, i2};
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void z(int i, int i2, int i3, int i4) {
        if (this.gm == null || this.bb) {
            return;
        }
        this.bb = true;
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void z(Canvas canvas, com.bytedance.adsdk.ugeno.dl.gc gcVar) {
        i iVar = this.kp;
        if (iVar != null) {
            iVar.z(canvas, gcVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void z(Canvas canvas) {
        com.bytedance.adsdk.ugeno.z.z zVar = this.tc;
        if (zVar != null) {
            zVar.z(canvas);
        }
        m mVar = this.me;
        if (mVar != null) {
            mVar.z(canvas);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl
    public void g(int i, int i2, int i3, int i4) {
        i iVar = this.kp;
        if (iVar != null) {
            iVar.z(i, i2);
        }
        com.bytedance.adsdk.ugeno.z.z zVar = this.tc;
        if (zVar != null) {
            zVar.z(i, i2);
        }
        m mVar = this.me;
        if (mVar != null) {
            mVar.z(i, i2);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv.g
    public void z(ls lsVar) {
        z<ViewGroup> zVar;
        dl<T> dlVarA;
        if (lsVar == null || lsVar.dl() == null) {
            return;
        }
        a.z zVar2 = this.lt;
        if (zVar2 != null) {
            zVar2.g();
        }
        if (TextUtils.equals(lsVar.dl().optString("type"), "onDismiss")) {
            String strOptString = lsVar.dl().optString("nodeId");
            g(8);
            this.e = (z) g(this);
            if (TextUtils.isEmpty(strOptString) || (zVar = this.e) == null || (dlVarA = zVar.a(strOptString)) == null) {
                return;
            }
            dlVarA.g(8);
        }
    }

    public void z(com.bytedance.adsdk.ugeno.gc.z.z zVar) {
        this.no = zVar;
    }

    public com.bytedance.adsdk.ugeno.gc.z.z wj() {
        return this.no;
    }

    public dl g(dl dlVar) {
        return (dlVar.gk() == null && (dlVar instanceof z)) ? dlVar : g(dlVar.gk());
    }

    public void j() {
        gc gcVar = this.hy;
        if (gcVar != null) {
            gcVar.g();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        gc gcVar;
        fv fvVar;
        com.bytedance.adsdk.ugeno.dl.g.dl dlVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            na();
        } else if (action == 1 || action == 3) {
            xl();
        }
        tb tbVar = this.sf;
        if (tbVar != null) {
            tbVar.z(this, motionEvent);
        }
        if (z(17) && motionEvent.getAction() == 0) {
            this.u.z(this.s.get(17), this, this);
        }
        if (z(1) && this.vt && (fvVar = this.u) != null && (dlVar = this.te) != null) {
            return dlVar.z(fvVar, this, motionEvent);
        }
        fv fvVar2 = this.u;
        if (fvVar2 != null && (gcVar = this.hy) != null) {
            return gcVar.z(fvVar2, this, motionEvent, gb());
        }
        com.bytedance.adsdk.ugeno.gc.fo foVar = this.hn;
        if (foVar != null) {
            return foVar.z(motionEvent);
        }
        return false;
    }

    public boolean gp() {
        return this.b > 0.0f;
    }

    public float t() {
        T t = this.gc;
        if (t instanceof com.bytedance.adsdk.ugeno.z.e) {
            return ((com.bytedance.adsdk.ugeno.z.e) t).getRipple();
        }
        return 0.0f;
    }

    public float vm() {
        T t = this.gc;
        if (t instanceof com.bytedance.adsdk.ugeno.z.e) {
            return ((com.bytedance.adsdk.ugeno.z.e) t).getShine();
        }
        return 0.0f;
    }

    public float y() {
        T t = this.gc;
        if (t instanceof com.bytedance.adsdk.ugeno.z.e) {
            return ((com.bytedance.adsdk.ugeno.z.e) t).getStretch();
        }
        return 0.0f;
    }

    public float ec() {
        T t = this.gc;
        if (t instanceof com.bytedance.adsdk.ugeno.z.e) {
            return ((com.bytedance.adsdk.ugeno.z.e) t).getRubIn();
        }
        return 0.0f;
    }

    public void a(int i) {
        if (h()) {
            T t = this.gc;
            if (t instanceof g) {
                ((g) t).z(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof g) {
                ((g) viewParent).z(this.gc, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.gc.getLayoutParams();
        layoutParams.width = i;
        this.gc.setLayoutParams(layoutParams);
    }

    public void gc(int i) {
        if (h()) {
            T t = this.gc;
            if (t instanceof g) {
                ((g) t).g(i);
                return;
            }
            ViewParent viewParent = (ViewGroup) t.getParent();
            if (viewParent instanceof g) {
                ((g) viewParent).g(this.gc, i);
                return;
            }
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.gc.getLayoutParams();
        layoutParams.height = i;
        this.gc.setLayoutParams(layoutParams);
    }

    public boolean bv() {
        return this.xf;
    }

    public List<com.bytedance.adsdk.ugeno.gc.dl.g> fo(String str) {
        com.bytedance.adsdk.ugeno.gc.fo foVar;
        if (TextUtils.isEmpty(str) || (foVar = this.hn) == null) {
            return null;
        }
        return foVar.z(str);
    }

    public void z(String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.gc.dl.g> listFo = fo(str);
        if (listFo == null || listFo.isEmpty()) {
            return;
        }
        for (com.bytedance.adsdk.ugeno.gc.dl.g gVar : listFo) {
            gVar.z(this.hn);
            gVar.z(objArr);
        }
    }

    public void z(com.bytedance.adsdk.ugeno.dl.m mVar) {
        com.bytedance.adsdk.ugeno.gc.fo foVar = this.hn;
        if (foVar != null) {
            foVar.z(mVar);
        }
    }

    public com.bytedance.adsdk.ugeno.z.z uy(String str) {
        com.bytedance.adsdk.ugeno.z.z zVar = this.tc;
        if (zVar != null && TextUtils.equals(str, zVar.gc())) {
            return this.tc;
        }
        m mVar = this.me;
        if (mVar != null) {
            return mVar.z(str);
        }
        return null;
    }

    public void z(e eVar) {
        this.yw = eVar;
    }

    public boolean gb() {
        return this.mj;
    }
}
