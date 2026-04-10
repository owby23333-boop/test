package com.bytedance.msdk.api.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public abstract class kb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f350a;
    public String dl;
    public String g;
    public int z;

    public int z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public String a() {
        return this.f350a;
    }

    public String gc() {
        switch (this.z) {
            case 1:
                return MediationConstant.ADN_PANGLE;
            case 2:
                return MediationConstant.ADN_ADMOB;
            case 3:
                return MediationConstant.ADN_GDT;
            case 4:
                return MediationConstant.ADN_MINTEGRAL;
            case 5:
                return MediationConstant.ADN_UNITY;
            case 6:
                return "baidu";
            case 7:
                return MediationConstant.ADN_KS;
            case 8:
                return MediationConstant.ADN_SIGMOB;
            case 9:
                return MediationConstant.ADN_KLEVIN;
            case 10:
                return MediationConstant.ADN_XIAOMI;
            default:
                return "";
        }
    }
}
