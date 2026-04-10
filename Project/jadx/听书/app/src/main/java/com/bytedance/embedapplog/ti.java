package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class ti implements Handler.Callback, Comparator<sd> {
    private static ti g;
    private static long i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bv f303a;
    private lq dl;
    private gb e;
    private na fo;
    private final ArrayList<sd> gc = new ArrayList<>(32);
    private Handler gz;
    private Handler kb;
    private tf m;
    private com.bytedance.embedapplog.util.z uy;
    private wj wp;
    public Application z;

    public static void z() {
        if (g != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - i) > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                i = jCurrentTimeMillis;
                g.z((String[]) null, true);
            }
        }
    }

    private ti() {
    }

    public Context g() {
        return this.z;
    }

    public tf dl() {
        return this.m;
    }

    public bv a() {
        return this.f303a;
    }

    public gb gc() {
        return this.e;
    }

    public static ti m() {
        if (g == null) {
            synchronized (ti.class) {
                if (g == null) {
                    g = new ti();
                }
            }
        }
        return g;
    }

    public na e() {
        return this.fo;
    }

    public com.bytedance.embedapplog.util.z gz() {
        if (this.uy == null) {
            com.bytedance.embedapplog.util.z zVarKb = this.f303a.vm().kb();
            this.uy = zVarKb;
            if (zVarKb == null) {
                this.uy = com.bytedance.embedapplog.util.g.z(0);
            }
        }
        return this.uy;
    }

    public void z(Application application, bv bvVar, gb gbVar, fv fvVar) {
        this.z = application;
        this.m = new tf(this);
        this.f303a = bvVar;
        this.e = gbVar;
        this.fo = new na(this.e, this.f303a);
        this.z.registerActivityLifecycleCallbacks(fvVar);
        Looper looperZ = o.z(bvVar);
        if (looperZ == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperZ = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperZ, this);
        this.kb = handler;
        handler.sendEmptyMessage(1);
        wo.z(bvVar.fo() != 0);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i2 = message.what;
            if (i2 == 1) {
                cb.z = this.f303a.zw();
                if (this.e.m()) {
                    if (this.f303a.fv()) {
                        Looper looperG = o.g(this.f303a);
                        if (looperG == null) {
                            HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                            handlerThread.start();
                            looperG = handlerThread.getLooper();
                        }
                        Handler handler = new Handler(looperG, this);
                        this.gz = handler;
                        handler.sendEmptyMessage(2);
                        if (this.gc.size() > 0) {
                            this.kb.removeMessages(4);
                            this.kb.sendEmptyMessageDelayed(4, 1000L);
                        }
                        cb.a("net|worker start", null);
                    }
                } else {
                    this.kb.removeMessages(1);
                    this.kb.sendEmptyMessageDelayed(1, 1000L);
                }
                j.z();
            } else if (i2 == 2) {
                ArrayList<mc> arrayList = new ArrayList(4);
                arrayList.add(new oq(this));
                arrayList.add(new un(this));
                wj wjVar = new wj(this);
                this.wp = wjVar;
                arrayList.add(wjVar);
                for (mc mcVar : arrayList) {
                    if (mcVar instanceof wj) {
                        this.wp.z(o.z());
                    }
                    long jE = mcVar.e();
                    if (jE < 864000000) {
                        this.gz.sendMessageDelayed(this.kb.obtainMessage(6, mcVar), jE);
                    }
                }
                this.wp.z(true);
                uy();
            } else if (i2 == 4) {
                z((String[]) null, false);
            } else if (i2 == 5) {
                z((String[]) message.obj, false);
            } else if (i2 == 6) {
                mc mcVar2 = (mc) message.obj;
                if (!mcVar2.m()) {
                    long jE2 = mcVar2.e();
                    if (jE2 < 864000000) {
                        this.gz.sendMessageDelayed(this.kb.obtainMessage(6, mcVar2), jE2);
                    }
                    uy();
                }
                this.wp.z(true);
            } else if (i2 == 7) {
                synchronized (this.gc) {
                    this.gc.add(na.gc());
                }
                z((String[]) null, false);
            } else if (i2 == 89) {
                gb gbVar = this.e;
                if (gbVar != null) {
                    gbVar.gc();
                }
            } else {
                cb.g((Throwable) null);
            }
        } catch (Throwable th) {
            cb.z("engine:" + th.getMessage());
        }
        return true;
    }

    private void uy() {
        if (this.f303a.iq()) {
            if (this.dl == null) {
                lq lqVar = new lq(this);
                this.dl = lqVar;
                this.gz.obtainMessage(6, lqVar).sendToTarget();
                return;
            }
            return;
        }
        lq lqVar2 = this.dl;
        if (lqVar2 != null) {
            lqVar2.gc();
            this.dl = null;
        }
    }

    private void z(String[] strArr, boolean z) {
        ArrayList<sd> arrayList;
        synchronized (this.gc) {
            arrayList = (ArrayList) this.gc.clone();
            this.gc.clear();
        }
        int i2 = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(sd.z(str));
            }
        }
        boolean z2 = this.f303a.z(arrayList);
        if (arrayList.size() > 0) {
            if (this.f303a.fv()) {
                if (z2 || arrayList.size() > 100) {
                    Collections.sort(arrayList, this);
                    ArrayList<sd> arrayList2 = new ArrayList<>(arrayList.size());
                    boolean z3 = false;
                    boolean z4 = false;
                    for (sd sdVar : arrayList) {
                        z3 |= this.fo.z(sdVar, arrayList2);
                        if (sdVar instanceof lk) {
                            z4 = na.z(sdVar);
                            i2 = 1;
                        }
                    }
                    this.m.z(arrayList2);
                    if (i2 != 0) {
                        if (z4) {
                            this.kb.removeMessages(7);
                        } else if (!o.g() && o.z()) {
                            this.kb.sendEmptyMessageDelayed(7, this.f303a.io());
                        }
                    }
                    if (z3 || z) {
                        kb();
                        return;
                    }
                    return;
                }
                synchronized (this.gc) {
                    this.gc.addAll(arrayList);
                }
                return;
            }
            Intent intent = new Intent(this.z, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i2 < size) {
                String string = arrayList.get(i2).gc().toString();
                strArr2[i2] = string;
                length += string.length();
                i2++;
            }
            if (length >= 307200) {
                cb.g((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.z.sendBroadcast(intent);
            } catch (Exception e) {
                cb.g(e);
            }
        }
    }

    private void kb() {
        if (cb.g) {
            cb.z("packAndSend once, " + this.fo.z() + ", hadUI:" + this.fo.g(), null);
        }
        wj wjVar = this.wp;
        if (wjVar != null) {
            wjVar.gz();
        }
        if (this.gz != null) {
            this.wp.z(o.z());
            this.gz.sendMessage(this.kb.obtainMessage(6, this.wp));
        }
    }

    public static void z(sd sdVar) {
        int size;
        Handler handler;
        ti tiVar = g;
        if (tiVar == null) {
            cb.g("Init comes First!", null);
            j.z(sdVar);
            return;
        }
        if (sdVar.g == 0) {
            cb.g((Throwable) null);
        }
        synchronized (tiVar.gc) {
            size = tiVar.gc.size();
            tiVar.gc.add(sdVar);
        }
        if (size % 10 != 0 || (handler = tiVar.kb) == null) {
            return;
        }
        handler.removeMessages(4);
        tiVar.kb.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void z(String[] strArr) {
        ti tiVar = g;
        if (tiVar == null) {
            cb.g(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = tiVar.kb;
        if (handler != null) {
            handler.removeMessages(4);
            tiVar.kb.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compare(sd sdVar, sd sdVar2) {
        long j = sdVar.g - sdVar2.g;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }

    public void fo() {
        Handler handler = this.kb;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.kb.sendEmptyMessage(89);
    }
}
