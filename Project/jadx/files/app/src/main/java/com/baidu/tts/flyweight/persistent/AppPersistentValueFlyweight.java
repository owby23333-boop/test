package com.baidu.tts.flyweight.persistent;

import android.content.Context;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.GetCUID;
import com.baidu.tts.tools.ResourceTools;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class AppPersistentValueFlyweight {
    public static final String DEFAULT_LICENSE_FILE_NAME = "baidu_tts_license";
    private WeakReference<Context> mContext;
    private String mDefaultLicenseFilePath;
    private String mDeviceId;

    public AppPersistentValueFlyweight(WeakReference<Context> weakReference) {
        this.mContext = weakReference;
    }

    private Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public String getDefaultLicenseFilePath() {
        if (this.mDefaultLicenseFilePath == null) {
            this.mDefaultLicenseFilePath = FileTools.jointPathAndName(ResourceTools.getAppFilesDirPath(getContext()), DEFAULT_LICENSE_FILE_NAME);
        }
        return this.mDefaultLicenseFilePath;
    }

    public String getDeviceId() {
        if (this.mDeviceId == null) {
            this.mDeviceId = GetCUID.getCUID(getContext());
        }
        return this.mDeviceId;
    }
}
