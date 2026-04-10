package com.bytedance.sdk.openadsdk.core.gk;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.dl.gc;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.fv;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.l;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.un;
import com.bytedance.sdk.openadsdk.core.iq.wj;
import com.bytedance.sdk.openadsdk.core.iq.yz;
import com.bytedance.sdk.openadsdk.core.nativeexpress.js;
import com.bytedance.sdk.openadsdk.core.un.hh;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.l;
import com.bytedance.sdk.openadsdk.core.un.lq;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements gc {
    private static final String he = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bytedance.sdk.component.a.g.dl f1111a;
    private int ao;
    private String aq;
    private JSONObject bb;
    private int bg;
    private boolean bp;
    private String bw;
    private boolean by;
    private int c;
    private float cb;
    private volatile SharedPreferences cn;
    private int ct;
    private boolean da;
    private String dh;
    public volatile com.bytedance.sdk.component.a.g.dl dl;
    private String dt;
    private int en;
    private int ep;
    private JSONObject ey;
    private int fb;
    private boolean fn;
    private volatile com.bytedance.sdk.component.a.g.dl fp;
    private int fq;
    private int fs;
    private Boolean fx;
    public int gc;
    private int gd;
    private int gl;
    private JSONObject gm;
    private String gp;
    private JSONObject gw;
    private String gy;
    private boolean hb;
    private int hl;
    private int hn;
    private e hs;
    private volatile int hu;
    private int hy;
    private Map<String, Object> ia;
    private int ib;
    private String jc;
    private String jh;
    private int jt;
    private boolean jv;
    private int jz;
    private float k;
    private JSONObject ka;
    private String kg;
    private float kp;
    private boolean ks;
    private boolean kv;
    private String la;
    private int li;
    private int lk;
    private volatile boolean lt;
    private int ly;
    private String lz;
    private String mc;
    private int mg;
    private int mj;
    private int mk;
    private int mn;
    private boolean mt;
    private int n;
    private String na;
    private int nb;
    private boolean nm;
    private int no;
    private JSONObject nv;
    private volatile int nz;
    private float o;
    private String oc;
    private JSONObject oq;
    private int ou;
    private JSONObject oz;
    private JSONObject pc;
    private float pd;
    private long po;
    private int qi;
    private int qz;
    private String re;
    private int rg;
    private volatile SharedPreferences rh;
    private long rw;
    private int ry;
    private int s;
    private boolean sa;
    private String sf;
    private boolean st;
    private boolean su;
    private List<Integer> sz;
    private un t;
    private boolean td;
    private int te;
    private boolean tk;
    private String to;
    private Object tp;
    private boolean ts;
    private int u;
    private g um;
    private String un;
    private m ux;
    private Boolean vd;
    private boolean vj;
    private JSONObject vk;
    private com.bytedance.sdk.openadsdk.core.ls.z.z vm;
    private wj vo;
    private SharedPreferences vt;
    private js vx;
    private JSONObject vy;
    private volatile int w;
    private long wj;
    private volatile boolean wk;
    private boolean wm;
    private final int wn;
    private float wo;
    private boolean wx;
    private boolean xf;
    private String xo;
    private int xt;
    private int yd;
    private boolean yt;
    private String yw;
    private int zb;
    private int zd;
    private boolean zr;
    private int zt;
    private final String zz;
    private static final int[] mz = {1, 3, 5};
    private static volatile boolean dz = false;
    private static volatile boolean nc = true;
    private int m = Integer.MAX_VALUE;
    private Set<String> e = Collections.synchronizedSet(new HashSet());
    private int gz = Integer.MAX_VALUE;
    private int fo = Integer.MAX_VALUE;
    private int uy = Integer.MAX_VALUE;
    private int kb = Integer.MAX_VALUE;
    private String wp = null;
    private int i = Integer.MAX_VALUE;
    private int v = Integer.MAX_VALUE;
    private int pf = Integer.MAX_VALUE;
    private int ls = Integer.MIN_VALUE;
    private int p = Integer.MIN_VALUE;
    private int fv = Integer.MIN_VALUE;
    private int js = Integer.MAX_VALUE;
    private int tb = Integer.MAX_VALUE;
    private int q = -1;
    private int iq = Integer.MIN_VALUE;
    private String zw = null;
    public int z = 0;
    private int io = Integer.MIN_VALUE;
    private int uf = Integer.MAX_VALUE;
    public int g = 10;
    private int sy = Integer.MAX_VALUE;
    private com.bytedance.sdk.openadsdk.core.e.g hh = null;
    private com.bytedance.sdk.openadsdk.core.dislike.a l = null;
    private boolean h = false;
    private int gk = Integer.MAX_VALUE;
    private final Map<String, z> x = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.adexpress.z.dl.a> lq = new HashMap();
    private Set<String> ti = Collections.synchronizedSet(new HashSet());
    private final List<Object> eo = new CopyOnWriteArrayList();
    private JSONObject xl = null;
    private String j = "";
    private int y = Integer.MAX_VALUE;
    private int ec = Integer.MAX_VALUE;
    private long bv = 0;
    private Set<String> gb = new ConcurrentSkipListSet();
    private Set<String> jq = new ConcurrentSkipListSet();
    private Set<String> sv = new ConcurrentSkipListSet();
    private int f = Integer.MAX_VALUE;
    private int yx = Integer.MAX_VALUE;
    private long qd = 2147483647L;
    private int zx = Integer.MAX_VALUE;
    private int b = Integer.MAX_VALUE;
    private int lw = Integer.MAX_VALUE;
    private int rv = Integer.MAX_VALUE;
    private int tc = Integer.MAX_VALUE;
    private int me = 0;
    private long nh = 0;
    private int r = 0;
    private long yz = 0;
    private int bm = Integer.MAX_VALUE;
    private JSONObject sd = null;
    private JSONObject tf = null;
    private int ja = 3;

    public static String dl() {
        return "tt_sdk_settings_other_bst";
    }

    private static boolean wp(int i) {
        return i == 0 || i == 1 || i == 2;
    }

    public uy() {
        int iDl = com.bytedance.sdk.openadsdk.z.g.g.dl();
        this.wn = iDl;
        this.nb = iDl;
        this.zz = "live_sdk_conf";
        this.lk = Integer.MAX_VALUE;
        this.u = Integer.MAX_VALUE;
        this.sf = null;
        this.yw = null;
        this.s = Integer.MAX_VALUE;
        this.n = Integer.MAX_VALUE;
        this.ly = Integer.MAX_VALUE;
        this.hn = 0;
        this.wo = 0.0f;
        this.k = 0.0f;
        this.wx = false;
        this.cb = 8.5f;
        this.o = 7.3f;
        this.bw = null;
        this.gy = null;
        this.dh = "apps.bytesfield.com";
        this.zb = Integer.MAX_VALUE;
        this.zd = Integer.MAX_VALUE;
        this.te = 0;
        this.hy = 2;
        this.lt = false;
        this.kp = -1.0f;
        this.pd = 2.1474836E9f;
        this.gm = null;
        this.mn = Integer.MAX_VALUE;
        this.jz = 2;
        this.oz = null;
        this.bb = null;
        this.by = false;
        this.li = 3;
        this.no = 0;
        this.mj = 1;
        this.c = Integer.MAX_VALUE;
        this.pc = null;
        this.qz = 0;
        this.aq = null;
        this.mk = 0;
        this.en = 0;
        this.oc = null;
        this.ou = 1;
        this.bp = true;
        this.mt = false;
        this.ey = null;
        this.xt = 1;
        this.re = "跳过";
        this.jt = 0;
        this.ux = new m();
        this.gd = 0;
        this.zt = 0;
        this.to = "";
        this.lz = "21ea2d6d4f321553dd684e6b864bf0b7";
        this.jh = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        this.fq = -1;
        this.rw = -1L;
        this.gl = 0;
        this.po = 2147483647L;
        this.rg = Integer.MAX_VALUE;
        this.fs = Integer.MAX_VALUE;
        this.ib = Integer.MAX_VALUE;
        this.ep = Integer.MAX_VALUE;
        this.ry = Integer.MAX_VALUE;
        this.w = Integer.MAX_VALUE;
        this.cn = null;
        this.ka = null;
        this.rh = null;
        this.tp = new Object();
        this.dl = null;
        this.nv = null;
        this.zr = false;
        this.tk = false;
        this.st = false;
        this.ts = false;
        this.sz = new ArrayList();
        this.fn = false;
        this.gc = 0;
        this.hs = new e();
        this.jv = true;
        this.sa = false;
        this.yd = 0;
        this.bg = Integer.MAX_VALUE;
        this.ks = false;
        this.da = false;
        this.td = false;
        this.ao = 0;
        this.ia = new HashMap();
        this.la = "";
        this.vd = null;
        this.fx = null;
        this.vj = false;
        this.hb = false;
        this.su = false;
        this.nm = false;
        this.hl = Integer.MAX_VALUE;
        this.wk = true;
        this.nz = Integer.MAX_VALUE;
        this.hu = Integer.MAX_VALUE;
        this.wm = true;
        this.qi = 0;
    }

    public com.bytedance.sdk.component.a.g.dl g() {
        if (this.dl == null) {
            this.dl = x.z(dl());
        }
        return this.dl;
    }

    public static String a() {
        return com.bytedance.sdk.openadsdk.core.a.z.e() ? "tt_sdk_lp_w_list_bst" : "tt_sdk_lp_w_list";
    }

    public static String gc() {
        return com.bytedance.sdk.openadsdk.core.a.z.e() ? "tt_sdk_settings_slot_bst" : "tt_sdk_settings_slot";
    }

    public static String m() {
        return com.bytedance.sdk.openadsdk.core.a.z.e() ? "tt_sdk_settings_slot_splash_bst" : "tt_sdk_settings_slot_splash";
    }

    public com.bytedance.sdk.component.a.g.dl e() {
        if (this.fp == null) {
            this.fp = x.z(gc());
        }
        if (x.g() != 1) {
            return null;
        }
        return this.fp;
    }

    private com.bytedance.sdk.component.a.g.dl hs() {
        if (this.f1111a == null) {
            this.f1111a = x.z(a());
        }
        return this.f1111a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x062c A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0653 A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x06d2 A[Catch: all -> 0x092e, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x071b A[Catch: all -> 0x092e, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0904 A[Catch: Exception -> 0x0923, all -> 0x092e, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0265 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x08e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0620 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01a1 A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0589 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0234 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0663 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x063c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x08c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01e9 A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0224 A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0255 A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0271 A[Catch: all -> 0x092e, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x042a  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0460 A[Catch: all -> 0x092e, LOOP:0: B:51:0x045a->B:53:0x0460, LOOP_END, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x04d7 A[Catch: all -> 0x092e, LOOP:1: B:59:0x04d1->B:61:0x04d7, LOOP_END, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x059e A[Catch: all -> 0x092e, TRY_LEAVE, TryCatch #8 {, blocks: (B:3:0x0001, B:5:0x0179, B:9:0x0185, B:11:0x0195, B:15:0x01a1, B:17:0x01b1, B:18:0x01b8, B:20:0x01c8, B:24:0x01e9, B:26:0x0203, B:30:0x0224, B:32:0x0234, B:36:0x0255, B:38:0x0265, B:42:0x0271, B:46:0x042b, B:48:0x0450, B:50:0x0456, B:51:0x045a, B:53:0x0460, B:54:0x046c, B:56:0x04c7, B:58:0x04cd, B:59:0x04d1, B:61:0x04d7, B:62:0x04e3, B:63:0x04e5, B:73:0x051b, B:74:0x051d, B:84:0x0553, B:86:0x0565, B:90:0x0579, B:92:0x0589, B:96:0x059e, B:98:0x0620, B:102:0x062c, B:104:0x063c, B:106:0x0649, B:110:0x0653, B:112:0x0663, B:113:0x066e, B:115:0x06d2, B:116:0x06e0, B:118:0x071b, B:119:0x0721, B:121:0x08c5, B:125:0x08d4, B:127:0x08e4, B:128:0x08eb, B:130:0x0904, B:131:0x090d, B:133:0x0913, B:135:0x0923, B:124:0x08d1, B:109:0x0650, B:101:0x0629, B:95:0x0595, B:89:0x0570, B:140:0x092a, B:143:0x092d, B:41:0x026e, B:35:0x023d, B:29:0x020c, B:23:0x01d1, B:14:0x019e, B:8:0x0182, B:75:0x051e, B:77:0x0536, B:79:0x053c, B:80:0x0540, B:82:0x0546, B:83:0x0552, B:64:0x04e6, B:66:0x04fe, B:68:0x0504, B:69:0x0508, B:71:0x050e, B:72:0x051a), top: B:167:0x0001, inners: #0, #1, #3, #4, #5, #7, #9, #10, #11, #14, #15, #16, #17 }] */
    @Override // com.bytedance.sdk.openadsdk.core.gk.gc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void z() {
        /*
            Method dump skipped, instruction units count: 2353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.gk.uy.z():void");
    }

    public static void gz() {
        uy uyVarG = zw.g();
        if (uyVarG != null) {
            boolean zMe = uyVarG.me();
            if (com.bytedance.sdk.openadsdk.ls.dl.g(com.bytedance.sdk.openadsdk.core.uy.ls().oq()).booleanValue(1) != zMe) {
                com.bytedance.sdk.openadsdk.core.uy.ls().oq().apply(com.bytedance.sdk.openadsdk.ls.a.z().z(10).z(Void.class).z(0, new lq().z("downloadPath", com.bytedance.sdk.openadsdk.core.kb.fo.z(zMe))).g());
            }
            if (uyVarG.bp && uyVarG.vo != null) {
                com.bytedance.sdk.openadsdk.core.live.g.z().g();
            }
            com.bytedance.sdk.openadsdk.core.un.dl();
            com.bytedance.sdk.openadsdk.core.eo.z.z().z(zw.getContext());
        }
    }

    private static z dl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("code_id");
        boolean z = l.z(jSONObject, "enable_bidding_cache", false);
        long jZ = l.z(jSONObject, "bidding_cache_skip_time", 0L);
        boolean z2 = l.z(jSONObject, "enable_bidding_pre_fetch", false);
        int iZ = l.z(jSONObject, "auto_play", 1);
        int iZ2 = l.z(jSONObject, "voice_control", 1);
        int iZ3 = l.z(jSONObject, "voice_control", 0);
        int iZ4 = l.z(jSONObject, "rv_preload", 2);
        int iZ5 = l.z(jSONObject, "nv_preload", 1);
        int iZ6 = l.z(jSONObject, "sp_preload", 0);
        int iZ7 = l.z(jSONObject, "skip_time_displayed", 0);
        int iZ8 = l.z(jSONObject, "reg_creative_control", 1);
        int iZ9 = l.z(jSONObject, "rv_skip_time", 0);
        int iZ10 = l.z(jSONObject, "iv_skip_time", 0);
        int iZ11 = l.z(jSONObject, "if_show_win", 1);
        int iZ12 = l.z(jSONObject, "stop_time", TTAdConstant.STYLE_SIZE_RADIO_3_2);
        boolean z3 = l.z(jSONObject, "close_on_click", false);
        int iZ13 = l.z(jSONObject, "splash_load_type", 2);
        int iZ14 = l.z(jSONObject, "splash_buffer_time", 100);
        int iZ15 = l.z(jSONObject, "time_out_control", 2000);
        int iZ16 = l.z(jSONObject, "time_out_control_type", 0);
        int iZ17 = l.z(jSONObject, "slot_type", -1);
        int iZ18 = l.z(jSONObject, "refresh_rit_sw", 0);
        if (!wp(iZ2)) {
            iZ2 = 1;
        }
        return z.z().z(strOptString).fo(iZ).uy(iZ2).kb(iZ4).wp(iZ5).i(iZ7).v(iZ8).e(iZ9).m(wp(iZ3) ? iZ3 : 0).pf(iZ11).a(iZ6).gc(iZ12).dl(iZ15).ls(iZ13).p(iZ14).gz(iZ10).dl(z3).fv(iZ16).z(jZ).g(z).z(z2).g(iZ17).z(iZ18);
    }

    @Override // com.bytedance.sdk.openadsdk.core.gk.gc
    public void g(final JSONObject jSONObject) {
        this.bw = jSONObject.optString("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        this.gy = jSONObject.optString("play_component_ugen_engine_url", "");
        this.sf = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
        this.yw = jSONObject.optString("app_log_url", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
        this.na = jSONObject.optString("xpath");
        this.oq = jSONObject.optJSONObject("digest");
        this.wj = jSONObject.optLong("data_time");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("feq_policy");
        gc.g gVar = new gc.g();
        if (jSONObjectOptJSONObject != null) {
            gVar.z(jSONObjectOptJSONObject.optLong("duration") * 1000);
            gVar.z(jSONObjectOptJSONObject.optInt("max"));
            gVar.z((float) jSONObjectOptJSONObject.optDouble("agg_multiple"));
        }
        this.lk = jSONObject.optInt("vbtt", 5);
        this.u = jSONObject.optInt("fetch_tpl_interval", SdkConfigData.DEFAULT_REQUEST_INTERVAL);
        this.jc = jSONObject.optString("privacy_url", he);
        this.vd = Boolean.valueOf(jSONObject.optBoolean("use_mediation_map"));
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("abtest");
        if (jSONObjectOptJSONObject2 != null) {
            gVar.z(jSONObjectOptJSONObject2.optString("version"));
            gVar.g(jSONObjectOptJSONObject2.optString("param"));
        } else {
            com.bytedance.sdk.openadsdk.core.dl.gc.z().e();
        }
        this.mn = jSONObject.optInt("read_video_from_cache", 1);
        this.by = jSONObject.optBoolean("enable_bw_screen_detection", false);
        a(jSONObject.optJSONObject("web_upload"));
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("log_rate_conf");
        this.gm = jSONObjectOptJSONObject3;
        if (jSONObjectOptJSONObject3 != null) {
            this.pd = (float) jSONObjectOptJSONObject3.optDouble("global_rate", 1.0d);
            if (this.gm.has("call_stack_rate")) {
                this.kp = (float) this.gm.optDouble("call_stack_rate");
            } else {
                this.kp = this.pd;
            }
        } else {
            this.pd = 1.0f;
        }
        this.gp = jSONObject.optString("pyload_h5");
        this.t = un.z(jSONObject.optJSONObject("insert_js_config"));
        this.y = gc(jSONObject);
        wp.a("splashLoad", "setting-》mSplashCheckType=" + this.y);
        this.f = jSONObject.optInt("if_both_open", 0);
        this.yx = jSONObject.optInt("support_tnc", Integer.MAX_VALUE);
        this.ec = jSONObject.optInt("al", 1);
        this.s = jSONObject.optInt("max_tpl_cnts", 100);
        com.bytedance.sdk.openadsdk.core.dl.dl.z().z(jSONObject);
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject4 != null) {
            this.dt = jSONObjectOptJSONObject4.optString("stats_url", "api-access.pangolin-sdk-toutiao1.com");
            this.xo = jSONObjectOptJSONObject4.optString("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
            this.xf = jSONObjectOptJSONObject4.optBoolean("enable_apm_pv", false);
            this.yt = jSONObjectOptJSONObject4.optBoolean("open_single_abi", false);
            this.hl = jSONObjectOptJSONObject4.optBoolean("show_callback_mult", false) ? 1 : 0;
            this.n = jSONObjectOptJSONObject4.optInt("fetch_tpl_timeout_ctrl", 5000);
            this.ly = jSONObjectOptJSONObject4.optInt("interact_show_after_time", 500);
            this.hn = jSONObjectOptJSONObject4.optInt("fetch_tpl_timeout_ctrl_bad_device", 300);
            this.wo = (float) jSONObjectOptJSONObject4.optDouble("tpl_render_error_rate_h5", 4.5d);
            this.k = (float) jSONObjectOptJSONObject4.optDouble("tpl_render_error_rate_native", 1.0d);
            this.wx = jSONObjectOptJSONObject4.optBoolean("tpl_enable_render_timeout_opt", false);
            String strOptString = jSONObjectOptJSONObject4.optString("tpl_timeout_ctrl");
            if (!TextUtils.isEmpty(strOptString)) {
                this.vx = js.dl(strOptString);
            }
            this.zb = jSONObjectOptJSONObject4.optInt("if_sp_cache", 1);
            gVar.z(jSONObjectOptJSONObject4.optBoolean("is_spl_cache_remove_change", false));
            this.ls = jSONObjectOptJSONObject4.optInt("express_gesture_enable", 0);
            this.fv = jSONObjectOptJSONObject4.optInt("enable_download_proto", 1);
            this.p = jSONObjectOptJSONObject4.optInt("app_express_gesture_priority", -1);
            this.zd = jSONObjectOptJSONObject4.optInt("webview_cache_count", 0);
            this.te = jSONObjectOptJSONObject4.optInt("webview_cache_count_v3", 0);
            this.hy = jSONObjectOptJSONObject4.optInt("webview_render_concurrent_count", 2);
            this.dh = jSONObjectOptJSONObject4.optString("ad_pkg_info_url", "apps.bytesfield.com");
            this.re = jSONObjectOptJSONObject4.optString("splash_close_text", "跳过");
            this.gk = jSONObjectOptJSONObject4.optInt("network_module", 1);
            gVar.g(jSONObjectOptJSONObject4.optInt("cypher_version", 40001));
            com.bytedance.sdk.component.g.z.z.z.z().z(this.gk != 2);
            this.lw = jSONObjectOptJSONObject4.optInt("adlog_debug", 0);
            this.zx = jSONObjectOptJSONObject4.optInt("adlog_batch", 10);
            this.qd = jSONObjectOptJSONObject4.optLong("adlog_interval", 5000L);
            this.pf = jSONObjectOptJSONObject4.optInt("enable_kite", 0);
            this.b = jSONObjectOptJSONObject4.optInt("adlog_exception_batch", 100);
            this.rv = jSONObjectOptJSONObject4.optInt("adlog_monitor", 1);
            this.q = jSONObjectOptJSONObject4.optInt("enable_ttvideo", -1);
            this.iq = jSONObjectOptJSONObject4.optInt("enable_zaid", 0);
            this.js = jSONObjectOptJSONObject4.optInt("enable_cdn_opt", 0);
            this.tb = jSONObjectOptJSONObject4.optInt("download_button_effect", 0);
            this.yz = jSONObjectOptJSONObject4.optLong("ext_use_type", this.nh);
            this.tc = jSONObjectOptJSONObject4.optInt("enable_glgpu", 0);
            this.r = jSONObjectOptJSONObject4.optInt("enable_dl_ext", this.me);
            this.sy = jSONObjectOptJSONObject4.optInt("download_receiver_enable", 1);
            this.z = jSONObjectOptJSONObject4.optInt("launch_strategy", 0);
            this.io = jSONObjectOptJSONObject4.optInt("dl_popup_duration", 1000);
            this.uf = jSONObjectOptJSONObject4.optInt("opt_show_check", 0);
            this.ct = jSONObjectOptJSONObject4.optInt("shake_trigger_control", 0);
            this.sd = jSONObjectOptJSONObject4.optJSONObject("pitaya_general_settings");
            this.tf = jSONObjectOptJSONObject4.optJSONObject("http_drop");
            this.ja = jSONObjectOptJSONObject4.optInt("stats_batch", 5);
            this.gw = jSONObjectOptJSONObject4.optJSONObject("live_stream_cof");
            this.vy = jSONObjectOptJSONObject4.optJSONObject("dl_notification");
            this.c = jSONObjectOptJSONObject4.optInt("disable_show_url", 0);
            this.pc = jSONObjectOptJSONObject4.optJSONObject("sensor_direction");
            this.vk = jSONObjectOptJSONObject4.optJSONObject("pitaya_business_conf");
            gVar.dl(jSONObjectOptJSONObject4.optInt("spl_cache_conf", 14));
            gVar.a(jSONObjectOptJSONObject4.optInt("spl_thread_conf", 1));
            gVar.gc(jSONObjectOptJSONObject4.optInt("spl_common_conf", 0));
            gVar.m(jSONObjectOptJSONObject4.optInt("spl_cache_expired", 0));
            gVar.dl(jSONObjectOptJSONObject4.optString("drop_cache_black_conf", ""));
            gVar.z(this.vk);
            gVar.e(jSONObjectOptJSONObject4.optInt("splash_render_timeout_backup", 100));
            JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("client_intelligence_conf");
            if (jSONObjectOptJSONObject5 != null) {
                this.zr = jSONObjectOptJSONObject5.optBoolean("net_rating");
                this.nv = jSONObjectOptJSONObject5.optJSONObject("net_rating_config");
                this.tk = jSONObjectOptJSONObject5.optBoolean("device_rating");
            }
            JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject4.optJSONObject("bytebench_rating");
            if (jSONObjectOptJSONObject6 != null) {
                this.st = jSONObjectOptJSONObject6.optBoolean("enable");
                this.cb = (float) jSONObjectOptJSONObject6.optDouble("mid_value");
                this.o = (float) jSONObjectOptJSONObject6.optDouble("low_value");
            }
            this.ts = true;
            this.sz.add(1);
            this.sz.add(3);
            this.sz.add(5);
            this.fn = true;
            JSONObject jSONObjectOptJSONObject7 = jSONObjectOptJSONObject4.optJSONObject("realtime_feature");
            if (jSONObjectOptJSONObject7 != null) {
                this.ts = jSONObjectOptJSONObject7.optBoolean("enable", true);
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject7.optJSONArray("time_window");
                this.sz.clear();
                if (jSONArrayOptJSONArray != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        this.sz.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                    }
                } else {
                    this.sz.add(1);
                    this.sz.add(3);
                    this.sz.add(5);
                }
                this.fn = jSONObjectOptJSONObject7.optBoolean("session_enable", false);
            }
            this.nb = jSONObjectOptJSONObject4.optInt("event_switch", this.wn);
            this.bm = jSONObjectOptJSONObject4.optInt("switch_audio_focus", 0);
            this.zw = jSONObjectOptJSONObject4.optString("apm_pv_config", "");
            this.li = jSONObjectOptJSONObject4.optInt("splash_card_show_max_count", 3);
            this.g = jSONObjectOptJSONObject4.optInt("pre_fetch_cnt", 10);
            this.fq = jSONObjectOptJSONObject4.optInt("gnd_prefetch_cache_size", 5);
            this.rw = jSONObjectOptJSONObject4.optLong("gnd_prefetch_cache_ttl", 0L);
            this.vm = com.bytedance.sdk.openadsdk.core.ls.z.z.z(jSONObjectOptJSONObject4.optJSONObject("white_check_config"));
            this.no = jSONObjectOptJSONObject4.optInt("scheme_get_type", 0);
            this.mj = jSONObjectOptJSONObject4.optInt("scheme_get_num", 1);
            this.qz = jSONObjectOptJSONObject4.optInt("if_query_all_package", 0);
            this.hh = com.bytedance.sdk.openadsdk.core.e.g.z(jSONObjectOptJSONObject4.optJSONObject("clog_config"));
            this.l = com.bytedance.sdk.openadsdk.core.dislike.a.z(jSONObjectOptJSONObject4.optJSONObject("oncall_upload"));
            this.h = jSONObjectOptJSONObject4.optBoolean("check_live_room", false);
            JSONObject jSONObjectOptJSONObject8 = jSONObjectOptJSONObject4.optJSONObject("pglam");
            if (jSONObjectOptJSONObject8 != null) {
                this.mk = jSONObjectOptJSONObject8.optInt("pglam_main_enable", 0);
                this.en = jSONObjectOptJSONObject8.optInt("pglam_dns_check_enable", 0);
                this.oc = jSONObjectOptJSONObject8.optString("pglam_clazz_check", "");
            }
            this.ou = jSONObjectOptJSONObject4.optInt("ud_enable", 1);
            this.bb = jSONObjectOptJSONObject4.optJSONObject("thread_config");
            com.bytedance.sdk.openadsdk.core.x.z.g();
            this.mt = jSONObjectOptJSONObject4.optBoolean("new_app_list", false);
            this.um = g.z(jSONObjectOptJSONObject4.optJSONObject("app_live_config"));
            this.ey = jSONObjectOptJSONObject4.optJSONObject("plugin_update_state");
            this.ka = jSONObjectOptJSONObject4.optJSONObject("antispam_autoclick_detect");
            com.bytedance.sdk.component.a.z zVarG = io.g();
            if (zVarG != null) {
                zVarG.updateHARSettings(this.ka);
            }
            this.xt = jSONObjectOptJSONObject4.optInt("is_open_isw", 1);
            this.jt = jSONObjectOptJSONObject4.optInt("is_kv_cache_type", 0);
            this.gd = jSONObjectOptJSONObject4.optInt("kv_init_type", 0);
            this.yd = jSONObjectOptJSONObject4.optInt("open_dl_type", 0);
            this.kg = jSONObjectOptJSONObject4.optString("app_dl_scheme_list", "");
            int iOptInt = jSONObjectOptJSONObject4.optInt("lp_url_sw", 0);
            this.zt = iOptInt;
            if (iOptInt == 1) {
                this.to = jSONObjectOptJSONObject4.optString("lp_list", "");
            }
            JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject4.optJSONObject("uchain");
            if (jSONObjectOptJSONObject9 != null) {
                String strOptString2 = jSONObjectOptJSONObject9.optString(TKDownloadReason.KSAD_TK_MD5, "");
                String strOptString3 = jSONObjectOptJSONObject9.optString("url", "");
                if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3)) {
                    this.lz = strOptString2;
                    this.jh = strOptString3;
                }
            }
            com.bytedance.sdk.openadsdk.core.fo.z.a.z.z(this.lz, this.jh);
            this.bg = jSONObjectOptJSONObject4.optInt("m_vids_join", 0);
            this.gl = jSONObjectOptJSONObject4.optInt("mini_event_upload_version", 0);
            this.po = jSONObjectOptJSONObject4.optLong("bg_web_readd_t", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
            this.rg = jSONObjectOptJSONObject4.optInt("title_priority", 0);
            this.fs = jSONObjectOptJSONObject4.optInt("splash_video_opt_enable", 0);
            this.ib = jSONObjectOptJSONObject4.optInt("gesture_through_enable", 0);
            this.ep = jSONObjectOptJSONObject4.optInt("refresh_req_num", 2);
            this.ry = jSONObjectOptJSONObject4.optInt("refresh_max_times", 1);
            yd().edit().putBoolean("_use_pl_", jSONObjectOptJSONObject4.optBoolean("_use_pl_", false)).apply();
            this.gc = jSONObjectOptJSONObject4.optInt("npth_enable_type", 0);
            this.jv = jSONObjectOptJSONObject4.optBoolean("is_sp_send_meta", true);
            this.hs = e.z(jSONObjectOptJSONObject4.optString("opt_config"));
            this.ux = m.z(jSONObjectOptJSONObject4.optString("kv_config"));
            this.ks = jSONObjectOptJSONObject4.optBoolean("preload_switch", false);
            this.da = jSONObjectOptJSONObject4.optBoolean("cache_ana_lru_switch", false);
            this.td = jSONObjectOptJSONObject4.optBoolean("cache_ana_expire_switch", false);
            this.ao = jSONObjectOptJSONObject4.optInt("preload_time_point", 0);
            this.vj = jSONObjectOptJSONObject4.optBoolean("is_adapt_density", false);
            this.wk = jSONObjectOptJSONObject4.optBoolean("disable_easy_playable", true);
            this.nz = jSONObjectOptJSONObject4.optInt("enable_target_34", 1);
            this.hu = jSONObjectOptJSONObject4.optInt("enable_xm_market", 1);
            this.kv = jSONObjectOptJSONObject4.optBoolean("app_info_cache_switch", false);
            this.wm = jSONObjectOptJSONObject4.optBoolean("disable_repeat_render", true);
            this.qi = jSONObjectOptJSONObject4.optInt("status_bar_adapt", 1);
            this.fb = jSONObjectOptJSONObject4.optInt("template_pull_timeout", -1);
            this.mg = jSONObjectOptJSONObject4.optInt("template_pull_type", 0);
            JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject4.optJSONObject("view_report_opt");
            if (jSONObjectOptJSONObject10 != null) {
                this.hb = jSONObjectOptJSONObject10.optBoolean("view_check_by_window", false);
                this.su = jSONObjectOptJSONObject10.optBoolean("shake_twist_bind_show", false);
                this.nm = jSONObjectOptJSONObject10.optBoolean("view_check_by_click", false);
            }
            com.bytedance.sdk.openadsdk.core.un.un.z();
            this.sa = jSONObjectOptJSONObject4.optBoolean("is_first_plugin_resources", false);
            int iOptInt2 = jSONObjectOptJSONObject4.optInt("open_webview_count");
            SSWebView.setMaxWebViewCount(iOptInt2);
            g().put("open_webview_count", iOptInt2);
            new com.bytedance.sdk.openadsdk.core.gk.z.g().z(jSONObjectOptJSONObject4);
        }
        JSONObject jSONObjectOptJSONObject11 = jSONObject.optJSONObject("download_config");
        if (jSONObjectOptJSONObject11 != null) {
            gVar.gz(jSONObjectOptJSONObject11.optInt("if_storage_internal", 1));
        }
        gVar.z();
        com.bytedance.sdk.openadsdk.core.iq.lq.g(jSONObject);
        gb.z(jSONObject);
        com.bytedance.sdk.openadsdk.core.iq.x.z(jSONObject);
        com.bytedance.sdk.openadsdk.core.iq.gz.z(jSONObject);
        fv.z(jSONObject);
        new com.bytedance.sdk.openadsdk.core.a.g("h5_resource_sync").g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.gk.uy.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.iq.l.z(jSONObject, new l.z() { // from class: com.bytedance.sdk.openadsdk.core.gk.uy.1.1
                    @Override // com.bytedance.sdk.openadsdk.core.iq.l.z
                    public void z(l.dl dlVar) {
                        com.bytedance.sdk.openadsdk.core.iq.l.z(uy.this.dl, dlVar);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.iq.l.z
                    public void g(l.dl dlVar) {
                        com.bytedance.sdk.openadsdk.core.iq.l.g(uy.this.dl, dlVar);
                    }
                });
            }
        });
        yz.z(jSONObject);
        this.bv = System.currentTimeMillis();
        this.gb.clear();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("spam_app_list");
        if (jSONArrayOptJSONArray2 != null) {
            int length = jSONArrayOptJSONArray2.length();
            for (int i2 = 0; i2 < length; i2++) {
                String strOptString4 = jSONArrayOptJSONArray2.optString(i2);
                if (!TextUtils.isEmpty(strOptString4)) {
                    this.gb.add(strOptString4);
                }
            }
        }
        synchronized (this.jq) {
            this.jq.clear();
            JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("scheme_check_list");
            if (jSONArrayOptJSONArray3 != null) {
                int length2 = jSONArrayOptJSONArray3.length();
                for (int i3 = 0; i3 < length2; i3++) {
                    String strOptString5 = jSONArrayOptJSONArray3.optString(i3);
                    if (!TextUtils.isEmpty(strOptString5)) {
                        this.jq.add(strOptString5);
                    }
                }
            }
        }
        synchronized (this.sv) {
            this.sv.clear();
            JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("top_scheme_list");
            if (jSONArrayOptJSONArray4 != null) {
                int length3 = jSONArrayOptJSONArray4.length();
                for (int i4 = 0; i4 < length3; i4++) {
                    String strOptString6 = jSONArrayOptJSONArray4.optString(i4);
                    if (!TextUtils.isEmpty(strOptString6)) {
                        this.sv.add(strOptString6);
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject12 = jSONObject.optJSONObject("download_sdk_config");
        if (jSONObjectOptJSONObject12 != null) {
            this.j = jSONObjectOptJSONObject12.toString();
        } else {
            this.j = "";
        }
        this.xl = jSONObjectOptJSONObject12;
        try {
            JSONObject jSONObjectOptJSONObject13 = jSONObject.optJSONObject("ad_slot_conf_block");
            if (jSONObjectOptJSONObject13 != null) {
                this.la = jSONObjectOptJSONObject13.toString();
                this.ia.clear();
                Iterator<String> itKeys = jSONObjectOptJSONObject13.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.ia.put(next, jSONObjectOptJSONObject13.opt(next));
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.dl.dl.z().fo() || !com.bytedance.sdk.openadsdk.core.uy.ls().gk()) {
            m(jSONObject);
        }
        com.bytedance.sdk.openadsdk.tools.g.dl(15, this.sf);
        if (com.bytedance.sdk.openadsdk.tools.g.z()) {
            JSONObject jSONObjectOptJSONObject14 = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optJSONObject("test_tool_urls") : null;
            if (jSONObjectOptJSONObject14 != null) {
                if (jSONObjectOptJSONObject14.has("qa_tool_host")) {
                    try {
                        String host = new URL(jSONObjectOptJSONObject14.optString("qa_tool_host")).getHost();
                        if (!TextUtils.isEmpty(host)) {
                            com.bytedance.sdk.openadsdk.core.uy.ls().kb(host);
                        }
                    } catch (MalformedURLException unused2) {
                    }
                }
                if (!TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.uy.ls().lw())) {
                    if (jSONObjectOptJSONObject14.has("ad_preview_url")) {
                        com.bytedance.sdk.openadsdk.core.uy.ls().wp(jSONObjectOptJSONObject14.optString("ad_preview_url"));
                    }
                    if (jSONObjectOptJSONObject14.has("basic_info_url")) {
                        com.bytedance.sdk.openadsdk.core.uy.ls().i(jSONObjectOptJSONObject14.optString("basic_info_url"));
                    }
                }
            }
        }
        this.jz = jSONObject.optInt("pre_cache_brand_count", this.jz);
        JSONObject jSONObjectOptJSONObject15 = jSONObject.optJSONObject("video_cache_config");
        this.oz = jSONObjectOptJSONObject15;
        if (jSONObjectOptJSONObject15 != null) {
            com.bykv.vk.openvk.component.video.z.z.z(jSONObjectOptJSONObject15);
        }
        gz();
        sa();
        com.bytedance.sdk.openadsdk.core.e.dl.z(this.hh);
        jv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.gk.gc
    public void z(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject2 != null) {
            this.bp = jSONObjectOptJSONObject2.optBoolean("can_init_live", true);
        }
        if (!this.bp || (jSONObjectOptJSONObject = jSONObject.optJSONObject("live_sdk_conf")) == null) {
            return;
        }
        this.vo = wj.z(jSONObjectOptJSONObject);
        com.bytedance.sdk.openadsdk.core.live.g.z().g();
    }

    public <T> T z(String str, T t) {
        try {
            if (this.ia.containsKey(str)) {
                T t2 = (T) this.ia.get(str);
                if (t2 != null) {
                    return t2;
                }
            }
        } catch (Exception unused) {
        }
        return t;
    }

    private void jv() {
        com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("") { // from class: com.bytedance.sdk.openadsdk.core.gk.uy.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.sy.g.z.z();
            }
        });
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.m = jSONObject.optInt("enable", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("content_type");
            this.e.clear();
            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i);
                    if (!TextUtils.isEmpty(strOptString)) {
                        this.e.add(strOptString);
                    }
                }
            }
            this.gz = jSONObject.optInt("send_response_to_webview", 0);
            this.fo = jSONObject.optInt("max_report_size_single", 2);
            this.uy = jSONObject.optInt("max_report_size_total", 5);
            this.v = jSONObject.optInt("max_report_times", 0);
            this.wp = jSONObject.optString("report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
            this.i = jSONObject.optInt("storage_type", 0);
            this.kb = jSONObject.optInt("report_only_wifi_enable", 0);
            return;
        }
        this.m = 0;
        this.e.clear();
        this.gz = 0;
        this.fo = 2;
        this.uy = 5;
        this.v = 0;
        this.wp = "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/";
        this.i = 0;
        this.kb = 0;
    }

    private int gc(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("splash_check_type", 1);
        this.y = iOptInt;
        if (iOptInt == 0 || iOptInt == 1) {
            return iOptInt;
        }
        return 1;
    }

    private void sa() {
        g();
        this.dl.put("url_stats", this.dt);
        if (!"https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".equals(this.xo) && !TextUtils.isEmpty(this.xo)) {
            this.dl.put("img_bucket", this.xo);
        }
        SharedPreferences.Editor editorEdit = yd().edit();
        editorEdit.putString("url_stats", this.dt);
        this.dl.put("url_alog", this.yw);
        editorEdit.putString("url_alog", this.yw);
        this.dl.put("xpath", this.na);
        if (this.oq != null) {
            this.dl.put("digest", this.oq.toString());
        }
        this.dl.put("data_time", this.wj);
        this.dl.put("fetch_template", this.u);
        this.dl.put("pyload_h5", this.gp);
        com.bytedance.sdk.component.a.g.dl dlVar = this.dl;
        un unVar = this.t;
        dlVar.put("insert_js_config", unVar != null ? unVar.toString() : "");
        com.bytedance.sdk.component.a.g.dl dlVar2 = this.dl;
        com.bytedance.sdk.openadsdk.core.ls.z.z zVar = this.vm;
        dlVar2.put("white_check_config", zVar != null ? zVar.toString() : "");
        this.dl.put("splash_check_type", this.y);
        this.dl.put("if_both_open", this.f);
        this.dl.put("adlog_exception_batch", this.b);
        this.dl.put("adlog_interval", this.qd);
        this.dl.put("enable_kite", this.pf);
        this.dl.put("adlog_batch", this.zx);
        this.dl.put("adlog_debug", this.lw);
        this.dl.put("adlog_monitor", this.rv);
        this.dl.put("enable_ttvideo", this.q);
        this.dl.put("enable_zaid", this.iq);
        this.dl.put("enable_cdn_opt", this.js);
        this.dl.put("download_button_effect", this.tb);
        this.dl.put("ext_use_type", this.yz);
        this.dl.put("enable_glgpu", 0);
        this.dl.put("enable_dl_ext", this.r);
        this.dl.put("download_receiver_enable", this.sy);
        this.dl.put("launch_strategy", this.z);
        this.dl.put("dl_popup_duration", this.io);
        this.dl.put("switch_audio_focus", this.bm);
        this.dl.put("opt_show_check", this.uf);
        if (this.sd != null) {
            this.dl.put("pitaya_general_settings", this.sd.toString());
        }
        if (this.gw != null) {
            this.dl.put("live_stream_cof", this.gw.toString());
        }
        if (this.vy != null) {
            this.dl.put("dl_notification", this.vy.toString());
        }
        this.dl.put("disable_show_url", this.c);
        if (this.pc != null) {
            this.dl.put("sensor_direction", this.pc.toString());
        }
        if (this.vk != null) {
            this.dl.put("pitaya_business_conf", this.vk.toString());
        }
        com.bytedance.sdk.component.a.g.dl dlVar3 = this.dl;
        JSONObject jSONObject = this.tf;
        dlVar3.put("http_drop", jSONObject == null ? "" : jSONObject.toString());
        this.dl.put("stats_batch", this.ja);
        this.dl.put("event_switch", this.nb);
        this.dl.put("pre_fetch_cnt", this.g);
        this.dl.put("web_upload_enable", this.m);
        this.dl.put("web_upload_content_type", this.e);
        this.dl.put("web_upload_send_restowv", this.gz);
        this.dl.put("web_upload_max_retry", this.v);
        this.dl.put("web_upload_max_single_file", this.fo);
        this.dl.put("web_upload_max_zip_file", this.uy);
        this.dl.put("web_upload_report_url", this.wp);
        this.dl.put("web_upload_storage_type", this.i);
        this.dl.put("web_upload_report_only_wifi", this.kb);
        this.dl.put("app_list_control", this.ec);
        this.dl.put("max_tpl_cnts", this.s);
        this.dl.put("fetch_tpl_timeout_ctrl", this.n);
        this.dl.put("interact_show_after_time", this.ly);
        this.dl.put("fetch_tpl_timeout_ctrl_bad_device", this.hn);
        this.dl.put("tpl_render_error_rate_h5", this.wo);
        this.dl.put("tpl_render_error_rate_native", this.k);
        this.dl.put("mid_value", this.cb);
        this.dl.put("low_value", this.o);
        this.dl.put("tpl_enable_render_timeout_opt", this.wx);
        this.dl.put("open_single_abi", this.yt);
        com.bytedance.sdk.component.a.g.dl dlVar4 = this.dl;
        int i = this.hl;
        if (i == Integer.MAX_VALUE) {
            i = 0;
        }
        dlVar4.put("show_callback_mult", i);
        this.dl.put("webview_cache_count", this.zd);
        this.dl.put("webview_cache_count_v3", this.te);
        this.dl.put("webview_render_concurrent_count", this.hy);
        this.dl.put("enable_apm_pv", this.xf);
        this.dl.put("hit_app_list_time", this.bv);
        this.dl.put("hit_app_list_data", this.gb);
        this.dl.put("scheme_list_data", this.jq);
        this.dl.put("top_scheme_list_data", this.sv);
        this.dl.put("policy_url", this.jc);
        com.bytedance.sdk.component.a.g.dl dlVar5 = this.dl;
        Boolean bool = this.vd;
        dlVar5.put("use_mediation_map", bool != null ? bool.booleanValue() : false);
        this.dl.put("apm_pv_config", this.zw);
        this.dl.put("dyn_draw_engine_url", this.bw);
        this.dl.put("play_component_ugen_engine_url", this.gy);
        this.dl.put("ad_pkg_info_url", this.dh);
        this.dl.put("sp_key_if_sp_cache", this.zb);
        this.dl.put("download_sdk_config", this.j);
        com.bytedance.sdk.component.a.g.dl dlVar6 = this.dl;
        JSONObject jSONObject2 = this.bb;
        dlVar6.put("thread_config", jSONObject2 != null ? jSONObject2.toString() : "");
        this.dl.put("npth_enable_type", this.gc);
        this.dl.put("is_sp_send_meta", this.jv);
        this.dl.put("opt_config", this.hs.toString());
        this.dl.put("kv_config", this.ux.toString());
        this.dl.put("is_first_plugin_resources", this.sa);
        this.dl.put("vbtt", this.lk);
        this.dl.put("preload_switch", this.ks);
        this.dl.put("cache_ana_lru_switch", this.da);
        this.dl.put("cache_ana_expire_switch", this.td);
        this.dl.put("preload_time_point", this.ao);
        this.dl.put("app_info_cache_switch", this.kv);
        this.dl.put("is_adapt_density", this.vj);
        this.dl.put("disable_easy_playable", this.wk);
        this.dl.put("enable_target_34", this.nz);
        this.dl.put("enable_xm_market", this.hu);
        this.dl.put("disable_repeat_render", this.wm);
        this.dl.put("status_bar_adapt", this.qi);
        this.dl.put("template_pull_timeout", this.fb);
        this.dl.put("template_pull_type", this.mg);
        if (!TextUtils.isEmpty(this.un)) {
            this.dl.put("template_ids", this.un);
        }
        if (!TextUtils.isEmpty(this.mc)) {
            this.dl.put("tpl_infos", this.mc);
        }
        com.bytedance.sdk.component.a.g.dl dlVar7 = this.dl;
        js jsVar = this.vx;
        dlVar7.put("tpl_timeout_ctrl", jsVar != null ? jsVar.toString() : "");
        this.dl.put("call_stack_rate", this.kp);
        this.dl.put("gnd_prefetch_cache_ttl", this.rw);
        this.dl.put("gnd_prefetch_cache_size", this.fq);
        this.dl.put("global_rate", this.pd);
        this.dl.put("read_video_from_cache", this.mn);
        this.dl.put("brand_video_cache_count", this.jz);
        this.dl.put("enable_bw_screen_detection", this.by);
        this.dl.put("splash_card_show_max_count", this.li);
        com.bytedance.sdk.component.a.g.dl dlVar8 = this.dl;
        com.bytedance.sdk.openadsdk.core.e.g gVar = this.hh;
        dlVar8.put("clog_config", gVar != null ? gVar.toString() : "");
        com.bytedance.sdk.component.a.g.dl dlVar9 = this.dl;
        com.bytedance.sdk.openadsdk.core.dislike.a aVar = this.l;
        dlVar9.put("clog_config", aVar != null ? aVar.toString() : "");
        this.dl.put("check_live_room", this.h);
        this.dl.put("can_init_live", this.bp);
        this.dl.put("new_app_list", this.mt);
        com.bytedance.sdk.component.a.g.dl dlVar10 = this.dl;
        g gVar2 = this.um;
        dlVar10.put("app_live_config", gVar2 != null ? gVar2.toString() : "");
        com.bytedance.sdk.component.a.g.dl dlVar11 = this.dl;
        JSONObject jSONObject3 = this.ey;
        dlVar11.put("plugin_update_state", jSONObject3 != null ? jSONObject3.toString() : "");
        com.bytedance.sdk.component.a.g.dl dlVar12 = this.dl;
        JSONObject jSONObject4 = this.ka;
        dlVar12.put("antispam_autoclick_detect", jSONObject4 != null ? jSONObject4.toString() : "");
        this.dl.put("pglam_main_enable", this.mk);
        this.dl.put("pglam_dns_check_enable", this.en);
        this.dl.put("pglam_clazz_check", this.oc);
        this.dl.put("ud_enable", this.ou);
        this.dl.put("is_open_isw", this.xt);
        editorEdit.putInt("is_kv_cache_type", this.jt);
        editorEdit.putInt("kv_init_type", this.gd);
        editorEdit.putString(TKDownloadReason.KSAD_TK_MD5, this.lz);
        editorEdit.putString("url", this.jh);
        editorEdit.apply();
        this.dl.put("lp_url_sw", this.zt);
        if (this.zt == 1 && (com.bytedance.sdk.openadsdk.core.dl.dl.z().fo() || !com.bytedance.sdk.openadsdk.core.uy.ls().gk())) {
            hs().put("lp_list", this.to);
        }
        if (this.vo != null) {
            this.dl.put("live_sdk_conf", this.vo.toString());
        }
        this.dl.put("open_dl_type", this.yd);
        this.dl.put("app_dl_scheme_list", this.kg);
        this.dl.put("scheme_get_type", this.no);
        this.dl.put("scheme_get_num", this.mj);
        this.dl.put("if_query_all_package", this.qz);
        if (this.oz != null) {
            this.dl.put("video_cache_config", this.oz.toString());
        }
        if (this.gm != null) {
            this.dl.put("log_rate_conf", this.gm.toString());
        }
        this.dl.put("splash_close_text", this.re);
        this.dl.put("network_module", this.gk);
        this.dl.put("m_vids_join", this.bg);
        this.dl.put("mini_event_upload_version", this.gl);
        this.dl.put("bg_web_readd_t", this.po);
        this.dl.put("title_priority", this.rg);
        this.dl.put("splash_video_opt_enable", this.fs);
        this.dl.put("gesture_through_enable", this.ib);
        this.dl.put("refresh_req_num", this.ep);
        this.dl.put("refresh_max_times", this.ry);
        this.dl.put("shake_trigger_control", this.ct);
        this.dl.put("net_rating", this.zr);
        this.dl.put("device_rating", this.tk);
        this.dl.put("bytebench_rating", this.st);
        com.bytedance.sdk.component.a.g.dl dlVar13 = this.dl;
        JSONObject jSONObject5 = this.nv;
        dlVar13.put("net_rating_config", jSONObject5 != null ? jSONObject5.toString() : "");
        this.dl.put("express_gesture_enable", this.ls);
        this.dl.put("enable_download_proto", this.fv);
        this.dl.put("app_express_gesture_priority", this.p);
        this.dl.put("ad_slot_conf_block", this.la);
        this.dl.put("view_check_by_window", this.hb);
        this.dl.put("shake_twist_bind_show", this.su);
        this.dl.put("view_check_by_click", this.nm);
        this.dl.put("enable", this.ts);
        this.dl.put("session_enable", this.fn);
        com.bytedance.sdk.openadsdk.core.iq.lq.z(this.dl);
        gb.z(this.dl);
        com.bytedance.sdk.openadsdk.core.iq.gz.g(this.dl);
        fv.z(this.dl);
        com.bytedance.sdk.openadsdk.core.iq.l.g(this.dl);
        com.bytedance.sdk.openadsdk.core.iq.x.g(this.dl);
    }

    private void m(JSONObject jSONObject) {
        int length;
        SharedPreferences.Editor editorEdit;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ad_slot_conf_list");
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            return;
        }
        this.x.clear();
        gw();
        com.bytedance.sdk.component.a.g.dl dlVarE = e();
        SharedPreferences.Editor editorEdit2 = null;
        if (dlVarE == null) {
            if (this.cn == null) {
                this.cn = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), gc(), 0);
            }
            editorEdit = this.cn.edit();
        } else {
            editorEdit = null;
        }
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            z zVarDl = dl(jSONObjectOptJSONObject);
            if (zVarDl != null) {
                this.x.put(zVarDl.z, zVarDl);
                if (com.bytedance.sdk.openadsdk.core.dl.a.z().e(zVarDl.dl())) {
                    if (editorEdit2 == null && this.rh != null) {
                        editorEdit2 = this.rh.edit();
                    }
                    if (editorEdit2 != null) {
                        editorEdit2.putString(tb(zVarDl.z), jSONObjectOptJSONObject.toString());
                    }
                }
                if (dlVarE != null) {
                    dlVarE.put(tb(zVarDl.z), jSONObjectOptJSONObject.toString());
                } else if (editorEdit != null) {
                    editorEdit.putString(tb(zVarDl.z), jSONObjectOptJSONObject.toString());
                }
                com.bytedance.sdk.openadsdk.tools.g.z(zVarDl.z, jSONObjectOptJSONObject);
            }
        }
        if (editorEdit2 != null) {
            try {
                editorEdit2.commit();
            } catch (Throwable th) {
                wp.g("TTSdkSetting", "saveSlotConfig failed:" + th.getMessage());
                return;
            }
        }
        if (editorEdit != null) {
            editorEdit.commit();
        }
    }

    private String tb(String str) {
        return "ad_slot_conf_".concat(String.valueOf(str));
    }

    public boolean fo() {
        return this.ct == 1;
    }

    public String uy() {
        if (TextUtils.isEmpty(this.sf)) {
            this.sf = com.bytedance.sdk.openadsdk.core.dl.dl.z().a();
        }
        return this.sf;
    }

    public boolean kb() {
        if (this.q == -1) {
            this.q = g().get("enable_ttvideo", -1);
        }
        int i = this.q;
        if (i == 0) {
            return false;
        }
        return (i == 1 && (sy.js() || sy.fv())) ? false : true;
    }

    public boolean wp() {
        if (this.iq == Integer.MIN_VALUE) {
            this.iq = g().get("enable_zaid", 0);
        }
        return this.iq != 0;
    }

    public boolean i() {
        if (this.ls == Integer.MIN_VALUE) {
            this.ls = g().get("express_gesture_enable", 0);
        }
        return this.ls == 1;
    }

    public int v() {
        if (this.p == Integer.MIN_VALUE) {
            this.p = g().get("app_express_gesture_priority", -1);
        }
        return this.p;
    }

    public String pf() {
        if (TextUtils.isEmpty(this.dt)) {
            String str = g().get("url_stats", "api-access.pangolin-sdk-toutiao1.com");
            this.dt = str;
            if (TextUtils.isEmpty(str)) {
                this.dt = "api-access.pangolin-sdk-toutiao1.com";
            }
        }
        return this.dt;
    }

    public String ls() {
        if (TextUtils.isEmpty(this.xo)) {
            this.xo = g().get("img_bucket", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/");
        }
        return this.xo;
    }

    public boolean p() {
        boolean z = g().get("enable_apm_pv", false);
        this.xf = z;
        return z;
    }

    public void fv() {
        this.sf = "api-access.pangolin-sdk-toutiao-b.com";
    }

    public String js() {
        if (TextUtils.isEmpty(this.yw)) {
            String str = g().get("url_alog", "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/");
            this.yw = str;
            if (TextUtils.isEmpty(str)) {
                this.yw = "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
            }
        }
        return this.yw;
    }

    public boolean tb() {
        if (this.lw == Integer.MAX_VALUE) {
            this.lw = g().get("adlog_debug", 0);
        }
        return this.lw == 1;
    }

    public boolean q() {
        if (this.rv == Integer.MAX_VALUE) {
            this.rv = g().get("adlog_monitor", 1);
        }
        return this.rv != 0;
    }

    public long iq() {
        if (this.qd == 2147483647L) {
            this.qd = g().get("adlog_interval", 5000L);
        }
        return this.qd;
    }

    public boolean zw() {
        if (this.pf == Integer.MAX_VALUE) {
            this.pf = g().get("enable_kite", 0);
        }
        return this.pf == 1;
    }

    public int io() {
        if (this.zx == Integer.MAX_VALUE) {
            this.zx = g().get("adlog_batch", 10);
        }
        return this.zx;
    }

    public boolean uf() {
        if (this.r == this.me) {
            this.r = g().get("enable_dl_ext", this.me);
        }
        return this.r == 1;
    }

    public int sy() {
        if (this.ja == 3) {
            this.ja = g().get("stats_batch", 5);
        }
        int i = this.ja;
        if (i <= 0 || i > 100) {
            return 5;
        }
        return i;
    }

    public boolean hh() {
        if (this.sy == Integer.MAX_VALUE) {
            this.sy = g().get("download_receiver_enable", 1);
        }
        return this.sy != 0;
    }

    public boolean l() {
        if (this.bm == Integer.MAX_VALUE) {
            this.bm = g().get("switch_audio_focus", 0);
        }
        return this.bm == 1;
    }

    public boolean h() {
        if (this.nb == this.wn) {
            this.nb = g().get("event_switch", this.wn);
        }
        return this.nb == 1;
    }

    public int gk() {
        if (this.g == 10) {
            this.g = g().get("pre_fetch_cnt", 10);
        }
        return this.g;
    }

    public long x() {
        if (this.yz == this.nh) {
            this.yz = g().get("ext_use_type", this.nh);
        }
        return this.yz;
    }

    public boolean lq() {
        if (this.tc == Integer.MAX_VALUE) {
            this.tc = g().get("enable_glgpu", 0);
        }
        return this.tc == 1;
    }

    public boolean mc() {
        if (this.z == 0) {
            this.z = g().get("launch_strategy", 0);
        }
        return this.z == 1;
    }

    public boolean un() {
        if (this.uf == Integer.MAX_VALUE) {
            this.uf = g().get("opt_show_check", 0);
        }
        return this.uf == 1;
    }

    public int ti() {
        if (this.b == Integer.MAX_VALUE) {
            this.b = g().get("adlog_exception_batch", 100);
        }
        return this.b;
    }

    public void z(int i) {
        this.yx = i;
    }

    public boolean eo() {
        if (this.yx == Integer.MAX_VALUE) {
            this.yx = 1;
        }
        return this.yx == 1;
    }

    public String oq() {
        if (TextUtils.isEmpty(this.na)) {
            this.na = g().get("xpath", "");
        }
        return this.na;
    }

    public JSONObject wj() {
        if (this.oq == null) {
            String str = g().get("digest", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.oq = new JSONObject(str);
                } catch (Exception unused) {
                }
            }
        }
        return this.oq;
    }

    public long na() {
        if (this.wj == 0) {
            this.wj = g().get("data_time", 0L);
        }
        return this.wj;
    }

    public float xl() {
        if (this.kp < 0.0f) {
            this.kp = g().get("call_stack_rate", 0.0f);
        }
        return this.kp;
    }

    public int j() {
        if (this.m == Integer.MAX_VALUE) {
            this.m = g().get("web_upload_enable", 0);
        }
        return this.m;
    }

    public Set<String> gp() {
        Set<String> set;
        if (this.e.isEmpty() && (set = g().get("web_upload_content_type", Collections.synchronizedSet(new HashSet()))) != null && set.size() != 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                this.e.add(it.next());
            }
        }
        return this.e;
    }

    public int t() {
        if (this.gz == Integer.MAX_VALUE) {
            this.gz = g().get("web_upload_send_restowv", 0);
        }
        return this.gz;
    }

    public int vm() {
        if (this.fo == Integer.MAX_VALUE) {
            this.fo = g().get("web_upload_max_single_file", 2);
        }
        return this.fo;
    }

    public int y() {
        if (this.uy == Integer.MAX_VALUE) {
            this.uy = g().get("web_upload_max_zip_file", 5);
        }
        return this.uy;
    }

    public int ec() {
        if (this.v == Integer.MAX_VALUE) {
            this.v = g().get("web_upload_max_retry", 0);
        }
        return this.v;
    }

    public int bv() {
        if (this.kb == Integer.MAX_VALUE) {
            this.kb = g().get("web_upload_report_only_wifi", 0);
        }
        return this.kb;
    }

    public String gb() {
        if (TextUtils.equals(this.wp, "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/")) {
            this.wp = g().get("web_upload_report_url", "https://api-access.pangolin-sdk-toutiao.com/v2/inspect/aegis/client/page/");
        }
        return this.wp;
    }

    public int jq() {
        if (this.i == Integer.MAX_VALUE) {
            this.i = g().get("web_upload_storage_type", 0);
        }
        return this.i;
    }

    public un sv() {
        if (this.t == null) {
            this.t = un.z(g().get("insert_js_config", ""));
        }
        return this.t;
    }

    public com.bytedance.sdk.openadsdk.core.ls.z.z f() {
        if (this.vm == null) {
            this.vm = com.bytedance.sdk.openadsdk.core.ls.z.z.z(g().get("white_check_config", ""));
        }
        return this.vm;
    }

    public JSONObject yx() {
        if (this.xl == null) {
            String str = g().get("download_sdk_config", "");
            this.j = str;
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.xl = new JSONObject(this.j);
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        }
        return this.xl;
    }

    public JSONObject qd() {
        return this.bb;
    }

    public int zx() {
        if (this.y == Integer.MAX_VALUE) {
            this.y = g().get("splash_check_type", 1);
        }
        return this.y;
    }

    public boolean g(int i) {
        return fo(i) != 0;
    }

    public boolean z(String str) {
        return fv(str).q;
    }

    public boolean g(String str) {
        return fv(str).iq;
    }

    public long dl(String str) {
        return fv(str).zw;
    }

    public boolean b() {
        return zx() == 1;
    }

    public boolean lw() {
        if (this.pd == 2.1474836E9f) {
            this.pd = g().get("global_rate", 1.0f);
        }
        return ((float) ((int) this.pd)) == 1.0f;
    }

    public String rv() {
        if (TextUtils.isEmpty(this.zw)) {
            this.zw = g().get("apm_pv_config", "");
        }
        return this.zw;
    }

    public JSONObject tc() {
        if (this.gm == null) {
            try {
                this.gm = new JSONObject(g().get("log_rate_conf", ""));
            } catch (Exception unused) {
            }
        }
        return this.gm;
    }

    public boolean me() {
        return com.bytedance.sdk.openadsdk.core.dl.gc.z().gz();
    }

    public JSONObject nh() {
        return this.sd;
    }

    public JSONObject r() {
        if (this.tf == null) {
            String str = g().get("http_drop", "");
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.tf = new JSONObject(str);
                } catch (Exception e) {
                    wp.z(e);
                }
            }
        }
        return this.tf;
    }

    public JSONObject yz() {
        return this.gw;
    }

    public JSONObject bm() {
        return this.vy;
    }

    public JSONObject sd() {
        return this.pc;
    }

    public JSONObject tf() {
        return this.vk;
    }

    public wj ja() {
        return this.vo;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.a wn() {
        return this.l;
    }

    public boolean nb() {
        if (this.c == Integer.MAX_VALUE) {
            this.c = this.dl.get("disable_show_url", 0);
        }
        return this.c == 1;
    }

    public String zz() {
        if (TextUtils.isEmpty(this.bw)) {
            this.bw = g().get("dyn_draw_engine_url", "https://sf3-fe-tos.pglstatp-toutiao.com/obj/ad-pattern/renderer/package.json");
        }
        return this.bw;
    }

    public String vo() {
        if (TextUtils.isEmpty(this.gy)) {
            this.gy = g().get("play_component_ugen_engine_url", "");
        }
        return this.gy;
    }

    public String lk() {
        if (TextUtils.isEmpty(this.dh)) {
            this.dh = g().get("ad_pkg_info_url", "apps.bytesfield.com");
        }
        if (TextUtils.isEmpty(this.dh)) {
            this.dh = "apps.bytesfield.com";
        }
        return this.dh;
    }

    public String u() {
        if (TextUtils.isEmpty(this.re)) {
            this.re = g().get("splash_close_text", "跳过");
        }
        if (TextUtils.isEmpty(this.re)) {
            this.re = "跳过";
        }
        return this.re;
    }

    public int sf() {
        return com.bytedance.sdk.openadsdk.core.dl.gc.z().fo();
    }

    public boolean yw() {
        int iSf = sf();
        com.bytedance.sdk.component.a.z zVarG = io.g();
        return (iSf == 40001 || iSf == 40002 || iSf == 4) && zVarG != null && zVarG.getArmorLoadStatus();
    }

    public boolean s() {
        if (this.js == Integer.MAX_VALUE) {
            this.js = g().getInt("enable_cdn_opt", 0);
        }
        return this.js == 1;
    }

    public int n() {
        if (this.tb == Integer.MAX_VALUE) {
            this.tb = g().getInt("download_button_effect", 0);
        }
        return this.tb;
    }

    public boolean ly() {
        if (this.w == Integer.MAX_VALUE) {
            this.w = g().get("settings_open", 1);
        }
        return this.w == 1;
    }

    public void dl(int i) {
        if (this.w != i) {
            this.w = i;
            g().put("settings_open", this.w);
        }
    }

    public boolean hn() {
        return this.no != 1;
    }

    public int wo() {
        int i = this.mj;
        if (i <= 0) {
            return 1;
        }
        return i;
    }

    public boolean k() {
        return this.qz == 1;
    }

    public int wx() {
        if (this.bg == Integer.MAX_VALUE) {
            this.bg = g().get("m_vids_join", 0);
        }
        int i = this.bg;
        if (i == Integer.MAX_VALUE) {
            return 0;
        }
        return i;
    }

    public boolean cb() {
        return Build.VERSION.SDK_INT < this.gl;
    }

    public long o() {
        if (this.po == 2147483647L) {
            this.po = g().get("bg_web_readd_t", C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        }
        return this.po;
    }

    public boolean yt() {
        if (this.rg == Integer.MAX_VALUE) {
            this.rg = g().get("title_priority", 0);
        }
        return this.rg == 1;
    }

    public boolean dt() {
        if (this.fs == Integer.MAX_VALUE) {
            this.fs = g().get("splash_video_opt_enable", 0);
        }
        return this.fs == 1;
    }

    public boolean xo() {
        if (this.ib == Integer.MAX_VALUE) {
            this.ib = g().get("gesture_through_enable", 0);
        }
        return this.ib == 1;
    }

    public int xf() {
        if (this.ep == Integer.MAX_VALUE) {
            this.ep = g().get("refresh_req_num", 2);
        }
        if (this.ep <= 0) {
            this.ep = 2;
        }
        return this.ep;
    }

    public int bw() {
        if (this.ry == Integer.MAX_VALUE) {
            this.ry = g().get("refresh_max_times", 1);
        }
        if (this.ry < 0) {
            this.ry = 1;
        }
        return this.ry;
    }

    public String gy() {
        if (TextUtils.isEmpty(this.jc)) {
            this.jc = g().get("policy_url", he);
        }
        return this.jc;
    }

    public boolean dh() {
        if (!TextUtils.isEmpty(gk.f1105a) && gk.f1105a.compareTo(gk.fo) < 0) {
            return false;
        }
        Boolean bool = this.fx;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (this.vd == null) {
            this.vd = Boolean.valueOf(g().get("use_mediation_map", false));
        }
        Boolean bool2 = this.vd;
        this.fx = bool2;
        return bool2.booleanValue();
    }

    public boolean a(int i) {
        return fv(String.valueOf(i)).dl == 1;
    }

    public boolean a(String str) {
        int i = zw.g().fv(String.valueOf(str)).gc;
        if (i != 1) {
            return i == 2 && v.dl(zw.getContext()) != 0;
        }
        return v.a(zw.getContext());
    }

    public boolean gc(String str) {
        return fv(String.valueOf(str)).m == 1;
    }

    public int m(String str) {
        return p(str).pf;
    }

    public boolean e(String str) {
        return str == null || zw.g().fv(String.valueOf(str)).wp == 1;
    }

    public boolean gz(String str) {
        return str == null || zw.g().p(String.valueOf(str)).i == 0;
    }

    public int fo(String str) {
        return str == null ? TTAdConstant.STYLE_SIZE_RADIO_3_2 : zw.g().fv(String.valueOf(str)).v;
    }

    public int gc(int i) {
        return Math.max(fv(String.valueOf(i)).fo, 0);
    }

    public int m(int i) {
        return Math.max(fv(String.valueOf(i)).uy, 0);
    }

    public boolean uy(String str) {
        try {
            z zVarFv = zw.g().fv(String.valueOf(str));
            if (zVarFv != null) {
                return zVarFv.p != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean kb(String str) {
        try {
            z zVarP = zw.g().p(String.valueOf(str));
            if (zVarP != null) {
                return zVarP.p != null;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public int wp(String str) {
        return fv(str).gz;
    }

    public boolean z(na naVar, int i) {
        z zVarFv = zw.g().fv(String.valueOf(i));
        return com.bytedance.sdk.openadsdk.core.component.reward.a.a.z(naVar) == 4 ? zVarFv.dl == 1 : zVarFv.kb == 1;
    }

    public List<String> zb() {
        if (this.bv + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.gb.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public int zd() {
        if (this.zb == Integer.MAX_VALUE) {
            this.zb = g().get("sp_key_if_sp_cache", 1);
        }
        return this.zb;
    }

    public JSONObject te() {
        if (this.oz == null) {
            try {
                String str = g().get("video_cache_config", "");
                if (!TextUtils.isEmpty(str)) {
                    this.oz = new JSONObject(str);
                }
            } catch (Throwable th) {
                wp.g("TTSdkSettings", th.getMessage());
            }
        }
        return this.oz;
    }

    public List<String> hy() {
        if (this.bv + 172800000 < System.currentTimeMillis()) {
            return null;
        }
        Map<String, Boolean> mapG = hh.g(86400000L);
        ArrayList arrayList = new ArrayList();
        synchronized (this.jq) {
            for (String str : this.jq) {
                if (!mapG.containsKey(str.replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""))) {
                    arrayList.add(str);
                }
            }
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.sdk.openadsdk.core.gk.uy.3
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public int compare(String str2, String str3) {
                try {
                    return Integer.parseInt(Uri.parse(str2).getQueryParameter("tt_csj_scheme_priority")) - Integer.parseInt(Uri.parse(str3).getQueryParameter("tt_csj_scheme_priority"));
                } catch (Throwable unused) {
                    return 0;
                }
            }
        });
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList.set(i, ((String) arrayList.get(i)).replaceAll("[&\\?]?tt_csj_scheme_priority=[^&]*", ""));
        }
        return arrayList;
    }

    public Set<String> lt() {
        if (this.sv.size() == 0) {
            return null;
        }
        return this.sv;
    }

    public boolean kp() {
        if (this.ec == Integer.MAX_VALUE) {
            this.ec = g().get("app_list_control", 0);
        }
        return this.ec == 1;
    }

    public int fp() {
        if (this.s == Integer.MAX_VALUE) {
            this.s = g().get("max_tpl_cnts", 100);
        }
        return this.s;
    }

    public boolean vt() {
        return this.yt;
    }

    public boolean pd() {
        if (this.hl == Integer.MAX_VALUE) {
            this.hl = g().get("show_callback_mult", 0);
        }
        return this.hl == 1;
    }

    public int gm() {
        if (this.ly == Integer.MAX_VALUE) {
            this.ly = g().get("interact_show_after_time", 500);
        }
        return this.ly;
    }

    public int mn() {
        if (this.hn == 0) {
            this.hn = g().get("fetch_tpl_timeout_ctrl_bad_device", 300);
        }
        return this.hn;
    }

    public boolean jz() {
        if (!this.wx) {
            this.wx = g().get("tpl_enable_render_timeout_opt", false);
        }
        return this.wx;
    }

    public float oz() {
        if (this.wo == 0.0f) {
            this.wo = g().get("tpl_render_error_rate_h5", 4.5f);
        }
        return this.wo;
    }

    public float bb() {
        if (this.k == 0.0f) {
            this.k = g().get("tpl_render_error_rate_native", 1.0f);
        }
        return this.k;
    }

    public float by() {
        if (this.o == 0.0f) {
            this.o = g().get("low_value", 7.3f);
        }
        return this.o;
    }

    public int z(String str, int i) {
        if (i == 0 || i == 9) {
            return v(str);
        }
        return i(str);
    }

    public boolean li() {
        if (!this.ts) {
            this.ts = g().get("enable", true);
        }
        return this.ts;
    }

    public boolean jc() {
        if (!this.fn) {
            this.fn = g().get("session_enable", false);
        }
        return this.fn;
    }

    public List<Integer> he() {
        return new ArrayList(this.sz);
    }

    public int i(String str) {
        int iG;
        if (this.vx == null) {
            return 5000;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                iG = this.vx.g(MediationConstant.RIT_TYPE_BANNER);
                break;
            case "rewarded_video":
                iG = this.vx.g("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                iG = this.vx.g("fullscreen");
                break;
            case "embeded_ad":
                iG = this.vx.g(MediationConstant.RIT_TYPE_FEED);
                break;
            case "draw_ad":
                iG = this.vx.g(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                iG = 5000;
                break;
        }
        if (iG <= 0) {
            return 5000;
        }
        return iG;
    }

    public int v(String str) {
        int iZ;
        if (this.vx == null) {
            return 5000;
        }
        str.hashCode();
        switch (str) {
            case "banner_ad":
                iZ = this.vx.z(MediationConstant.RIT_TYPE_BANNER);
                break;
            case "rewarded_video":
                iZ = this.vx.z("rewarded");
                break;
            case "fullscreen_interstitial_ad":
                iZ = this.vx.z("fullscreen");
                break;
            case "embeded_ad":
                iZ = this.vx.z(MediationConstant.RIT_TYPE_FEED);
                break;
            case "draw_ad":
                iZ = this.vx.z(MediationConstant.RIT_TYPE_DRAW);
                break;
            default:
                iZ = 5000;
                break;
        }
        if (iZ <= 0) {
            return 5000;
        }
        return iZ;
    }

    public int no() {
        if (this.zd == Integer.MAX_VALUE) {
            this.zd = g().get("webview_cache_count", 0);
        }
        int i = this.zd;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int mj() {
        if (this.te == Integer.MAX_VALUE) {
            this.te = g().get("webview_cache_count_v3", 0);
        }
        int i = this.te;
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public int e(int i) {
        z zVarFv = fv(String.valueOf(i));
        if (zVarFv.g <= 0 || zVarFv.g > 5) {
            return 1;
        }
        return zVarFv.g;
    }

    public int gz(int i) {
        return fv(String.valueOf(i)).e;
    }

    public int fo(int i) {
        int i2 = p(String.valueOf(i)).fv;
        if (i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
            return i2;
        }
        return 2;
    }

    public int uy(int i) {
        return p(String.valueOf(i)).js;
    }

    public int pf(String str) {
        return p(String.valueOf(str)).tb;
    }

    public boolean kb(int i) {
        return fv(String.valueOf(i)).ls;
    }

    public boolean ls(String str) {
        return fv(str).g() == 1;
    }

    public int c() {
        if (this.lk == Integer.MAX_VALUE) {
            this.lk = g().get("vbtt", 5);
        }
        return this.lk;
    }

    public z p(String str) {
        if (str == null) {
            return dl(new JSONObject());
        }
        z zVarQ = this.x.get(str);
        if (zVarQ == null) {
            zVarQ = q(str);
        }
        if (zVarQ != null) {
            return zVarQ;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return dl(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public z fv(String str) {
        if (str == null) {
            return dl(new JSONObject());
        }
        z zVarIq = this.x.get(str);
        if (zVarIq == null) {
            zVarIq = iq(str);
        }
        if (zVarIq != null) {
            return zVarIq;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code_id", str);
            return dl(jSONObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void gw() {
        if (this.rh == null) {
            synchronized (this.tp) {
                if (this.rh == null) {
                    this.rh = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), m(), 0);
                }
            }
        }
    }

    private z q(String str) {
        z zVarDl = null;
        try {
            gw();
            String string = this.rh.getString(tb(str), null);
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            zVarDl = dl(new JSONObject(string));
            this.x.put(str, zVarDl);
            return zVarDl;
        } catch (Throwable th) {
            wp.g("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return zVarDl;
        }
    }

    private z iq(String str) {
        String string;
        com.bytedance.sdk.component.a.g.dl dlVarE = e();
        z zVarDl = null;
        try {
            if (dlVarE == null) {
                if (this.cn == null) {
                    this.cn = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), gc(), 0);
                }
                string = this.cn.getString(tb(str), "");
            } else {
                string = dlVarE.get(tb(str), "");
            }
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            zVarDl = dl(new JSONObject(string));
            this.x.put(str, zVarDl);
            return zVarDl;
        } catch (Throwable th) {
            wp.g("TTSdkSetting", "buildSlot failed:" + th.getMessage());
            return zVarDl;
        }
    }

    public boolean vy() {
        return this.lt;
    }

    public int vk() {
        if (this.fq == -1) {
            this.fq = g().get("gnd_prefetch_cache_size", 5);
        }
        return this.fq;
    }

    public long pc() {
        if (this.rw == -1) {
            this.rw = g().get("gnd_prefetch_cache_ttl", 0L);
        }
        return this.rw;
    }

    public int qz() {
        if (this.nz == Integer.MAX_VALUE) {
            this.nz = g().get("enable_target_34", 1);
        }
        return this.nz;
    }

    public int aq() {
        if (this.hu == Integer.MAX_VALUE) {
            this.hu = g().get("enable_xm_market", 1);
        }
        return this.hu;
    }

    public boolean mk() {
        return this.wm;
    }

    public int en() {
        return this.qi;
    }

    public int oc() {
        return this.fb;
    }

    public int ou() {
        return this.mg;
    }

    public boolean bp() {
        if (this.mn == Integer.MAX_VALUE) {
            this.mn = g().get("read_video_from_cache", 1);
        }
        return this.mn == 1;
    }

    public int mt() {
        return this.li;
    }

    public int um() {
        return this.jz;
    }

    public int ey() {
        int i = g().get("npth_enable_type", 0);
        this.gc = i;
        return i;
    }

    public boolean xt() {
        return this.jv;
    }

    public boolean re() {
        return this.hs.dl;
    }

    public boolean jt() {
        return this.hs.z;
    }

    public e ux() {
        return this.hs;
    }

    public m gd() {
        return this.ux;
    }

    public synchronized boolean zt() {
        if (!dz) {
            nc = g().get("disable_easy_playable", true);
            dz = true;
        }
        return nc;
    }

    public boolean to() {
        return this.h;
    }

    public int lz() {
        return this.en;
    }

    public String[] jh() {
        String str = this.oc;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.oc.split("//");
    }

    public boolean fq() {
        return this.bp;
    }

    public boolean rw() {
        return this.mt;
    }

    public JSONObject gl() {
        return this.ey;
    }

    public g po() {
        return this.um;
    }

    public boolean rg() {
        return gk.e() && this.xt == 1;
    }

    public int fs() {
        if (this.jt == 0) {
            this.jt = yd().getInt("is_kv_cache_type", 0);
        }
        return this.jt;
    }

    public int ib() {
        return this.jt;
    }

    public int ep() {
        if (this.gd == 0) {
            this.gd = yd().getInt("kv_init_type", 0);
        }
        return this.gd;
    }

    public String ry() {
        if (this.zt != 1) {
            return "";
        }
        if (!TextUtils.isEmpty(this.to)) {
            return this.to;
        }
        String str = hs().get("lp_list", this.to);
        this.to = str;
        return str;
    }

    public String ct() {
        if (TextUtils.isEmpty(this.lz)) {
            this.lz = yd().getString(TKDownloadReason.KSAD_TK_MD5, "");
        }
        return this.lz;
    }

    public String w() {
        if (TextUtils.isEmpty(this.jh)) {
            this.jh = yd().getString("url", "");
        }
        return this.jh;
    }

    public boolean js(String str) {
        if (TextUtils.isEmpty(str) || str.equals("http") || str.equals("https")) {
            return false;
        }
        if (this.yd == 0) {
            this.yd = g().get("open_dl_type", 0);
        }
        int i = this.yd;
        if (i == 0) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        return zw(str);
    }

    private boolean zw(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!TextUtils.isEmpty(this.kg)) {
            this.kg = g().get("app_dl_scheme_list", "");
        }
        if (TextUtils.isEmpty(this.kg)) {
            return false;
        }
        String[] strArrSplit = this.kg.split(",");
        if (strArrSplit.length == 0) {
            return false;
        }
        for (String str2 : strArrSplit) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean cn() {
        return this.ks;
    }

    public boolean ka() {
        return this.da;
    }

    public boolean rh() {
        return this.td;
    }

    public int tp() {
        return this.ao;
    }

    public boolean nv() {
        if (this.ou == 1) {
            this.ou = g().get("ud_enable", 1);
        }
        return this.ou == 1;
    }

    private SharedPreferences yd() {
        if (this.vt == null) {
            this.vt = com.bytedance.sdk.openadsdk.api.plugin.g.g(zw.getContext(), dl(), 0);
        }
        return this.vt;
    }

    public boolean zr() {
        return this.tk;
    }

    public boolean tk() {
        return this.st;
    }

    public boolean st() {
        return this.kv;
    }

    public boolean mz() {
        return this.vj;
    }

    public boolean ts() {
        return this.hb;
    }

    public boolean sz() {
        return this.su;
    }

    public boolean fn() {
        return this.nm;
    }
}
