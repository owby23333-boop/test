package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdInfo;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.j;
import com.anythink.core.common.b.n;
import com.anythink.core.common.v;
import com.anythink.rewardvideo.api.ATRewardVideoAutoEventListener;
import com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile d f12727c;
    String a = "RewardVideoAuto";
    ATRewardVideoAutoLoadListener b = new ATRewardVideoAutoLoadListener() { // from class: com.anythink.rewardvideo.a.d.1
        @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
        public final void onRewardVideoAutoLoadFail(final String str, final AdError adError) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.d.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.f12728d != null) {
                        d.this.f12728d.onRewardVideoAutoLoadFail(str, adError);
                    }
                }
            });
        }

        @Override // com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener
        public final void onRewardVideoAutoLoaded(final String str) {
            n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.d.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (d.this.f12728d != null) {
                        d.this.f12728d.onRewardVideoAutoLoaded(str);
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ATRewardVideoAutoLoadListener f12728d;

    public static void b(String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                v.a().a(str, false);
                a.a(n.a().g(), str).k();
            }
        }
    }

    private ATAdStatusInfo d(String str) {
        a aVarA;
        if (n.a().g() == null || TextUtils.isEmpty(n.a().p()) || TextUtils.isEmpty(n.a().q()) || (aVarA = a.a(n.a().E(), str)) == null) {
            return null;
        }
        return aVarA.a(n.a().E(), (Map<String, Object>) null);
    }

    public final List<ATAdInfo> c(String str) {
        a aVarA;
        if (TextUtils.isEmpty(str) || (aVarA = a.a(n.a().E(), str)) == null) {
            return null;
        }
        return aVarA.a(n.a().E());
    }

    public static d a() {
        if (f12727c == null) {
            synchronized (d.class) {
                if (f12727c == null) {
                    f12727c = new d();
                }
            }
        }
        return f12727c;
    }

    public final ATAdStatusInfo b(String str) {
        ATAdStatusInfo aTAdStatusInfo;
        if (TextUtils.isEmpty(str) || (aTAdStatusInfo = d(str)) == null) {
            aTAdStatusInfo = new ATAdStatusInfo(false, false, null);
        }
        com.anythink.core.common.k.n.b(str, g.i.f6869o, g.i.f6875u, aTAdStatusInfo.toString(), "");
        return aTAdStatusInfo;
    }

    public final void a(Context context, String[] strArr, ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener) {
        if (context instanceof Activity) {
            n.a().a((Activity) context);
        }
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str) && !v.a().f(str)) {
                    v.a().a(str, true);
                    a.a(context, str).a(context, 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        }
        this.f12728d = aTRewardVideoAutoLoadListener;
    }

    private ATRewardVideoAutoLoadListener b() {
        return this.b;
    }

    public static void a(String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && !v.a().f(str)) {
                v.a().a(str, true);
                a.a(n.a().E(), str).a(n.a().E(), 3, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
            }
        }
    }

    public static void a(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        v.a().a(str, map);
    }

    private void a(Activity activity, String str, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        a(activity, str, "", aTRewardVideoAutoEventListener);
    }

    public final void a(Activity activity, String str, String str2, ATRewardVideoAutoEventListener aTRewardVideoAutoEventListener) {
        com.anythink.core.common.k.n.b(str, g.i.f6869o, g.i.f6873s, g.i.f6862h, "");
        if (TextUtils.isEmpty(str)) {
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.exception, "", "placementId is empty.");
            if (aTRewardVideoAutoEventListener != null) {
                aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(errorCode, j.a((com.anythink.core.common.b.d) null));
            }
        }
        if (n.a().g() != null && !TextUtils.isEmpty(n.a().p()) && !TextUtils.isEmpty(n.a().q())) {
            a.a(activity, str).a(activity, str2, new c(aTRewardVideoAutoEventListener), (ATEventInterface) null, (Map<String, Object>) null);
            return;
        }
        AdError errorCode2 = ErrorCode.getErrorCode(ErrorCode.exception, "", "sdk init error");
        if (aTRewardVideoAutoEventListener != null) {
            aTRewardVideoAutoEventListener.onRewardedVideoAdPlayFailed(errorCode2, j.a((com.anythink.core.common.b.d) null));
        }
    }

    public final boolean a(String str) {
        boolean zIsReady = false;
        if (!TextUtils.isEmpty(str)) {
            ATAdStatusInfo aTAdStatusInfoD = d(str);
            if (aTAdStatusInfoD == null) {
                return false;
            }
            zIsReady = aTAdStatusInfoD.isReady();
        }
        com.anythink.core.common.k.n.b(str, g.i.f6869o, g.i.f6874t, String.valueOf(zIsReady), "");
        return zIsReady;
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        n.a().a(str, str2, "1", map);
    }
}
