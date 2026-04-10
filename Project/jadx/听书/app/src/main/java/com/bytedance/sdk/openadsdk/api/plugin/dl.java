package com.bytedance.sdk.openadsdk.api.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.plugin.fo;
import com.bytedance.sdk.openadsdk.api.plugin.gz;
import java.io.File;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
class dl {
    private static volatile dl dl;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f894a;
    private volatile boolean e;
    private final Function<SparseArray<Object>, Object> gc = new fo.dl();
    private gz.z m;
    private static final String z = File.separator + "next";
    private static final String g = File.separator + "tmp";

    private dl(Context context) {
        this.f894a = context;
    }

    public static dl z(Context context) {
        if (dl == null) {
            synchronized (dl.class) {
                if (dl == null) {
                    dl = new dl(context);
                }
            }
        }
        return dl;
    }

    public void z(List<gz.z> list) {
        if (list == null || list.isEmpty()) {
            gc.z("plugin_download", "plugin is empty");
            return;
        }
        gz.z zVar = list.get(0);
        this.m = zVar;
        if (TextUtils.isEmpty(zVar.dl)) {
            return;
        }
        String str = this.m.z + "-" + this.m.g + "-" + this.m.m + "-" + this.m.e + ".apk";
        File fileDl = dl();
        File file = new File(fileDl, str);
        if (file.exists()) {
            gc.z("plugin_download", "plugin file already exists");
            com.bytedance.sdk.openadsdk.api.m.g("FileDownloadTask", "Plugin file already exists.");
            this.m.fo = file.getAbsolutePath();
            gz.z zVar2 = this.m;
            zVar2.uy = zVar2.g < 7105;
            z(true, this.m.z, this.m.toString());
            return;
        }
        File fileG = g();
        if (!fileDl.exists()) {
            fileDl.mkdirs();
        }
        if (!fileG.exists()) {
            fileG.mkdirs();
        }
        z(this.m.dl, fileDl.getAbsolutePath(), fileG.getAbsolutePath(), str);
    }

    private void z(String str, String str2, String str3, String str4) {
        if (this.e) {
            com.bytedance.sdk.openadsdk.api.m.g("FileDownloadTask", "Downloading...");
            return;
        }
        this.e = true;
        try {
            File file = new File(str2 + "/" + str4);
            if (file.exists()) {
                file.delete();
            }
            com.bytedance.sdk.openadsdk.api.plugin.g.dl.z().z(str, str2, str4, new EventListener() { // from class: com.bytedance.sdk.openadsdk.api.plugin.dl.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    dl.this.e = false;
                    if (i == 0) {
                        gc.z("plugin_download", "download success");
                        dl.this.m.fo = result.message();
                        com.bytedance.sdk.openadsdk.api.m.g("FileDownloadTask", "Download end." + dl.this.m.fo);
                        dl.this.m.uy = dl.this.m.g < 7105;
                        dl dlVar = dl.this;
                        dlVar.z(true, dlVar.m.z, dl.this.m.toString());
                        return null;
                    }
                    String strMessage = result.message();
                    gc.z("plugin_download", "download failed: ".concat(String.valueOf(strMessage)));
                    com.bytedance.sdk.openadsdk.api.m.gc("FileDownloadTask", "Download failed. ".concat(String.valueOf(strMessage)));
                    dl dlVar2 = dl.this;
                    dlVar2.z(false, dlVar2.m.z, dl.this.m.toString());
                    return null;
                }
            });
            gc.z("plugin_download", "start download");
            com.bytedance.sdk.openadsdk.api.m.g("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            gc.z("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.bytedance.sdk.openadsdk.api.m.gc("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z2, String str, String str2) {
        ValueSet valueSetG = com.bykv.z.z.z.z.dl.z().z(-999900, z2 ? 0 : 1004).z(-999903, z2).z(-999902, com.bykv.z.z.z.z.dl.z().z(2, str2).z(3, str).g().sparseArray()).g();
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, valueSetG.sparseArray());
        this.gc.apply(sparseArray);
    }

    private File z() {
        return g.z(this.f894a, "tt_pangle_bykv_file", 0);
    }

    private File g() {
        return new File(z(), g);
    }

    private File dl() {
        return new File(z(), z);
    }
}
