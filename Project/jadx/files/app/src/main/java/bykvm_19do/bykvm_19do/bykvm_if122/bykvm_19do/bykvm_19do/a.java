package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.p;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.z;
import com.anythink.expressad.video.module.a.a.m;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.bytedance.msdk.api.AdSlot;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.base.TTBaseAd;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private int a;
    private int b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private RewardItem f1345f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private AdSlot f1351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private TTBaseAd f1352m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f1353n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f1354o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private i f1355p;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f1342c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f1343d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f1344e = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f1346g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f1347h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1348i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f1349j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f1350k = "";

    /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$a, reason: collision with other inner class name */
    class RunnableC0033a implements Runnable {
        RunnableC0033a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f1343d = true;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f1342c = true;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a, reason: collision with other inner class name */
        class RunnableC0034a implements Runnable {

            /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a$a, reason: collision with other inner class name */
            class C0035a implements RewardItem {
                C0035a() {
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public float getAmount() {
                    if (a.this.f1351l != null) {
                        return a.this.f1351l.getRewardAmount();
                    }
                    return 0.0f;
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public Map<String, Object> getCustomData() {
                    HashMap map = new HashMap();
                    map.put(RewardItem.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, true);
                    map.put("transId", a.this.f1354o);
                    map.put("reason", 0);
                    map.put("gromoreExtra", (a.this.f1351l == null || a.this.f1351l.getCustomData() == null) ? "" : a.this.f1351l.getCustomData().get("gromoreExtra"));
                    map.put("errorCode", Integer.valueOf(a.this.f1349j));
                    map.put(RewardItem.KEY_ERROR_MSG, a.this.f1350k);
                    GMAdEcpmInfo gMAdEcpmInfoA = p.a(a.this.f1352m, true);
                    map.put(RewardItem.KEY_ADN_NAME, gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getAdnName() : "");
                    map.put("ecpm", gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getPreEcpm() : "");
                    return map;
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public String getRewardName() {
                    return a.this.f1351l != null ? a.this.f1351l.getRewardName() : "";
                }

                @Override // com.bytedance.msdk.api.reward.RewardItem
                public boolean rewardVerify() {
                    return false;
                }
            }

            RunnableC0034a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f1342c) {
                    Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，已经destroy了, 直接return");
                    return;
                }
                if (a.this.f1355p == null || a.this.f1347h) {
                    return;
                }
                Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- verify回调兜底进来，给开发者verify回调");
                a.this.f1347h = true;
                RewardItem c0035a = new C0035a();
                i iVar = a.this.f1355p;
                if (a.this.f1345f != null) {
                    c0035a = a.this.f1345f;
                }
                iVar.onRewardVerify(c0035a);
            }
        }

        c() {
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0073  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.b(r0)
                java.lang.String r1 = "GROMORE_SS_REWARD_VERIFY"
                if (r0 == 0) goto L11
                java.lang.String r0 = "--==-- verify回调进来，已经destroy, 直接return"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                goto La0
            L11:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                r2 = 1
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.c(r0, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.g(r0)
                if (r0 == 0) goto L49
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$i r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.h(r0)
                if (r0 == 0) goto La0
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r0)
                if (r0 != 0) goto La0
                java.lang.String r0 = "--==-- verify回调进来，已经有结果，直接给开发者回调"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.d(r0, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$i r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.h(r0)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r1 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.g(r1)
                r0.onRewardVerify(r1)
                goto La0
            L49:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r0)
                r4 = -1
                java.lang.String r0 = "--==-- verify回调进来准备请求，但是不能重试"
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L77
                java.lang.String r2 = "--==-- verify回调进来，先进来发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r3 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.a(r2, r3)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.k(r2)
                if (r2 == 0) goto L73
            L6d:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.l(r0)
                goto L96
            L73:
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                goto L96
            L77:
                long r2 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r4)
                long r2 = r2 - r4
                r4 = 2000(0x7d0, double:9.88E-321)
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L96
                java.lang.String r2 = "--==-- verify回调进来，后进来但大于2s，发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.k(r2)
                if (r2 == 0) goto L73
                goto L6d
            L96:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a r0 = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$c$a
                r0.<init>()
                r1 = 3000(0xbb8, double:1.482E-320)
                com.bytedance.msdk.adapter.util.ThreadHelper.postDelayOnMSDKThread(r0, r1)
            La0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.c.run():void");
        }
    }

    class d implements Runnable {
        d() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            if (r7.a.f1348i != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
        
            r7.a.h();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0068, code lost:
        
            if (r7.a.f1348i != false) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r7 = this;
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.b(r0)
                java.lang.String r1 = "GROMORE_SS_REWARD_VERIFY"
                if (r0 == 0) goto L11
                java.lang.String r0 = "--==-- complete回调进来，已经destroy, 直接return"
            Lc:
                com.bytedance.msdk.adapter.util.Logger.d(r1, r0)
                goto L9c
            L11:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.g(r0)
                if (r0 != 0) goto L6b
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r0)
                if (r0 == 0) goto L22
                goto L6b
            L22:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r0)
                r4 = -1
                java.lang.String r0 = "--==-- complete回调进来准备请求，但是不能重试"
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 != 0) goto L4c
                java.lang.String r2 = "--==-- complete回调进来，先进来发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r3 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.a(r2, r3)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.k(r2)
                if (r2 == 0) goto Lc
            L46:
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r0 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.l(r0)
                goto L9c
            L4c:
                long r2 = android.os.SystemClock.elapsedRealtime()
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                long r4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.j(r4)
                long r2 = r2 - r4
                r4 = 2000(0x7d0, double:9.88E-321)
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 <= 0) goto L9c
                java.lang.String r2 = "--==-- complete回调进来，后进来但大于2s，发起请求"
                com.bytedance.msdk.adapter.util.Logger.d(r1, r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.k(r2)
                if (r2 == 0) goto Lc
                goto L46
            L6b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "--==-- complete回调进来，已经有响应("
                r0.append(r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                com.bytedance.msdk.api.reward.RewardItem r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.g(r2)
                if (r2 == 0) goto L7f
                r2 = 1
                goto L80
            L7f:
                r2 = 0
            L80:
                r0.append(r2)
                java.lang.String r2 = ")或已经给出开发者回调("
                r0.append(r2)
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.this
                boolean r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.i(r2)
                r0.append(r2)
                java.lang.String r2 = "), 直接return"
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                goto Lc
            L9c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.d.run():void");
        }
    }

    class e implements RewardItem {
        final /* synthetic */ boolean a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f1356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1357d;

        e(boolean z2, int i2, String str, int i3) {
            this.a = z2;
            this.b = i2;
            this.f1356c = str;
            this.f1357d = i3;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public float getAmount() {
            return this.b;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public Map<String, Object> getCustomData() {
            HashMap map = new HashMap();
            map.put(RewardItem.KEY_IS_GROMORE_SERVER_SIDE_VERIFY, true);
            map.put("transId", a.this.f1354o);
            map.put("reason", Integer.valueOf(this.f1357d));
            map.put("gromoreExtra", (a.this.f1351l == null || a.this.f1351l.getCustomData() == null) ? "" : a.this.f1351l.getCustomData().get("gromoreExtra"));
            map.put("errorCode", Integer.valueOf(a.this.f1349j));
            map.put(RewardItem.KEY_ERROR_MSG, a.this.f1350k);
            GMAdEcpmInfo gMAdEcpmInfoA = p.a(a.this.f1352m, true);
            map.put(RewardItem.KEY_ADN_NAME, gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getAdnName() : "");
            map.put("ecpm", gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getPreEcpm() : "");
            return map;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public String getRewardName() {
            return this.f1356c;
        }

        @Override // com.bytedance.msdk.api.reward.RewardItem
        public boolean rewardVerify() {
            return this.a;
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f1344e != -1 || a.this.f1342c || a.this.f1343d) {
                Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，已经destroy，或者skip，或者比complete/verify回调还晚，直接return");
                return;
            }
            Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen计时到时间，发起请求");
            a.this.h();
            ThreadHelper.postDelayOnMSDKThread(a.this.new h(1), m.ag);
            ThreadHelper.postDelayOnMSDKThread(a.this.new h(2), 6000L);
            ThreadHelper.postDelayOnMSDKThread(a.this.new h(3), 9000L);
        }
    }

    class g extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a {

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a$g$a, reason: collision with other inner class name */
        class RunnableC0036a implements Runnable {
            final /* synthetic */ bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b a;

            RunnableC0036a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar) {
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a(this.a);
            }
        }

        class b implements Runnable {
            final /* synthetic */ IOException a;

            b(g gVar, IOException iOException) {
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide verify http error: " + this.a.toString());
            }
        }

        g() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b bVar2) {
            ThreadHelper.runOnMSDKThread(new RunnableC0036a(bVar2));
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.a
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.b bVar, IOException iOException) {
            ThreadHelper.runOnMSDKThread(new b(this, iOException));
        }
    }

    private class h implements Runnable {
        private final int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f1345f != null || a.this.f1347h || !a.this.f1348i || a.this.f1342c || a.this.f1343d) {
                return;
            }
            Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- ServerSide reward verify 进行第" + this.a + "次重试请求");
            a.this.h();
        }
    }

    public interface i {
        void onRewardVerify(RewardItem rewardItem);
    }

    public a(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c cVarC;
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d dVarF = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f();
        if (dVarF != null && (cVarC = dVarF.c(str)) != null) {
            this.a = cVarC.w();
            this.b = cVarC.v();
        }
        if (this.a < 0) {
            this.a = 15000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00db A[Catch: JSONException -> 0x0137, TryCatch #3 {JSONException -> 0x0137, blocks: (B:8:0x0011, B:10:0x003f, B:11:0x0043, B:12:0x0048, B:14:0x004c, B:16:0x0052, B:18:0x007b, B:22:0x0085, B:44:0x00db, B:46:0x0118, B:48:0x011c, B:50:0x0120, B:27:0x0096, B:29:0x00b1, B:41:0x00d5, B:24:0x008f), top: B:63:0x0011, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b r13) {
        /*
            Method dump skipped, instruction units count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.b):void");
    }

    private String f() {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version", "3.9.0.2");
            jSONObject.put("user_agent", com.bytedance.msdk.base.b.b);
            jSONObject.put("network", z.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
            jSONObject.put("play_start_ts", this.f1353n);
            jSONObject.put("play_end_ts", System.currentTimeMillis());
            jSONObject.put("user_id", this.f1351l != null ? this.f1351l.getUserID() : "");
            if (TextUtils.isEmpty(this.f1354o)) {
                string = UUID.randomUUID().toString();
                this.f1354o = string;
            } else {
                string = this.f1354o;
            }
            jSONObject.put("trans_id", string);
            jSONObject.put("link_id", this.f1351l != null ? this.f1351l.getLinkedId() : "");
            jSONObject.put("prime_rit", this.f1351l != null ? this.f1351l.getAdUnitId() : "");
            jSONObject.put("adn_rit", this.f1352m != null ? this.f1352m.getAdNetworkSlotId() : "");
            jSONObject.put("reward_name", this.f1351l != null ? this.f1351l.getRewardName() : "");
            jSONObject.put("reward_amount", this.f1351l != null ? this.f1351l.getRewardAmount() : 0);
            jSONObject.put("media_extra", (this.f1351l == null || this.f1351l.getCustomData() == null) ? "" : this.f1351l.getCustomData().get("gromoreExtra"));
            if (this.f1351l != null && this.f1351l.getScenarioId() != null) {
                jSONObject.put("scenario_id", this.f1351l.getScenarioId());
            }
            GMAdEcpmInfo gMAdEcpmInfoA = p.a(this.f1352m, true);
            jSONObject.put("adn_name", gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getAdnName() : "");
            jSONObject.put("ecpm", gMAdEcpmInfoA != null ? gMAdEcpmInfoA.getPreEcpm() : "");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return m0.a(jSONObject).toString();
    }

    private void g() {
        Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- showListen回调进来，开始计时");
        ThreadHelper.postDelayOnMSDKThread(new f(), this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_if122.c cVarC = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.b().a().c();
        cVarC.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c.f());
        String strQ = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.J().q();
        if (!TextUtils.isEmpty(strQ)) {
            cVarC.a("X-Tt-Env", strQ);
            cVarC.a("x-use-ppe", "1");
        }
        cVarC.a("User-Agent", com.bytedance.msdk.base.b.b);
        cVarC.c(f());
        cVarC.a(new g());
    }

    public void a() {
        ThreadHelper.runOnMSDKThread(new b());
    }

    public void a(i iVar) {
        this.f1355p = iVar;
    }

    public void a(AdSlot adSlot, TTBaseAd tTBaseAd) {
        this.f1353n = System.currentTimeMillis();
        this.f1351l = adSlot;
        this.f1352m = tTBaseAd;
        g();
    }

    public boolean b() {
        boolean z2 = this.b == 1;
        Logger.d("GROMORE_SS_REWARD_VERIFY", "--==-- 判断是否开启了M服务端激励验证： " + z2);
        return z2;
    }

    public void c() {
        ThreadHelper.runOnMSDKThread(new RunnableC0033a());
    }

    public void d() {
        ThreadHelper.runOnMSDKThread(new c());
    }

    public void e() {
        ThreadHelper.runOnMSDKThread(new d());
    }
}
