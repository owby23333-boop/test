package com.kwad.sdk.utils;

import android.location.Location;
import com.kwad.sdk.api.KsCustomController;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class as {
    private static boolean DP() {
        if (!com.kwad.b.kwai.a.bI.booleanValue()) {
            return false;
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }

    public static boolean DQ() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canReadLocation()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static Location DR() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF == null || (ksCustomController = sdkConfigCF.ksCustomController) == null) {
                return null;
            }
            return ksCustomController.getLocation();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean DS() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canUsePhoneState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String DT() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            return (sdkConfigCF == null || (ksCustomController = sdkConfigCF.ksCustomController) == null) ? "" : ksCustomController.getImei();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String[] DU() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                return ksCustomController.getImeis();
            }
        } catch (Throwable unused) {
        }
        return new String[]{"", ""};
    }

    public static String DV() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            return (sdkConfigCF == null || (ksCustomController = sdkConfigCF.ksCustomController) == null) ? "" : ksCustomController.getAndroidId();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean DW() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canUseMacAddress()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String DX() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            return (sdkConfigCF == null || (ksCustomController = sdkConfigCF.ksCustomController) == null) ? "" : ksCustomController.getMacAddress();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean DY() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canUseOaid()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String DZ() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            return (sdkConfigCF == null || (ksCustomController = sdkConfigCF.ksCustomController) == null) ? "" : ksCustomController.getOaid();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean Ea() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canUseNetworkState()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Eb() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canUseStoragePermission()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean Ec() {
        KsCustomController ksCustomController;
        if (DP()) {
            return true;
        }
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                if (!ksCustomController.canReadInstalledPackages()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static List<String> Ed() {
        KsCustomController ksCustomController;
        try {
            SdkConfig sdkConfigCF = ServiceProvider.CF();
            if (sdkConfigCF != null && (ksCustomController = sdkConfigCF.ksCustomController) != null) {
                return ksCustomController.getInstalledPackages();
            }
        } catch (Throwable unused) {
        }
        return new ArrayList();
    }
}
