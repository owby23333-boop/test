package com.funny.audio;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.core.utils.MiscUtils;
import com.funny.audio.models.GroupInfo;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.UMConfigure;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010,\u001a\u00020-2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010.\u001a\u00020-R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/funny/audio/AppManager;", "", "()V", "appChannel", "", "getAppChannel", "()Ljava/lang/String;", "setAppChannel", "(Ljava/lang/String;)V", "appKey", "getAppKey", "setAppKey", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "groupInfo", "Lcom/funny/audio/models/GroupInfo;", "getGroupInfo", "()Lcom/funny/audio/models/GroupInfo;", "setGroupInfo", "(Lcom/funny/audio/models/GroupInfo;)V", "isNightMode", "", "()Z", "setNightMode", "(Z)V", "mainActivity", "Landroid/app/Activity;", "getMainActivity", "()Landroid/app/Activity;", "setMainActivity", "(Landroid/app/Activity;)V", "psign", "getPsign", "setPsign", AnalyticsConfig.RTD_START_TIME, "", "getStartTime", "()J", "setStartTime", "(J)V", "init", "", "initStatistics", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppManager {
    private static Application context;
    private static GroupInfo groupInfo;
    private static boolean isNightMode;
    private static Activity mainActivity;
    private static String psign;
    private static long startTime;
    public static final AppManager INSTANCE = new AppManager();
    private static String appKey = "";
    private static String appChannel = "";

    private AppManager() {
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final Activity getMainActivity() {
        return mainActivity;
    }

    public final void setMainActivity(Activity activity) {
        mainActivity = activity;
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

    public final boolean isNightMode() {
        return isNightMode;
    }

    public final void setNightMode(boolean z) {
        isNightMode = z;
    }

    public final String getPsign() {
        return psign;
    }

    public final void setPsign(String str) {
        psign = str;
    }

    public final GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public final void setGroupInfo(GroupInfo groupInfo2) {
        groupInfo = groupInfo2;
    }

    public final long getStartTime() {
        return startTime;
    }

    public final void setStartTime(long j) {
        startTime = j;
    }

    public final void init(Application context2) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        Application application = context2;
        String packageName = MiscUtils.getPackageName(application);
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(context)");
        appKey = packageName;
        appChannel = DeviceUtils.INSTANCE.getAppChannel(application);
        psign = DeviceUtils.INSTANCE.getPESign(application);
        startTime = System.currentTimeMillis();
        initStatistics();
    }

    public final void initStatistics() throws PackageManager.NameNotFoundException {
        Application application = context;
        Intrinsics.checkNotNull(application);
        PackageManager packageManager = application.getPackageManager();
        Application application2 = context;
        Intrinsics.checkNotNull(application2);
        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(application2.getPackageName(), 128);
        Intrinsics.checkNotNullExpressionValue(applicationInfo, "context!!.packageManager…ageManager.GET_META_DATA)");
        String string = applicationInfo.metaData.getString("UMENG_APPKEY");
        String string2 = applicationInfo.metaData.getString("UMENG_CHANNEL");
        Application application3 = context;
        Intrinsics.checkNotNull(application3);
        UMConfigure.preInit(application3, string, string2);
        Application application4 = context;
        Intrinsics.checkNotNull(application4);
        UMConfigure.init(application4, string, string2, 1, "");
    }
}
