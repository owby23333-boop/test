package com.funny.audio.core.utils;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.webkit.WebSettings;
import com.github.gzuliyujiang.oaid.DeviceIdentifier;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.d;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0015R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/funny/audio/core/utils/DeviceUtils;", "", "()V", "_apkSize", "", "_channel", "_ipAddress", "_peSignMD5", "_ssign", "_userAgent", ar.i, "getApkSize", "getAppChannel", d.R, "Landroid/content/Context;", "getDeviceUUID", "getIpAddress", "getPESign", "getUserAgent", "init", "", "Landroid/app/Application;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static String _apkSize;
    private static String _channel;
    private static String _ipAddress;
    private static String _peSignMD5;
    private static String _ssign;
    private static String _userAgent;
    private static String _uuid;

    public static final String getApkSize() {
        return "35288721";
    }

    public final String getPESign(Context context) {
        return "9f05e35446d7d6d886ecafdf7d689db2";
    }

    private DeviceUtils() {
    }

    public final void init(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DeviceIdentifier.register(context);
    }

    public final String getDeviceUUID(Context context) {
        String str = _uuid;
        if (str == null || str.length() == 0) {
            _uuid = DeviceIdentifier.getClientId();
        }
        String str2 = _uuid;
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public final String getIpAddress(Context context) {
        String str = _ipAddress;
        if (str == null || str.length() == 0) {
            if (context == null) {
                return "0.0.0.0";
            }
            _ipAddress = NetWorkUtils.getIpAddressDesc(context);
        }
        String str2 = _ipAddress;
        if (str2 == null) {
            return "0.0.0.0";
        }
        Intrinsics.checkNotNull(str2);
        return str2;
    }

    public final String getAppChannel(Context context) throws PackageManager.NameNotFoundException {
        String str = _channel;
        if (str == null || str.length() == 0) {
            if (context != null) {
                String str2 = _channel;
                if (str2 == null || str2.length() == 0) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                    Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.g…ATA\n                    )");
                    _channel = applicationInfo.metaData.getString("UMENG_CHANNEL");
                }
            }
            String str3 = _channel;
            if (str3 == null || str3.length() == 0) {
                _channel = "normal";
            }
        }
        String str4 = _channel;
        Intrinsics.checkNotNull(str4);
        return str4;
    }

    public final String getUserAgent(Context context) {
        String property;
        Intrinsics.checkNotNullParameter(context, "context");
        String str = _userAgent;
        if (str != null) {
            return str;
        }
        try {
            property = WebSettings.getDefaultUserAgent(context);
        } catch (Exception unused) {
            property = System.getProperty("http.agent");
        }
        Intrinsics.checkNotNullExpressionValue(property, "{\n            try {\n    …)\n            }\n        }");
        StringBuffer stringBuffer = new StringBuffer();
        int length = property.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = property.charAt(i);
            if (Intrinsics.compare((int) cCharAt, 31) <= 0 || Intrinsics.compare((int) cCharAt, 127) >= 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str2 = String.format("\\u%04x", Arrays.copyOf(new Object[]{Integer.valueOf(cCharAt)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                stringBuffer.append(str2);
            } else {
                stringBuffer.append(cCharAt);
            }
        }
        String string = stringBuffer.toString();
        _userAgent = string;
        return string;
    }
}
