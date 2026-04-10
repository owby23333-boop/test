package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.a.js;
import com.ss.android.socialbase.downloader.a.l;
import com.ss.android.socialbase.downloader.a.pf;
import com.ss.android.socialbase.downloader.a.q;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.a.v;
import com.ss.android.socialbase.downloader.downloader.tb;
import com.ss.android.socialbase.downloader.downloader.uy;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f2039a;
    private boolean bv;
    private String dl;
    private String e;
    private un ec;
    private int f;
    private com.ss.android.socialbase.downloader.downloader.fo fv;
    private Context g;
    private JSONObject gb;
    private String gc;
    private boolean gk;
    private com.ss.android.socialbase.appdownloader.dl.m gp;
    private List<com.ss.android.socialbase.downloader.e.gc> gz;
    private int h;
    private boolean hh;
    private hh i;
    private String io;
    private boolean iq;
    private pf j;
    private String jq;
    private uy js;
    private String lw;
    private String m;
    private boolean mc;
    private int[] me;
    private boolean p;
    private String pf;
    private com.ss.android.socialbase.downloader.notification.z q;
    private int qd;
    private long sy;
    private q t;
    private tb tb;
    private String tc;
    private boolean ti;
    private String uf;
    private boolean un;
    private hh v;
    private js vm;
    private int wj;
    private String x;
    private l xl;
    private boolean y;
    private long yx;
    private Activity z;
    private boolean zw;
    private boolean zx;
    private boolean fo = true;
    private boolean uy = false;
    private boolean kb = true;
    private boolean wp = false;
    private String ls = "application/vnd.android.package-archive";
    private int l = 5;
    private boolean lq = true;
    private com.ss.android.socialbase.downloader.g.e eo = com.ss.android.socialbase.downloader.g.e.ENQUEUE_NONE;
    private int oq = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
    private boolean na = true;
    private List<v> sv = new ArrayList();
    private boolean b = true;
    private boolean rv = true;

    public m(Context context, String str) {
        this.g = context.getApplicationContext();
        this.dl = str;
    }

    public Activity getActivity() {
        return this.z;
    }

    public Context getContext() {
        return this.g;
    }

    public String z() {
        return this.dl;
    }

    public String g() {
        return this.gc;
    }

    public String dl() {
        return this.e;
    }

    public List<com.ss.android.socialbase.downloader.e.gc> a() {
        return this.gz;
    }

    public boolean gc() {
        return this.fo;
    }

    public boolean m() {
        return this.uy;
    }

    public boolean e() {
        return this.kb;
    }

    public boolean gz() {
        return this.wp;
    }

    public hh fo() {
        return this.i;
    }

    public hh uy() {
        return this.v;
    }

    public String kb() {
        return this.pf;
    }

    public String wp() {
        return this.ls;
    }

    public boolean i() {
        return this.p;
    }

    public com.ss.android.socialbase.downloader.notification.z v() {
        return this.q;
    }

    public uy pf() {
        return this.js;
    }

    public com.ss.android.socialbase.downloader.downloader.fo ls() {
        return this.fv;
    }

    public boolean p() {
        return this.iq;
    }

    public boolean fv() {
        return this.zw;
    }

    public int js() {
        return this.qd;
    }

    public void z(int i) {
        this.qd = i;
    }

    public String tb() {
        return this.io;
    }

    public String q() {
        return this.uf;
    }

    public long iq() {
        return this.sy;
    }

    public int zw() {
        return this.l;
    }

    public int io() {
        return this.h;
    }

    public boolean uf() {
        return this.gk;
    }

    public String sy() {
        return this.x;
    }

    public boolean hh() {
        return this.lq;
    }

    public boolean l() {
        return this.mc;
    }

    public tb h() {
        return this.tb;
    }

    public int gk() {
        return this.oq;
    }

    public int x() {
        return this.wj;
    }

    public boolean lq() {
        return this.un;
    }

    public boolean mc() {
        return this.ti;
    }

    public boolean un() {
        return this.na;
    }

    public boolean ti() {
        return this.y;
    }

    public com.ss.android.socialbase.downloader.g.e eo() {
        return this.eo;
    }

    public boolean oq() {
        return this.hh;
    }

    public String wj() {
        return this.m;
    }

    public l na() {
        return this.xl;
    }

    public pf xl() {
        return this.j;
    }

    public com.ss.android.socialbase.appdownloader.dl.m j() {
        return this.gp;
    }

    public q gp() {
        return this.t;
    }

    public un t() {
        return this.ec;
    }

    public List<v> vm() {
        return this.sv;
    }

    public String y() {
        return this.lw;
    }

    public boolean ec() {
        return this.bv;
    }

    public int bv() {
        return this.f;
    }

    public long gb() {
        return this.yx;
    }

    public boolean jq() {
        return this.rv;
    }

    public String sv() {
        return this.tc;
    }

    public int[] f() {
        return this.me;
    }

    public boolean yx() {
        return this.zx;
    }

    public boolean qd() {
        return this.b;
    }

    public m z(String str) {
        this.gc = str;
        return this;
    }

    public m g(String str) {
        this.m = str;
        return this;
    }

    public m dl(String str) {
        this.e = str;
        return this;
    }

    public m z(List<com.ss.android.socialbase.downloader.e.gc> list) {
        this.gz = list;
        return this;
    }

    public m z(boolean z) {
        this.fo = z;
        return this;
    }

    public m a(String str) {
        this.lw = str;
        return this;
    }

    public m g(boolean z) {
        this.uy = z;
        return this;
    }

    public m dl(boolean z) {
        this.wp = z;
        return this;
    }

    public m z(hh hhVar) {
        this.i = hhVar;
        return this;
    }

    public m gc(String str) {
        this.pf = str;
        return this;
    }

    public m m(String str) {
        this.ls = str;
        return this;
    }

    public m a(boolean z) {
        this.p = z;
        return this;
    }

    public m gc(boolean z) {
        this.iq = z;
        return this;
    }

    public m m(boolean z) {
        this.zw = z;
        return this;
    }

    public m e(String str) {
        this.io = str;
        return this;
    }

    public m gz(String str) {
        this.uf = str;
        return this;
    }

    public m z(long j) {
        this.sy = j;
        return this;
    }

    public m g(int i) {
        this.l = i;
        return this;
    }

    public m dl(int i) {
        this.h = i;
        return this;
    }

    public m e(boolean z) {
        this.gk = z;
        return this;
    }

    public m fo(String str) {
        this.x = str;
        return this;
    }

    public m gz(boolean z) {
        this.y = z;
        return this;
    }

    public m fo(boolean z) {
        this.lq = z;
        return this;
    }

    public m uy(boolean z) {
        this.mc = z;
        return this;
    }

    public m kb(boolean z) {
        this.un = z;
        return this;
    }

    public m wp(boolean z) {
        this.ti = z;
        return this;
    }

    public m a(int i) {
        this.oq = i;
        return this;
    }

    public m gc(int i) {
        this.wj = i;
        return this;
    }

    public m i(boolean z) {
        this.na = z;
        return this;
    }

    public m z(com.ss.android.socialbase.downloader.g.e eVar) {
        this.eo = eVar;
        return this;
    }

    public m v(boolean z) {
        this.hh = z;
        return this;
    }

    public m z(q qVar) {
        this.t = qVar;
        return this;
    }

    public m uy(String str) {
        this.tc = str;
        return this;
    }

    public m kb(String str) {
        this.jq = str;
        return this;
    }

    public String zx() {
        return this.jq;
    }

    public m m(int i) {
        this.f = i;
        return this;
    }

    public List<String> b() {
        return this.f2039a;
    }

    public m g(List<String> list) {
        this.f2039a = list;
        return this;
    }

    public js lw() {
        return this.vm;
    }

    public m z(js jsVar) {
        this.vm = jsVar;
        return this;
    }

    public JSONObject rv() {
        return this.gb;
    }

    public m z(JSONObject jSONObject) {
        this.gb = jSONObject;
        return this;
    }

    public m z(v vVar) {
        synchronized (this.sv) {
            if (vVar != null) {
                if (!this.sv.contains(vVar)) {
                    this.sv.add(vVar);
                    return this;
                }
            }
            return this;
        }
    }

    public m pf(boolean z) {
        this.zx = z;
        return this;
    }

    public m ls(boolean z) {
        this.b = z;
        return this;
    }
}
