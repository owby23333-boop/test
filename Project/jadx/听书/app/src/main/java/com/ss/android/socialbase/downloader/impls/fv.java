package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.media3.exoplayer.ExoPlayer;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.socialbase.downloader.downloader.js;
import com.ss.android.socialbase.downloader.z.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class fv implements Handler.Callback, z.InterfaceC0484z {
    private static g fo;
    private static volatile fv z;
    private final boolean gc;
    private ConnectivityManager gz;
    private long m;
    private final Handler dl = new Handler(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<z> f2091a = new SparseArray<>();
    private int e = 0;
    private final Context g = com.ss.android.socialbase.downloader.downloader.dl.xl();

    public interface g {
        void z(com.ss.android.socialbase.downloader.e.dl dlVar, long j, boolean z, int i);
    }

    private fv() {
        m();
        this.gc = com.ss.android.socialbase.downloader.pf.m.dl();
        com.ss.android.socialbase.downloader.z.z.z().z(this);
    }

    public static fv z() {
        if (z == null) {
            synchronized (fv.class) {
                if (z == null) {
                    z = new fv();
                }
            }
        }
        return z;
    }

    public static void z(g gVar) {
        fo = gVar;
    }

    private void m() {
        if (com.ss.android.socialbase.downloader.i.z.dl().z("use_network_callback", 0) != 1) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.fv.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (fv.this.g != null) {
                        fv fvVar = fv.this;
                        fvVar.gz = (ConnectivityManager) fvVar.g.getApplicationContext().getSystemService("connectivity");
                        fv.this.gz.registerNetworkCallback(new NetworkRequest.Builder().build(), new ConnectivityManager.NetworkCallback() { // from class: com.ss.android.socialbase.downloader.impls.fv.1.1
                            @Override // android.net.ConnectivityManager.NetworkCallback
                            public void onAvailable(Network network) {
                                com.ss.android.socialbase.downloader.m.z.g("RetryScheduler", "network onAvailable: ");
                                fv.this.z(1, true);
                            }
                        });
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    public void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (dlVar == null || TextUtils.isEmpty(com.ss.android.socialbase.downloader.g.gc.z) || !com.ss.android.socialbase.downloader.g.gc.z.equals(dlVar.yt())) {
            return;
        }
        z(dlVar, dlVar.io() || dlVar.jq(), e());
    }

    private void z(com.ss.android.socialbase.downloader.e.dl dlVar, boolean z2, int i) {
        com.ss.android.socialbase.downloader.gc.z zVarGd = dlVar.gd();
        if (zVarGd == null) {
            return;
        }
        z zVarG = g(dlVar.e());
        if (zVarG.fo > zVarG.dl) {
            com.ss.android.socialbase.downloader.m.z.a("RetryScheduler", "tryStartScheduleRetry, id = " + zVarG.z + ", mRetryCount = " + zVarG.fo + ", maxCount = " + zVarG.dl);
            return;
        }
        int iZ = zVarGd.z();
        if (!com.ss.android.socialbase.downloader.pf.m.gz(zVarGd) && !com.ss.android.socialbase.downloader.pf.m.fo(zVarGd) && (!dlVar.f() || !dlVar.jq())) {
            if (!z(zVarG, iZ)) {
                return;
            } else {
                com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "allow error code, id = " + zVarG.z + ", error code = " + iZ);
            }
        }
        zVarG.uy = z2;
        synchronized (this.f2091a) {
            if (!zVarG.wp) {
                zVarG.wp = true;
                this.e++;
            }
        }
        int iA = zVarG.a();
        com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "tryStartScheduleRetry: id = " + zVarG.z + ", delayTimeMills = " + iA + ", mWaitingRetryTasks = " + this.e);
        if (!zVarG.m) {
            if (z2) {
                return;
            }
            this.dl.removeMessages(dlVar.e());
            this.dl.sendEmptyMessageDelayed(dlVar.e(), iA);
            return;
        }
        if (i == 0) {
            zVarG.dl();
        }
        g gVar = fo;
        if (gVar != null) {
            gVar.z(dlVar, iA, z2, i);
        }
        if (this.gc) {
            zVarG.z(System.currentTimeMillis());
            zVarG.g();
            zVarG.z();
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            g(message.arg1, message.arg2 == 1);
        } else {
            com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "handleMessage, doSchedulerRetry, id = " + message.what);
            z(message.what);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, boolean z2) {
        if (this.e <= 0) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            if (!z2) {
                if (jCurrentTimeMillis - this.m < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    return;
                }
            }
            this.m = jCurrentTimeMillis;
            com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "scheduleAllTaskRetry, level = [" + i + "], force = [" + z2 + "]");
            if (z2) {
                this.dl.removeMessages(0);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 0;
            messageObtain.arg1 = i;
            messageObtain.arg2 = z2 ? 1 : 0;
            this.dl.sendMessageDelayed(messageObtain, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    private void g(final int i, final boolean z2) {
        com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.fv.2
            @Override // java.lang.Runnable
            public void run() {
                int iE;
                try {
                    if (fv.this.e > 0 && (iE = fv.this.e()) != 0) {
                        com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "doScheduleAllTaskRetry: mWaitingRetryTasksCount = " + fv.this.e);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        synchronized (fv.this.f2091a) {
                            for (int i2 = 0; i2 < fv.this.f2091a.size(); i2++) {
                                z zVar = (z) fv.this.f2091a.valueAt(i2);
                                if (zVar != null && zVar.z(jCurrentTimeMillis, i, iE, z2)) {
                                    if (z2) {
                                        zVar.dl();
                                    }
                                    arrayList.add(zVar);
                                }
                            }
                        }
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                fv.this.z(((z) it.next()).z, iE, false);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public void z(final int i) {
        com.ss.android.socialbase.downloader.downloader.dl.kb().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.fv.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fv fvVar = fv.this;
                    fvVar.z(i, fvVar.e(), true);
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, boolean z2) {
        js jsVarG;
        boolean z3;
        Context context = this.g;
        if (context == null) {
            return;
        }
        synchronized (this.f2091a) {
            z zVar = this.f2091a.get(i);
            if (zVar == null) {
                return;
            }
            boolean z4 = true;
            if (zVar.wp) {
                zVar.wp = false;
                int i3 = this.e - 1;
                this.e = i3;
                if (i3 < 0) {
                    this.e = 0;
                }
            }
            com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "doSchedulerRetryInSubThread: downloadId = " + i + ", retryCount = " + zVar.fo + ", mWaitingRetryTasksCount = " + this.e);
            com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(context).gz(i);
            if (dlVarGz == null) {
                dl(i);
                return;
            }
            com.ss.android.socialbase.downloader.m.z.gc("RetryScheduler", "doSchedulerRetryInSubThread，id:".concat(String.valueOf(i)));
            int iZw = dlVarGz.zw();
            if (iZw == -3 || iZw == -4) {
                dl(i);
                return;
            }
            if (iZw == -5 || (iZw == -2 && dlVarGz.jq())) {
                if (iZw == -2 && (jsVarG = com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).g()) != null) {
                    jsVarG.z(dlVarGz, 4, 3);
                }
                com.ss.android.socialbase.downloader.downloader.v vVarZw = com.ss.android.socialbase.downloader.downloader.dl.zw();
                if (vVarZw != null) {
                    vVarZw.z(Collections.singletonList(dlVarGz), 3);
                }
                dl(i);
                return;
            }
            if (iZw != -1) {
                return;
            }
            if (i2 != 0) {
                z3 = true;
            } else if (!zVar.m) {
                return;
            } else {
                z3 = false;
            }
            com.ss.android.socialbase.downloader.gc.z zVarGd = dlVarGz.gd();
            if (z3 && com.ss.android.socialbase.downloader.pf.m.gz(zVarGd)) {
                z3 = z(dlVarGz, zVarGd);
            }
            zVar.g();
            if (z3) {
                com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "doSchedulerRetry: restart task, ****** id = " + zVar.z);
                zVar.z(System.currentTimeMillis());
                if (z2) {
                    zVar.z();
                }
                dlVarGz.g(zVar.fo);
                if (dlVarGz.p() == -1) {
                    com.ss.android.socialbase.downloader.downloader.e.g(context).gc(dlVarGz.e());
                    return;
                }
                return;
            }
            if (z2) {
                zVar.z();
            }
            if (!dlVarGz.io() && !dlVarGz.jq()) {
                z4 = false;
            }
            z(dlVarGz, z4, i2);
        }
    }

    private boolean z(z zVar, int i) {
        int[] iArr = zVar.e;
        if (iArr != null && iArr.length != 0) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
        }
        return false;
    }

    private z g(int i) {
        z zVarA = this.f2091a.get(i);
        if (zVarA == null) {
            synchronized (this.f2091a) {
                zVarA = this.f2091a.get(i);
                if (zVarA == null) {
                    zVarA = a(i);
                }
                this.f2091a.put(i, zVarA);
            }
        }
        return zVarA;
    }

    private void dl(int i) {
        synchronized (this.f2091a) {
            this.f2091a.remove(i);
        }
    }

    private z a(int i) {
        int[] iArrZ;
        int i2;
        int i3;
        boolean z2;
        com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(i);
        boolean z3 = false;
        int iZ = zVarZ.z("retry_schedule", 0);
        JSONObject jSONObjectA = zVarZ.a("retry_schedule_config");
        int i4 = 60;
        if (jSONObjectA != null) {
            int iOptInt = jSONObjectA.optInt("max_count", 60);
            int iOptInt2 = jSONObjectA.optInt("interval_sec", 60);
            int iOptInt3 = jSONObjectA.optInt("interval_sec_acceleration", 60);
            if (fo != null && jSONObjectA.optInt("use_job_scheduler", 0) == 1) {
                z3 = true;
            }
            iArrZ = z(jSONObjectA.optString("allow_error_code"));
            i2 = iOptInt3;
            z2 = z3;
            i3 = iOptInt;
            i4 = iOptInt2;
        } else {
            iArrZ = null;
            i2 = 60;
            i3 = 60;
            z2 = false;
        }
        return new z(i, iZ, i3, i4 * 1000, i2 * 1000, z2, iArrZ);
    }

    private int[] z(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length <= 0) {
                return null;
            }
            int[] iArr = new int[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            }
            return iArr;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
    public void g() {
        z(4, false);
    }

    @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
    public void dl() {
        z(3, false);
    }

    public void a() {
        z(2, true);
    }

    public void gc() {
        z(5, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int e() {
        try {
            if (this.gz == null) {
                this.gz = (ConnectivityManager) this.g.getApplicationContext().getSystemService("connectivity");
            }
            NetworkInfo activeNetworkInfo = this.gz.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo.getType() == 1 ? 2 : 1;
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    private boolean z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.downloader.gc.z zVar) {
        long jA;
        long jS;
        try {
            jA = com.ss.android.socialbase.downloader.pf.m.a(dlVar.wp());
        } catch (com.ss.android.socialbase.downloader.gc.z e) {
            com.bytedance.sdk.component.utils.wp.z(e);
            jA = 0;
        }
        if (zVar instanceof com.ss.android.socialbase.downloader.gc.gc) {
            jS = ((com.ss.android.socialbase.downloader.gc.gc) zVar).gc();
        } else {
            jS = dlVar.s() - dlVar.sf();
        }
        if (jA < jS) {
            com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
            if (zVarZ.z("space_fill_part_download", 0) == 1) {
                if (jA > 0) {
                    int iZ = zVarZ.z("space_fill_min_keep_mb", 100);
                    if (iZ > 0) {
                        long j = jA - (((long) iZ) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
                        com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "retry schedule: available = " + com.ss.android.socialbase.downloader.pf.m.z(jA) + "MB, minKeep = " + iZ + "MB, canDownload = " + com.ss.android.socialbase.downloader.pf.m.z(j) + "MB");
                        if (j <= 0) {
                            com.ss.android.socialbase.downloader.m.z.a("RetryScheduler", "doSchedulerRetryInSubThread: canDownload <= 0 , canRetry = false !!!!");
                            return false;
                        }
                    }
                } else if (zVarZ.z("download_when_space_negative", 0) != 1) {
                }
            }
            return false;
        }
        return true;
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f2092a;
        final int dl;
        final int[] e;
        private int fo;
        final int g;
        final int gc;
        private int gz;
        private long kb;
        final boolean m;
        private boolean uy;
        private boolean wp;
        final int z;

        z(int i, int i2, int i3, int i4, int i5, boolean z, int[] iArr) {
            i4 = i4 < 3000 ? 3000 : i4;
            i5 = i5 < 5000 ? 5000 : i5;
            this.z = i;
            this.g = i2;
            this.dl = i3;
            this.f2092a = i4;
            this.gc = i5;
            this.m = z;
            this.e = iArr;
            this.gz = i4;
        }

        boolean z(long j, int i, int i2, boolean z) {
            if (!this.wp) {
                com.ss.android.socialbase.downloader.m.z.dl("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            }
            if (this.g < i || this.fo >= this.dl) {
                return false;
            }
            if (!this.uy || i2 == 2) {
                return z || j - this.kb >= ((long) this.f2092a);
            }
            return false;
        }

        synchronized void z() {
            this.gz += this.gc;
        }

        synchronized void z(long j) {
            this.kb = j;
        }

        synchronized void g() {
            this.fo++;
        }

        void dl() {
            this.gz = this.f2092a;
        }

        int a() {
            return this.gz;
        }
    }
}
