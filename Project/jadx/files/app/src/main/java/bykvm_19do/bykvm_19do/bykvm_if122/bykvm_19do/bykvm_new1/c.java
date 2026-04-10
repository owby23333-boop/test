package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.i;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.h0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.u;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.slot.GMAdSlotBase;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c f1615d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Map<Integer, List<j>> f1616e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f1617f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Handler f1618g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected AdSlot f1619h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f1620i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f1621j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected boolean f1622k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected List<Integer> f1625n;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected int f1631t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected GMAdSlotBase f1634w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected long f1636y;
    protected final AtomicBoolean a = new AtomicBoolean(false);
    protected final AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AtomicBoolean f1614c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected int f1623l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected final List<j> f1624m = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected List<TTBaseAd> f1626o = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected List<TTBaseAd> f1627p = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected List<TTBaseAd> f1628q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected Map<String, Object> f1629r = new HashMap();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected h f1630s = new h();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected AtomicBoolean f1632u = new AtomicBoolean(false);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected i f1633v = new i();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected final AtomicBoolean f1635x = new AtomicBoolean(false);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected boolean f1637z = false;
    protected int A = 0;
    protected Map<String, TTAbsAdLoaderAdapter> B = new ConcurrentHashMap();

    class a implements d.a {
        final /* synthetic */ AdSlot a;
        final /* synthetic */ List b;

        a(AdSlot adSlot, List list) {
            this.a = adSlot;
            this.b = list;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d.a
        public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar) {
            c.this.a(this.a, (List<j>) this.b, aVar);
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;

        class a implements d.a {
            a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d.a
            public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar) {
                Map<Integer, List<j>> map = c.this.f1616e;
                List<j> list = map != null ? map.get(0) : null;
                c cVar = c.this;
                cVar.a(cVar.f1619h, list, aVar);
            }
        }

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f fVar = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.f) bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.e.a();
            String str = this.a;
            c cVar = c.this;
            fVar.a(str, cVar.f1636y, cVar.f1619h, cVar.f1615d, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot, List<j> list, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.a aVar) {
        List<TTBaseAd> list2;
        List<TTBaseAd> list3;
        AdError adError;
        StringBuilder sb;
        String str;
        List<TTBaseAd> list4;
        List<TTBaseAd> list5;
        if (this.f1633v != null && aVar != null && !TextUtils.isEmpty(aVar.f1554c)) {
            this.f1633v.a = aVar.f1554c;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        String strC = cVar != null ? cVar.C() : null;
        if (aVar != null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(adSlot, aVar.f1556e, aVar.f1557f, strC, aVar.f1554c, this.f1630s.g() ? 1 : 0, aVar.f1558g, aVar.f1559h);
        }
        if (aVar == null || h0.a(aVar.a)) {
            this.f1623l = 2;
            if (this.a.get() || this.b.get()) {
                return;
            }
            Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "serverBidding响应失败了.......... ");
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f1630s.a((String) null);
                }
            }
            this.f1630s.a(0, true);
            if (this.f1630s.g() || !this.f1630s.f()) {
                A();
            } else {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "所有广告都已经加载完成....... ");
                List<TTBaseAd> list6 = this.f1628q;
                if ((list6 == null || list6.size() <= 0) && (((list2 = this.f1626o) == null || list2.size() <= 0) && ((list3 = this.f1627p) == null || list3.size() <= 0))) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar2 = this.f1615d;
                    if (cVar2 == null || !cVar2.I()) {
                        adError = new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL));
                        a(adError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                    } else {
                        a(new AdError(AdError.ERROR_COED_ADM_ERROR, AdError.getMessage(AdError.ERROR_COED_ADM_ERROR)), (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
                    str = "exchange响应失败且所有的广告都已经加载完成，则给出成功回调.....";
                    sb.append(str);
                    Logger.e("TTMediationSDK", sb.toString());
                    q();
                }
            }
        } else {
            this.f1623l = 1;
            if (this.a.get() || this.b.get()) {
                return;
            }
            Handler handler = this.f1618g;
            if (handler != null) {
                handler.removeMessages(4);
                this.f1618g.removeMessages(1);
                this.f1618g.removeMessages(3);
            }
            this.f1624m.clear();
            List<j> list7 = aVar.a;
            if (list7 != null) {
                this.f1624m.addAll(list7);
            }
            a(this.f1624m, this.f1615d.J());
            if (h0.a(this.f1624m)) {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "serverBidding响应回来..........没有P层，且普通广告全都没有胜出.....直接返回");
                List<TTBaseAd> list8 = this.f1628q;
                if ((list8 == null || list8.size() <= 0) && (((list4 = this.f1626o) == null || list4.size() <= 0) && ((list5 = this.f1627p) == null || list5.size() <= 0))) {
                    adError = new AdError(AdError.ERROR_CODE_AD_LOAD_FAIL, AdError.getMessage(AdError.ERROR_CODE_AD_LOAD_FAIL));
                    a(adError, (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d) null);
                } else {
                    if (!this.f1621j) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
                        str = "没有client bidding....直接给出成功回调.....";
                    } else if (m()) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
                        str = "存在client bidding且满足触发成功回调的条件，则给出成功回调.....";
                    }
                    sb.append(str);
                    Logger.e("TTMediationSDK", sb.toString());
                    q();
                }
            } else {
                Logger.e("TTMediationSDK", TTLogUtil.getTagSecondLevel(this.f1617f) + "serverBidding响应回来..........开始从头开始请求waterFallConfig ");
                a();
            }
        }
        if (aVar == null || !aVar.b) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f()).a().c(1);
    }

    private void c(TTBaseAd tTBaseAd) {
        AdSlot adSlot;
        if (tTBaseAd == null || (adSlot = this.f1619h) == null || !adSlot.isBidNotify()) {
            return;
        }
        if (tTBaseAd.isMultiBiddingAd() || tTBaseAd.isClientBiddingAd() || tTBaseAd.isServerBiddingAd()) {
            tTBaseAd.bidWinNotify(null);
        }
    }

    protected void A() {
        StringBuilder sb;
        String str;
        if (s()) {
            if (this.f1628q.size() < i()) {
                Iterator<TTBaseAd> it = this.f1626o.iterator();
                while (it.hasNext()) {
                    if (a(it.next()) && m()) {
                        sb = new StringBuilder();
                        sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
                        str = "抛出成功回调_普通层池中广告满足数量，且满足client bidding的返回条件，给出成功回调，直接返回......";
                    }
                }
                return;
            }
            sb = new StringBuilder();
            sb.append(TTLogUtil.getTagSecondLevel(this.f1617f));
            str = "抛出成功回调_P层池中广告满足数量，直接返回......";
            sb.append(str);
            Logger.d("TTMediationSDK", sb.toString());
            q();
        }
    }

    public TTAbsAdLoaderAdapter a(String str, String str2, String str3) {
        return this.B.get(String.format("%1$s_%2$s_%3$s", str, str2, str3));
    }

    protected void a() {
        a(0, false);
        A();
    }

    protected void a(int i2) {
        i iVar = this.f1633v;
        if (iVar != null) {
            iVar.b = i2;
        }
    }

    abstract void a(int i2, boolean z2);

    protected void a(Context context, AdSlot adSlot, List<j> list, boolean z2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.d dVarA = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.e.a();
        if (dVarA != null) {
            this.f1623l = 0;
            i iVar = this.f1633v;
            if (iVar != null) {
                iVar.f1468d = true;
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b bVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.b();
            bVar.a = adSlot;
            bVar.b = list;
            bVar.f1561d = this.f1615d;
            bVar.f1563f = z2;
            bVar.f1562e = adSlot != null ? adSlot.getPrimeRitReqType() : 1;
            dVarA.a(this.B, context, bVar, new a(adSlot, list));
            while (true) {
                switch (58) {
                    case 57:
                    case 58:
                    case 59:
                        return;
                }
            }
        }
    }

    protected void a(AdError adError) {
    }

    abstract void a(AdError adError, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.d dVar);

    protected void a(TTBaseAd tTBaseAd, GMAdConstant.BiddingLossReason biddingLossReason) {
        AdSlot adSlot;
        if (tTBaseAd == null || (adSlot = this.f1619h) == null || biddingLossReason == null || !adSlot.isBidNotify()) {
            return;
        }
        HashMap map = new HashMap();
        map.put("bidding_lose_reason", biddingLossReason);
        tTBaseAd.bidLoseNotify(map);
    }

    public void a(List<TTBaseAd> list) {
        boolean z2;
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            c((TTBaseAd) it.next());
        }
        if (this.f1627p.size() != 0) {
            ArrayList<TTBaseAd> arrayList2 = new ArrayList();
            arrayList2.addAll(this.f1627p);
            for (TTBaseAd tTBaseAd : arrayList2) {
                Iterator<TTBaseAd> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    TTBaseAd next = it2.next();
                    if (next != null && tTBaseAd != null && next == tTBaseAd) {
                        z2 = false;
                        break;
                    }
                }
                if (z2) {
                    a(tTBaseAd, GMAdConstant.BiddingLossReason.LOW_PRICE);
                }
            }
        }
    }

    protected void a(List<TTBaseAd> list, AdError adError) {
    }

    protected void a(List<j> list, boolean z2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        Map<Integer, List<j>> mapA = z2 ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.c.a(list) : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_if122.c.b(list);
        if (mapA == null) {
            mapA = new HashMap<>();
        }
        this.f1616e = mapA;
        this.f1625n = new ArrayList();
        this.f1625n.addAll(this.f1616e.keySet());
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.b.a(this.f1625n);
        this.f1630s.b(this.f1625n);
        this.f1630s.a(list, g(), d());
        b(list);
        while (true) {
            char c2 = 'Z';
            switch (94) {
                case 92:
                    while (true) {
                        switch (c2) {
                            case 'E':
                                return;
                            case 'F':
                            case 'G':
                                break;
                            default:
                                c2 = 'F';
                                break;
                        }
                    }
                    break;
                case 94:
                    return;
            }
        }
    }

    protected void a(boolean z2, StackTraceElement[] stackTraceElementArr) {
        if (z2) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a((TTBaseAd) null, this.f1619h, u.a(stackTraceElementArr), 3);
        }
    }

    protected boolean a(TTBaseAd tTBaseAd) {
        Map<Integer, List<j>> map;
        if (tTBaseAd == null || TextUtils.isEmpty(tTBaseAd.getAdNetworkSlotId()) || !tTBaseAd.isNormalAd() || (map = this.f1616e) == null) {
            return false;
        }
        List<j> list = map.get(Integer.valueOf(tTBaseAd.getLoadSort()));
        if (h0.a(list)) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        Collections.sort(arrayList);
        return !h0.b(arrayList) && tTBaseAd.getAdNetworkSlotId().equals(((j) arrayList.get(0)).d());
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            while (true) {
                switch (101) {
                    case 99:
                    case 100:
                    case 101:
                        return false;
                }
            }
        }
        if (!p() || !w()) {
            while (true) {
                switch (71) {
                    case 69:
                    case 70:
                    case 71:
                        return false;
                }
            }
        }
        Iterator<j> it = this.f1624m.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next().d())) {
                return false;
            }
        }
        return true;
    }

    public GMAdEcpmInfo b() {
        List<TTBaseAd> listU;
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p() || (listU = u()) == null || listU.size() == 0) {
            return null;
        }
        return p.a(listU.get(0), false);
    }

    public void b(TTBaseAd tTBaseAd) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().t()) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(tTBaseAd, this.f1619h, u.a(Thread.currentThread().getStackTrace()), 2);
        }
    }

    protected void b(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00cb A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[LOOP:2: B:24:0x00c0->B:46:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00c2 -> B:27:0x00c6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r7) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1.c.b(java.util.List):void");
    }

    public List<GMAdEcpmInfo> c() {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TTBaseAd tTBaseAd : u()) {
            if (tTBaseAd != null) {
                arrayList.add(p.a(tTBaseAd, false));
            }
        }
        return arrayList;
    }

    public void c(String str) {
        ThreadHelper.runOnMSDKThread(new b(str));
    }

    protected List<j> d() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || cVar.B() == null || this.f1615d.B().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.f1615d.B()) {
            if (jVar != null && (jVar.f() == 1 || jVar.f() == 3)) {
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    protected void d(String str) {
        i iVar = this.f1633v;
        if (iVar != null) {
            iVar.f1467c = str;
        }
    }

    public int e() {
        i iVar = this.f1633v;
        if (iVar != null) {
            return iVar.b;
        }
        return 0;
    }

    public List<GMAdEcpmInfo> f() {
        if (!bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().p()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TTBaseAd tTBaseAd : this.f1627p) {
            if (tTBaseAd != null) {
                arrayList.add(p.a(tTBaseAd, false));
            }
        }
        return arrayList;
    }

    protected List<j> g() {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVar = this.f1615d;
        if (cVar == null || cVar.B() == null || this.f1615d.B().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (j jVar : this.f1615d.B()) {
            if (jVar != null && jVar.f() == 100) {
                arrayList.add(jVar);
            }
        }
        return arrayList;
    }

    public int h() {
        return -1;
    }

    protected int i() {
        AdSlot adSlot = this.f1619h;
        if (adSlot == null) {
            return 1;
        }
        return adSlot.getAdCount();
    }

    protected String j() {
        i iVar = this.f1633v;
        if (iVar == null) {
            return null;
        }
        return iVar.a;
    }

    protected String k() {
        i iVar = this.f1633v;
        if (iVar != null) {
            return iVar.f1467c;
        }
        return null;
    }

    public String l() {
        return this.f1617f;
    }

    public boolean m() {
        return !n() || this.f1635x.get() || this.f1630s.b() == 0;
    }

    protected boolean n() {
        return this.f1621j;
    }

    public boolean o() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().r();
    }

    protected boolean p() {
        return this.f1620i;
    }

    abstract void q();

    protected boolean r() {
        return this.f1628q.size() >= i();
    }

    protected boolean s() {
        return this.f1628q.size() + this.f1626o.size() >= i();
    }

    protected boolean t() {
        return false;
    }

    public List<TTBaseAd> u() {
        ArrayList arrayList = new ArrayList();
        if (!h0.a(this.f1626o)) {
            arrayList.addAll(this.f1626o);
        }
        if (!h0.a(this.f1627p)) {
            arrayList.addAll(this.f1627p);
        }
        g.a(arrayList, g.c());
        if (!h0.a(this.f1628q)) {
            arrayList.addAll(0, this.f1628q);
        }
        return arrayList;
    }

    protected boolean v() {
        return this.f1622k;
    }

    protected boolean w() {
        return this.f1623l == 1;
    }

    protected boolean x() {
        return this.f1623l > 0;
    }

    protected void y() {
        i iVar;
        if (!p() || (iVar = this.f1633v) == null || TextUtils.isEmpty(iVar.a)) {
            return;
        }
        Iterator<TTBaseAd> it = this.f1628q.iterator();
        while (it.hasNext()) {
            it.next().putEventParam("server_bidding_extra", this.f1633v.a);
        }
        Iterator<TTBaseAd> it2 = this.f1627p.iterator();
        while (it2.hasNext()) {
            it2.next().putEventParam("server_bidding_extra", this.f1633v.a);
        }
        Iterator<TTBaseAd> it3 = this.f1626o.iterator();
        while (it3.hasNext()) {
            it3.next().putEventParam("server_bidding_extra", this.f1633v.a);
        }
    }

    protected void z() {
        i iVar = this.f1633v;
        if (iVar != null) {
            iVar.b = 2;
        }
    }
}
