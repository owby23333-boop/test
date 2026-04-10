package com.lxj.xpopup.util;

import android.annotation.SuppressLint;
import android.os.Build;
import com.kuaishou.weapon.p0.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"InlinedApi"})
public final class PermissionConstants {
    private static final String[] a = {"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"};
    private static final String[] b = {"android.permission.CAMERA"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f17540c = {"android.permission.READ_CONTACTS", "android.permission.WRITE_CONTACTS", g.f16726f};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f17541d = {g.f16727g, g.f16728h, "android.permission.ACCESS_BACKGROUND_LOCATION"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f17542e = {"android.permission.RECORD_AUDIO"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f17543f = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f17544g = {"android.permission.READ_PHONE_STATE", "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", "android.permission.WRITE_CALL_LOG", "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f17545h = {"android.permission.BODY_SENSORS"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f17546i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f17547j = {g.f16729i, "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f17548k = {"android.permission.ACTIVITY_RECOGNITION"};

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionGroup {
    }

    public static String[] a(String str) {
        if (str == null) {
            return new String[0];
        }
        switch (str) {
            case "CALENDAR":
                return a;
            case "CAMERA":
                return b;
            case "CONTACTS":
                return f17540c;
            case "LOCATION":
                return f17541d;
            case "MICROPHONE":
                return f17542e;
            case "PHONE":
                return Build.VERSION.SDK_INT < 26 ? f17544g : f17543f;
            case "SENSORS":
                return f17545h;
            case "SMS":
                return f17546i;
            case "STORAGE":
                return f17547j;
            case "ACTIVITY_RECOGNITION":
                return f17548k;
            default:
                return new String[]{str};
        }
    }
}
