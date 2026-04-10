package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdEcpmInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1470a;
    private String dl;
    private String e;
    private String fo;
    private String g;
    private String gc;
    private String gz;
    private String i;
    private String kb;
    private Map<String, String> ls;
    private int m;
    private String pf;
    private String uy;
    private String v;
    private String wp;
    private String z;

    public MediationAdEcpmInfo() {
        this.ls = new HashMap();
    }

    public MediationAdEcpmInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        HashMap map2 = new HashMap();
        this.ls = map2;
        this.z = str;
        this.g = str2;
        this.dl = str3;
        this.f1470a = str4;
        this.gc = str5;
        this.m = i;
        this.e = str6;
        this.gz = str7;
        this.fo = str8;
        this.uy = str9;
        this.kb = str10;
        this.wp = str11;
        this.i = str12;
        this.v = str13;
        this.pf = str14;
        if (map != null) {
            this.ls = map;
        } else {
            map2.clear();
        }
    }

    public Map<String, String> getCustomData() {
        return this.ls;
    }

    public String getSdkName() {
        return this.z;
    }

    public String getCustomSdkName() {
        return this.g;
    }

    public String getSlotId() {
        return this.dl;
    }

    public String getLevelTag() {
        return this.f1470a;
    }

    public String getEcpm() {
        return this.gc;
    }

    public int getReqBiddingType() {
        return this.m;
    }

    public String getErrorMsg() {
        return this.e;
    }

    public String getRequestId() {
        return this.gz;
    }

    public String getRitType() {
        return this.fo;
    }

    public String getSegmentId() {
        return this.kb;
    }

    public String getChannel() {
        return this.wp;
    }

    public String getSubChannel() {
        return this.i;
    }

    public String getAbTestId() {
        return this.v;
    }

    public String getScenarioId() {
        return this.pf;
    }

    public String getSubRitType() {
        return this.uy;
    }
}
