package com.bytedance.msdk.dl.dl.z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.core.a.a;
import com.bytedance.msdk.dl.dl.z.z;
import com.bytedance.msdk.gz.h;
import com.bytedance.msdk.gz.tb;
import com.bytedance.msdk.gz.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z, com.bytedance.msdk.dl.g.g.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f447a;
    private String e;
    private List<Integer> fo;
    protected com.bytedance.msdk.dl.m.z.z g;
    private com.bytedance.msdk.dl.m.z.g gc;
    private com.bytedance.msdk.api.z.g gz;
    private com.bytedance.msdk.dl.e.g.z kb;
    private com.bytedance.msdk.core.uy.g m;
    private Handler uy;
    Map<Integer, List<com.bytedance.msdk.core.uy.uy>> z;
    protected final List<com.bytedance.msdk.core.uy.uy> dl = new CopyOnWriteArrayList();
    private boolean wp = false;

    public g() {
        Looper looperG = com.bytedance.msdk.z.gc.m.g();
        if (looperG != null) {
            this.uy = new Handler(looperG) { // from class: com.bytedance.msdk.dl.dl.z.g.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    g.this.z(message);
                }
            };
        } else {
            com.bytedance.msdk.z.gc.m.z();
            this.uy = new Handler(com.bytedance.msdk.z.gc.m.g()) { // from class: com.bytedance.msdk.dl.dl.z.g.2
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    g.this.z(message);
                }
            };
        }
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void z(z.InterfaceC0102z interfaceC0102z) {
        com.bytedance.msdk.dl.m.z.g gVarZ = interfaceC0102z.z();
        this.gc = gVarZ;
        gVarZ.z(this.uy);
        this.g = this.gc.i();
        this.m = this.gc.wp();
        com.bytedance.msdk.api.z.g gVarJs = this.gc.js();
        this.gz = gVarJs;
        this.e = gVarJs.zw();
        this.z = this.m.sy();
        ArrayList arrayList = new ArrayList();
        this.fo = arrayList;
        arrayList.addAll(this.z.keySet());
        com.bytedance.msdk.core.e.g.z(this.fo);
        this.g.z(this.fo);
        this.g.e(this.m.zw());
        List<com.bytedance.msdk.core.uy.uy> listZ = com.bytedance.msdk.dl.gz.e.z(this.m.t());
        List<com.bytedance.msdk.core.uy.uy> listG = com.bytedance.msdk.dl.gz.e.g(this.m.t());
        this.g.gz(listZ == null ? 0 : listZ.size());
        this.g.fo(listG == null ? 0 : listG.size());
        Handler handler = this.uy;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(6, this.m.wj());
        }
        if (!this.gc.iq()) {
            com.bytedance.msdk.gc.m.z(this.gz, this.m.vm(), !this.gc.zw(), this.gc.un().z, 0, (Map<String, Object>) null);
        }
        if (this.m.i()) {
            interfaceC0102z.z(interfaceC0102z.z());
        } else {
            if (com.bytedance.msdk.z.gc.dl.g()) {
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "开始加载广告 num:" + this.m.zw());
            }
            dl(0);
        }
        com.bytedance.msdk.core.v.g.z(com.bytedance.msdk.core.g.g()).g(1);
    }

    @Override // com.bytedance.msdk.dl.dl.z.z
    public void g(z.InterfaceC0102z interfaceC0102z) {
        ((com.bytedance.msdk.core.a.m) com.bytedance.msdk.core.a.gc.z()).z(this.gc.ti(), this.f447a, this.gz, this.m, new a.z() { // from class: com.bytedance.msdk.dl.dl.z.g.3
            @Override // com.bytedance.msdk.core.a.a.z
            public void z(com.bytedance.msdk.core.a.g gVar) {
                List<com.bytedance.msdk.core.uy.uy> list = g.this.z != null ? g.this.z.get(0) : null;
                g gVar2 = g.this;
                gVar2.z(gVar2.gz, list, gVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(int i) {
        if (i < 0) {
            return;
        }
        if (com.bytedance.msdk.dl.gz.e.z(i, this.fo)) {
            int iEc = this.m.ec();
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "the " + i + " level is first level normal ad and ParallelNum:" + iEc);
            for (int i2 = 0; i2 < iEc; i2++) {
                a(i + i2);
            }
            return;
        }
        a(i);
    }

    private void a(int i) {
        if (this.gc.z() || gc()) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "已经触发过成功、失败回调...");
            return;
        }
        if (this.gc.m()) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "已经触发过destroy操作...");
            return;
        }
        if (g()) {
            return;
        }
        if (i >= this.fo.size()) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "第 " + i + " 层没有广告可以请求...");
            return;
        }
        int iIntValue = this.fo.get(i).intValue();
        if (this.g.dl(iIntValue)) {
            dl(i + 1);
            return;
        }
        if (com.bytedance.msdk.dl.gz.e.g(iIntValue) && this.g.g() == -1) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "开启serverBidding exchange 请求....");
            z(this.z.get(Integer.valueOf(iIntValue)));
            z(i);
            return;
        }
        this.g.g(iIntValue);
        z(iIntValue, i);
        if (com.bytedance.msdk.dl.gz.e.dl(iIntValue) || com.bytedance.msdk.dl.gz.e.g(iIntValue)) {
            com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "第 " + i + "层 ClientBidding,ServerBidding 广告，levelSort：" + iIntValue + "，同时请求下一层广告...");
            dl(i + 1);
        }
    }

    private void z(int i, int i2) {
        long jOq;
        Handler handler;
        Map<Integer, List<com.bytedance.msdk.core.uy.uy>> map = this.z;
        if (map == null) {
            return;
        }
        final List<com.bytedance.msdk.core.uy.uy> list = map.get(Integer.valueOf(i));
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "loadLevelWaterFall start...执行当前加载层级 ：" + i2 + " levelSort:" + i + "  waterFallConfig.size:" + (list == null ? 0 : list.size()));
        if (h.z(list)) {
            return;
        }
        this.g.z(i, list.size());
        if (com.bytedance.msdk.dl.gz.e.dl(i)) {
            jOq = this.m.q();
        } else {
            jOq = this.m.oq();
        }
        Message messageObtain = Message.obtain();
        if (com.bytedance.msdk.dl.gz.e.z(i)) {
            messageObtain.what = 1;
        } else if (com.bytedance.msdk.dl.gz.e.dl(i)) {
            messageObtain.what = 2;
        } else if (com.bytedance.msdk.dl.gz.e.g(i)) {
            messageObtain.what = 3;
        } else {
            messageObtain.what = 4;
            messageObtain.obj = tb.z(i);
        }
        messageObtain.arg1 = i;
        Handler handler2 = this.uy;
        if (handler2 != null) {
            handler2.sendMessageDelayed(messageObtain, jOq);
        }
        long jEo = this.m.eo();
        if (jEo != 0 && (handler = this.uy) != null) {
            handler.removeMessages(5);
            this.uy.sendEmptyMessageDelayed(5, jEo);
        }
        for (final int i3 = 0; i3 < list.size(); i3++) {
            try {
                com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.dl.dl.z.g.4
                    @Override // java.lang.Runnable
                    public void run() {
                        g.this.z((com.bytedance.msdk.core.uy.uy) list.get(i3), list.size());
                    }
                });
                if (this.gc.zw()) {
                    this.gc.hh();
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.z(th);
            }
        }
    }

    protected void z(com.bytedance.msdk.core.uy.uy uyVar, int i) {
        if (uyVar != null && this.gz != null) {
            z(uyVar.fv(), uyVar.pf(), uyVar.ls(), com.bytedance.msdk.g.z.z(this.gz.iq(), uyVar.m()), 0, "广告请求中");
        }
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "开始 某一层级的waterFallConfig请求 WaterFallConfig:" + uyVar.toString());
        com.bytedance.msdk.dl.m.g.g gVarZ = com.bytedance.msdk.dl.m.g.g.z(uyVar, this);
        gVarZ.dl(1);
        gVarZ.g(1);
        gVarZ.z(i);
        gVarZ.z(!this.gc.zw());
        gVarZ.z(SystemClock.elapsedRealtime());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.bytedance.msdk.dl.dl.g.g());
        arrayList.add(new com.bytedance.msdk.dl.dl.g.e());
        arrayList.add(new com.bytedance.msdk.dl.dl.g.a());
        arrayList.add(new com.bytedance.msdk.dl.dl.g.m());
        arrayList.add(new com.bytedance.msdk.dl.dl.g.dl());
        new com.bytedance.msdk.dl.dl.g.gc(arrayList).z(this.gc, gVarZ);
    }

    protected void z(final List<com.bytedance.msdk.core.uy.uy> list) {
        final Context context = this.gc.getContext();
        if (context != null) {
            com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.dl.dl.z.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g gVar = g.this;
                    gVar.z(context, gVar.gz, list, !g.this.gc.zw());
                }
            });
        }
    }

    public void z(final int i) {
        com.bytedance.msdk.dl.e.g.z zVarZ = com.bytedance.msdk.dl.e.g.gc.z(this.m);
        this.kb = zVarZ;
        zVarZ.z(this.uy, this.m, new com.bytedance.msdk.dl.e.g.g(this.m, new Runnable() { // from class: com.bytedance.msdk.dl.dl.z.g.6
            @Override // java.lang.Runnable
            public void run() {
                g.this.dl(i + 1);
            }
        }));
    }

    public boolean g() {
        return g(null, 3);
    }

    public boolean g(com.bytedance.msdk.core.uy.uy uyVar, int i) {
        if (this.gc.z() || gc()) {
            return true;
        }
        if (this.g.gc()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "触发总超时或全部代码位响应结束.....totalTimeout：" + this.g.gc() + "  allWtfFinish:" + this.g.gz());
            if (!h.z(this.gc.e()) || !h.z(this.gc.gz()) || !h.z(this.gc.uy())) {
                dl();
            } else {
                if (com.bytedance.msdk.gz.g.z.g(this.m)) {
                    com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "总加载时间超时.......isCallback:true");
                    if (com.bytedance.msdk.gz.g.z.z(this.gc, this.fo, this.z)) {
                        dl();
                        return true;
                    }
                }
                this.wp = true;
                z(new com.bytedance.msdk.api.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB, com.bytedance.msdk.api.z.z(AVMDLDataLoader.KeyIsStoRingBufferSizeKB)));
            }
            return true;
        }
        if (this.g.gz()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "全部广告完成响应...");
            if (!h.z(this.gc.e()) || !h.z(this.gc.gz()) || !h.z(this.gc.uy())) {
                dl();
            } else {
                z(new com.bytedance.msdk.api.z(20005, com.bytedance.msdk.api.z.z(20005)));
            }
            return true;
        }
        if (this.gc.v()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "p层广告已经满足返回条件...");
            dl();
            return true;
        }
        if (!(this.m.gk() && this.g.dl()) && this.m.gk()) {
            return false;
        }
        if (uyVar == null) {
            if (this.gc.pf() && this.gc.p()) {
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "p层&普通层广告 已经满足返回条件 V1 .........");
                dl();
                return true;
            }
            if (!this.gc.ls() || !this.g.fo() || !this.g.uy() || !this.gc.fv()) {
                return false;
            }
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "p层&普通&Bidding层广告 已经满足返回条件 V2 .........");
            dl();
            return true;
        }
        if (this.gc.pf() && this.gc.p()) {
            for (com.bytedance.msdk.g.dl dlVar : this.gc.gz()) {
                com.bytedance.msdk.dl.e.z.z zVarZ = com.bytedance.msdk.dl.e.z.a.z(this.m);
                com.bytedance.msdk.dl.m.z.g gVar = this.gc;
                Map<Integer, List<com.bytedance.msdk.core.uy.uy>> map = this.z;
                if (zVarZ.z(gVar, dlVar, map == null ? null : map.get(Integer.valueOf(com.bytedance.msdk.dl.gz.e.z(this.m, dlVar))))) {
                    com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "p层&普通层广告 已经满足返回条件 V3 .........");
                    dl();
                    return true;
                }
            }
            return false;
        }
        if (!this.gc.ls() || !this.g.fo() || !this.g.uy() || !this.gc.fv()) {
            return false;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "p层&普通&Bidding层广告 已经满足返回条件 V4 .........");
        dl();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Message message) {
        int i = message.arg1;
        switch (message.what) {
            case 1:
            case 4:
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + (message.what == 1 ? "P层" : "普通层") + "广告触发层超时.........levelSort:" + i);
                this.g.a(i);
                if (!g()) {
                    dl(g(i));
                }
                break;
            case 2:
            case 3:
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + (message.what == 2 ? "ClientBidding层" : "ServerBidding层层") + "广告触发层超时.........levelSort:" + i);
                this.g.a(i);
                g();
                break;
            case 5:
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "触发最小层超时.........levelSort:" + i);
                g();
                break;
            case 6:
                com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "触发总超时.........");
                this.g.a();
                this.gc.un().m = true;
                g();
                break;
        }
    }

    @Override // com.bytedance.msdk.dl.g.g.z
    public void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.core.uy.uy uyVar) {
        if (h.z(list) || uyVar == null) {
            return;
        }
        z(list, this.m);
        z(uyVar.fv(), uyVar.pf(), uyVar.ls(), com.bytedance.msdk.g.z.z(uyVar.i(), uyVar.m()), 0, "广告加载成功");
        com.bytedance.msdk.core.e.dl.z(this.e, uyVar, !h.g(list) ? list.get(0) : null);
        g(list);
        int iZ = com.bytedance.msdk.dl.gz.e.z(this.m, uyVar);
        if (uyVar.ti() && com.bytedance.msdk.dl.e.z.z(this.g, this.dl, uyVar.fv())) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "返回的普通广告被server Bidding过滤了......slotId:" + uyVar.fv());
            this.gc.fo().addAll(list);
            return;
        }
        com.bytedance.msdk.dl.gz.z.z(this.gc, list, false);
        this.g.z(iZ, uyVar.fv());
        if (this.gc.zw()) {
            dl(list);
        }
        if (this.g.gc()) {
            z((List<com.bytedance.msdk.g.dl>) null, new com.bytedance.msdk.api.z(10012, "load ad timeout !!!"));
        } else {
            z(list, (com.bytedance.msdk.api.z) null);
        }
        this.gc.z(list);
        if (g(uyVar, 1) || this.g.m(iZ) != 0 || uyVar.un()) {
            return;
        }
        int iG = g(iZ);
        dl(uyVar, iZ);
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "onAdLoaded levelSort: " + iZ + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iG);
        dl(iG);
    }

    @Override // com.bytedance.msdk.dl.g.g.z
    public void z(com.bytedance.msdk.api.z zVar, com.bytedance.msdk.core.uy.uy uyVar) {
        if (uyVar == null) {
            return;
        }
        z((List<com.bytedance.msdk.g.dl>) null, zVar);
        if (zVar != null) {
            z(uyVar.fv(), uyVar.p(), uyVar.ls(), com.bytedance.msdk.g.z.z(uyVar.i(), uyVar.m()), zVar.dl, zVar.f366a);
        }
        com.bytedance.msdk.core.e.dl.z(zVar, uyVar);
        if (uyVar.ti() && com.bytedance.msdk.dl.e.z.z(this.g, this.dl, uyVar.fv())) {
            return;
        }
        int iZ = com.bytedance.msdk.dl.gz.e.z(this.m, uyVar);
        this.g.z(iZ, uyVar.fv());
        if (g(uyVar, 2) || this.g.gc(iZ) || this.g.m(iZ) != 0 || uyVar.un()) {
            return;
        }
        int iG = g(iZ);
        dl(uyVar, iZ);
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "onAdFailed levelSort " + iZ + " 广告全部响应结束&不满足返回条件，直接请求下一层广告 nextIdx：" + iG);
        dl(iG);
    }

    private void dl(com.bytedance.msdk.core.uy.uy uyVar, int i) {
        int i2;
        if (uyVar == null || this.uy == null) {
            return;
        }
        if (uyVar.lq()) {
            i2 = 1;
        } else if (uyVar.x() || uyVar.mc()) {
            i2 = 2;
        } else {
            i2 = uyVar.gk() ? 3 : 4;
        }
        if (uyVar.ti()) {
            this.uy.removeMessages(i2, tb.z(i));
        } else {
            this.uy.removeMessages(i2);
        }
    }

    @Override // com.bytedance.msdk.dl.g.g.z
    public void z() {
        com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "onAdVideoCache.....");
        a();
    }

    void dl() {
        this.wp = false;
        this.gc.a();
    }

    void z(com.bytedance.msdk.api.z zVar) {
        this.gc.z(zVar);
    }

    void a() {
        this.gc.gc();
    }

    void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z zVar) {
        this.gc.z(list, zVar);
    }

    protected int g(int i) {
        int iIndexOf;
        List<Integer> list = this.fo;
        if (list == null || (iIndexOf = list.indexOf(Integer.valueOf(i))) == -1) {
            return -1;
        }
        return iIndexOf + 1;
    }

    protected void z(Context context, final com.bytedance.msdk.api.z.g gVar, final List<com.bytedance.msdk.core.uy.uy> list, boolean z) {
        com.bytedance.msdk.core.a.a aVarZ = com.bytedance.msdk.core.a.gc.z();
        if (aVarZ != null) {
            this.g.z(0);
            this.gc.un().f407a = true;
            com.bytedance.msdk.core.a.dl dlVar = new com.bytedance.msdk.core.a.dl();
            dlVar.z = gVar;
            dlVar.g = list;
            dlVar.f370a = this.m;
            dlVar.m = z;
            dlVar.gc = gVar != null ? gVar.dl() : 1;
            aVarZ.z(this.gc.q(), context, dlVar, new a.z() { // from class: com.bytedance.msdk.dl.dl.z.g.7
                @Override // com.bytedance.msdk.core.a.a.z
                public void z(com.bytedance.msdk.core.a.g gVar2) {
                    g.this.z(gVar, list, gVar2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(com.bytedance.msdk.api.z.g gVar, List<com.bytedance.msdk.core.uy.uy> list, com.bytedance.msdk.core.a.g gVar2) {
        com.bytedance.msdk.dl.e.g.z zVar;
        if (this.gc != null && gVar2 != null && !TextUtils.isEmpty(gVar2.f371a)) {
            this.gc.un().z = gVar2.f371a;
        }
        com.bytedance.msdk.core.uy.g gVar3 = this.m;
        if (gVar3 != null && gVar2 != null) {
            gVar3.m().put("price_source", Integer.valueOf(gVar2.i));
        }
        if (gVar2 != null) {
            com.bytedance.msdk.gc.m.z(gVar, gVar2, this.g.gc() ? 1 : 0);
        }
        if (gVar2 != null && !h.z(gVar2.g)) {
            this.g.z(1);
            if (this.gc.z() || this.gc.g()) {
                return;
            }
            this.dl.clear();
            this.dl.addAll(gVar2.g);
            Handler handler = this.uy;
            if (handler != null) {
                handler.removeMessages(1);
                this.uy.removeMessages(4);
                this.uy.removeMessages(5);
            }
            x.z(gVar2.g);
            this.z = com.bytedance.msdk.dl.gz.e.z(gVar2.g, this.m.wp());
            ArrayList arrayList = new ArrayList();
            this.fo = arrayList;
            arrayList.addAll(this.z.keySet());
            com.bytedance.msdk.core.e.g.z(this.fo);
            this.g.z(this.fo);
            this.g.z(gVar2.g, com.bytedance.msdk.dl.gz.e.z(this.m.t()), com.bytedance.msdk.dl.gz.e.dl(this.m.t()));
            com.bytedance.msdk.dl.e.z.z(this.m, this.gc, gVar2.g);
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "serverBidding响应回来..........开始从头开始请求waterFallConfig  代码位总数量：" + gVar2.g.size());
            dl(0);
            g();
        } else {
            this.g.z(2);
            if (this.gc.z() || this.gc.g()) {
                return;
            }
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", com.bytedance.msdk.z.gc.gc.z(this.m) + "serverBidding响应失败了.......... ");
            this.g.g(0);
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    com.bytedance.msdk.core.uy.uy uyVar = list.get(i);
                    this.g.z(com.bytedance.msdk.dl.gz.e.z(this.m, uyVar), uyVar.fv());
                }
            }
            if (!g() && (zVar = this.kb) != null) {
                zVar.z();
            }
        }
        if (this.m != null && gVar2 != null) {
            com.bytedance.msdk.core.fo.g.a().z(gVar2.wp, gVar2.v, this.m.un(), this.m.lq());
        }
        if (gVar2 == null || !gVar2.dl) {
            return;
        }
        com.bytedance.msdk.core.v.g.z(com.bytedance.msdk.core.g.g()).z().g(1);
    }

    public boolean gc() {
        if (this.gc.g()) {
            return (this.wp && com.bytedance.msdk.gz.g.z.z(this.m)) ? false : true;
        }
        return false;
    }

    protected void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.core.uy.g gVar) {
        com.bytedance.msdk.core.fo.a.z(list, gVar);
        com.bytedance.msdk.core.g.z.z(list, gVar);
    }

    protected void z(String str, String str2, String str3, String str4, int i, String str5) {
        com.bytedance.msdk.api.g gVar = this.gc.io().get(str);
        if (gVar == null) {
            gVar = new com.bytedance.msdk.api.g();
        }
        gVar.g(str).dl(str2).a(str3).z(i).gc(str5).z(str4);
        this.gc.io().put(str, gVar);
    }

    private void g(List<com.bytedance.msdk.g.dl> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        String strYz = list.get(0).yz();
        if (list.get(0).wo() && com.bytedance.msdk.core.gc.z.z.z().gc(this.e, strYz, this.gz.gc()) == 1) {
            ArrayList arrayList = new ArrayList();
            for (com.bytedance.msdk.g.dl dlVar : list) {
                if (dlVar != null) {
                    arrayList.add(new com.bytedance.msdk.core.gc.g.e(dlVar, 0L, this.gz));
                }
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.g.dl dlVar2 = ((com.bytedance.msdk.core.gc.g.e) arrayList.get(0)).z;
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "--==-- 广告复用:广告缓存成功 -------" + dlVar2.zx() + ", adType: " + com.bytedance.msdk.g.z.z(dlVar2.hy(), dlVar2.j()) + ", adnSlotId: " + dlVar2.yz() + ", ad个数: " + arrayList.size());
                com.bytedance.msdk.core.gc.z.z.z().z(strYz, (List<com.bytedance.msdk.core.gc.g.e>) arrayList, false);
            }
        }
    }

    private void dl(List<com.bytedance.msdk.g.dl> list) {
        if (list == null) {
            return;
        }
        for (com.bytedance.msdk.g.dl dlVar : list) {
            if (dlVar != null) {
                com.bytedance.msdk.core.gc.g.a.z().z(this.e, new com.bytedance.msdk.core.gc.g.e(dlVar, this.gc.l(), this.gz));
            }
        }
    }
}
