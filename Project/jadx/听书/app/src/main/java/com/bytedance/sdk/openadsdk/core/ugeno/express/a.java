package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.dl.fo;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.adexpress.g.e;
import com.bytedance.sdk.component.adexpress.g.gz;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.utils.iq;
import com.bytedance.sdk.openadsdk.core.iq.h;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.iq.zw;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.kb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.mc;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements fv, tb, com.bytedance.sdk.component.adexpress.dynamic.a, com.bytedance.sdk.component.adexpress.g.a<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected JSONObject f1350a;
    protected com.bytedance.adsdk.ugeno.g.dl<View> dl;
    protected g e;
    protected gz fo;
    protected com.bytedance.sdk.openadsdk.core.ugeno.uy.z fv;
    protected Context g;
    protected JSONObject gc;
    protected UGTimerContainer gz;
    protected WeakReference<ViewGroup> i;
    private boolean iq;
    private List<com.bytedance.adsdk.ugeno.g.dl<View>> js;
    protected v kb;
    protected na m;
    protected iq p;
    protected com.bytedance.adsdk.ugeno.g.dl pf;
    private String q;
    private String tb;
    protected com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gz uy;
    protected com.bytedance.adsdk.ugeno.g.dl v;
    protected pf z;
    protected uy wp = new uy();
    protected AtomicBoolean ls = new AtomicBoolean(false);

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
    }

    public a(Context context, na naVar, g gVar, ViewGroup viewGroup) {
        JSONObject jSONObjectOptJSONObject;
        this.iq = false;
        this.g = context;
        this.z = new pf(context);
        this.m = naVar;
        this.e = gVar;
        this.gz = new UGTimerContainer(context);
        this.i = new WeakReference<>(viewGroup);
        JSONObject jSONObjectZ = z();
        this.f1350a = jSONObjectZ;
        if (naVar != null && jSONObjectZ != null && (jSONObjectOptJSONObject = jSONObjectZ.optJSONObject("event_template")) != null) {
            this.iq = true;
            com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(jSONObjectOptJSONObject);
        }
        if (com.bytedance.sdk.openadsdk.gc.z.a(naVar)) {
            this.z.z(new com.bytedance.adsdk.ugeno.dl.gz() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.a.1
                @Override // com.bytedance.adsdk.ugeno.dl.gz
                public void z(fo.z zVar) {
                    com.bytedance.sdk.openadsdk.gc.z.z(true, zVar);
                }

                @Override // com.bytedance.adsdk.ugeno.dl.gz
                public void g(fo.z zVar) {
                    com.bytedance.sdk.openadsdk.gc.z.z(false, zVar);
                }
            });
        }
    }

    public void z(gz gzVar) {
        this.fo = gzVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gz gzVar) {
        this.uy = gzVar;
    }

    public void g() {
        List<com.bytedance.adsdk.ugeno.g.dl<View>> list = this.js;
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = this.js.iterator();
        while (it.hasNext()) {
            it.next().j();
        }
    }

    private void z(com.bytedance.adsdk.ugeno.g.dl<View> dlVar, List<com.bytedance.adsdk.ugeno.g.dl<View>> list) {
        if (dlVar instanceof com.bytedance.adsdk.ugeno.g.z) {
            if (dlVar.z(4)) {
                list.add(dlVar);
            }
            List<com.bytedance.adsdk.ugeno.g.dl<View>> listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e();
            if (listE == null || listE.size() == 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
            while (it.hasNext()) {
                z(it.next(), list);
            }
            return;
        }
        if (dlVar == null || !dlVar.z(4)) {
            return;
        }
        list.add(dlVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public void z(e eVar) {
        this.e.mc().z();
        this.f1350a = z();
        JSONObject jSONObjectUy = uy();
        this.gc = jSONObjectUy;
        if (this.f1350a == null || jSONObjectUy == null) {
            eVar.z(MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, (String) null);
            return;
        }
        g(eVar);
        if (this.dl != null) {
            dl dlVar = new dl();
            this.kb = dlVar;
            dlVar.z(true);
            this.kb.z(dl());
            com.bytedance.adsdk.ugeno.g.dl dlVarGc = gc();
            this.v = dlVarGc;
            if (dlVarGc != null && (dlVarGc instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.a.z)) {
                ((dl) this.kb).z((FrameLayout) dlVarGc.fo());
            }
            com.bytedance.adsdk.ugeno.g.dl dlVarM = m();
            this.pf = dlVarM;
            if (dlVarM != null && (dlVarM instanceof com.bytedance.adsdk.ugeno.widget.frame.z)) {
                ((dl) this.kb).g((FrameLayout) dlVarM.fo());
            }
            v vVar = this.kb;
            if (vVar instanceof dl) {
                ((dl) vVar).z(this.fv);
            }
            this.gz.setTimerHolder(this.fv);
            int iMc = this.dl.mc();
            int iUn = this.dl.un();
            ArrayList arrayList = new ArrayList();
            this.js = arrayList;
            z(this.dl, arrayList);
            View viewFo = this.dl.fo();
            ViewGroup viewGroup = (ViewGroup) viewFo.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(viewFo);
            }
            this.gz.addView(this.dl.fo(), new FrameLayout.LayoutParams(iMc, iUn));
            float fGk = this.e.gk();
            float fX = this.e.x();
            float fDl = oq.dl(this.g, fGk);
            float fDl2 = oq.dl(this.g, fX);
            int iA = oq.a(this.g);
            int iFo = (int) (oq.fo(this.g) + oq.kb(this.g));
            float f = iA;
            if (fDl > f) {
                fDl = f;
            }
            float f2 = iFo;
            if (fDl2 > f2) {
                fDl2 = f2;
            }
            if (fX <= 0.0f) {
                this.gz.setLayoutParams(new FrameLayout.LayoutParams((int) fDl, -2));
            } else {
                this.gz.setLayoutParams(new FrameLayout.LayoutParams((int) fDl, (int) fDl2));
            }
            if (fX <= 0.0f) {
                this.gz.measure(View.MeasureSpec.makeMeasureSpec((int) fDl, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                int iA2 = oq.a(this.g, this.gz.getMeasuredWidth());
                int iA3 = oq.a(this.g, this.gz.getMeasuredHeight());
                this.kb.z(iA2);
                this.kb.g(iA3);
            } else {
                this.kb.z(oq.a(this.g, fDl));
                this.kb.g(oq.a(this.g, fDl2));
            }
            if (this.ls.get()) {
                eVar.z(MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, (String) null);
                return;
            } else {
                eVar.z(this.gz, this.kb);
                return;
            }
        }
        eVar.z(138, (String) null);
    }

    public float[] a() {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null) {
            return null;
        }
        com.bytedance.adsdk.ugeno.dl dlVarGc = dlVar.gc("InteractContainerView");
        if (dlVarGc instanceof kb) {
            return ((kb) dlVarGc).sv();
        }
        return null;
    }

    protected com.bytedance.adsdk.ugeno.g.dl gc() {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null) {
            return null;
        }
        return dlVar.gc("VideoPlaceholder");
    }

    protected com.bytedance.adsdk.ugeno.g.dl m() {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null) {
            return null;
        }
        return dlVar.gc("PlayableComponent");
    }

    protected void g(e eVar) {
        this.z.z((fv) this);
        this.z.z((tb) this);
        this.dl = this.z.z(this.f1350a);
        this.e.mc().g();
        this.e.mc().dl();
        this.z.g(this.gc);
    }

    public List<com.bytedance.adsdk.ugeno.g.dl<View>> gz() {
        return this.js;
    }

    public boolean fo() {
        return this.iq;
    }

    protected JSONObject z() {
        return this.e.gc();
    }

    protected JSONObject uy() {
        return this.e.lq();
    }

    public void z(boolean z) {
        this.ls.set(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public View e() {
        return this.gz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v() {
        na naVar = this.m;
        if (naVar != null) {
            return naVar.gc();
        }
        return 0;
    }

    public void kb() {
        this.ls.set(false);
        iq iqVar = this.p;
        if (iqVar != null) {
            iqVar.g(v());
        }
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.fv;
        if (zVar != null) {
            zVar.g();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.a
    public int dl() {
        return vm.g(this.m);
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(ls lsVar, fv.g gVar, fv.z zVar) {
        if (lsVar == null) {
            return;
        }
        if (lsVar.g() == 18) {
            dl(lsVar, gVar, zVar);
        } else if (lsVar.g() == 3) {
            a(lsVar, gVar, zVar);
        } else if (lsVar.g() == 9) {
            g(lsVar.dl());
        } else if (lsVar.g() == 10) {
            z(lsVar.dl());
        } else if (lsVar.g() == 21) {
            g(lsVar);
        } else if (lsVar.g() == 19) {
            dl(lsVar);
        } else if (lsVar.g() != 20) {
            if (a(lsVar)) {
                g(lsVar, gVar, zVar);
            } else if (lsVar.g() == 22) {
                z(lsVar);
            } else {
                z(lsVar, gVar, zVar, 0);
            }
        }
        if (lsVar.dl() != null) {
            String strOptString = lsVar.dl().optString("next");
            try {
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                ls lsVar2 = new ls();
                lsVar2.z(1);
                lsVar2.z(new JSONObject(strOptString));
                lsVar2.z(this.dl);
                z(lsVar2, (fv.g) null, (fv.z) null);
            } catch (JSONException unused) {
            }
        }
    }

    private void z(ls lsVar) {
        JSONObject jSONObjectDl;
        if (lsVar == null || (jSONObjectDl = lsVar.dl()) == null) {
            return;
        }
        String strOptString = jSONObjectDl.optString("type");
        String strOptString2 = jSONObjectDl.optString("uchain");
        JSONObject jSONObjectOptJSONObject = jSONObjectDl.optJSONObject("params");
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, com.bytedance.adsdk.ugeno.a.g.z(jSONObjectOptJSONObject.optString(next), uy()));
                } catch (Throwable unused) {
                }
            }
        }
        if ("true".equals(strOptString2)) {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            map2.put("material_meta", this.m);
            HashMap map3 = new HashMap();
            map3.put("ugen_event_params", jSONObject);
            String strG = eo.g(this.m);
            eo.hh();
            com.bytedance.sdk.openadsdk.core.fo.z.a.z.z(this.m, map, strOptString, map2, strG, map3);
        }
    }

    private void g(ls lsVar) {
        JSONObject jSONObjectDl;
        if (lsVar == null || (jSONObjectDl = lsVar.dl()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().z(this.m, jSONObjectDl.optString("uttieUrl"));
    }

    private void dl(ls lsVar) {
        JSONObject jSONObjectDl;
        if (lsVar == null || (jSONObjectDl = lsVar.dl()) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.q.v.z().z(this.m, jSONObjectDl.optString("uttieUrl"), jSONObjectDl.optLong("duration"));
    }

    private boolean a(ls lsVar) {
        JSONObject jSONObjectDl;
        return lsVar != null && lsVar.g() == 1 && (jSONObjectDl = lsVar.dl()) != null && jSONObjectDl.optBoolean("lottieEvent", false);
    }

    private void g(ls lsVar, fv.g gVar, fv.z zVar) {
        JSONObject jSONObjectDl = lsVar.dl();
        if (jSONObjectDl == null) {
            return;
        }
        String strOptString = jSONObjectDl.optString("type", null);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (strOptString.equals("clickEvent")) {
            z(lsVar, gVar, zVar, 0);
            return;
        }
        if (strOptString.equals(ILivePush.ClickType.CLOSE)) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.gz gzVar = this.uy;
            if (gzVar != null) {
                gzVar.z();
            }
            com.bytedance.sdk.openadsdk.core.q.v.z().g(this.m, jSONObjectDl.optString("uttieUrl"));
        }
    }

    private void dl(final ls lsVar, final fv.g gVar, final fv.z zVar) {
        if (this.p == null) {
            iq iqVar = new iq(zw.getContext(), 2, this.e.fo());
            this.p = iqVar;
            iqVar.z(this.m.fn());
            this.p.dl(this.m.vl());
            this.p.g(this.m.hs());
            this.p.z(this.m.kk());
            this.p.m(this.m.s());
            this.p.gc(this.m.yw());
            this.p.g(this.m.jb());
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        final float[] fArr = {0.0f};
        this.p.z(new iq.z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.a.2
            @Override // com.bytedance.sdk.component.utils.iq.z
            public void z(int i) {
                if (i != 2) {
                    return;
                }
                a.this.p.g(a.this.v());
                fArr[0] = 0.0f;
                View viewFo = ((com.bytedance.adsdk.ugeno.g.dl) gVar).fo();
                if (viewFo != null) {
                    viewFo.getViewTreeObserver().addOnWindowFocusChangeListener(new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.a.2.1
                        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
                        public void onWindowFocusChanged(boolean z) {
                            if (z) {
                                a.this.p.z(a.this.v());
                            } else {
                                a.this.p.g(a.this.v());
                                fArr[0] = 0.0f;
                            }
                        }
                    });
                }
                AtomicBoolean atomicBoolean2 = atomicBoolean;
                if (atomicBoolean2 != null) {
                    atomicBoolean2.set(true);
                }
                a.this.z(lsVar, gVar, zVar, 2);
            }
        });
        this.p.z(new iq.g() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.a.3
            float z = 0.0f;
            float g = 0.0f;
            float dl = 0.0f;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            float f1352a = 0.0f;
            float gc = 0.0f;
            float m = 0.0f;
            long e = System.currentTimeMillis();

            @Override // com.bytedance.sdk.component.utils.iq.g
            public void z(float f, float f2, float f3) {
                JSONObject jSONObjectDl;
                View viewFo;
                boolean z;
                float f4;
                float fCeil;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.e < 100) {
                    return;
                }
                this.e = jCurrentTimeMillis;
                ls lsVar2 = lsVar;
                if (lsVar2 == null || (jSONObjectDl = lsVar2.dl()) == null) {
                    return;
                }
                double dOptDouble = jSONObjectDl.optDouble("rotateZ", -1.0d);
                if (dOptDouble == -1.0d) {
                    return;
                }
                fv.g gVar2 = gVar;
                if ((gVar2 instanceof com.bytedance.adsdk.ugeno.g.dl) && (viewFo = ((com.bytedance.adsdk.ugeno.g.dl) gVar2).fo()) != null && viewFo.isShown()) {
                    float fAbs = Math.abs(f);
                    float fAbs2 = Math.abs(f2);
                    float fAbs3 = Math.abs(f3);
                    AtomicBoolean atomicBoolean2 = atomicBoolean;
                    if (atomicBoolean2 != null && atomicBoolean2.get()) {
                        if (f != 0.0f && f2 != 0.0f && f3 != 0.0f) {
                            atomicBoolean.set(false);
                        }
                        this.z = fAbs;
                        this.g = fAbs2;
                        this.dl = fAbs3;
                        this.f1352a = f;
                        this.gc = f2;
                        this.m = f3;
                        return;
                    }
                    float fMax = Math.max(Math.abs(fAbs - this.z), Math.max(Math.abs(fAbs2 - this.g), Math.abs(fAbs3 - this.dl)));
                    int iHs = a.this.m.hs();
                    if (iHs <= 0) {
                        iHs = 50;
                    }
                    if (Math.abs(fAbs - this.z) == fMax) {
                        f4 = f >= this.f1352a ? fMax : -fMax;
                        z = true;
                    } else {
                        z = false;
                        f4 = 0.0f;
                    }
                    if (Math.abs(fAbs2 - this.g) == fMax) {
                        f4 = f2 >= this.gc ? fMax : -fMax;
                        z = true;
                    }
                    if (Math.abs(fAbs3 - this.dl) != fMax) {
                        fMax = f4;
                    } else if (f3 < this.m) {
                        fMax = -fMax;
                    }
                    if (a.this.m.s() == 0) {
                        fCeil = (float) Math.ceil(((double) (fMax * 180.0f)) / dOptDouble);
                    } else {
                        double degrees = Math.toDegrees(fMax);
                        float fCeil2 = (float) Math.ceil(degrees / dOptDouble);
                        if (z && Math.abs(degrees) < iHs - 8) {
                            return;
                        } else {
                            fCeil = z ? -Math.abs(fCeil2) : fCeil2;
                        }
                    }
                    if (Math.abs(fCeil - fArr[0]) < 1.3d) {
                        return;
                    }
                    ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewFo, Key.ROTATION, fArr[0], fCeil);
                    objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
                    objectAnimatorOfFloat.setDuration(100L);
                    objectAnimatorOfFloat.start();
                    fArr[0] = fCeil;
                }
            }
        });
        this.p.z(v());
    }

    private void z(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar;
        com.bytedance.adsdk.ugeno.g.dl dlVarA;
        if (jSONObject == null) {
            return;
        }
        String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("type"), uy());
        String strZ2 = com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("nodeId"), uy());
        if (TextUtils.isEmpty(strZ2) || (dlVar = this.dl) == null || (dlVarA = dlVar.g(dlVar).a(strZ2)) == null) {
            return;
        }
        if (TextUtils.equals(strZ, "onShow")) {
            dlVarA.g(0);
        } else if (TextUtils.equals(strZ, "onDismiss")) {
            dlVarA.g(8);
        } else if (TextUtils.equals(strZ, "haptic")) {
            dl(jSONObject);
        }
    }

    private void g(JSONObject jSONObject) {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar;
        com.bytedance.adsdk.ugeno.g.dl dlVarA;
        if (jSONObject == null) {
            return;
        }
        String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("type"), uy());
        String strZ2 = com.bytedance.adsdk.ugeno.a.g.z(jSONObject.optString("nodeId"), uy());
        if (TextUtils.isEmpty(strZ2) || (dlVar = this.dl) == null || (dlVarA = dlVar.g(dlVar).a(strZ2)) == null) {
            return;
        }
        if (TextUtils.equals(strZ, "onDismiss")) {
            dlVarA.g(8);
        } else if (TextUtils.equals(strZ, "onShow")) {
            dlVarA.g(0);
        } else if (TextUtils.equals(strZ, "haptic")) {
            dl(jSONObject);
        }
    }

    private void a(final ls lsVar, final fv.g gVar, final fv.z zVar) {
        WeakReference<ViewGroup> weakReference = this.i;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        mc.z(this.i, new com.bytedance.sdk.openadsdk.core.g.dl() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.a.4
            @Override // com.bytedance.sdk.openadsdk.core.g.dl
            public void z() {
                if (a.this.i == null || a.this.i.get() == null || !mc.z(a.this.i.get())) {
                    return;
                }
                a.this.z(lsVar, gVar, zVar, 1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ls lsVar, fv.g gVar, fv.z zVar, int i) {
        com.bytedance.adsdk.ugeno.g.dl dlVarZ;
        int i2;
        String strOptString;
        JSONObject jSONObjectLq;
        CharSequence text;
        if (lsVar == null || (dlVarZ = lsVar.z()) == null) {
            return;
        }
        JSONObject jSONObjectDl = lsVar.dl();
        String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectDl.optString("nodeId"), uy());
        String strZ2 = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectDl.optString("type"), uy());
        int iOptInt = -1;
        if (TextUtils.equals(strZ2, "clickEvent")) {
            strOptString = jSONObjectDl.optString("subConvertLinkTag");
            iOptInt = jSONObjectDl.optInt("dpaPosition", -1);
            i2 = 2;
        } else {
            if (TextUtils.equals(strZ2, "muteVideo")) {
                this.tb = jSONObjectDl.optString("muteSrc");
                this.q = jSONObjectDl.optString("unmuteSrc");
                i2 = 5;
            } else if (TextUtils.equals(strZ2, "dislike")) {
                i2 = 3;
            } else if (TextUtils.equals(strZ2, "skip")) {
                i2 = 6;
            } else if (TextUtils.equals(strZ2, "openPolicy")) {
                i2 = 7;
            } else if (TextUtils.equals(strZ2, "openAppPolicy")) {
                i2 = 9;
            } else if (TextUtils.equals(strZ2, "openAppPermission")) {
                i2 = 10;
            } else if (TextUtils.equals(strZ2, ILivePush.ClickType.CLOSE)) {
                strOptString = "";
                i2 = 8;
            } else if (TextUtils.equals(strZ2, "openAppFunctionDesc")) {
                i2 = 12;
            } else if (TextUtils.equals(strZ2, "videoControl") || TextUtils.equals(strZ2, "pauseVideo")) {
                i2 = 4;
            } else if (TextUtils.equals(strZ2, "openCommonUrl")) {
                i2 = 13;
            } else {
                if (TextUtils.equals(strZ2, "onDismiss")) {
                    com.bytedance.adsdk.ugeno.g.dl dlVarA = lsVar.z().g(lsVar.z()).a(strZ);
                    if (dlVarA != null) {
                        dlVarA.g(8);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(strZ2, "onShow")) {
                    com.bytedance.adsdk.ugeno.g.dl dlVarA2 = lsVar.z().g(lsVar.z()).a(strZ);
                    if (dlVarA2 != null) {
                        dlVarA2.g(0);
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(strZ2, "haptic")) {
                    dl(lsVar.dl());
                    return;
                }
                i2 = 0;
            }
            strOptString = "";
        }
        zw.z zVarGc = new zw.z().a(this.wp.v()).dl(this.wp.pf()).g(this.wp.ls()).z(this.wp.p()).z(dlVarZ.x()).g(this.wp.wp()).z(this.wp.i()).gc(strOptString).gc(iOptInt);
        JSONObject jSONObject = new JSONObject();
        if (i > 0) {
            try {
                jSONObject.put("convertActionType", i);
            } catch (Throwable unused) {
            }
        }
        View viewFo = dlVarZ.fo();
        try {
            if ((viewFo instanceof TextView) && (text = ((TextView) viewFo).getText()) != null && text.toString().contains("下载")) {
                jSONObject.put("is_compliant_download", true);
            }
        } catch (JSONException unused2) {
        }
        try {
            if (this.m != null && this.iq && jSONObjectDl.optBoolean("uchain", false)) {
                jSONObject.put("uchain_event_name", strZ2);
            }
        } catch (JSONException unused3) {
        }
        try {
            g gVar2 = this.e;
            if (gVar2 != null && (jSONObjectLq = gVar2.lq()) != null) {
                jSONObject.put("ugen_id", jSONObjectLq.optString("ugen_id"));
            }
        } catch (JSONException unused4) {
        }
        try {
            String strZ3 = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectDl.optString("webUrl"), uy());
            String strZ4 = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectDl.optString("webTitle"), uy());
            jSONObject.put("openCommonWebUrl", strZ3);
            jSONObject.put("openCommonWebTitle", strZ4);
        } catch (JSONException unused5) {
        }
        zVarGc.z(jSONObject);
        com.bytedance.sdk.openadsdk.core.iq.zw zwVarZ = zVarGc.z();
        gz gzVar = this.fo;
        if (gzVar != null) {
            gzVar.z(viewFo, i2, zwVarZ);
        }
        if (gVar == null || lsVar.a() == null) {
            return;
        }
        gVar.z(lsVar.a());
    }

    private void z(Context context, h hVar) {
        new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.z.z(context, hVar).g();
    }

    private void dl(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        na naVar;
        h hVarZ;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("params")) == null) {
            return;
        }
        String strOptString = jSONObjectOptJSONObject.optString("id");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("pattern");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            z(this.g, new h(strOptString, jSONArrayOptJSONArray));
        } else {
            if (TextUtils.isEmpty(strOptString) || (naVar = this.m) == null || (hVarZ = naVar.z(strOptString)) == null) {
                return;
            }
            z(this.g, hVarZ);
        }
    }

    public void wp() {
        com.bytedance.adsdk.ugeno.g.dl<T> dlVarA;
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null || (dlVarA = dlVar.a("corver_container")) == 0 || dlVarA.fo() == null) {
            return;
        }
        dlVarA.fo().setVisibility(0);
    }

    public void i() {
        com.bytedance.adsdk.ugeno.g.dl<T> dlVarA;
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null || (dlVarA = dlVar.a("corver_container")) == 0 || dlVarA.fo() == null) {
            return;
        }
        dlVarA.fo().setVisibility(8);
    }

    public void z(long j, long j2) {
        com.bytedance.adsdk.ugeno.g.dl dlVar = this.v;
        if (dlVar instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.a.z) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.a.z) dlVar).z(j, j2);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a
    public void z(CharSequence charSequence, int i, int i2, boolean z) {
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.g.dl<T> dlVarA = dlVar.a("count_down_skip_container");
        if (dlVarA != 0 && dlVarA.fo() != null) {
            dlVarA.fo().setVisibility(0);
        }
        com.bytedance.adsdk.ugeno.dl dlVarA2 = this.dl.a("count_down");
        com.bytedance.adsdk.ugeno.dl dlVarA3 = this.dl.a("skip");
        if ((dlVarA2 instanceof com.bytedance.adsdk.ugeno.widget.text.g) && (dlVarA3 instanceof com.bytedance.adsdk.ugeno.widget.text.g)) {
            if (i2 == 0) {
                if (TextUtils.equals(charSequence, "0") || z) {
                    ((com.bytedance.adsdk.ugeno.widget.text.g) dlVarA2).fo().setVisibility(8);
                    ((com.bytedance.adsdk.ugeno.widget.text.g) dlVarA3).kb("跳过");
                    return;
                } else {
                    ((com.bytedance.adsdk.ugeno.widget.text.g) dlVarA2).kb(((Object) charSequence) + "s ");
                    com.bytedance.adsdk.ugeno.widget.text.g gVar = (com.bytedance.adsdk.ugeno.widget.text.g) dlVarA3;
                    gVar.kb("| 跳过");
                    gVar.fo().setVisibility(0);
                    return;
                }
            }
            ((com.bytedance.adsdk.ugeno.widget.text.g) dlVarA2).kb(((Object) charSequence) + "s ");
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.a
    public void setSoundMute(boolean z) {
        com.bytedance.adsdk.ugeno.g.dl<T> dlVarA;
        com.bytedance.adsdk.ugeno.g.dl<View> dlVar = this.dl;
        if (dlVar == null || (dlVarA = dlVar.a("mute_image")) == 0) {
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(this.tb)) {
                ((com.bytedance.adsdk.ugeno.widget.image.g) dlVarA).wp(this.tb);
            }
        } else if (!TextUtils.isEmpty(this.q)) {
            ((com.bytedance.adsdk.ugeno.widget.image.g) dlVarA).wp(this.q);
        }
        dlVarA.g();
    }

    @Override // com.bytedance.adsdk.ugeno.dl.tb
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                return;
            }
            this.wp.dl(motionEvent.getRawX());
            this.wp.a(motionEvent.getRawY());
            this.wp.g(System.currentTimeMillis());
            return;
        }
        this.wp.gc((int) motionEvent.getRawX());
        this.wp.m((int) motionEvent.getRawY());
        this.wp.z(motionEvent.getRawX());
        this.wp.g(motionEvent.getRawY());
        this.wp.z(System.currentTimeMillis());
        this.wp.g(motionEvent.getToolType(0));
        this.wp.dl(motionEvent.getDeviceId());
        this.wp.a(motionEvent.getSource());
    }
}
