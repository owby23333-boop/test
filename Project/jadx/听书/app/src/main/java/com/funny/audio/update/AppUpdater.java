package com.funny.audio.update;

import android.app.Application;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.core.utils.FileUtils;
import com.funny.audio.core.utils.MiscUtils;
import com.funny.audio.models.CloudUpdateInfo;
import com.umeng.analytics.pro.d;
import com.xuexiang.xupdate.XUpdate;
import com.xuexiang.xupdate._XUpdate;
import java.io.File;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: AppUpdater.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010%2\b\b\u0002\u0010-\u001a\u00020+J\u000e\u0010.\u001a\u00020/2\u0006\u0010\f\u001a\u00020\rJ\u000e\u00100\u001a\u00020/2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u0004\u0018\u00010%R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00064"}, d2 = {"Lcom/funny/audio/update/AppUpdater;", "", "()V", "appChannel", "", "getAppChannel", "()Ljava/lang/String;", "setAppChannel", "(Ljava/lang/String;)V", "appKey", "getAppKey", "setAppKey", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "getUpdateInfoInternal", "", "getGetUpdateInfoInternal", "()J", "setGetUpdateInfoInternal", "(J)V", "http", "Lokhttp3/OkHttpClient;", "getHttp", "()Lokhttp3/OkHttpClient;", "setHttp", "(Lokhttp3/OkHttpClient;)V", "lastGetUpdateInfoTime", "getLastGetUpdateInfoTime", "setLastGetUpdateInfoTime", "shareAppUrl", "getShareAppUrl", "setShareAppUrl", "updateInfo", "Lcom/funny/audio/models/CloudUpdateInfo;", "getUpdateInfo", "()Lcom/funny/audio/models/CloudUpdateInfo;", "setUpdateInfo", "(Lcom/funny/audio/models/CloudUpdateInfo;)V", "hasUpdate", "", "update", "constraint", "init", "", "install", FileUtils.URI_TYPE_FILE, "Ljava/io/File;", "loadUpdateInfo", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppUpdater {
    private static Application context;
    private static long getUpdateInfoInternal;
    private static OkHttpClient http;
    private static long lastGetUpdateInfoTime;
    private static CloudUpdateInfo updateInfo;
    public static final AppUpdater INSTANCE = new AppUpdater();
    private static String appKey = "";
    private static String appChannel = "";
    private static String shareAppUrl = "";

    private AppUpdater() {
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    static {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(20L, TimeUnit.SECONDS);
        builder.readTimeout(20L, TimeUnit.SECONDS);
        builder.writeTimeout(10L, TimeUnit.SECONDS);
        builder.proxy(Proxy.NO_PROXY);
        http = builder.build();
        getUpdateInfoInternal = 1200000L;
    }

    public final String getAppKey() {
        return appKey;
    }

    public final void setAppKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        appKey = str;
    }

    public final String getAppChannel() {
        return appChannel;
    }

    public final void setAppChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        appChannel = str;
    }

    public final CloudUpdateInfo getUpdateInfo() {
        return updateInfo;
    }

    public final void setUpdateInfo(CloudUpdateInfo cloudUpdateInfo) {
        updateInfo = cloudUpdateInfo;
    }

    public final String getShareAppUrl() {
        return shareAppUrl;
    }

    public final void setShareAppUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        shareAppUrl = str;
    }

    public final OkHttpClient getHttp() {
        return http;
    }

    public final void setHttp(OkHttpClient okHttpClient) {
        Intrinsics.checkNotNullParameter(okHttpClient, "<set-?>");
        http = okHttpClient;
    }

    public final long getLastGetUpdateInfoTime() {
        return lastGetUpdateInfoTime;
    }

    public final void setLastGetUpdateInfoTime(long j) {
        lastGetUpdateInfoTime = j;
    }

    public final long getGetUpdateInfoInternal() {
        return getUpdateInfoInternal;
    }

    public final void setGetUpdateInfoInternal(long j) {
        getUpdateInfoInternal = j;
    }

    public final void init(Application context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        Application application = context2;
        String packageName = MiscUtils.getPackageName(application);
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(context)");
        appKey = packageName;
        appChannel = DeviceUtils.INSTANCE.getAppChannel(application);
        XUpdate.get().init(context2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.funny.audio.models.CloudUpdateInfo loadUpdateInfo() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = com.funny.audio.update.AppUpdater.lastGetUpdateInfoTime
            long r0 = r0 - r2
            long r2 = com.funny.audio.update.AppUpdater.getUpdateInfoInternal
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L10
            com.funny.audio.models.CloudUpdateInfo r0 = com.funny.audio.update.AppUpdater.updateInfo
            return r0
        L10:
            java.lang.String r0 = com.funny.audio.update.AppUpdater.appKey
            java.lang.String r1 = com.funny.audio.update.AppUpdater.appChannel
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L21
            r2 = r3
            goto L22
        L21:
            r2 = r4
        L22:
            if (r2 != 0) goto L60
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            int r2 = r2.length()
            if (r2 != 0) goto L2e
            goto L2f
        L2e:
            r3 = r4
        L2f:
            if (r3 != 0) goto L60
            com.funny.audio.api.ApiManager r2 = com.funny.audio.api.ApiManager.INSTANCE
            com.funny.audio.api.ICloudApi r2 = r2.getCloud()
            com.funny.audio.core.net.Response r1 = r2.getUpdateInfo(r0, r1)
            if (r1 == 0) goto L43
            boolean r2 = com.funny.audio.core.net.NetModelsKt.success(r1)
            if (r2 != 0) goto L4d
        L43:
            com.funny.audio.api.ApiManager r1 = com.funny.audio.api.ApiManager.INSTANCE
            com.funny.audio.api.ICloudApi r1 = r1.getCloud()
            com.funny.audio.core.net.Response r1 = r1.getUpdateInfo(r0)
        L4d:
            if (r1 == 0) goto L55
            boolean r0 = com.funny.audio.core.net.NetModelsKt.success(r1)
            if (r0 != 0) goto L6a
        L55:
            com.funny.audio.api.ApiManager r0 = com.funny.audio.api.ApiManager.INSTANCE
            com.funny.audio.api.ICloudApi r0 = r0.getCloud()
            com.funny.audio.core.net.Response r1 = r0.getUpdateInfo()
            goto L6a
        L60:
            com.funny.audio.api.ApiManager r0 = com.funny.audio.api.ApiManager.INSTANCE
            com.funny.audio.api.ICloudApi r0 = r0.getCloud()
            com.funny.audio.core.net.Response r1 = r0.getUpdateInfo()
        L6a:
            r0 = 0
            if (r1 == 0) goto L97
            boolean r2 = com.funny.audio.core.net.NetModelsKt.success(r1)
            if (r2 == 0) goto L97
            long r2 = java.lang.System.currentTimeMillis()
            com.funny.audio.update.AppUpdater.lastGetUpdateInfoTime = r2
            com.funny.audio.core.net.AppBody r1 = r1.getBody()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Object r1 = r1.getData()
            com.funny.audio.models.CloudUpdateInfo r1 = (com.funny.audio.models.CloudUpdateInfo) r1
            com.funny.audio.update.AppUpdater.updateInfo = r1
            if (r1 == 0) goto L8e
            java.lang.String r0 = r1.getShareHtml()
        L8e:
            if (r0 == 0) goto L96
            java.lang.String r0 = r1.getShareHtml()
            com.funny.audio.update.AppUpdater.shareAppUrl = r0
        L96:
            r0 = r1
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.update.AppUpdater.loadUpdateInfo():com.funny.audio.models.CloudUpdateInfo");
    }

    public static /* synthetic */ boolean hasUpdate$default(AppUpdater appUpdater, CloudUpdateInfo cloudUpdateInfo, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return appUpdater.hasUpdate(cloudUpdateInfo, z);
    }

    public final boolean hasUpdate(CloudUpdateInfo update, boolean constraint) {
        String appVersion;
        if (update == null) {
            return false;
        }
        Integer versionCode = MiscUtils.getAppVersionCode(context);
        Intrinsics.checkNotNullExpressionValue(versionCode, "versionCode");
        if (versionCode.intValue() < update.getLatestVersionCode()) {
            return true;
        }
        return (!constraint || (appVersion = MiscUtils.getAppVersion(context)) == null || update.getLatestVersionName() == null || Intrinsics.areEqual(StringsKt.trimStart(StringsKt.trim((CharSequence) appVersion).toString(), 'v'), StringsKt.trimStart(StringsKt.trim((CharSequence) update.getLatestVersionName()).toString(), 'v'))) ? false : true;
    }

    public final void install(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Application application = context;
        Intrinsics.checkNotNull(application);
        _XUpdate.startInstallApk(application, file);
    }
}
