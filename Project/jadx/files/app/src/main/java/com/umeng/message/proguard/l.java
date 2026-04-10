package com.umeng.message.proguard;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;
import java.io.Closeable;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    private static final String a = "Helper";
    private static final AtomicInteger b = new AtomicInteger(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20484c = "[^[a-z][A-Z][0-9][.][_]]";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f20485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Boolean f20486e;

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02X", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Exception unused) {
            return str.replaceAll(f20484c, "");
        }
    }

    private static void b(final Context context, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.umeng.message.proguard.l.1
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(context, str, 1).show();
            }
        });
    }

    public static boolean c(Context context) {
        Boolean bool = f20486e;
        if (bool != null) {
            return bool.booleanValue();
        }
        String packageName = context.getPackageName();
        f20486e = Boolean.valueOf(!TextUtils.isEmpty(packageName) && TextUtils.equals(b(context), packageName));
        return f20486e.booleanValue();
    }

    public static void d(final Context context) {
        MessageSharedPrefs.getInstance(context).setRegisterTimes(MessageSharedPrefs.getInstance(context).getRegisterTimes() + 1);
        if (c(context)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.umeng.message.proguard.l.2
                @Override // java.lang.Runnable
                public void run() {
                    if (MessageSharedPrefs.getInstance(context).getRegisterTimes() <= 1) {
                        UPLog.e(l.a, "pushAgent.register方法应该在主进程和channel进程中都被调用!");
                        UMLog.aq(t.b, 0, "\\|");
                        final Toast toastMakeText = Toast.makeText(context, "pushAgent.register方法应该在主进程和channel进程中都被调用!", 1);
                        for (int i2 = 0; i2 < 3; i2++) {
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.umeng.message.proguard.l.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        toastMakeText.show();
                                    } catch (Throwable unused) {
                                    }
                                }
                            }, i2 * 3500);
                        }
                    }
                }
            }, 20000L);
        }
    }

    private static void b() {
        Class<?> clsA = ah.a("com.umeng.commonsdk.framework.UMEnvelopeBuild");
        if (clsA == null) {
            return;
        }
        try {
            clsA.getDeclaredMethod("buildEnvelopeWithExtHeader", Context.class, JSONObject.class, JSONObject.class, String.class, String.class, String.class);
        } catch (NoSuchMethodException unused) {
        }
    }

    public static String b(Context context) {
        if (!TextUtils.isEmpty(f20485d)) {
            return f20485d;
        }
        String currentProcessName = null;
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                currentProcessName = Application.getProcessName();
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(currentProcessName)) {
            currentProcessName = UMFrUtils.getCurrentProcessName(context);
        }
        f20485d = currentProcessName;
        return currentProcessName;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, Class<?> cls) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) > -1) {
                ComponentName componentName = new ComponentName(context, cls);
                if (a(packageManager, componentName)) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(PackageManager packageManager, ComponentName componentName) {
        try {
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
            return componentEnabledSetting == 1 || componentEnabledSetting == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    public static boolean a(Context context) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (!PushAgent.getInstance(context).isPushCheck()) {
            return true;
        }
        b();
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageAppkey())) {
            b(context, "Please set umeng appkey!");
            return false;
        }
        if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageSecret())) {
            b(context, "Please set umeng message secret!");
            return false;
        }
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.setAction("com.taobao.accs.intent.action.SERVICE");
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentServices(intent, 64).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            ResolveInfo next = it.next();
            if (next.serviceInfo.name.equals(com.taobao.accs.utl.j.channelService)) {
                String str = next.serviceInfo.processName;
                if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, context.getPackageName())) {
                    z2 = true;
                    break;
                }
            }
        }
        if (!z2) {
            b(context, "Please check ChannelService in AndroidManifest!");
            return false;
        }
        Intent intent2 = new Intent();
        intent2.setPackage(context.getPackageName());
        intent2.setAction("com.taobao.accs.intent.action.ELECTION");
        Iterator<ResolveInfo> it2 = context.getPackageManager().queryIntentServices(intent2, 64).iterator();
        while (true) {
            if (!it2.hasNext()) {
                z3 = false;
                break;
            }
            ResolveInfo next2 = it2.next();
            if (next2.serviceInfo.name.equals(com.taobao.accs.utl.j.channelService)) {
                String str2 = next2.serviceInfo.processName;
                if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, context.getPackageName())) {
                    z3 = true;
                    break;
                }
            }
        }
        if (!z3) {
            b(context, "Please check ChannelService in AndroidManifest!");
            return false;
        }
        Intent intent3 = new Intent();
        intent3.setPackage(context.getPackageName());
        intent3.setAction(Constants.ACTION_RECEIVE);
        Iterator<ResolveInfo> it3 = context.getPackageManager().queryIntentServices(intent3, 64).iterator();
        while (true) {
            if (!it3.hasNext()) {
                z4 = false;
                break;
            }
            if (it3.next().serviceInfo.name.equals(com.taobao.accs.utl.j.msgService)) {
                z4 = true;
                break;
            }
        }
        if (!z4) {
            b(context, "Please check MsgDistributeService in AndroidManifest!");
            return false;
        }
        Intent intent4 = new Intent();
        intent4.setPackage(context.getPackageName());
        intent4.setAction(Constants.ACTION_COMMAND);
        Iterator<ResolveInfo> it4 = context.getPackageManager().queryBroadcastReceivers(intent4, 64).iterator();
        while (true) {
            if (!it4.hasNext()) {
                z5 = false;
                break;
            }
            ResolveInfo next3 = it4.next();
            if (next3.activityInfo.name.equals("com.taobao.accs.ServiceReceiver")) {
                String str3 = next3.activityInfo.processName;
                if (!TextUtils.isEmpty(str3) && !TextUtils.equals(str3, context.getPackageName())) {
                    z5 = true;
                    break;
                }
            }
        }
        if (!z5) {
            b(context, "Please check ServiceReceiver in AndroidManifest!");
            return false;
        }
        Intent intent5 = new Intent();
        intent5.setPackage(context.getPackageName());
        intent5.setAction(Constants.ACTION_START_FROM_AGOO);
        Iterator<ResolveInfo> it5 = context.getPackageManager().queryBroadcastReceivers(intent5, 64).iterator();
        while (true) {
            if (!it5.hasNext()) {
                z6 = false;
                break;
            }
            ResolveInfo next4 = it5.next();
            if (next4.activityInfo.name.equals("com.taobao.accs.ServiceReceiver")) {
                String str4 = next4.activityInfo.processName;
                if (!TextUtils.isEmpty(str4) && !TextUtils.equals(str4, context.getPackageName())) {
                    z6 = true;
                    break;
                }
            }
        }
        if (!z6) {
            b(context, "Please check ServiceReceiver in AndroidManifest!");
            return false;
        }
        Intent intent6 = new Intent();
        intent6.setPackage(context.getPackageName());
        intent6.setAction(Constants.ACTION_RECEIVE);
        Iterator<ResolveInfo> it6 = context.getPackageManager().queryIntentServices(intent6, 64).iterator();
        while (true) {
            if (!it6.hasNext()) {
                z7 = false;
                break;
            }
            if (it6.next().serviceInfo.name.equals("org.android.agoo.accs.AgooService")) {
                z7 = true;
                break;
            }
        }
        if (!z7) {
            b(context, "Please check AgooService in AndroidManifest!");
            return false;
        }
        Intent intent7 = new Intent();
        intent7.setPackage(context.getPackageName());
        intent7.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        Iterator<ResolveInfo> it7 = context.getPackageManager().queryIntentServices(intent7, 64).iterator();
        while (true) {
            if (!it7.hasNext()) {
                z8 = false;
                break;
            }
            if (it7.next().serviceInfo.name.equals("com.umeng.message.UmengIntentService")) {
                z8 = true;
                break;
            }
        }
        if (!z8) {
            b(context, "Please check UmengIntentService in AndroidManifest!");
            return false;
        }
        Intent intent8 = new Intent();
        intent8.setPackage(context.getPackageName());
        intent8.setAction(context.getPackageName() + ".intent.action.COMMAND");
        Iterator<ResolveInfo> it8 = context.getPackageManager().queryBroadcastReceivers(intent8, 64).iterator();
        while (true) {
            if (!it8.hasNext()) {
                z9 = false;
                break;
            }
            if (it8.next().activityInfo.name.equals("com.taobao.agoo.AgooCommondReceiver")) {
                z9 = true;
                break;
            }
        }
        if (!z9) {
            b(context, "Please replace '${applicationId}.intent.action.COMMAND' with application's applicationId for AgooCommondReceiver in AndroidManifest!");
            return false;
        }
        Intent intent9 = new Intent();
        intent9.setClassName(context.getPackageName(), "com.umeng.message.UmengNotificationReceiver");
        Iterator<ResolveInfo> it9 = context.getPackageManager().queryBroadcastReceivers(intent9, 65536).iterator();
        while (true) {
            if (!it9.hasNext()) {
                z10 = false;
                break;
            }
            ResolveInfo next5 = it9.next();
            if (next5.activityInfo.name.equals("com.umeng.message.UmengNotificationReceiver") && TextUtils.equals(next5.activityInfo.processName, context.getPackageName())) {
                z10 = true;
                break;
            }
        }
        if (!z10) {
            b(context, "Please check UmengNotificationReceiver in AndroidManifest!");
            return false;
        }
        Intent intent10 = new Intent();
        intent10.setPackage(context.getPackageName());
        intent10.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
        Iterator<ResolveInfo> it10 = context.getPackageManager().queryIntentServices(intent10, 64).iterator();
        while (true) {
            if (!it10.hasNext()) {
                z11 = false;
                break;
            }
            ResolveInfo next6 = it10.next();
            if (next6.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService") && TextUtils.equals(context.getPackageName(), next6.serviceInfo.processName)) {
                z11 = true;
                break;
            }
        }
        if (!z11) {
            b(context, "Please check UmengMessageCallbackHandlerService in AndroidManifest!");
            return false;
        }
        Intent intent11 = new Intent();
        intent11.setPackage(context.getPackageName());
        intent11.setAction(MsgConstant.MESSAGE_ENABLE_CALLBACK_ACTION);
        Iterator<ResolveInfo> it11 = context.getPackageManager().queryIntentServices(intent11, 64).iterator();
        while (true) {
            if (!it11.hasNext()) {
                z12 = false;
                break;
            }
            if (it11.next().serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                z12 = true;
                break;
            }
        }
        if (!z12) {
            b(context, "Please check UmengMessageCallbackHandlerService in AndroidManifest!");
            return false;
        }
        Intent intent12 = new Intent();
        intent12.setPackage(context.getPackageName());
        intent12.setAction(MsgConstant.MESSAGE_DISABLE_CALLBACK_ACTION);
        Iterator<ResolveInfo> it12 = context.getPackageManager().queryIntentServices(intent12, 64).iterator();
        while (true) {
            if (!it12.hasNext()) {
                z13 = false;
                break;
            }
            if (it12.next().serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                z13 = true;
                break;
            }
        }
        if (!z13) {
            b(context, "Please check UmengMessageCallbackHandlerService in AndroidManifest!");
            return false;
        }
        Intent intent13 = new Intent();
        intent13.setPackage(context.getPackageName());
        intent13.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
        Iterator<ResolveInfo> it13 = context.getPackageManager().queryIntentServices(intent13, 64).iterator();
        while (true) {
            if (!it13.hasNext()) {
                z14 = false;
                break;
            }
            if (it13.next().serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                z14 = true;
                break;
            }
        }
        if (!z14) {
            b(context, "Please check UmengMessageCallbackHandlerService in AndroidManifest!");
            return false;
        }
        Intent intent14 = new Intent();
        intent14.setClassName(context.getPackageName(), "com.umeng.message.UmengDownloadResourceService");
        Iterator<ResolveInfo> it14 = context.getPackageManager().queryIntentServices(intent14, 65536).iterator();
        while (true) {
            if (!it14.hasNext()) {
                z15 = false;
                break;
            }
            if (it14.next().serviceInfo.name.equals("com.umeng.message.UmengDownloadResourceService")) {
                z15 = true;
                break;
            }
        }
        if (!z15) {
            b(context, "Please check UmengDownloadResourceService in AndroidManifest!");
            return false;
        }
        Intent intent15 = new Intent();
        intent15.setPackage(context.getPackageName());
        intent15.setAction(AgooConstants.BINDER_MSGRECEIVER_ACTION);
        Iterator<ResolveInfo> it15 = context.getPackageManager().queryIntentServices(intent15, 64).iterator();
        while (true) {
            if (!it15.hasNext()) {
                z16 = false;
                break;
            }
            ResolveInfo next7 = it15.next();
            if (next7.serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService") && next7.serviceInfo.exported) {
                String str5 = next7.serviceInfo.processName;
                if (!TextUtils.isEmpty(str5) && !TextUtils.equals(str5, context.getPackageName())) {
                    z16 = true;
                    break;
                }
            }
        }
        if (!z16) {
            b(context, "Please check UmengMessageIntentReceiverService in AndroidManifest!");
            return false;
        }
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        if (packageInfo.requestedPermissions != null) {
            z17 = false;
            z18 = false;
            z19 = false;
            for (int i2 = 0; i2 < packageInfo.requestedPermissions.length; i2++) {
                if ("android.permission.INTERNET".equals(packageInfo.requestedPermissions[i2])) {
                    z17 = true;
                } else if ("android.permission.ACCESS_WIFI_STATE".equals(packageInfo.requestedPermissions[i2])) {
                    z19 = true;
                } else if ("android.permission.ACCESS_NETWORK_STATE".equals(packageInfo.requestedPermissions[i2])) {
                    z18 = true;
                }
            }
        } else {
            z17 = false;
            z18 = false;
            z19 = false;
        }
        if (!(z17 && z19 && z18)) {
            b(context, "Please add required permission in AndroidManifest!");
            return false;
        }
        return true;
    }

    public static String a(Context context, String str) {
        String str2 = context.getCacheDir() + "/umeng_push_inapp/";
        if (str == null) {
            return str2;
        }
        return str2 + str + "/";
    }

    public static int a() {
        int i2;
        int i3;
        if (Build.VERSION.SDK_INT >= 17) {
            return View.generateViewId();
        }
        do {
            i2 = b.get();
            i3 = i2 + 1;
            if (i3 > 16777215) {
                i3 = 1;
            }
        } while (!b.compareAndSet(i2, i3));
        return i2;
    }
}
