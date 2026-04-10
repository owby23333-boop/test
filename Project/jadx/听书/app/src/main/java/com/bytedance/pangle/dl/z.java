package com.bytedance.pangle.dl;

import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.m;
import com.bytedance.pangle.uy;
import com.funny.audio.core.utils.FileUtils;
import com.umeng.analytics.pro.an;
import java.io.File;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<File> f508a;
    private JSONObject dl;
    private String e;
    private String g;
    private File gc;
    private JSONObject m;
    private String z;

    public static z z(JSONObject jSONObject, File file, List<File> list) {
        z zVar = new z();
        zVar.z = jSONObject.optString("version");
        zVar.g = jSONObject.optString(an.o);
        zVar.dl = jSONObject.optJSONObject("adn_adapter_md5");
        zVar.e = jSONObject.optString("alias_package_name");
        zVar.f508a = list;
        zVar.gc = file;
        zVar.m = jSONObject;
        return zVar;
    }

    public boolean z() {
        return gz() && fo();
    }

    private boolean gz() {
        JSONObject jSONObject;
        Map<String, JSONObject> mapGc = uy.z().gc();
        if (mapGc != null && mapGc.size() > 0 && (jSONObject = mapGc.get(this.g)) != null && jSONObject.has("packageName") && TextUtils.equals(jSONObject.optString("packageName"), this.g)) {
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName success , packageName=" + this.g);
            return true;
        }
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "DexPluginConfig check packageName fail, packageName=" + this.g + ", packageManager=" + mapGc);
        return false;
    }

    private boolean fo() {
        JSONObject jSONObject;
        List<File> list = this.f508a;
        boolean z = false;
        if (list != null && list.size() != 0 && (jSONObject = this.dl) != null && jSONObject.length() != 0) {
            int size = this.f508a.size();
            int length = this.dl.length();
            for (File file : this.f508a) {
                String strZ = m.z(file);
                if (strZ != null) {
                    strZ = strZ.toLowerCase();
                }
                String strZ2 = z(file.getName());
                if (TextUtils.equals(strZ2, strZ)) {
                    size--;
                    length--;
                } else {
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 fail, packageName=" + this.g + "downloadFileMd5=" + strZ + " configMd5=" + strZ2);
                }
            }
            if (size == 0 && length == 0) {
                z = true;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "DexPluginConfig check md5 " + (z ? "success" : "fail") + ", packageName=" + this.g + " fileSize=" + size + " configFileSize=" + length);
            return z;
        }
        StringBuilder sbAppend = new StringBuilder("DexPluginConfig check md5 fail, packageName=").append(this.g).append(" dexlist is ").append(this.f508a).append(" dexlist size is ");
        List<File> list2 = this.f508a;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, sbAppend.append(list2 == null ? -1 : list2.size()).toString());
        return false;
    }

    public String z(String str) {
        JSONObject jSONObject;
        return (TextUtils.isEmpty(str) || (jSONObject = this.dl) == null || !jSONObject.has(str)) ? "" : this.dl.optString(str);
    }

    public String g() {
        return this.g;
    }

    public int dl() {
        if (TextUtils.isEmpty(this.z)) {
            return -1;
        }
        String strReplace = this.z.replace(FileUtils.FILE_EXTENSION_SEPARATOR, "");
        if (TextUtils.isEmpty(strReplace)) {
            return -1;
        }
        try {
            return Integer.valueOf(strReplace).intValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public List<File> a() {
        return this.f508a;
    }

    public File gc() {
        return this.gc;
    }

    public JSONObject m() {
        return this.m;
    }

    public String e() {
        return this.e;
    }

    public String toString() {
        return "DexPluginConfig{mVersion='" + this.z + "', mPackageName='" + this.g + "'}";
    }
}
