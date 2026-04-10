package com.amgcyo.cuttadon.h.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.amgcyo.cuttadon.api.entity.other.RewardAdParam;
import com.amgcyo.cuttadon.f.s.a;
import com.amgcyo.cuttadon.sdk.ui.OwnerRewardFullVideoActivity;
import java.util.Random;

/* JADX INFO: compiled from: RewardVideoUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: RewardVideoUtil.java */
    private static class b {
        private static final i a = new i();
    }

    public static i a() {
        return b.a;
    }

    private void a(String str) {
    }

    private i() {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(Context context, final RewardAdParam rewardAdParam, final com.amgcyo.cuttadon.h.f.c cVar) {
        if (context == null || rewardAdParam == null) {
            a("context==null||adParam==null");
            return;
        }
        final String platform = rewardAdParam.getPlatform();
        if (TextUtils.isEmpty(platform)) {
            a("platform is null");
            return;
        }
        byte b2 = -1;
        switch (platform.hashCode()) {
            case -103418728:
                if (platform.equals("gdt_new")) {
                    b2 = 2;
                }
                break;
            case 3302:
                if (platform.equals("gm")) {
                    b2 = 3;
                }
                break;
            case 3432:
                if (platform.equals("ks")) {
                    b2 = 1;
                }
                break;
            case 3526476:
                if (platform.equals("self")) {
                    b2 = 5;
                }
                break;
            case 570658005:
                if (platform.equals("topon_new")) {
                    b2 = 4;
                }
                break;
            case 1061735899:
                if (platform.equals("csj_new")) {
                    b2 = 0;
                }
                break;
        }
        if (b2 == 0) {
            d.c().a(context, rewardAdParam, cVar);
            return;
        }
        if (b2 == 1) {
            g.c().a(context, rewardAdParam, cVar);
            return;
        }
        if (b2 == 2) {
            e.c().a(context, rewardAdParam, cVar);
            return;
        }
        if (b2 == 3) {
            f.a().a((Activity) context, rewardAdParam, cVar);
            return;
        }
        if (b2 == 4) {
            j.c().a(context, rewardAdParam, cVar);
        } else {
            if (b2 != 5) {
                return;
            }
            Intent intent = new Intent(context, (Class<?>) OwnerRewardFullVideoActivity.class);
            intent.putExtra("key_txmoney", rewardAdParam.getStyle());
            intent.putExtra("ltype", rewardAdParam.isNoExempt());
            com.amgcyo.cuttadon.f.s.a.c((Activity) context).startActivityForResult(intent, new a.InterfaceC0088a() { // from class: com.amgcyo.cuttadon.h.g.b
                @Override // com.amgcyo.cuttadon.f.s.a.InterfaceC0088a
                public final void a(int i2, Intent intent2) {
                    i.a(cVar, rewardAdParam, platform, i2, intent2);
                }
            });
        }
    }

    static /* synthetic */ void a(final com.amgcyo.cuttadon.h.f.c cVar, RewardAdParam rewardAdParam, String str, int i2, Intent intent) {
        if (cVar == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("data:");
        sb.append(intent == null);
        sb.toString();
        final String adPosition = rewardAdParam.getAdPosition();
        if (intent == null) {
            cVar.onRewardAdFail(-1, "参数异常！", str, adPosition);
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("LocalMp3Bean", false);
        String str2 = "isTimeFinish:" + booleanExtra;
        if (booleanExtra) {
            h hVar = new h();
            hVar.f3979c = new Random().nextInt(100);
            hVar.a = str + "激励视频广告获取激励";
            hVar.b = adPosition;
            hVar.f3980d = false;
            cVar.onRewardAdSuccess(hVar);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.amgcyo.cuttadon.h.g.a
                @Override // java.lang.Runnable
                public final void run() {
                    cVar.onRewardAdClose(adPosition);
                }
            }, 1000L);
            return;
        }
        String stringExtra = intent.getStringExtra("title");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = "获取奖励失败！";
        }
        cVar.onRewardAdFail(-2, stringExtra, str, adPosition);
    }
}
