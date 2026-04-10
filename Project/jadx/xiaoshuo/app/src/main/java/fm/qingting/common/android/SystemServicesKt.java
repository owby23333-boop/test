package fm.qingting.common.android;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.NetworkStatsManager;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.fingerprint.FingerprintManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.midi.MidiManager;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.CarrierConfigManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.reader.BaseEnv;
import com.iflytek.aikit.media.speech.SpeechConstant;
import com.xiaomi.onetrack.api.at;
import com.xiaomi.passport.ui.page.UserAvatarUpdateActivity;
import com.yuewen.g72;
import com.yuewen.i8;
import com.yuewen.kl2;
import com.yuewen.rf4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000Ì\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0002\u001a\f\u0010\t\u001a\u00020\n*\u00020\u0002H\u0007\u001a\u0012\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f*\u00020\u0002\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0002\u001a\f\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0007\u001a\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0002H\u0007\u001a\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0002H\u0007\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0002H\u0007\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\n\u0010\u001a\u001a\u00020\u001b*\u00020\u0002\u001a\n\u0010\u001c\u001a\u00020\u001d*\u00020\u0002\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u0002H\u0007\u001a\n\u0010 \u001a\u00020!*\u00020\u0002\u001a\f\u0010\"\u001a\u00020#*\u00020\u0002H\u0007\u001a\n\u0010$\u001a\u00020%*\u00020\u0002\u001a\n\u0010&\u001a\u00020'*\u00020\u0002\u001a\f\u0010(\u001a\u00020)*\u00020\u0002H\u0007\u001a\f\u0010*\u001a\u00020+*\u00020\u0002H\u0007\u001a\n\u0010,\u001a\u00020-*\u00020\u0002\u001a\f\u0010.\u001a\u00020/*\u00020\u0002H\u0007\u001a\n\u00100\u001a\u000201*\u00020\u0002\u001a\f\u00102\u001a\u000203*\u00020\u0002H\u0007\u001a\n\u00104\u001a\u000205*\u00020\u0002\u001a\n\u00106\u001a\u000207*\u00020\u0002\u001a\f\u00108\u001a\u000209*\u00020\u0002H\u0007\u001a\f\u0010:\u001a\u00020;*\u00020\u0002H\u0007\u001a\f\u0010<\u001a\u00020=*\u00020\u0002H\u0007\u001a\f\u0010>\u001a\u00020?*\u00020\u0002H\u0007\u001a\f\u0010@\u001a\u00020A*\u00020\u0002H\u0007\u001a\n\u0010B\u001a\u00020C*\u00020\u0002\u001a\n\u0010D\u001a\u00020E*\u00020\u0002\u001a\f\u0010F\u001a\u00020G*\u00020\u0002H\u0007\u001a\n\u0010H\u001a\u00020I*\u00020\u0002\u001a\f\u0010J\u001a\u00020K*\u00020\u0002H\u0007\u001a\f\u0010L\u001a\u00020M*\u00020\u0002H\u0007\u001a\n\u0010N\u001a\u00020O*\u00020\u0002\u001a\n\u0010P\u001a\u00020Q*\u00020\u0002\u001a\n\u0010R\u001a\u00020S*\u00020\u0002\u001a\f\u0010T\u001a\u00020U*\u00020\u0002H\u0007\u001a\f\u0010V\u001a\u00020W*\u00020\u0002H\u0007\u001a\n\u0010X\u001a\u00020Y*\u00020\u0002\u001a\n\u0010Z\u001a\u00020[*\u00020\u0002\u001a\f\u0010\\\u001a\u00020]*\u00020\u0002H\u0007\u001a\n\u0010^\u001a\u00020_*\u00020\u0002\u001a\f\u0010`\u001a\u00020a*\u00020\u0002H\u0007\u001a\n\u0010b\u001a\u00020c*\u00020\u0002\u001a\f\u0010d\u001a\u00020e*\u00020\u0002H\u0007\u001a\n\u0010f\u001a\u00020g*\u00020\u0002\u001a\n\u0010h\u001a\u00020i*\u00020\u0002\u001a\n\u0010j\u001a\u00020k*\u00020\u0002\u001a\n\u0010l\u001a\u00020m*\u00020\u0002¨\u0006n"}, d2 = {"getAccessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "Landroid/content/Context;", "getAccountManager", "Landroid/accounts/AccountManager;", "getActivityManager", "Landroid/app/ActivityManager;", "getAlarmManager", "Landroid/app/AlarmManager;", "getAppOpsManager", "Landroid/app/AppOpsManager;", "getAppWidgetManager", "Landroid/appwidget/AppWidgetManager;", "kotlin.jvm.PlatformType", "getAudioManager", "Landroid/media/AudioManager;", "getBatteryManager", "Landroid/os/BatteryManager;", "getBluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getCameraManager", "Landroid/hardware/camera2/CameraManager;", "getCaptioningManager", "Landroid/view/accessibility/CaptioningManager;", "getCarrierConfigManager", "Landroid/telephony/CarrierConfigManager;", "getClipboardManager", "Landroid/content/ClipboardManager;", "getConnectivityManager", "Landroid/net/ConnectivityManager;", "getConsumerIrManager", "Landroid/hardware/ConsumerIrManager;", "getDevicePolicyManager", "Landroid/app/admin/DevicePolicyManager;", "getDisplayManager", "Landroid/hardware/display/DisplayManager;", "getDownloadManager", "Landroid/app/DownloadManager;", "getDropBoxManager", "Landroid/os/DropBoxManager;", "getFingerprintManager", "Landroid/hardware/fingerprint/FingerprintManager;", "getInputManager", "Landroid/hardware/input/InputManager;", "getInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getJobScheduler", "Landroid/app/job/JobScheduler;", "getKeyguardManager", "Landroid/app/KeyguardManager;", "getLauncherApps", "Landroid/content/pm/LauncherApps;", "getLayoutInflater", "Landroid/view/LayoutInflater;", "getLocationManager", "Landroid/location/LocationManager;", "getMediaProjectionManager", "Landroid/media/projection/MediaProjectionManager;", "getMediaRouter", "Landroid/media/MediaRouter;", "getMediaSessionManager", "Landroid/media/session/MediaSessionManager;", "getMidiManager", "Landroid/media/midi/MidiManager;", "getNetworkStatsManager", "Landroid/app/usage/NetworkStatsManager;", "getNfcManager", "Landroid/nfc/NfcManager;", "getNotificationManager", "Landroid/app/NotificationManager;", "getNsdManager", "Landroid/net/nsd/NsdManager;", "getPowerManager", "Landroid/os/PowerManager;", "getPrintManager", "Landroid/print/PrintManager;", "getRestrictionsManager", "Landroid/content/RestrictionsManager;", "getSearchManager", "Landroid/app/SearchManager;", "getSensorManager", "Landroid/hardware/SensorManager;", "getStorageManager", "Landroid/os/storage/StorageManager;", "getSubscriptionManager", "Landroid/telephony/SubscriptionManager;", "getTelecomManager", "Landroid/telecom/TelecomManager;", "getTelephonyManager", "Landroid/telephony/TelephonyManager;", "getTextServicesManager", "Landroid/view/textservice/TextServicesManager;", "getTvInputManager", "Landroid/media/tv/TvInputManager;", "getUiModeManager", "Landroid/app/UiModeManager;", "getUsageStatsManager", "Landroid/app/usage/UsageStatsManager;", "getUsbManager", "Landroid/hardware/usb/UsbManager;", "getUserManager", "Landroid/os/UserManager;", "getVibrator", "Landroid/os/Vibrator;", "getWifiManager", "Landroid/net/wifi/WifiManager;", "getWifiP2pManager", "Landroid/net/wifi/p2p/WifiP2pManager;", "getWindowManager", "Landroid/view/WindowManager;", "commonutils_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class SystemServicesKt {
    @NotNull
    public static final AccessibilityManager getAccessibilityManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("accessibility");
        if (systemService != null) {
            return (AccessibilityManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
    }

    @NotNull
    public static final AccountManager getAccountManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("account");
        if (systemService != null) {
            return (AccountManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.accounts.AccountManager");
    }

    @NotNull
    public static final ActivityManager getActivityManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (systemService != null) {
            return (ActivityManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @NotNull
    public static final AlarmManager getAlarmManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (systemService != null) {
            return (AlarmManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.AlarmManager");
    }

    @RequiresApi(19)
    @NotNull
    public static final AppOpsManager getAppOpsManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("appops");
        if (systemService != null) {
            return (AppOpsManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.AppOpsManager");
    }

    public static final AppWidgetManager getAppWidgetManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return AppWidgetManager.getInstance(context);
    }

    @NotNull
    public static final AudioManager getAudioManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("audio");
        if (systemService != null) {
            return (AudioManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.AudioManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final BatteryManager getBatteryManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("batterymanager");
        if (systemService != null) {
            return (BatteryManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
    }

    @RequiresApi(18)
    @NotNull
    public static final BluetoothManager getBluetoothManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(SpeechConstant.BLUETOOTH);
        if (systemService != null) {
            return (BluetoothManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.bluetooth.BluetoothManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final CameraManager getCameraManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(UserAvatarUpdateActivity.CAMERA);
        if (systemService != null) {
            return (CameraManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
    }

    @RequiresApi(19)
    @NotNull
    public static final CaptioningManager getCaptioningManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("captioning");
        if (systemService != null) {
            return (CaptioningManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.CaptioningManager");
    }

    @RequiresApi(23)
    @NotNull
    public static final CarrierConfigManager getCarrierConfigManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("carrier_config");
        if (systemService != null) {
            return (CarrierConfigManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.CarrierConfigManager");
    }

    @NotNull
    public static final ClipboardManager getClipboardManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("clipboard");
        if (systemService != null) {
            return (ClipboardManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.ClipboardManager");
    }

    @NotNull
    public static final ConnectivityManager getConnectivityManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            return (ConnectivityManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @RequiresApi(19)
    @NotNull
    public static final ConsumerIrManager getConsumerIrManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("consumer_ir");
        if (systemService != null) {
            return (ConsumerIrManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.ConsumerIrManager");
    }

    @NotNull
    public static final DevicePolicyManager getDevicePolicyManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("device_policy");
        if (systemService != null) {
            return (DevicePolicyManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.admin.DevicePolicyManager");
    }

    @RequiresApi(17)
    @NotNull
    public static final DisplayManager getDisplayManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("display");
        if (systemService != null) {
            return (DisplayManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.display.DisplayManager");
    }

    @NotNull
    public static final DownloadManager getDownloadManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(i8.o);
        if (systemService != null) {
            return (DownloadManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.DownloadManager");
    }

    @NotNull
    public static final DropBoxManager getDropBoxManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("dropbox");
        if (systemService != null) {
            return (DropBoxManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.DropBoxManager");
    }

    @RequiresApi(23)
    @NotNull
    public static final FingerprintManager getFingerprintManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("fingerprint");
        if (systemService != null) {
            return (FingerprintManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.fingerprint.FingerprintManager");
    }

    @RequiresApi(16)
    @NotNull
    public static final InputManager getInputManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(rf4.b.n);
        if (systemService != null) {
            return (InputManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.input.InputManager");
    }

    @NotNull
    public static final InputMethodManager getInputMethodManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("input_method");
        if (systemService != null) {
            return (InputMethodManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final JobScheduler getJobScheduler(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("jobscheduler");
        if (systemService != null) {
            return (JobScheduler) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.job.JobScheduler");
    }

    @NotNull
    public static final KeyguardManager getKeyguardManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("keyguard");
        if (systemService != null) {
            return (KeyguardManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.KeyguardManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final LauncherApps getLauncherApps(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("launcherapps");
        if (systemService != null) {
            return (LauncherApps) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.pm.LauncherApps");
    }

    @NotNull
    public static final LayoutInflater getLayoutInflater(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService != null) {
            return (LayoutInflater) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.LayoutInflater");
    }

    @NotNull
    public static final LocationManager getLocationManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("location");
        if (systemService != null) {
            return (LocationManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.location.LocationManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final MediaProjectionManager getMediaProjectionManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("media_projection");
        if (systemService != null) {
            return (MediaProjectionManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.projection.MediaProjectionManager");
    }

    @RequiresApi(16)
    @NotNull
    public static final MediaRouter getMediaRouter(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("media_router");
        if (systemService != null) {
            return (MediaRouter) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.MediaRouter");
    }

    @RequiresApi(21)
    @NotNull
    public static final MediaSessionManager getMediaSessionManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("media_session");
        if (systemService != null) {
            return (MediaSessionManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.session.MediaSessionManager");
    }

    @RequiresApi(23)
    @NotNull
    public static final MidiManager getMidiManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("midi");
        if (systemService != null) {
            return (MidiManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.midi.MidiManager");
    }

    @RequiresApi(23)
    @NotNull
    public static final NetworkStatsManager getNetworkStatsManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("netstats");
        if (systemService != null) {
            return (NetworkStatsManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.usage.NetworkStatsManager");
    }

    @NotNull
    public static final NfcManager getNfcManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("nfc");
        if (systemService != null) {
            return (NfcManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.nfc.NfcManager");
    }

    @NotNull
    public static final NotificationManager getNotificationManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("notification");
        if (systemService != null) {
            return (NotificationManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    @RequiresApi(16)
    @NotNull
    public static final NsdManager getNsdManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("servicediscovery");
        if (systemService != null) {
            return (NsdManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
    }

    @NotNull
    public static final PowerManager getPowerManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("power");
        if (systemService != null) {
            return (PowerManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
    }

    @RequiresApi(19)
    @NotNull
    public static final PrintManager getPrintManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("print");
        if (systemService != null) {
            return (PrintManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.print.PrintManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final RestrictionsManager getRestrictionsManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("restrictions");
        if (systemService != null) {
            return (RestrictionsManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.content.RestrictionsManager");
    }

    @NotNull
    public static final SearchManager getSearchManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("search");
        if (systemService != null) {
            return (SearchManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.SearchManager");
    }

    @NotNull
    public static final SensorManager getSensorManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("sensor");
        if (systemService != null) {
            return (SensorManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.SensorManager");
    }

    @NotNull
    public static final StorageManager getStorageManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(BaseEnv.y);
        if (systemService != null) {
            return (StorageManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.storage.StorageManager");
    }

    @RequiresApi(22)
    @NotNull
    public static final SubscriptionManager getSubscriptionManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("telephony_subscription_service");
        if (systemService != null) {
            return (SubscriptionManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.SubscriptionManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final TelecomManager getTelecomManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("telecom");
        if (systemService != null) {
            return (TelecomManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.telecom.TelecomManager");
    }

    @NotNull
    public static final TelephonyManager getTelephonyManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(at.d);
        if (systemService != null) {
            return (TelephonyManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    @NotNull
    public static final TextServicesManager getTextServicesManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("textservices");
        if (systemService != null) {
            return (TextServicesManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.textservice.TextServicesManager");
    }

    @RequiresApi(21)
    @NotNull
    public static final TvInputManager getTvInputManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("tv_input");
        if (systemService != null) {
            return (TvInputManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.media.tv.TvInputManager");
    }

    @NotNull
    public static final UiModeManager getUiModeManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("uimode");
        if (systemService != null) {
            return (UiModeManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.UiModeManager");
    }

    @RequiresApi(22)
    @NotNull
    public static final UsageStatsManager getUsageStatsManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("usagestats");
        if (systemService != null) {
            return (UsageStatsManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.usage.UsageStatsManager");
    }

    @NotNull
    public static final UsbManager getUsbManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("usb");
        if (systemService != null) {
            return (UsbManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.hardware.usb.UsbManager");
    }

    @RequiresApi(17)
    @NotNull
    public static final UserManager getUserManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("user");
        if (systemService != null) {
            return (UserManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.UserManager");
    }

    @NotNull
    public static final Vibrator getVibrator(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("vibrator");
        if (systemService != null) {
            return (Vibrator) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Vibrator");
    }

    @NotNull
    public static final WifiManager getWifiManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getApplicationContext().getSystemService(g72.g);
        if (systemService != null) {
            return (WifiManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.WifiManager");
    }

    @NotNull
    public static final WifiP2pManager getWifiP2pManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("wifip2p");
        if (systemService != null) {
            return (WifiP2pManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
    }

    @NotNull
    public static final WindowManager getWindowManager(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService(kl2.t9);
        if (systemService != null) {
            return (WindowManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }
}
