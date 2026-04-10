package com.sntech.cc.data;

import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.taobao.accs.common.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class MyApplicationInfo {

    @SerializedName("appComponentFactory")
    @Expose
    public String appComponentFactory;

    @SerializedName("backupAgentName")
    @Expose
    public String backupAgentName;

    @SerializedName("banner")
    @Expose
    public int banner;

    @SerializedName("category")
    @Expose
    public int category;

    @SerializedName("className")
    @Expose
    public String className;

    @SerializedName("compatibleWidthLimitDp")
    @Expose
    public int compatibleWidthLimitDp;

    @SerializedName("dataDir")
    @Expose
    public String dataDir;

    @SerializedName("descriptionRes")
    @Expose
    public int descriptionRes;

    @SerializedName("deviceProtectedDataDir")
    @Expose
    public String deviceProtectedDataDir;

    @SerializedName("enabled")
    @Expose
    public boolean enabled;

    @SerializedName(Constants.KEY_FLAGS)
    @Expose
    public int flags;

    @SerializedName("icon")
    @Expose
    public int icon;

    @SerializedName("labelRes")
    @Expose
    public int labelRes;

    @SerializedName("largestWidthLimitDp")
    @Expose
    public int largestWidthLimitDp;

    @SerializedName("logo")
    @Expose
    public int logo;

    @SerializedName("manageSpaceActivityName")
    @Expose
    public String manageSpaceActivityName;

    @SerializedName("minSdkVersion")
    @Expose
    public int minSdkVersion;

    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("nativeLibraryDir")
    @Expose
    public String nativeLibraryDir;

    @SerializedName("nonLocalizedLabel")
    @Expose
    public CharSequence nonLocalizedLabel;

    @SerializedName("packageName")
    @Expose
    public String packageName;

    @SerializedName("permission")
    @Expose
    public String permission;

    @SerializedName(com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME)
    @Expose
    public String processName;

    @SerializedName("publicSourceDir")
    @Expose
    public String publicSourceDir;

    @SerializedName("requiresSmallestWidthDp")
    @Expose
    public int requiresSmallestWidthDp;

    @SerializedName("sharedLibraryFiles")
    @Expose
    public String[] sharedLibraryFiles;

    @SerializedName("sourceDir")
    @Expose
    public String sourceDir;

    @SerializedName("splitNames")
    @Expose
    public String[] splitNames;

    @SerializedName("splitPublicSourceDirs")
    @Expose
    public String[] splitPublicSourceDirs;

    @SerializedName("splitSourceDirs")
    @Expose
    public String[] splitSourceDirs;

    @SerializedName("storageUuid")
    @Expose
    public String storageUuid;

    @SerializedName("targetSdkVersion")
    @Expose
    public int targetSdkVersion;

    @SerializedName("taskAffinity")
    @Expose
    public String taskAffinity;

    @SerializedName("theme")
    @Expose
    public int theme;

    @SerializedName("uiOptions")
    @Expose
    public int uiOptions;

    @SerializedName("uid")
    @Expose
    public int uid;

    public MyApplicationInfo() {
        this.uiOptions = 0;
        this.flags = 0;
        this.requiresSmallestWidthDp = 0;
        this.compatibleWidthLimitDp = 0;
        this.largestWidthLimitDp = 0;
        this.enabled = true;
    }

    public ApplicationInfo toApplicationInfo() {
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.name = this.name;
        applicationInfo.packageName = this.packageName;
        applicationInfo.labelRes = this.labelRes;
        applicationInfo.nonLocalizedLabel = this.nonLocalizedLabel;
        applicationInfo.icon = this.icon;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            applicationInfo.banner = this.banner;
        }
        applicationInfo.logo = this.logo;
        applicationInfo.taskAffinity = this.taskAffinity;
        applicationInfo.permission = this.permission;
        applicationInfo.processName = this.processName;
        applicationInfo.className = this.className;
        applicationInfo.theme = this.theme;
        applicationInfo.flags = this.flags;
        applicationInfo.requiresSmallestWidthDp = this.requiresSmallestWidthDp;
        applicationInfo.compatibleWidthLimitDp = this.compatibleWidthLimitDp;
        applicationInfo.largestWidthLimitDp = this.largestWidthLimitDp;
        if (i2 >= 26) {
            String str = this.storageUuid;
            if (str != null) {
                applicationInfo.storageUuid = UUID.fromString(str);
            }
            applicationInfo.splitNames = this.splitNames;
            applicationInfo.category = this.category;
        }
        applicationInfo.sourceDir = this.sourceDir;
        applicationInfo.publicSourceDir = this.publicSourceDir;
        if (i2 >= 21) {
            applicationInfo.splitSourceDirs = this.splitSourceDirs;
            applicationInfo.splitPublicSourceDirs = this.splitPublicSourceDirs;
        }
        applicationInfo.nativeLibraryDir = this.nativeLibraryDir;
        applicationInfo.sharedLibraryFiles = this.sharedLibraryFiles;
        applicationInfo.dataDir = this.dataDir;
        if (i2 >= 24) {
            applicationInfo.deviceProtectedDataDir = this.deviceProtectedDataDir;
            applicationInfo.minSdkVersion = this.minSdkVersion;
        }
        applicationInfo.uid = this.uid;
        applicationInfo.targetSdkVersion = this.targetSdkVersion;
        applicationInfo.enabled = this.enabled;
        applicationInfo.manageSpaceActivityName = this.manageSpaceActivityName;
        applicationInfo.descriptionRes = this.descriptionRes;
        applicationInfo.uiOptions = this.uiOptions;
        applicationInfo.backupAgentName = this.backupAgentName;
        if (i2 >= 28) {
            applicationInfo.appComponentFactory = this.appComponentFactory;
        }
        return applicationInfo;
    }

    public MyApplicationInfo(ApplicationInfo applicationInfo) {
        this.uiOptions = 0;
        this.flags = 0;
        this.requiresSmallestWidthDp = 0;
        this.compatibleWidthLimitDp = 0;
        this.largestWidthLimitDp = 0;
        this.enabled = true;
        String str = applicationInfo.name;
        this.name = str;
        if (str != null) {
            this.name = str.trim();
        }
        this.packageName = applicationInfo.packageName;
        this.labelRes = applicationInfo.labelRes;
        CharSequence charSequence = applicationInfo.nonLocalizedLabel;
        this.nonLocalizedLabel = charSequence;
        if (charSequence != null) {
            this.nonLocalizedLabel = charSequence.toString().trim();
        }
        this.icon = applicationInfo.icon;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 20) {
            this.banner = applicationInfo.banner;
        }
        this.logo = applicationInfo.logo;
        this.taskAffinity = applicationInfo.taskAffinity;
        this.permission = applicationInfo.permission;
        this.processName = applicationInfo.processName;
        this.className = applicationInfo.className;
        this.theme = applicationInfo.theme;
        this.flags = applicationInfo.flags;
        this.requiresSmallestWidthDp = applicationInfo.requiresSmallestWidthDp;
        this.compatibleWidthLimitDp = applicationInfo.compatibleWidthLimitDp;
        this.largestWidthLimitDp = applicationInfo.largestWidthLimitDp;
        if (i2 >= 26) {
            UUID uuid = applicationInfo.storageUuid;
            if (uuid != null) {
                this.storageUuid = uuid.toString();
            }
            this.splitNames = applicationInfo.splitNames;
            this.category = applicationInfo.category;
        }
        this.sourceDir = applicationInfo.sourceDir;
        this.publicSourceDir = applicationInfo.publicSourceDir;
        if (i2 >= 21) {
            this.splitSourceDirs = applicationInfo.splitSourceDirs;
            this.splitPublicSourceDirs = applicationInfo.splitPublicSourceDirs;
        }
        this.nativeLibraryDir = applicationInfo.nativeLibraryDir;
        this.sharedLibraryFiles = applicationInfo.sharedLibraryFiles;
        this.dataDir = applicationInfo.dataDir;
        if (i2 >= 24) {
            this.deviceProtectedDataDir = applicationInfo.deviceProtectedDataDir;
            this.minSdkVersion = applicationInfo.minSdkVersion;
        }
        this.uid = applicationInfo.uid;
        this.targetSdkVersion = applicationInfo.targetSdkVersion;
        this.enabled = applicationInfo.enabled;
        this.manageSpaceActivityName = applicationInfo.manageSpaceActivityName;
        this.descriptionRes = applicationInfo.descriptionRes;
        this.uiOptions = applicationInfo.uiOptions;
        this.backupAgentName = applicationInfo.backupAgentName;
        if (i2 >= 28) {
            this.appComponentFactory = applicationInfo.appComponentFactory;
        }
    }
}
