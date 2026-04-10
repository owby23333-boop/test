package com.funny.audio.core.net;

import android.app.Application;
import android.content.pm.PackageManager;
import com.funny.audio.AppManager;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.core.utils.MiscUtils;
import com.funny.audio.core.utils.NetWorkUtils;
import com.funny.audio.user.UserManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/* JADX INFO: compiled from: HeaderInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/funny/audio/core/net/HeaderInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HeaderInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public okhttp3.Response intercept(Interceptor.Chain chain) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        HttpUrl httpUrlUrl = request.url();
        Application context = AppManager.INSTANCE.getContext();
        Intrinsics.checkNotNull(context);
        Application application = context;
        String appId = MiscUtils.getPackageName(application);
        String appVersion = MiscUtils.getAppVersion(application);
        Integer appVersionCode = MiscUtils.getAppVersionCode(application);
        String brand = MiscUtils.getManufacturer(application);
        String deviceUUID = DeviceUtils.INSTANCE.getDeviceUUID(application);
        String networkType = NetWorkUtils.getNetworkTypeDesc(application);
        String ipAddress = DeviceUtils.INSTANCE.getIpAddress(application);
        long jCurrentTimeMillis = System.currentTimeMillis();
        String userId = UserManager.INSTANCE.getUserId();
        String appChannel = DeviceUtils.INSTANCE.getAppChannel(application);
        String systemVersion = MiscUtils.getSystemVersion();
        Request.Builder builderUrl = request.newBuilder().url(httpUrlUrl);
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        Request.Builder builderAddHeader = builderUrl.addHeader("appId", appId).addHeader("appChannel", appChannel).addHeader("appVersion", String.valueOf(appVersionCode));
        Intrinsics.checkNotNullExpressionValue(appVersion, "appVersion");
        Request.Builder builderAddHeader2 = builderAddHeader.addHeader("appVersionName", appVersion);
        Intrinsics.checkNotNullExpressionValue(brand, "brand");
        Request.Builder builderAddHeader3 = builderAddHeader2.addHeader("deviceBrand", brand).addHeader("deviceName", "").addHeader("deviceUuid", deviceUUID).addHeader("deviceId", deviceUUID).addHeader("deviceMac", "").addHeader("deviceIMEI", "").addHeader("deviceIMSI", "").addHeader("deviceOS", "Android");
        Intrinsics.checkNotNullExpressionValue(systemVersion, "systemVersion");
        Request.Builder builderAddHeader4 = builderAddHeader3.addHeader("deviceOSVersion", systemVersion);
        Intrinsics.checkNotNullExpressionValue(networkType, "networkType");
        return chain.proceed(builderAddHeader4.addHeader("networkType", networkType).addHeader("networkIp", ipAddress).addHeader("time", String.valueOf(jCurrentTimeMillis)).addHeader("userId", userId).addHeader("sign", CryptoLib.INSTANCE.getSign1(jCurrentTimeMillis + appId + appVersionCode)).build());
    }
}
