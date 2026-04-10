package com.kwad.components.ad.reward.model;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.KSRewardVideoActivityProxy;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.s;
import java.io.File;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private JSONObject mReportExtData;
    public int mScreenOrientation;
    private KsVideoPlayConfig mVideoPlayConfig;
    private int rewardType = 1;

    @Nullable
    private static c a(AdTemplate adTemplate, @Nullable AdTemplate adTemplate2, int i2, KsVideoPlayConfig ksVideoPlayConfig) {
        File fileAN;
        c cVar = new c();
        AdInfo adInfoCb = d.cb(adTemplate);
        String strE = com.kwad.sdk.core.response.a.a.E(adInfoCb);
        if (com.kwad.sdk.core.config.d.uJ() < 0 && ((fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(strE)) == null || !fileAN.exists())) {
            return null;
        }
        boolean zIsShowLandscape = ksVideoPlayConfig.isShowLandscape();
        adTemplate.mInitVoiceStatus = ksVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        if (!TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
            cVar.mReportExtData = jSONObject;
        }
        cVar.mVideoPlayConfig = ksVideoPlayConfig;
        cVar.mAdTemplate = adTemplate;
        cVar.mAdInfo = adInfoCb;
        cVar.mScreenOrientation = zIsShowLandscape ? 1 : 0;
        cVar.rewardType = i2;
        cVar.mAdTemplate.mPlayAgain = adTemplate2;
        return cVar;
    }

    @Nullable
    public static c c(Intent intent) {
        AdTemplate adTemplate;
        Serializable serializableExtra = intent.getSerializableExtra("key_video_play_config");
        if (!(serializableExtra instanceof KsVideoPlayConfig)) {
            com.kwad.sdk.core.d.b.e("RewardActivityModel", "data is not instanceof VideoPlayConfigImpl:" + serializableExtra);
            return null;
        }
        KsVideoPlayConfig ksVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
        int intExtra = intent.getIntExtra(KSRewardVideoActivityProxy.KEY_REWARD_TYPE, 1);
        String stringExtra = intent.getStringExtra("key_template_json");
        try {
            AdTemplate adTemplate2 = new AdTemplate();
            adTemplate2.parseJson(new JSONObject(stringExtra));
            String stringExtra2 = intent.getStringExtra(KSRewardVideoActivityProxy.KEY_TEMPLATE_PLAY_AGAIN);
            if (stringExtra2 != null) {
                adTemplate = new AdTemplate();
                adTemplate.parseJson(new JSONObject(stringExtra2));
            } else {
                adTemplate = null;
            }
            return a(adTemplate2, adTemplate, intExtra, ksVideoPlayConfig);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            return null;
        }
    }

    public final AdInfo bK() {
        return this.mAdInfo;
    }

    public final boolean bL() {
        return d.cn(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    public final int getScreenOrientation() {
        return this.mScreenOrientation;
    }

    public final boolean hB() {
        return d.g(getAdTemplate(), com.kwad.components.ad.reward.kwai.b.l(bK()));
    }

    public final boolean hC() {
        return d.q(getAdTemplate());
    }

    public final KsVideoPlayConfig hD() {
        return this.mVideoPlayConfig;
    }

    public final int hE() {
        return this.rewardType;
    }

    public final JSONObject hF() {
        return this.mReportExtData;
    }

    public final void x(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = d.cb(adTemplate);
    }
}
