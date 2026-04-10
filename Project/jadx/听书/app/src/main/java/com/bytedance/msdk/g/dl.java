package com.bytedance.msdk.g;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.api.a.z.e.fo;
import com.bytedance.msdk.api.a.z.e.gc;
import com.bytedance.msdk.api.a.z.e.gz;
import com.bytedance.msdk.api.a.z.e.uy;
import com.bytedance.msdk.gz.q;
import com.bytedance.msdk.z.g.m;
import com.bytedance.sdk.openadsdk.core.ti.a;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import com.bytedance.sdk.openadsdk.ls.dl.g.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl extends a implements Comparable<dl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.msdk.api.a.z.a f461a;
    private String bm;
    private String bv;
    private com.bytedance.sdk.openadsdk.js.z.g.z.z bw;
    protected com.bytedance.msdk.api.a.z.g dl;
    private String dt;
    protected m e;
    private int ec;
    private Map<String, Object> eo;
    private boolean f;
    private String fo;
    private String fv;
    protected gz g;
    private String gb;
    protected fo gc;
    private String gk;
    protected m gz;
    private String h;
    private String hh;
    private volatile boolean hn;
    private int i;
    private double iq;
    private int ja;
    private String jq;
    private double js;
    private String k;
    private String kb;
    private boolean l;
    private int lk;
    private String lq;
    private int ls;
    private volatile boolean ly;
    protected com.bytedance.msdk.api.a.z.dl.z m;
    private String mc;
    private boolean n;
    private int na;
    private int nb;
    private int nh;
    private String o;
    private double oq;
    private String p;
    private int pf;
    private String q;
    private int r;
    private String s;
    private boolean sd;
    private String sf;
    private String sv;
    private boolean sy;
    private String tf;
    private Map<String, String> ti;
    private int uf;
    private String un;
    private String uy;
    private int v;
    private String vm;
    private String vo;
    private double wj;
    private int wn;
    private long wo;
    private String wp;
    private String wx;
    private long x;
    private z xo;
    private int y;
    private String yt;
    private String yw;
    private int yx;
    private int yz;
    protected com.bytedance.msdk.api.a.z.e.g z;
    private int zw;
    private String zz;
    private List<String> tb = new ArrayList();
    private int io = -1;
    private int xl = 1;
    private int j = 1;
    private int gp = 1;
    private int t = 1;
    private volatile boolean qd = false;
    private volatile boolean zx = false;
    private volatile boolean b = false;
    private volatile boolean lw = false;
    private final Map<String, Object> rv = new q();
    private boolean tc = false;
    private boolean me = false;
    private String u = "1";
    private Map<String, Object> cb = new HashMap();
    private Map<String, Object> xf = new ConcurrentHashMap();

    public interface z {
        void z();

        void z(dl dlVar);
    }

    public int a() {
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return null;
    }

    public boolean bb() {
        return false;
    }

    public wp c() {
        return null;
    }

    public void dl() {
    }

    public String e() {
        return null;
    }

    public View fo() {
        return null;
    }

    public e g(Dialog dialog, Integer[] numArr) {
        return null;
    }

    public void g() {
    }

    public void g(Activity activity) {
    }

    public void g(Map<String, Object> map) {
    }

    public abstract boolean gc();

    public long gm() {
        return 0L;
    }

    public void gw() {
    }

    public gc gz() {
        return null;
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.a he() {
        return null;
    }

    public void kb() {
    }

    public void ls() {
    }

    public Bitmap mj() {
        return null;
    }

    public String mn() {
        return null;
    }

    public double no() {
        return 0.0d;
    }

    public void p() {
    }

    public long pd() {
        return 0L;
    }

    public boolean tb() {
        return false;
    }

    public void ti(String str) {
    }

    public View uy() {
        return null;
    }

    public void uy(boolean z2) {
    }

    public com.bytedance.sdk.openadsdk.ls.dl.g.gc vk() {
        return null;
    }

    public int vy() {
        return 0;
    }

    public boolean xl() {
        return false;
    }

    public e z(Activity activity) {
        return null;
    }

    public void z() {
    }

    public void z(Activity activity, Object obj, String str) {
    }

    public void z(Dialog dialog, Integer[] numArr) {
    }

    public void z(Bitmap bitmap, int i) {
    }

    public void z(ViewGroup viewGroup) {
    }

    public void z(ViewGroup viewGroup, Activity activity) {
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar) {
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar) {
    }

    public void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
    }

    public void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar) {
    }

    public void z(Object obj) {
    }

    public void z(Map<String, Object> map) {
    }

    public void zw(int i) {
    }

    public void z(String str) {
        this.tf = str;
    }

    public String q() {
        return this.tf;
    }

    public void z(boolean z2) {
        this.sd = z2;
    }

    public boolean iq() {
        return this.sd;
    }

    public void g(String str) {
        this.bm = str;
    }

    public String zw() {
        return this.bm;
    }

    public void z(int i) {
        this.yz = i;
    }

    public int io() {
        return this.yz;
    }

    public int uf() {
        return this.r;
    }

    public void g(int i) {
        this.r = i;
    }

    public void dl(int i) {
        this.nh = i;
    }

    public int sy() {
        return this.nh;
    }

    public boolean hh() {
        return this.me;
    }

    public void g(boolean z2) {
        this.me = z2;
    }

    public boolean l() {
        return this.tc;
    }

    public void dl(boolean z2) {
        this.tc = z2;
    }

    public void dl(Map<String, Object> map) {
        if (map != null) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "setMediaExtraInfo ".concat(String.valueOf(map)));
            this.rv.putAll(map);
        }
    }

    public Map<String, Object> h() {
        return this.rv;
    }

    public boolean gk() {
        if (this.qd) {
            return true;
        }
        this.qd = true;
        return false;
    }

    public boolean x() {
        if (this.zx) {
            return true;
        }
        this.zx = true;
        return false;
    }

    public boolean lq() {
        if (this.b) {
            return true;
        }
        this.b = true;
        return false;
    }

    public boolean mc() {
        if (this.lw) {
            return true;
        }
        this.lw = true;
        return false;
    }

    public int un() {
        return this.yx;
    }

    public void a(int i) {
        this.yx = i;
    }

    public void a(boolean z2) {
        this.f = z2;
    }

    public boolean ti() {
        return this.f;
    }

    public String eo() {
        return this.jq;
    }

    public void dl(String str) {
        this.jq = str;
    }

    public String oq() {
        return this.sv;
    }

    public void a(String str) {
        this.sv = str;
    }

    public String wj() {
        return this.bv;
    }

    public void gc(String str) {
        this.bv = str;
    }

    public String na() {
        return this.gb;
    }

    public void m(String str) {
        this.gb = str;
    }

    public int j() {
        return this.ec;
    }

    public void gc(int i) {
        this.ec = i;
    }

    public int gp() {
        return this.y;
    }

    public void m(int i) {
        this.y = i;
    }

    public void e(String str) {
        this.vm = str;
    }

    public void e(int i) {
        this.gp = i;
    }

    public void gz(int i) {
        this.t = i;
    }

    public int gz(String str) {
        if (TextUtils.equals(str, this.vm)) {
            return this.gp;
        }
        return this.xl;
    }

    public void fo(int i) {
        this.xl = i;
    }

    public int fo(String str) {
        if (TextUtils.equals(str, this.vm)) {
            return this.t;
        }
        return this.j;
    }

    public void uy(int i) {
        this.j = i;
    }

    public String t() {
        return this.yt;
    }

    public void uy(String str) {
        this.yt = str;
    }

    public String vm() {
        return this.dt;
    }

    public void kb(String str) {
        this.dt = str;
    }

    public String y() {
        return this.o;
    }

    public void wp(String str) {
        this.o = str;
    }

    public void z(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.cb.put(str, obj);
    }

    public void a(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.cb.putAll(map);
    }

    public final Map<String, Object> ec() {
        return this.cb;
    }

    public String bv() {
        return this.wx;
    }

    public void i(String str) {
        this.wx = str;
    }

    public String gb() {
        return this.k;
    }

    public void v(String str) {
        this.k = str;
    }

    public boolean jq() {
        return this.ly;
    }

    public void gc(boolean z2) {
        this.ly = z2;
    }

    public boolean sv() {
        return this.hn;
    }

    public void m(boolean z2) {
        this.hn = z2;
    }

    public final void z(long j) {
        if (this.wo == 0) {
            this.wo = j;
        }
    }

    public final long f() {
        return this.wo;
    }

    public Map<String, Object> yx() {
        return this.xf;
    }

    public void g(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.xf.put(str, obj);
    }

    public void pf(String str) {
        this.u = str;
    }

    public String qd() {
        return this.u;
    }

    public void ls(String str) {
        this.yw = str;
    }

    public String zx() {
        return this.yw;
    }

    public void p(String str) {
        this.s = str;
    }

    public String b() {
        return this.s;
    }

    public String lw() {
        return TextUtils.isEmpty(this.yw) ? this.s : this.yw;
    }

    public void fv(String str) {
        this.sf = str;
    }

    public String rv() {
        return this.sf;
    }

    public void e(boolean z2) {
        this.sy = z2;
    }

    public boolean tc() {
        return this.sy;
    }

    public void kb(int i) {
        this.zw = i;
    }

    public void wp(int i) {
        this.io = i;
    }

    public int me() {
        return this.io;
    }

    public int nh() {
        return this.zw;
    }

    public int r() {
        return this.lk;
    }

    public void i(int i) {
        this.lk = i;
    }

    public void js(String str) {
        this.zz = str;
    }

    public String yz() {
        return this.vo;
    }

    public void tb(String str) {
        this.vo = str;
    }

    public void q(String str) {
        this.hh = str;
    }

    public void gz(boolean z2) {
        this.l = z2;
    }

    public boolean bm() {
        if (!TextUtils.isEmpty(this.h) || !TextUtils.isEmpty(this.gk) || this.x > 0 || !TextUtils.isEmpty(this.lq)) {
            return true;
        }
        Map<String, String> map = this.ti;
        return ((map == null || map.size() <= 0) && TextUtils.isEmpty(this.mc) && TextUtils.isEmpty(this.un) && TextUtils.isEmpty(this.o)) ? false : true;
    }

    public String sd() {
        return this.h;
    }

    public void iq(String str) {
        this.h = str;
    }

    public String tf() {
        return this.gk;
    }

    public void zw(String str) {
        this.gk = str;
    }

    public long ja() {
        return this.x;
    }

    public void g(long j) {
        this.x = j;
    }

    public String wn() {
        return this.lq;
    }

    public void io(String str) {
        this.lq = str;
    }

    public String nb() {
        return this.mc;
    }

    public void uf(String str) {
        this.mc = str;
    }

    public String zz() {
        return this.un;
    }

    public void sy(String str) {
        this.un = str;
    }

    public Map<String, String> vo() {
        return this.ti;
    }

    public void gc(Map<String, String> map) {
        this.ti = map;
    }

    public Map<String, Object> lk() {
        return this.eo;
    }

    public double u() {
        try {
        } catch (NumberFormatException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        if (hn()) {
            if (yw() < 0.0d) {
                return 0.0d;
            }
            return yw();
        }
        if (k() || wx()) {
            return this.iq * Double.valueOf(this.u).doubleValue();
        }
        return this.iq;
    }

    public void z(double d) {
        this.iq = d;
    }

    public double sf() {
        if (!hn()) {
            return this.iq;
        }
        if (yw() < 0.0d) {
            return 0.0d;
        }
        return yw();
    }

    public double yw() {
        return this.oq;
    }

    public void g(double d) {
        this.oq = d;
    }

    public double s() {
        return this.wj;
    }

    public void dl(double d) {
        this.wj = d;
    }

    public String n() {
        if (hn()) {
            return yw() < 0.0d ? "-1" : String.valueOf(yw());
        }
        return String.valueOf(u());
    }

    public String ly() {
        if (hn()) {
            return s() < 0.0d ? "-1" : String.valueOf(s());
        }
        return String.valueOf(u());
    }

    public boolean hn() {
        return this.nb == 2;
    }

    public boolean wo() {
        int i = this.nb;
        return i == 0 || i == 100;
    }

    public boolean k() {
        return this.nb == 1;
    }

    public boolean wx() {
        return this.nb == 3;
    }

    public boolean cb() {
        return this.nb == 0;
    }

    public boolean o() {
        return this.nb == 100;
    }

    public void v(int i) {
        this.uf = i;
    }

    public int yt() {
        return this.nb;
    }

    public void pf(int i) {
        this.nb = i;
    }

    public void ls(int i) {
        this.ja = i;
    }

    public int dt() {
        return this.ja;
    }

    public void p(int i) {
        this.wn = i;
    }

    public int xo() {
        return this.wn;
    }

    public List<String> xf() {
        return this.tb;
    }

    public void z(List<String> list) {
        if (list != null) {
            this.tb.addAll(list);
        }
    }

    public void hh(String str) {
        this.kb = str;
    }

    public String bw() {
        return this.kb;
    }

    public String gy() {
        return this.wp;
    }

    public void l(String str) {
        this.wp = str;
    }

    public int dh() {
        return this.i;
    }

    public void fv(int i) {
        this.i = i;
    }

    public int zb() {
        return this.v;
    }

    public void js(int i) {
        this.v = i;
    }

    public String zd() {
        return this.p;
    }

    public void h(String str) {
        this.p = str;
    }

    public void gk(String str) {
        this.fv = str;
    }

    public void tb(int i) {
        this.na = i;
    }

    public int te() {
        return this.na;
    }

    public int hy() {
        return this.uf;
    }

    public String lt() {
        return this.fo;
    }

    public void x(String str) {
        this.fo = str;
    }

    public void lq(String str) {
        this.uy = str;
    }

    public String kp() {
        return this.uy;
    }

    public double fp() {
        return this.js;
    }

    public void a(double d) {
        this.js = d;
    }

    public void mc(String str) {
        this.q = str;
    }

    public String vt() {
        return this.q;
    }

    public final boolean un(String str) {
        Integer numM = m();
        return numM.intValue() == 1 ? !com.bytedance.msdk.core.gc.z.z.z().z(str, this) : numM.intValue() == 2;
    }

    public Integer m() {
        return 1;
    }

    public void q(int i) {
        this.pf = i;
    }

    public int jz() {
        return this.pf;
    }

    public void iq(int i) {
        this.ls = i;
    }

    public int oz() {
        return this.ls;
    }

    public boolean by() {
        return this.n;
    }

    public void fo(boolean z2) {
        this.n = z2;
    }

    private void z(ViewGroup viewGroup, uy uyVar) {
        g(viewGroup);
        View viewFindViewById = viewGroup.findViewById(R.id.tt_mediation_mtg_ad_choice);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(8);
        }
        if (uyVar != null) {
            z(viewGroup.findViewById(uyVar.wp));
        }
    }

    public void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view) {
        z(viewGroup, (uy) null);
    }

    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, uy uyVar, List<View> list4) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        z(viewGroup, uyVar);
    }

    public void z(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
        }
    }

    public void g(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    private void g(ViewGroup viewGroup) {
        try {
            if (viewGroup.getChildCount() == 0) {
                return;
            }
            int i = 0;
            if (r() != 3 && (viewGroup.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                if (MediationConstant.TT_GDT_NATIVE_ROOT_VIEW_TAG.equals(viewGroup2.getTag(R.id.tt_mediation_gdt_developer_view_root_tag_key))) {
                    viewGroup.removeView(viewGroup2);
                    int i2 = 0;
                    while (i2 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i2);
                        if (childAt != null) {
                            Object tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key);
                            if ((tag instanceof String) && tag.equals(MediationConstant.TT_GDT_NATIVE_VIEW_TAG)) {
                                viewGroup2.removeView(childAt);
                                viewGroup.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i2++;
                    }
                }
            }
            if (r() == 2 || !(viewGroup.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup.getChildAt(0);
            if (MediationConstant.TT_ADMOB_NATIVE_VIEW_ROOT_TAG.equals(viewGroup3.getTag(R.id.tt_mediation_admob_developer_view_root_tag_key))) {
                viewGroup.removeView(viewGroup3);
                while (i < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(R.id.tt_mediation_admob_developer_view_tag_key);
                        if ((tag2 instanceof String) && tag2.equals(MediationConstant.TT_ADMOB_NATIVE_VIEW_TAG)) {
                            viewGroup3.removeView(childAt2);
                            viewGroup.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i++;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    public void fv() {
        this.z = null;
        this.g = null;
        this.dl = null;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(dl dlVar) {
        if (dlVar == null || this.wn > dlVar.xo()) {
            return 1;
        }
        if (this.wn < dlVar.xo()) {
            return -1;
        }
        if (this.ja > dlVar.dt()) {
            return 1;
        }
        return this.ja < dlVar.dt() ? -1 : 0;
    }

    public com.bytedance.msdk.api.a.z.e.g wp() {
        return this.z;
    }

    public com.bytedance.msdk.api.a.z.dl.z pf() {
        return this.m;
    }

    public gz i() {
        return this.g;
    }

    public com.bytedance.msdk.api.a.z.g v() {
        return this.dl;
    }

    public void z(fo foVar) {
        this.gc = foVar;
    }

    public void z(com.bytedance.msdk.api.a.z.a aVar) {
        this.f461a = aVar;
    }

    public void z(com.bytedance.msdk.api.a.z.e.g gVar) {
        this.z = gVar;
    }

    public void z(gz gzVar) {
        this.g = gzVar;
    }

    public void z(final com.bytedance.msdk.api.a.z.g gVar) {
        if (gVar != null) {
            this.dl = new com.bytedance.msdk.api.a.z.g() { // from class: com.bytedance.msdk.g.dl.1
                @Override // com.bytedance.msdk.api.a.z.g
                public void z() {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.z();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void g() {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.g();
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(final long j, final long j2, final int i, final int i2, final String str, final String str2) {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.z(j, j2, i, i2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(final long j, final long j2, final String str, final String str2) {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.z(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void g(final long j, final long j2, final String str, final String str2) {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.g(j, j2, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(final long j, final String str, final String str2) {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.z(j, str, str2);
                        }
                    });
                }

                @Override // com.bytedance.msdk.api.a.z.g
                public void z(final String str, final String str2) {
                    com.bytedance.msdk.z.gc.m.dl(new Runnable() { // from class: com.bytedance.msdk.g.dl.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            gVar.z(str, str2);
                        }
                    });
                }
            };
        }
    }

    public void z(com.bytedance.msdk.api.a.z.dl.z zVar) {
        this.m = zVar;
    }

    public void z(m mVar) {
        this.e = mVar;
    }

    public m li() {
        return this.e;
    }

    public void g(m mVar) {
        this.gz = mVar;
    }

    public boolean jc() {
        return (this instanceof com.bytedance.msdk.api.a.z.g.g) || (this instanceof com.bytedance.msdk.dl.z.z.dl);
    }

    public void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar) {
        this.bw = zVar;
    }

    public com.bytedance.sdk.openadsdk.js.z.g.z.z js() {
        return this.bw;
    }

    public z pc() {
        return this.xo;
    }

    public void z(z zVar) {
        this.xo = zVar;
    }
}
