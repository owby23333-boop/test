package com.anythink.expressad.foundation.d;

import android.net.Uri;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.anythink.basead.b.a;
import com.anythink.expressad.a.c;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.foundation.h.w;
import com.anythink.expressad.foundation.h.x;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c extends h implements com.anythink.expressad.e.b, Serializable {
    public static final int A = -2;
    public static final int B = 1;
    public static final String C = "id";
    public static final String D = "unitId";
    public static final String E = "title";
    public static final String F = "desc";
    public static final String G = "package_name";
    public static final String H = "icon_url";
    public static final String I = "image_url";
    public static final String J = "image_size";
    public static final String K = "app_size";
    public static final String L = "impression_url";
    public static final String M = "click_url";
    public static final String N = "wtick";
    public static final String O = "deep_link";
    public static final String P = "user_activation";
    public static final String Q = "notice_url";
    public static final String R = "template";
    public static final String S = "ad_source_id";
    public static final String T = "fca";
    public static final String U = "fcb";
    public static final String V = "click_mode";
    public static final String W = "landing_type";
    public static final String X = "link_type";
    public static final String Y = "rating";
    public static final String Z = "number_rating";
    public static final String a = c.class.getSimpleName();
    public static final String aA = "vctn_t";
    public static final String aB = "vck_t";
    public static final String aC = "rs_ignc_r";
    public static final int aD = 1;
    public static final int aE = 2;
    public static final String aF = "rw_pl";
    public static final String aG = "jm_pd";
    public static final String aI = "oc_type";
    public static final String aJ = "oc_time";
    public static final String aK = "t_list";
    public static final String aL = "adchoice";
    public static final String aM = "omid";
    public static final String aN = "ia_icon";
    public static final String aO = "ia_rst";
    public static final String aP = "ia_url";
    public static final String aQ = "ia_ori";
    public static final String aR = "ad_type";
    public static final String aS = "ia_ext1";
    public static final String aT = "ia_ext2";
    public static final String aU = "is_download_zip";
    public static final String aV = "ia_cache";
    public static final String aW = "imp_ua";
    public static final String aX = "c_ua";
    public static final int aY = 1;
    public static final int aZ = 1;
    public static final String aa = "ctatext";
    public static final String ab = "c_ct";
    public static final String ac = "video_url";
    public static final String ad = "video_length";
    public static final String ae = "video_size";
    public static final String af = "video_resolution";
    public static final String ag = "watch_mile";
    public static final String ah = "endcard_click_result";
    public static final String ai = "ctype";
    public static final String aj = "adv_imp";
    public static final String ak = "t_imp";
    public static final String al = "sec";
    public static final String am = "url";
    public static final String an = "guidelines";
    public static final String ao = "offer_type";
    public static final String ap = "reward_amount";
    public static final String aq = "reward_name";
    public static final String ar = "md5_file";
    public static final String as = "c_toi";
    public static final int at = 2;
    public static final String au = "5";
    public static final String av = "rtins_type";
    public static final String aw = "ad_url_list";
    public static final String ax = "retarget_offer";
    public static final String ay = "flb";
    public static final String az = "flb_skiptime";
    public static final String b = "ad_tpl_url";
    public static final int bA = 9;
    public static final int bB = 12;
    public static final String bC = "video_end_type";
    public static final int bD = 1;
    public static final int bE = 2;
    public static final int bF = 3;
    public static final int bG = 4;
    public static final int bH = 5;
    public static final int bI = 100;
    public static final int bJ = 2;
    public static final String bL = "ready_rate";
    public static final String bM = "tmp_ids";
    public static final String bN = "ext_data";
    public static final String bO = "endcard_url";
    public static final String bP = "playable_ads_without_video";
    public static final int bQ = 1;
    public static final int bR = 2;
    public static final String bS = "impression";
    public static final String bT = "start";
    public static final String bU = "first_quartile";
    public static final String bV = "midpoint";
    public static final String bW = "third_quartile";
    public static final String bX = "complete";
    public static final String bY = "mute";
    public static final String bZ = "unmute";
    public static final String ba = "iex";
    public static final String bb = "ts";
    public static final String bc = "nv_t2";
    public static final String bd = "impression_t2";
    public static final String be = "gif_url";
    public static final String bf = "dropout_track";
    public static final String bg = "plycmpt_track";
    public static final String bh = "aks";
    public static final String bi = "k";
    public static final String bj = "q";
    public static final String bk = "r";
    public static final String bl = "al";
    public static final String bm = "mp";
    public static final String bn = "pv_urls";
    public static final int bo = 3;
    public static final int bp = 4;
    public static final int bq = 1;
    public static final int br = 2;
    public static final int bs = 3;
    public static final int bt = 1;
    public static final int bu = 2;
    public static final int bv = 1;
    public static final int bw = 2;
    public static final int bx = 3;
    public static final int by = 4;
    public static final int bz = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10151c = "ad_html";
    public static final String ca = "click";
    public static final String cb = "pause";
    public static final String cc = "resume";
    public static final String cd = "error";
    public static final String ce = "endcard";
    public static final String cf = "close";
    public static final String cg = "video_click";
    public static final String ch = "endcard_show";
    public static final String ci = "play_percentage";
    public static final String cj = "ad_tracking";
    public static final String ck = "rv";
    public static final int cl = -1;
    public static final int cm = 1;

    /* JADX INFO: renamed from: cn, reason: collision with root package name */
    public static final int f10152cn = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10153d = "cmpt=1";
    private static final long dP = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10154e = "tp_offer";
    private static final int eS = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10155f = "fac";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10156g = "at_cd_rate";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10157h = "plct";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10158i = "plctb";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10159j = "banner_url";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10160k = "banner_html";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10161l = "creative_id";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10162m = "mraid";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10163n = "mraid_src";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10164o = "timestamp";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10165p = "hb";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f10166q = "maitve";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f10167r = "maitve_src";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10168s = "vcn";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f10169t = "token_r";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f10170u = "encrypt_p";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f10171v = "view_com_time";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f10172w = "adspace_t";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f10173x = "cbd";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f10174y = "vst";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f10175z = -2;
    public p aH;
    private List<String> cZ;
    private String dA;
    private int dB;
    private String dC;
    private int dD;
    private int dE;
    private String dF;
    private String dG;
    private int dH;
    private String dI;
    private a dJ;
    private int dL;
    private String dM;
    private String dR;
    private long da;
    private int dd;
    private boolean dl;
    private int du;
    private int dv;
    private int dw;
    private int dx;
    private int dy;
    private int dz;
    private int eA;
    private String eB;
    private int eC;
    private String eD;
    private HashMap<String, String> eE;
    private String eF;
    private String eG;
    private String eH;
    private String eI;
    private String eJ;
    private boolean eK;
    private String eM;
    private boolean eN;
    private boolean eO;
    private int eQ;
    private String eT;
    private String eV;
    private String eW;
    private int eX;
    private String eY;
    private int eb;
    private int ec;
    private int ed;
    private String ee;
    private String ef;
    private String eg;
    private String eh;
    private int ei;
    private boolean ej;
    private boolean el;
    private int em;
    private int eo;
    private String ep;
    private int eq;
    private int er;
    private String es;
    private int et;
    private int eu;
    private int ev;
    private String ew;
    private int ex;
    private String ey;
    private String ez;
    private String fA;
    private int fC;
    private String fb;
    private n fd;
    private String fe;
    private String ff;
    private int fg;
    private long fh;
    private String fi;
    private String fj;
    private int fk;
    private String fl;
    private int fm;
    private b fn;
    private C0205c fo;
    private c.b fp;
    private int fs;
    private ArrayList<Integer> fu;
    private int cV = 1;
    private String cW = "";
    private String cX = "";
    private boolean cY = false;
    private int db = 0;
    private int dc = 0;
    private int de = -2;
    private int df = -2;
    private long dg = 0;
    private long dh = 0;
    private String di = "";
    private String dj = "";
    private long dk = 0;
    private int dm = 0;
    private int dn = 0;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private String f60do = "";
    private boolean dp = false;
    private int dq = 0;
    private boolean dr = false;
    private int ds = 0;
    private int dt = -1;
    private int dK = 0;
    private int dN = 1;
    private int dO = 1;
    private int dQ = 6;
    private int dS = -1;
    private String dT = "";
    private String dU = "";
    private String dV = "";
    private int dW = 0;
    private String dX = "";
    private boolean dY = false;
    private String dZ = "";
    private String ea = "";
    private boolean ek = false;
    private String en = "";
    private String eL = "";
    private int eP = 2;
    public String bK = "";
    private int eR = -1;
    private int eU = 1;
    private int eZ = 0;
    private int fa = 2;
    private int fc = 1;
    private boolean fq = false;
    private String fr = null;
    private String ft = "";
    private int fv = 2;
    private int fw = 1;
    private int fx = -1;
    private boolean fy = false;
    private boolean fz = false;
    private int fB = 0;

    public static final class a implements Serializable {
        public static final String a = "ad_logo_link";
        public static final String b = "adchoice_link";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f10176c = "adchoice_icon";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f10177d = "adchoice_size";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f10178e = "platform_name";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f10179f = "platform_logo";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f10180g = "adv_name";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f10181h = "adv_logo";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f10182i = "";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f10183j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f10184k = "";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f10185l = "";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f10186m = "";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f10187n = "";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f10188o = "";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f10189p = "";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f10190q = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f10191r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private String f10192s = "";

        private void a(int i2) {
            this.f10190q = i2;
        }

        private void b(int i2) {
            this.f10191r = i2;
        }

        private void c(String str) {
            this.f10182i = str;
        }

        private void d(String str) {
            this.f10183j = str;
        }

        private int e() {
            return this.f10190q;
        }

        private int f() {
            return this.f10191r;
        }

        private String g() {
            return this.f10182i;
        }

        private String h() {
            return this.f10186m;
        }

        private String i() {
            return this.f10187n;
        }

        private String j() {
            return this.f10188o;
        }

        private String k() {
            return this.f10189p;
        }

        private boolean l() {
            return (TextUtils.isEmpty(this.f10183j) || TextUtils.isEmpty(this.f10185l) || TextUtils.isEmpty(this.f10184k)) ? false : true;
        }

        private void b(String str) {
            this.f10192s = str;
        }

        private void e(String str) {
            this.f10184k = str;
        }

        private void f(String str) {
            this.f10185l = str;
        }

        private void g(String str) {
            this.f10186m = str;
        }

        private void h(String str) {
            this.f10187n = str;
        }

        private void i(String str) {
            this.f10188o = str;
        }

        private void j(String str) {
            this.f10189p = str;
        }

        private static int k(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (strArrSplit = str.split("x")) != null && strArrSplit.length > 1) {
                    return Integer.parseInt(strArrSplit[1]);
                }
            } catch (NumberFormatException | Exception unused) {
            }
            return 0;
        }

        public final String a() {
            return this.f10192s;
        }

        public final String c() {
            return this.f10184k;
        }

        public final String d() {
            return this.f10185l;
        }

        public static a a(String str) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return a(new JSONObject(str));
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                if (com.anythink.expressad.a.a) {
                    th.printStackTrace();
                }
                return null;
            }
        }

        private static int l(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            try {
                if (str.contains("x") && (strArrSplit = str.split("x")) != null && strArrSplit.length > 0) {
                    return Integer.parseInt(strArrSplit[0]);
                }
            } catch (NumberFormatException | Exception unused) {
            }
            return 0;
        }

        public final String b() {
            return this.f10183j;
        }

        private static a a(JSONObject jSONObject) {
            a aVar;
            try {
                aVar = new a();
            } catch (Exception e2) {
                e = e2;
                aVar = null;
            } catch (Throwable th) {
                th = th;
                aVar = null;
            }
            try {
                aVar.f10184k = jSONObject.optString("adchoice_icon");
                aVar.f10183j = jSONObject.optString("adchoice_link");
                String strOptString = jSONObject.optString("adchoice_size");
                aVar.f10185l = strOptString;
                aVar.f10182i = jSONObject.optString(a);
                aVar.f10189p = jSONObject.optString(f10181h);
                aVar.f10188o = jSONObject.optString(f10180g);
                aVar.f10187n = jSONObject.optString("platform_logo");
                aVar.f10186m = jSONObject.optString("platform_name");
                aVar.f10191r = k(strOptString);
                aVar.f10190q = l(strOptString);
                aVar.f10192s = jSONObject.toString();
            } catch (Exception e3) {
                e = e3;
                if (com.anythink.expressad.a.a) {
                    e.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                if (com.anythink.expressad.a.a) {
                    th.printStackTrace();
                }
            }
            return aVar;
        }
    }

    public static final class b implements Serializable {
        public boolean a = false;
        public boolean b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10193c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10194d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10195e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f10196f = false;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f10197g = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f10198h = false;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f10199i = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f10200j = false;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f10201k = false;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Map<Integer, String> f10202l;
    }

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.d.c$c, reason: collision with other inner class name */
    public static final class C0205c implements Serializable {
        public static final String a = "video_template";
        public static final String b = "template_url";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f10203c = "orientation";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f10204d = "paused_url";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f10205e = "image";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f10206f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f10207g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f10208h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f10209i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f10210j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f10211k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private List<a> f10212l;

        /* JADX INFO: renamed from: com.anythink.expressad.foundation.d.c$c$a */
        public static final class a implements Serializable {
            public String a;
            public List<String> b = new ArrayList();
        }

        private C0205c(String str) {
            this.f10207g = str;
        }

        private void b(String str) {
            this.f10207g = str;
        }

        public final int c() {
            return this.f10209i;
        }

        public final String d() {
            return this.f10210j;
        }

        public final String e() {
            return this.f10211k;
        }

        public final List<a> f() {
            return this.f10212l;
        }

        private void c(String str) {
            this.f10210j = str;
        }

        private static C0205c d(String str) {
            try {
                if (w.b(str)) {
                    return a(new JSONObject(str));
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final String a() {
            return this.f10207g;
        }

        public final int b() {
            return this.f10208h;
        }

        private void a(int i2) {
            this.f10208h = i2;
        }

        private void b(int i2) {
            this.f10209i = i2;
        }

        public final void a(String str) {
            this.f10211k = x.c(str);
        }

        private void a(List<a> list) {
            this.f10212l = list;
        }

        public static C0205c a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            try {
                if (!w.b(jSONObject.toString())) {
                    return null;
                }
                C0205c c0205c = new C0205c(jSONObject.toString());
                c0205c.f10208h = jSONObject.optInt(a, 1);
                c0205c.a(jSONObject.optString("template_url"));
                c0205c.f10209i = jSONObject.optInt("orientation");
                c0205c.f10210j = jSONObject.optString(f10204d);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(f10205e);
                if (jSONObjectOptJSONObject != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys != null && itKeys.hasNext()) {
                        String next = itKeys.next();
                        List<String> listA = t.a(jSONObjectOptJSONObject.optJSONArray(next));
                        if (listA != null && listA.size() > 0) {
                            a aVar = new a();
                            aVar.a = next;
                            aVar.b.addAll(listA);
                            arrayList.add(aVar);
                        }
                    }
                    c0205c.f10212l = arrayList;
                }
                return c0205c;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    private void A(int i2) {
        this.dH = i2;
    }

    private void B(int i2) {
        this.dz = i2;
    }

    private void C(String str) {
        this.dM = str;
    }

    private void D(String str) {
        this.dI = str;
    }

    private void E(int i2) {
        this.dw = i2;
    }

    private void F(int i2) {
        this.dQ = i2;
    }

    private void G(String str) {
        this.eG = str;
    }

    private void H(String str) {
        this.eH = str;
    }

    private void I(String str) {
        this.eI = str;
    }

    private void J(String str) {
        this.eJ = str;
    }

    private void K(String str) {
        this.eL = str;
    }

    private void L(String str) {
        this.bK = str;
    }

    private void M(String str) {
        this.fe = str;
    }

    private void N(String str) {
        this.eD = str;
    }

    private void O(String str) {
        this.fi = str;
    }

    private void P(String str) {
        this.fj = str;
    }

    private void Q(String str) {
        this.ew = str;
    }

    private void R(String str) {
        this.eB = str;
    }

    private void S(String str) {
        this.es = str;
    }

    private void T(String str) {
        this.en = str;
    }

    private void V(int i2) {
        this.em = i2;
    }

    private void ak(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length > 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (String str2 : strArrSplit) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
            }
            this.fu = arrayList;
        }
    }

    private int bA() {
        return this.dD;
    }

    private int bB() {
        return this.dz;
    }

    private int bC() {
        return this.dw;
    }

    private int bD() {
        return this.dx;
    }

    private int bE() {
        return this.dy;
    }

    private int bF() {
        return this.ev;
    }

    private String bG() {
        return this.eF;
    }

    private String bH() {
        return this.eG;
    }

    private String bI() {
        return this.eH;
    }

    private String bJ() {
        return this.eI;
    }

    private String bK() {
        return this.eJ;
    }

    private String bL() {
        return this.bK;
    }

    private String bM() {
        return this.fe;
    }

    private String bN() {
        return this.eD;
    }

    private String bO() {
        return this.fi;
    }

    private String bP() {
        return this.fj;
    }

    private int bQ() {
        return this.fg;
    }

    private long bR() {
        return this.fh;
    }

    private b bS() {
        return this.fn;
    }

    private int bT() {
        return this.eC;
    }

    private String bU() {
        return this.ew;
    }

    private String bV() {
        return this.ey;
    }

    private int bW() {
        return this.eA;
    }

    private String bX() {
        return this.eB;
    }

    private int bY() {
        return this.er;
    }

    private String bZ() {
        return this.es;
    }

    private int bj() {
        return this.cV;
    }

    private String bk() {
        return this.f60do;
    }

    private int bl() {
        int i2 = this.dn;
        if (i2 == 1) {
            return i2;
        }
        return 0;
    }

    private int bm() {
        int i2 = this.dm;
        if (i2 > 0) {
            return i2;
        }
        return 1;
    }

    private void bn() {
        this.dp = true;
    }

    private long bo() {
        return this.dh;
    }

    private p bp() {
        return this.aH;
    }

    private int bq() {
        return this.dK;
    }

    private int br() {
        return this.dL;
    }

    private String bs() {
        return this.dM;
    }

    private String bt() {
        return this.dI;
    }

    private int bu() {
        return this.dH;
    }

    private String bv() {
        return this.dF;
    }

    private String bw() {
        return this.dG;
    }

    private String bx() {
        return this.dA;
    }

    private int by() {
        return this.dB;
    }

    private String bz() {
        return this.dC;
    }

    private int ca() {
        return this.et;
    }

    private int cb() {
        return this.eq;
    }

    private int cc() {
        return this.em;
    }

    private boolean cd() {
        return this.ek;
    }

    private int ce() {
        return this.ei;
    }

    private int cf() {
        return this.ec;
    }

    private int cg() {
        return this.ed;
    }

    private int ch() {
        return this.dS;
    }

    private boolean ci() {
        return this.dY;
    }

    private int cj() {
        return this.eb;
    }

    private String ck() {
        return this.ea;
    }

    private String cl() {
        return this.eT;
    }

    private String cm() {
        return this.eY;
    }

    private int cn() {
        return this.fk;
    }

    private String co() {
        return this.fl;
    }

    private String cp() {
        return this.fr;
    }

    private String cq() {
        return this.ft;
    }

    private long cr() {
        return this.da;
    }

    private String cs() {
        ArrayList<Integer> arrayList = this.fu;
        if (arrayList == null || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Integer> it = this.fu.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
            return !TextUtils.isEmpty(sb) ? sb.toString() : "";
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d(a, th.getMessage());
            return "";
        }
    }

    private int ct() {
        return this.fv;
    }

    private int cu() {
        return this.fx;
    }

    private boolean cv() {
        return this.fz;
    }

    private int cw() {
        return this.fC;
    }

    private void r(int i2) {
        this.db = i2;
    }

    private void s(int i2) {
        this.dc = i2;
    }

    private void t(int i2) {
        this.dd = i2;
    }

    private void u(int i2) {
        this.de = i2;
    }

    private void v(int i2) {
        this.dq = t.a(i2);
    }

    private void w(int i2) {
        this.du = i2;
    }

    private void x(int i2) {
        this.dv = i2;
    }

    private void y(int i2) {
        this.dK = i2;
    }

    private void z(int i2) {
        this.dL = i2;
    }

    public final String U() {
        return this.ep;
    }

    public final boolean W() {
        return this.el;
    }

    public final void X() {
        this.el = true;
    }

    public final int Y() {
        return this.fa;
    }

    public final String Z() {
        try {
            if (!TextUtils.isEmpty(this.eg)) {
                return this.eg;
            }
            if (TextUtils.isEmpty(this.dZ)) {
                return null;
            }
            Uri uri = Uri.parse(this.dZ);
            if (uri != null) {
                this.eg = uri.getQueryParameter("k");
                this.eg = this.eg;
            }
            return this.eg;
        } catch (Exception unused) {
            return null;
        }
    }

    public final int a() {
        return this.db;
    }

    public final boolean aA() {
        return super.b(this);
    }

    public final ArrayList<Integer> aB() {
        return this.fu;
    }

    public final int aC() {
        return this.fw;
    }

    public final boolean aD() {
        return this.fy;
    }

    public final String aE() {
        return this.fA;
    }

    public final int aF() {
        return this.fB;
    }

    public final String aa() {
        try {
            if (!TextUtils.isEmpty(this.eh)) {
                return this.eh;
            }
            if (TextUtils.isEmpty(this.dU)) {
                return "";
            }
            Uri uri = Uri.parse(this.dU);
            if (uri != null) {
                this.eh = uri.getQueryParameter("k");
                this.eh = this.eh;
            }
            return this.eh;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String ab() {
        return this.ee;
    }

    public final String ac() {
        return this.ef;
    }

    public final String ad() {
        return this.dV;
    }

    public final int ae() {
        return this.dW;
    }

    public final String af() {
        return this.dX;
    }

    public final String ag() {
        return this.dT;
    }

    public final String ah() {
        return this.dU;
    }

    public final String ai() {
        return this.dZ;
    }

    @Override // com.anythink.expressad.foundation.d.h
    public final c.b aj() {
        return this.fp;
    }

    public final List<String> al() {
        String str = this.eD;
        ArrayList arrayList = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        arrayList2.add(jSONArray.optString(i2));
                    } catch (Exception e2) {
                        arrayList = arrayList2;
                        e = e2;
                        e.printStackTrace();
                        return arrayList;
                    }
                }
                return arrayList2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return arrayList;
    }

    public final boolean am() {
        return this.eO;
    }

    public final void an() {
        this.eO = true;
    }

    public final int ao() {
        return this.eR;
    }

    public final int ap() {
        return this.eU;
    }

    public final String aq() {
        return this.eV;
    }

    public final String ar() {
        return this.eW;
    }

    public final int as() {
        return this.eX;
    }

    public final boolean at() {
        return this.cY;
    }

    public final void au() {
        this.cY = true;
    }

    public final int av() {
        return this.eZ;
    }

    public final boolean aw() {
        return this.fq;
    }

    public final void ax() {
        this.fq = true;
    }

    public final boolean ay() {
        return (TextUtils.isEmpty(this.fr) || TextUtils.isEmpty(com.anythink.expressad.a.f7979w)) ? false : true;
    }

    public final int az() {
        return this.fs;
    }

    public final int b() {
        return this.dc;
    }

    public final String c() {
        return this.cW;
    }

    public final String d() {
        return this.cX;
    }

    public final List<String> e() {
        return this.cZ;
    }

    public final int f() {
        return this.dd;
    }

    public final int g() {
        return this.de;
    }

    public final int h() {
        return this.df;
    }

    public final int i() {
        return this.ds;
    }

    public final boolean j() {
        return this.dp;
    }

    public final int k() {
        return this.dq;
    }

    public final boolean l() {
        return this.dr;
    }

    public final void m() {
        this.dr = true;
    }

    public final int n() {
        return this.dt;
    }

    public final long o() {
        return this.dg;
    }

    public final String p() {
        return this.di;
    }

    public final String q() {
        return this.dj;
    }

    private void C(int i2) {
        this.dx = i2;
    }

    private void D(int i2) {
        this.dy = i2;
    }

    private void E(String str) {
        this.dR = str;
    }

    private void F(String str) {
        this.eF = str;
    }

    private void G(int i2) {
        this.eQ = i2;
    }

    private void H(int i2) {
        this.dN = i2;
    }

    private void I(int i2) {
        this.dO = i2;
    }

    private void J(int i2) {
        this.eP = i2;
    }

    private void K(int i2) {
        this.fc = i2;
    }

    private void R(int i2) {
        this.er = i2;
    }

    private void S(int i2) {
        this.et = i2;
    }

    private void U(String str) {
        this.ep = str;
    }

    private void W(int i2) {
        this.ei = i2;
    }

    private void X(int i2) {
        this.fa = i2;
    }

    private void Y(String str) {
        this.ef = str;
    }

    private void ab(int i2) {
        this.dW = i2;
    }

    private void ac(int i2) {
        this.eb = i2;
    }

    private static n ad(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                n nVar = new n();
                nVar.r(a(jSONObject.optJSONArray(bS)));
                nVar.g(a(jSONObject.optJSONArray(bT)));
                nVar.h(a(jSONObject.optJSONArray(bU)));
                nVar.i(a(jSONObject.optJSONArray(bV)));
                nVar.j(a(jSONObject.optJSONArray(bW)));
                nVar.k(a(jSONObject.optJSONArray(bX)));
                nVar.a(b(jSONObject.optJSONArray(ci)));
                nVar.l(a(jSONObject.optJSONArray("mute")));
                nVar.m(a(jSONObject.optJSONArray(bZ)));
                nVar.n(a(jSONObject.optJSONArray("click")));
                nVar.o(a(jSONObject.optJSONArray(cb)));
                nVar.p(a(jSONObject.optJSONArray(cc)));
                nVar.q(a(jSONObject.optJSONArray("error")));
                nVar.s(a(jSONObject.optJSONArray(ce)));
                nVar.u(a(jSONObject.optJSONArray(cf)));
                nVar.t(a(jSONObject.optJSONArray(ch)));
                nVar.v(a(jSONObject.optJSONArray(cg)));
                nVar.f(a(jSONObject.optJSONArray(bd)));
                nVar.d(a(jSONObject.optJSONArray(bf)));
                nVar.e(a(jSONObject.optJSONArray(bg)));
                nVar.a(a(jSONObject.optJSONArray(h.cK)));
                nVar.b(a(jSONObject.optJSONArray(h.cL)));
                nVar.c(a(jSONObject.optJSONArray(h.cM)));
                return nVar;
            }
        } catch (JSONException unused) {
        }
        return null;
    }

    private static Map<Integer, String> ae(String str) {
        HashMap map = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            HashMap map2 = new HashMap();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                    int iOptInt = jSONObjectOptJSONObject.optInt("sec");
                    map2.put(Integer.valueOf(iOptInt), jSONObjectOptJSONObject.optString("url"));
                } catch (Exception e2) {
                    e = e2;
                    map = map2;
                }
            }
            return map2;
        } catch (Exception e3) {
            e = e3;
        }
        e.printStackTrace();
        return map;
    }

    private void af(String str) {
        this.eT = str;
    }

    private void ag(String str) {
        this.eW = str;
    }

    private void ah(String str) {
        this.fl = str;
    }

    private void ai(String str) {
        this.fr = str;
    }

    private void aj(String str) {
        this.ft = str;
    }

    public final boolean A() {
        return this.eK;
    }

    public final String B() {
        return this.eL;
    }

    public final n L() {
        return this.fd;
    }

    public final C0205c M() {
        return this.fo;
    }

    public final int N() {
        return this.fm;
    }

    public final int O() {
        return this.ex;
    }

    public final String P() {
        return this.ez;
    }

    public final int Q() {
        return this.eu;
    }

    public final int T() {
        return this.eo;
    }

    public final boolean V() {
        return this.ej;
    }

    public final void a(String str) {
        this.cW = str;
        boolean zE = t.e(str);
        int iG = t.g(str);
        if (zE) {
            this.dp = true;
            v(iG);
        }
    }

    public final void b(String str) {
        this.cX = str;
    }

    public final void c(String str) {
        this.f60do = str;
    }

    public final void d(int i2) {
        this.dm = i2;
    }

    public final void e(int i2) {
        this.dt = i2;
    }

    public final void f(int i2) {
        this.dE = i2;
    }

    public final void g(String str) {
        this.dG = str;
    }

    public final void h(String str) {
        this.dA = str;
    }

    public final void i(String str) {
        this.dC = str;
    }

    public final void j(String str) {
        this.eM = str;
    }

    public final void k(String str) {
        C0205c c0205c;
        this.fb = str;
        if (TextUtils.isEmpty(this.eV) && (((c0205c = this.fo) == null || TextUtils.isEmpty(c0205c.f10211k)) && !TextUtils.isEmpty(str) && str.contains(f10153d))) {
            this.eW = str;
        }
        this.fz = t.d(str);
    }

    public final void l(String str) {
        this.ff = str;
    }

    public final void m(String str) {
        this.ey = str;
    }

    public final void n(String str) {
        this.ez = x.c(str);
    }

    @Override // com.anythink.expressad.out.j
    public final void o(String str) {
        if (TextUtils.isEmpty(str)) {
            str = this.eu != 2 ? "Learn more" : "Install";
        }
        super.o(str);
    }

    public final void p(String str) {
        this.dV = str;
    }

    public final void q(String str) {
        this.dU = str;
    }

    public final long r() {
        return this.dk;
    }

    public final boolean s() {
        return this.dl;
    }

    public final int t() {
        return this.du;
    }

    public final int u() {
        return this.dv;
    }

    public final a v() {
        return this.dJ;
    }

    public final int w() {
        return this.dE;
    }

    public final int x() {
        return this.dQ;
    }

    public final String y() {
        return this.dR;
    }

    public final HashMap<String, String> z() {
        return this.eE;
    }

    private void L(int i2) {
        this.fg = i2;
    }

    private void M(int i2) {
        this.fm = i2;
    }

    private void N(int i2) {
        this.eC = i2;
    }

    private void O(int i2) {
        this.ex = i2;
    }

    private void P(int i2) {
        this.eA = i2;
    }

    private void Q(int i2) {
        this.eu = i2;
    }

    private void T(int i2) {
        this.eo = i2;
    }

    private void U(int i2) {
        this.eq = i2;
    }

    private void V(String str) {
        this.eg = str;
    }

    private void W(String str) {
        this.eh = str;
    }

    private void X(String str) {
        this.ee = str;
    }

    private void Y(int i2) {
        this.ec = i2;
    }

    private void ab(String str) {
        this.dZ = str;
    }

    private void ac(String str) {
        this.ea = str;
    }

    private void af(int i2) {
        this.fk = i2;
    }

    private void ag(int i2) {
        if (i2 <= 2 && i2 > 0) {
            this.fv = i2;
        } else {
            this.fv = 2;
        }
    }

    private void ah(int i2) {
        if (i2 <= 2 && i2 > 0) {
            this.fw = i2;
        } else {
            this.fw = 1;
        }
    }

    private void ai(int i2) {
        this.fx = i2;
    }

    private void aj(int i2) {
        this.fC = i2;
    }

    public final int C() {
        return this.eQ;
    }

    public final int D() {
        return this.dN;
    }

    public final int E() {
        return this.dO;
    }

    public final int F() {
        return this.eP;
    }

    public final String G() {
        return this.eM;
    }

    public final boolean H() {
        return this.eN;
    }

    public final String I() {
        if (!TextUtils.isEmpty(this.fb)) {
            return this.fb + "&n_logo=0";
        }
        return this.fb;
    }

    public final int J() {
        return this.fc;
    }

    public final String K() {
        return this.ff;
    }

    public final Map<Integer, String> R() {
        return ae(this.es);
    }

    public final String S() {
        return this.en;
    }

    public final void b(int i2) {
        this.ds = i2;
    }

    public final void c(int i2) {
        this.dn = i2;
    }

    public final void d(String str) {
        this.di = x.c(str);
    }

    public final void e(String str) {
        this.dj = str;
    }

    public final void f(String str) {
        this.dF = str;
    }

    public final void g(int i2) {
        this.dB = i2;
    }

    public final void h(int i2) {
        this.dD = i2;
    }

    public final void i(int i2) {
        this.ev = i2;
    }

    public final void j(int i2) {
        this.eU = i2;
    }

    public final void l(int i2) {
        this.eZ = i2;
    }

    public final void m(int i2) {
        this.fs = i2;
    }

    public final void n(int i2) {
        this.fB = i2;
    }

    public final void r(String str) {
        this.eV = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.eW = str;
        boolean zE = t.e(str);
        int iG = t.g(str);
        if (zE) {
            this.dp = true;
            v(iG);
        }
        this.fy = t.d(str);
    }

    public final void s(String str) {
        this.eY = str;
    }

    public final void t(String str) {
        this.fA = str;
    }

    private void b(long j2) {
        this.dg = j2;
    }

    private void c(long j2) {
        this.dh = j2;
    }

    private void d(long j2) {
        this.dk = j2;
    }

    private void e(long j2) {
        this.fh = j2;
    }

    private void f(boolean z2) {
        this.dY = z2;
    }

    private void g(long j2) {
        this.da = j2;
    }

    private void h(boolean z2) {
        this.fz = z2;
    }

    private void d(boolean z2) {
        this.eK = z2;
    }

    private void e(boolean z2) {
        this.ek = z2;
    }

    private boolean f(long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return this.dg > 0 ? bg() + (this.dg * 1000) >= jCurrentTimeMillis : bg() + j2 >= jCurrentTimeMillis;
    }

    private void g(boolean z2) {
        this.fy = z2;
    }

    public final void b(boolean z2) {
        this.eN = z2;
    }

    public final void c(boolean z2) {
        this.ej = z2;
    }

    public static c b(JSONObject jSONObject) {
        c cVar;
        ArrayList arrayList;
        c cVarA = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            cVar = new c();
            try {
                cVar.v(jSONObject.optString("id"));
                cVar.x(jSONObject.optString("title"));
                cVar.y(jSONObject.optString("desc"));
                cVar.w(jSONObject.optString("package_name"));
                cVar.ev = jSONObject.optInt(av);
                cVar.z(jSONObject.optString("icon_url"));
                cVar.A(jSONObject.optString("image_url"));
                cVar.B(jSONObject.optString(K));
                cVar.ea = jSONObject.optString(J);
                cVar.dT = jSONObject.optString(L);
                cVar.dV = jSONObject.optString("click_url");
                cVar.aH = p.a(jSONObject.optString(aF));
                cVar.dW = jSONObject.optInt(N);
                cVar.dX = jSONObject.optString(O);
                cVar.dY = jSONObject.optBoolean(P, false);
                cVar.dU = jSONObject.optString("notice_url");
                cVar.eb = jSONObject.optInt("template");
                cVar.p(jSONObject.optInt("ad_source_id", 1));
                cVar.ec = jSONObject.optInt(T);
                cVar.ed = jSONObject.optInt(U);
                cVar.eQ = jSONObject.optInt(ah);
                if (!TextUtils.isEmpty(jSONObject.optString(Y))) {
                    cVar.a(Double.parseDouble(jSONObject.optString(Y, "0")));
                }
                if (!TextUtils.isEmpty(jSONObject.optString(Z))) {
                    cVar.o(jSONObject.optInt(Z, 333333));
                }
                cVar.ee = jSONObject.optString("click_mode");
                cVar.ef = jSONObject.optString("landing_type");
                cVar.eu = jSONObject.optInt("link_type", 4);
                cVar.ei = jSONObject.optInt(ab);
                cVar.o(jSONObject.optString(aa));
                cVar.eD = jSONObject.optString(aw);
                cVar.fm = jSONObject.optInt(ax, 2);
                cVar.en = jSONObject.optString("video_url");
                cVar.q(jSONObject.optInt("video_length"));
                cVar.eo = jSONObject.optInt("video_size");
                cVar.ep = jSONObject.optString(af);
                cVar.eq = jSONObject.optInt(ag);
                cVar.a(System.currentTimeMillis());
                cVar.er = jSONObject.optInt("ctype");
                cVar.es = jSONObject.optString(aj);
                cVar.et = jSONObject.optInt(ak);
                cVar.ey = jSONObject.optString(d.f10216f);
                cVar.n(jSONObject.optString(d.f10221k));
                cVar.ew = jSONObject.optString(an);
                cVar.ex = jSONObject.optInt("offer_type");
                cVar.eB = jSONObject.optString("reward_name");
                cVar.eA = jSONObject.optInt("reward_amount");
                try {
                    String strOptString = jSONObject.optString(cj);
                    if (!TextUtils.isEmpty(strOptString)) {
                        cVar.fe = strOptString;
                        cVar.fd = ad(strOptString);
                    }
                } catch (Exception unused) {
                }
                try {
                    cVar.eR = jSONObject.optInt("ready_rate", -1);
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(bN);
                    if (jSONObjectOptJSONObject != null) {
                        cVar.eT = jSONObjectOptJSONObject.toString();
                    }
                    cVar.eX = jSONObject.optInt(d.G);
                    cVar.r(jSONObject.optString(d.F));
                    cVar.eU = jSONObject.optInt(d.E);
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                    }
                    cVar.cZ = arrayList;
                    JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(d.H);
                    if (jSONObjectOptJSONObject2 != null) {
                        cVar.eY = jSONObjectOptJSONObject2.toString();
                    }
                } catch (Exception unused2) {
                }
                cVar.eP = jSONObject.optInt(bC, 2);
                if (a(cVar, jSONObject.optString("endcard_url"))) {
                    return null;
                }
                cVar.fc = jSONObject.optInt(bP, 1);
                if (jSONObject.has(ar)) {
                    cVar.bK = jSONObject.optString(ar);
                }
                if (jSONObject.has(bc)) {
                    cVar.dQ = jSONObject.optInt(bc);
                }
                if (jSONObject.has(be)) {
                    cVar.dR = jSONObject.optString(be);
                }
                cVar.a(C0205c.a(jSONObject.optJSONObject(ck)));
                cVar.fa = jSONObject.optInt(as, 2);
                cVar.dN = jSONObject.optInt(aW, 1);
                cVar.dO = jSONObject.optInt(aX, 1);
                cVar.dw = jSONObject.optInt(aG);
                cVar.dA = jSONObject.optString("ia_icon");
                cVar.dB = jSONObject.optInt("ia_rst");
                cVar.dC = jSONObject.optString("ia_url");
                cVar.dD = jSONObject.optInt("ia_ori");
                cVar.dE = jSONObject.optInt("ad_type");
                cVar.db = jSONObject.optInt(f10154e);
                cVar.dc = jSONObject.optInt(f10155f);
                cVar.dF = jSONObject.optString(aS);
                cVar.dG = jSONObject.optString(aT);
                cVar.dH = jSONObject.optInt(aU);
                cVar.dI = jSONObject.optString(aV);
                cVar.dL = jSONObject.optInt(aJ);
                cVar.dK = jSONObject.optInt(aI);
                cVar.dM = jSONObject.optString(aK);
                cVar.dJ = a.a(jSONObject.optString(aL, ""));
                cVar.dg = jSONObject.optLong("plct");
                cVar.dh = jSONObject.optLong("plctb");
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(aM);
                if (jSONArrayOptJSONArray2 == null) {
                    if (!TextUtils.isEmpty(jSONObject.optString(aM))) {
                        cVar.fr = jSONObject.optString(aM);
                    } else {
                        cVar.fr = null;
                    }
                } else {
                    cVar.fr = jSONArrayOptJSONArray2.toString();
                }
                cVar.dk = jSONObject.optInt("creative_id");
                String strOptString2 = jSONObject.optString("cam_tpl_url");
                Uri uri = Uri.parse(strOptString2);
                if (!TextUtils.isEmpty(uri.getPath()) && (uri.getPath().endsWith(".zip") || uri.getPath().endsWith(".ZIP"))) {
                    cVar.a(strOptString2);
                } else {
                    cVar.d(strOptString2);
                }
                cVar.dj = jSONObject.optString("cam_html");
                cVar.cX = jSONObject.optString("cam_html");
                cVar.ff = jSONObject.optString("unitId");
                String strOptString3 = jSONObject.optString(f10162m);
                if (TextUtils.isEmpty(strOptString3)) {
                    strOptString3 = jSONObject.optString(f10163n);
                }
                if (!TextUtils.isEmpty(strOptString3)) {
                    cVar.eN = true;
                    cVar.eM = strOptString3;
                } else if (!TextUtils.isEmpty(cVar.cX) && !cVar.cX.contains("<MBTPLMARK>")) {
                    cVar.eN = true;
                } else {
                    cVar.eN = false;
                }
                try {
                    String strOptString4 = jSONObject.optString(d.f10217g);
                    if (!TextUtils.isEmpty(strOptString4)) {
                        cVar.dZ = strOptString4;
                        Uri uri2 = Uri.parse(strOptString4);
                        if (uri2 != null) {
                            cVar.eg = uri2.getQueryParameter("k");
                        }
                    }
                    String strOptString5 = jSONObject.optString("notice_url");
                    if (!TextUtils.isEmpty(strOptString5)) {
                        cVar.dU = strOptString5;
                        Uri uri3 = Uri.parse(strOptString5);
                        if (uri3 != null) {
                            cVar.eh = uri3.getQueryParameter("k");
                        }
                    }
                } catch (Exception unused3) {
                }
                cVar.eK = jSONObject.optBoolean("hb", false);
                cVar.fk = jSONObject.optInt(f10166q);
                cVar.fl = jSONObject.optString(f10167r);
                cVar.du = jSONObject.optInt(ay);
                cVar.dv = jSONObject.optInt(az);
                cVar.de = jSONObject.optInt(f10173x, -2);
                cVar.df = jSONObject.optInt(f10174y, -2);
                cVar.dd = jSONObject.optInt("adspace_t", 1);
                cVarA = h.a(jSONObject, cVar);
                cVarA.dm = jSONObject.optInt("vcn");
                cVarA.dn = jSONObject.optInt("token_r");
                cVarA.f60do = jSONObject.optString("encrypt_p");
                cVarA.ds = jSONObject.optInt(f10171v);
                cVarA.ag(jSONObject.optInt(aB, 2));
                cVarA.ah(jSONObject.optInt(aA, 1));
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(aC);
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    ArrayList<Integer> arrayList2 = new ArrayList<>();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray3.optInt(i3)));
                    }
                    if (arrayList2.size() > 0) {
                        cVarA.fu = arrayList2;
                    }
                }
                cVarA.fC = jSONObject.optInt(f10156g, 0);
                return cVarA;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return cVar;
            }
        } catch (Exception e3) {
            e = e3;
            cVar = cVarA;
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        try {
            if (!jSONObject.has(bM) || (jSONArrayOptJSONArray = jSONObject.optJSONArray(bM)) == null || jSONArrayOptJSONArray.length() <= 0) {
                return jSONObject;
            }
            jSONObject.remove(bM);
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                JSONObject jSONObjectA = com.anythink.expressad.foundation.c.a.a.a().a(jSONArrayOptJSONArray.getString(i2));
                if (jSONObjectA != null) {
                    Iterator<String> itKeys = jSONObjectA.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObjectA.opt(next));
                    }
                }
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void a(List<String> list) {
        this.cZ = list;
    }

    public final void k(int i2) {
        this.eX = i2;
    }

    public final void a(int i2) {
        this.df = i2;
    }

    public final String ak() {
        if (!TextUtils.isEmpty(this.dU)) {
            try {
                URL url = new URL(this.dU);
                return url.getProtocol() + HttpConstant.SCHEME_SPLIT + url.getHost();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    private void Z(int i2) {
        this.ed = i2;
    }

    private void aa(int i2) {
        this.dS = i2;
    }

    public final void a(boolean z2) {
        this.dl = z2;
    }

    private void Z(String str) {
        this.dX = str;
    }

    private void a(a aVar) {
        this.dJ = aVar;
    }

    private void aa(String str) {
        this.dT = str;
    }

    private void a(p pVar) {
        this.aH = pVar;
    }

    private void a(HashMap<String, String> map) {
        this.eE = map;
    }

    private void ae(int i2) {
        this.cV = i2;
    }

    private void a(n nVar) {
        this.fd = nVar;
    }

    private void a(b bVar) {
        this.fn = bVar;
    }

    private void a(C0205c c0205c) {
        this.fo = c0205c;
        if (c0205c == null || TextUtils.isEmpty(c0205c.e())) {
            return;
        }
        if (TextUtils.isEmpty(this.eV) && c0205c.e().contains(f10153d)) {
            this.eW = c0205c.e();
        }
        boolean zE = t.e(c0205c.e());
        int iG = t.g(c0205c.e());
        if (zE) {
            this.dp = true;
            v(iG);
        }
    }

    @Override // com.anythink.expressad.foundation.d.h
    public final void a(c.b bVar) {
        this.fp = bVar;
    }

    public static c a(JSONObject jSONObject) {
        c cVar = new c();
        cVar.v(jSONObject.optString("campaignid"));
        cVar.w(jSONObject.optString("packageName"));
        cVar.x(jSONObject.optString("title"));
        cVar.o(jSONObject.optString(a.C0132a.f5846k));
        cVar.y(jSONObject.optString("desc"));
        cVar.dT = jSONObject.optString(L);
        cVar.A(jSONObject.optString("image_url"));
        cVar.dg = jSONObject.optLong("plct");
        cVar.dh = jSONObject.optLong("plctb");
        cVar.cX = jSONObject.optString(f10151c);
        cVar.a(jSONObject.optString(b));
        cVar.d(jSONObject.optString(f10159j));
        cVar.dj = jSONObject.optString(f10160k);
        cVar.dk = jSONObject.optInt("creative_id");
        return cVar;
    }

    private static boolean a(c cVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.anythink.expressad.foundation.b.a.b().h() == 2 && "1".equals(Uri.parse(str).getQueryParameter("dpwgl"))) {
            return true;
        }
        cVar.k(str);
        return false;
    }

    private static c a(JSONObject jSONObject, String str, String str2, String str3, boolean z2, d dVar) {
        return a(jSONObject, str, str2, str3, z2, dVar, "");
    }

    private void ad(int i2) {
        this.eR = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v52, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v53 */
    /* JADX WARN: Type inference failed for: r11v54, types: [com.anythink.expressad.foundation.d.c, com.anythink.expressad.out.j] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.anythink.expressad.foundation.d.c] */
    /* JADX WARN: Type inference failed for: r12v2, types: [com.anythink.expressad.foundation.d.c, com.anythink.expressad.out.j] */
    /* JADX WARN: Type inference failed for: r12v3 */
    public static c a(JSONObject jSONObject, String str, String str2, String str3, boolean z2, d dVar, String str4) {
        ?? cVar;
        ArrayList arrayList;
        JSONObject jSONObjectC = c(jSONObject);
        if (jSONObjectC == null) {
            return null;
        }
        try {
            cVar = new c();
            try {
                String strOptString = jSONObjectC.optString(bh);
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    HashMap<String, String> map = new HashMap<>();
                    for (Iterator<String> itKeys = jSONObject2.keys(); itKeys != null && itKeys.hasNext(); itKeys = itKeys) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.optString(next));
                    }
                    ((c) cVar).eE = map;
                }
                if (!TextUtils.isEmpty(str4)) {
                    ((c) cVar).eL = str4;
                    ((c) cVar).eK = true;
                }
                try {
                    ((c) cVar).eR = jSONObjectC.optInt("ready_rate", -1);
                    JSONObject jSONObjectOptJSONObject = jSONObjectC.optJSONObject(bN);
                    if (jSONObjectOptJSONObject != null) {
                        ((c) cVar).eT = jSONObjectOptJSONObject.toString();
                    }
                    ((c) cVar).eX = jSONObjectC.optInt(d.G);
                    cVar.r(jSONObjectC.optString(d.F));
                    ((c) cVar).eU = jSONObjectC.optInt(d.E);
                    new JSONArray();
                    JSONArray jSONArrayOptJSONArray = jSONObjectC.optJSONArray("pv_urls");
                    if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(jSONArrayOptJSONArray.length());
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                    }
                    ((c) cVar).cZ = arrayList;
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectC.optJSONObject(d.H);
                    if (jSONObjectOptJSONObject2 != null) {
                        ((c) cVar).eY = jSONObjectOptJSONObject2.toString();
                    }
                } catch (Exception unused) {
                }
                cVar.v(jSONObjectC.optString("id"));
                cVar.x(jSONObjectC.optString("title"));
                ((c) cVar).ff = jSONObjectC.optString("unitId", "");
                cVar.y(jSONObjectC.optString("desc"));
                cVar.w(jSONObjectC.optString("package_name"));
                ((c) cVar).ev = jSONObjectC.optInt(av);
                cVar.z(jSONObjectC.optString("icon_url"));
                cVar.A(jSONObjectC.optString("image_url"));
                cVar.B(jSONObjectC.optString(K));
                ((c) cVar).ea = jSONObjectC.optString(J);
                ((c) cVar).dT = h.a(dVar, cVar, jSONObjectC.optString(L));
                ((c) cVar).dV = h.a(dVar, cVar, jSONObjectC.optString("click_url"));
                cVar.aH = p.a(jSONObjectC.optString(aF));
                ((c) cVar).dW = jSONObjectC.optInt(N);
                ((c) cVar).dX = h.a(dVar, cVar, jSONObjectC.optString(O));
                ((c) cVar).dY = jSONObjectC.optBoolean(P, false);
                ((c) cVar).dU = h.a(dVar, cVar, jSONObjectC.optString("notice_url"));
                ((c) cVar).eb = jSONObjectC.optInt("template");
                cVar.p(jSONObjectC.optInt("ad_source_id", 1));
                ((c) cVar).ec = jSONObjectC.optInt(T);
                ((c) cVar).ed = jSONObjectC.optInt(U);
                ((c) cVar).eQ = jSONObjectC.optInt(ah);
                if (!TextUtils.isEmpty(jSONObjectC.optString(Y))) {
                    cVar.a(Double.parseDouble(jSONObjectC.optString(Y, "0")));
                }
                if (!TextUtils.isEmpty(jSONObjectC.optString(Z))) {
                    cVar.o(jSONObjectC.optInt(Z, 333333));
                }
                ((c) cVar).ee = jSONObjectC.optString("click_mode");
                ((c) cVar).ef = jSONObjectC.optString("landing_type");
                ((c) cVar).eu = jSONObjectC.optInt("link_type", 4);
                ((c) cVar).ei = jSONObjectC.optInt(ab);
                cVar.o(jSONObjectC.optString(aa));
                ((c) cVar).eD = jSONObjectC.optString(aw);
                ((c) cVar).fm = jSONObjectC.optInt(ax, 2);
                String strOptString2 = jSONObjectC.optString("video_url");
                ?? IsEmpty = TextUtils.isEmpty(strOptString2);
                if (IsEmpty == 0) {
                    if (z2) {
                        ((c) cVar).en = strOptString2;
                    } else {
                        ((c) cVar).en = com.anythink.expressad.foundation.h.j.b(strOptString2);
                    }
                }
                ((c) cVar).ds = jSONObjectC.optInt(f10171v);
                cVar.q(jSONObjectC.optInt("video_length"));
                ((c) cVar).eo = jSONObjectC.optInt("video_size");
                ((c) cVar).ep = jSONObjectC.optString(af);
                ((c) cVar).eq = jSONObjectC.optInt(ag);
                cVar.a(System.currentTimeMillis());
                ((c) cVar).dZ = h.a(dVar, cVar, str);
                ((c) cVar).er = jSONObjectC.optInt("ctype");
                ((c) cVar).es = jSONObjectC.optString(aj);
                ((c) cVar).et = jSONObjectC.optInt(ak);
                ((c) cVar).ey = str2;
                cVar.n(str3);
                ((c) cVar).ew = jSONObjectC.optString(an);
                ((c) cVar).ex = jSONObjectC.optInt("offer_type");
                ((c) cVar).eB = jSONObjectC.optString("reward_name");
                ((c) cVar).eA = jSONObjectC.optInt("reward_amount");
                try {
                    if (jSONObjectC.has(cj)) {
                        String strA = h.a(dVar, cVar, jSONObjectC.optString(cj));
                        if (!TextUtils.isEmpty(strA)) {
                            ((c) cVar).fe = strA;
                            ((c) cVar).fd = ad(strA);
                        }
                    }
                } catch (Exception unused2) {
                }
                ((c) cVar).eP = jSONObjectC.optInt(bC, 2);
                if (a((c) cVar, jSONObjectC.optString("endcard_url"))) {
                    return null;
                }
                ((c) cVar).fc = jSONObjectC.optInt(bP, 1);
                if (jSONObjectC.has(ar)) {
                    cVar.bK = jSONObjectC.optString(ar);
                }
                if (jSONObjectC.has(bc)) {
                    ((c) cVar).dQ = jSONObjectC.optInt(bc);
                }
                if (jSONObjectC.has(be)) {
                    ((c) cVar).dR = jSONObjectC.optString(be);
                }
                cVar.a(C0205c.a(jSONObjectC.optJSONObject(ck)));
                ((c) cVar).fa = jSONObjectC.optInt(as, 2);
                ((c) cVar).dN = jSONObjectC.optInt(aW, 1);
                ((c) cVar).dO = jSONObjectC.optInt(aX, 1);
                ((c) cVar).dw = jSONObjectC.optInt(aG);
                ((c) cVar).dA = jSONObjectC.optString("ia_icon");
                ((c) cVar).dB = jSONObjectC.optInt("ia_rst");
                ((c) cVar).dC = jSONObjectC.optString("ia_url");
                ((c) cVar).dD = jSONObjectC.optInt("ia_ori");
                ((c) cVar).dE = dVar.d();
                ((c) cVar).db = jSONObjectC.optInt(f10154e);
                ((c) cVar).dc = jSONObjectC.optInt(f10155f);
                ((c) cVar).dF = jSONObjectC.optString(aS);
                ((c) cVar).dG = jSONObjectC.optString(aT);
                ((c) cVar).dH = jSONObjectC.optInt(aU);
                ((c) cVar).dI = jSONObjectC.optString(aV);
                ((c) cVar).dL = jSONObjectC.optInt(aJ);
                ((c) cVar).dK = jSONObjectC.optInt(aI);
                ((c) cVar).dM = jSONObjectC.optString(aK);
                ((c) cVar).dJ = a.a(jSONObjectC.optString(aL, ""));
                ((c) cVar).dg = jSONObjectC.optLong("plct");
                ((c) cVar).dh = jSONObjectC.optLong("plctb");
                ((c) cVar).dk = jSONObjectC.optLong("creative_id");
                String strOptString3 = jSONObjectC.optString("cam_tpl_url");
                Uri uri = Uri.parse(strOptString3);
                if (!TextUtils.isEmpty(uri.getPath()) && (uri.getPath().endsWith(".zip") || uri.getPath().endsWith(".ZIP"))) {
                    cVar.a(strOptString3);
                } else {
                    cVar.d(strOptString3);
                }
                ((c) cVar).dj = jSONObjectC.optString("cam_html");
                ((c) cVar).cX = jSONObjectC.optString("cam_html");
                String strOptString4 = jSONObjectC.optString(f10162m);
                if (!TextUtils.isEmpty(strOptString4)) {
                    ((c) cVar).eN = true;
                    ((c) cVar).eM = strOptString4;
                } else if (!TextUtils.isEmpty(((c) cVar).cX) && !((c) cVar).cX.contains("<MBTPLMARK>")) {
                    ((c) cVar).eN = true;
                } else {
                    ((c) cVar).eN = false;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectC.optJSONArray(aM);
                if (jSONArrayOptJSONArray2 == null) {
                    if (!TextUtils.isEmpty(jSONObjectC.optString(aM))) {
                        ((c) cVar).fr = jSONObjectC.optString(aM);
                    } else {
                        ((c) cVar).fr = null;
                    }
                } else {
                    ((c) cVar).fr = jSONArrayOptJSONArray2.toString();
                }
                try {
                    ((c) cVar).fk = jSONObjectC.optInt(f10166q);
                    ((c) cVar).fl = jSONObjectC.optString(f10167r);
                    ((c) cVar).du = jSONObjectC.optInt(ay);
                    ((c) cVar).de = jSONObjectC.optInt(f10173x, -2);
                    ((c) cVar).df = jSONObjectC.optInt(f10174y, -2);
                    ((c) cVar).dd = jSONObjectC.optInt("adspace_t", 1);
                    ((c) cVar).dv = jSONObjectC.optInt(az);
                    IsEmpty = h.b(jSONObjectC, cVar);
                    try {
                        ((c) IsEmpty).dT = t.a(com.anythink.core.common.b.n.a().g(), IsEmpty.ba(), ((c) IsEmpty).dT);
                    } catch (Exception e2) {
                        com.anythink.expressad.foundation.h.o.d("campaign", e2.getMessage());
                    }
                    IsEmpty.ag(jSONObjectC.optInt(aB, 2));
                    IsEmpty.ah(jSONObjectC.optInt(aA, 1));
                    JSONArray jSONArrayOptJSONArray3 = jSONObjectC.optJSONArray(aC);
                    if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                        ArrayList<Integer> arrayList2 = new ArrayList<>();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                            arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray3.optInt(i3)));
                        }
                        if (arrayList2.size() > 0) {
                            ((c) IsEmpty).fu = arrayList2;
                        }
                    }
                    ((c) IsEmpty).fC = jSONObjectC.optInt(f10156g, 0);
                    return IsEmpty;
                } catch (Exception e3) {
                    e = e3;
                    cVar = IsEmpty;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            cVar = 0;
        }
        e.printStackTrace();
        return cVar;
    }

    public static JSONArray b(List<c> list) {
        JSONArray jSONArray = null;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    try {
                        Iterator<c> it = list.iterator();
                        while (it.hasNext()) {
                            try {
                                jSONArray2.put(a(it.next()));
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                        return jSONArray2;
                    } catch (Exception e2) {
                        e = e2;
                        jSONArray = jSONArray2;
                        e.printStackTrace();
                        return jSONArray;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return jSONArray;
    }

    private static List<Map<Integer, String>> b(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                try {
                    String string = jSONArray.getString(i2);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObject = new JSONObject(string);
                        HashMap map = new HashMap();
                        int i3 = jSONObject.getInt("rate");
                        map.put(Integer.valueOf(i3), jSONObject.getString("url"));
                        arrayList.add(map);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return arrayList;
    }

    private static n a(JSONObject jSONObject, n nVar) {
        nVar.a(a(jSONObject.optJSONArray(h.cK)));
        nVar.b(a(jSONObject.optJSONArray(h.cL)));
        nVar.c(a(jSONObject.optJSONArray(h.cM)));
        return nVar;
    }

    private static String[] a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            strArr[i2] = jSONArray.optString(i2);
        }
        return strArr;
    }

    public static JSONObject a(c cVar, boolean z2, boolean z3) throws JSONException {
        JSONObject jSONObjectA = a(cVar);
        jSONObjectA.put("isReady", z2);
        jSONObjectA.put("expired", z3);
        return jSONObjectA;
    }

    public static JSONObject a(c cVar) throws JSONException {
        C0205c c0205c;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", cVar.aZ());
        jSONObject.put(ay, cVar.du);
        jSONObject.put(az, cVar.dv);
        jSONObject.put("adspace_t", cVar.dd);
        jSONObject.put(f10174y, cVar.df);
        jSONObject.put(f10173x, cVar.de);
        if (!TextUtils.isEmpty(cVar.ff)) {
            jSONObject.put("unitId", cVar.ff);
        }
        if (!TextUtils.isEmpty(cVar.eT)) {
            try {
                jSONObject.put(bN, new JSONObject(cVar.eT));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(cVar.eY)) {
            try {
                jSONObject.put(d.H, new JSONObject(cVar.eY));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        List<String> list = cVar.cZ;
        if (list != null && list.size() > 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = cVar.cZ.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next());
                }
                jSONObject.put("pv_urls", jSONArray);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(cVar.eV)) {
            jSONObject.put(d.G, cVar.eX);
            jSONObject.put(d.F, cVar.eV);
            jSONObject.put(d.E, cVar.eU);
        }
        jSONObject.put("ready_rate", cVar.eR);
        jSONObject.put("title", cVar.bb());
        jSONObject.put("desc", cVar.bc());
        jSONObject.put("package_name", cVar.ba());
        jSONObject.put(av, cVar.ev);
        jSONObject.put("icon_url", cVar.bd());
        jSONObject.put("image_url", cVar.be());
        jSONObject.put(K, cVar.bh());
        jSONObject.put(J, cVar.ea);
        jSONObject.put(L, cVar.dT);
        jSONObject.put("click_url", cVar.dV);
        p pVar = cVar.aH;
        if (pVar != null) {
            jSONObject.put(aF, pVar.c());
        }
        jSONObject.put(N, cVar.dW);
        jSONObject.put(O, cVar.dX);
        jSONObject.put(P, cVar.dY);
        jSONObject.put("notice_url", cVar.dU);
        jSONObject.put("template", cVar.eb);
        jSONObject.put("ad_source_id", cVar.bf());
        jSONObject.put(T, cVar.ec);
        jSONObject.put(U, cVar.ed);
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.aX());
        jSONObject.put(Y, sb.toString());
        jSONObject.put(Z, cVar.aY());
        jSONObject.put("click_mode", cVar.ee);
        jSONObject.put("landing_type", cVar.ef);
        jSONObject.put("link_type", cVar.eu);
        jSONObject.put(ab, cVar.ei);
        jSONObject.put(aa, cVar.cU);
        jSONObject.put(ah, cVar.eQ);
        jSONObject.put(ax, cVar.fm);
        jSONObject.put("video_url", cVar.en);
        jSONObject.put("video_length", cVar.bi());
        jSONObject.put("video_size", cVar.eo);
        jSONObject.put(af, cVar.ep);
        jSONObject.put(ag, cVar.eq);
        jSONObject.put(aw, cVar.eD);
        jSONObject.put(d.f10217g, cVar.dZ);
        jSONObject.put("ctype", cVar.er);
        jSONObject.put(ak, cVar.et);
        jSONObject.put(aj, cVar.es);
        jSONObject.put(d.f10216f, cVar.ey);
        jSONObject.put(d.f10221k, cVar.ez);
        jSONObject.put(an, cVar.ew);
        jSONObject.put("offer_type", cVar.ex);
        jSONObject.put("reward_amount", cVar.eA);
        jSONObject.put("reward_name", cVar.eB);
        jSONObject.put(be, cVar.dR);
        if (w.b(cVar.fe)) {
            jSONObject.put(cj, new JSONObject(cVar.fe));
        }
        jSONObject.put(bC, cVar.eP);
        jSONObject.put("endcard_url", cVar.I());
        jSONObject.put(bP, cVar.fc);
        if (cVar != null && (c0205c = cVar.fo) != null && w.b(c0205c.a())) {
            jSONObject.put(ck, new JSONObject(cVar.fo.a()));
        }
        jSONObject.put(ar, cVar.bK);
        jSONObject.put(as, cVar.fa);
        jSONObject.put(aX, cVar.dO);
        jSONObject.put(aW, cVar.dN);
        jSONObject.put(aG, cVar.dw);
        jSONObject.put("ia_icon", cVar.dA);
        jSONObject.put("ia_rst", cVar.dB);
        jSONObject.put("ia_url", cVar.dC);
        jSONObject.put("ia_ori", cVar.dD);
        jSONObject.put("ad_type", cVar.dE);
        jSONObject.put(aS, cVar.dF);
        jSONObject.put(aT, cVar.dG);
        jSONObject.put(aU, cVar.dH);
        jSONObject.put(aV, cVar.dI);
        jSONObject.put(aI, cVar.dK);
        jSONObject.put(aJ, cVar.dL);
        jSONObject.put(aK, cVar.dM);
        a aVar = cVar.dJ;
        if (aVar != null) {
            jSONObject.put(aL, new JSONObject(aVar.a()));
        }
        jSONObject.put("plct", cVar.dg);
        jSONObject.put("plctb", cVar.dh);
        jSONObject.put(aM, cVar.fr);
        jSONObject.put("creative_id", cVar.dk);
        jSONObject.put("cam_html", cVar.dj);
        String str = cVar.di;
        if (str == null) {
            str = cVar.cW;
        }
        jSONObject.put("cam_tpl_url", str);
        jSONObject.put(f10162m, cVar.eM);
        jSONObject.put(f10163n, cVar.eM);
        jSONObject.put("timestamp", cVar.bg());
        jSONObject.put("hb", cVar.eK);
        jSONObject.put(f10166q, cVar.fk);
        jSONObject.put(f10167r, cVar.fl);
        int i2 = cVar.dm;
        if (i2 <= 0) {
            i2 = 1;
        }
        jSONObject.put("vcn", i2);
        int i3 = cVar.dn;
        if (i3 != 1) {
            i3 = 0;
        }
        jSONObject.put("token_r", i3);
        jSONObject.put("encrypt_p", cVar.f60do);
        jSONObject.put(f10171v, cVar.ds);
        jSONObject.put(aC, cVar.fu);
        jSONObject.put(aB, cVar.fv);
        jSONObject.put(aA, cVar.fw);
        jSONObject.put(f10154e, cVar.db);
        jSONObject.put(f10155f, cVar.dc);
        try {
            jSONObject.put("misk_spt", com.anythink.core.common.p.a().c());
            com.anythink.core.common.p.a();
            jSONObject.put("misk_spt_det", com.anythink.core.common.p.b());
        } catch (JSONException unused) {
        }
        jSONObject.put(f10156g, cVar.fC);
        if (cVar == null) {
            return jSONObject;
        }
        jSONObject.put(h.cw, cVar.aW());
        jSONObject.put(h.cx, cVar.aV());
        jSONObject.put(h.cA, cVar.aU());
        jSONObject.put("ttc_type", cVar.aT());
        jSONObject.put(h.cC, cVar.aS());
        jSONObject.put(h.cD, cVar.aN());
        jSONObject.put(h.cE, com.anythink.expressad.foundation.h.j.a(cVar.aO()));
        jSONObject.put(h.cF, cVar.aP());
        jSONObject.put(h.cp, cVar.aI());
        jSONObject.put(h.cq, cVar.aH());
        if (cVar.aG() != null) {
            jSONObject.put(h.cr, cVar.aG().g());
        }
        jSONObject.put(h.cG, cVar.aQ());
        jSONObject.put(h.cH, cVar.aR());
        jSONObject.put(bc, cVar.dQ);
        jSONObject.put(h.ct, cVar.aK());
        jSONObject.put(h.cs, cVar.aJ());
        jSONObject.put(h.cu, cVar.aL());
        jSONObject.put(h.cv, cVar.aM());
        return jSONObject;
    }

    private void a(ArrayList<Integer> arrayList) {
        this.fu = arrayList;
    }

    public final boolean a(long j2, long j3) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.dg <= 0 ? bg() + j2 >= jCurrentTimeMillis : bg() + (this.dg * 1000) >= jCurrentTimeMillis) {
            return false;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        return this.dh > 0 ? bg() + (this.dh * 1000) >= jCurrentTimeMillis2 : bg() + j3 >= jCurrentTimeMillis2;
    }
}
