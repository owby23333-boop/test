package com.sntech.net;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DomainProvider {
    @Keep
    public static String baseA4Url() {
        StringBuilder sbA = y.b.a("http://");
        sbA.append(DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_A4));
        sbA.append("/");
        return sbA.toString();
    }

    @Keep
    public static String baseDeviceUrl() {
        StringBuilder sbA = y.b.a("http://");
        sbA.append(DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_DEVICE));
        sbA.append("/");
        return sbA.toString();
    }

    @Keep
    public static String baseUrl() {
        StringBuilder sbA = y.b.a("http://");
        sbA.append(DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_X1));
        sbA.append("/");
        return sbA.toString();
    }

    @Keep
    public static String baseX2Url() {
        StringBuilder sbA = y.b.a("http://");
        sbA.append(DomainManager.get().getDomainByTemplate(DomainConfig.TEMPLATE_X2));
        sbA.append("/");
        return sbA.toString();
    }
}
