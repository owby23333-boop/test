package p000else;

import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: renamed from: else.do, reason: invalid class name */
/* JADX INFO: compiled from: EnumC0020a.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Cdo {
    UNSUPPORT("unsupport"),
    HUA_WEI("HUAWEI"),
    XIAOMI("Xiaomi"),
    VIVO(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO),
    OPPO(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO),
    MOTO("motorola"),
    LENOVO("lenovo"),
    ASUS("asus"),
    SAMSUNG("samsung"),
    MEIZU(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU),
    NUBIA("nubia"),
    ZTE("ZTE"),
    ONEPLUS("OnePlus"),
    BLACKSHARK("blackshark"),
    FREEMEOS("freemeos"),
    SSUIOS("ssui"),
    QIKU("qiku");


    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f20795s;

    Cdo(String str) {
        this.f20795s = str;
    }

    public static Cdo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return UNSUPPORT;
        }
        for (Cdo cdo : values()) {
            if (cdo.f20795s.equalsIgnoreCase(str)) {
                return cdo;
            }
        }
        return UNSUPPORT;
    }
}
