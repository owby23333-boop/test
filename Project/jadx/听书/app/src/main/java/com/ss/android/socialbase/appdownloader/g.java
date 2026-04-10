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
import androidx.core.provider.FontsContractCompat;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.v.gz;
import com.ss.android.socialbase.downloader.z.z;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static z dl = null;
    private static dl g = null;
    private static final String z = "g";

    public interface dl {
        void z(com.ss.android.socialbase.downloader.e.dl dlVar, com.ss.android.socialbase.appdownloader.z zVar);
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.g$g, reason: collision with other inner class name */
    interface InterfaceC0454g {
        boolean z(Context context);
    }

    public static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, Intent intent, boolean z2) {
        JSONArray jSONArrayGc = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).gc("ah_plans");
        if (jSONArrayGc == null) {
            return false;
        }
        int length = jSONArrayGc.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayGc.optJSONObject(i);
            if (com.ss.android.socialbase.appdownloader.m.z.z(jSONObjectOptJSONObject) && z(context, dlVar, intent, jSONObjectOptJSONObject, z2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:103:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0167 A[PHI: r15
  0x0167: PHI (r15v13 com.ss.android.socialbase.appdownloader.z) = 
  (r15v2 com.ss.android.socialbase.appdownloader.z)
  (r15v8 com.ss.android.socialbase.appdownloader.z)
  (r15v14 com.ss.android.socialbase.appdownloader.z)
 binds: [B:94:0x0165, B:84:0x013d, B:60:0x00e9] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean z(android.content.Context r11, com.ss.android.socialbase.downloader.e.dl r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instruction units count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.g.z(android.content.Context, com.ss.android.socialbase.downloader.e.dl, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    private static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.z zVar, com.ss.android.socialbase.downloader.i.z zVar2) {
        boolean zG;
        String strOptString = jSONObject.optString("type");
        zVar.z = strOptString;
        Intent intentG = com.ss.android.socialbase.appdownloader.z.a.z(context, "vbi", jSONObject, dlVar).g();
        StringBuilder sb = new StringBuilder();
        try {
            zG = g(context, intentG);
        } catch (Throwable th) {
            sb.append(strOptString).append(" startActivity failed : ").append(z(th));
            z(zVar, 1);
            zG = false;
        }
        if (!zG) {
            zVar.dl = sb.toString();
        } else {
            zVar.g = 0;
        }
        return true;
    }

    private static boolean z(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.z zVar) {
        String str;
        boolean z2;
        if (context != null && jSONObject != null) {
            String strOptString = jSONObject.optString("device_plans");
            zVar.gc = strOptString;
            if (!TextUtils.isEmpty(strOptString)) {
                String[] strArrSplit = strOptString.split(",");
                String strKb = dlVar.kb();
                if (TextUtils.isEmpty(strKb)) {
                    return false;
                }
                File file = new File(strKb);
                StringBuilder sb = new StringBuilder();
                int length = strArrSplit.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        str = null;
                        z2 = false;
                        break;
                    }
                    str = strArrSplit[i];
                    com.ss.android.socialbase.appdownloader.z.z zVarZ = com.ss.android.socialbase.appdownloader.z.a.z(context, str, jSONObject, dlVar);
                    if (zVarZ != null) {
                        Intent intentG = zVarZ.g();
                        if (intentG != null) {
                            if (z(file, dlVar, jSONObject)) {
                                z2 = true;
                                try {
                                    z(context, intentG, false);
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str).append(" startActivity failed : ").append(z(th));
                                    z(zVar, 1);
                                }
                            } else {
                                z(zVar, 6);
                                sb.append(str).append(" createDescFile failed! ");
                            }
                        } else {
                            z(zVar, 3);
                            sb.append(str).append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z2) {
                    zVar.dl = sb.toString();
                } else {
                    zVar.f2046a = str;
                    zVar.g = 0;
                }
                return z2;
            }
        }
        return false;
    }

    private static boolean g(Context context, com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.z zVar) {
        if (context != null && jSONObject != null) {
            String strKb = dlVar.kb();
            if (TextUtils.isEmpty(strKb)) {
                return false;
            }
            zVar.f2046a = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            com.ss.android.socialbase.appdownloader.z.z zVarZ = com.ss.android.socialbase.appdownloader.z.a.z(context, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, dlVar);
            if (zVarZ == null || !zVarZ.z()) {
                zVar.g = 3;
            } else {
                Intent intentG = zVarZ.g();
                if (intentG == null) {
                    return false;
                }
                if (z(new File(strKb), dlVar, jSONObject)) {
                    if (g(context, intentG)) {
                        zVar.g = 0;
                        return true;
                    }
                    zVar.g = 1;
                } else {
                    zVar.g = 6;
                }
                return false;
            }
        }
        return false;
    }

    public static int z(com.ss.android.socialbase.downloader.i.z zVar) {
        int i;
        if (!(zVar.a("download_dir") != null ? !TextUtils.isEmpty(r0.optString("dir_name")) : false)) {
            return 5;
        }
        if (!com.ss.android.socialbase.downloader.i.z.dl().z("get_download_info_by_list")) {
            return 4;
        }
        JSONArray jSONArrayGc = zVar.gc("ah_plans");
        int i2 = -1;
        if (jSONArrayGc != null) {
            int length = jSONArrayGc.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayGc.optJSONObject(i3);
                if (com.ss.android.socialbase.appdownloader.m.z.z(jSONObjectOptJSONObject)) {
                    String strOptString = jSONObjectOptJSONObject.optString("type");
                    if ("plan_a".equals(strOptString) || "plan_b".equals(strOptString) || "plan_e".equals(strOptString) || "plan_f".equals(strOptString)) {
                        com.ss.android.socialbase.appdownloader.z zVarZ = z(jSONObjectOptJSONObject, zVar);
                        i = zVarZ.g;
                        if (zVarZ.g == 0) {
                            return 0;
                        }
                    } else {
                        if (!"plan_d".equalsIgnoreCase(strOptString) && !"plan_h".equalsIgnoreCase(strOptString)) {
                            if ("plan_g".equalsIgnoreCase(strOptString)) {
                                com.ss.android.socialbase.appdownloader.z zVarG = g(jSONObjectOptJSONObject, zVar);
                                i = zVarG.g;
                                if (zVarG.g == 0) {
                                }
                            } else {
                                continue;
                            }
                        }
                        return 0;
                    }
                    i2 = i;
                }
            }
        }
        return i2;
    }

    public static com.ss.android.socialbase.appdownloader.z z(JSONObject jSONObject, com.ss.android.socialbase.downloader.i.z zVar) {
        com.ss.android.socialbase.appdownloader.z zVar2 = new com.ss.android.socialbase.appdownloader.z();
        if (jSONObject == null) {
            return zVar2;
        }
        String strOptString = jSONObject.optString("type");
        zVar2.z = strOptString;
        if ("plan_b".equals(strOptString)) {
            zVar2.gc = MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM;
            if (com.ss.android.socialbase.appdownloader.z.a.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject, zVar)) {
                zVar2.g = 0;
                return zVar2;
            }
            z(zVar2, 3);
        } else {
            String strOptString2 = jSONObject.optString("device_plans");
            zVar2.gc = strOptString2;
            if (!TextUtils.isEmpty(strOptString2)) {
                for (String str : strOptString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.z.a.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), str, jSONObject, zVar)) {
                        zVar2.g = 0;
                        return zVar2;
                    }
                    z(zVar2, 3);
                }
            }
        }
        return zVar2;
    }

    public static com.ss.android.socialbase.appdownloader.z g(JSONObject jSONObject, com.ss.android.socialbase.downloader.i.z zVar) {
        com.ss.android.socialbase.appdownloader.z zVar2 = new com.ss.android.socialbase.appdownloader.z();
        if (jSONObject == null) {
            return zVar2;
        }
        zVar2.z = jSONObject.optString("type");
        zVar2.gc = "vbi";
        if (com.ss.android.socialbase.appdownloader.z.a.z(com.ss.android.socialbase.downloader.downloader.dl.xl(), "vbi", jSONObject, zVar)) {
            zVar2.g = 0;
        } else {
            z(zVar2, 3);
        }
        return zVar2;
    }

    public static com.ss.android.socialbase.appdownloader.z z(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.i.z zVar) {
        com.ss.android.socialbase.appdownloader.z zVar2 = new com.ss.android.socialbase.appdownloader.z();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.m.gc.dl()) {
            zVar2.z = jSONObject.optString("type");
            if (zVar.z("bi", 0) == 1) {
                zVar2.g = 0;
                return zVar2;
            }
            if (z(context)) {
                zVar2.g = 2;
            } else if (com.ss.android.socialbase.appdownloader.m.z.z(str) != null) {
                zVar2.g = 0;
            } else {
                zVar2.g = 9;
            }
        }
        return zVar2;
    }

    private static void z(com.ss.android.socialbase.appdownloader.z zVar, int i) {
        if (zVar.g != -1) {
            zVar.g = (zVar.g * 10) + i;
        } else {
            zVar.g = i;
        }
    }

    private static boolean z(File file, com.ss.android.socialbase.downloader.e.dl dlVar, JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject jSONObjectA = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).a("download_dir");
        File file2 = null;
        String strOptString = jSONObjectA != null ? jSONObjectA.optString("ins_desc") : null;
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

    public static boolean z(Context context, Intent intent, JSONObject jSONObject, int i, com.ss.android.socialbase.appdownloader.z zVar) {
        if (context != null && jSONObject != null) {
            long jOptLong = jSONObject.optLong("jump_interval", 0L);
            if (jOptLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferencesG = com.bytedance.sdk.openadsdk.api.plugin.g.g(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferencesG.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= jOptLong && !z(context)) {
                sharedPreferencesG.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (z(context, intent2, false)) {
                            a(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (zVar != null) {
                            zVar.g = 1;
                            zVar.dl = "tryShowUnknownSourceDialog" + z(th);
                        }
                        return false;
                    }
                }
                if (z(context, intent, i, jSONObject)) {
                    dl(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean z(Context context, Intent intent, int i, JSONObject jSONObject) {
        try {
            com.ss.android.socialbase.appdownloader.m.gc.dl();
            if (context.getApplicationInfo().targetSdkVersion >= 26 && !gc(context)) {
                com.ss.android.socialbase.appdownloader.z.g gVar = new com.ss.android.socialbase.appdownloader.z.g(context);
                if (gVar.z()) {
                    z(context, intent, i, jSONObject, new InterfaceC0454g() { // from class: com.ss.android.socialbase.appdownloader.g.2
                        @Override // com.ss.android.socialbase.appdownloader.g.InterfaceC0454g
                        public boolean z(Context context2) {
                            return g.gc(context2);
                        }
                    });
                    return g(context, gVar.g());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.appdownloader.g$1, reason: invalid class name */
    static class AnonymousClass1 implements InterfaceC0454g {
        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.appdownloader.g.InterfaceC0454g
        public boolean z(Context context) {
            return g.a(context);
        }
    }

    public static boolean z(Context context) {
        if (context == null) {
            return true;
        }
        try {
            com.ss.android.socialbase.appdownloader.m.gc.dl();
            if (context.getApplicationInfo().targetSdkVersion >= 26) {
                return gc(context);
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean gc(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean z() {
        return gc.z == 1;
    }

    private static void a(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z2 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.socialbase.downloader.downloader.dl.gp().g(i, "guide_auth_dialog_show", jSONObject2);
    }

    public static void z(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z2 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.socialbase.downloader.downloader.dl.gp().g(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    public static void g(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z2 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.socialbase.downloader.downloader.dl.gp().g(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    public static void dl(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z2 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z2) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.socialbase.downloader.downloader.dl.gp().g(i, "guide_auth_open_setting", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(int i, boolean z2, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z2 ? 1 : 2);
            if (!z3) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception e) {
            wp.z(e);
        }
        com.ss.android.socialbase.downloader.downloader.dl.gp().g(i, "guide_auth_result", jSONObject);
    }

    private static void z(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0454g interfaceC0454g) {
        if (dl != null) {
            com.ss.android.socialbase.downloader.z.z.z().g(dl);
            dl = null;
        }
        dl = new z(context, intent, i, jSONObject, interfaceC0454g);
        com.ss.android.socialbase.downloader.z.z.z().z(dl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean g(Context context, Intent intent) {
        return z(context, intent, true);
    }

    public static boolean z(Context context, Intent intent, boolean z2) {
        if (context == null || intent == null) {
            return false;
        }
        if (z2) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String z(Throwable th) {
        String string = th.toString();
        return string.length() > 800 ? string.substring(0, 500) : string;
    }

    private static class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f2032a;
        private final Handler dl;
        private final InterfaceC0454g g;
        private final Context z;

        public a(Handler handler, Context context, InterfaceC0454g interfaceC0454g, long j) {
            this.z = context;
            this.g = interfaceC0454g;
            this.dl = handler;
            this.f2032a = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0454g interfaceC0454g;
            try {
                interfaceC0454g = this.g;
            } catch (Throwable unused) {
            }
            if (interfaceC0454g != null) {
                long j = this.f2032a;
                if (j > 0 && j <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    Context context = this.z;
                    boolean z = context != null ? interfaceC0454g.z(context) : false;
                    Message messageObtain = Message.obtain();
                    if (z) {
                        messageObtain.what = 2;
                        this.dl.sendMessage(messageObtain);
                    } else {
                        messageObtain.what = 1;
                        this.dl.sendMessageDelayed(messageObtain, this.f2032a);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public static void z(dl dlVar) {
        g = dlVar;
    }

    private static class z implements z.InterfaceC0484z {
        private JSONObject dl;
        private final int g;
        private final gc z;

        public z(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC0454g interfaceC0454g) {
            this.dl = jSONObject;
            int iOptInt = jSONObject.optInt("query_interval", 1000);
            this.g = iOptInt;
            this.z = new gc(context, intent, i, interfaceC0454g, iOptInt);
        }

        @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
        public void g() {
            if (!this.z.fo) {
                Message messageObtain = Message.obtain();
                messageObtain.what = 2;
                this.z.m.sendMessage(messageObtain);
            }
            com.ss.android.socialbase.downloader.z.z.z().g(this);
            z unused = g.dl = null;
        }

        @Override // com.ss.android.socialbase.downloader.z.z.InterfaceC0484z
        public void dl() {
            int iOptInt = this.dl.optInt("time_out_second", 20);
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            this.z.m.sendMessage(messageObtain);
            if (iOptInt <= 0 || iOptInt >= 60) {
                return;
            }
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 2;
            this.z.m.sendMessageDelayed(messageObtain2, iOptInt * 1000);
        }
    }

    private static class gc implements gz.z {
        private static int g;
        public static int z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f2033a;
        private final Context dl;
        private final long e;
        private boolean fo = false;
        private final InterfaceC0454g gc;
        private Future<Boolean> gz;
        private final Handler m;

        public gc(Context context, Intent intent, int i, InterfaceC0454g interfaceC0454g, long j) {
            this.dl = context;
            this.f2033a = intent;
            g = i;
            this.gc = interfaceC0454g;
            this.m = new com.ss.android.socialbase.downloader.v.gz(Looper.getMainLooper(), this);
            this.e = j;
        }

        @Override // com.ss.android.socialbase.downloader.v.gz.z
        public void z(Message message) {
            if (message != null) {
                if (message.what == 1) {
                    long j = this.e;
                    if (j <= 0 || j > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    z = 1;
                    this.gz = com.ss.android.socialbase.downloader.downloader.dl.kb().submit(new a(this.m, this.dl, this.gc, this.e));
                    return;
                }
                if (message.what == 2) {
                    z = 2;
                    this.m.removeMessages(2);
                    this.m.removeMessages(1);
                    Future<Boolean> future = this.gz;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.fo && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.z.z.z().g())) {
                        Intent intent = this.f2033a;
                        if (intent != null) {
                            g.g(this.dl, intent);
                        } else {
                            com.ss.android.socialbase.downloader.e.dl dlVarGz = com.ss.android.socialbase.downloader.downloader.e.g(this.dl).gz(g);
                            if (dlVarGz != null && dlVarGz.no()) {
                                com.ss.android.socialbase.appdownloader.dl.g(this.dl, g, false);
                            }
                        }
                        this.fo = true;
                    }
                    g.g(g, this.f2033a == null, g.z(this.dl));
                }
            }
        }
    }
}
