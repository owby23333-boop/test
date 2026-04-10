package com.bytedance.sdk.component.uy.z;

import com.bytedance.sdk.component.uy.kb;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements Comparable<dl>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private m f808a;
    public final Runnable dl;
    private long gz;
    public static final AtomicInteger z = new AtomicInteger(0);
    public static boolean g = false;
    private boolean gc = true;
    private boolean m = true;
    private final long e = System.currentTimeMillis();
    private int fo = 0;
    private int uy = 0;

    public dl(Runnable runnable) {
        this.dl = runnable;
    }

    public dl(Runnable runnable, m mVar) {
        this.dl = runnable;
        this.f808a = mVar;
    }

    public void z(m mVar) {
        this.f808a = mVar;
    }

    Runnable z() {
        return this.dl;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:0|2|(12:4|42|5|6|11|(1:13)(1:14)|15|(1:19)|40|20|24|(1:26)(2:27|(2:31|(2:33|34)(3:(1:36)(1:37)|38|39))(1:44)))(1:9)|10|11|(0)(0)|15|(2:17|19)|40|20|24|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0082, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        com.bytedance.sdk.component.utils.wp.g("BizRunnable", r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.uy.z.dl.run():void");
    }

    public void g() {
        this.gz = System.currentTimeMillis() - this.e;
    }

    private boolean z(long j) {
        return this.uy == 1 ? j > kb.g.p() : j > kb.g.fv();
    }

    private void z(long j, long j2, String str, int i, int i2, int i3, com.bytedance.sdk.component.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.e);
            jSONObject.put("is_wrap", this.dl instanceof dl);
            jSONObject.put("is_oom", g);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.gz);
            jSONObject.put("pool_type", this.fo);
            jSONObject.put("origin_pool_type", this.uy);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put("thread_name", Thread.currentThread().getName());
            kb kbVar = kb.g;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", kbVar.v());
            jSONObject.put("auto_size", com.bytedance.sdk.component.uy.e.gc());
            jSONObject.put("pri_task_in_little", z.get());
            jSONObject.put("core_count", kbVar.gz());
            jSONObject.put("max_pool_size", kbVar.kb());
            jSONObject.put("use_little_pool", kbVar.ls());
        } catch (Exception unused) {
        }
        eVar.onStatsEvent("task_run_cost", jSONObject);
    }

    private void dl(boolean z2) {
        m mVar = this.f808a;
        if (mVar != null) {
            mVar.z(this, z2);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(dl dlVar) {
        Class<?> cls = this.dl.getClass();
        Class<?> cls2 = dlVar.dl.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.dl;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = dlVar.dl;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }

    public void z(boolean z2) {
        this.gc = z2;
    }

    public boolean dl() {
        return this.m;
    }

    public void g(boolean z2) {
        this.m = z2;
    }

    public void z(int i) {
        int i2 = this.fo;
        if (i2 == 0) {
            this.uy = i;
        } else {
            this.uy = i2;
        }
        this.fo = i;
    }

    public int a() {
        return this.fo;
    }
}
