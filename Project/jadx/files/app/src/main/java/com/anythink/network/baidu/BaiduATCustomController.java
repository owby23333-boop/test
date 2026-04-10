package com.anythink.network.baidu;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaiduATCustomController {
    public boolean getPermissionAppList() {
        return false;
    }

    public boolean getPermissionAppUpdate() {
        return true;
    }

    public boolean getPermissionDeviceInfo() {
        return true;
    }

    public boolean getPermissionLocation() {
        return false;
    }

    public boolean getPermissionOAID() {
        return true;
    }

    public boolean getPermissionReadDeviceID() {
        return true;
    }

    public boolean getPermissionRunningApp() {
        return true;
    }

    public boolean getPermissionStorage() {
        return false;
    }
}
