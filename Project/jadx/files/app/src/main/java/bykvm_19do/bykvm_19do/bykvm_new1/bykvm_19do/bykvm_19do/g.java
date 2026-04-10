package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.util.Printer;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.h;
import com.taobao.accs.common.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static boolean a = false;
    private static boolean b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f1932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static List<d> f1933d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f1936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static HandlerThread f1937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static long f1938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f1939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Handler f1940k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static int f1941l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f1942m;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile AtomicLong f1934e = new AtomicLong(-1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static long f1935f = 100;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile String f1943n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile boolean f1944o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f1945p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static long f1946q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static long f1947r = -1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static int f1948s = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static MessageQueue f1949t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static Field f1950u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static Field f1951v = null;

    static final class a implements Printer {
        a() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            if (g.b) {
                String unused = g.f1943n = str;
                if (!g.f1942m) {
                    boolean unused2 = g.f1942m = true;
                    int unused3 = g.f1945p = Process.myTid();
                    g.v();
                }
                g.f1946q = g.f1934e.get();
                if (g.f1947r != -1) {
                    long j2 = g.f1946q - g.f1947r;
                    if (j2 <= 0) {
                        g.k();
                        return;
                    }
                    int i2 = j2 == 1 ? g.f1941l > 1 ? 7 : g.f1941l == 1 ? 3 : 0 : g.f1941l > 1 ? 5 : g.f1941l == 1 ? 6 : 1;
                    long jS = g.s();
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    if (!g.f1944o) {
                        g.b(g.t(), jS - g.f1938i, jUptimeMillis - g.f1939j, j2, i2, g.f1941l, null);
                    }
                    long unused4 = g.f1938i = jS;
                    long unused5 = g.f1939j = jUptimeMillis;
                    int unused6 = g.f1941l = 1;
                }
            }
        }
    }

    static final class b implements Printer {
        b() {
        }

        @Override // android.util.Printer
        public void println(String str) {
            g.f1947r = g.f1934e.get();
            if (g.f1946q <= 0) {
                return;
            }
            long j2 = g.f1947r - g.f1946q;
            if (j2 > 0) {
                long jS = g.s();
                long jUptimeMillis = SystemClock.uptimeMillis();
                int i2 = (j2 != 1 || g.f1941l <= 1) ? (j2 == 1 && g.f1941l == 1) ? 2 : (j2 <= 1 || g.f1941l <= 1) ? (j2 <= 1 || g.f1941l != 1) ? 0 : 8 : 4 : 9;
                if (!g.f1944o) {
                    g.b(g.t(), jS - g.f1938i, jUptimeMillis - g.f1939j, j2, i2, g.f1941l, str);
                }
                long unused = g.f1938i = jS;
                long unused2 = g.f1939j = jUptimeMillis;
                int unused3 = g.f1941l = 0;
                g.f1946q = -1L;
            }
        }
    }

    static final class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            long j2;
            g.f1934e.set((SystemClock.uptimeMillis() - g.f1936g) / g.f1935f);
            long jUptimeMillis = (SystemClock.uptimeMillis() - g.f1936g) % g.f1935f;
            if (jUptimeMillis >= 95) {
                g.f1934e.incrementAndGet();
                j2 = g.f1935f << 1;
            } else {
                j2 = g.f1935f;
            }
            g.f1940k.postDelayed(this, j2 - jUptimeMillis);
        }
    }

    public static class d {
        public int a;
        public int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1952c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1953d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1954e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f1955f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f1956g;

        public String toString() {
            StringBuilder sb;
            String str;
            String str2;
            String str3;
            int i2 = this.b;
            if (i2 == 0) {
                sb = new StringBuilder();
                str3 = "[[[ IDLE  ]]] cost ";
            } else {
                if (i2 != 1) {
                    if (i2 == 2) {
                        sb = new StringBuilder();
                        sb.append("[[[  1 msg  ]]] cost ");
                        sb.append(this.f1952c);
                        sb.append(" tick , mDuration：");
                        sb.append(this.f1953d);
                        sb.append(",cpuTime:");
                        sb.append(this.f1954e);
                        sb.append(", msg:");
                    } else if (i2 == 3) {
                        sb = new StringBuilder();
                        str3 = "[[[ 1 msg + IDLE  ]]] cost ";
                    } else {
                        if (i2 != 4) {
                            if (i2 == 5) {
                                sb = new StringBuilder();
                                sb.append("[[[ ");
                                sb.append(this.a);
                                sb.append(" msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than");
                                sb.append(this.f1952c - 1);
                                str2 = " ticks, , mDuration：";
                            } else {
                                if (i2 != 6) {
                                    if (i2 == 7) {
                                        sb = new StringBuilder();
                                        sb.append("[[[ ");
                                        sb.append(this.a);
                                        str = " msgs + IDLE  ]]] cost 1 tick , mDuration：";
                                    } else if (i2 == 8) {
                                        sb = new StringBuilder();
                                        sb.append("[[[ 1 msgs ]]] cost ");
                                        sb.append(this.f1952c);
                                        sb.append(" ticks , mDuration：");
                                        sb.append(this.f1953d);
                                        sb.append(" cost cpuTime:");
                                    } else {
                                        if (i2 != 9) {
                                            sb = new StringBuilder();
                                            sb.append("=========   UNKNOW =========  Type:");
                                            sb.append(this.b);
                                            sb.append(" cost ticks ");
                                            sb.append(this.f1952c);
                                            sb.append(" msgs:");
                                            sb.append(this.a);
                                            return sb.toString();
                                        }
                                        sb = new StringBuilder();
                                        sb.append("[[[ ");
                                        sb.append(this.a);
                                        str = " msgs ]]] cost 1 tick , mDuration：";
                                    }
                                    sb.append(str);
                                    sb.append(this.f1953d);
                                    sb.append(" cost cpuTime:");
                                    sb.append(this.f1954e);
                                    return sb.toString();
                                }
                                sb = new StringBuilder();
                                sb.append("[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than");
                                sb.append(this.f1952c - 1);
                                str2 = ", , mDuration：";
                            }
                            sb.append(str2);
                            sb.append(this.f1953d);
                            sb.append("cpuTime:");
                            sb.append(this.f1954e);
                            return sb.toString();
                        }
                        sb = new StringBuilder();
                        sb.append("[[[ ");
                        sb.append(this.a - 1);
                        sb.append(" msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than ");
                        sb.append(this.f1952c - 1);
                        sb.append("tick ,, mDuration：");
                        sb.append(this.f1953d);
                        sb.append("cpuTime:");
                        sb.append(this.f1954e);
                        sb.append(" msg:");
                    }
                    sb.append(this.f1956g);
                    return sb.toString();
                }
                sb = new StringBuilder();
                str3 = "[[[ Long IDLE  ]]] cost ";
            }
            sb.append(str3);
            sb.append(this.f1952c);
            sb.append(" tick , mDuration：");
            sb.append(this.f1953d);
            sb.append(",cpuTime:");
            sb.append(this.f1954e);
            return sb.toString();
        }
    }

    private static Message a(Message message) {
        Message message2;
        Field field = f1951v;
        try {
            if (field == null) {
                f1951v = Class.forName("android.os.Message").getDeclaredField("next");
                f1951v.setAccessible(true);
                message2 = (Message) f1951v.get(message);
                if (a) {
                    String str = "[getNextMessage] success get next msg :" + message2;
                }
            } else {
                message2 = (Message) field.get(message);
            }
            return message2;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Message a(MessageQueue messageQueue) {
        Object obj;
        Field field = f1950u;
        try {
            if (field == null) {
                f1950u = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                f1950u.setAccessible(true);
                obj = f1950u.get(messageQueue);
            } else {
                obj = field.get(messageQueue);
            }
            return (Message) obj;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONArray a(int i2, long j2) {
        MessageQueue messageQueueR = r();
        JSONArray jSONArray = new JSONArray();
        if (messageQueueR != null) {
            synchronized (messageQueueR) {
                Message messageA = a(messageQueueR);
                if (messageA != null) {
                    int i3 = 0;
                    int i4 = 0;
                    while (messageA != null && i3 < i2) {
                        i3++;
                        i4++;
                        JSONObject jSONObjectA = a(messageA, j2);
                        try {
                            jSONObjectA.put("id", i4);
                        } catch (JSONException unused) {
                        }
                        jSONArray.put(jSONObjectA);
                        messageA = a(messageA);
                    }
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(Message message, long j2) {
        JSONObject jSONObject = new JSONObject();
        if (message != null) {
            try {
                jSONObject.put("when", message.getWhen() - j2);
                if (message.getCallback() != null) {
                    jSONObject.put("callback", message.getCallback());
                }
                jSONObject.put("what", message.what);
                if (message.getTarget() != null) {
                    jSONObject.put(Constants.KEY_TARGET, message.getTarget());
                } else {
                    jSONObject.put("barrier", message.arg1);
                }
                jSONObject.put("arg1", message.arg1);
                jSONObject.put("arg2", message.arg2);
                if (message.obj != null) {
                    jSONObject.put("obj", message.obj);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static void a(int i2, int i3) {
        if (b) {
            if (i2 > 10) {
                f1932c = i2;
            }
            if (i3 > 10) {
                f1935f = i3;
            }
            f1933d = new ArrayList();
            u();
            a(r());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(d dVar, long j2, long j3, long j4, int i2, int i3, String str) {
        dVar.f1954e = j2;
        dVar.f1952c = j4;
        dVar.f1953d = j3;
        dVar.f1955f = false;
        dVar.a = i3;
        if (str != null) {
            dVar.f1956g = str;
        }
        dVar.b = i2;
    }

    public static JSONObject c(long j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", f1943n);
            jSONObject.put("currentMessageCost", o());
            jSONObject.put("currentMessageCpu", s() - f1938i);
            jSONObject.put("currentTick", f1934e.get());
        } catch (Throwable th) {
            j.a(th);
        }
        return jSONObject;
    }

    static /* synthetic */ int k() {
        int i2 = f1941l;
        f1941l = i2 + 1;
        return i2;
    }

    public static long o() {
        return (SystemClock.uptimeMillis() - f1936g) - ((f1946q < 0 ? f1947r : f1946q) * f1935f);
    }

    public static List<d> p() {
        if (f1933d == null) {
            return null;
        }
        f1944o = true;
        ArrayList arrayList = new ArrayList();
        if (f1933d.size() == f1932c) {
            for (int i2 = f1948s; i2 < f1933d.size(); i2++) {
                arrayList.add(f1933d.get(i2));
            }
            for (int i3 = 0; i3 < f1948s; i3++) {
                arrayList.add(f1933d.get(i3));
            }
        } else {
            arrayList.addAll(f1933d);
        }
        f1944o = false;
        return arrayList;
    }

    public static JSONArray q() {
        JSONArray jSONArray = new JSONArray();
        List<d> listP = p();
        if (listP != null) {
            int i2 = 0;
            for (d dVar : listP) {
                if (dVar != null) {
                    i2++;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("msg", dVar.f1956g);
                        jSONObject.put("cpuDuration", dVar.f1954e);
                        jSONObject.put("duration", dVar.f1953d);
                        jSONObject.put("tick", dVar.f1952c);
                        jSONObject.put("type", dVar.b);
                        jSONObject.put("count", dVar.a);
                        jSONObject.put("id", i2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
        }
        return jSONArray;
    }

    public static MessageQueue r() {
        MessageQueue queue;
        if (f1949t == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                queue = Looper.myQueue();
            } else if (Build.VERSION.SDK_INT >= 23) {
                queue = mainLooper.getQueue();
            } else {
                try {
                    Field declaredField = mainLooper.getClass().getDeclaredField("mQueue");
                    declaredField.setAccessible(true);
                    f1949t = (MessageQueue) declaredField.get(mainLooper);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            f1949t = queue;
        }
        return f1949t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long s() {
        return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.c.a(f1945p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static d t() {
        int size = f1933d.size();
        int i2 = f1932c;
        if (size == i2) {
            f1948s = (f1948s + 1) % i2;
            return f1933d.get(f1948s);
        }
        d dVar = new d();
        f1933d.add(dVar);
        f1948s++;
        return dVar;
    }

    public static void u() {
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.g.a(4L);
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().a();
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().b(new a());
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().a(new b());
        f1938i = s();
        f1939j = SystemClock.uptimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void v() {
        f1937h = h.b();
        f1936g = SystemClock.uptimeMillis();
        f1940k = new Handler(f1937h.getLooper());
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.g.a(8L);
        f1940k.postDelayed(new c(), f1935f);
    }
}
