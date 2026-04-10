package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.net.InetAddress;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class f implements c {
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f832d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f834f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f835g;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f846r;
    private long a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f833e = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f836h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f837i = 19700101000L;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f838j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private HashMap<String, Integer> f839k = new HashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private HashMap<String, Integer> f840l = new HashMap<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f841m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private HashMap<String, Integer> f842n = new HashMap<>();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private HashMap<String, Integer> f843o = new HashMap<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f844p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, Integer> f845q = new HashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Handler f847s = new a(Looper.getMainLooper());

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            f.this.b(message.arg1 != 0);
        }
    }

    private f() {
    }

    public f(int i2) {
        this.f846r = i2;
    }

    private String a(y yVar) {
        if (yVar == null || yVar.g() == null || yVar.g().o() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(yVar.g().o().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void a(a0 a0Var, String str) {
        StringBuilder sb;
        String str2;
        int i2;
        long j2;
        d dVarC;
        if (a0Var != null && this.f844p) {
            String strA = a0Var.a("tnc-cmd", null);
            if (TextUtils.isEmpty(strA)) {
                sb = new StringBuilder();
                str2 = "Gromore-handleTncProbe, no probeProto, ";
            } else {
                String[] strArrSplit = strA.split("@");
                if (strArrSplit != null && strArrSplit.length == 2) {
                    try {
                        i2 = Integer.parseInt(strArrSplit[0]);
                    } catch (Throwable th) {
                        th = th;
                        i2 = 0;
                    }
                    try {
                        j2 = Long.parseLong(strArrSplit[1]);
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-handleTncProbe, probeProto except, " + str);
                        j2 = 0L;
                    }
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-handleTncProbe, local: " + this.f836h + "@" + this.f837i + " svr: " + i2 + "@" + j2 + " " + str);
                    if (j2 > this.f837i) {
                        this.f836h = i2;
                        this.f837i = j2;
                        this.f834f.getSharedPreferences(f(), 0).edit().putInt("tnc_probe_cmd", i2).putLong("tnc_probe_version", j2).apply();
                        if (this.f836h != 10000 || (dVarC = c()) == null) {
                            return;
                        }
                        Random random = new Random(System.currentTimeMillis());
                        int i3 = dVarC.f826l;
                        long jNextInt = i3 > 0 ? 1000 * ((long) random.nextInt(i3)) : 0L;
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
                        a(true, jNextInt);
                        return;
                    }
                    return;
                }
                sb = new StringBuilder();
                str2 = "Gromore-handleTncProbe, probeProto err, ";
            }
            sb.append(str2);
            sb.append(str);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", sb.toString());
        }
    }

    private void a(boolean z2, long j2) {
        if (this.f847s.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.f847s.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z2 ? 1 : 0;
        if (j2 > 0) {
            this.f847s.sendMessageDelayed(messageObtainMessage, j2);
        } else {
            this.f847s.sendMessage(messageObtainMessage);
        }
    }

    private boolean a(int i2) {
        if (i2 >= 100 && i2 < 1000) {
            d dVarC = c();
            if (dVarC != null && !TextUtils.isEmpty(dVarC.f827m)) {
                if (!dVarC.f827m.contains("" + i2)) {
                }
            }
            return false;
        }
        return true;
    }

    private void b(String str) {
        Map<String, String> mapE;
        if (TextUtils.isEmpty(str) || (mapE = e()) == null || !mapE.containsValue(str)) {
            return;
        }
        if (this.f845q.get(str) == null) {
            this.f845q.put(str, 1);
        } else {
            this.f845q.put(str, Integer.valueOf(this.f845q.get(str).intValue() + 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        d dVarC = c();
        if (dVarC == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doUpdateRemote, " + z2);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (z2 || this.a + (((long) dVarC.f825k) * 1000) <= jElapsedRealtime) {
            this.a = jElapsedRealtime;
            h.a().a(this.f846r, this.f834f).a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f834f));
        } else if (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a()) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-doUpdateRemote, time limit，当前时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()) + "，下次更新TNC配置剩余倒计时：" + (((this.a + (((long) dVarC.f825k) * 1000)) - jElapsedRealtime) / 1000) + "s");
        }
    }

    private boolean b(int i2) {
        return i2 >= 200 && i2 < 400;
    }

    private boolean c(String str) {
        Map<String, String> mapE = e();
        if (mapE == null) {
            return false;
        }
        String str2 = mapE.get(str);
        if (TextUtils.isEmpty(str2) || this.f845q.get(str2) == null || this.f845q.get(str2).intValue() < 3) {
            return false;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-handleHostMapping, TNC host faild num over limit: " + str);
        return true;
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f845q.containsKey(str)) {
            this.f845q.put(str, 0);
        }
    }

    private void i() {
        SharedPreferences sharedPreferences = this.f834f.getSharedPreferences(f(), 0);
        this.f836h = sharedPreferences.getInt("tnc_probe_cmd", 0);
        this.f837i = sharedPreferences.getLong("tnc_probe_version", 19700101000L);
    }

    private void j() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-resetTNCControlState");
        this.f838j = 0;
        this.f839k.clear();
        this.f840l.clear();
        this.f841m = 0;
        this.f842n.clear();
        this.f843o.clear();
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12.a a() {
        return this.b;
    }

    public String a(String str) {
        String protocol;
        StringBuilder sb;
        String str2;
        String string;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                th = th2;
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (c(host)) {
                    sb = new StringBuilder();
                    str2 = "Gromore-handleHostMapping, TNC host faild num over limit: ";
                } else {
                    Map<String, String> mapE = e();
                    if (mapE == null || !mapE.containsKey(host)) {
                        sb = new StringBuilder();
                        str2 = "Gromore-handleHostMapping, nomatch: ";
                    } else {
                        String str3 = mapE.get(host);
                        if (!TextUtils.isEmpty(str3)) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-handleHostMapping, match, origin: " + str);
                            String str4 = protocol + HttpConstant.SCHEME_SPLIT + host;
                            String str5 = protocol + HttpConstant.SCHEME_SPLIT + str3;
                            if (str.startsWith(str4)) {
                                str = str.replaceFirst(str4, str5);
                            }
                            string = "Gromore-handleHostMapping, target: " + str;
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", string);
                        }
                    }
                }
                sb.append(str2);
                sb.append(host);
                string = sb.toString();
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", string);
            }
        }
        return str;
    }

    public void a(Context context, boolean z2) {
        synchronized (this) {
            if (!this.f833e) {
                this.f834f = context;
                this.f844p = z2;
                this.f835g = new e(context, z2, this.f846r);
                if (z2) {
                    i();
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-initTnc, isMainProc: " + z2 + " probeCmd: " + this.f836h + " probeVersion: " + this.f837i);
                this.b = h.a().a(this.f846r, this.f834f);
                this.f833e = true;
            }
        }
    }

    public void a(b bVar) {
        this.f832d = bVar;
    }

    public void a(y yVar, a0 a0Var) {
        synchronized (this) {
            if (yVar != null && a0Var != null) {
                if (this.f844p && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f834f)) {
                    URL urlO = null;
                    try {
                        urlO = yVar.g().o();
                    } catch (Exception unused) {
                    }
                    if (urlO != null) {
                        String protocol = urlO.getProtocol();
                        String host = urlO.getHost();
                        String path = urlO.getPath();
                        String strA = a(yVar);
                        int iK = a0Var.k();
                        if (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(strA)) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-onResponse, url: " + protocol + HttpConstant.SCHEME_SPLIT + host + "#" + strA + "#" + iK);
                            d dVarC = c();
                            if (dVarC != null && dVarC.b) {
                                a(a0Var, host);
                            }
                            if (dVarC != null) {
                                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-onResponse, url matched: " + protocol + HttpConstant.SCHEME_SPLIT + host + "#" + strA + "#" + iK + " " + this.f838j + "#" + this.f839k.size() + "#" + this.f840l.size() + " " + this.f841m + "#" + this.f842n.size() + "#" + this.f843o.size());
                                if (iK > 0) {
                                    if (b(iK)) {
                                        if (this.f838j > 0 || this.f841m > 0) {
                                            j();
                                        }
                                        d(host);
                                    } else if (!a(iK)) {
                                        this.f841m++;
                                        this.f842n.put(path, 0);
                                        this.f843o.put(strA, 0);
                                        if (this.f841m >= dVarC.f822h && this.f842n.size() >= dVarC.f823i && this.f843o.size() >= dVarC.f824j) {
                                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-onResponse, url doUpdate: " + protocol + HttpConstant.SCHEME_SPLIT + host + "#" + strA + "#" + iK);
                                            a(false, 0L);
                                            j();
                                        }
                                        b(host);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(y yVar, Exception exc) {
        d dVarC;
        synchronized (this) {
            if (yVar != null) {
                if (yVar.g() != null && exc != null && this.f844p && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.e.a(this.f834f)) {
                    URL urlO = null;
                    try {
                        urlO = yVar.g().o();
                    } catch (Exception unused) {
                    }
                    if (urlO != null) {
                        String protocol = urlO.getProtocol();
                        String host = urlO.getHost();
                        String path = urlO.getPath();
                        String strA = a(yVar);
                        if (("http".equals(protocol) || "https".equals(protocol)) && (dVarC = c()) != null) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-onError, url matched: " + protocol + HttpConstant.SCHEME_SPLIT + host + "#" + strA + "# （mReqToCnt：" + this.f838j + "）#" + this.f839k.size() + "#" + this.f840l.size() + " " + this.f841m + "#" + this.f842n.size() + "#" + this.f843o.size());
                            this.f838j = this.f838j + 1;
                            this.f839k.put(path, 0);
                            this.f840l.put(strA, 0);
                            if (this.f838j >= dVarC.f819e && this.f839k.size() >= dVarC.f820f && this.f840l.size() >= dVarC.f821g) {
                                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_int108.b.a("TNCManager_GroMore", "Gromore-onError, url doUpate: " + protocol + HttpConstant.SCHEME_SPLIT + host + "#" + strA);
                                a(false, 0L);
                                j();
                            }
                            b(host);
                        }
                    }
                }
            }
        }
    }

    public void a(boolean z2) {
        this.f831c = z2;
    }

    public b b() {
        return this.f832d;
    }

    public d c() {
        e eVar = this.f835g;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public e d() {
        return this.f835g;
    }

    public Map<String, String> e() {
        d dVarC = c();
        if (dVarC != null) {
            return dVarC.f818d;
        }
        return null;
    }

    public String f() {
        return "ttnet_tnc_config" + this.f846r;
    }

    public boolean g() {
        return this.f831c;
    }

    public void h() {
        this.f845q.clear();
    }
}
