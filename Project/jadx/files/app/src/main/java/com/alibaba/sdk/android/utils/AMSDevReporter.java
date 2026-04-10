package com.alibaba.sdk.android.utils;

import android.content.Context;
import com.umeng.message.proguard.ad;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class AMSDevReporter {
    private static Context context;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ExecutorService f40a = Executors.newSingleThreadExecutor(new a());
    private static ConcurrentHashMap<AMSSdkTypeEnum, AMSReportStatusEnum> a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static boolean f41a = false;
    private static String TAG = "AMSDevReporter";

    public enum AMSReportStatusEnum {
        UNREPORTED,
        REPORTED
    }

    public enum AMSSdkExtInfoKeyEnum {
        AMS_EXTINFO_KEY_VERSION(ad.f20396i),
        AMS_EXTINFO_KEY_PACKAGE("PackageName");

        private String description;

        AMSSdkExtInfoKeyEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    public enum AMSSdkTypeEnum {
        AMS_MAN("MAN"),
        AMS_HTTPDNS("HTTPDNS"),
        AMS_MPUSH("MPUSH"),
        AMS_MAC("MAC"),
        AMS_API("API"),
        AMS_HOTFIX("HOTFIX"),
        AMS_FEEDBACK("FEEDBACK"),
        AMS_IM("IM");

        private String description;

        AMSSdkTypeEnum(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    static {
        for (AMSSdkTypeEnum aMSSdkTypeEnum : AMSSdkTypeEnum.values()) {
            a.put(aMSSdkTypeEnum, AMSReportStatusEnum.UNREPORTED);
        }
    }

    public static void asyncReport(Context context2, AMSSdkTypeEnum aMSSdkTypeEnum) {
        asyncReport(context2, aMSSdkTypeEnum, null);
    }

    public static AMSReportStatusEnum getReportStatus(AMSSdkTypeEnum aMSSdkTypeEnum) {
        return a.get(aMSSdkTypeEnum);
    }

    public static void setLogEnabled(boolean z2) {
        d.setLogEnabled(z2);
    }

    public static void asyncReport(Context context2, final AMSSdkTypeEnum aMSSdkTypeEnum, final Map<String, Object> map) {
        if (context2 == null) {
            d.c(TAG, "Context is null, return.");
            return;
        }
        context = context2;
        d.b(TAG, "Add [" + aMSSdkTypeEnum.toString() + "] to report queue.");
        f41a = false;
        f40a.execute(new Runnable() { // from class: com.alibaba.sdk.android.utils.AMSDevReporter.1
            @Override // java.lang.Runnable
            public void run() {
                if (AMSDevReporter.f41a) {
                    d.c(AMSDevReporter.TAG, "Unable to execute remain task in queue, return.");
                    return;
                }
                d.b(AMSDevReporter.TAG, "Get [" + aMSSdkTypeEnum.toString() + "] from report queue.");
                AMSDevReporter.a(aMSSdkTypeEnum, (Map<String, Object>) map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AMSSdkTypeEnum aMSSdkTypeEnum, Map<String, Object> map) {
        String string = aMSSdkTypeEnum.toString();
        if (a.get(aMSSdkTypeEnum) != AMSReportStatusEnum.UNREPORTED) {
            d.b(TAG, "[" + string + "] already reported, return.");
            return;
        }
        int i2 = 0;
        int i3 = 5;
        while (true) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Report [");
            sb.append(string);
            sb.append("], times: [");
            i2++;
            sb.append(i2);
            sb.append("].");
            d.b(str, sb.toString());
            if (!m31a(aMSSdkTypeEnum, map)) {
                if (i2 <= 10) {
                    d.b(TAG, "Report [" + string + "] failed, wait for [" + i3 + "] seconds.");
                    e.a((double) i3);
                    i3 *= 2;
                    if (i3 >= 60) {
                        i3 = 60;
                    }
                } else {
                    d.c(TAG, "Report [" + string + "] stat failed, exceed max retry times, return.");
                    a.put(aMSSdkTypeEnum, AMSReportStatusEnum.UNREPORTED);
                    f41a = true;
                    break;
                }
            } else {
                d.b(TAG, "Report [" + string + "] stat success.");
                a.put(aMSSdkTypeEnum, AMSReportStatusEnum.REPORTED);
                break;
            }
        }
        if (f41a) {
            d.c(TAG, "Report [" + string + "] failed, clear remain report in queue.");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:11|94|12|(3:13|(1:15)(1:100)|68)|16|85|17|(4:(1:20)|(2:87|22)|25|28)) */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0162, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0163, code lost:
    
        com.alibaba.sdk.android.utils.d.e(com.alibaba.sdk.android.utils.AMSDevReporter.TAG, r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e4 A[Catch: IOException -> 0x01e0, TRY_LEAVE, TryCatch #11 {IOException -> 0x01e0, blocks: (B:75:0x01dc, B:79:0x01e4), top: B:92:0x01dc }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m31a(com.alibaba.sdk.android.utils.AMSDevReporter.AMSSdkTypeEnum r10, java.util.Map<java.lang.String, java.lang.Object> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 496
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.utils.AMSDevReporter.m31a(com.alibaba.sdk.android.utils.AMSDevReporter$AMSSdkTypeEnum, java.util.Map):boolean");
    }

    private static String a(AMSSdkTypeEnum aMSSdkTypeEnum, String str, Map<String, Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append(aMSSdkTypeEnum);
        sb.append("-");
        sb.append(str);
        if (map != null) {
            String str2 = (String) map.get(AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_VERSION.toString());
            if (!e.m39a(str2)) {
                sb.append("-");
                sb.append(str2);
            }
            String str3 = (String) map.get(AMSSdkExtInfoKeyEnum.AMS_EXTINFO_KEY_PACKAGE.toString());
            if (!e.m39a(str3)) {
                sb.append("-");
                sb.append(str3);
            }
        }
        return sb.toString();
    }
}
