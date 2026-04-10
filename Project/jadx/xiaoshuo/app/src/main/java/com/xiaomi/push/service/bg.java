package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.iflytek.aikit.utils.constants.ErrorCode;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import miuix.android.content.SystemIntent;

/* JADX INFO: loaded from: classes8.dex */
public class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bg f8238a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ConcurrentHashMap<String, HashMap<String, b>> f973a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<a> f972a = new ArrayList();

    public interface a {
        void a();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Context f974a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Messenger f976a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private XMPushService f978a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public l f981a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f982a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f984a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f985b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        c f980a = c.unbind;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8239a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final CopyOnWriteArrayList<a> f983a = new CopyOnWriteArrayList<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c f8240b = null;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f986b = false;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private XMPushService.c f977a = new XMPushService.c(this);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        IBinder.DeathRecipient f975a = null;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final C0558b f979a = new C0558b();

        public interface a {
            void a(c cVar, c cVar2, int i);
        }

        /* JADX INFO: renamed from: com.xiaomi.push.service.bg$b$b, reason: collision with other inner class name */
        public class C0558b extends XMPushService.j {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            String f987a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f8242b;

            /* JADX INFO: renamed from: b, reason: collision with other field name */
            String f988b;
            int c;

            public C0558b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            public String a() {
                return "notify job";
            }

            @Override // com.xiaomi.push.service.XMPushService.j
            /* JADX INFO: renamed from: a */
            public void mo435a() {
                if (b.this.a(this.f8242b, this.c, this.f988b)) {
                    b.this.a(this.f8242b, this.c, this.f987a, this.f988b);
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.b(" ignore notify client :" + b.this.g);
            }

            public XMPushService.j a(int i, int i2, String str, String str2) {
                this.f8242b = i;
                this.c = i2;
                this.f988b = str2;
                this.f987a = str;
                return this;
            }
        }

        public class c implements IBinder.DeathRecipient {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Messenger f8243a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            final b f989a;

            public c(b bVar, Messenger messenger) {
                this.f989a = bVar;
                this.f8243a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                com.xiaomi.channel.commonutils.logger.b.b("peer died, chid = " + this.f989a.g);
                b.this.f978a.a(new bi(this, 0), 0L);
                if ("9".equals(this.f989a.g) && SystemIntent.ACTIVATE_SERVICE_HOST_PACKAGE.equals(b.this.f978a.getPackageName())) {
                    b.this.f978a.a(new bj(this, 0), 60000L);
                }
            }
        }

        public b() {
        }

        private boolean b(int i, int i2, String str) {
            if (i == 1) {
                return (this.f980a == c.binded || !this.f978a.m725c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i == 2) {
                return this.f978a.m725c();
            }
            if (i != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        public String a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m770a() {
            try {
                Messenger messenger = this.f976a;
                if (messenger != null && this.f975a != null) {
                    messenger.getBinder().unlinkToDeath(this.f975a, 0);
                }
            } catch (Exception unused) {
            }
            this.f8240b = null;
        }

        public void b(a aVar) {
            this.f983a.remove(aVar);
        }

        public b(XMPushService xMPushService) {
            this.f978a = xMPushService;
            a(new bh(this));
        }

        public void a(Messenger messenger) {
            m770a();
            try {
                if (messenger != null) {
                    this.f976a = messenger;
                    this.f986b = true;
                    this.f975a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f975a, 0);
                } else {
                    com.xiaomi.channel.commonutils.logger.b.b("peer linked with old sdk chid = " + this.g);
                }
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.b("peer linkToDeath err: " + e.getMessage());
                this.f976a = null;
                this.f986b = false;
            }
        }

        public void a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            for (a aVar : this.f983a) {
                if (aVar != null) {
                    aVar.a(this.f980a, cVar, i2);
                }
            }
            c cVar2 = this.f980a;
            int i3 = 0;
            if (cVar2 != cVar) {
                com.xiaomi.channel.commonutils.logger.b.m106a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, a(i), bk.a(i2), str, str2, this.g));
                this.f980a = cVar;
            }
            if (this.f981a == null) {
                com.xiaomi.channel.commonutils.logger.b.d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f8240b != null && (z = this.f986b)) {
                i3 = (this.f976a == null || !z) ? ErrorCode.MSP_ERROR_GENERAL : 1000;
            }
            this.f978a.b(this.f979a);
            if (b(i, i2, str2)) {
                a(i, i2, str, str2);
            } else {
                this.f978a.a(this.f979a.a(i, i2, str, str2), i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, String str, String str2) {
            c cVar = this.f980a;
            this.f8240b = cVar;
            if (i == 2) {
                this.f981a.a(this.f974a, this, i2);
                return;
            }
            if (i == 3) {
                this.f981a.a(this.f974a, this, str2, str);
                return;
            }
            if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f8239a++;
                } else if (z) {
                    this.f8239a = 0;
                    if (this.f976a != null) {
                        try {
                            this.f976a.send(Message.obtain(null, 16, this.f978a.f900a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f981a.a(this.f978a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(int i, int i2, String str) {
            boolean z;
            c cVar = this.f8240b;
            if (cVar == null || !(z = this.f986b)) {
                return true;
            }
            if (cVar == this.f980a) {
                com.xiaomi.channel.commonutils.logger.b.b(" status recovered, don't notify client:" + this.g);
                return false;
            }
            if (this.f976a != null && z) {
                com.xiaomi.channel.commonutils.logger.b.b("Peer alive notify status to client:" + this.g);
                return true;
            }
            com.xiaomi.channel.commonutils.logger.b.b("peer died, ignore notify " + this.g);
            return false;
        }

        public void a(a aVar) {
            this.f983a.add(aVar);
        }

        public long a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((long) ((this.f8239a + 1) * 15))) * 1000;
        }

        public static String a(String str) {
            int iLastIndexOf;
            return (TextUtils.isEmpty(str) || (iLastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(iLastIndexOf + 1);
        }
    }

    public enum c {
        unbind,
        binding,
        binded
    }

    private bg() {
    }

    public static synchronized bg a() {
        if (f8238a == null) {
            f8238a = new bg();
        }
        return f8238a;
    }

    public synchronized void b() {
        this.f972a.clear();
    }

    public synchronized void a(b bVar) {
        HashMap<String, b> map = this.f973a.get(bVar.g);
        if (map == null) {
            map = new HashMap<>();
            this.f973a.put(bVar.g, map);
        }
        map.put(a(bVar.f985b), bVar);
        com.xiaomi.channel.commonutils.logger.b.m106a("add active client. " + bVar.f982a);
        Iterator<a> it = this.f972a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m768a(String str, String str2) {
        HashMap<String, b> map = this.f973a.get(str);
        if (map != null) {
            b bVar = map.get(a(str2));
            if (bVar != null) {
                bVar.m770a();
            }
            map.remove(a(str2));
            if (map.isEmpty()) {
                this.f973a.remove(str);
            }
        }
        Iterator<a> it = this.f972a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m767a(String str) {
        HashMap<String, b> map = this.f973a.get(str);
        if (map != null) {
            Iterator<b> it = map.values().iterator();
            while (it.hasNext()) {
                it.next().m770a();
            }
            map.clear();
            this.f973a.remove(str);
        }
        Iterator<a> it2 = this.f972a.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized List<String> m765a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f973a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f982a)) {
                    arrayList.add(bVar.g);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized ArrayList<b> m763a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f973a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized Collection<b> m764a(String str) {
        if (!this.f973a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f973a.get(str).clone()).values();
    }

    public synchronized b a(String str, String str2) {
        HashMap<String, b> map = this.f973a.get(str);
        if (map == null) {
            return null;
        }
        return map.get(a(str2));
    }

    public synchronized void a(Context context, int i) {
        Iterator<HashMap<String, b>> it = this.f973a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized int m762a() {
        return this.f973a.size();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m766a() {
        Iterator<b> it = m763a().iterator();
        while (it.hasNext()) {
            it.next().m770a();
        }
        this.f973a.clear();
    }

    public synchronized void a(Context context) {
        Iterator<HashMap<String, b>> it = this.f973a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int iIndexOf = str.indexOf("@");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }

    public synchronized void a(a aVar) {
        this.f972a.add(aVar);
    }
}
