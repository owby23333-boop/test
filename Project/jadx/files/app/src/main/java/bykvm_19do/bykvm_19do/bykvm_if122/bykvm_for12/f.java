package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.k;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.x;
import com.baidu.mobads.sdk.internal.bj;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class f<T extends k> extends HandlerThread implements Handler.Callback {
    public String a;
    public final bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> f1702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<T> f1703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Handler f1707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f1708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b f1709j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1710k;

    public interface a {
        boolean a();
    }

    public static class b {
        final int a;
        final long b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f1711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f1712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f1713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f1714f;

        b(int i2, long j2, long j3, int i3, long j4, long j5) {
            this.a = i2;
            this.b = j2;
            this.f1711c = j3;
            this.f1712d = i3;
            this.f1713e = j4;
            this.f1714f = j5;
        }

        public static b b() {
            Logger.d("TTMediationSDK", "AdEventThread- policy: batchSize: " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().i() + ", routineInterval: " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().n());
            return new b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().i(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().n(), 60000L, 5, bj.f12906d, 300000L);
        }

        public int a() {
            if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m.a) {
                return 1;
            }
            return this.a;
        }
    }

    public f(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> aVar2, b bVar, a aVar3) {
        super("gm_t_adevent_" + str, -4);
        this.a = "AdEventThread-【";
        this.a += str + "】";
        this.f1710k = "V3".equals(str);
        a("tag=" + str);
        this.f1709j = bVar;
        this.f1708i = aVar3;
        this.b = aVar;
        this.f1702c = aVar2;
        this.f1703d = Collections.synchronizedList(new LinkedList());
    }

    private void a() {
        this.b.a(h(), this.f1703d);
        this.f1703d.clear();
    }

    private void a(int i2, long j2) {
        Message messageObtainMessage = this.f1707h.obtainMessage();
        messageObtainMessage.what = i2;
        this.f1707h.sendMessageDelayed(messageObtainMessage, j2);
    }

    private void a(T t2) {
        this.b.a(h(), t2);
        if (this.f1705f) {
            a("如果在容灾状态，直接返回.......mIsServerBusy=" + this.f1705f);
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f1703d.add(t2);
        a(this.f1703d);
        if (j()) {
            a("onHandleReceivedAdEvent upload");
            f();
        }
    }

    private void a(String str) {
        Logger.i(this.a, str);
    }

    private void a(List<T> list) {
        String str;
        int iA = this.f1709j.a();
        if (list == null) {
            return;
        }
        if (list.size() <= iA) {
            str = "start and return, checkAndDeleteEvent local size:" + list.size() + "小于:" + iA;
        } else {
            int size = list.size() - iA;
            a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(list.get(i2));
            }
            list.removeAll(arrayList);
            str = "end checkAndDeleteEvent local size:" + list.size();
        }
        a(str);
    }

    private static boolean a(g gVar) {
        return gVar.f1716d;
    }

    private void b() {
        this.f1705f = false;
        this.b.a(h(), false);
        this.f1706g = 0;
        this.b.a(h(), 0);
        this.f1707h.removeMessages(4);
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    Iterator<T> it = this.f1703d.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().a());
                    }
                    for (T t2 : list) {
                        if (!hashSet.contains(t2.a())) {
                            this.f1703d.add(t2);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private static boolean b(g gVar) {
        return gVar.b == 509;
    }

    private g c(List<T> list) {
        try {
            if (this.f1702c == null) {
                this.f1702c = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.e();
            }
        } catch (Exception unused) {
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> aVar = this.f1702c;
        if (aVar == null) {
            return null;
        }
        return aVar.a(list);
    }

    private void c() {
        a(2, this.f1709j.b);
    }

    private void d() {
        a(4, g());
    }

    private void e() {
        a("普通失败 ，触发重试机制：" + this.f1709j.f1711c + "毫秒后 重试.....");
        a(3, this.f1709j.f1711c);
    }

    private void f() {
        this.f1707h.removeMessages(3);
        this.f1707h.removeMessages(2);
        if (x.a(this.f1703d)) {
            this.f1704e = System.currentTimeMillis();
            c();
            return;
        }
        if (!this.f1708i.a()) {
            a("doRoutineUpload no net, wait retry");
            e();
            return;
        }
        g gVarC = c(this.f1703d);
        if (gVarC != null) {
            if (gVarC.a) {
                a("doRoutineUpload success: " + this.f1703d.size() + " events");
                a();
                o();
                p();
                return;
            }
            if (b(gVarC)) {
                a("doRoutineUpload serverbusy");
                i();
            } else if (a(gVarC)) {
                a("服务端返回data error 抛弃数据 , 清空本次日志，重置上传状态....");
                a();
                o();
            } else {
                if (this.f1705f) {
                    return;
                }
                e();
                a("doRoutineUpload net fail retry");
            }
        }
    }

    private long g() {
        a("服务器繁忙，" + (((this.f1706g % 3) + 1) * this.f1709j.f1714f) + "毫秒后进行重试,当前重试次数：mServerBusyRetryCount=" + this.f1706g + "，mServerBusyRetryBaseInternal=" + this.f1709j.f1714f);
        return ((long) ((this.f1706g % 3) + 1)) * this.f1709j.f1714f;
    }

    private int h() {
        return this.f1710k ? 2 : 1;
    }

    private void i() {
        this.f1705f = true;
        this.b.a(h(), true);
        this.f1703d.clear();
        this.f1707h.removeMessages(3);
        this.f1707h.removeMessages(2);
        d();
    }

    private boolean j() {
        a("mCacheList.size():" + this.f1703d.size() + ",mPolicy.mMaxCacheCount=" + this.f1709j.a() + ",System.currentTimeMillis() - mLastSuccessUploadTime =" + (System.currentTimeMillis() - this.f1704e) + ",mPolicy.mMaxCacheTime=" + this.f1709j.b);
        return !this.f1705f && (this.f1703d.size() >= this.f1709j.a() || System.currentTimeMillis() - this.f1704e >= this.f1709j.b);
    }

    private void k() {
        a("onHandleInitEvent 初始化日志组件.....线程优先级：" + Process.getThreadPriority(0));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar = this.b;
        b bVar = this.f1709j;
        aVar.a(2, bVar.f1712d, bVar.f1713e);
        this.f1705f = this.b.a(h());
        this.f1706g = this.b.b(h());
        if (this.f1705f) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.f1706g);
            d();
            return;
        }
        List<T> listA = this.b.a(h(), this.f1709j.a(), "_id");
        if (Logger.isDebug()) {
            for (T t2 : listA) {
            }
        }
        b(listA);
        a("onHandleInitEvent cacheData count = " + this.f1703d.size());
        f();
    }

    private void l() {
        if (!this.f1705f) {
            a("onHandleRoutineRetryEvent");
            f();
        } else {
            a("如果在容灾状态，直接返回, 安全起见这里判断一下,mIsServerBusy=" + this.f1705f);
        }
    }

    private void m() {
        if (!this.f1705f) {
            a("onHandleRoutineUploadEvent");
            f();
        } else {
            a("如果在容灾状态，直接返回, 安全起见这里判断一下,mIsServerBusy=" + this.f1705f);
        }
    }

    private void n() {
        String str;
        if (this.f1708i.a()) {
            List<T> listA = this.b.a(h(), this.f1709j.a(), "_id");
            a(listA);
            StringBuilder sb = new StringBuilder();
            sb.append("数据库查询出来的size=");
            sb.append(listA != null ? listA.size() : 0);
            a(sb.toString());
            if (x.a(listA)) {
                a("onHandleServerBusyRetryEvent, empty list start routine");
                b();
                c();
                return;
            }
            g gVarC = c(listA);
            if (gVarC == null) {
                return;
            }
            if (gVarC.a) {
                a("onHandleServerBusyRetryEvent, success");
                a();
                o();
                p();
                return;
            }
            if (b(gVarC)) {
                this.f1706g++;
                this.b.a(h(), this.f1706g);
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar = this.b;
                int iH = h();
                b bVar = this.f1709j;
                aVar.a(iH, listA, bVar.f1712d, bVar.f1713e);
                d();
                str = "onHandleServerBusyRetryEvent, serverbusy, count = " + this.f1706g;
            } else {
                if (a(gVarC)) {
                    a("onHandleServerBusyRetryEvent, ---》 data Error直接抛弃数据 ");
                    a();
                    o();
                    return;
                }
                e();
                str = "onHandleServerBusyRetryEvent, net fail";
            }
        } else {
            a(4, this.f1709j.f1711c);
            str = "onHandleServerBusyRetryEvent, no net";
        }
        a(str);
    }

    private void o() {
        this.f1704e = System.currentTimeMillis();
        b();
        c();
    }

    private void p() {
        StringBuilder sb;
        String str;
        int iA = this.f1709j.a() / 2;
        if (iA < 1) {
            iA = 1;
        }
        List<T> listA = this.b.a(h(), iA, "_id");
        if (listA == null || listA.size() <= 0) {
            sb = new StringBuilder();
            str = "数据库日志数量: 0, 小于batchSize/2（";
        } else {
            this.f1703d.addAll(listA);
            if (listA.size() >= iA) {
                this.f1707h.removeMessages(2);
                this.f1707h.sendEmptyMessage(2);
                sb = new StringBuilder();
                sb.append("数据库日志数量: ");
                sb.append(this.f1703d.size());
                sb.append(", 大于等于batchSize/2（");
                sb.append(iA);
                sb.append("），继续上传.");
                a(sb.toString());
            }
            sb = new StringBuilder();
            sb.append("数据库日志数量: ");
            sb.append(this.f1703d.size());
            str = ", 小于batchSize/2（";
        }
        sb.append(str);
        sb.append(iA);
        sb.append("），停止上传，等待新产生的事件");
        a(sb.toString());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            a((k) message.obj);
        } else if (i2 == 2) {
            m();
        } else if (i2 == 3) {
            a("routine触发失败重试.....");
            l();
        } else if (i2 == 4) {
            a("触发服务器繁忙重试机制.....");
            n();
        } else if (i2 == 5) {
            k();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f1704e = System.currentTimeMillis();
        this.f1707h = new Handler(getLooper(), this);
    }
}
