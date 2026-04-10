package com.bytedance.sdk.openadsdk.core.ugeno.gz;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.adsdk.ugeno.dl.v;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.adsdk.ugeno.gc.m;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.io.g;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.uy;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.e;
import com.bytedance.sdk.openadsdk.core.ugeno.webview.PageWebView;
import com.bytedance.sdk.openadsdk.core.un.io;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements fv, tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private na f1363a;
    private com.bytedance.sdk.openadsdk.core.ugeno.m.z dl;
    private g e;
    private JSONObject fo;
    private ViewGroup g;
    private dl gc;
    private uy gz;
    private com.bytedance.sdk.openadsdk.core.ugeno.a.z m;
    private Map<String, Object> uy;
    private Context z;

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(dl dlVar, String str, m.z zVar) {
    }

    public z(Context context, ViewGroup viewGroup, com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar, na naVar) {
        this.z = context;
        this.g = viewGroup;
        this.dl = zVar;
        this.f1363a = naVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.a.z zVar) {
        this.m = zVar;
    }

    public void z(DownloadListener downloadListener) {
        PageWebView.z(this.fo, downloadListener);
    }

    public void z() {
        com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar = this.dl;
        if (zVar == null) {
            com.bytedance.sdk.openadsdk.core.ugeno.a.z zVar2 = this.m;
            if (zVar2 != null) {
                zVar2.z(-1);
                return;
            }
            return;
        }
        JSONObject jSONObjectZ = e.z().z(zVar.z(), this.dl.g());
        if (jSONObjectZ == null) {
            com.bytedance.sdk.openadsdk.core.io.g.z(this.dl, new g.InterfaceC0179g() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gz.z.1
                @Override // com.bytedance.sdk.openadsdk.core.io.g.InterfaceC0179g
                public void z(JSONObject jSONObject) {
                    z.this.z(jSONObject);
                }

                @Override // com.bytedance.sdk.openadsdk.core.io.g.InterfaceC0179g
                public void z() {
                    if (z.this.m != null) {
                        z.this.m.z(-1);
                    }
                }
            });
        } else {
            z(jSONObjectZ);
        }
    }

    public void z(final JSONObject jSONObject) {
        final pf pfVar = new pf(this.z);
        final JSONObject jSONObjectKv = this.f1363a.kv();
        this.fo = jSONObjectKv;
        v vVar = new v();
        vVar.z(this.z);
        HashMap map = new HashMap();
        map.put("key_reward_page", this.uy);
        vVar.z(map);
        pfVar.z("reward_page", vVar);
        pfVar.z((fv) this);
        q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.gz.z.2
            @Override // java.lang.Runnable
            public void run() {
                z.this.gc = pfVar.z(jSONObject);
                if (z.this.gc == null) {
                    if (z.this.m != null) {
                        z.this.m.z(-1);
                    }
                } else {
                    pfVar.g(jSONObjectKv);
                    z.this.g.addView(z.this.gc.fo(), new FrameLayout.LayoutParams(z.this.gc.mc(), z.this.gc.un()));
                    if (z.this.m != null) {
                        z.this.m.z(z.this.gc.fo());
                    }
                }
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.dl.fv
    public void z(ls lsVar, fv.g gVar, fv.z zVar) {
        if (lsVar != null && lsVar.g() == 1) {
            z(lsVar, lsVar.dl());
        }
    }

    private void z(ls lsVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("type");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        strOptString.hashCode();
        if (!strOptString.equals("clickEvent")) {
            if (strOptString.equals("openPolicy")) {
                com.bytedance.sdk.openadsdk.core.un.m.z(this.z, this.f1363a);
            }
        } else {
            com.bytedance.sdk.openadsdk.core.g.g gVar = this.e;
            if (gVar != null) {
                gVar.z(lsVar.z().fo(), this.gz);
            }
        }
    }

    public void z(com.bytedance.sdk.openadsdk.core.g.g gVar) {
        this.e = gVar;
    }

    @Override // com.bytedance.adsdk.ugeno.dl.tb
    public void z(dl dlVar, MotionEvent motionEvent) {
        this.gz.dl(motionEvent.getDeviceId());
        this.gz.g(motionEvent.getToolType(0));
        this.gz.a(motionEvent.getSource());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.gz.dl(motionEvent.getRawX());
                this.gz.a(motionEvent.getRawY());
                this.gz.g(System.currentTimeMillis());
                return;
            } else {
                if (actionMasked != 2) {
                    return;
                }
                this.gz.dl(motionEvent.getRawX());
                this.gz.a(motionEvent.getRawY());
                return;
            }
        }
        this.gz.gc((int) motionEvent.getRawX());
        this.gz.m((int) motionEvent.getRawY());
        this.gz.z(motionEvent.getRawX());
        this.gz.g(motionEvent.getRawY());
        this.gz.z(System.currentTimeMillis());
        this.gz.g(motionEvent.getToolType(0));
        this.gz.dl(motionEvent.getDeviceId());
        this.gz.a(motionEvent.getSource());
        this.gz.z(true);
        io.z(motionEvent);
    }

    public void z(Map<String, Object> map) {
        this.uy = map;
    }

    public void g() {
        PageWebView.z(this.fo);
    }
}
