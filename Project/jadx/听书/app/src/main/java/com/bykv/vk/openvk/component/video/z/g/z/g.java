package com.bykv.vk.openvk.component.video.z.g.z;

import android.content.Context;
import com.bykv.vk.openvk.component.video.z.g.a;
import com.bykv.vk.openvk.component.video.z.g.gc;
import com.bytedance.sdk.component.uy.fo;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    public final File z;

    public void z() {
        com.bykv.vk.openvk.component.video.z.dl.z.z(new fo("clear") { // from class: com.bykv.vk.openvk.component.video.z.g.z.g.1
            @Override // java.lang.Runnable
            public void run() {
                g.this.g();
            }
        });
    }

    public void g() {
        a.dl().a();
        Context context = gc.getContext();
        if (context != null) {
            com.bykv.vk.openvk.component.video.z.g.g.dl.z(context).z(1);
        }
        for (File file : this.z.listFiles()) {
            try {
                file.delete();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z.z
    public File dl(String str) {
        return gc(str);
    }

    @Override // com.bykv.vk.openvk.component.video.z.g.z.z
    public File a(String str) {
        return gc(str);
    }

    File gc(String str) {
        return new File(this.z, str);
    }
}
