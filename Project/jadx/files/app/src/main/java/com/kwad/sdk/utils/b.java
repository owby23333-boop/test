package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static int CG() {
        String strDo = x.Do();
        if (TextUtils.isEmpty(strDo)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(strDo);
            int iOptInt = jSONObject.optInt("currentDailyCount");
            if (b(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                return iOptInt;
            }
            return 0;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return 0;
        }
    }

    private static boolean b(long j2, long j3) {
        if (j2 > 0 && j3 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j2)).equals(simpleDateFormat.format(new Date(j3)));
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return false;
    }

    public static StatusInfo.SplashStyleControl c(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl == null || !e(sceneImpl)) {
            return null;
        }
        com.kwad.sdk.internal.api.b bVar = sceneImpl.splashExtraData;
        splashStyleControl.disableShake = bVar.disableShake;
        splashStyleControl.disableRotate = bVar.disableRotate;
        splashStyleControl.disableSlide = bVar.disableSlide;
        return splashStyleControl;
    }

    public static StatusInfo.NativeAdStyleControl d(SceneImpl sceneImpl) {
        NativeAdExtraDataImpl nativeAdExtraDataImpl;
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        if (sceneImpl == null || (nativeAdExtraDataImpl = sceneImpl.nativeAdExtraData) == null) {
            return null;
        }
        nativeAdStyleControl.enableShake = nativeAdExtraDataImpl.enableShake;
        return nativeAdStyleControl;
    }

    private static boolean e(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }
}
