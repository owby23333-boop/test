package com.bytedance.sdk.openadsdk.v;

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
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
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

/* JADX INFO: loaded from: classes2.dex */
public class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1488a;
    private int b;
    private String bb;
    private Context bm;
    private int bv;
    private int bw;
    private String by;
    private float cb;
    private int dh;
    public final String dl;
    private int dt;
    private final String e;
    private int ec;
    private long eo;
    private String f;
    private Runnable fo;
    private boolean fp;
    private boolean fv;
    public final String g;
    private int gb;
    public final String gc;
    private long gk;
    private boolean gm;
    private String gp;
    private int gy;
    private final Handler gz;
    private int h;
    private ViewTreeObserver.OnGlobalLayoutListener he;
    private long hh;
    private String hn;
    private int hy;
    private Runnable i;
    private boolean io;
    private boolean iq;
    private String j;
    private m ja;
    private List<JSONObject> jc;
    private int jq;
    private Set<String> js;
    private String jz;
    private String k;
    private Runnable kb;
    private boolean kp;
    private long l;
    private boolean li;
    private JSONObject lk;
    private long lq;
    private boolean ls;
    private String lt;
    private int lw;
    private String ly;
    private final String m;
    private long mc;
    private JSONObject me;
    private boolean mn;
    private JSONObject n;
    private String na;
    private dl nb;
    private int nh;
    private float o;
    private long oq;
    private String oz;
    private boolean p;
    private boolean pd;
    private g pf;
    private String q;
    private int qd;
    private int r;
    private long rv;
    private Map<String, String> s;
    private com.bytedance.sdk.component.i.dl sd;
    private String sf;
    private int sv;
    private String sy;
    private int t;
    private String tb;
    private long tc;
    private int te;
    private WeakReference<View> tf;
    private long ti;
    private String u;
    private boolean uf;
    private long un;
    private Runnable uy;
    private Runnable v;
    private int vm;
    private int vo;
    private boolean vt;
    private long wj;
    private com.bytedance.sdk.openadsdk.v.z wn;
    private String wo;
    private final Handler wp;
    private JSONObject wx;
    private long x;
    private int xf;
    private String xl;
    private int xo;
    private boolean y;
    private float yt;
    private String yw;
    private boolean yx;
    private z yz;
    public final String z;
    private int zb;
    private int zd;
    private boolean zw;
    private int zx;
    private int zz;

    public enum z {
        LAND_PAGE,
        FEED,
        OTHER,
        FEED_AWEME
    }

    public String un() {
        return "function playable_callJS(){return \"Android调用了JS的callJS方法\";}";
    }

    static /* synthetic */ int i(gz gzVar) {
        int i = gzVar.vm;
        gzVar.vm = i + 1;
        return i;
    }

    static /* synthetic */ int wp(gz gzVar) {
        int i = gzVar.t;
        gzVar.t = i + 1;
        return i;
    }

    private gz(Context context, com.bytedance.sdk.component.i.dl dlVar, dl dlVar2, com.bytedance.sdk.openadsdk.v.z zVar, z zVar2, boolean z2) {
        this.m = "playable_stuck_check_ping";
        this.e = "playable_apply_media_permission_callback";
        this.gz = new Handler(Looper.getMainLooper());
        this.wp = new Handler(Looper.getMainLooper());
        this.ls = true;
        this.p = true;
        this.fv = true;
        this.z = "PL_sdk_playable_global_viewable";
        this.g = "PL_sdk_page_screen_blank";
        this.dl = "PL_sdk_playable_destroy_analyze_summary";
        this.f1488a = "PL_sdk_playable_hardware_dialog_cancel";
        this.gc = "PL_sdk_playable_hardware_dialog_setting";
        this.js = new HashSet(Arrays.asList("adInfo", "appInfo", "subscribe_app_ad", "download_app_ad"));
        this.tb = null;
        this.q = "embeded_ad";
        this.iq = true;
        this.zw = true;
        this.io = true;
        this.uf = false;
        this.sy = "";
        this.hh = 10L;
        this.l = 10L;
        this.h = 700;
        this.gk = 0L;
        this.x = 0L;
        this.lq = -1L;
        this.mc = -1L;
        this.un = -1L;
        this.ti = -1L;
        this.eo = -1L;
        this.oq = -1L;
        this.wj = -1L;
        this.na = "";
        this.xl = "";
        this.j = "";
        this.gp = "";
        this.t = 0;
        this.vm = 0;
        this.y = false;
        this.ec = 0;
        this.bv = -1;
        this.gb = 0;
        this.jq = 0;
        this.sv = 0;
        this.f = null;
        this.yx = false;
        this.qd = 0;
        this.zx = 0;
        this.b = 0;
        this.lw = 0;
        this.rv = 0L;
        this.tc = 0L;
        this.nh = -2;
        this.r = 0;
        this.zz = 0;
        this.vo = 0;
        this.lk = new JSONObject();
        this.s = new HashMap();
        this.n = new JSONObject();
        this.k = "";
        this.cb = 0.0f;
        this.o = 0.0f;
        this.vt = false;
        this.mn = false;
        this.li = false;
        this.jc = new ArrayList();
        this.he = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.v.gz.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                try {
                    View view = (View) gz.this.tf.get();
                    if (view == null) {
                        return;
                    }
                    gz.this.g(view);
                } catch (Throwable th) {
                    e.z("PlayablePlugin", "onSizeChanged error", th);
                }
            }
        };
        this.nh = 0;
        this.yz = zVar2;
        this.sd = dlVar;
        fo.z(dlVar);
        if (!z2) {
            z(dlVar.getView());
        }
        z(context, dlVar2, zVar);
    }

    private gz(Context context, com.bytedance.sdk.component.i.dl dlVar, dl dlVar2, com.bytedance.sdk.openadsdk.v.z zVar, Set<String> set, z zVar2, boolean z2) {
        this(context, dlVar, dlVar2, zVar, zVar2, z2);
        this.js = set;
    }

    private void z(Context context, dl dlVar, com.bytedance.sdk.openadsdk.v.z zVar) {
        this.tb = UUID.randomUUID().toString();
        this.bm = context;
        this.wn = zVar;
        this.nb = dlVar;
        uy.z(zVar);
        this.ja = new m(this);
        ti();
    }

    private void ti() {
        this.pf = new g(this, this.h);
        this.fo = new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.3
            @Override // java.lang.Runnable
            public void run() {
                if (gz.this.zw) {
                    gz.this.zw = false;
                    gz.this.gz.removeCallbacks(gz.this.uy);
                    gz.this.z(2, "容器加载超时");
                }
            }
        };
        this.uy = new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.4
            @Override // java.lang.Runnable
            public void run() {
                if (gz.this.zw) {
                    gz.this.zw = false;
                    gz.this.gz.removeCallbacks(gz.this.fo);
                    gz.this.z(3, "JSSDK加载超时");
                }
            }
        };
        this.i = new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.5
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (gz.this.sd != null) {
                    gz.this.sd.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.v.gz.5.1
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            if (gz.this.pf != null) {
                                gz.this.pf.z(System.currentTimeMillis());
                            }
                        }
                    });
                }
                if (gz.this.wp != null) {
                    gz.this.wp.postDelayed(this, 500L);
                }
            }
        };
        this.v = new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.6
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                gz.this.z("playable_stuck_check_ping", new JSONObject());
                if (gz.this.wp != null) {
                    gz.this.wp.postDelayed(this, 500L);
                }
            }
        };
        this.kb = new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.7
            @Override // java.lang.Runnable
            public void run() {
                if (gz.this.tc <= 0) {
                    gz.this.g(1, "点击热区卡死");
                } else {
                    if (gz.this.tc - gz.this.rv <= gz.this.h) {
                        gz.this.gk();
                        gz.this.rv = 0L;
                        gz.this.tc = 0L;
                        return;
                    }
                    gz.this.g(1, "点击热区卡死");
                }
            }
        };
    }

    private boolean uy(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("/union-fe/playable/") || str.contains("/union-fe-sg/playable/") || str.contains("/union-fe-i18n/playable/");
    }

    public void z(View view) {
        if (view == null) {
            return;
        }
        try {
            this.tf = new WeakReference<>(view);
            g(view);
            view.getViewTreeObserver().addOnGlobalLayoutListener(this.he);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "setViewForScreenSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(View view) {
        if (view == null) {
            return;
        }
        try {
            if (this.zz == view.getWidth() && this.vo == view.getHeight()) {
                return;
            }
            this.zz = view.getWidth();
            this.vo = view.getHeight();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediaFormat.KEY_WIDTH, this.zz);
            jSONObject.put(MediaFormat.KEY_HEIGHT, this.vo);
            z("resize", jSONObject);
            this.lk = jSONObject;
        } catch (Throwable th) {
            e.z("PlayablePlugin", "resetViewDataJsonByView error", th);
        }
    }

    public Context getContext() {
        return this.bm;
    }

    public gz z(String str, String str2) {
        this.s.put(str, str2);
        return this;
    }

    public Map<String, String> z() {
        return this.s;
    }

    public gz z(String str) {
        this.u = str;
        return this;
    }

    public gz g(String str) {
        this.sf = str;
        return this;
    }

    public JSONObject g() {
        return this.wx;
    }

    public String dl() {
        return this.sf;
    }

    public String a() {
        return this.u;
    }

    public gz dl(String str) {
        this.yw = str;
        return this;
    }

    public String gc() {
        return this.yw;
    }

    public gz a(String str) {
        this.lt = str;
        return this;
    }

    public String m() {
        return this.lt;
    }

    public gz z(boolean z2) {
        this.kp = z2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("endcard_mute", this.kp);
            z("volumeChange", jSONObject);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "setIsMute error", th);
        }
        return this;
    }

    public boolean e() {
        return this.kp;
    }

    public gz z(long j) {
        if (j <= 0) {
            this.hh = 10L;
        } else {
            this.hh = j;
        }
        return this;
    }

    public gz g(long j) {
        if (j <= 0) {
            this.l = 10L;
        } else {
            this.l = j;
        }
        return this;
    }

    public gz g(boolean z2) {
        if (this.fp == z2) {
            return this;
        }
        this.fp = z2;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!this.fp) {
                jSONObject.put("playable_background_show_type", this.zx);
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        dl(this.fp ? "PL_sdk_viewable_true" : "PL_sdk_viewable_false", jSONObject);
        if (this.mc == -1 && this.fp) {
            this.mc = System.currentTimeMillis();
            dl("PL_sdk_page_show", (JSONObject) null);
        }
        if (this.mc != -1 && !this.fp && !this.vt) {
            this.vt = true;
        }
        if (this.fp) {
            this.lq = System.currentTimeMillis();
        } else if (this.lq != -1) {
            this.gk += System.currentTimeMillis() - this.lq;
            this.lq = -1L;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("viewStatus", this.fp);
            z("viewableChange", jSONObject2);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "setViewable error", th);
        }
        if (this.fp) {
            gk();
        } else {
            x();
        }
        return this;
    }

    public boolean gz() {
        return this.fp;
    }

    public gz dl(boolean z2) {
        this.pd = z2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.pd);
            z("change_playable_click", jSONObject);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "setPlayableClick error", th);
        }
        return this;
    }

    public JSONObject fo() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("send_click", this.pd);
            return jSONObject;
        } catch (Throwable th) {
            e.z("PlayablePlugin", "getPlayableClickStatus error", th);
            return new JSONObject();
        }
    }

    public Set<String> uy() {
        Set<String> setZ = this.ja.z();
        Set<String> set = this.js;
        if (set == null || set.size() <= 0) {
            return setZ;
        }
        HashSet hashSet = new HashSet();
        for (String str : setZ) {
            if (!this.js.contains(str)) {
                hashSet.add(str);
            }
        }
        return hashSet;
    }

    public JSONObject kb() {
        try {
            boolean z2 = gc.z(this.bm, "android.permission.RECORD_AUDIO");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", z2);
            return jSONObject;
        } catch (Throwable th) {
            e.z("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject wp() {
        try {
            boolean z2 = gc.z(this.bm, "android.permission.CAMERA");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("result", z2);
            return jSONObject;
        } catch (Throwable th) {
            e.z("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public JSONObject i() {
        boolean z2;
        boolean z3;
        try {
            boolean z4 = true;
            if (Build.VERSION.SDK_INT >= 33) {
                z2 = gc.z(this.bm, "android.permission.READ_MEDIA_IMAGES");
                z3 = true;
            } else {
                z2 = gc.z(this.bm, com.kuaishou.weapon.p0.g.i);
                z3 = gc.z(this.bm, com.kuaishou.weapon.p0.g.j);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("isHasRead", z2);
            jSONObject.put("isHasWrite", z3);
            if (!z2 || !z3) {
                z4 = false;
            }
            jSONObject.put("result", z4);
            return jSONObject;
        } catch (Throwable th) {
            e.z("PlayablePlugin", "getCameraPermission error", th);
            return new JSONObject();
        }
    }

    public void z(JSONObject jSONObject) {
        if (this.wn != null) {
            pf();
        }
    }

    public void g(JSONObject jSONObject) {
        int iOptInt = 0;
        if (jSONObject != null) {
            iOptInt = jSONObject.optInt("resource_type", 0);
            gc.dl = jSONObject.optInt("video_min_duration", 1);
            gc.f1487a = jSONObject.optInt("video_max_duration", 20);
            gc.gc = Math.min(jSONObject.optLong("video_max_size", 15360L), 15360L);
        }
        if (this.wn != null) {
            z(iOptInt);
        }
    }

    public void dl(JSONObject jSONObject) throws Throwable {
        com.bytedance.sdk.openadsdk.v.z zVar = this.wn;
        if (zVar == null || zVar.z(jSONObject) || jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("resource_base64");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        int iOptInt = jSONObject.optInt("resource_type", -1);
        String strOptString2 = jSONObject.optString("resource_name", "playable_media");
        if (iOptInt == 1) {
            g(strOptString2, strOptString);
        } else if (iOptInt == 2) {
            dl(strOptString2, strOptString);
        }
    }

    public void a(JSONObject jSONObject) {
        if (this.wn != null) {
            try {
                jSONObject.optBoolean("isPrevent", false);
            } catch (Exception e) {
                wp.z(e);
            }
        }
    }

    public JSONObject v() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("scene_type", this.yz.ordinal());
            jSONObject.put("safe_area_top_height", this.cb);
            jSONObject.put("safe_area_bottom_height", this.o);
            jSONObject.put("playable_enter_from", this.jq);
            jSONObject.put("playable_retry_count", this.gb);
            jSONObject.put("playable_card_session", this.na);
            jSONObject.put("playable_video_session", this.xl);
            jSONObject.put("playable_network_type", ls());
            jSONObject.put("aweme_id", this.gp);
            return jSONObject;
        } catch (Throwable th) {
            e.z("PlayablePlugin", "playableInfo error", th);
            return new JSONObject();
        }
    }

    public Intent pf() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File fileZ = gc.z();
        if (fileZ == null) {
            return null;
        }
        intent.putExtra("output", FileProvider.getUriForFile(this.bm, this.bm.getPackageName() + ".playable.fileProvider", fileZ));
        return intent;
    }

    public Intent z(int i) {
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

    public void z(String str, JSONObject jSONObject) {
        dl dlVar = this.nb;
        if (dlVar != null) {
            dlVar.z(str, jSONObject);
        }
    }

    public void g(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.bm, "照片保存失败", 0).show();
            return;
        }
        Bitmap bitmapG = gc.g(str2);
        if (bitmapG != null) {
            MediaStore.Images.Media.insertImage(this.bm.getContentResolver(), bitmapG, str, "");
            Toast.makeText(this.bm, "照片已保存到相册", 0).show();
        } else {
            Toast.makeText(this.bm, "照片保存失败", 0).show();
        }
    }

    public void dl(String str, String str2) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.bm, "视频保存失败", 0).show();
            return;
        }
        File fileZ = gc.z(str, str2);
        if (fileZ == null || !fileZ.exists()) {
            Toast.makeText(this.bm, "视频保存失败", 0).show();
            return;
        }
        Uri uriFromFile = Uri.fromFile(fileZ);
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(uriFromFile);
        this.bm.sendBroadcast(intent);
        Toast.makeText(this.bm, "视频已保存到相册", 0).show();
    }

    public String ls() {
        com.bytedance.sdk.openadsdk.v.z zVar;
        if (TextUtils.isEmpty(this.j) && (zVar = this.wn) != null) {
            this.j = zVar.a().toString();
        }
        return this.j;
    }

    public com.bytedance.sdk.openadsdk.v.z p() {
        return this.wn;
    }

    public JSONObject fv() {
        if (this.lk.isNull(MediaFormat.KEY_WIDTH)) {
            View view = this.tf.get();
            if (view == null) {
                return this.lk;
            }
            g(view);
        }
        return this.lk;
    }

    public JSONObject js() {
        return this.n;
    }

    public gz gc(JSONObject jSONObject) {
        this.n = jSONObject;
        return this;
    }

    public gz gc(String str) {
        int iIndexOf;
        String strDecode;
        this.k = str;
        try {
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                g(0);
                if (str != null && (iIndexOf = str.indexOf("?")) != -1) {
                    str = str.substring(0, iIndexOf);
                }
            } else {
                String host = uri.getHost();
                if ("webview".equalsIgnoreCase(host) || (host != null && host.contains("webview"))) {
                    g(0);
                    String queryParameter = uri.getQueryParameter("url");
                    if (!TextUtils.isEmpty(queryParameter) && (strDecode = Uri.decode(queryParameter)) != null) {
                        int iIndexOf2 = strDecode.indexOf("?");
                        str = iIndexOf2 != -1 ? strDecode.substring(0, iIndexOf2) : strDecode;
                    }
                } else if ("lynxview".equalsIgnoreCase(host) || (host != null && host.contains("lynxview"))) {
                    if (this.nh == -1) {
                        g(2);
                    } else {
                        g(1);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.ly = str;
        return this;
    }

    public gz g(int i) {
        this.nh = i;
        return this;
    }

    public gz a(boolean z2) {
        this.io = z2;
        return this;
    }

    public JSONObject tb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devicePixelRatio", this.yt);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MediaFormat.KEY_WIDTH, this.dt);
            jSONObject2.put(MediaFormat.KEY_HEIGHT, this.xo);
            jSONObject.put("screen", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("x", this.bw);
            jSONObject3.put("y", this.xf);
            jSONObject3.put(MediaFormat.KEY_WIDTH, this.gy);
            jSONObject3.put(MediaFormat.KEY_HEIGHT, this.dh);
            jSONObject.put("webview", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("x", this.zd);
            jSONObject4.put("y", this.zb);
            jSONObject4.put(MediaFormat.KEY_WIDTH, this.te);
            jSONObject4.put(MediaFormat.KEY_HEIGHT, this.hy);
            jSONObject.put("visible", jSONObject4);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "getViewport error", th);
        }
        return jSONObject;
    }

    public void q() {
        com.bytedance.sdk.openadsdk.v.z zVar = this.wn;
        if (zVar != null) {
            zVar.z();
        }
    }

    public void iq() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.eo > 0) {
                jSONObject.put("playable_material_interactable_duration", System.currentTimeMillis() - this.eo);
            } else {
                jSONObject.put("playable_material_interactable_duration", 0L);
            }
            if (this.un > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.un;
                this.wj = jCurrentTimeMillis;
                jSONObject.put("playable_material_interactable_load_duration", jCurrentTimeMillis);
            } else {
                jSONObject.put("playable_material_interactable_load_duration", 0L);
            }
            dl("PL_sdk_material_interactable", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void m(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f = jSONObject.optString("section");
        }
    }

    public void zw() {
        this.bv = 2;
    }

    public void io() {
        this.yx = true;
    }

    public void uf() {
        if (this.wn != null) {
            z zVar = z.FEED_AWEME;
        }
    }

    public void sy() {
        if (this.wn != null) {
            z zVar = z.FEED_AWEME;
        }
    }

    public void e(JSONObject jSONObject) {
        this.me = jSONObject;
        this.sv++;
        x();
        this.gz.removeCallbacks(this.kb);
        if (this.io) {
            this.oq = System.currentTimeMillis();
            this.rv = System.currentTimeMillis();
            this.tc = 0L;
            int i = this.nh;
            if (i == 0) {
                com.bytedance.sdk.component.i.dl dlVar = this.sd;
                if (dlVar != null) {
                    dlVar.evaluateJavascript("javascript:typeof playable_callJS === 'function' && playable_callJS()", new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.v.gz.8
                        @Override // android.webkit.ValueCallback
                        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                        public void onReceiveValue(String str) {
                            gz.this.tc = System.currentTimeMillis();
                        }
                    });
                }
            } else if (i == 1 || i == 2) {
                z("playable_stuck_check_ping", new JSONObject());
            }
            this.gz.postDelayed(this.kb, this.h);
        }
    }

    public void hh() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.eo > 0) {
                jSONObject.put("playable_material_first_frame_show_duration", System.currentTimeMillis() - this.eo);
            } else {
                jSONObject.put("playable_material_first_frame_show_duration", 0L);
            }
            if (this.un > 0) {
                jSONObject.put("playable_material_first_frame_load_duration", System.currentTimeMillis() - this.un);
            } else {
                jSONObject.put("playable_material_first_frame_load_duration", 0L);
            }
            dl("PL_sdk_material_first_frame_show", jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void gz(JSONObject jSONObject) {
        g(2, jSONObject != null ? jSONObject.optString("error_msg", "素材直接调用端上异常兜底蒙层") : "素材直接调用端上异常兜底蒙层");
    }

    public void l() {
        g gVar;
        this.tc = System.currentTimeMillis();
        int i = this.nh;
        if ((i == 1 || i == 2) && (gVar = this.pf) != null) {
            gVar.z(System.currentTimeMillis());
        }
    }

    public JSONObject fo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            return kb();
        }
        if (iOptInt != 2) {
            return iOptInt != 3 ? jSONObject2 : i();
        }
        return wp();
    }

    public JSONObject uy(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        int iOptInt = jSONObject.optInt("type", 0);
        JSONObject jSONObject2 = new JSONObject();
        if (iOptInt == 1) {
            jSONObject2.put("result", gc.g(this.bm, "android.permission.RECORD_AUDIO"));
        } else {
            if (iOptInt != 2) {
                if (iOptInt == 3) {
                    jSONObject2.put("result", gc.z(this.bm));
                }
                return jSONObject2;
            }
            jSONObject2.put("result", gc.g(this.bm, "android.permission.CAMERA"));
        }
        return jSONObject2;
    }

    public void m(String str) {
        int i;
        int i2;
        this.r = 1;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.un = jCurrentTimeMillis;
            long j = this.mc;
            jSONObject.put("playable_page_show_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "reportUrlLoadStart error", th);
        }
        dl("PL_sdk_html_load_start", jSONObject);
        if (this.iq && ((i = this.nh) == 0 || i == 1 || i == 2)) {
            this.gz.postDelayed(this.fo, this.hh * 1000);
            if (uy(this.ly) || (i2 = this.nh) == 1 || i2 == 2) {
                this.gz.postDelayed(this.uy, this.l * 1000);
            }
            this.iq = false;
        }
        if (this.p) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                StringBuffer stringBuffer2 = new StringBuffer();
                StringBuffer stringBuffer3 = new StringBuffer();
                if (gc.z(this.bm, gc.wp)) {
                    stringBuffer.append("Microphone_");
                    stringBuffer2.append("1");
                    if (gc.g(this.bm, "android.permission.RECORD_AUDIO")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (gc.z(this.bm, gc.kb)) {
                    stringBuffer.append("Magetometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (gc.z(this.bm, gc.uy)) {
                    stringBuffer.append("Accelerometer_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (gc.z(this.bm, gc.fo)) {
                    stringBuffer.append("Gyro_");
                    stringBuffer2.append("1");
                    stringBuffer3.append("1");
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (gc.z(this.bm, gc.gz)) {
                    stringBuffer.append("Camera_");
                    stringBuffer2.append("1");
                    if (gc.g(this.bm, "android.permission.CAMERA")) {
                        stringBuffer3.append("1");
                    } else {
                        stringBuffer3.append("0");
                    }
                } else {
                    stringBuffer2.append("0");
                    stringBuffer3.append("0");
                }
                if (gc.z(this.bm, gc.e)) {
                    stringBuffer.append("Photo");
                    stringBuffer2.append("1");
                    if (gc.z(this.bm)) {
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
                dl("PL_sdk_hardware_detect", jSONObject2);
                this.p = false;
            } catch (Throwable th2) {
                e.z("PlayablePlugin", "Hardware detect error", th2);
            }
        }
    }

    public void e(String str) {
        com.bytedance.sdk.component.i.dl dlVar;
        this.r = 2;
        this.hn = str;
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.ti = jCurrentTimeMillis;
            long j = this.un;
            jSONObject.put("playable_html_load_start_duration", j != -1 ? jCurrentTimeMillis - j : 0L);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "reportUrlLoadFinish error", th);
        }
        dl("PL_sdk_html_load_finish", jSONObject);
        this.gz.removeCallbacks(this.fo);
        try {
            if (this.nh == 0) {
                if (this.ls && (dlVar = this.sd) != null) {
                    this.ls = false;
                    dlVar.evaluateJavascript(un(), new ValueCallback<String>() { // from class: com.bytedance.sdk.openadsdk.v.gz.9
                        @Override // android.webkit.ValueCallback
                        public /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                        }
                    });
                }
                gk();
            }
        } catch (Throwable th2) {
            e.z("PlayablePlugin", "crashMonitor error", th2);
        }
    }

    public void h() {
        this.gz.removeCallbacks(this.fo);
        this.gz.removeCallbacks(this.uy);
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.un > 0) {
                jSONObject.put("playable_jssdk_load_success_duration", System.currentTimeMillis() - this.un);
            } else {
                jSONObject.put("playable_jssdk_load_success_duration", 0L);
            }
            dl("PL_sdk_jssdk_load_success", jSONObject);
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    public void kb(JSONObject jSONObject) {
        if (jSONObject != null) {
            boolean zOptBoolean = jSONObject.optBoolean("success", true);
            if (zOptBoolean) {
                this.r = 3;
                gk();
            } else {
                this.r = -2;
            }
            if (zOptBoolean || !this.zw) {
                return;
            }
            this.zw = false;
            this.gz.removeCallbacks(this.fo);
            this.gz.removeCallbacks(this.uy);
            z(4, "素材渲染失败");
        }
    }

    private void dl(int i, String str) {
        com.bytedance.sdk.openadsdk.v.z zVar = this.wn;
        if (zVar != null) {
            zVar.z(i, str);
        }
    }

    protected void z(int i, String str) {
        x();
        dl(i, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "reportRenderFatal error", th);
        }
        dl("PL_sdk_global_faild", jSONObject);
    }

    public void g(int i, String str) {
        this.bv = i;
        if (this.me == null) {
            this.me = new JSONObject();
        }
        try {
            this.me.put("playable_stuck_type", i);
            this.me.put("playable_stuck_reason", str);
            if (this.oq > 0) {
                this.me.put("playable_stuck_duration", System.currentTimeMillis() - this.oq);
            } else {
                this.me.put("playable_stuck_duration", 0L);
            }
        } catch (Throwable unused) {
        }
        dl("PL_sdk_page_stuck", this.me);
        x();
        if (this.wn == null || i != 2) {
            return;
        }
        this.me = new JSONObject();
    }

    protected void g(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        gc(str, jSONObject);
    }

    private String a(String str, String str2) {
        String queryParameter;
        String queryParameter2;
        if (TextUtils.isEmpty(this.wo) && !TextUtils.isEmpty(this.k)) {
            Uri uri = Uri.parse(this.k);
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
            this.wo = builderAppendQueryParameter.toString();
        }
        return this.wo;
    }

    private String gc(String str, String str2) {
        String str3 = String.format("rubeex://playable-minigamelite?id=%1s&schema=%2s", str, Uri.encode(str2));
        this.ly = str3;
        return str3;
    }

    private void eo() {
        String str;
        if (this.n == null || (str = this.ly) == null || str.contains("/cid_")) {
            return;
        }
        String strOptString = this.n.optString(CmcdConfiguration.KEY_CONTENT_ID);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        String host = Uri.parse(this.ly).getHost();
        if (TextUtils.isEmpty(host)) {
            this.ly += "/cid_" + strOptString;
        } else {
            this.ly = this.ly.replace(host, host + "/cid_" + strOptString);
        }
    }

    private void gc(String str, JSONObject jSONObject) {
        try {
            int i = this.nh;
            if (i == 0) {
                if (this.yz != z.LAND_PAGE && !uy(this.ly)) {
                    eo();
                }
                jSONObject.put("playable_url", this.ly);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", gc(this.bb, this.by));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", a(this.jz, this.oz));
            }
            jSONObject.put("playable_render_type", this.nh);
            if (this.wn != null && this.nh == 0 && this.yz == z.LAND_PAGE) {
                uy(this.ly);
            }
        } catch (JSONException unused) {
        }
    }

    public void dl(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            if (!this.y && this.vm > 0) {
                this.y = true;
            }
            jSONObject.put("playable_event", str);
            jSONObject.put("playable_ts", System.currentTimeMillis());
            jSONObject.put("playable_viewable", this.fp);
            jSONObject.put("playable_session_id", this.tb);
            int i = this.nh;
            if (i == 0) {
                if (this.yz != z.LAND_PAGE && !uy(this.ly)) {
                    eo();
                }
                jSONObject.put("playable_url", this.ly);
            } else if (i == 3 || i == 4) {
                jSONObject.put("playable_url", gc(this.bb, this.by));
            } else if (i == 1 || i == 2) {
                jSONObject.put("playable_url", a(this.jz, this.oz));
            }
            jSONObject.put("playable_full_url", this.k);
            jSONObject.put("playable_replay_count", this.ec);
            jSONObject.put("playable_is_prerender", this.gm);
            jSONObject.put("playable_is_preload", this.y);
            jSONObject.put("playable_render_type", this.nh);
            jSONObject.put("playable_scenes_type", this.yz.ordinal());
            String str2 = "";
            jSONObject.put("playable_gecko_key", TextUtils.isEmpty(this.jz) ? "" : this.jz);
            if (!TextUtils.isEmpty(this.oz)) {
                str2 = this.oz;
            }
            jSONObject.put("playable_gecko_channel", str2);
            jSONObject.put("playable_sdk_version", "6.5.1");
            jSONObject.put("playable_minigamelite_id", this.bb);
            jSONObject.put("playable_minigamelite_schema", this.by);
            jSONObject.put("playable_is_debug", this.mn);
            jSONObject.put("playable_retry_count", this.gb);
            jSONObject.put("playable_enter_from", this.jq);
            jSONObject.put("playable_sequence", this.sv);
            jSONObject.put("playable_current_section", this.f);
            jSONObject.put("is_playable_finish", this.yx);
            jSONObject.put("playable_card_session", this.na);
            jSONObject.put("playable_video_session", this.xl);
            jSONObject.put("playable_network_type", ls());
            jSONObject.put("playable_lynx_version", this.sy);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ad_extra_data", jSONObject);
            jSONObject2.put("tag", this.q);
            jSONObject2.put("nt", 4);
            jSONObject2.put("category", "umeng");
            jSONObject2.put("is_ad_event", "1");
            jSONObject2.put("refer", "playable");
            jSONObject2.put("value", this.n.opt(CmcdConfiguration.KEY_CONTENT_ID));
            jSONObject2.put(MediationConstant.EXTRA_LOG_EXTRA, this.n.opt(MediationConstant.EXTRA_LOG_EXTRA));
            int i2 = this.nh;
            if (i2 != -1 && i2 != -2) {
                if (this.wn != null) {
                    List<JSONObject> list = this.jc;
                    if (list != null && !list.isEmpty()) {
                        Iterator<JSONObject> it = this.jc.iterator();
                        while (it.hasNext()) {
                            JSONObject jSONObjectOptJSONObject = it.next().optJSONObject("ad_extra_data");
                            if (jSONObjectOptJSONObject != null) {
                                jSONObjectOptJSONObject.put("playable_render_type", this.nh);
                                jSONObjectOptJSONObject.put("playable_url", this.ly);
                            }
                        }
                        this.jc.clear();
                    }
                    if (this.nh == 0 && this.yz == z.LAND_PAGE) {
                        uy(this.ly);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.jc == null) {
                this.jc = new ArrayList();
            }
            this.jc.add(jSONObject2);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "reportEvent error", th);
        }
    }

    public void gz(String str) {
        this.gz.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.10
            @Override // java.lang.Runnable
            public void run() {
                gz.wp(gz.this);
            }
        });
    }

    public void fo(String str) {
        this.gz.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.gz.2
            @Override // java.lang.Runnable
            public void run() {
                gz.i(gz.this);
            }
        });
    }

    public void gk() {
        if (this.io) {
            this.oq = System.currentTimeMillis();
            if (this.yz == z.FEED_AWEME) {
                if (this.fp && this.r == 3) {
                    g gVar = this.pf;
                    if (gVar != null && gVar.g()) {
                        oq();
                        return;
                    } else {
                        if (this.pf == null) {
                            this.pf = new g(this, this.h);
                            oq();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.fp && this.r == 2) {
                g gVar2 = this.pf;
                if (gVar2 != null && gVar2.g()) {
                    oq();
                } else if (this.pf == null) {
                    this.pf = new g(this, this.h);
                    oq();
                }
            }
        }
    }

    private void oq() {
        Runnable runnable;
        Runnable runnable2;
        this.pf.z(System.currentTimeMillis());
        Handler handler = this.wp;
        if (handler != null) {
            int i = this.nh;
            if (i == 0 && (runnable2 = this.i) != null) {
                handler.post(runnable2);
            } else if ((i == 1 || i == 2) && (runnable = this.v) != null) {
                handler.post(runnable);
            }
            this.pf.z(500);
        }
    }

    public void x() {
        try {
            g gVar = this.pf;
            if (gVar != null) {
                gVar.z();
            }
            Handler handler = this.wp;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused) {
        }
    }

    public void lq() {
        this.zz = 0;
        this.vo = 0;
        this.yt = 0.0f;
        this.dt = 0;
        this.xo = 0;
        this.xf = 0;
        this.bw = 0;
        this.gy = 0;
        this.dh = 0;
        this.zb = 0;
        this.zd = 0;
        this.te = 0;
        this.hy = 0;
    }

    public void mc() {
        if (this.li) {
            return;
        }
        this.li = true;
        this.x = 0L;
        this.p = true;
        lq();
        try {
            View view = this.tf.get();
            if (view != null) {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this.he);
            }
        } catch (Throwable unused) {
        }
        try {
            this.ja.g();
        } catch (Throwable unused2) {
        }
        try {
            g gVar = this.pf;
            if (gVar != null) {
                gVar.z();
                this.pf = null;
            }
            Handler handler = this.wp;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Throwable unused3) {
        }
        try {
            if (!TextUtils.isEmpty(this.ly)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("playable_all_times", this.t);
                jSONObject.put("playable_hit_times", this.vm);
                int i = this.t;
                if (i > 0) {
                    jSONObject.put("playable_hit_ratio", ((double) this.vm) / (((double) i) * 1.0d));
                } else {
                    jSONObject.put("playable_hit_ratio", 0);
                }
                dl("PL_sdk_preload_times", jSONObject);
            }
        } catch (Throwable unused4) {
        }
        try {
            if (!TextUtils.isEmpty(this.ly)) {
                if (this.lq != -1) {
                    this.gk += System.currentTimeMillis() - this.lq;
                    this.lq = -1L;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("playable_user_play_duration", this.gk);
                dl("PL_sdk_user_play_duration", jSONObject2);
            }
        } catch (Throwable unused5) {
        }
        this.gz.removeCallbacks(this.fo);
        this.gz.removeCallbacks(this.uy);
        this.gz.removeCallbacksAndMessages(null);
    }

    public void z(int i, String str, String str2) {
        this.r = -1;
        this.hn = str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("playable_code", i);
            jSONObject.put("playable_msg", str);
            jSONObject.put("playable_fail_url", str2);
        } catch (Throwable th) {
            e.z("PlayablePlugin", "onWebReceivedError error", th);
        }
        dl("PL_sdk_html_load_error", jSONObject);
        if (this.zw) {
            this.zw = false;
            this.gz.removeCallbacks(this.fo);
            this.gz.removeCallbacks(this.uy);
            z(1, "容器加载失败");
        }
    }

    public void z(boolean z2, String str, int i) {
        if (z2) {
            this.r = -1;
            this.hn = str;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("playable_code", i);
                jSONObject.put("playable_msg", "url load error");
                jSONObject.put("playable_fail_url", str);
            } catch (Throwable th) {
                e.z("PlayablePlugin", "onWebReceivedHttpError error", th);
            }
            dl("PL_sdk_html_load_error", jSONObject);
            if (this.zw) {
                this.zw = false;
                this.gz.removeCallbacks(this.fo);
                this.gz.removeCallbacks(this.uy);
                z(1, "容器加载失败");
            }
        }
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        System.currentTimeMillis();
        JSONObject jSONObjectZ = this.ja.z(str, jSONObject);
        if (e.z()) {
            System.currentTimeMillis();
        }
        return jSONObjectZ;
    }

    public static gz z(Context context, com.bytedance.sdk.component.i.dl dlVar, dl dlVar2, com.bytedance.sdk.openadsdk.v.z zVar, Set<String> set, z zVar2, boolean z2) {
        if (dlVar == null || dlVar2 == null || zVar == null) {
            return null;
        }
        return new gz(context, dlVar, dlVar2, zVar, set, zVar2, z2);
    }
}
