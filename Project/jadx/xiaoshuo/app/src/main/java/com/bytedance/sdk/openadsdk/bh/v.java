package com.bytedance.sdk.openadsdk.bh;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.google.android.exoplayer2.util.MimeTypes;
import com.iflytek.aikit.media.param.MscKeys;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f2101a;
    private boolean ah;
    private JSONObject aq;
    private JSONObject as;
    private boolean ay;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f2102b;
    private int bc;
    public final String bf;
    private Runnable bh;
    private long bm;
    private String br;
    private long bx;
    private String c;
    private boolean cv;
    public final String d;
    private String dt;
    public final String e;
    private String eb;
    private long em;
    private int en;
    private int ev;
    private float ey;
    private boolean f;
    private int fa;
    private boolean fg;
    private int fl;
    private boolean ft;
    private int fy;
    private JSONObject g;
    public final String ga;
    private String gm;
    private long h;
    private long hb;
    private String i;
    private Map<String, String> in;
    private String j;
    private String jk;
    private List<JSONObject> ju;
    private Set<String> k;
    private int kt;
    private int kx;
    private boolean l;
    private String lc;
    private int lg;
    private WebView lw;
    private Runnable m;
    private boolean n;
    private int nt;
    private boolean o;
    private int ot;
    private int ou;
    private int ov;
    private final String p;
    private String pc;
    private String pe;
    private int pl;
    private long q;
    private String qb;
    private long r;
    private int rb;
    private String rk;
    private long rm;
    private String rt;
    private String rw;
    private bf s;
    private vn sq;
    private Runnable t;
    public final String tg;
    private int tk;
    private d tu;
    private String tv;
    private int tx;
    private String ue;
    private long uk;
    private int uo;
    private int uq;
    private final Handler v;
    private int vd;
    private com.bytedance.sdk.openadsdk.bh.e vg;
    private int vl;
    private float vm;
    private final String vn;
    private boolean vr;
    private long vs;
    private int vu;
    private boolean w;
    private boolean wl;
    private Runnable wu;
    private long x;
    private Context xn;
    private String xo;
    private final Handler xu;
    private WeakReference<View> xy;
    private boolean y;
    private int ya;
    private int yf;
    private boolean yk;
    private String yl;
    private float yq;
    private String ys;
    private int z;
    private boolean za;
    private e zb;
    private Runnable zk;
    private boolean zm;
    private int zo;
    private JSONObject zr;
    private ViewTreeObserver.OnGlobalLayoutListener zw;

    public enum e {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    private v(Context context, WebView webView, d dVar, com.bytedance.sdk.openadsdk.bh.e eVar, e eVar2, boolean z) {
        this.vn = "playable_stuck_check_ping";
        this.p = "playable_apply_media_permission_callback";
        this.v = new Handler(Looper.getMainLooper());
        this.xu = new Handler(Looper.getMainLooper());
        this.w = true;
        this.l = true;
        this.f = true;
        this.e = "PL_sdk_playable_global_viewable";
        this.bf = "PL_sdk_page_screen_blank";
        this.d = "PL_sdk_playable_destroy_analyze_summary";
        this.tg = "PL_sdk_playable_hardware_dialog_cancel";
        this.ga = "PL_sdk_playable_hardware_dialog_setting";
        this.k = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.dt = null;
        this.pe = "embeded_ad";
        this.y = true;
        this.cv = true;
        this.wl = true;
        this.za = false;
        this.lc = "";
        this.f2101a = 10L;
        this.uk = 10L;
        this.fy = 700;
        this.h = 0L;
        this.x = 0L;
        this.hb = -1L;
        this.bx = -1L;
        this.bm = -1L;
        this.f2102b = -1L;
        this.r = -1L;
        this.rm = -1L;
        this.q = -1L;
        this.rt = "";
        this.j = "";
        this.i = "";
        this.yl = "";
        this.rb = 0;
        this.ot = 0;
        this.n = false;
        this.nt = 0;
        this.ya = -1;
        this.fl = 0;
        this.uq = 0;
        this.yf = 0;
        this.ue = null;
        this.ft = false;
        this.ov = 0;
        this.vu = 0;
        this.z = 0;
        this.ev = 0;
        this.vs = 0L;
        this.em = 0L;
        this.tx = -2;
        this.pl = 0;
        this.zo = 0;
        this.lg = 0;
        this.zr = new JSONObject();
        this.in = new HashMap();
        this.as = new JSONObject();
        this.br = "";
        this.ey = 0.0f;
        this.vm = 0.0f;
        this.fg = false;
        this.ay = false;
        this.o = false;
        this.ju = new ArrayList();
        this.zw = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.bh.v.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) v.this.xy.get();
                    if (view == null) {
                        return;
                    }
                    v.this.bf(view);
                } catch (Throwable th) {
                    p.e("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.tx = 0;
        this.zb = eVar2;
        this.lw = webView;
        zk.e(webView);
        if (!z) {
            e(webView);
        }
        e(context, dVar, eVar);
    }

    public static /* synthetic */ int bh(v vVar) {
        int i = vVar.ot;
        vVar.ot = i + 1;
        return i;
    }

    private void j() {
        Runnable runnable;
        Runnable runnable2;
        this.s.e(System.currentTimeMillis());
        Handler handler = this.xu;
        if (handler != null) {
            int i = this.tx;
            if (i == 0 && (runnable2 = this.bh) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.t) != null) {
                handler.post(runnable);
            }
            this.s.e(500);
        }
    }

    private void q() {
        this.s = new bf(this, this.fy);
        this.zk = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.3
            @Override // java.lang.Runnable
            public void run() {
                if (v.this.cv) {
                    v.this.cv = false;
                    v.this.v.removeCallbacks(v.this.m);
                    v.this.e(2, "容器加载超时");
                }
            }
        };
        this.m = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.4
            @Override // java.lang.Runnable
            public void run() {
                if (v.this.cv) {
                    v.this.cv = false;
                    v.this.v.removeCallbacks(v.this.zk);
                    v.this.e(3, "JSSDK加载超时");
                }
            }
        };
        this.bh = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.5
            @Override // java.lang.Runnable
            public void run() {
                p.e("mCheckJSRunnable", " ====定时任务=== " + System.currentTimeMillis());
                if (v.this.lw != null) {
                    v.this.lw.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.bh.v.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (v.this.s != null) {
                                v.this.s.e(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (v.this.xu != null) {
                    v.this.xu.postDelayed(this, 500L);
                }
            }
        };
        this.t = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.6
            @Override // java.lang.Runnable
            public void run() {
                p.e("mCheckJSRunnable", " ====Lynx检测定时任务=== " + System.currentTimeMillis());
                v.this.e("playable_stuck_check_ping", new JSONObject());
                if (v.this.xu != null) {
                    v.this.xu.postDelayed(this, 500L);
                }
            }
        };
        this.wu = new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.7
            @Override // java.lang.Runnable
            public void run() {
                if (v.this.em <= 0) {
                    v.this.bf(1, "点击热区卡死");
                } else {
                    if (v.this.em - v.this.vs > v.this.fy) {
                        v.this.bf(1, "点击热区卡死");
                        return;
                    }
                    v.this.bx();
                    v.this.vs = 0L;
                    v.this.em = 0L;
                }
            }
        };
    }

    private void rt() {
        String str;
        if (this.as == null || (str = this.jk) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.as.optString("cid");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.jk).getHost();
        if (TextUtils.isEmpty(host)) {
            this.jk += "/cid_" + strOptString;
            return;
        }
        this.jk = this.jk.replace(host, host + "/cid_" + strOptString);
    }

    public static /* synthetic */ int xu(v vVar) {
        int i = vVar.rb;
        vVar.rb = i + 1;
        return i;
    }

    public void a() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.v();
        }
    }

    public void b() {
        this.zo = 0;
        this.lg = 0;
        this.yq = 0.0f;
        this.en = 0;
        this.bc = 0;
        this.fa = 0;
        this.vd = 0;
        this.kt = 0;
        this.uo = 0;
        this.ou = 0;
        this.tk = 0;
        this.kx = 0;
        this.vl = 0;
    }

    public void bm() {
        try {
            bf bfVar = this.s;
            if (bfVar != null) {
                bfVar.e();
            }
            Handler handler = this.xu;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            p.e("Playable_CrashMonitor", "暂停卡顿检测发生crash -- " + th);
        }
    }

    public void bx() {
        if (this.wl) {
            this.rm = System.currentTimeMillis();
            if (this.zb == e.FEED_AWEME) {
                if (this.yk && this.pl == 3) {
                    bf bfVar = this.s;
                    if (bfVar != null && bfVar.bf()) {
                        j();
                        return;
                    } else {
                        if (this.s == null) {
                            this.s = new bf(this, this.fy);
                            j();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.yk && this.pl == 2) {
                bf bfVar2 = this.s;
                if (bfVar2 != null && bfVar2.bf()) {
                    j();
                } else if (this.s == null) {
                    this.s = new bf(this, this.fy);
                    j();
                }
            }
        }
    }

    public void cv() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.ga();
        }
        this.ya = 2;
    }

    public JSONObject dt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.yq);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", this.en);
            jSONObject2.put("height", this.bc);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.vd);
            jSONObject3.put("y", this.fa);
            jSONObject3.put("width", this.kt);
            jSONObject3.put("height", this.uo);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.tk);
            jSONObject4.put("y", this.ou);
            jSONObject4.put("width", this.kx);
            jSONObject4.put("height", this.vl);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public JSONObject f() {
        if (this.zr.isNull("width")) {
            View view = this.xy.get();
            if (view == null) {
                return this.zr;
            }
            bf(view);
        }
        return this.zr;
    }

    public void fy() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.m();
        }
    }

    public Context getContext() {
        return this.xn;
    }

    public void h() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.wu();
        }
    }

    public void hb() {
        this.v.removeCallbacks(this.zk);
        this.v.removeCallbacks(this.m);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.bm > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.bm);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            d("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.tg();
        }
    }

    public JSONObject k() {
        return this.as;
    }

    public com.bytedance.sdk.openadsdk.bh.e l() {
        return this.vg;
    }

    public void lc() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            if (this.zb != e.FEED_AWEME) {
                eVar.p();
                return;
            }
            int i = this.ya;
            if (i == 0 || i == 1) {
                return;
            }
            eVar.p();
        }
    }

    public void pe() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void r() {
        if (this.o) {
            return;
        }
        this.o = true;
        this.x = 0L;
        this.l = true;
        b();
        try {
            View view = this.xy.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.zw);
            }
        } catch (Throwable unused) {
        }
        try {
            this.sq.bf();
        } catch (Throwable unused2) {
        }
        try {
            bf bfVar = this.s;
            if (bfVar != null) {
                bfVar.e();
                this.s = null;
            }
            Handler handler = this.xu;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable th) {
            p.e("Playable_CrashMonitor", "发生crash -- " + th);
        }
        try {
            if (!TextUtils.isEmpty(this.jk)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.rb);
                jSONObject.put("playable_hit_times", this.ot);
                int i = this.rb;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.ot) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                d("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.jk)) {
                if (this.hb != -1) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.hb;
                    p.e("PlayablePlugin", "playable show time +" + jCurrentTimeMillis);
                    this.h = this.h + jCurrentTimeMillis;
                    this.hb = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.h);
                d("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused4) {
        }
        this.v.removeCallbacks(this.zk);
        this.v.removeCallbacks(this.m);
        this.v.removeCallbacksAndMessages(null);
    }

    public String rm() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    public Intent s() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileE = ga.e();
        if (fileE == null) {
            return null;
        }
        intent.putExtra(MscKeys.KEY_LOG_OUTPUT, FileProvider.getUriForFile(this.xn, this.xn.getPackageName() + ".playable.fileProvider", fileE));
        return intent;
    }

    public JSONObject t() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.zb.ordinal());
            jSONObject.put("safe_area_top_height", this.ey);
            jSONObject.put("safe_area_bottom_height", this.vm);
            jSONObject.put("playable_enter_from", this.uq);
            jSONObject.put("playable_retry_count", this.fl);
            jSONObject.put("playable_card_session", this.rt);
            jSONObject.put("playable_video_session", this.j);
            jSONObject.put("playable_network_type", w());
            jSONObject.put("aweme_id", this.yl);
            return jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public void uk() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.r > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.r);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.bm > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.bm);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            d("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public String w() {
        com.bytedance.sdk.openadsdk.bh.e eVar;
        if (TextUtils.isEmpty(this.i) && (eVar = this.vg) != null) {
            this.i = eVar.bf().toString();
        }
        return this.i;
    }

    public void wl() {
        this.ft = true;
    }

    public void x() {
        bf bfVar;
        this.em = System.currentTimeMillis();
        int i = this.tx;
        if ((i == 1 || i == 2) && (bfVar = this.s) != null) {
            bfVar.e(System.currentTimeMillis());
        }
    }

    public void y() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.bf(true);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.r > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.r);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.bm > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.bm;
                this.q = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            d("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void za() {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            if (this.zb != e.FEED_AWEME) {
                eVar.vn();
                return;
            }
            int i = this.ya;
            if (i == 0 || i == 1) {
                return;
            }
            eVar.vn();
        }
    }

    private boolean wu(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public JSONObject bh() {
        boolean zE;
        boolean zE2;
        try {
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 33) {
                zE = ga.e(this.xn, "android.permission.READ_MEDIA_IMAGES");
                zE2 = true;
            } else {
                zE = ga.e(this.xn, "android.permission.READ_EXTERNAL_STORAGE");
                zE2 = ga.e(this.xn, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", zE);
            jSONObject.put("isHasWrite", zE2);
            if (!zE || !zE2) {
                z = false;
            }
            jSONObject.put("result", z);
            return jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public v d(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("playable_style", str);
            this.aq = jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "setPlayableStyle error", th);
        }
        return this;
    }

    public String ga() {
        return this.c;
    }

    public void l(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.p(jSONObject);
        }
    }

    public Set<String> m() {
        Set<String> setE = this.sq.e();
        Set<String> set = this.k;
        if (set == null || set.size() <= 0) {
            return setE;
        }
        HashSet hashSet = new HashSet();
        for (String str : setE) {
            if (!this.k.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public boolean p() {
        return this.zm;
    }

    public String tg() {
        return this.tv;
    }

    public boolean v() {
        return this.yk;
    }

    public String vn() {
        return this.qb;
    }

    public JSONObject xu() {
        try {
            boolean zE = ga.e(this.xn, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zE);
            return jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject zk() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ah);
            return jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bf(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.zo == view.getWidth() && this.lg == view.getHeight()) {
                return;
            }
            this.zo = view.getWidth();
            this.lg = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", this.zo);
            jSONObject.put("height", this.lg);
            e("resize", jSONObject);
            this.zr = jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public v ga(String str) {
        this.qb = str;
        return this;
    }

    public void p(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.wu(jSONObject);
        }
    }

    public v tg(String str) {
        this.c = str;
        return this;
    }

    public void v(JSONObject jSONObject) {
        this.g = jSONObject;
        this.yf++;
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.xu(jSONObject);
        }
        bm();
        this.v.removeCallbacks(this.wu);
        if (this.wl) {
            this.rm = System.currentTimeMillis();
            this.vs = System.currentTimeMillis();
            this.em = 0L;
            int i = this.tx;
            if (i == 0) {
                WebView webView = this.lw;
                if (webView != null) {
                    webView.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.bh.v.8
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            v.this.em = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                e("playable_stuck_check_ping", new JSONObject());
            }
            this.v.postDelayed(this.wu, this.fy);
        }
    }

    public v vn(String str) {
        int iIndexOf;
        String strDecode;
        this.br = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!"http".equalsIgnoreCase(scheme) && !"https".equalsIgnoreCase(scheme)) {
                String host = uri.getHost();
                if (!"webview".equalsIgnoreCase(host) && (host == null || !host.contains("webview"))) {
                    if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                        if (this.tx == -1) {
                            bf(2);
                        } else {
                            bf(1);
                        }
                    }
                } else {
                    bf(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                }
            } else {
                bf(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            }
        } catch (Throwable unused) {
        }
        this.jk = str;
        return this;
    }

    public JSONObject wu() {
        try {
            boolean zE = ga.e(this.xn, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", zE);
            return jSONObject;
        } catch (Throwable th) {
            p.e("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public v ga(JSONObject jSONObject) {
        this.as = jSONObject;
        return this;
    }

    public v tg(boolean z) {
        this.ah = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.ah);
            e("change_playable_click", jSONObject);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    private void e(Context context, d dVar, com.bytedance.sdk.openadsdk.bh.e eVar) {
        this.dt = UUID.randomUUID().toString();
        this.xn = context;
        this.vg = eVar;
        this.tu = dVar;
        m.e(eVar);
        this.sq = new vn(this);
        q();
    }

    public v ga(boolean z) {
        this.wl = z;
        return this;
    }

    public void p(String str) {
        int i;
        int i2;
        this.pl = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.bm = jCurrentTimeMillis;
            long j = this.bx;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        d("PL_sdk_html_load_start", jSONObject);
        if (this.y && ((i = this.tx) == 0 || i == 1 || i == 2)) {
            this.v.postDelayed(this.zk, this.f2101a * 1000);
            if (wu(this.jk) || (i2 = this.tx) == 1 || i2 == 2) {
                this.v.postDelayed(this.m, this.uk * 1000);
            }
            this.y = false;
        }
        if (this.l) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (ga.e(this.xn, ga.xu)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (ga.bf(this.xn, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ga.e(this.xn, ga.wu)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ga.e(this.xn, ga.m)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ga.e(this.xn, ga.zk)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ga.e(this.xn, ga.v)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (ga.bf(this.xn, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (ga.e(this.xn, ga.p)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (ga.e(this.xn)) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_available_hardware_name", stringBuffer.toString());
                jSONObject2.put("playable_available_hardware_code", stringBuffer2.toString());
                jSONObject2.put("playable_available_hardware_auth_code", stringBuffer3.toString());
                d("PL_sdk_hardware_detect", jSONObject2);
                this.l = false;
            } catch (Throwable th2) {
                p.e("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void w(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.vn(jSONObject);
        }
    }

    private String ga(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.jk = str3;
        return str3;
    }

    public String d() {
        return this.rk;
    }

    public void zk(JSONObject jSONObject) {
        bf(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    private void ga(String str, JSONObject jSONObject) {
        try {
            int i = this.tx;
            if (i == 0) {
                if (this.zb != e.LAND_PAGE && !wu(this.jk)) {
                    rt();
                }
                jSONObject.put("playable_url", this.jk);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", ga(this.gm, this.pc));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", tg(this.xo, this.eb));
            }
            jSONObject.put("playable_render_type", this.tx);
            if (this.vg != null) {
                if (this.tx == 0 && (this.zb != e.LAND_PAGE || wu(this.jk))) {
                    p.e("PlayablePlugin", "reportJSSDKEvent by ActionProxy");
                    this.vg.e(jSONObject);
                } else if (this.tx != 0) {
                    p.e("PlayablePlugin", "reportJSSDKEvent by ActionProxy");
                    this.vg.e(jSONObject);
                } else {
                    p.e("PlayablePlugin", "reportJSSDKEvent error no not playable url");
                }
            }
        } catch (JSONException unused) {
        }
    }

    public v d(boolean z) {
        int i;
        int i2;
        if (this.yk == z) {
            return this;
        }
        this.yk = z;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.yk) {
                jSONObject.put("playable_background_show_type", this.vu);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        d(this.yk ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.bx == -1 && this.yk) {
            this.bx = System.currentTimeMillis();
            d("PL_sdk_page_show", (JSONObject) null);
            com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
            if (eVar != null && (((i2 = this.tx) == 0 || i2 == 1 || i2 == 2) && this.za)) {
                eVar.e(0);
            }
        }
        if (this.bx != -1 && !this.yk && !this.fg) {
            this.fg = true;
            com.bytedance.sdk.openadsdk.bh.e eVar2 = this.vg;
            if (eVar2 != null && (((i = this.tx) == 0 || i == 1 || i == 2) && this.za)) {
                eVar2.e(1);
            }
        }
        if (this.yk) {
            this.hb = System.currentTimeMillis();
        } else if (this.hb != -1) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.hb;
            p.e("PlayablePlugin", "playable show time +" + jCurrentTimeMillis);
            this.h = this.h + jCurrentTimeMillis;
            this.hb = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.yk);
            e("viewableChange", jSONObject2);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "setViewable error", th);
        }
        if (this.yk) {
            bx();
        } else {
            bm();
        }
        return this;
    }

    public void s(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.ga(jSONObject);
        }
    }

    public JSONObject xu(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return wu();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : bh();
        }
        return xu();
    }

    public void m(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.bh(jSONObject);
        }
    }

    public void wu(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.t(jSONObject);
        }
    }

    public void zk(String str) {
        this.v.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.10
            @Override // java.lang.Runnable
            public void run() {
                v.xu(v.this);
            }
        });
    }

    public void tg(JSONObject jSONObject) {
        if (this.vg != null) {
            try {
                this.vg.e(jSONObject.optBoolean("isPrevent", false));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void m(String str) {
        this.v.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.v.2
            @Override // java.lang.Runnable
            public void run() {
                v.bh(v.this);
            }
        });
    }

    public v bf(String str) {
        this.rk = str;
        return this;
    }

    public JSONObject bh(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            jSONObject2.put("result", ga.bf(this.xn, "android.permission.RECORD_AUDIO"));
        } else {
            if (iOptInt != 2) {
                if (iOptInt == 3) {
                    jSONObject2.put("result", ga.e(this.xn));
                }
                return jSONObject2;
            }
            jSONObject2.put("result", ga.bf(this.xn, "android.permission.CAMERA"));
        }
        return jSONObject2;
    }

    public void e(View view) {
        if (view == null) {
            return;
        }
        try {
            this.xy = new WeakReference<>(view);
            bf(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.zw);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    private String tg(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.ys) && !TextUtils.isEmpty(this.br)) {
            Uri uri = Uri.parse(this.br);
            String host = uri.getHost();
            if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                queryParameter = uri.getQueryParameter("surl");
                queryParameter2 = uri.getQueryParameter("playable_hash");
            } else {
                queryParameter = "";
                queryParameter2 = "";
            }
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(uri.getScheme()).authority(host).appendQueryParameter("surl", queryParameter);
            if (!TextUtils.isEmpty(queryParameter2)) {
                builderAppendQueryParameter.appendQueryParameter("playable_hash", queryParameter2);
            }
            this.ys = builderAppendQueryParameter.toString();
        }
        return this.ys;
    }

    public JSONObject bf() {
        return this.aq;
    }

    public void t(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.pl = 3;
                bx();
            } else {
                this.pl = -2;
                com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
                if (eVar != null) {
                    eVar.bf(false);
                }
            }
            if (zOptBoolean || !this.cv) {
                return;
            }
            this.cv = false;
            this.v.removeCallbacks(this.zk);
            this.v.removeCallbacks(this.m);
            e(4, "素材渲染失败");
        }
    }

    public v bf(boolean z) {
        this.vr = z;
        return this;
    }

    public v bf(long j) {
        if (j <= 0) {
            this.uk = 10L;
        } else {
            this.uk = j;
        }
        return this;
    }

    public v e(String str, String str2) {
        this.in.put(str, str2);
        return this;
    }

    public void bf(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            ga.d = jSONObject.optInt("video_min_duration", 1);
            ga.tg = jSONObject.optInt("video_max_duration", 20);
            ga.ga = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.bf(e(iOptInt));
        }
    }

    public Map<String, String> e() {
        return this.in;
    }

    public v e(String str) {
        this.tv = str;
        return this;
    }

    public void v(String str) {
        WebView webView;
        this.pl = 2;
        this.rw = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f2102b = jCurrentTimeMillis;
            long j = this.bm;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        d("PL_sdk_html_load_finish", jSONObject);
        this.v.removeCallbacks(this.zk);
        try {
            if (this.tx == 0) {
                if (this.w && (webView = this.lw) != null) {
                    this.w = false;
                    webView.evaluateJavascript(rm(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.bh.v.9
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str2) {
                            p.e("Playable_CrashMonitor", "加载注入js=" + str2);
                        }
                    });
                }
                bx();
            }
        } catch (Throwable th2) {
            p.e("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public v e(boolean z) {
        this.zm = z;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.zm);
            e("volumeChange", jSONObject);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public void vn(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ue = jSONObject.optString("section");
        }
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.m(jSONObject);
        }
    }

    public void bf(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.xn, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapBf = ga.bf(str2);
        if (bitmapBf != null) {
            MediaStore.Images.Media.insertImage(this.xn.getContentResolver(), bitmapBf, str, "");
            Toast.makeText(this.xn, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.xn, "照片保存失败", 0).show();
        }
    }

    public v e(long j) {
        if (j <= 0) {
            this.f2101a = 10L;
        } else {
            this.f2101a = j;
        }
        return this;
    }

    public JSONObject tg(String str, JSONObject jSONObject) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (p.e()) {
            StringBuilder sb = new StringBuilder();
            sb.append("PlayablePlugin JSB-REQ [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            p.e("PlayablePlugin", sb.toString());
        }
        JSONObject jSONObjectE = this.sq.e(str, jSONObject);
        if (p.e()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("PlayablePlugin JSB-RSP [");
            sb2.append(str);
            sb2.append("] time:");
            sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb2.append(" ");
            sb2.append(jSONObjectE != null ? jSONObjectE.toString() : "");
            p.e("PlayablePlugin", sb2.toString());
        }
        return jSONObjectE;
    }

    public void e(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.e(s());
        }
    }

    public Intent e(int i) {
        Intent intent = new Intent("android.intent.action.PICK");
        if (i == 0) {
            intent.setType("*/*");
        } else if (i == 1) {
            intent.setType("image/*");
        } else if (i == 2) {
            intent.setType(MimeTypes.VIDEO_MP4);
        } else {
            intent.setType("*/*");
        }
        return intent;
    }

    public v bf(int i) {
        this.tx = i;
        return this;
    }

    public void bf(int i, String str) {
        p.e("Playable_CrashMonitor", "-- 检测到页面卡顿 需要上报 卡顿类型：" + i);
        this.ya = i;
        if (this.g == null) {
            this.g = new JSONObject();
        }
        try {
            this.g.put("playable_stuck_type", i);
            this.g.put("playable_stuck_reason", str);
            if (this.rm > 0) {
                this.g.put("playable_stuck_duration", System.currentTimeMillis() - this.rm);
            } else {
                this.g.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        d("PL_sdk_page_stuck", this.g);
        bm();
        if (this.vg != null) {
            if (i == 2) {
                this.g = new JSONObject();
            }
            this.vg.zk(this.g);
        }
    }

    public void e(String str, JSONObject jSONObject) {
        if (p.e()) {
            StringBuilder sb = new StringBuilder();
            sb.append("CALL JS [");
            sb.append(str);
            sb.append("] ");
            sb.append(jSONObject != null ? jSONObject.toString() : "");
            p.e("PlayablePlugin", sb.toString());
        }
        d dVar = this.tu;
        if (dVar != null) {
            dVar.e(str, jSONObject);
        }
    }

    public void e(int i, String str) {
        bm();
        d(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "reportRenderFatal error", th);
        }
        d("PL_sdk_global_faild", jSONObject);
    }

    public void d(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar == null || eVar.v(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            bf(strOptString2, strOptString);
        } else if (iOptInt == 2) {
            d(strOptString2, strOptString);
        }
    }

    public void e(int i, String str, String str2) {
        this.pl = -1;
        this.rw = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "onWebReceivedError error", th);
        }
        d("PL_sdk_html_load_error", jSONObject);
        if (this.cv) {
            this.cv = false;
            this.v.removeCallbacks(this.zk);
            this.v.removeCallbacks(this.m);
            e(1, "容器加载失败");
        }
    }

    public void bf(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ga(str, jSONObject);
    }

    public void d(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.xn, "视频保存失败", 0).show();
            return;
        }
        File fileE = ga.e(str, str2);
        if (fileE != null && fileE.exists()) {
            Uri uriFromFile = Uri.fromFile(fileE);
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uriFromFile);
            this.xn.sendBroadcast(intent);
            Toast.makeText(this.xn, "视频已保存到相册", 0).show();
            return;
        }
        Toast.makeText(this.xn, "视频保存失败", 0).show();
    }

    private void d(int i, String str) {
        com.bytedance.sdk.openadsdk.bh.e eVar = this.vg;
        if (eVar != null) {
            eVar.e(i, str);
        }
    }

    public void e(boolean z, String str, int i) {
        if (z) {
            this.pl = -1;
            this.rw = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                p.e("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            d("PL_sdk_html_load_error", jSONObject);
            if (this.cv) {
                this.cv = false;
                this.v.removeCallbacks(this.zk);
                this.v.removeCallbacks(this.m);
                e(1, "容器加载失败");
            }
        }
    }

    public void d(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.n && this.ot > 0) {
                this.n = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.yk);
            jSONObject.put("playable_session_id", this.dt);
            int i = this.tx;
            if (i == 0) {
                if (this.zb != e.LAND_PAGE && !wu(this.jk)) {
                    rt();
                }
                jSONObject.put("playable_url", this.jk);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", ga(this.gm, this.pc));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", tg(this.xo, this.eb));
            }
            jSONObject.put("playable_full_url", this.br);
            jSONObject.put("playable_replay_count", this.nt);
            jSONObject.put("playable_is_prerender", this.vr);
            jSONObject.put("playable_is_preload", this.n);
            jSONObject.put("playable_render_type", this.tx);
            jSONObject.put("playable_scenes_type", this.zb.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.xo) ? "" : this.xo);
            if (!TextUtils.isEmpty(this.eb)) {
                str2 = this.eb;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.gm);
            jSONObject.put("playable_minigamelite_schema", this.pc);
            jSONObject.put("playable_is_debug", this.ay);
            jSONObject.put("playable_retry_count", this.fl);
            jSONObject.put("playable_enter_from", this.uq);
            jSONObject.put("playable_sequence", this.yf);
            jSONObject.put("playable_current_section", this.ue);
            jSONObject.put("is_playable_finish", this.ft);
            jSONObject.put("playable_card_session", this.rt);
            jSONObject.put("playable_video_session", this.j);
            jSONObject.put("playable_network_type", w());
            jSONObject.put("playable_lynx_version", this.lc);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            jSONObject2.put("tag", this.pe);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", BaseConstants.CATEGORY_UMENG);
            jSONObject2.put(BaseConstants.EVENT_LABEL_IS_AD_EVENT, "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.as.opt("cid"));
            jSONObject2.put(BaseConstants.EVENT_LABEL_LOG_EXTRA, this.as.opt(BaseConstants.EVENT_LABEL_LOG_EXTRA));
            int i2 = this.tx;
            if (i2 != -1 && i2 != -2) {
                if (this.vg != null) {
                    List<JSONObject> list = this.ju;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.ju.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.tx);
                                jSONObjectOptJSONObject.put("playable_url", this.jk);
                            }
                            this.vg.e(jSONObjectOptJSONObject);
                        }
                        this.ju.clear();
                    }
                    if (this.tx == 0 && (this.zb != e.LAND_PAGE || wu(this.jk))) {
                        p.e("PlayablePlugin", "reportEvent by ActionProxy");
                        this.vg.e(jSONObject);
                        return;
                    } else if (this.tx != 0) {
                        p.e("PlayablePlugin", "reportEvent by ActionProxy");
                        this.vg.e(jSONObject);
                        return;
                    } else {
                        p.e("PlayablePlugin", "reportEvent error no not playable url");
                        return;
                    }
                }
                p.e("PlayablePlugin", "reportEvent error no impl");
                return;
            }
            if (this.ju == null) {
                this.ju = new ArrayList();
            }
            this.ju.add(jSONObject2);
        } catch (Throwable th) {
            p.e("PlayablePlugin", "reportEvent error", th);
        }
    }

    public static v e(Context context, WebView webView, d dVar, com.bytedance.sdk.openadsdk.bh.e eVar, Set<String> set, e eVar2, boolean z) {
        if (webView == null || dVar == null || eVar == null) {
            return null;
        }
        return new v(context, webView, dVar, eVar, set, eVar2, z);
    }

    private v(Context context, WebView webView, d dVar, com.bytedance.sdk.openadsdk.bh.e eVar, Set<String> set, e eVar2, boolean z) {
        this(context, webView, dVar, eVar, eVar2, z);
        this.k = set;
    }
}
