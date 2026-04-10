package com.taobao.accs.data;

import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.ut.monitor.AssembleMonitor;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.cb;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final int SPLITTED_DATA_INDEX = 17;
    public static final int SPLITTED_DATA_MD5 = 18;
    public static final int SPLITTED_DATA_NUMS = 16;
    public static final int SPLITTED_TIME_OUT = 15;
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f18166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f18168e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScheduledFuture<?> f18170g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile int f18169f = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<Integer, byte[]> f18171h = new TreeMap(new b(this));

    public a(String str, int i2, String str2) {
        this.b = str;
        this.f18166c = i2;
        this.f18167d = str2;
    }

    public void a(long j2) {
        if (j2 <= 0) {
            j2 = 30000;
        }
        this.f18170g = ThreadPoolExecutorFactory.getScheduledExecutor().schedule(new c(this), j2, TimeUnit.MILLISECONDS);
    }

    public byte[] a(int i2, int i3, byte[] bArr) {
        long jCurrentTimeMillis;
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("AssembleMessage", "putBurst", Constants.KEY_DATA_ID, this.b, "index", Integer.valueOf(i2));
        }
        if (i3 != this.f18166c) {
            ALog.e("AssembleMessage", "putBurst fail as burstNums not match", new Object[0]);
            return null;
        }
        if (i2 >= 0 && i2 < i3) {
            synchronized (this) {
                if (this.f18169f != 0) {
                    ALog.e("AssembleMessage", "putBurst fail", "status", Integer.valueOf(this.f18169f));
                } else {
                    if (this.f18171h.get(Integer.valueOf(i2)) != null) {
                        ALog.e("AssembleMessage", "putBurst fail as exist old", new Object[0]);
                        return null;
                    }
                    if (this.f18171h.isEmpty()) {
                        this.f18168e = System.currentTimeMillis();
                    }
                    this.f18171h.put(Integer.valueOf(i2), bArr);
                    if (this.f18171h.size() == this.f18166c) {
                        byte[] bArr2 = null;
                        for (byte[] bArr3 : this.f18171h.values()) {
                            if (bArr2 == null) {
                                bArr2 = bArr3;
                            } else {
                                byte[] bArr4 = new byte[bArr2.length + bArr3.length];
                                System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
                                System.arraycopy(bArr3, 0, bArr4, bArr2.length, bArr3.length);
                                bArr2 = bArr4;
                            }
                        }
                        if (!TextUtils.isEmpty(this.f18167d)) {
                            String str = new String(a(org.android.agoo.common.a.a(bArr2)));
                            if (!this.f18167d.equals(str)) {
                                ALog.w("AssembleMessage", "putBurst fail", Constants.KEY_DATA_ID, this.b, "dataMd5", this.f18167d, "finalDataMd5", str);
                                this.f18169f = 3;
                                bArr2 = null;
                            }
                        }
                        long length = 0;
                        if (bArr2 != null) {
                            length = bArr2.length;
                            jCurrentTimeMillis = System.currentTimeMillis() - this.f18168e;
                            this.f18169f = 2;
                            ALog.i("AssembleMessage", "putBurst completed", Constants.KEY_DATA_ID, this.b, "length", Long.valueOf(length), "cost", Long.valueOf(jCurrentTimeMillis));
                        } else {
                            jCurrentTimeMillis = 0;
                        }
                        AssembleMonitor assembleMonitor = new AssembleMonitor(this.b, String.valueOf(this.f18169f));
                        assembleMonitor.assembleLength = length;
                        assembleMonitor.assembleTimes = jCurrentTimeMillis;
                        AppMonitor.getInstance().commitStat(assembleMonitor);
                        this.f18171h.clear();
                        if (this.f18170g != null) {
                            this.f18170g.cancel(false);
                        }
                        return bArr2;
                    }
                }
                return null;
            }
        }
        ALog.e("AssembleMessage", "putBurst fail as burstIndex invalid", new Object[0]);
        return null;
    }

    private static char[] a(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length << 1];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i2 + 1;
            char[] cArr2 = a;
            cArr[i2] = cArr2[(bArr[i3] & 240) >>> 4];
            i2 = i4 + 1;
            cArr[i4] = cArr2[bArr[i3] & cb.f19604m];
        }
        return cArr;
    }
}
