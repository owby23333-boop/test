package com.bytedance.e.e.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.e.e.ga.v;
import com.bytedance.e.e.v.m;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p {
    private static Handler bh = null;
    private static boolean d = false;
    private static int ga = 0;
    private static HandlerThread m = null;
    private static boolean s = false;
    private static int t = 0;
    private static boolean tg = true;
    private static List<e> vn;
    private static long wu;
    private static long xu;
    private static long zk;
    private static volatile AtomicLong p = new AtomicLong(-1);
    private static long v = 100;
    private static volatile String w = null;
    private static volatile boolean l = false;
    private static int f = -1;
    public static long e = -1;
    public static long bf = -1;
    private static int k = -1;
    private static MessageQueue dt = null;
    private static Field pe = null;
    private static Field y = null;

    public static class e {
        public int bf;
        public long d;
        public int e;
        public long ga;
        public String p;
        public long tg;
        public boolean vn;

        public String toString() {
            int i = this.bf;
            if (i == 0) {
                return "[[[ IDLE  ]]] cost " + this.d + " tick , mDuration：" + this.tg + ",cpuTime:" + this.ga;
            }
            if (i == 1) {
                return "[[[ Long IDLE  ]]] cost " + this.d + " tick , mDuration：" + this.tg + ",cpuTime:" + this.ga;
            }
            if (i == 2) {
                return "[[[  1 msg  ]]] cost " + this.d + " tick , mDuration：" + this.tg + ",cpuTime:" + this.ga + ", msg:" + this.p;
            }
            if (i == 3) {
                return "[[[ 1 msg + IDLE  ]]] cost " + this.d + " tick , mDuration：" + this.tg + ",cpuTime:" + this.ga;
            }
            if (i == 4) {
                return "[[[ " + (this.e - 1) + " msgs  ]]] cost less than 1 tick, [[[  last msg ]]] cost more than " + (this.d - 1) + "tick ,, mDuration：" + this.tg + "cpuTime:" + this.ga + " msg:" + this.p;
            }
            if (i == 5) {
                return "[[[ " + this.e + " msgs ]]] cost less than 1 tick but [[[  IDLE ]]] cost more than" + (this.d - 1) + " ticks, , mDuration：" + this.tg + "cpuTime:" + this.ga;
            }
            if (i == 6) {
                return "[[[  1 msg  ]]] cost less than 1 tick , but [[[  IDLE ]]] cost more than" + (this.d - 1) + ", , mDuration：" + this.tg + "cpuTime:" + this.ga;
            }
            if (i == 7) {
                return "[[[ " + this.e + " msgs + IDLE  ]]] cost 1 tick , mDuration：" + this.tg + " cost cpuTime:" + this.ga;
            }
            if (i == 8) {
                return "[[[ 1 msgs ]]] cost " + this.d + " ticks , mDuration：" + this.tg + " cost cpuTime:" + this.ga + " msg:" + this.p;
            }
            if (i == 9) {
                return "[[[ " + this.e + " msgs ]]] cost 1 tick , mDuration：" + this.tg + " cost cpuTime:" + this.ga;
            }
            return "=========   UNKNOW =========  Type:" + this.bf + " cost ticks " + this.d + " msgs:" + this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e dt() {
        int size = vn.size();
        int i = ga;
        if (size == i) {
            int i2 = (k + 1) % i;
            k = i2;
            return vn.get(i2);
        }
        e eVar = new e();
        vn.add(eVar);
        k++;
        return eVar;
    }

    public static long ga() {
        long jUptimeMillis;
        long j;
        long j2;
        if (e < 0) {
            jUptimeMillis = SystemClock.uptimeMillis() - zk;
            j = bf;
            j2 = v;
        } else {
            jUptimeMillis = SystemClock.uptimeMillis() - zk;
            j = e;
            j2 = v;
        }
        return jUptimeMillis - (j * j2);
    }

    public static /* synthetic */ int m() {
        int i = t;
        t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pe() {
        m = v.e();
        zk = SystemClock.uptimeMillis();
        bh = new Handler(m.getLooper());
        com.bytedance.e.e.ga.p.e(8L);
        bh.postDelayed(new Runnable() { // from class: com.bytedance.e.e.e.p.3
            @Override // java.lang.Runnable
            public void run() {
                long j;
                p.p.set((SystemClock.uptimeMillis() - p.zk) / p.v);
                long jUptimeMillis = (SystemClock.uptimeMillis() - p.zk) % p.v;
                if (jUptimeMillis >= 95) {
                    p.p.incrementAndGet();
                    j = p.v << 1;
                } else {
                    j = p.v;
                }
                p.bh.postDelayed(this, j - jUptimeMillis);
            }
        }, v);
    }

    public static MessageQueue tg() {
        if (dt == null && Looper.getMainLooper() != null) {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == Looper.myLooper()) {
                dt = Looper.myQueue();
            } else {
                dt = mainLooper.getQueue();
            }
        }
        return dt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long y() {
        return com.bytedance.e.e.ga.d.e(f);
    }

    public static List<e> d() {
        if (vn == null) {
            return null;
        }
        l = true;
        ArrayList arrayList = new ArrayList();
        if (vn.size() == ga) {
            for (int i = k; i < vn.size(); i++) {
                arrayList.add(vn.get(i));
            }
            for (int i2 = 0; i2 < k; i2++) {
                arrayList.add(vn.get(i2));
            }
        } else {
            arrayList.addAll(vn);
        }
        l = false;
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bf(e eVar, long j, long j2, long j3, int i, int i2, String str) {
        eVar.ga = j;
        eVar.d = j3;
        eVar.tg = j2;
        eVar.vn = false;
        eVar.e = i2;
        if (str != null) {
            eVar.p = str;
        }
        eVar.bf = i;
    }

    public static void e(int i, int i2) {
        if (tg) {
            if (i > 10) {
                ga = i;
            }
            if (i2 > 10) {
                v = i2;
            }
            vn = new ArrayList();
            e();
            e(tg());
        }
    }

    public static JSONArray bf() {
        JSONArray jSONArray = new JSONArray();
        List<e> listD = d();
        if (listD == null) {
            return jSONArray;
        }
        int i = 0;
        for (e eVar : listD) {
            if (eVar != null) {
                i++;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("msg", eVar.p);
                    jSONObject.put("cpuDuration", eVar.ga);
                    jSONObject.put("duration", eVar.tg);
                    jSONObject.put("tick", eVar.d);
                    jSONObject.put("type", eVar.bf);
                    jSONObject.put("count", eVar.e);
                    jSONObject.put("id", i);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    public static void e() {
        com.bytedance.e.e.ga.p.e(4L);
        com.bytedance.e.e.ga.vn.e().bf();
        com.bytedance.e.e.ga.vn.e().bf(new Printer() { // from class: com.bytedance.e.e.e.p.1
            /* JADX WARN: Removed duplicated region for block: B:33:0x0079  */
            @Override // android.util.Printer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void println(java.lang.String r17) {
                /*
                    r16 = this;
                    boolean r0 = com.bytedance.e.e.e.p.vn()
                    if (r0 != 0) goto L7
                    return
                L7:
                    com.bytedance.e.e.e.p.e(r17)
                    boolean r0 = com.bytedance.e.e.e.p.p()
                    r1 = 1
                    if (r0 != 0) goto L1e
                    com.bytedance.e.e.e.p.e(r1)
                    int r0 = android.os.Process.myTid()
                    com.bytedance.e.e.e.p.e(r0)
                    com.bytedance.e.e.e.p.v()
                L1e:
                    java.util.concurrent.atomic.AtomicLong r0 = com.bytedance.e.e.e.p.zk()
                    long r2 = r0.get()
                    com.bytedance.e.e.e.p.e = r2
                    long r2 = com.bytedance.e.e.e.p.bf
                    r4 = -1
                    int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r0 != 0) goto L31
                    return
                L31:
                    long r2 = com.bytedance.e.e.e.p.e
                    long r4 = com.bytedance.e.e.e.p.bf
                    long r11 = r2 - r4
                    r2 = 0
                    int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                    if (r0 > 0) goto L41
                    com.bytedance.e.e.e.p.m()
                    goto L9a
                L41:
                    r2 = 1
                    int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                    if (r0 != 0) goto L59
                    int r0 = com.bytedance.e.e.e.p.wu()
                    if (r0 <= r1) goto L4f
                    r0 = 7
                    goto L60
                L4f:
                    int r0 = com.bytedance.e.e.e.p.wu()
                    if (r0 != r1) goto L57
                    r0 = 3
                    goto L60
                L57:
                    r0 = 0
                    goto L60
                L59:
                    int r0 = com.bytedance.e.e.e.p.wu()
                    if (r0 <= r1) goto L62
                    r0 = 5
                L60:
                    r13 = r0
                    goto L6b
                L62:
                    int r0 = com.bytedance.e.e.e.p.wu()
                    if (r0 != r1) goto L6a
                    r0 = 6
                    goto L60
                L6a:
                    r13 = r1
                L6b:
                    long r2 = com.bytedance.e.e.e.p.xu()
                    long r4 = android.os.SystemClock.uptimeMillis()
                    boolean r0 = com.bytedance.e.e.e.p.bh()
                    if (r0 != 0) goto L91
                    com.bytedance.e.e.e.p$e r6 = com.bytedance.e.e.e.p.t()
                    long r7 = com.bytedance.e.e.e.p.s()
                    long r7 = r2 - r7
                    long r9 = com.bytedance.e.e.e.p.w()
                    long r9 = r4 - r9
                    int r14 = com.bytedance.e.e.e.p.wu()
                    r15 = 0
                    com.bytedance.e.e.e.p.e(r6, r7, r9, r11, r13, r14, r15)
                L91:
                    com.bytedance.e.e.e.p.bf(r2)
                    com.bytedance.e.e.e.p.d(r4)
                    com.bytedance.e.e.e.p.bf(r1)
                L9a:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.e.e.e.p.AnonymousClass1.println(java.lang.String):void");
            }
        });
        com.bytedance.e.e.ga.vn.e().e(new Printer() { // from class: com.bytedance.e.e.e.p.2
            /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
            @Override // android.util.Printer
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void println(java.lang.String r17) {
                /*
                    r16 = this;
                    java.util.concurrent.atomic.AtomicLong r0 = com.bytedance.e.e.e.p.zk()
                    long r0 = r0.get()
                    com.bytedance.e.e.e.p.bf = r0
                    long r0 = com.bytedance.e.e.e.p.e
                    r2 = 0
                    int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r0 > 0) goto L13
                    return
                L13:
                    long r0 = com.bytedance.e.e.e.p.bf
                    long r4 = com.bytedance.e.e.e.p.e
                    long r11 = r0 - r4
                    int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                    if (r0 > 0) goto L1e
                    return
                L1e:
                    long r0 = com.bytedance.e.e.e.p.xu()
                    long r2 = android.os.SystemClock.uptimeMillis()
                    r4 = 1
                    int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                    r5 = 0
                    r6 = 1
                    if (r4 != 0) goto L38
                    int r7 = com.bytedance.e.e.e.p.wu()
                    if (r7 <= r6) goto L38
                    r4 = 9
                L36:
                    r13 = r4
                    goto L58
                L38:
                    if (r4 != 0) goto L42
                    int r7 = com.bytedance.e.e.e.p.wu()
                    if (r7 != r6) goto L42
                    r4 = 2
                    goto L36
                L42:
                    if (r4 <= 0) goto L4c
                    int r7 = com.bytedance.e.e.e.p.wu()
                    if (r7 <= r6) goto L4c
                    r4 = 4
                    goto L36
                L4c:
                    if (r4 <= 0) goto L57
                    int r4 = com.bytedance.e.e.e.p.wu()
                    if (r4 != r6) goto L57
                    r4 = 8
                    goto L36
                L57:
                    r13 = r5
                L58:
                    boolean r4 = com.bytedance.e.e.e.p.bh()
                    if (r4 != 0) goto L77
                    com.bytedance.e.e.e.p$e r6 = com.bytedance.e.e.e.p.t()
                    long r7 = com.bytedance.e.e.e.p.s()
                    long r7 = r0 - r7
                    long r9 = com.bytedance.e.e.e.p.w()
                    long r9 = r2 - r9
                    int r14 = com.bytedance.e.e.e.p.wu()
                    r15 = r17
                    com.bytedance.e.e.e.p.e(r6, r7, r9, r11, r13, r14, r15)
                L77:
                    com.bytedance.e.e.e.p.bf(r0)
                    com.bytedance.e.e.e.p.d(r2)
                    com.bytedance.e.e.e.p.bf(r5)
                    r0 = -1
                    com.bytedance.e.e.e.p.e = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.e.e.e.p.AnonymousClass2.println(java.lang.String):void");
            }
        });
        wu = y();
        xu = SystemClock.uptimeMillis();
    }

    private static Message e(MessageQueue messageQueue) {
        Field field = pe;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
                pe = declaredField;
                declaredField.setAccessible(true);
                return (Message) pe.get(messageQueue);
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(messageQueue);
        } catch (Exception unused2) {
            return null;
        }
    }

    public static JSONArray e(int i, long j) {
        MessageQueue messageQueueTg = tg();
        JSONArray jSONArray = new JSONArray();
        if (messageQueueTg == null) {
            return jSONArray;
        }
        synchronized (messageQueueTg) {
            Message messageE = e(messageQueueTg);
            if (messageE == null) {
                return jSONArray;
            }
            int i2 = 0;
            int i3 = 0;
            while (messageE != null && i2 < i) {
                i2++;
                i3++;
                JSONObject jSONObjectE = e(messageE, j);
                try {
                    jSONObjectE.put("id", i3);
                } catch (JSONException unused) {
                }
                jSONArray.put(jSONObjectE);
                messageE = e(messageE);
            }
            return jSONArray;
        }
    }

    public static JSONObject e(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", w);
            jSONObject.put("currentMessageCost", ga());
            jSONObject.put("currentMessageCpu", y() - wu);
            jSONObject.put("currentTick", p.get());
        } catch (Throwable th) {
            m.e(th);
        }
        return jSONObject;
    }

    private static JSONObject e(Message message, long j) {
        JSONObject jSONObject = new JSONObject();
        if (message == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("when", message.getWhen() - j);
            if (message.getCallback() != null) {
                jSONObject.put("callback", message.getCallback());
            }
            jSONObject.put("what", message.what);
            if (message.getTarget() != null) {
                jSONObject.put(TypedValues.AttributesType.S_TARGET, message.getTarget());
            } else {
                jSONObject.put("barrier", message.arg1);
            }
            jSONObject.put("arg1", message.arg1);
            jSONObject.put("arg2", message.arg2);
            Object obj = message.obj;
            if (obj != null) {
                jSONObject.put("obj", obj);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private static Message e(Message message) {
        Field field = y;
        if (field == null) {
            try {
                Field declaredField = Class.forName("android.os.Message").getDeclaredField("next");
                y = declaredField;
                declaredField.setAccessible(true);
                Message message2 = (Message) y.get(message);
                if (d) {
                    Log.i("LooperMonitor", "[getNextMessage] success get next msg :" + message2);
                }
                return message2;
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return (Message) field.get(message);
        } catch (Exception unused2) {
            return null;
        }
    }
}
