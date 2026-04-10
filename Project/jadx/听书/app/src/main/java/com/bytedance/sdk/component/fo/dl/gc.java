package com.bytedance.sdk.component.fo.dl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.utils.wp;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f707a;
    private z dl;
    private Context e;
    private g gc;
    private a gz;
    private int js;
    private long g = 0;
    private boolean m = false;
    private int fo = 0;
    private long uy = 19700101000L;
    private int kb = 0;
    private HashMap<String, Integer> wp = new HashMap<>();
    private HashMap<String, Integer> i = new HashMap<>();
    private int v = 0;
    private HashMap<String, Integer> pf = new HashMap<>();
    private HashMap<String, Integer> ls = new HashMap<>();
    private boolean p = true;
    private Map<String, Integer> fv = new HashMap();
    Handler z = new Handler(Looper.getMainLooper()) { // from class: com.bytedance.sdk.component.fo.dl.gc.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10000) {
                return;
            }
            gc.this.g(message.arg1 != 0);
        }
    };

    private boolean z(int i) {
        return i >= 200 && i < 400;
    }

    private gc() {
    }

    public gc(int i) {
        this.js = i;
    }

    public String z() {
        return "ttnet_tnc_config" + this.js;
    }

    public z g() {
        return this.dl;
    }

    public void z(boolean z) {
        this.f707a = z;
    }

    public void z(g gVar) {
        this.gc = gVar;
    }

    public boolean dl() {
        return this.f707a;
    }

    public g a() {
        return this.gc;
    }

    public void gc() {
        this.fv.clear();
    }

    public synchronized void z(Context context, boolean z) {
        if (!this.m) {
            this.e = context;
            this.p = z;
            this.gz = new a(context, z, this.js);
            if (z) {
                fo();
            }
            com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "initTnc, isMainProc: " + z + " probeCmd: " + this.fo + " probeVersion: " + this.uy);
            this.dl = e.z().z(this.js, this.e);
            this.m = true;
        }
    }

    private void fo() {
        SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(this.e, z(), 0);
        this.fo = sharedPreferencesG.getInt("tnc_probe_cmd", 0);
        this.uy = sharedPreferencesG.getLong("tnc_probe_version", 19700101000L);
    }

    public dl m() {
        a aVar = this.gz;
        if (aVar != null) {
            return aVar.dl();
        }
        return null;
    }

    public Map<String, String> e() {
        dl dlVarM = m();
        if (dlVarM != null) {
            return dlVarM.f706a;
        }
        return null;
    }

    public a gz() {
        return this.gz;
    }

    public String z(String str) {
        String protocol;
        if (!TextUtils.isEmpty(str) && !str.contains("/network/get_network") && !str.contains("/get_domains/v4") && !str.contains("/ies/speed")) {
            String host = null;
            try {
                URL url = new URL(str);
                protocol = url.getProtocol();
                try {
                    host = url.getHost();
                } catch (Throwable th) {
                    th = th;
                    wp.z(th);
                }
            } catch (Throwable th2) {
                th = th2;
                protocol = null;
            }
            if (!TextUtils.isEmpty(protocol) && (("http".equals(protocol) || "https".equals(protocol)) && !TextUtils.isEmpty(host))) {
                if (a(host)) {
                    com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(host)));
                    return str;
                }
                Map<String, String> mapE = e();
                if (mapE == null || !mapE.containsKey(host)) {
                    com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleHostMapping, nomatch: ".concat(String.valueOf(host)));
                } else {
                    String str2 = mapE.get(host);
                    if (TextUtils.isEmpty(str2)) {
                        return str;
                    }
                    com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleHostMapping, match, origin: ".concat(String.valueOf(str)));
                    String str3 = protocol + "://" + host;
                    String str4 = protocol + "://" + str2;
                    if (str.startsWith(str3)) {
                        str = str.replaceFirst(str3, str4);
                    }
                    com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleHostMapping, target: ".concat(String.valueOf(str)));
                    return str;
                }
            }
        }
        return str;
    }

    public synchronized void z(v vVar, ls lsVar) {
        URL urlZ;
        if (vVar == null || lsVar == null) {
            return;
        }
        if (this.p) {
            if (com.bytedance.sdk.component.fo.a.m.z(this.e)) {
                try {
                    urlZ = vVar.g().z();
                } catch (Exception unused) {
                    urlZ = null;
                }
                if (urlZ == null) {
                    return;
                }
                String protocol = urlZ.getProtocol();
                String host = urlZ.getHost();
                String path = urlZ.getPath();
                String strZ = z(vVar);
                int iDl = lsVar.dl();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    if (TextUtils.isEmpty(strZ)) {
                        return;
                    }
                    com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "onResponse, url: " + protocol + "://" + host + "#" + strZ + "#" + iDl);
                    dl dlVarM = m();
                    if (dlVarM != null && dlVarM.g) {
                        z(lsVar, host);
                    }
                    if (dlVarM == null) {
                        return;
                    }
                    com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "onResponse, url matched: " + protocol + "://" + host + "#" + strZ + "#" + iDl + " " + this.kb + "#" + this.wp.size() + "#" + this.i.size() + " " + this.v + "#" + this.pf.size() + "#" + this.ls.size());
                    if (iDl > 0) {
                        if (z(iDl)) {
                            if (this.kb > 0 || this.v > 0) {
                                uy();
                            }
                            dl(host);
                            return;
                        }
                        if (!g(iDl)) {
                            this.v++;
                            this.pf.put(path, 0);
                            this.ls.put(strZ, 0);
                            if (this.v >= dlVarM.gz && this.pf.size() >= dlVarM.fo && this.ls.size() >= dlVarM.uy) {
                                com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "onResponse, url doUpdate: " + protocol + "://" + host + "#" + strZ + "#" + iDl);
                                z(false, 0L);
                                uy();
                            }
                            g(host);
                        }
                    }
                }
            }
        }
    }

    private String z(v vVar) {
        if (vVar == null || vVar.g() == null || vVar.g().z() == null) {
            return "";
        }
        try {
            return InetAddress.getByName(vVar.g().z().getHost()).getHostAddress();
        } catch (Exception unused) {
            return "";
        }
    }

    private void g(String str) {
        Map<String, String> mapE;
        if (TextUtils.isEmpty(str) || (mapE = e()) == null || !mapE.containsValue(str)) {
            return;
        }
        if (this.fv.get(str) == null) {
            this.fv.put(str, 1);
        } else {
            this.fv.put(str, Integer.valueOf(this.fv.get(str).intValue() + 1));
        }
    }

    private void dl(String str) {
        if (!TextUtils.isEmpty(str) && this.fv.containsKey(str)) {
            this.fv.put(str, 0);
        }
    }

    private boolean a(String str) {
        Map<String, String> mapE = e();
        if (mapE == null) {
            return false;
        }
        String str2 = mapE.get(str);
        if (TextUtils.isEmpty(str2) || this.fv.get(str2) == null || this.fv.get(str2).intValue() < 3) {
            return false;
        }
        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleHostMapping, TNC host faild num over limit: ".concat(String.valueOf(str)));
        return true;
    }

    public synchronized void z(v vVar, Exception exc) {
        URL urlZ;
        if (vVar != null) {
            if (vVar.g() != null && exc != null) {
                if (this.p) {
                    if (com.bytedance.sdk.component.fo.a.m.z(this.e)) {
                        try {
                            urlZ = vVar.g().z();
                        } catch (Exception unused) {
                            urlZ = null;
                        }
                        if (urlZ == null) {
                            return;
                        }
                        String protocol = urlZ.getProtocol();
                        String host = urlZ.getHost();
                        String path = urlZ.getPath();
                        String strZ = z(vVar);
                        if ("http".equals(protocol) || "https".equals(protocol)) {
                            dl dlVarM = m();
                            if (dlVarM == null) {
                                return;
                            }
                            com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "onError, url matched: " + protocol + "://" + host + "#" + strZ + "# " + this.kb + "#" + this.wp.size() + "#" + this.i.size() + " " + this.v + "#" + this.pf.size() + "#" + this.ls.size());
                            this.kb++;
                            this.wp.put(path, 0);
                            this.i.put(strZ, 0);
                            if (this.kb >= dlVarM.gc && this.wp.size() >= dlVarM.m && this.i.size() >= dlVarM.e) {
                                com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "onError, url doUpate: " + protocol + "://" + host + "#" + strZ);
                                z(false, 0L);
                                uy();
                            }
                            g(host);
                        }
                    }
                }
            }
        }
    }

    private void z(ls lsVar, String str) {
        int i;
        long j;
        dl dlVarM;
        if (lsVar != null && this.p) {
            String strZ = lsVar.z("tnc-cmd", null);
            if (TextUtils.isEmpty(strZ)) {
                com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleTncProbe, no probeProto, ".concat(String.valueOf(str)));
                return;
            }
            String[] strArrSplit = strZ.split("@");
            if (strArrSplit == null || strArrSplit.length != 2) {
                com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleTncProbe, probeProto err, ".concat(String.valueOf(str)));
                return;
            }
            try {
                i = Integer.parseInt(strArrSplit[0]);
            } catch (Throwable th) {
                th = th;
                i = 0;
            }
            try {
                j = Long.parseLong(strArrSplit[1]);
            } catch (Throwable th2) {
                th = th2;
                wp.z(th);
                com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleTncProbe, probeProto except, ".concat(String.valueOf(str)));
                j = 0;
            }
            com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleTncProbe, local: " + this.fo + "@" + this.uy + " svr: " + i + "@" + j + " " + str);
            if (j <= this.uy) {
                return;
            }
            this.fo = i;
            this.uy = j;
            com.bytedance.sdk.openadsdk.api.plugin.g.g(this.e, z(), 0).edit().putInt("tnc_probe_cmd", i).putLong("tnc_probe_version", j).apply();
            if (this.fo != 10000 || (dlVarM = m()) == null) {
                return;
            }
            long jNextInt = dlVarM.wp > 0 ? ((long) new Random(System.currentTimeMillis()).nextInt(dlVarM.wp)) * 1000 : 0L;
            com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "handleTncProbe, updateConfig delay: " + jNextInt + " " + str);
            z(true, jNextInt);
        }
    }

    private void z(boolean z, long j) {
        if (this.z.hasMessages(10000)) {
            return;
        }
        Message messageObtainMessage = this.z.obtainMessage();
        messageObtainMessage.what = 10000;
        messageObtainMessage.arg1 = z ? 1 : 0;
        if (j > 0) {
            this.z.sendMessageDelayed(messageObtainMessage, j);
        } else {
            this.z.sendMessage(messageObtainMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        dl dlVarM = m();
        if (dlVarM == null) {
            return;
        }
        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doUpdateRemote, ".concat(String.valueOf(z)));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!z && this.g + (((long) dlVarM.kb) * 1000) > jElapsedRealtime) {
            com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "doUpdateRemote, time limit");
        } else {
            this.g = jElapsedRealtime;
            e.z().z(this.js, this.e).dl();
        }
    }

    private void uy() {
        com.bytedance.sdk.component.fo.a.dl.g("TNCManager", "resetTNCControlState");
        this.kb = 0;
        this.wp.clear();
        this.i.clear();
        this.v = 0;
        this.pf.clear();
        this.ls.clear();
    }

    private boolean g(int i) {
        if (i < 100 || i >= 1000) {
            return true;
        }
        dl dlVarM = m();
        return (dlVarM == null || TextUtils.isEmpty(dlVarM.i) || !dlVarM.i.contains(String.valueOf(i))) ? false : true;
    }
}
