package com.taobao.accs.ut.monitor;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class TrafficsMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f18295d;
    private Map<String, List<a>> a = new HashMap();
    private Map<String, String> b = new HashMap<String, String>() { // from class: com.taobao.accs.ut.monitor.TrafficsMonitor.1
        {
            put("im", "512");
            put("motu", "513");
            put("acds", "514");
            put(GlobalClientInfo.AGOO_SERVICE_ID, "515");
            put(AgooConstants.AGOO_SERVICE_AGOOACK, "515");
            put("agooTokenReport", "515");
            put("accsSelf", "1000");
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18294c = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18296e = "";

    /* JADX INFO: compiled from: Taobao */
    @Monitor(module = "NetworkSDK", monitorPoint = "TrafficStats")
    public static class StatTrafficMonitor extends BaseMonitor {

        @Dimension
        public String bizId;

        @Dimension
        public String date;

        @Dimension
        public String host;

        @Dimension
        public boolean isBackground;

        @Dimension
        public String serviceId;

        @Measure
        public long size;
    }

    public TrafficsMonitor(Context context) {
        this.f18295d = context;
    }

    private void b() {
        String str;
        boolean z2;
        synchronized (this.a) {
            String strA = UtilityImpl.a(System.currentTimeMillis());
            if (TextUtils.isEmpty(this.f18296e) || this.f18296e.equals(strA)) {
                str = strA;
                z2 = false;
            } else {
                str = this.f18296e;
                z2 = true;
            }
            Iterator<String> it = this.a.keySet().iterator();
            while (it.hasNext()) {
                for (a aVar : this.a.get(it.next())) {
                    if (aVar != null) {
                        com.taobao.accs.b.a.a(this.f18295d).a(aVar.f18299e, aVar.f18297c, this.b.get(aVar.f18297c), aVar.f18298d, aVar.f18300f, str);
                    }
                }
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("TrafficsMonitor", "savetoDay:" + str + " saveTraffics" + this.a.toString(), new Object[0]);
            }
            if (z2) {
                this.a.clear();
                c();
            } else if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d("TrafficsMonitor", "no need commit lastsaveDay:" + this.f18296e + " currday:" + strA, new Object[0]);
            }
            this.f18296e = strA;
            this.f18294c = 0;
        }
    }

    private void c() {
        List<a> listA = com.taobao.accs.b.a.a(this.f18295d).a(false);
        if (listA == null) {
            return;
        }
        try {
            for (a aVar : listA) {
                if (aVar != null) {
                    StatTrafficMonitor statTrafficMonitor = new StatTrafficMonitor();
                    statTrafficMonitor.bizId = aVar.b;
                    statTrafficMonitor.date = aVar.a;
                    statTrafficMonitor.host = aVar.f18299e;
                    statTrafficMonitor.isBackground = aVar.f18298d;
                    statTrafficMonitor.size = aVar.f18300f;
                    AppMonitor.getInstance().commitStat(statTrafficMonitor);
                }
            }
            com.taobao.accs.b.a.a(this.f18295d).a();
        } catch (Throwable th) {
            ALog.e("", th.toString(), new Object[0]);
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
        boolean z2;
        if (aVar == null || aVar.f18299e == null || aVar.f18300f <= 0) {
            return;
        }
        aVar.f18297c = TextUtils.isEmpty(aVar.f18297c) ? "accsSelf" : aVar.f18297c;
        synchronized (this.a) {
            String str = this.b.get(aVar.f18297c);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            aVar.b = str;
            ALog.isPrintLog(ALog.Level.D);
            List<a> arrayList = this.a.get(str);
            if (arrayList != null) {
                Iterator<a> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = true;
                        break;
                    }
                    a next = it.next();
                    if (next.f18298d == aVar.f18298d && next.f18299e != null && next.f18299e.equals(aVar.f18299e)) {
                        next.f18300f += aVar.f18300f;
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                    arrayList.add(aVar);
                }
            } else {
                arrayList = new ArrayList<>();
                arrayList.add(aVar);
            }
            this.a.put(str, arrayList);
            this.f18294c++;
            if (this.f18294c >= 10) {
                b();
            }
        }
    }

    /* JADX INFO: compiled from: Taobao */
    public static class a {
        String a;
        String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f18297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f18298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f18299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f18300f;

        public a(String str, boolean z2, String str2, long j2) {
            this.f18297c = str;
            this.f18298d = z2;
            this.f18299e = str2;
            this.f18300f = j2;
        }

        public String toString() {
            return "date:" + this.a + " bizId:" + this.b + " serviceId:" + this.f18297c + " host:" + this.f18299e + " isBackground:" + this.f18298d + " size:" + this.f18300f;
        }

        public a(String str, String str2, String str3, boolean z2, String str4, long j2) {
            this.a = str;
            this.b = str2;
            this.f18297c = str3;
            this.f18298d = z2;
            this.f18299e = str4;
            this.f18300f = j2;
        }
    }

    public void a() {
        try {
            synchronized (this.a) {
                this.a.clear();
            }
            List<a> listA = com.taobao.accs.b.a.a(this.f18295d).a(true);
            if (listA == null) {
                return;
            }
            Iterator<a> it = listA.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        } catch (Exception e2) {
            ALog.w("TrafficsMonitor", e2.toString(), new Object[0]);
        }
    }
}
