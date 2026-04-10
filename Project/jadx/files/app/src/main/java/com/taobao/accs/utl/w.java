package com.taobao.accs.utl;

import com.ut.mini.IUTApplication;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;
import com.ut.mini.crashhandler.IUTCrashCaughtListner;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
class w implements IUTApplication {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UTMini f18341c;

    w(UTMini uTMini, String str, String str2) {
        this.f18341c = uTMini;
        this.a = str;
        this.b = str2;
    }

    public String getUTAppVersion() {
        return null;
    }

    public String getUTChannel() {
        return this.a;
    }

    public IUTCrashCaughtListner getUTCrashCraughtListener() {
        return null;
    }

    public IUTRequestAuthentication getUTRequestAuthInstance() {
        return new UTSecuritySDKRequestAuthentication(this.b);
    }

    public boolean isAliyunOsSystem() {
        return false;
    }

    public boolean isUTCrashHandlerDisable() {
        return false;
    }

    public boolean isUTLogEnable() {
        return false;
    }
}
