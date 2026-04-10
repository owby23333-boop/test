package com.bytedance.sdk.openadsdk.core.iq;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.sdk.openadsdk.core.iq.b;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.kwad.sdk.api.model.AdnName;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1185a;
    private boolean ao;
    private t aq;
    private String b;
    private zx bb;
    private int bg;
    private iq bp;
    private y bv;
    private int by;
    private i c;
    private String cb;
    private uf ct;
    private int da;
    private com.bytedance.sdk.openadsdk.core.dislike.dl.g dl;
    private gb ec;
    private qd en;
    private boolean eo;
    private String ep;
    private int ey;
    private com.bytedance.sdk.openadsdk.ls.dl.dl.g f;
    private JSONObject fo;
    private int fp;
    private String fq;
    private boolean fs;
    private String fv;
    private int fx;
    public String g;
    private eo gb;
    private gk gc;
    private kb gd;
    private long gk;
    private int gl;
    private int gm;
    private oq gw;
    private String gz;
    private long h;
    private com.bytedance.sdk.openadsdk.core.ugeno.m.z hb;
    private int he;
    private JSONObject hh;
    private long hn;
    private boolean hs;
    private volatile JSONObject ib;
    private int io;
    private q iq;
    private int ja;
    private int jc;
    private boolean k;
    private String ka;
    private p kg;
    private rv kp;
    private int ks;
    private String kv;
    private String l;
    private boolean la;
    private String li;
    private long lk;
    private int lq;
    private long ls;
    private String ly;
    private boolean lz;
    private String m;
    private tf mc;
    private JSONObject me;
    private String mj;
    private js mk;
    private int mn;
    private m mt;
    private hh mz;
    private String n;
    private b nb;
    private v no;
    private int nv;
    private int o;
    private mc oc;
    private lq ou;
    private String p;
    private long pc;
    private int pd;
    private String pf;
    private String po;
    private gc q;
    private int qd;
    private vm qz;
    private JSONObject r;
    private String re;
    private String rg;
    private String rh;
    private String rw;
    private io ry;
    private String s;
    private String sf;
    private JSONObject st;
    private com.bytedance.sdk.openadsdk.core.ugeno.fo.z su;
    private String sy;
    private xl sz;
    private boolean t;
    private int td;
    private ti te;
    private boolean ti;
    private JSONObject tk;
    private JSONObject to;
    private int tp;
    private x ts;
    private String u;
    private String uf;
    private String um;
    private int un;
    private int ux;
    private JSONObject uy;
    private int vd;
    private int vj;
    private tc vk;
    private tb vm;
    private int vt;
    private int vx;
    private sv vy;
    private JSONObject w;
    private int wn;
    private String wo;
    private String wp;
    private String wx;
    private int x;
    private String xo;
    private int xt;
    private Map<String, Object> y;
    private sy yd;
    private boolean yw;
    private int yx;
    private int yz;
    public ja z;
    private gp zb;
    private ec zd;
    private JSONObject zr;
    private ls zw;
    private int e = -1;
    private List<gk> kb = new ArrayList();
    private List<String> i = new ArrayList();
    private List<String> v = new ArrayList();
    private String js = "0";
    private String tb = "0";
    private int oq = -1;
    private long wj = -1;
    private long na = -1;
    private long xl = System.currentTimeMillis();
    private String j = UUID.randomUUID().toString();
    private String gp = "";
    private int jq = IOfflineCompo.Priority.HIGHEST;
    private int sv = 0;
    private int zx = 1;
    private int lw = 0;
    private int rv = 0;
    private int tc = 0;
    private int nh = 1;
    private int bm = 0;
    private int sd = 0;
    private int tf = 0;
    private int zz = 1;
    private boolean vo = false;
    private int yt = 1;
    private float dt = 100.0f;
    private int xf = 0;
    private int bw = 2;
    private int gy = 0;
    private int dh = 100;
    private int hy = 2;
    private int lt = 2;
    private float jz = 0.07f;
    private float oz = 0.0f;
    private long jt = 0;
    private boolean zt = true;
    private int jh = -1;
    private int cn = 0;
    private int fn = 0;
    private long jv = 0;
    private int sa = 0;
    private List<h> ia = new ArrayList();

    public void z(h hVar) {
        if (hVar == null) {
            return;
        }
        if (this.ia == null) {
            this.ia = new ArrayList();
        }
        this.ia.add(hVar);
    }

    public h z(String str) {
        List<h> list = this.ia;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < this.ia.size(); i++) {
                h hVar = this.ia.get(i);
                if (hVar != null) {
                    String strZ = hVar.z();
                    if (!TextUtils.isEmpty(strZ) && strZ.equals(str)) {
                        return hVar;
                    }
                }
            }
        }
        return null;
    }

    public boolean z() {
        return this.ao;
    }

    public void z(boolean z) {
        this.ao = z;
    }

    public int g() {
        return this.td;
    }

    public void z(int i) {
        this.td = i;
    }

    public void g(int i) {
        this.vd = i;
    }

    public int dl() {
        return this.vd;
    }

    public boolean a() {
        return this.la && kb();
    }

    public void g(boolean z) {
        this.la = z;
    }

    public void dl(int i) {
        this.bg = i;
    }

    public void a(int i) {
        if (this.fx == 0) {
            this.fx = i;
        }
    }

    public int gc() {
        return this.fx;
    }

    public int m() {
        return this.bg;
    }

    public boolean e() {
        return m() == 1;
    }

    public void gc(int i) {
        this.vx = i;
    }

    public int gz() {
        return this.vx;
    }

    public boolean fo() {
        return this.vx == 1;
    }

    public void m(int i) {
        this.ks = i;
    }

    public int uy() {
        return this.ks;
    }

    public boolean kb() {
        return uy() == 1;
    }

    public void e(int i) {
        this.da = i;
    }

    public int wp() {
        return this.da;
    }

    public boolean i() {
        return wp() == 1;
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.kg = new p();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_template_info");
            if (jSONObjectOptJSONObject != null) {
                this.kg.z(jSONObjectOptJSONObject.optString("lottie_tmp_url"));
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("aigc");
            if (jSONObjectOptJSONObject2 != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2.optJSONArray("bg_anim_img_android");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    this.kg.z(arrayList);
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray.optJSONObject(i);
                        if (jSONObjectOptJSONObject3 != null) {
                            gk gkVar = new gk();
                            gkVar.z(jSONObjectOptJSONObject3.optInt(MediaFormat.KEY_WIDTH));
                            gkVar.g(jSONObjectOptJSONObject3.optInt(MediaFormat.KEY_HEIGHT));
                            gkVar.z(jSONObjectOptJSONObject3.optString("url"));
                            arrayList.add(gkVar);
                        }
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject2.optJSONArray("bg_videos");
                if (jSONArrayOptJSONArray2 != null) {
                    ArrayList arrayList2 = new ArrayList();
                    this.kg.g(arrayList2);
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                        JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray2.optJSONObject(i2);
                        if (jSONObjectOptJSONObject4 != null) {
                            com.bykv.vk.openvk.component.video.api.dl.dl dlVar = new com.bykv.vk.openvk.component.video.api.dl.dl();
                            dlVar.gc(jSONObjectOptJSONObject4.optString("file_hash"));
                            dlVar.z(jSONObjectOptJSONObject4.optString(an.z));
                            dlVar.z(jSONObjectOptJSONObject4.optDouble("video_duration"));
                            dlVar.dl(jSONObjectOptJSONObject4.optString("video_url"));
                            arrayList2.add(dlVar);
                        }
                    }
                }
            }
        }
    }

    public p v() {
        return this.kg;
    }

    public boolean pf() {
        return this.hs;
    }

    public void dl(boolean z) {
        this.hs = z;
    }

    public String ls() {
        return this.ep;
    }

    public void g(String str) {
        this.ep = str;
    }

    public String p() {
        return this.rw;
    }

    public void dl(String str) {
        this.rw = str;
    }

    public int fv() {
        return this.gl;
    }

    public void gz(int i) {
        this.gl = i;
    }

    public String js() {
        return this.po;
    }

    public void a(String str) {
        this.po = str;
    }

    public String tb() {
        return this.rg;
    }

    public void gc(String str) {
        this.rg = str;
    }

    public void a(boolean z) {
        this.fs = z;
    }

    public boolean q() {
        return this.fs;
    }

    public void g(JSONObject jSONObject) {
        this.ib = jSONObject;
    }

    public JSONObject iq() {
        return this.ib;
    }

    public static boolean z(na naVar) {
        return naVar != null && naVar.xl() == 1;
    }

    public static boolean g(na naVar) {
        if (naVar == null) {
            return false;
        }
        return naVar.ou() == 5 || naVar.ou() == 15 || naVar.ou() == 166;
    }

    public static boolean dl(na naVar) {
        try {
            if (naVar.rw() != null) {
                if (naVar.rw().optInt("parent_type") == 1) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public long zw() {
        return this.lk;
    }

    public void z(long j) {
        this.lk = j;
    }

    public String io() {
        return this.u;
    }

    public void m(String str) {
        this.u = str;
    }

    public void g(long j) {
        this.pc = j;
    }

    public long uf() {
        return this.pc;
    }

    public void fo(int i) {
        this.vj = i;
    }

    public int sy() {
        if (js.a(this)) {
            return 0;
        }
        return this.vj;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.m.z hh() {
        return this.hb;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.m.z zVar) {
        this.hb = zVar;
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVar) {
        this.su = zVar;
    }

    public com.bytedance.sdk.openadsdk.core.ugeno.fo.z l() {
        return this.su;
    }

    public String h() {
        return this.sf;
    }

    public void e(String str) {
        this.sf = str;
    }

    public boolean gk() {
        return this.yw;
    }

    public void gc(boolean z) {
        this.yw = z;
    }

    public String x() {
        return this.s;
    }

    public void gz(String str) {
        this.s = str;
    }

    public String lq() {
        return this.wo;
    }

    public void fo(String str) {
        this.wo = str;
    }

    public boolean mc() {
        return this.k;
    }

    public void m(boolean z) {
        this.k = z;
    }

    public void dl(long j) {
        this.hn = j;
    }

    public String un() {
        return this.ly;
    }

    public void uy(String str) {
        this.ly = str;
    }

    public long ti() {
        return this.hn;
    }

    public void kb(String str) {
        this.n = str;
    }

    public void uy(int i) {
        this.ux = i;
    }

    public int eo() {
        return this.ux;
    }

    public int oq() {
        return this.lt;
    }

    public void z(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.lt = 2;
        } else {
            this.lt = (int) d;
        }
    }

    public int wj() {
        return this.hy;
    }

    public void g(double d) {
        if (d != 2.0d && d != 1.0d) {
            this.hy = 2;
        } else {
            this.hy = (int) d;
        }
    }

    public int na() {
        return this.lq;
    }

    public void kb(int i) {
        this.lq = i;
    }

    public int xl() {
        return this.tf;
    }

    public void wp(int i) {
        this.tf = i;
    }

    public gb j() {
        return this.ec;
    }

    public void z(gb gbVar) {
        this.ec = gbVar;
    }

    public x gp() {
        return this.ts;
    }

    public void z(x xVar) {
        this.ts = xVar;
    }

    public int t() {
        return this.lw;
    }

    public void i(int i) {
        this.lw = i;
    }

    public boolean vm() {
        return this.lw == 1;
    }

    public t y() {
        return this.aq;
    }

    public void z(t tVar) {
        this.aq = tVar;
    }

    public vm ec() {
        return this.qz;
    }

    public void z(vm vmVar) {
        this.qz = vmVar;
    }

    public String bv() {
        return this.rh;
    }

    public void wp(String str) {
        this.rh = str;
    }

    public int gb() {
        return this.tp;
    }

    public void v(int i) {
        this.tp = i;
    }

    public js jq() {
        return this.mk;
    }

    public void z(js jsVar) {
        this.mk = jsVar;
    }

    public qd sv() {
        return this.en;
    }

    public void z(qd qdVar) {
        this.en = qdVar;
    }

    public int f() {
        return this.tc;
    }

    public void pf(int i) {
        this.tc = i;
    }

    public int yx() {
        return this.jh;
    }

    public void ls(int i) {
        this.jh = i;
    }

    public int qd() {
        return this.rv;
    }

    public void p(int i) {
        this.rv = i;
    }

    public int zx() {
        return this.zx;
    }

    public void fv(int i) {
        this.zx = i;
    }

    public int b() {
        if (tk() != 100.0f || vm.z(this) == 2) {
            return 0;
        }
        return this.sv;
    }

    public void js(int i) {
        this.sv = i;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.dl.g lw() {
        return this.f;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.dl.g gVar) {
        if (gVar == null) {
            if (this.f != null) {
                this.f = new dl(this.f);
                return;
            }
            return;
        }
        this.f = gVar;
    }

    public int rv() {
        return this.yx;
    }

    public void tb(int i) {
        this.yx = i;
    }

    public int tc() {
        return this.qd;
    }

    public void q(int i) {
        this.qd = i;
    }

    public int me() {
        return this.jq;
    }

    public void iq(int i) {
        this.jq = i;
    }

    public int nh() {
        return this.nh;
    }

    public void zw(int i) {
        this.nh = i;
    }

    public int r() {
        return this.yz;
    }

    public void io(int i) {
        this.yz = i;
    }

    public void uf(int i) {
        this.zz = i;
    }

    public int yz() {
        return this.zz;
    }

    public int bm() {
        b bVar = this.nb;
        if (bVar == null) {
            return 1;
        }
        return bVar.z();
    }

    public String sd() {
        b bVar = this.nb;
        return bVar == null ? "" : bVar.g();
    }

    public boolean tf() {
        b bVar = this.nb;
        return bVar == null || bVar.dl();
    }

    public int ja() {
        b bVar = this.nb;
        if (bVar == null) {
            return 50;
        }
        return bVar.a();
    }

    public int wn() {
        b bVar = this.nb;
        if (bVar == null) {
            return 236;
        }
        return bVar.gc();
    }

    public int nb() {
        b bVar = this.nb;
        if (bVar == null) {
            return 82;
        }
        return bVar.m();
    }

    public int zz() {
        b bVar = this.nb;
        if (bVar == null) {
            return 56;
        }
        return bVar.e();
    }

    public int vo() {
        b bVar = this.nb;
        if (bVar == null) {
            return 0;
        }
        return bVar.fo();
    }

    public String lk() {
        b bVar = this.nb;
        return bVar == null ? "#008DEA" : bVar.uy();
    }

    public String u() {
        b bVar = this.nb;
        return bVar == null ? "点击查看" : bVar.kb();
    }

    public int sf() {
        b bVar = this.nb;
        if (bVar == null) {
            return 0;
        }
        return bVar.gz();
    }

    public int yw() {
        return this.gm;
    }

    public void sy(int i) {
        this.gm = i;
    }

    public int s() {
        return this.mn;
    }

    public void hh(int i) {
        this.mn = i;
    }

    public b.g n() {
        b bVar = this.nb;
        if (bVar != null) {
            return bVar.wp();
        }
        return null;
    }

    public b.g ly() {
        b bVar = this.nb;
        if (bVar != null) {
            return bVar.i();
        }
        return null;
    }

    public b.z hn() {
        b bVar = this.nb;
        if (bVar != null) {
            return bVar.v();
        }
        return null;
    }

    private float lf() {
        if (this.nb == null) {
            return 5.0f;
        }
        return r0.pf();
    }

    public int wo() {
        rv rvVar = this.kp;
        if (rvVar == null) {
            return 2;
        }
        return rvVar.z();
    }

    public int k() {
        rv rvVar = this.kp;
        if (rvVar == null) {
            return 16;
        }
        return rvVar.g();
    }

    public int wx() {
        rv rvVar = this.kp;
        if (rvVar == null) {
            return 30;
        }
        return rvVar.dl();
    }

    public int cb() {
        zx zxVar = this.bb;
        if (zxVar == null) {
            return 0;
        }
        return zxVar.z();
    }

    public int o() {
        zx zxVar = this.bb;
        if (zxVar == null) {
            return 90;
        }
        return zxVar.g();
    }

    public int yt() {
        zx zxVar = this.bb;
        if (zxVar == null) {
            return 90;
        }
        return zxVar.dl();
    }

    public tb dt() {
        return this.vm;
    }

    public void z(tb tbVar) {
        this.vm = tbVar;
    }

    public JSONObject xo() {
        return this.to;
    }

    public void dl(JSONObject jSONObject) {
        this.to = jSONObject;
    }

    public b xf() {
        return this.nb;
    }

    public void z(b bVar) {
        this.nb = bVar;
    }

    public m bw() {
        return this.mt;
    }

    public void z(m mVar) {
        this.mt = mVar;
    }

    public String gy() {
        return this.um;
    }

    public void i(String str) {
        this.um = str;
    }

    public int dh() {
        return this.ey;
    }

    public void l(int i) {
        this.ey = i;
    }

    public int zb() {
        return this.xt;
    }

    public void h(int i) {
        if (i != 1) {
            i = 0;
        }
        this.xt = i;
    }

    public void z(tf tfVar) {
        this.mc = tfVar;
    }

    public tf zd() {
        return this.mc;
    }

    public int te() {
        return this.un;
    }

    public void gk(int i) {
        this.un = i;
    }

    public String hy() {
        return this.uf;
    }

    public void v(String str) {
        this.uf = str;
    }

    public int lt() {
        return this.f1185a;
    }

    public void x(int i) {
        this.f1185a = i;
    }

    public gk kp() {
        return this.gc;
    }

    public void z(gk gkVar) {
        this.gc = gkVar;
    }

    public String fp() {
        return this.m;
    }

    public void pf(String str) {
        this.m = str;
    }

    public int vt() {
        return this.e;
    }

    public void lq(int i) {
        this.e = i;
    }

    public String pd() {
        return this.gz;
    }

    public void ls(String str) {
        this.gz = str;
    }

    public JSONObject gm() {
        return this.fo;
    }

    public void a(JSONObject jSONObject) {
        this.fo = jSONObject;
    }

    public JSONObject mn() {
        return this.uy;
    }

    public void gc(JSONObject jSONObject) {
        this.uy = jSONObject;
    }

    public List<gk> jz() {
        return this.kb;
    }

    public void g(gk gkVar) {
        this.kb.add(gkVar);
    }

    public String oz() {
        return this.wp;
    }

    public void p(String str) {
        this.wp = str;
    }

    public List<String> bb() {
        return this.i;
    }

    public List<String> by() {
        return this.v;
    }

    public String li() {
        return this.pf;
    }

    public void fv(String str) {
        this.pf = str;
    }

    public long jc() {
        return this.ls;
    }

    public void a(long j) {
        this.ls = j;
    }

    public String he() {
        return this.p;
    }

    public void js(String str) {
        this.p = str;
    }

    public String no() {
        return this.fv;
    }

    public void tb(String str) {
        this.fv = str;
    }

    public String mj() {
        return this.js;
    }

    public void q(String str) {
        this.js = str;
    }

    public gc c() {
        return this.q;
    }

    public void z(gc gcVar) {
        this.q = gcVar;
    }

    public q gw() {
        return this.iq;
    }

    public void z(q qVar) {
        this.iq = qVar;
    }

    public ls vy() {
        return this.zw;
    }

    public void z(ls lsVar) {
        this.zw = lsVar;
    }

    public String vk() {
        return this.sy;
    }

    public void iq(String str) {
        this.sy = str;
    }

    public int pc() {
        return this.ja;
    }

    public void mc(int i) {
        this.ja = i;
    }

    public int qz() {
        return this.wn;
    }

    public void un(int i) {
        this.wn = Math.max(0, i);
    }

    public String aq() {
        return this.l;
    }

    public void zw(String str) {
        this.l = str;
    }

    public String mk() {
        return this.tb;
    }

    public void io(String str) {
        this.tb = str;
    }

    public JSONObject en() {
        if (this.hh == null) {
            try {
                if (!TextUtils.isEmpty(this.sy)) {
                    this.hh = new JSONObject(this.sy);
                }
            } catch (JSONException unused) {
            }
        }
        return this.hh;
    }

    public String oc() {
        try {
            return en().optString("convert_id", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public int ou() {
        return this.io;
    }

    public void ti(int i) {
        this.io = i;
    }

    public long bp() {
        return this.h;
    }

    public void gc(long j) {
        this.h = j;
    }

    public long mt() {
        return this.gk;
    }

    public void m(long j) {
        this.gk = j;
    }

    public int um() {
        return this.x;
    }

    public void eo(int i) {
        this.x = i;
    }

    public boolean ey() {
        return this.ti;
    }

    public void e(boolean z) {
        this.ti = z;
    }

    public boolean xt() {
        return this.eo;
    }

    public void gz(boolean z) {
        this.eo = z;
    }

    public long re() {
        return this.xl;
    }

    public void e(long j) {
        this.xl = j;
    }

    public String jt() {
        return this.j;
    }

    public void uf(String str) {
        this.j = str;
    }

    public void sy(String str) {
        this.gp = str;
    }

    public String ux() {
        return this.gp;
    }

    public boolean gd() {
        return (TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.un.eo.uy(this)) || TextUtils.isEmpty(this.gp) || com.bytedance.sdk.openadsdk.core.un.eo.uy(this).contains(this.gp)) ? false : true;
    }

    public int zt() {
        return this.oq;
    }

    public void oq(int i) {
        this.oq = i;
    }

    public long to() {
        return this.wj;
    }

    public void gz(long j) {
        this.wj = j;
    }

    public long lz() {
        return this.na;
    }

    public void fo(long j) {
        this.na = j;
    }

    public boolean jh() {
        return this.t;
    }

    public void fo(boolean z) {
        this.t = z;
    }

    public Map<String, Object> fq() {
        return this.y;
    }

    public void z(Map<String, Object> map) {
        this.y = map;
    }

    public JSONObject rw() {
        return this.me;
    }

    public void m(JSONObject jSONObject) {
        this.me = jSONObject;
    }

    public JSONObject gl() {
        return this.r;
    }

    public void e(JSONObject jSONObject) {
        this.r = jSONObject;
    }

    public String po() {
        return this.b;
    }

    public void hh(String str) {
        this.b = str;
    }

    public int rg() {
        return this.bm;
    }

    public boolean fs() {
        return rg() == 1;
    }

    public void wj(int i) {
        this.bm = i;
    }

    public boolean ib() {
        return ep() == 1;
    }

    public int ep() {
        return this.sd;
    }

    public void na(int i) {
        this.sd = i;
    }

    public String ry() {
        return this.g;
    }

    public void l(String str) {
        this.g = str;
    }

    public void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar) {
        this.dl = gVar;
    }

    public com.bytedance.sdk.openadsdk.core.dislike.dl.g ct() {
        com.bytedance.sdk.openadsdk.core.dislike.g.z();
        return this.dl;
    }

    public gp w() {
        return this.zb;
    }

    public void z(gp gpVar) {
        this.zb = gpVar;
    }

    public mc cn() {
        return this.oc;
    }

    public void z(mc mcVar) {
        this.oc = mcVar;
    }

    public String ka() {
        return this.cb;
    }

    public void h(String str) {
        this.cb = str;
    }

    public boolean rh() {
        return tp() != 1;
    }

    public int tp() {
        return this.o;
    }

    public void xl(int i) {
        this.o = i;
    }

    public String nv() {
        return this.wx;
    }

    public void gk(String str) {
        this.wx = str;
    }

    public int zr() {
        if (this.yt != 2) {
            this.yt = 1;
        }
        return this.yt;
    }

    public void j(int i) {
        this.yt = i;
    }

    public float tk() {
        if (this.dt <= 0.0f) {
            this.dt = 100.0f;
        }
        return (this.dt * 1000.0f) / 1000.0f;
    }

    public void x(String str) {
        this.re = str;
    }

    public String st() {
        return this.re;
    }

    public void uy(long j) {
        if (j != 0) {
            this.jt = j;
        } else {
            this.jt = System.currentTimeMillis() / 1000;
        }
    }

    public long mz() {
        return this.jt;
    }

    public void z(float f) {
        this.dt = f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            na naVar = (na) obj;
            if (this.js.equals(naVar.js) && this.sy.equals(naVar.sy)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.js.hashCode() * 31) + this.sy.hashCode();
    }

    public boolean ts() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this)) {
            return true;
        }
        if (this.kb.isEmpty()) {
            return false;
        }
        if (this.io == 4 && this.kb.size() < 3) {
            return false;
        }
        Iterator<gk> it = this.kb.iterator();
        while (it.hasNext()) {
            if (!it.next().gc()) {
                return false;
            }
        }
        return true;
    }

    public boolean sz() {
        if (ct() != null) {
            return ct().gc();
        }
        return false;
    }

    public int fn() {
        return this.fp;
    }

    public void gp(int i) {
        if (i < 12) {
            i = 12;
        }
        if (i > 20) {
            i = 20;
        }
        this.fp = i;
    }

    public int hs() {
        return this.vt;
    }

    public void t(int i) {
        if (i < 0 || i > 180) {
            this.vt = 50;
        } else {
            this.vt = i;
        }
    }

    public boolean jv() {
        int iV = com.bytedance.sdk.openadsdk.core.un.eo.v(this);
        return iV == 3 || iV == 6;
    }

    public String sa() {
        if (!TextUtils.isEmpty(this.xo)) {
            this.xo = this.xo.trim();
        }
        return this.xo;
    }

    public void lq(String str) {
        this.xo = str;
    }

    public int yd() {
        return this.xf;
    }

    public void vm(int i) {
        this.xf = i;
    }

    public int kg() {
        return this.dh;
    }

    public void y(int i) {
        if (i < 0 || i > 100) {
            return;
        }
        this.dh = i;
    }

    public JSONObject bg() {
        return this.w;
    }

    public void gz(JSONObject jSONObject) {
        this.w = jSONObject;
    }

    public io vx() {
        return this.ry;
    }

    public uf ks() {
        return this.ct;
    }

    public void z(io ioVar) {
        this.ry = ioVar;
        if (ioVar != null) {
            String strG = ioVar.g();
            String strDl = this.ry.dl();
            if (TextUtils.isEmpty(strG)) {
                return;
            }
            com.bytedance.sdk.openadsdk.core.ugeno.uy.z(strG, strDl, (com.bytedance.sdk.openadsdk.core.ugeno.dl) null);
        }
    }

    public void z(uf ufVar) {
        this.ct = ufVar;
    }

    public int da() {
        return js.gz(this);
    }

    public int td() {
        JSONObject jSONObject = this.fo;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public ec ao() {
        return this.zd;
    }

    public void z(ec ecVar) {
        this.zd = ecVar;
    }

    public ti ia() {
        return this.te;
    }

    public void z(ti tiVar) {
        this.te = tiVar;
    }

    public float la() {
        float f = this.jz;
        if (f < 0.07f || f > 0.175f) {
            this.jz = 0.07f;
        }
        return this.jz;
    }

    public void g(float f) {
        this.jz = f;
    }

    public float vd() {
        float f = this.oz;
        if (f < 0.0f || f > 50.0f) {
            this.oz = 0.0f;
        }
        return this.oz;
    }

    public void dl(float f) {
        this.oz = f;
    }

    public ja fx() {
        return this.z;
    }

    public void z(ja jaVar) {
        this.z = jaVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public JSONObject kv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("s_sig_ts", st());
            jSONObject.put("ad_rec_stamp", mz());
            jSONObject.put("interaction_type", lt());
            jSONObject.put("target_url", fp());
            jSONObject.put("use_media_video_player", xl());
            jSONObject.put("landing_scroll_percentage", vt());
            jSONObject.put("gecko_id", pd());
            jSONObject.put("extension", gm());
            jSONObject.put("overlay", mn());
            jSONObject.put(MediationConstant.EXTRA_ADID, mj());
            jSONObject.put("source", hy());
            jSONObject.put(an.o, ry());
            jSONObject.put("screenshot", ey());
            jSONObject.put("play_bar_style", b());
            jSONObject.put("play_bar_show_time", me());
            jSONObject.put("if_block_lp", t());
            jSONObject.put("cache_sort", nh());
            jSONObject.put("if_sp_cache", r());
            jSONObject.put("splash_timeout_stage", yz());
            jSONObject.put("is_from_local_cache", xt());
            jSONObject.put("is_from_cache_type", zt());
            jSONObject.put("correct_action_code", to());
            jSONObject.put("correct_result_code", lz());
            jSONObject.put("meta_hashcode", gc());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", wj());
            jSONObject2.put(AdnName.OTHER, oq());
            jSONObject.put("set_click_type", jSONObject2);
            gk gkVarKp = kp();
            if (gkVarKp != null && !TextUtils.isEmpty(gkVarKp.z())) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", gkVarKp.z());
                jSONObject3.put(MediaFormat.KEY_HEIGHT, gkVarKp.dl());
                jSONObject3.put(MediaFormat.KEY_WIDTH, gkVarKp.g());
                jSONObject.put("icon", jSONObject3);
            }
            Object objRw = rw();
            if (objRw != null) {
                jSONObject.put("session_params", objRw);
            }
            Object objGl = gl();
            if (objGl != null) {
                jSONObject.put("cache_control", objGl);
            }
            com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw = lw();
            if (gVarLw != null) {
                jSONObject.put("adslot", com.bytedance.sdk.openadsdk.core.un.l.z(gVarLw));
            }
            List<gk> listJz = jz();
            if (listJz != null) {
                JSONArray jSONArray = new JSONArray();
                for (gk gkVar : listJz) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("url", gkVar.z());
                    jSONObject4.put(MediaFormat.KEY_HEIGHT, gkVar.dl());
                    jSONObject4.put(MediaFormat.KEY_WIDTH, gkVar.g());
                    jSONObject4.put("image_preview", gkVar.m());
                    jSONObject4.put("image_key", gkVar.e());
                    jSONArray.put(jSONObject4);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> listBb = bb();
            if (listBb != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = listBb.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> listBy = by();
            if (listBy != null) {
                JSONArray jSONArray3 = new JSONArray();
                Iterator<String> it2 = listBy.iterator();
                while (it2.hasNext()) {
                    jSONArray3.put(it2.next());
                }
                jSONObject.put("click_url", jSONArray3);
            }
            jSONObject.put("phone_num", oz());
            jSONObject.put("title", li());
            jSONObject.put("download_num", jc());
            jSONObject.put("description", he());
            jSONObject.put("ext", vk());
            jSONObject.put("req_id", aq());
            jSONObject.put("image_mode", ou());
            jSONObject.put("intercept_flag", rv());
            jSONObject.put("web_inspector", tc());
            jSONObject.put("button_text", no());
            jSONObject.put("ad_logo", zx());
            jSONObject.put("video_adaptation", qd());
            jSONObject.put("feed_video_opentype", f());
            jSONObject.put("feed_reward_type", yx());
            jSONObject.put("orientation", zr());
            jSONObject.put("aspect_ratio", tk());
            jSONObject.put("aspect_margin", la());
            jSONObject.put("corner_radius", vd());
            gc gcVarC = c();
            if (gcVarC != null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, gcVarC.dl());
                jSONObject5.put(an.o, gcVarC.a());
                jSONObject5.put("download_url", gcVarC.g());
                jSONObject5.put("score", gcVarC.gc());
                jSONObject5.put("comment_num", gcVarC.m());
                jSONObject5.put("quick_app_url", gcVarC.z());
                jSONObject5.put("app_size", gcVarC.e());
                jSONObject.put("app", jSONObject5);
            }
            q qVarGw = gw();
            if (qVarGw != null) {
                jSONObject.put("download_sdk_conf", qVarGw.dl());
            }
            if (j() != null) {
                j().g(jSONObject);
            }
            if (fy() != null) {
                fy().z(jSONObject);
            }
            if (vy() != null) {
                vy().z(jSONObject);
            }
            if (ct() != null) {
                ct().z(jSONObject);
            }
            if (ec() != null) {
                ec().z(jSONObject);
            }
            if (y() != null) {
                y().z(jSONObject);
            }
            if (jq() != null) {
                jq().z(jSONObject);
            }
            if (w() != null) {
                w().z(jSONObject);
            }
            if (sv() != null) {
                sv().z(jSONObject);
            }
            if (cn() != null) {
                cn().z(jSONObject);
            }
            if (ao() != null) {
                ao().z(jSONObject);
            }
            if (gp() != null) {
                gp().g(jSONObject);
            }
            jSONObject.put("count_down", um());
            jSONObject.put("expiration_time", bp());
            jSONObject.put("client_expiration_time", bp());
            jSONObject.put("_child_metas", lo());
            jSONObject.put("_meta_life_record", ac().z());
            jSONObject.put("src_req_id", ux());
            jSONObject.put("player_type", su());
            jSONObject.put("video_encode_type", te());
            jSONObject.put("feed_video_finish_type", na());
            if (zd() != null) {
                zd().z(jSONObject);
            }
            if (dt() != null) {
                dt().z(jSONObject);
            }
            jSONObject.put("if_both_open", rg());
            jSONObject.put("if_double_deeplink", ep());
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("splash_clickarea", bm());
            jSONObject6.put("splash_clicktext", sd());
            jSONObject6.put("area_height", ja());
            jSONObject6.put("area_width", wn());
            jSONObject6.put("area_blank_height", nb());
            jSONObject6.put("half_blank_height", zz());
            jSONObject6.put("splash_style_id", vo());
            jSONObject6.put("btn_background_dest_color", lk());
            jSONObject6.put("top_splash_clicktext", u());
            jSONObject6.put("splash_load_time_optimization", sf());
            jSONObject6.put("text_config", n() != null ? n().z() : null);
            jSONObject6.put("top_text_config", ly() != null ? ly().z() : null);
            jSONObject6.put("sliding_distance", lf());
            jSONObject6.put("slide_area", hn() != null ? hn().gc() : null);
            jSONObject.put("splash_control", jSONObject6);
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("position", wo());
            jSONObject7.put("left_or_right_margin", k());
            jSONObject7.put("top_or_bottom_margin", wx());
            rv rvVar = this.kp;
            jSONObject7.put("skip_style", rvVar == null ? 1 : rvVar.a());
            rv rvVar2 = this.kp;
            jSONObject7.put("hide_native_skip_logo", rvVar2 == null ? 0 : rvVar2.gc());
            jSONObject.put("skip_control", jSONObject7);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("show_type", cb());
            jSONObject8.put("blank", o());
            jSONObject8.put("half_blank", yt());
            jSONObject.put("splash_compliance_bar", jSONObject8);
            if (fq() != null) {
                JSONObject jSONObject9 = new JSONObject();
                Set<Map.Entry<String, Object>> setEntrySet = fq().entrySet();
                if (setEntrySet != null && !setEntrySet.isEmpty()) {
                    for (Map.Entry<String, Object> entry : setEntrySet) {
                        jSONObject9.put(entry.getKey(), entry.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject9);
            }
            jSONObject.put("isDirectDownload", pf());
            jSONObject.put("page_render_type", sy());
            jSONObject.put("promotion_type", eo());
            jSONObject.put("if_lpua_package", this.nv);
            jSONObject.put("click_freq", this.fn);
            com.bytedance.sdk.openadsdk.core.ugeno.m.z zVarHh = hh();
            if (zVarHh != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("id", zVarHh.z());
                jSONObject10.put(TKDownloadReason.KSAD_TK_MD5, zVarHh.g());
                jSONObject10.put("url", zVarHh.dl());
                jSONObject10.put("scene", zVarHh.a());
                jSONObject.put("ugeno", jSONObject10);
            }
            com.bytedance.sdk.openadsdk.core.ugeno.fo.z zVarL = l();
            if (zVarL != null) {
                JSONObject jSONObject11 = new JSONObject();
                jSONObject11.put("product_infos", zVarL.z());
                jSONObject11.put("coupon", zVarL.g());
                jSONObject11.put("render_config", zVarL.dl());
                jSONObject11.put("live_room_data", zVarL.a());
                jSONObject11.putOpt("ec_mall_conf", zVarL.gc());
                jSONObject.put("dylite_info", jSONObject11);
            }
            jSONObject.put("native_lp_data", p());
            jSONObject.put("native_lp_tpl_id", fv());
            jSONObject.put("native_lp_ugen_url", js());
            jSONObject.put("native_lp_ugen_md5", tb());
            jSONObject.put("download_url", ls());
            jSONObject.put("native_lp_is_preload", q());
            if (q()) {
                jSONObject.put("native_lp_content", iq());
            }
            jSONObject.put("market_url", po());
            jSONObject.put("close_on_dislike", nc());
            m mVarBw = bw();
            if (mVarBw != null) {
                JSONObject jSONObject12 = new JSONObject();
                jSONObject12.put("developer_name", mVarBw.e());
                jSONObject12.put("app_version", mVarBw.gc());
                jSONObject12.put("permissions", mVarBw.wp());
                jSONObject12.put("privacy_policy_url", mVarBw.gz());
                jSONObject12.put(an.o, mVarBw.i());
                jSONObject12.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, mVarBw.v());
                jSONObject12.put("score", mVarBw.dl());
                jSONObject12.put("creative_tags", mVarBw.a());
                jSONObject12.put("permissions_url", mVarBw.g());
                jSONObject12.put("desc_url", mVarBw.fo());
                jSONObject12.put("reg_number", mVarBw.uy());
                jSONObject12.put("reg_url", mVarBw.kb());
                jSONObject.put("app_manage", jSONObject12);
            }
            io ioVarVx = vx();
            if (ioVarVx != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("ugen_dialog_url", ioVarVx.g());
                jSONObject13.put("ugen_dialog_md5", ioVarVx.dl());
                jSONObject13.put("dialog_style", ioVarVx.z());
                jSONObject.put("easy_dl_dialog", jSONObject13);
            }
            if (bg() != null) {
                jSONObject.put("easy_pl_material", bg());
            }
            jSONObject.put("app_manage_type", dh());
            jSONObject.put("lp_down_rule", zb() == 1 ? 1 : 0);
            jSONObject.put("auction_price", ka());
            jSONObject.put("price", un());
            jSONObject.put("ad_info", nv());
            jSONObject.put("adx_name", sa());
            jSONObject.put("no_default_ttdsp_price", tp());
            jSONObject.put("endcard_close_time", yd());
            jSONObject.put("proportion_watching", kg());
            jSONObject.put("video_skip_result", d());
            jSONObject.put("shake_value", fn());
            jSONObject.put("deep_shake_value", vl());
            jSONObject.put("rotation_angle", hs());
            jSONObject.put("calculation_method", yw());
            jSONObject.put("calculation_method_twist", s());
            jSONObject.put("show_poll_time", wk());
            jSONObject.put("dynamic_join_type", pc());
            jSONObject.put("dynamic_join_duration", qz());
            jSONObject.put("cache_ext", io());
            jSONObject.put("cache_time", zw());
            jSONObject.put("req_id", h());
            jSONObject.put("is_cache", gk());
            jSONObject.put("log_ext", x());
            jSONObject.put("material_key", lq());
            jSONObject.put("need_get_materials", mc());
            jSONObject.put("s_send_ts", ti());
            jSONObject.put("parse_material_ts", uf());
            ja jaVar = this.z;
            if (jaVar != null) {
                jSONObject.put("wc_miniapp_info", jaVar.fo());
            }
            kb kbVarSx = sx();
            if (kbVarSx != null) {
                JSONObject jSONObject14 = new JSONObject();
                jSONObject14.put("click_trigger_type", kbVarSx.z());
                jSONObject14.put("shake_start_time", kbVarSx.g());
                jSONObject14.put("shake_end_time", kbVarSx.dl());
                jSONObject.put("click_trigger_config", jSONObject14);
            }
            jSONObject.put("web_monitor_rate", g());
        } catch (Exception unused) {
        }
        if (bf() != null) {
            bf().z(jSONObject);
        }
        try {
            jSONObject.put("live_room_id", nz());
            jSONObject.put("ad_type", hu());
            jSONObject.put("live_interaction_type", wm());
            jSONObject.put("ec_schema", bv());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            jSONObject.put("ecom_live_params", qi());
        } catch (JSONException e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
        lq lqVarMq = mq();
        if (lqVarMq != null) {
            lqVarMq.z(jSONObject);
        }
        iq iqVarZm = zm();
        if (iqVarZm != null) {
            iqVarZm.z(jSONObject);
        }
        ti tiVarIa = ia();
        if (tiVarIa != null) {
            try {
                JSONObject jSONObject15 = new JSONObject();
                jSONObject15.put("reward_live_deep_link_user_id", tiVarIa.z());
                jSONObject15.put("reward_live_deep_link_request_id", tiVarIa.m());
                jSONObject15.put("reward_live_deep_link_room_id", tiVarIa.g());
                jSONObject15.put("reward_live_last_time", tiVarIa.gc());
                jSONObject15.put("reawrd_live_short_touch_params", tiVarIa.dl());
                jSONObject15.put("reawrd_live_extra_pangle_scheme_params", tiVarIa.a());
                jSONObject.put("reward_live_deep_link_params", jSONObject15);
            } catch (Exception unused2) {
            }
        }
        v vVarWg = wg();
        if (vVarWg != null) {
            try {
                JSONObject jSONObject16 = new JSONObject();
                jSONObject16.put("style_type", vVarWg.z());
                jSONObject16.put("image_url", vVarWg.g());
                jSONObject16.put("position", vVarWg.dl());
                jSONObject16.put("image_height", vVarWg.a());
                jSONObject16.put("image_scale_rate", vVarWg.m());
                jSONObject16.put("image_gif_url", vVarWg.gc());
                jSONObject16.put("image_gif_aspect_ratio", vVarWg.e());
                jSONObject.put("dynamic_join_coupon_style", jSONObject16);
            } catch (Exception unused3) {
            }
        }
        i iVarFb = fb();
        if (iVarFb != null) {
            try {
                jSONObject.put("coupon", iVarFb.z());
            } catch (JSONException e3) {
                com.bytedance.sdk.component.utils.wp.z(e3);
            }
        }
        oq oqVarMg = mg();
        if (oqVarMg != null) {
            try {
                jSONObject.put("live_info", oqVarMg.z());
            } catch (JSONException unused4) {
            }
        }
        sv svVarDz = dz();
        if (svVarDz != null) {
            try {
                jSONObject.put("saas_info", svVarDz.z());
            } catch (JSONException unused5) {
            }
        }
        Object objXo = xo();
        if (objXo != null) {
            try {
                jSONObject.put(d.K, objXo);
            } catch (Exception unused6) {
            }
        }
        tc tcVarUv = uv();
        if (tcVarUv != null) {
            try {
                JSONObject jSONObject17 = new JSONObject();
                jSONObject17.put("video_adapter_type", tcVarUv.z());
                jSONObject17.put("video_mute_type", tcVarUv.g());
                jSONObject.put("video_config", jSONObject17);
            } catch (Exception unused7) {
            }
        }
        try {
            jSONObject.put("not_valid_download_url", hb());
        } catch (JSONException e4) {
            com.bytedance.sdk.component.utils.wp.z(e4);
        }
        try {
            jSONObject.put("dynamic_configs", vj());
            String strVf = vf();
            if (!TextUtils.isEmpty(strVf)) {
                jSONObject.put("gnd_prefetch_cache_key", strVf);
                jSONObject.put("gnd_prefetch_timing", lb());
            }
        } catch (JSONException e5) {
            com.bytedance.sdk.component.utils.wp.z(e5);
        }
        try {
            jSONObject.put("twist_config", kk());
            jSONObject.put("shake_interact_conf", eb());
            jSONObject.put("twist_interact_conf", jb());
        } catch (JSONException e6) {
            com.bytedance.sdk.component.utils.wp.z(e6);
        }
        try {
            hh hhVar = this.mz;
            if (hhVar != null) {
                hhVar.g(jSONObject);
            }
        } catch (Throwable unused8) {
        }
        try {
            x xVar = this.ts;
            if (xVar != null) {
                xVar.g(jSONObject);
            }
        } catch (Throwable unused9) {
        }
        p pVarV = v();
        if (pVarV != null) {
            try {
                JSONObject jSONObject18 = new JSONObject();
                jSONObject18.put("lottie_tmp_url", pVarV.dl());
                JSONArray jSONArray4 = new JSONArray();
                List<gk> listZ = pVarV.z();
                if (listZ != null) {
                    for (gk gkVar2 : listZ) {
                        if (gkVar2 != null) {
                            JSONObject jSONObject19 = new JSONObject();
                            jSONObject19.put(MediaFormat.KEY_WIDTH, gkVar2.g());
                            jSONObject19.put(MediaFormat.KEY_HEIGHT, gkVar2.dl());
                            jSONObject19.put("url", gkVar2.z());
                            jSONArray4.put(jSONObject19);
                        }
                    }
                }
                JSONArray jSONArray5 = new JSONArray();
                List<com.bykv.vk.openvk.component.video.api.dl.dl> listG = pVarV.g();
                if (listG != null) {
                    for (com.bykv.vk.openvk.component.video.api.dl.dl dlVar : listG) {
                        if (dlVar != null) {
                            JSONObject jSONObject20 = new JSONObject();
                            jSONObject20.put("file_hash", dlVar.pf());
                            jSONObject20.put(an.z, dlVar.fo());
                            jSONObject20.put("video_duration", dlVar.m());
                            jSONObject20.put("video_url", dlVar.wp());
                            jSONArray5.put(jSONObject20);
                        }
                    }
                }
                JSONObject jSONObject21 = new JSONObject();
                jSONObject21.put("bg_anim_img_android", jSONArray4);
                jSONObject21.put("bg_videos", jSONArray5);
                JSONObject jSONObject22 = new JSONObject();
                jSONObject22.put("sdk_template_info", jSONObject18);
                jSONObject22.put("aigc", jSONObject21);
                jSONObject.put("sdk_derive_info", jSONObject22);
            } catch (JSONException unused10) {
            }
        }
        try {
            jSONObject.put("disable_video_join", m());
            jSONObject.put("disable_top_bar", uy());
            jSONObject.put("disable_rtn_button", wp());
            jSONObject.put("disable_safe_area", a());
            jSONObject.put("disable_slide_return", gz());
        } catch (Throwable unused11) {
        }
        return jSONObject;
    }

    public void mc(String str) {
        this.fq = str;
    }

    public String vj() {
        return this.fq;
    }

    public void uy(boolean z) {
        this.lz = z;
    }

    public boolean hb() {
        return this.lz;
    }

    public int su() {
        return this.gy;
    }

    public void ec(int i) {
        this.gy = i;
    }

    public rv nm() {
        return this.kp;
    }

    public void z(rv rvVar) {
        this.kp = rvVar;
    }

    public zx hl() {
        return this.bb;
    }

    public void z(zx zxVar) {
        this.bb = zxVar;
    }

    public int wk() {
        return this.by;
    }

    public void bv(int i) {
        int i2 = 500;
        if (i == Integer.MIN_VALUE) {
            i = com.bytedance.sdk.openadsdk.core.un.eo.gz(this) == 3 ? 500 : 1000;
        }
        if (i >= 500) {
            i2 = 3000;
            if (i <= 3000) {
                i2 = i;
            }
        }
        this.by = i2;
    }

    public String nz() {
        return this.li;
    }

    public void un(String str) {
        this.li = str;
    }

    public int hu() {
        return this.jc;
    }

    public void gb(int i) {
        this.jc = i;
    }

    public int wm() {
        return this.he;
    }

    public void jq(int i) {
        this.he = i;
    }

    public void z(y yVar) {
        this.bv = yVar;
    }

    public String qi() {
        return this.mj;
    }

    public void ti(String str) {
        this.mj = str;
    }

    public i fb() {
        return this.c;
    }

    public void z(i iVar) {
        this.c = iVar;
    }

    public oq mg() {
        return this.gw;
    }

    public void z(oq oqVar) {
        this.gw = oqVar;
    }

    public sv dz() {
        return this.vy;
    }

    public void z(sv svVar) {
        this.vy = svVar;
    }

    public boolean nc() {
        return this.vo;
    }

    public void kb(boolean z) {
        this.vo = z;
    }

    public int d() {
        return this.bw;
    }

    public void sv(int i) {
        if (i <= 0 || i > 9) {
            this.bw = 3;
        } else {
            this.bw = i;
        }
    }

    public v wg() {
        return this.no;
    }

    public void z(v vVar) {
        this.no = vVar;
    }

    public tc uv() {
        return this.vk;
    }

    public void z(tc tcVar) {
        this.vk = tcVar;
    }

    public int vl() {
        if (this.f1185a == 4 && TextUtils.isEmpty(this.b)) {
            return this.pd;
        }
        return 0;
    }

    public void f(int i) {
        this.pd = i;
    }

    public void eo(String str) {
        this.kv = str;
    }

    public String lo() {
        return this.kv;
    }

    public y fy() {
        return this.bv;
    }

    public kb sx() {
        return this.gd;
    }

    public void z(kb kbVar) {
        this.gd = kbVar;
    }

    public void z(eo eoVar) {
        this.gb = eoVar;
    }

    public eo bf() {
        return this.gb;
    }

    public void z(com.bykv.vk.openvk.component.video.api.dl.dl dlVar) {
        if (this.mc == null) {
            this.mc = new tf();
        }
        this.mc.z(dlVar);
    }

    public void wp(boolean z) {
        this.zt = z;
    }

    public boolean cl() {
        return this.zt;
    }

    public void z(lq lqVar) {
        this.ou = lqVar;
    }

    public lq mq() {
        return this.ou;
    }

    public void z(iq iqVar) {
        this.bp = iqVar;
    }

    public iq zm() {
        return this.bp;
    }

    public int lb() {
        return this.cn;
    }

    public void yx(int i) {
        this.cn = i;
    }

    public String vf() {
        return this.ka;
    }

    public void oq(String str) {
        this.ka = str;
    }

    public static boolean a(na naVar) {
        return naVar != null && naVar.nv == 1;
    }

    public void qd(int i) {
        this.fn = i;
    }

    public static boolean gc(na naVar) {
        if (naVar == null || naVar.jv <= 0 || naVar.fn <= 0) {
            return false;
        }
        boolean z = System.currentTimeMillis() - naVar.jv < ((long) naVar.fn);
        if (z) {
            naVar.sa++;
            com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.iq.na.1
                @Override // com.bytedance.sdk.openadsdk.kb.z.z
                public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("count", na.this.sa);
                    jSONObject.put("click_freq", na.this.fn);
                    return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("click_intercept").gz(na.this.vk()).g(jSONObject.toString());
                }
            }, "click_intercept");
        }
        return z;
    }

    public static void m(na naVar) {
        if (naVar == null) {
            return;
        }
        naVar.jv = System.currentTimeMillis();
    }

    public void zx(int i) {
        this.nv = i;
    }

    public JSONObject kk() {
        return this.zr;
    }

    public void fo(JSONObject jSONObject) {
        this.zr = jSONObject;
    }

    public JSONObject eb() {
        return this.tk;
    }

    public void uy(JSONObject jSONObject) {
        this.tk = jSONObject;
    }

    public JSONObject jb() {
        return this.st;
    }

    public void kb(JSONObject jSONObject) {
        this.st = jSONObject;
    }

    public String xn() {
        return hashCode() + aq() + uf();
    }

    public String dc() {
        JSONObject jSONObject = this.me;
        String strOptString = jSONObject != null ? jSONObject.optString("session_id") : "";
        return TextUtils.isEmpty(strOptString) ? xn() : strOptString;
    }

    public void z(hh hhVar) {
        this.mz = hhVar;
    }

    public hh dp() {
        return this.mz;
    }

    public void z(sy syVar) {
        this.yd = syVar;
    }

    public sy kq() {
        return this.yd;
    }

    public xl ac() {
        if (this.sz == null) {
            this.sz = new xl(this);
        }
        return this.sz;
    }

    public void wp(JSONObject jSONObject) {
        this.sz = new xl(this, jSONObject);
    }
}
