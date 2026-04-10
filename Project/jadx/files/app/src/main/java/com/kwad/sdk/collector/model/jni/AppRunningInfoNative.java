package com.kwad.sdk.collector.model.jni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    private static SimpleDateFormat aaR = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public AppRunningInfoNative(long j2) {
        this.mPtr = j2;
    }

    public AppRunningInfoNative(long j2, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j2, str, str2);
    }

    private static String H(long j2) {
        return aaR.format(new Date(j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative);
        if (jAppRunningInfoGetLastRunningTime == 0) {
            return 0;
        }
        return jAppRunningInfoGetLastRunningTime > 0 ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* JADX INFO: renamed from: tW, reason: merged with bridge method [inline-methods] */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j2 = this.mPtr;
        if (j2 != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j2);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AppRunningInfoNative.class != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long jAppRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (jAppRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String strAppRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String strAppRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (jAppRunningInfoGetGranularity == 0) {
            jAppRunningInfoGetGranularity = 1;
        }
        if (jAppRunningInfoGetLastRunningTime / jAppRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / jAppRunningInfoGetGranularity && strAppRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return strAppRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long jAppRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (jAppRunningInfoGetGranularity == 0) {
            jAppRunningInfoGetGranularity = 1;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / jAppRunningInfoGetGranularity;
        return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (jAppRunningInfoGetLastRunningTime ^ (jAppRunningInfoGetLastRunningTime >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        s.putValue(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
        s.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + H(c.c(this)) + '}';
    }
}
