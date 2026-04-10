package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static volatile i z;
    private SharedPreferences g = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    public static i z() {
        if (z == null) {
            synchronized (i.class) {
                if (z == null) {
                    z = new i();
                }
            }
        }
        return z;
    }

    private i() {
    }

    public void z(String str) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putString("ROM_LAST_".concat(String.valueOf(str)), Build.VERSION.INCREMENTAL);
        editorEdit.apply();
    }

    public boolean g(String str) {
        return !TextUtils.isEmpty(this.g.getString("HOST_ABI_".concat(String.valueOf(str)), ""));
    }

    public boolean dl(String str) {
        boolean z2 = !TextUtils.equals(this.g.getString("HOST_ABI_".concat(String.valueOf(str)), ""), Zeus.getHostAbi());
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils isHostAbiUpdate HOST_ABI=" + this.g.getString("HOST_ABI_".concat(String.valueOf(str)), "") + ", " + Zeus.getHostAbi() + ", result=" + z2);
        return z2;
    }

    public void a(String str) {
        String string = this.g.getString("HOST_ABI_".concat(String.valueOf(str)), "");
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putString("HOST_ABI_".concat(String.valueOf(str)), Zeus.getHostAbi());
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostAbiUpdated HOST_ABI=" + string + " --> " + Zeus.getHostAbi());
    }

    public int gc(String str) {
        int i = this.g.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    public void z(String str, int i) {
        int iGc = gc(str);
        if (iGc != i) {
            SharedPreferences.Editor editorEdit = this.g.edit();
            editorEdit.putInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), i);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setPluginApiVersion " + iGc + " --> " + i);
    }

    public String m(String str) {
        String string = this.g.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    public void z(String str, String str2) {
        String strM = m(str);
        if (!TextUtils.equals(strM, str2)) {
            SharedPreferences.Editor editorEdit = this.g.edit();
            editorEdit.putString("HOST_IDENTITY_".concat(String.valueOf(str)), str2);
            editorEdit.apply();
        }
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils setHostIdentity(" + str + ") " + strM + " --> " + str2);
    }

    public void z(String str, int i, int i2, int i3) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putInt("API_MIN_" + str + "_" + i, i2);
        editorEdit.putInt("API_MAX_" + str + "_" + i, i3);
        editorEdit.apply();
    }

    public int g(String str, int i) {
        return this.g.getInt("API_MIN_" + str + "_" + i, 0);
    }

    public int dl(String str, int i) {
        int i2 = this.g.getInt("API_MAX_" + str + "_" + i, Integer.MAX_VALUE);
        if (i2 == 0) {
            return Integer.MAX_VALUE;
        }
        return i2;
    }

    public void z(String str, int i, boolean z2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        String str2 = "DISABLE_DOWNLOAD_" + str + "_" + i;
        if (z2) {
            editorEdit.putInt(str2, 0);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markAllowDownloadFlag packageName=" + str + " version=" + i + " disable=" + z2);
    }

    public void e(String str) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putBoolean("UNINSTALL__".concat(String.valueOf(str)), true);
        editorEdit.apply();
        ZeusLogger.i(ZeusLogger.TAG_INIT, "ZeusSpUtils markUnInstallFlag packageName=".concat(String.valueOf(str)));
    }

    public void gz(String str) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.remove("UNINSTALL__".concat(String.valueOf(str)));
        editorEdit.apply();
    }

    public boolean fo(String str) {
        return this.g.getBoolean("UNINSTALL__".concat(String.valueOf(str)), false);
    }

    public String uy(String str) {
        return this.g.getString("IDENTITY_".concat(String.valueOf(str)), "");
    }

    public void g(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putString("IDENTITY_".concat(String.valueOf(str)), str2);
        editorEdit.apply();
    }

    public void g(String str, int i, boolean z2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        String str2 = "INSTALLED_" + str + "-" + i;
        if (z2) {
            editorEdit.putBoolean(str2, true);
        } else {
            editorEdit.remove(str2);
        }
        editorEdit.apply();
    }

    public boolean a(String str, int i) {
        return this.g.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    public void gc(String str, int i) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putInt("OFFLINE_INTERNAL_".concat(String.valueOf(str)), i);
        editorEdit.apply();
    }

    public boolean m(String str, int i) {
        return this.g.getInt(String.format(Locale.getDefault(), "OFFLINE_INTERNAL_%s", str), -1) == i;
    }

    public void dl(String str, int i, boolean z2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putBoolean("dex_opt_state_" + str + "_" + i, z2);
        editorEdit.apply();
    }

    public boolean e(String str, int i) {
        return this.g.getBoolean("dex_opt_state_" + str + "_" + i, false);
    }

    public boolean gz(String str, int i) {
        return this.g.getBoolean("dex_remove_state_" + str + "_" + i, false);
    }

    public void a(String str, int i, boolean z2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putBoolean("dex_remove_state_" + str + "_" + i, z2);
        editorEdit.apply();
    }

    public void z(String str, int i, int i2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putInt("remove_entry_flag_" + str + "_" + i, i2);
        editorEdit.apply();
    }

    public int fo(String str, int i) {
        return this.g.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    public void z(String str, int i, String str2) {
        int iG = g(str, i, str2);
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, iG + 1);
        editorEdit.apply();
    }

    public int g(String str, int i, String str2) {
        return this.g.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    public void dl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZ = m.z(str);
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.putString("ALIAS_".concat(String.valueOf(strZ)), str2);
        editorEdit.apply();
    }

    public String kb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.g.getString("ALIAS_".concat(String.valueOf(m.z(str))), "");
    }

    public void wp(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZ = m.z(str);
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.remove("ALIAS_".concat(String.valueOf(strZ)));
        editorEdit.apply();
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.g.edit();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZ = m.z(str);
        String string = this.g.getString("ALIAS_LAST_TIME_".concat(String.valueOf(strZ)), "");
        if (TextUtils.isEmpty(string)) {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strZ)), str2);
        } else {
            editorEdit.putString("ALIAS_LAST_TIME_".concat(String.valueOf(strZ)), string + "_" + str2);
        }
        editorEdit.apply();
    }

    public List<String> i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = this.g.getString("ALIAS_LAST_TIME_".concat(String.valueOf(m.z(str))), "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return Arrays.asList(string.split("_"));
    }

    public void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strZ = m.z(str);
        SharedPreferences.Editor editorEdit = this.g.edit();
        editorEdit.remove("ALIAS_LAST_TIME_".concat(String.valueOf(strZ)));
        editorEdit.apply();
    }
}
