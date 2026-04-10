package com.bytedance.adsdk.ugeno.gc.g;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import com.bytedance.adsdk.ugeno.gc.m;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends z {
    public gc(com.bytedance.adsdk.ugeno.g.dl dlVar, String str, m.z zVar) {
        super(dlVar, str, zVar);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.g.z
    public void z() {
        if (this.m == null || this.m.size() <= 0) {
            return;
        }
        String str = this.m.get("id");
        if (TextUtils.isEmpty(str)) {
            z(this.dl);
            return;
        }
        com.bytedance.adsdk.ugeno.g.dl dlVarG = this.dl.g(this.dl);
        if (dlVarG == null) {
            return;
        }
        z(dlVarG.a(str));
    }

    private void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        for (String str : this.m.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id")) {
                dlVar.z(str, this.m.get(str));
            }
        }
        dlVar.z(this.m.containsKey(MediaFormat.KEY_WIDTH), this.m.containsKey(MediaFormat.KEY_HEIGHT));
        dlVar.g();
    }
}
