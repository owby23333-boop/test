package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.aj;
import com.yuewen.xa3;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class eg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile eg f7908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f271a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentLinkedQueue<b> f272a;

    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.eg.b, com.xiaomi.push.aj.b
        public void b() {
            eg.this.b();
        }
    }

    public class b extends aj.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f7910a = System.currentTimeMillis();

        public b() {
        }

        public boolean a() {
            return true;
        }

        @Override // com.xiaomi.push.aj.b
        public void b() {
        }

        /* JADX INFO: renamed from: b, reason: collision with other method in class */
        public final boolean m322b() {
            return System.currentTimeMillis() - this.f7910a > 172800000;
        }
    }

    private eg(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f272a = concurrentLinkedQueue;
        this.f271a = context;
        concurrentLinkedQueue.add(new a());
        b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            File file = new File(this.f271a.getFilesDir() + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    private void c() {
        while (!this.f272a.isEmpty()) {
            b bVarPeek = this.f272a.peek();
            if (bVarPeek != null) {
                if (!bVarPeek.m322b() && this.f272a.size() <= 6) {
                    return;
                }
                com.xiaomi.channel.commonutils.logger.b.c("remove Expired task");
                this.f272a.remove(bVarPeek);
            }
        }
    }

    public static eg a(Context context) {
        if (f7908a == null) {
            synchronized (eg.class) {
                if (f7908a == null) {
                    f7908a = new eg(context);
                }
            }
        }
        f7908a.f271a = context;
        return f7908a;
    }

    private void b(long j) {
        if (this.f272a.isEmpty()) {
            return;
        }
        hs.a(new ei(this), j);
    }

    public class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f7912a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        File f274a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        String f275a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7913b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        boolean f277b;

        public c(String str, String str2, File file, boolean z) {
            super();
            this.f275a = str;
            this.f7913b = str2;
            this.f274a = file;
            this.f277b = z;
        }

        private boolean c() {
            int i;
            int i2 = 0;
            SharedPreferences sharedPreferences = eg.this.f271a.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                jCurrentTimeMillis = jSONObject.getLong(com.yuewen.et.j);
                i = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i = 0;
            }
            if (System.currentTimeMillis() - jCurrentTimeMillis >= 86400000) {
                jCurrentTimeMillis = System.currentTimeMillis();
            } else {
                if (i > 10) {
                    return false;
                }
                i2 = i;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(com.yuewen.et.j, jCurrentTimeMillis);
                jSONObject2.put("times", i2 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e) {
                com.xiaomi.channel.commonutils.logger.b.c("JSONException on put " + e.getMessage());
            }
            return true;
        }

        @Override // com.xiaomi.push.eg.b
        public boolean a() {
            return bf.e(eg.this.f271a) || (this.f277b && bf.b(eg.this.f271a));
        }

        @Override // com.xiaomi.push.eg.b, com.xiaomi.push.aj.b
        public void b() {
            try {
                if (c()) {
                    HashMap map = new HashMap();
                    map.put("uid", com.xiaomi.push.service.bw.m776a());
                    map.put("token", this.f7913b);
                    map.put("net", bf.m219a(eg.this.f271a));
                    bf.a(this.f275a, map, this.f274a, xa3.f19839a);
                }
                this.f276a = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.aj.b
        /* JADX INFO: renamed from: c, reason: collision with other method in class */
        public void mo323c() {
            if (!this.f276a) {
                int i = this.f7912a + 1;
                this.f7912a = i;
                if (i < 3) {
                    eg.this.f272a.add(this);
                }
            }
            if (this.f276a || this.f7912a >= 3) {
                this.f274a.delete();
            }
            eg.this.a((1 << this.f7912a) * 1000);
        }
    }

    public void a(String str, String str2, Date date, Date date2, int i, boolean z) {
        this.f272a.add(new eh(this, i, date, date2, str, str2, z));
        b(0L);
    }

    public void a() {
        c();
        a(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        b bVarPeek = this.f272a.peek();
        if (bVarPeek == null || !bVarPeek.a()) {
            return;
        }
        b(j);
    }
}
