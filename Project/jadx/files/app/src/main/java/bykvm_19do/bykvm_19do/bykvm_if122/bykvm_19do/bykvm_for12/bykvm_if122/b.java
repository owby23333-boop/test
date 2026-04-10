package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.v2.GMPreloadRequestInfo;
import com.bytedance.msdk.api.v2.ad.AdUtils;
import com.bytedance.msdk.base.TTBaseAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class b extends bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static volatile b f1522o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Integer> f1523c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, Long> f1524d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, AdSlot> f1525e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>>> f1526f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<String, Map<String, AdError>> f1527g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, Boolean> f1528h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c> f1529i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1530j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1531k = 20;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f1532l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f1533m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f1534n;

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1535c;

        a(Context context, String str, int i2) {
            this.a = context;
            this.b = str;
            this.f1535c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.a, this.b, 2, this.f1535c, (f) null);
        }
    }

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b$b, reason: collision with other inner class name */
    class RunnableC0044b implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1537c;

        RunnableC0044b(Context context, String str, int i2) {
            this.a = context;
            this.b = str;
            this.f1537c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.a, this.b, 4, this.f1537c, (f) null);
        }
    }

    class c implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ List b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f1539c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1540d;

        class a implements e {
            a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.e
            public void a(boolean z2) {
                if (z2) {
                    return;
                }
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.b.c().a(b.this.f1526f);
            }
        }

        c(Activity activity, List list, int i2, int i3) {
            this.a = activity;
            this.b = list;
            this.f1539c = i2;
            this.f1540d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            if (b.this.f1530j) {
                str = "注意：预加载preload只能调用一次";
            } else if (this.a == null) {
                str = "预加载preload传入的activity不能是null";
            } else {
                List list = this.b;
                if (list != null && list.size() > 0) {
                    b.this.f1530j = true;
                    b.this.f1533m = this.f1539c;
                    b.this.f1534n = this.f1540d;
                    b.this.f1532l = new ArrayList();
                    for (GMPreloadRequestInfo gMPreloadRequestInfo : this.b) {
                        if (gMPreloadRequestInfo != null && gMPreloadRequestInfo.getPrimeRitList() != null) {
                            b.this.f1532l.addAll(gMPreloadRequestInfo.getPrimeRitList());
                        }
                    }
                    int i2 = this.f1539c;
                    int i3 = (i2 < 1 || i2 > 20) ? 2 : i2;
                    int i4 = this.f1540d;
                    int i5 = (i4 < 1 || i4 > 10) ? 2 : i4;
                    List listA = b.this.a((List<GMPreloadRequestInfo>) this.b);
                    if (listA.size() > 0) {
                        b.this.new d(this.a, listA, i3, i5, new a()).a();
                        return;
                    }
                    return;
                }
                str = "预加载preload传入的requestInfos不能是null或者size为0";
            }
            Logger.d("TTMediationSDK", str);
        }
    }

    private class d {
        private final Activity a;
        private final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<GMPreloadRequestInfo> f1543d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final e f1544e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1545f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f1546g;

        class a implements f {
            a() {
            }

            @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.f
            public void a(String str, boolean z2) {
                d.d(d.this);
                if (!z2) {
                    d.f(d.this);
                }
                Logger.d("TTMediationSDK", "--==-- pendingLoadNum: " + d.this.f1545f);
                if (d.this.f1545f > 0 || d.this.f1544e == null) {
                    return;
                }
                d.this.f1544e.a(d.this.f1546g <= 0);
            }
        }

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b$d$b, reason: collision with other inner class name */
        class RunnableC0045b implements Runnable {
            RunnableC0045b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.a();
            }
        }

        d(Activity activity, List<GMPreloadRequestInfo> list, int i2, int i3, e eVar) {
            this.a = activity;
            this.f1543d = list;
            this.b = i2;
            this.f1542c = i3;
            this.f1544e = eVar;
            this.f1545f = list.size();
            this.f1546g = list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            GMPreloadRequestInfo gMPreloadRequestInfoRemove;
            StringBuilder sb;
            String str;
            for (int i2 = 0; i2 < this.b; i2++) {
                if (this.f1543d.size() > 0 && (gMPreloadRequestInfoRemove = this.f1543d.remove(0)) != null) {
                    AdSlot adSlotConvertGMAdSlotBase2AdSlot = AdUtils.convertGMAdSlotBase2AdSlot(gMPreloadRequestInfoRemove.getGmAdSlot());
                    String str2 = gMPreloadRequestInfoRemove.getPrimeRitList().get(0);
                    if (adSlotConvertGMAdSlotBase2AdSlot == null) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为空，广告位：";
                    } else if (adSlotConvertGMAdSlotBase2AdSlot.getAdType() == 1) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为banner类型，不支持该类型预加载，广告位: ";
                    } else if (adSlotConvertGMAdSlotBase2AdSlot.getAdType() == 2) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为插屏类型，不支持该类型预加载，广告位: ";
                    } else if (adSlotConvertGMAdSlotBase2AdSlot.getAdType() == 9) {
                        sb = new StringBuilder();
                        str = "预加载preload传入的GMAdSlotBase为Draw类型，不支持该类型预加载，广告位: ";
                    } else {
                        b.this.a(str2, adSlotConvertGMAdSlotBase2AdSlot);
                        b.this.a(this.a, str2, 5, 0, new a());
                    }
                    sb.append(str);
                    sb.append(str2);
                    Logger.d("TTMediationSDK", sb.toString());
                }
            }
            if (this.f1543d.size() > 0) {
                ThreadHelper.postDelayOnMSDKThread(new RunnableC0045b(), ((long) this.f1542c) * 1000);
            }
        }

        static /* synthetic */ int d(d dVar) {
            int i2 = dVar.f1545f;
            dVar.f1545f = i2 - 1;
            return i2;
        }

        static /* synthetic */ int f(d dVar) {
            int i2 = dVar.f1546g;
            dVar.f1546g = i2 - 1;
            return i2;
        }
    }

    public interface e {
        void a(boolean z2);
    }

    public interface f {
        void a(String str, boolean z2);
    }

    private b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r10, java.lang.String r11, com.bytedance.msdk.api.AdSlot r12, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c r13) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.a(java.util.List, java.lang.String, com.bytedance.msdk.api.AdSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<GMPreloadRequestInfo> a(List<GMPreloadRequestInfo> list) {
        ArrayList arrayList = new ArrayList();
        int i2 = this.f1531k;
        HashSet hashSet = new HashSet();
        for (GMPreloadRequestInfo gMPreloadRequestInfo : list) {
            if (arrayList.size() >= i2) {
                break;
            }
            if (gMPreloadRequestInfo != null && gMPreloadRequestInfo.getPrimeRitList() != null) {
                for (String str : gMPreloadRequestInfo.getPrimeRitList()) {
                    if (arrayList.size() < i2) {
                        if (!TextUtils.isEmpty(str) && !hashSet.contains(str)) {
                            hashSet.add(str);
                            ArrayList arrayList2 = new ArrayList(1);
                            arrayList2.add(str);
                            arrayList.add(new GMPreloadRequestInfo(gMPreloadRequestInfo.getGmAdSlot(), arrayList2));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a> a(List<j> list, String str, Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map, AdSlot adSlot, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c cVar) {
        int i2;
        int iA;
        TTBaseAd tTBaseAd;
        List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list2;
        while (true) {
            char c2 = 5;
            switch (10) {
                case 8:
                case 10:
                    ArrayList arrayList = new ArrayList();
                    int iD0 = (cVar.h() == 2 && (cVar instanceof bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d)) ? ((bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d) cVar).d0() : 0;
                    while (i2 < list.size() && i2 < iD0) {
                        String strD = list.get(i2).d();
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a aVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.a();
                        aVar.b(strD);
                        aVar.e(list.get(i2).y());
                        aVar.c(list.get(i2).p());
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar = (map == null || (list2 = map.get(strD)) == null || list2.size() <= 0) ? null : list2.get(0);
                        if (eVar == null || (tTBaseAd = eVar.a) == null) {
                            Map<String, AdError> map2 = this.f1527g.get(str);
                            AdError adError = map2 != null ? map2.get(strD) : null;
                            if (adError != null) {
                                aVar.d(3);
                                aVar.a(adError.thirdSdkErrorCode);
                                aVar.a(adError.thirdSdkErrorMessage);
                                arrayList.add(aVar);
                            } else {
                                iA = 4;
                            }
                        } else {
                            aVar.b(tTBaseAd.isHasShown() ? 1 : 0);
                            iA = a(eVar, this.f1525e.get(str), adSlot, "预缓存");
                            i2 = iA == -1 ? i2 + 1 : 0;
                        }
                        aVar.d(iA);
                        arrayList.add(aVar);
                    }
                    return arrayList;
                case 9:
                    while (true) {
                        switch (c2) {
                            case '-':
                                break;
                            case '.':
                                break;
                            case '/':
                                break;
                            default:
                                c2 = '/';
                                break;
                        }
                    }
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, int i2, int i3, f fVar) {
        int iA = a(str, i3);
        if (iA != 2) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 配置未开启预加载缓存，req_type: " + iA);
            if (fVar != null) {
                fVar.a(str, false);
                return;
            }
            return;
        }
        if (this.f1528h.get(str) != null && this.f1528h.get(str).booleanValue()) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 已发起过预缓存，还未使用掉，此次不发起");
            if (fVar != null) {
                fVar.a(str, true);
                return;
            }
            return;
        }
        AdSlot shallowCopy = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.b.getShallowCopy(this.f1525e.get(str));
        if (shallowCopy == null) {
            Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存取消，adslot为null，rit：" + str);
            return;
        }
        Logger.d("TTMediationSDK", TTLogUtil.getTagSecondLevel(str) + "--==-- 预缓存开始请求, req_type: " + iA);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d dVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.d(context, str);
        this.f1529i.put(str, dVar);
        this.f1528h.put(str, true);
        shallowCopy.setPrimeRitReqType(i2);
        dVar.a(shallowCopy, fVar);
    }

    private void b(String str, AdSlot adSlot) {
        Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f1526f.get(str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list = map.get(str2);
                if (list != null && list.size() > 0 && list.get(0) != null) {
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar = list.get(0);
                    if (a(eVar, eVar.a(), adSlot, "聚合预缓存") != -1) {
                        map.put(str2, null);
                    }
                }
            }
            return;
        }
        while (true) {
            switch (71) {
                case 70:
                case 72:
                    while (true) {
                        char c2 = 'R';
                        switch (82) {
                            case 82:
                                while (true) {
                                    switch (c2) {
                                        case 'P':
                                        case 'Q':
                                            break;
                                        case 'R':
                                            break;
                                        default:
                                            c2 = 'P';
                                            break;
                                    }
                                }
                                break;
                        }
                        return;
                    }
                case 71:
                    return;
            }
        }
    }

    public static b d() {
        if (f1522o == null) {
            synchronized (b.class) {
                if (f1522o == null) {
                    f1522o = new b();
                }
            }
        }
        return f1522o;
    }

    public int a() {
        return this.f1533m;
    }

    public int a(String str, int i2) {
        Integer num;
        if (i2 == 2 || (num = this.f1523c.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public AdSlot a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f1525e.get(str);
    }

    public void a(int i2) {
        this.f1531k = i2;
    }

    public void a(Activity activity, List<GMPreloadRequestInfo> list, int i2, int i3) {
        ThreadHelper.runOnMSDKThread(new c(activity, list, i2, i3));
    }

    public void a(Context context, String str, int i2) {
        ThreadHelper.runOnMSDKThread(new a(context, str, i2));
    }

    public void a(String str, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f1524d.put(str, Long.valueOf(j2));
    }

    public void a(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e eVar) {
        if (d(str) == null || d(str).longValue() == eVar.b()) {
            Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f1526f.get(str);
            String adNetworkSlotId = eVar.a.getAdNetworkSlotId();
            if (map == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eVar);
                HashMap map2 = new HashMap();
                map2.put(adNetworkSlotId, arrayList);
                this.f1526f.put(str, map2);
                return;
            }
            List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list = map.get(adNetworkSlotId);
            if (list != null) {
                list.add(eVar);
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(eVar);
            map.put(adNetworkSlotId, arrayList2);
            while (true) {
                switch (71) {
                    case 70:
                    case 71:
                    case 72:
                        return;
                }
            }
        }
    }

    public void a(String str, AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f1525e.put(str, adSlot);
    }

    public void a(String str, String str2, long j2, AdError adError) {
        if (d(str) == null || d(str).longValue() == j2) {
            Map<String, AdError> map = this.f1527g.get(str);
            if (map == null) {
                map = new HashMap<>();
                this.f1527g.put(str, map);
            }
            map.put(str2, adError);
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:28:0x00cc. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:33:0x00d6. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc A[LOOP:2: B:28:0x00cc->B:27:0x00ca, LOOP_START, PHI: r9
  0x00cc: PHI (r9v3 char) = (r9v2 char), (r9v4 char) binds: [B:47:?, B:27:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0 A[PHI: r9
  0x00d0: PHI (r9v5 char) = (r9v3 char), (r9v6 char), (r9v6 char) binds: [B:44:0x00d0, B:31:0x00d2, B:33:0x00d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00da A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00df A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[PHI: r9
  PHI (r9v2 char) = (r9v1 char), (r9v6 char) binds: [B:38:0x00cc, B:31:0x00d2] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00d0 -> B:31:0x00d2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d6 -> B:35:0x00da). Please report as a decompilation issue!!! */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r9, com.bytedance.msdk.api.AdSlot r10, java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.a(java.lang.String, com.bytedance.msdk.api.AdSlot, java.lang.String):boolean");
    }

    public List<String> b() {
        return this.f1532l;
    }

    public Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> b(String str) {
        return this.f1526f.get(str);
    }

    public void b(Context context, String str, int i2) {
        ThreadHelper.runOnMSDKThread(new RunnableC0044b(context, str, i2));
    }

    public void b(String str, int i2) {
        this.f1523c.put(str, Integer.valueOf(i2));
    }

    public int c() {
        return this.f1534n;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.c c(String str) {
        return this.f1529i.get(str);
    }

    public Long d(String str) {
        return this.f1524d.get(str);
    }

    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> e(String str) {
        ArrayList arrayList = new ArrayList();
        Map<String, List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e>> map = this.f1526f.get(str);
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.e> list = map.get(it.next());
                if (list != null && list.size() > 0) {
                    arrayList.addAll(list);
                }
            }
        }
        if (map != null) {
            map.clear();
        }
        Map<String, AdError> map2 = this.f1527g.get(str);
        if (map2 != null) {
            map2.clear();
        }
        return arrayList;
    }
}
