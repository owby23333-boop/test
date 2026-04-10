package com.kwad.sdk.core.track;

import android.text.TextUtils;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.aq;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class AdTrackLog extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final int NEGATIVE_RESULT = 2;
    public static final int POSITIVE_RESULT = 1;
    private static int sLiveSupportMode = 2;
    private static final long serialVersionUID = 6629369763953107007L;
    public int adLiveComponentReady;
    public int adLiveSwitch;
    public int adTkLiveSwitch;
    public String apiSdkVersion;
    public int isPlugin;
    public int preLandingPageShowType;
    public int preLandingPageSwitch;
    public int rewardAdvanceSwitch;
    public int rewardDetailCallPositionY;
    public int rewardDetailStatusBarHeight;
    public int rewardSkipShowTime;
    public String sceneId;
    public int screenOrientation;
    public int serverCheckSwitch;
    public String templateId;

    private int toReportInt(boolean z) {
        return z ? 1 : 2;
    }

    public static AdTrackLog createFromJson(String str) {
        try {
            AdTrackLog adTrackLog = new AdTrackLog();
            adTrackLog.parseJson(new JSONObject(str));
            return adTrackLog;
        } catch (Exception unused) {
            return null;
        }
    }

    private AdTrackLog() {
    }

    public AdTrackLog(String str, String str2) {
        this.templateId = str;
        this.sceneId = str2;
    }

    public void bindABParams(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        AdInfo adInfoEl = e.el(adTemplate);
        this.adLiveComponentReady = toReportInt(((f) ServiceProvider.get(f.class)).qu());
        this.adLiveSwitch = toReportInt(com.kwad.sdk.core.response.b.a.cR(adInfoEl));
        this.adTkLiveSwitch = toReportInt(TextUtils.isEmpty(b.ep(adInfoEl)));
        if (sLiveSupportMode == 2 && ((f) ServiceProvider.get(f.class)).qu()) {
            sLiveSupportMode = 1;
        }
        this.adLiveComponentReady = sLiveSupportMode;
        this.serverCheckSwitch = toReportInt(com.kwad.sdk.core.response.b.a.df(adInfoEl));
        this.rewardAdvanceSwitch = toReportInt(com.kwad.sdk.core.response.b.a.dg(adInfoEl));
        this.rewardSkipShowTime = com.kwad.sdk.core.response.b.a.ae(adInfoEl);
        this.preLandingPageSwitch = toReportInt(b.en(adInfoEl));
        this.preLandingPageShowType = b.eo(adInfoEl);
        this.apiSdkVersion = ((f) ServiceProvider.get(f.class)).getApiVersion();
        this.isPlugin = toReportInt(((f) ServiceProvider.get(f.class)).Bk());
        this.screenOrientation = toReportInt(aq.isOrientationPortrait());
    }
}
