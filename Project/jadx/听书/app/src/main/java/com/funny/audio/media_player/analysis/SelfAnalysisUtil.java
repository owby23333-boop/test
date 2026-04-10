package com.funny.audio.media_player.analysis;

import android.app.Application;
import com.funny.audio.AppManager;
import com.funny.audio.ad.AdManager;
import com.funny.audio.ad.AdSetting;
import com.funny.audio.api.AddressSetting;
import com.funny.audio.core.net.CryptoLib;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.core.utils.MiscUtils;
import com.funny.audio.models.AlbumTrackAnalysisInfo;
import com.funny.audio.user.UserManager;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import java.net.URI;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SelfAnalysisUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/media_player/analysis/SelfAnalysisUtil;", "", "()V", "analysis", "Lcom/funny/audio/media_player/analysis/AnalysisResult;", "analysisInfo", "Lcom/funny/audio/models/AlbumTrackAnalysisInfo;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SelfAnalysisUtil {
    public static final SelfAnalysisUtil INSTANCE = new SelfAnalysisUtil();

    private SelfAnalysisUtil() {
    }

    public final AnalysisResult analysis(AlbumTrackAnalysisInfo analysisInfo) {
        String string;
        String deviceUUID;
        String psign;
        Intrinsics.checkNotNullParameter(analysisInfo, "analysisInfo");
        AnalysisResult analysisResult = new AnalysisResult();
        if (StringsKt.startsWith$default(analysisInfo.getAccessPath(), "http", false, 2, (Object) null)) {
            string = analysisInfo.getAccessPath();
        } else {
            string = new URI(AddressSetting.INSTANCE.getCurrent().getTrackResource().getValue()).resolve(analysisInfo.getAccessPath()).toString();
            Intrinsics.checkNotNullExpressionValue(string, "{\n            val baseUr…ath).toString()\n        }");
        }
        analysisResult.setUrl(string);
        HashMap map = new HashMap();
        Application context = AppManager.INSTANCE.getContext();
        Intrinsics.checkNotNull(context);
        Application application = context;
        String appVersion = MiscUtils.getAppVersion(application);
        Integer appVersionCode = MiscUtils.getAppVersionCode(application);
        if (UserManager.INSTANCE.isLogin()) {
            deviceUUID = UserManager.INSTANCE.getUserId();
        } else {
            deviceUUID = DeviceUtils.INSTANCE.getDeviceUUID(application);
        }
        HashMap map2 = map;
        map2.put("appKey", AppManager.INSTANCE.getAppKey());
        map2.put("appChannel", AppManager.INSTANCE.getAppChannel());
        Intrinsics.checkNotNullExpressionValue(appVersion, "appVersion");
        map2.put("version", appVersion);
        map2.put(DefaultUpdateParser.APIKeyLower.VERSION_CODE, String.valueOf(appVersionCode));
        if (AppManager.INSTANCE.getPsign() == null) {
            psign = "";
        } else {
            psign = AppManager.INSTANCE.getPsign();
            Intrinsics.checkNotNull(psign);
        }
        map2.put("psign", psign);
        map2.put("initStatus", String.valueOf(AdManager.INSTANCE.getInitSuccess()));
        AdSetting setting = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting);
        map2.put("freeTime", String.valueOf(setting.getFreeTime().getValueLong()));
        AdSetting setting2 = AdManager.INSTANCE.getSetting();
        Intrinsics.checkNotNull(setting2);
        map2.put("rewardTime", String.valueOf(setting2.getRewardTime().getValueLong()));
        map2.put("userId", deviceUUID);
        map2.put("clientTime", String.valueOf(System.currentTimeMillis()));
        map2.put("sTime", String.valueOf(AppManager.INSTANCE.getStartTime()));
        String path = new URI(analysisResult.getUrl()).getPath();
        Intrinsics.checkNotNullExpressionValue(path, "URI(result.url).path");
        String strTrimStart = StringsKt.trimStart(path, '/');
        map2.put("sign1", CryptoLib.INSTANCE.getSign2(strTrimStart));
        map2.put("sign2", CryptoLib.INSTANCE.getSign4(strTrimStart));
        CryptoLib cryptoLib = CryptoLib.INSTANCE;
        Object obj = map.get("clientTime");
        Intrinsics.checkNotNull(obj);
        map2.put("sign3", cryptoLib.getSign5((String) obj));
        analysisResult.setHeaders(map2);
        analysisResult.setSuccess(true);
        return analysisResult;
    }
}
