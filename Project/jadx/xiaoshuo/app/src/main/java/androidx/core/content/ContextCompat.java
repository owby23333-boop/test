package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.content.res.ResourcesCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.reader.BaseEnv;
import com.iflytek.aikit.media.speech.SpeechConstant;
import com.xiaomi.onetrack.api.at;
import com.xiaomi.passport.ui.page.UserAvatarUpdateActivity;
import com.yuewen.g72;
import com.yuewen.i8;
import com.yuewen.kl2;
import com.yuewen.rf4;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class ContextCompat {
    private static final String TAG = "ContextCompat";
    private static final Object sLock = new Object();
    private static final Object sSync = new Object();
    private static TypedValue sTempValue;

    @RequiresApi(16)
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void startActivities(Context obj, Intent[] intents, Bundle options) {
            obj.startActivities(intents, options);
        }

        @DoNotInline
        public static void startActivity(Context obj, Intent intent, Bundle options) {
            obj.startActivity(intent, options);
        }
    }

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static File[] getExternalCacheDirs(Context obj) {
            return obj.getExternalCacheDirs();
        }

        @DoNotInline
        public static File[] getExternalFilesDirs(Context obj, String type) {
            return obj.getExternalFilesDirs(type);
        }

        @DoNotInline
        public static File[] getObbDirs(Context obj) {
            return obj.getObbDirs();
        }
    }

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static File getCodeCacheDir(Context obj) {
            return obj.getCodeCacheDir();
        }

        @DoNotInline
        public static Drawable getDrawable(Context obj, int id) {
            return obj.getDrawable(id);
        }

        @DoNotInline
        public static File getNoBackupFilesDir(Context obj) {
            return obj.getNoBackupFilesDir();
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int getColor(Context obj, int id) {
            return obj.getColor(id);
        }

        @DoNotInline
        public static ColorStateList getColorStateList(Context obj, int id) {
            return obj.getColorStateList(id);
        }

        @DoNotInline
        public static <T> T getSystemService(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        @DoNotInline
        public static String getSystemServiceName(Context obj, Class<?> serviceClass) {
            return obj.getSystemServiceName(serviceClass);
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static Context createDeviceProtectedStorageContext(Context obj) {
            return obj.createDeviceProtectedStorageContext();
        }

        @DoNotInline
        public static File getDataDir(Context obj) {
            return obj.getDataDir();
        }

        @DoNotInline
        public static boolean isDeviceProtectedStorage(Context obj) {
            return obj.isDeviceProtectedStorage();
        }
    }

    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        public static ComponentName startForegroundService(Context obj, Intent service2) {
            return obj.startForegroundService(service2);
        }
    }

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static Executor getMainExecutor(Context obj) {
            return obj.getMainExecutor();
        }
    }

    @RequiresApi(30)
    public static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        public static String getAttributionTag(Context obj) {
            return obj.getAttributionTag();
        }
    }

    public static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES;

        static {
            HashMap<Class<?>, String> map = new HashMap<>();
            SERVICES = map;
            map.put(SubscriptionManager.class, "telephony_subscription_service");
            map.put(UsageStatsManager.class, "usagestats");
            map.put(AppWidgetManager.class, "appwidget");
            map.put(BatteryManager.class, "batterymanager");
            map.put(CameraManager.class, UserAvatarUpdateActivity.CAMERA);
            map.put(JobScheduler.class, "jobscheduler");
            map.put(LauncherApps.class, "launcherapps");
            map.put(MediaProjectionManager.class, "media_projection");
            map.put(MediaSessionManager.class, "media_session");
            map.put(RestrictionsManager.class, "restrictions");
            map.put(TelecomManager.class, "telecom");
            map.put(TvInputManager.class, "tv_input");
            map.put(AppOpsManager.class, "appops");
            map.put(CaptioningManager.class, "captioning");
            map.put(ConsumerIrManager.class, "consumer_ir");
            map.put(PrintManager.class, "print");
            map.put(BluetoothManager.class, SpeechConstant.BLUETOOTH);
            map.put(DisplayManager.class, "display");
            map.put(UserManager.class, "user");
            map.put(InputManager.class, rf4.b.n);
            map.put(MediaRouter.class, "media_router");
            map.put(NsdManager.class, "servicediscovery");
            map.put(AccessibilityManager.class, "accessibility");
            map.put(AccountManager.class, "account");
            map.put(ActivityManager.class, TTDownloadField.TT_ACTIVITY);
            map.put(AlarmManager.class, NotificationCompat.CATEGORY_ALARM);
            map.put(AudioManager.class, "audio");
            map.put(ClipboardManager.class, "clipboard");
            map.put(ConnectivityManager.class, "connectivity");
            map.put(DevicePolicyManager.class, "device_policy");
            map.put(DownloadManager.class, i8.o);
            map.put(DropBoxManager.class, "dropbox");
            map.put(InputMethodManager.class, "input_method");
            map.put(KeyguardManager.class, "keyguard");
            map.put(LayoutInflater.class, "layout_inflater");
            map.put(LocationManager.class, "location");
            map.put(NfcManager.class, "nfc");
            map.put(NotificationManager.class, "notification");
            map.put(PowerManager.class, "power");
            map.put(SearchManager.class, "search");
            map.put(SensorManager.class, "sensor");
            map.put(StorageManager.class, BaseEnv.y);
            map.put(TelephonyManager.class, at.d);
            map.put(TextServicesManager.class, "textservices");
            map.put(UiModeManager.class, "uimode");
            map.put(UsbManager.class, "usb");
            map.put(Vibrator.class, "vibrator");
            map.put(WallpaperManager.class, "wallpaper");
            map.put(WifiP2pManager.class, "wifip2p");
            map.put(WifiManager.class, g72.g);
            map.put(WindowManager.class, kl2.t9);
        }

        private LegacyServiceMapHolder() {
        }
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String permission) {
        if (permission != null) {
            return context.checkPermission(permission, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    @Nullable
    public static Context createDeviceProtectedStorageContext(@NonNull Context context) {
        return Api24Impl.createDeviceProtectedStorageContext(context);
    }

    private static File createFilesDir(File file) {
        synchronized (sSync) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                Log.w(TAG, "Unable to create files subdir " + file.getPath());
            }
            return file;
        }
    }

    @Nullable
    public static String getAttributionTag(@NonNull Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.getAttributionTag(context);
        }
        return null;
    }

    public static File getCodeCacheDir(@NonNull Context context) {
        return Api21Impl.getCodeCacheDir(context);
    }

    @ColorInt
    public static int getColor(@NonNull Context context, @ColorRes int id) {
        return Api23Impl.getColor(context, id);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Context context, @ColorRes int id) {
        return ResourcesCompat.getColorStateList(context.getResources(), id, context.getTheme());
    }

    @Nullable
    public static File getDataDir(@NonNull Context context) {
        return Api24Impl.getDataDir(context);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        return Api21Impl.getDrawable(context, id);
    }

    @NonNull
    public static File[] getExternalCacheDirs(@NonNull Context context) {
        return Api19Impl.getExternalCacheDirs(context);
    }

    @NonNull
    public static File[] getExternalFilesDirs(@NonNull Context context, @Nullable String type) {
        return Api19Impl.getExternalFilesDirs(context, type);
    }

    public static Executor getMainExecutor(Context context) {
        return Api28Impl.getMainExecutor(context);
    }

    @Nullable
    public static File getNoBackupFilesDir(@NonNull Context context) {
        return Api21Impl.getNoBackupFilesDir(context);
    }

    @NonNull
    public static File[] getObbDirs(@NonNull Context context) {
        return Api19Impl.getObbDirs(context);
    }

    @Nullable
    public static <T> T getSystemService(@NonNull Context context, @NonNull Class<T> cls) {
        return (T) Api23Impl.getSystemService(context, cls);
    }

    @Nullable
    public static String getSystemServiceName(@NonNull Context context, @NonNull Class<?> serviceClass) {
        return Api23Impl.getSystemServiceName(context, serviceClass);
    }

    public static boolean isDeviceProtectedStorage(@NonNull Context context) {
        return Api24Impl.isDeviceProtectedStorage(context);
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intents) {
        return startActivities(context, intents, null);
    }

    public static void startActivity(@NonNull Context context, @NonNull Intent intent, @Nullable Bundle options) {
        Api16Impl.startActivity(context, intent, options);
    }

    public static void startForegroundService(@NonNull Context context, @NonNull Intent intent) {
        Api26Impl.startForegroundService(context, intent);
    }

    public static boolean startActivities(@NonNull Context context, @NonNull Intent[] intents, @Nullable Bundle options) {
        Api16Impl.startActivities(context, intents, options);
        return true;
    }
}
