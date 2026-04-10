package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    private static mb b = null;
    private static final String mb = "ox";
    private static b ox;

    public interface b {
        void mb(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.mb mbVar);
    }

    private static class h implements WeakDownloadHandler.IHandler {
        public static int mb;
        private static int ox;
        private final Context b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final InterfaceC0524ox f18069h;
        private final Intent hj;
        private final long ko;
        private boolean lz = false;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final Handler f18070u;
        private Future<Boolean> ww;

        public h(Context context, Intent intent, int i2, InterfaceC0524ox interfaceC0524ox, long j2) {
            this.b = context;
            this.hj = intent;
            ox = i2;
            this.f18069h = interfaceC0524ox;
            this.f18070u = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.ko = j2;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j2 = this.ko;
                    if (j2 <= 0 || j2 > 10000) {
                        return;
                    }
                    mb = 1;
                    this.ww = DownloadComponentManager.getCPUThreadExecutor().submit(new hj(this.f18070u, this.b, this.f18069h, this.ko));
                    return;
                }
                if (i2 == 2) {
                    mb = 2;
                    this.f18070u.removeMessages(2);
                    this.f18070u.removeMessages(1);
                    Future<Boolean> future = this.ww;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.lz && (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground())) {
                        Intent intent = this.hj;
                        if (intent != null) {
                            ox.ox(this.b, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.b).getDownloadInfo(ox);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.b.ox(this.b, ox, false);
                            }
                        }
                        this.lz = true;
                    }
                    ox.ox(ox, this.hj == null, ox.mb(this.b));
                }
            }
        }
    }

    private static class hj implements Callable<Boolean> {
        private final Handler b;
        private final long hj;
        private final Context mb;
        private final InterfaceC0524ox ox;

        public hj(Handler handler, Context context, InterfaceC0524ox interfaceC0524ox, long j2) {
            this.mb = context;
            this.ox = interfaceC0524ox;
            this.b = handler;
            this.hj = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            if (this.ox != null && this.hj > 0 && this.hj <= 10000) {
                Context context = this.mb;
                boolean zMb = context != null ? this.ox.mb(context) : false;
                Message messageObtain = Message.obtain();
                if (zMb) {
                    messageObtain.what = 2;
                    this.b.sendMessage(messageObtain);
                } else {
                    messageObtain.what = 1;
                    this.b.sendMessageDelayed(messageObtain, this.hj);
                }
                return false;
            }
            return false;
        }
    }

    private static class mb implements AppStatusManager.AppStatusChangeListener {
        private JSONObject b;
        private final h mb;
        private final int ox;

        public mb(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0524ox interfaceC0524ox) {
            this.b = jSONObject;
            this.ox = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.mb = new h(context, intent, i2, interfaceC0524ox, this.ox);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int iOptInt = this.b.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.mb.f18070u.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.mb.f18070u.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.mb.lz) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.mb.f18070u.sendMessage(messageObtain);
            }
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            mb unused = ox.b = null;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.ox$ox, reason: collision with other inner class name */
    interface InterfaceC0524ox {
        boolean mb(@NonNull Context context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean h(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hj(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void b(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z2 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    private static void hj(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z2 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    private static boolean ox(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.mb mbVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            mbVar.hj = "custom";
            com.ss.android.socialbase.appdownloader.mb.mb mbVarMb = com.ss.android.socialbase.appdownloader.mb.hj.mb(context, "custom", jSONObject, downloadInfo);
            if (mbVarMb != null && mbVarMb.mb()) {
                Intent intentOx = mbVarMb.ox();
                if (intentOx == null) {
                    return false;
                }
                if (!mb(new File(savePath), downloadInfo, jSONObject)) {
                    mbVar.ox = 6;
                } else {
                    if (ox(context, intentOx)) {
                        mbVar.ox = 0;
                        return true;
                    }
                    mbVar.ox = 1;
                }
                return false;
            }
            mbVar.ox = 3;
        }
        return false;
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, Intent intent, boolean z2) {
        JSONArray jSONArrayOptJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (jSONArrayOptJSONArray == null) {
            return false;
        }
        int length = jSONArrayOptJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
            if (com.ss.android.socialbase.appdownloader.u.mb.mb(jSONObjectOptJSONObject) && mb(context, downloadInfo, intent, jSONObjectOptJSONObject, z2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0164 A[PHI: r15
  0x0164: PHI (r15v10 com.ss.android.socialbase.appdownloader.mb) = 
  (r15v2 com.ss.android.socialbase.appdownloader.mb)
  (r15v8 com.ss.android.socialbase.appdownloader.mb)
  (r15v11 com.ss.android.socialbase.appdownloader.mb)
 binds: [B:91:0x0162, B:81:0x013a, B:69:0x010d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean mb(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.ox.mb(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.mb ox(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.mb mbVar = new com.ss.android.socialbase.appdownloader.mb();
        if (jSONObject == null) {
            return mbVar;
        }
        mbVar.mb = jSONObject.optString("type");
        mbVar.f18067h = "vbi";
        if (com.ss.android.socialbase.appdownloader.mb.hj.mb(DownloadComponentManager.getAppContext(), "vbi", jSONObject, downloadSetting)) {
            mbVar.ox = 0;
        } else {
            mb(mbVar, 3);
        }
        return mbVar;
    }

    public static void ox(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z2 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(int i2, boolean z2, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("scene", z2 ? 1 : 2);
            if (!z3) {
                i3 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean ox(Context context, Intent intent) {
        return mb(context, intent, true);
    }

    private static boolean mb(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.mb mbVar, DownloadSetting downloadSetting) {
        boolean zOx;
        String strOptString = jSONObject.optString("type");
        mbVar.mb = strOptString;
        Intent intentOx = com.ss.android.socialbase.appdownloader.mb.hj.mb(context, "vbi", jSONObject, downloadInfo).ox();
        StringBuilder sb = new StringBuilder();
        try {
            zOx = ox(context, intentOx);
        } catch (Throwable th) {
            sb.append(strOptString);
            sb.append(" startActivity failed : ");
            sb.append(mb(th));
            mb(mbVar, 1);
            zOx = false;
        }
        if (!zOx) {
            mbVar.b = sb.toString();
        } else {
            mbVar.ox = 0;
        }
        return true;
    }

    private static boolean mb(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.mb mbVar) {
        boolean z2;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            mbVar.f18067h = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = strArrSplit.length;
                int i2 = 0;
                while (true) {
                    z2 = true;
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    }
                    String str2 = strArrSplit[i2];
                    com.ss.android.socialbase.appdownloader.mb.mb mbVarMb = com.ss.android.socialbase.appdownloader.mb.hj.mb(context, str2, jSONObject, downloadInfo);
                    if (mbVarMb != null) {
                        Intent intentOx = mbVarMb.ox();
                        if (intentOx != null) {
                            if (mb(file, downloadInfo, jSONObject)) {
                                try {
                                    mb(context, intentOx, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(mb(th));
                                    mb(mbVar, 1);
                                }
                            } else {
                                mb(mbVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            mb(mbVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i2++;
                }
                if (!z2) {
                    mbVar.b = sb.toString();
                } else {
                    mbVar.hj = str;
                    mbVar.ox = 0;
                }
                return z2;
            }
        }
        return false;
    }

    public static int mb(@NonNull DownloadSetting downloadSetting) {
        if (!(downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !TextUtils.isEmpty(r0.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false)) {
            return 5;
        }
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) {
            return 4;
        }
        JSONArray jSONArrayOptJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (jSONArrayOptJSONArray == null) {
            return -1;
        }
        int length = jSONArrayOptJSONArray.length();
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
            if (com.ss.android.socialbase.appdownloader.u.mb.mb(jSONObjectOptJSONObject)) {
                String strOptString = jSONObjectOptJSONObject.optString("type");
                if (!"plan_a".equals(strOptString) && !"plan_b".equals(strOptString) && !"plan_e".equals(strOptString) && !"plan_f".equals(strOptString)) {
                    if ("plan_d".equalsIgnoreCase(strOptString) || "plan_h".equalsIgnoreCase(strOptString) || ("plan_g".equalsIgnoreCase(strOptString) && (i2 = ox(jSONObjectOptJSONObject, downloadSetting).ox) == 0)) {
                        return 0;
                    }
                } else {
                    i2 = mb(jSONObjectOptJSONObject, downloadSetting).ox;
                    if (i2 == 0) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.mb mb(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.mb mbVar = new com.ss.android.socialbase.appdownloader.mb();
        if (jSONObject == null) {
            return mbVar;
        }
        String strOptString = jSONObject.optString("type");
        mbVar.mb = strOptString;
        if ("plan_b".equals(strOptString)) {
            mbVar.f18067h = "custom";
            if (com.ss.android.socialbase.appdownloader.mb.hj.mb(DownloadComponentManager.getAppContext(), "custom", jSONObject, downloadSetting)) {
                mbVar.ox = 0;
                return mbVar;
            }
            mb(mbVar, 3);
        } else {
            String strOptString2 = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            mbVar.f18067h = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.mb.hj.mb(DownloadComponentManager.getAppContext(), str, jSONObject, downloadSetting)) {
                        mbVar.ox = 0;
                        return mbVar;
                    }
                    mb(mbVar, 3);
                }
            }
        }
        return mbVar;
    }

    public static com.ss.android.socialbase.appdownloader.mb mb(JSONObject jSONObject, String str, Context context, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.mb mbVar = new com.ss.android.socialbase.appdownloader.mb();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.u.hj.ox()) {
            mbVar.mb = jSONObject.optString("type");
            if (downloadSetting.optInt("bi", 0) == 1) {
                mbVar.ox = 0;
                return mbVar;
            }
            if (mb(context)) {
                mbVar.ox = 2;
            } else if (com.ss.android.socialbase.appdownloader.u.mb.mb(str) != null) {
                mbVar.ox = 0;
            } else {
                mbVar.ox = 9;
            }
        }
        return mbVar;
    }

    private static void mb(com.ss.android.socialbase.appdownloader.mb mbVar, int i2) {
        int i3 = mbVar.ox;
        if (i3 != -1) {
            mbVar.ox = (i3 * 10) + i2;
        } else {
            mbVar.ox = i2;
        }
    }

    private static boolean mb(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectOptJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        File file2 = null;
        String strOptString = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC) : null;
        if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
            file2 = new File(path + File.separator + strOptString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean mb(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.mb mbVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L)) / 60000 >= jOptLong && !mb(context)) {
                sharedPreferences.edit().putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis()).apply();
                if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (mb(context, intent2, false)) {
                            hj(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (mbVar != null) {
                            mbVar.ox = 1;
                            mbVar.b = "tryShowUnknownSourceDialog" + mb(th);
                        }
                        return false;
                    }
                }
                if (mb(context, intent, i2, jSONObject)) {
                    b(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean mb(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.u.hj.ox() && Build.VERSION.SDK_INT < 26 && !hj(context)) {
                com.ss.android.socialbase.appdownloader.mb.u uVar = new com.ss.android.socialbase.appdownloader.mb.u(context);
                if (uVar.mb()) {
                    mb(context, intent, i2, jSONObject, new InterfaceC0524ox() { // from class: com.ss.android.socialbase.appdownloader.ox.1
                        @Override // com.ss.android.socialbase.appdownloader.ox.InterfaceC0524ox
                        public boolean mb(@NonNull Context context2) {
                            return ox.hj(context2);
                        }
                    });
                    return ox(context, uVar.ox());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !h(context)) {
                com.ss.android.socialbase.appdownloader.mb.ox oxVar = new com.ss.android.socialbase.appdownloader.mb.ox(context);
                if (oxVar.mb()) {
                    mb(context, intent, i2, jSONObject, new InterfaceC0524ox() { // from class: com.ss.android.socialbase.appdownloader.ox.2
                        @Override // com.ss.android.socialbase.appdownloader.ox.InterfaceC0524ox
                        public boolean mb(@NonNull Context context2) {
                            return ox.h(context2);
                        }
                    });
                    return ox(context, oxVar.ox());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean mb(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.u.hj.ox() && Build.VERSION.SDK_INT < 26) {
            return hj(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return h(context);
        }
        return true;
    }

    public static boolean mb() {
        return h.mb == 1;
    }

    public static void mb(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z2 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    private static void mb(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0524ox interfaceC0524ox) {
        if (b != null) {
            AppStatusManager.getInstance().unregisterAppSwitchListener(b);
            b = null;
        }
        b = new mb(context, intent, i2, jSONObject, interfaceC0524ox);
        AppStatusManager.getInstance().registerAppSwitchListener(b);
    }

    public static boolean mb(Context context, Intent intent, boolean z2) {
        if (context == null || intent == null) {
            return false;
        }
        if (z2) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String mb(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    public static void mb(b bVar) {
        ox = bVar;
    }
}
