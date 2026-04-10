package com.sntech.net;

import androidx.annotation.Keep;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DomainConfig {
    public static final String TEMPLATE_A4 = "new-a4.template";
    public static final String TEMPLATE_DEVICE = "device-center.template";
    public static final String TEMPLATE_X1 = "x1.template";
    public static final String TEMPLATE_X2 = "x2.template";
    private Map<String, String[]> templateDomains;

    /* JADX INFO: renamed from: com.sntech.net.DomainConfig$do, reason: invalid class name */
    public static final class Cdo {

        /* JADX INFO: renamed from: do, reason: not valid java name */
        public Map<String, String[]> f81do = new HashMap(3);
    }

    public DomainConfig(Cdo cdo) {
        this.templateDomains = cdo.f81do;
    }

    public Map<String, String[]> getTemplateDomains() {
        return this.templateDomains;
    }
}
