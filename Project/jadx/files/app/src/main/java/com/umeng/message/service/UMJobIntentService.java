package com.umeng.message.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class UMJobIntentService extends JobIntentService {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f20585j = "UMJobIntentService";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20586k = 21000;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final HashMap<Class<?>, Integer> f20587l = new HashMap<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f20588m = new Object();

    public static void enqueueWork(Context context, Class<? extends UMJobIntentService> cls, Intent intent) {
        int iIntValue;
        synchronized (f20588m) {
            if (context == null || cls == null || intent == null) {
                return;
            }
            UPLog.i(f20585j, "--->>> enqueueWork, cls is " + cls.getName());
            if (f20587l.containsKey(cls)) {
                Integer num = f20587l.get(cls);
                if (num == null) {
                    return;
                } else {
                    iIntValue = num.intValue();
                }
            } else {
                iIntValue = f20587l.size() + f20586k;
                f20587l.put(cls, Integer.valueOf(iIntValue));
            }
            UPLog.i(f20585j, "cls jobId is " + iIntValue);
            JobIntentService.enqueueWork(context, cls, iIntValue, intent);
        }
    }

    @Override // com.umeng.message.service.JobIntentService
    protected void a(Intent intent) {
        UPLog.i(f20585j, "--->>> onHandleWork");
    }

    public static void enqueueWork(Context context, String str, Intent intent) {
        int iIntValue;
        synchronized (f20588m) {
            if (context != null) {
                if (!TextUtils.isEmpty(str) && intent != null) {
                    UPLog.i(f20585j, "--->>> enqueueWork, cls is " + str);
                    Class<?> cls = null;
                    try {
                        cls = Class.forName(str);
                    } catch (ClassNotFoundException unused) {
                    }
                    if (cls == null) {
                        UPLog.i(f20585j, "cls == null");
                        return;
                    }
                    if (!f20587l.containsKey(cls)) {
                        iIntValue = f20587l.size() + f20586k;
                        f20587l.put(cls, Integer.valueOf(iIntValue));
                    } else {
                        Integer num = f20587l.get(cls);
                        if (num == null) {
                            return;
                        } else {
                            iIntValue = num.intValue();
                        }
                    }
                    UPLog.i(f20585j, "cls jobId is " + iIntValue);
                    JobIntentService.enqueueWork(context, cls, iIntValue, intent);
                }
            }
        }
    }
}
