package com.ss.android.downloadad.api.download;

import android.text.TextUtils;
import com.anythink.core.common.c.m;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.download.api.b.ox;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.b;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.ExecutorGroup;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class AdDownloadModel implements DownloadModel {
    protected String mAppIcon;
    protected String mAppName;
    protected boolean mAutoInstallWithoutNotification;
    protected List<String> mBackupUrls;
    protected List<String> mClickTrackUrl;
    protected DeepLink mDeepLink;
    protected boolean mDistinctDir;
    protected JSONObject mDownloadSettings;
    protected String mDownloadUrl;
    protected long mExpectFileLength;
    protected JSONObject mExtra;
    protected long mExtraValue;
    protected String mFileName;
    protected String mFilePath;
    protected IDownloadFileUriProvider mFileUriProvider;
    protected Map<String, String> mHeaders;
    protected long mId;
    protected boolean mIndependentProcess;

    @Deprecated
    protected boolean mIsInExternalPublicDir;
    protected String mLogExtra;
    protected String mMd5;
    protected String mMimeType;
    protected int mModelType;
    protected String mNotificationJumpUrl;
    protected String mPackageName;
    protected b mQuickAppModel;
    protected String mSdkMonitorScene;
    protected String mStartToast;
    protected int mVersionCode;
    protected String mVersionName;
    protected boolean mIsAd = true;
    protected boolean mIsShowToast = true;
    protected boolean mIsShowNotification = true;
    protected boolean mAutoInstall = true;
    protected boolean mNeedWifi = false;

    @ExecutorGroup
    protected int mExecutorGroup = 2;
    protected boolean mEnablePause = true;
    protected int mFunnelType = 1;

    public static final class Builder {
        AdDownloadModel model = new AdDownloadModel();

        public AdDownloadModel build() {
            return this.model;
        }

        @Deprecated
        public Builder setAdId(long j2) {
            return setId(j2);
        }

        public Builder setAppIcon(String str) {
            this.model.mAppIcon = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.model.mAppName = str;
            return this;
        }

        public Builder setAutoInstall(boolean z2) {
            this.model.mAutoInstall = z2;
            return this;
        }

        public Builder setAutoInstallWithoutNotification(boolean z2) {
            this.model.mAutoInstallWithoutNotification = z2;
            return this;
        }

        public Builder setBackupUrls(List<String> list) {
            this.model.mBackupUrls = list;
            return this;
        }

        public Builder setClickTrackUrl(List<String> list) {
            this.model.mClickTrackUrl = list;
            return this;
        }

        public Builder setDeepLink(DeepLink deepLink) {
            this.model.mDeepLink = deepLink;
            return this;
        }

        public Builder setDistinctDir(boolean z2) {
            this.model.mDistinctDir = z2;
            return this;
        }

        public Builder setDownloadSettings(JSONObject jSONObject) {
            this.model.mDownloadSettings = jSONObject;
            return this;
        }

        public Builder setDownloadUrl(String str) {
            this.model.mDownloadUrl = str;
            return this;
        }

        public Builder setEnablePause(boolean z2) {
            this.model.mEnablePause = z2;
            return this;
        }

        public Builder setExecutorGroup(@ExecutorGroup int i2) {
            this.model.mExecutorGroup = i2;
            return this;
        }

        public Builder setExpectFileLength(long j2) {
            this.model.mExpectFileLength = j2;
            return this;
        }

        public Builder setExtra(JSONObject jSONObject) {
            this.model.mExtra = jSONObject;
            return this;
        }

        public Builder setExtraValue(long j2) {
            this.model.mExtraValue = j2;
            return this;
        }

        public Builder setFileName(String str) {
            this.model.mFileName = str;
            return this;
        }

        public Builder setFilePath(String str) {
            this.model.mFilePath = str;
            return this;
        }

        public Builder setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
            this.model.mFileUriProvider = iDownloadFileUriProvider;
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.model.mHeaders = map;
            return this;
        }

        public Builder setId(long j2) {
            this.model.mId = j2;
            return this;
        }

        public Builder setIsAd(boolean z2) {
            this.model.mIsAd = z2;
            return this;
        }

        @Deprecated
        public Builder setIsInExternalPublicDir(boolean z2) {
            this.model.mIsInExternalPublicDir = z2;
            return this;
        }

        public Builder setIsShowNotification(boolean z2) {
            this.model.mIsShowNotification = z2;
            return this;
        }

        public Builder setIsShowToast(boolean z2) {
            this.model.mIsShowToast = z2;
            return this;
        }

        public Builder setLogExtra(String str) {
            this.model.mLogExtra = str;
            return this;
        }

        public Builder setMd5(String str) {
            this.model.mMd5 = str;
            return this;
        }

        public Builder setMimeType(String str) {
            this.model.mMimeType = str;
            return this;
        }

        public Builder setModelType(int i2) {
            this.model.mModelType = i2;
            return this;
        }

        public Builder setNeedIndependentProcess(boolean z2) {
            this.model.mIndependentProcess = z2;
            return this;
        }

        public Builder setNeedWifi(boolean z2) {
            this.model.mNeedWifi = z2;
            return this;
        }

        public Builder setNotificationJumpUrl(String str) {
            this.model.mNotificationJumpUrl = str;
            return this;
        }

        public Builder setPackageName(String str) {
            this.model.mPackageName = str;
            return this;
        }

        public Builder setQuickAppModel(b bVar) {
            this.model.mQuickAppModel = bVar;
            return this;
        }

        public Builder setSdkMonitorScene(String str) {
            this.model.mSdkMonitorScene = str;
            return this;
        }

        public Builder setStartToast(String str) {
            this.model.mStartToast = str;
            return this;
        }

        public Builder setVersionCode(int i2) {
            this.model.mVersionCode = i2;
            return this;
        }

        public Builder setVersionName(String str) {
            this.model.mVersionName = str;
            return this;
        }
    }

    protected AdDownloadModel() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String AdDownloadModel1672829046101dc(java.lang.String r4) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            r2 = 0
            switch(r0) {
                case 72: goto L0;
                case 73: goto L9;
                case 74: goto Lc;
                default: goto L8;
            }
        L8:
            goto L5a
        L9:
            switch(r1) {
                case 94: goto L55;
                case 95: goto L10;
                case 96: goto L3f;
                default: goto Lc;
            }
        Lc:
            switch(r1) {
                case 55: goto L55;
                case 56: goto L55;
                case 57: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L55
        L10:
            r0 = 18
            r1 = 1
            switch(r1) {
                case 60: goto L17;
                case 61: goto L25;
                case 62: goto L34;
                default: goto L16;
            }
        L16:
            goto L3f
        L17:
            int r3 = 0 - r1
            int r3 = r3 * 0
            r2 = 0
            int r2 = r2 * 2
            int r2 = r2 - r1
            int r3 = r3 * r2
            int r3 = r3 % 6
            if (r3 == 0) goto L0
        L25:
            int r2 = 18 - r1
            int r2 = r2 * 18
            r3 = 18
            int r3 = r3 * 2
            int r3 = r3 - r1
            int r2 = r2 * r3
            int r2 = r2 % 6
            if (r2 == 0) goto L55
        L34:
            r1 = 99
            int r1 = r1 * r1
            int r0 = r0 * r0
            int r0 = r0 * 34
            int r1 = r1 - r0
            r0 = -1
            goto L0
        L3f:
            char[] r4 = r4.toCharArray()
        L43:
            int r0 = r4.length
            if (r2 >= r0) goto L4f
            char r0 = r4[r2]
            r0 = r0 ^ r2
            char r0 = (char) r0
            r4[r2] = r0
            int r2 = r2 + 1
            goto L43
        L4f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            return r0
        L55:
            r0 = 73
            r1 = 96
            goto L4
        L5a:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadad.api.download.AdDownloadModel.AdDownloadModel1672829046101dc(java.lang.String):java.lang.String");
    }

    private static void appendBackupUrlsFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("backup_urls");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            arrayList.add(jSONArrayOptJSONArray.optString(i2));
        }
        builder.setBackupUrls(arrayList);
    }

    private static void appendDeepLinkFromJson(JSONObject jSONObject, Builder builder) {
        builder.setDeepLink(new DeepLink(jSONObject.optString(EventConstants.ExtraJson.OPEN_URL), jSONObject.optString("web_url"), null));
    }

    private static void appendHeaderMapFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("header_keys");
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("header_values");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray2 == null) {
            return;
        }
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            map.put(jSONArrayOptJSONArray.optString(i2), jSONArrayOptJSONArray2.optString(i2));
        }
        builder.setHeaders(map);
    }

    private static void appendQuickAppUrlFromJson(JSONObject jSONObject, Builder builder) {
        String strOptString = jSONObject.optString("quick_app_url");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        builder.setQuickAppModel(new b.mb().mb(strOptString).mb());
    }

    private static void appendTrackUrlFromJson(JSONObject jSONObject, Builder builder) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("click_track_urls");
        if (jSONArrayOptJSONArray != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                arrayList.add(jSONArrayOptJSONArray.optString(i2));
            }
            builder.setClickTrackUrl(arrayList);
        }
    }

    public static AdDownloadModel fromJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Builder builder = new Builder();
        try {
            boolean z2 = true;
            Builder distinctDir = builder.setAdId(ox.mb(jSONObject, "id")).setIsAd(jSONObject.optInt("is_ad", 1) == 1).setModelType(jSONObject.optInt("model_type")).setMimeType(jSONObject.optString(EventConstants.ExtraJson.MIME_TYPE)).setExtraValue(ox.mb(jSONObject, "ext_value")).setLogExtra(jSONObject.optString("log_extra")).setPackageName(jSONObject.optString("package_name")).setDownloadUrl(jSONObject.optString(EventConstants.ExtraJson.DOWNLOAD_URL)).setAppName(jSONObject.optString("app_name")).setAppIcon(jSONObject.optString("app_icon")).setIsShowToast(jSONObject.optInt("is_show_toast", 1) == 1).setIsShowNotification(jSONObject.optInt("show_notification", 1) == 1).setNeedWifi(jSONObject.optInt("need_wifi") == 1).setMd5(jSONObject.optString("md5")).setExpectFileLength(jSONObject.optLong(EventConstants.ExtraJson.EXPECT_FILE_LENGTH)).setNeedIndependentProcess(jSONObject.optInt("independent_process") == 1).setVersionCode(jSONObject.optInt("version_code")).setVersionName(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)).setFilePath(jSONObject.optString(m.a.f7064c)).setFileName(jSONObject.optString(EventConstants.ExtraJson.FILE_NAME)).setNotificationJumpUrl(jSONObject.optString("notification_jump_url")).setAutoInstallWithoutNotification(jSONObject.optInt("auto_install_without_notify") == 1).setExecutorGroup(jSONObject.optInt(DbJsonConstants.DBJSON_KEY_EXECUTOR)).setDownloadSettings(jSONObject.optJSONObject("download_settings")).setExtra(jSONObject.optJSONObject("extra")).setStartToast(jSONObject.optString("start_toast")).setSdkMonitorScene(jSONObject.optString("sdk_monitor_scene")).setAutoInstall(jSONObject.optInt(DbJsonConstants.AUTO_INSTALL, 1) == 1).setDistinctDir(jSONObject.optInt("distinct_dir") == 1);
            if (jSONObject.optInt("enable_pause", 1) != 1) {
                z2 = false;
            }
            distinctDir.setEnablePause(z2);
            appendDeepLinkFromJson(jSONObject, builder);
            appendQuickAppUrlFromJson(jSONObject, builder);
            appendTrackUrlFromJson(jSONObject, builder);
            appendHeaderMapFromJson(jSONObject, builder);
            appendBackupUrlsFromJson(jSONObject, builder);
        } catch (Exception e2) {
            x.m().mb(e2, "AdDownloadModel fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean autoInstallWithoutNotification() {
        return this.mAutoInstallWithoutNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean distinctDir() {
        return this.mDistinctDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean enablePause() {
        return this.mEnablePause;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideNotification() {
        this.mIsShowNotification = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceHideToast() {
        this.mIsShowToast = false;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public void forceWifi() {
        this.mNeedWifi = true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getAppIcon() {
        return this.mAppIcon;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getBackupUrls() {
        return this.mBackupUrls;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public List<String> getClickTrackUrl() {
        return this.mClickTrackUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public DeepLink getDeepLink() {
        return this.mDeepLink;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public IDownloadFileUriProvider getDownloadFileUriProvider() {
        return this.mFileUriProvider;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getDownloadSettings() {
        return this.mDownloadSettings;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getExecutorGroup() {
        return this.mExecutorGroup;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExpectFileLength() {
        return this.mExpectFileLength;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public JSONObject getExtra() {
        return this.mExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getExtraValue() {
        return this.mExtraValue;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFileName() {
        return this.mFileName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getFilePath() {
        return this.mFilePath;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getFunnelType() {
        return this.mFunnelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public long getId() {
        return this.mId;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getLogExtra() {
        return this.mLogExtra;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMd5() {
        return this.mMd5;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getMimeType() {
        return this.mMimeType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getModelType() {
        return this.mModelType;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getName() {
        return this.mAppName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getNotificationJumpUrl() {
        return this.mNotificationJumpUrl;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getPackageName() {
        return this.mPackageName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public b getQuickAppModel() {
        return this.mQuickAppModel;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getSdkMonitorScene() {
        return this.mSdkMonitorScene;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getStartToast() {
        return this.mStartToast;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public String getVersionName() {
        return this.mVersionName;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAd() {
        return this.mIsAd;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isAutoInstall() {
        return this.mAutoInstall;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isInExternalPublicDir() {
        return this.mIsInExternalPublicDir;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isNeedWifi() {
        return this.mNeedWifi;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowNotification() {
        return this.mIsShowNotification;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isShowToast() {
        return this.mIsShowToast;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean isVisibleInDownloadsUi() {
        return true;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean needIndependentProcess() {
        return this.mIndependentProcess;
    }

    @Deprecated
    public AdDownloadModel setAdId(long j2) {
        return setId(j2);
    }

    public AdDownloadModel setAppIcon(String str) {
        this.mAppIcon = str;
        return this;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public AdDownloadModel setAutoInstallWithoutNotification(boolean z2) {
        this.mAutoInstallWithoutNotification = z2;
        return this;
    }

    public AdDownloadModel setBackupUrls(List<String> list) {
        this.mBackupUrls = list;
        return this;
    }

    public AdDownloadModel setClickTrackUrl(List<String> list) {
        this.mClickTrackUrl = list;
        return this;
    }

    public AdDownloadModel setDeepLink(DeepLink deepLink) {
        this.mDeepLink = deepLink;
        return this;
    }

    public AdDownloadModel setDownloadUrl(String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public void setExpectFileLength(long j2) {
        this.mExpectFileLength = j2;
    }

    public void setExtra(JSONObject jSONObject) {
        this.mExtra = jSONObject;
    }

    public void setExtraValue(long j2) {
        this.mExtraValue = j2;
    }

    public AdDownloadModel setFileName(String str) {
        this.mFileName = str;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public AdDownloadModel setFilePath(String str) {
        this.mFilePath = str;
        return this;
    }

    public AdDownloadModel setFileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.mFileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public AdDownloadModel setFunnelType(int i2) {
        this.mFunnelType = i2;
        return this;
    }

    public AdDownloadModel setHeaders(Map<String, String> map) {
        this.mHeaders = map;
        return this;
    }

    public AdDownloadModel setId(long j2) {
        this.mId = j2;
        return this;
    }

    public AdDownloadModel setIsAd(boolean z2) {
        this.mIsAd = z2;
        return this;
    }

    public AdDownloadModel setIsShowNotification(boolean z2) {
        this.mIsShowNotification = z2;
        return this;
    }

    public void setIsShowToast(boolean z2) {
        this.mIsShowToast = z2;
    }

    public AdDownloadModel setLogExtra(String str) {
        this.mLogExtra = str;
        return this;
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public AdDownloadModel setMimeType(String str) {
        this.mMimeType = str;
        return this;
    }

    public AdDownloadModel setModelType(int i2) {
        this.mModelType = i2;
        return this;
    }

    public AdDownloadModel setNeedIndependentProcess(boolean z2) {
        this.mIndependentProcess = z2;
        return this;
    }

    public void setNeedWifi(boolean z2) {
        this.mNeedWifi = z2;
    }

    public AdDownloadModel setNotificationJumpUrl(String str) {
        this.mNotificationJumpUrl = str;
        return this;
    }

    public AdDownloadModel setPackageName(String str) {
        this.mPackageName = str;
        return this;
    }

    public AdDownloadModel setQuickAppModel(b bVar) {
        this.mQuickAppModel = bVar;
        return this;
    }

    public void setSdkMonitorScene(String str) {
        this.mSdkMonitorScene = str;
    }

    public void setStartToast(String str) {
        this.mStartToast = str;
    }

    public AdDownloadModel setVersionCode(int i2) {
        this.mVersionCode = i2;
        return this;
    }

    public AdDownloadModel setVersionName(String str) {
        this.mVersionName = str;
        return this;
    }

    @Override // com.ss.android.download.api.download.DownloadModel
    public boolean shouldDownloadWithPatchApply() {
        return ox.mb(DownloadSetting.obtain(getDownloadSettings()), getMimeType());
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.mId);
            int i2 = 1;
            jSONObject.put("is_ad", this.mIsAd ? 1 : 0);
            jSONObject.putOpt("model_type", Integer.valueOf(this.mModelType));
            jSONObject.putOpt(EventConstants.ExtraJson.MIME_TYPE, this.mMimeType);
            jSONObject.putOpt("ext_value", Long.valueOf(this.mExtraValue));
            jSONObject.putOpt("log_extra", this.mLogExtra);
            jSONObject.putOpt("package_name", this.mPackageName);
            jSONObject.putOpt(EventConstants.ExtraJson.DOWNLOAD_URL, this.mDownloadUrl);
            jSONObject.putOpt("app_name", this.mAppName);
            jSONObject.putOpt("app_icon", this.mAppIcon);
            jSONObject.putOpt("is_show_toast", Integer.valueOf(this.mIsShowToast ? 1 : 0));
            jSONObject.putOpt("show_notification", Integer.valueOf(this.mIsShowNotification ? 1 : 0));
            jSONObject.put("need_wifi", this.mNeedWifi ? 1 : 0);
            jSONObject.put("md5", this.mMd5);
            jSONObject.put(EventConstants.ExtraJson.EXPECT_FILE_LENGTH, this.mExpectFileLength);
            jSONObject.put("independent_process", this.mIndependentProcess ? 1 : 0);
            jSONObject.put("version_code", this.mVersionCode);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, this.mVersionName);
            jSONObject.putOpt(m.a.f7064c, this.mFilePath);
            jSONObject.putOpt(EventConstants.ExtraJson.FILE_NAME, this.mFileName);
            jSONObject.putOpt("notification_jump_url", this.mNotificationJumpUrl);
            jSONObject.putOpt("auto_install_without_notify", Integer.valueOf(this.mAutoInstallWithoutNotification ? 1 : 0));
            jSONObject.putOpt(DbJsonConstants.DBJSON_KEY_EXECUTOR, Integer.valueOf(this.mExecutorGroup));
            jSONObject.putOpt("start_toast", this.mStartToast);
            jSONObject.putOpt("sdk_monitor_scene", this.mSdkMonitorScene);
            jSONObject.putOpt(DbJsonConstants.AUTO_INSTALL, Integer.valueOf(this.mAutoInstall ? 1 : 0));
            jSONObject.putOpt("distinct_dir", Integer.valueOf(this.mDistinctDir ? 1 : 0));
            if (!this.mEnablePause) {
                i2 = 0;
            }
            jSONObject.putOpt("enable_pause", Integer.valueOf(i2));
            if (this.mDownloadSettings != null) {
                jSONObject.put("download_settings", this.mDownloadSettings);
            }
            if (this.mBackupUrls != null && !this.mBackupUrls.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String str : this.mBackupUrls) {
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("backup_urls", jSONArray);
            }
            if (this.mDeepLink != null) {
                if (!TextUtils.isEmpty(this.mDeepLink.getOpenUrl())) {
                    jSONObject.put(EventConstants.ExtraJson.OPEN_URL, this.mDeepLink.getOpenUrl());
                }
                if (!TextUtils.isEmpty(this.mDeepLink.getWebUrl())) {
                    jSONObject.put("web_url", this.mDeepLink.getWebUrl());
                }
            }
            if (this.mQuickAppModel != null) {
                jSONObject.putOpt("quick_app_url", this.mQuickAppModel.mb());
            }
            if (this.mClickTrackUrl != null && !this.mClickTrackUrl.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = this.mClickTrackUrl.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject.put("click_track_urls", jSONArray2);
            }
            if (this.mExtra != null) {
                jSONObject.put("extra", this.mExtra);
            }
            if (this.mHeaders != null && !this.mHeaders.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                for (Map.Entry<String, String> entry : this.mHeaders.entrySet()) {
                    jSONArray3.put(entry.getKey());
                    jSONArray4.put(entry.getKey());
                }
                jSONObject.put("header_keys", jSONArray3);
                jSONObject.put("header_values", jSONArray4);
            }
        } catch (Exception e2) {
            x.m().mb(e2, "AdDownloadModel toJson");
        }
        return jSONObject;
    }
}
