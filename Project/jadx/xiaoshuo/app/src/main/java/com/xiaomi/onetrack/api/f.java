package com.xiaomi.onetrack.api;

import com.xiaomi.onetrack.Configuration;

/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f7551a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7552b = 2;
    private static final int c = 4;
    private static final int d = 8;
    private static final int e = 16;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    public static int a(Configuration configuration) {
        if (configuration == null) {
            return 0;
        }
        boolean zIsGAIDEnable = configuration.isGAIDEnable();
        ?? r0 = zIsGAIDEnable;
        if (configuration.isIMSIEnable()) {
            r0 = (zIsGAIDEnable ? 1 : 0) | 2;
        }
        ?? r02 = r0;
        if (configuration.isIMEIEnable()) {
            r02 = (r0 == true ? 1 : 0) | 4;
        }
        ?? r03 = r02;
        if (configuration.isExceptionCatcherEnable()) {
            r03 = (r02 == true ? 1 : 0) | 8;
        }
        return configuration.isOverrideMiuiRegionSetting() ? r03 | 16 : r03;
    }
}
