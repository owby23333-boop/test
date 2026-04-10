package com.bytedance.sdk.component.wp.g.z;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.DataLoaderHelper;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.z.g;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class z implements g {
    private long z;
    private String g = "tt_video_reward_full";
    private String dl = "tt_video_brand";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f854a = "tt_video_splash";
    private String gc = "tt_video_default";
    private String m = null;
    private String e = null;
    private String gz = null;
    private String fo = null;
    private String uy = null;
    private String kb = null;

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public void gc() {
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public void z(String str) {
        if (!TextUtils.isEmpty(this.kb) && !this.kb.equals(str)) {
            this.m = null;
            this.e = null;
            this.gz = null;
            this.fo = null;
            this.uy = null;
        }
        this.kb = str;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String a() {
        if (this.uy == null) {
            this.uy = this.kb + File.separator + this.gc;
            File file = new File(this.uy);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.uy;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String z() {
        if (this.e == null) {
            this.e = this.kb + File.separator + this.g;
            File file = new File(this.e);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.e;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String g() {
        if (this.gz == null) {
            this.gz = this.kb + File.separator + this.dl;
            File file = new File(this.gz);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.gz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public String dl() {
        if (this.fo == null) {
            this.fo = this.kb + File.separator + this.f854a;
            File file = new File(this.fo);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return this.fo;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public boolean z(a aVar) {
        DataLoaderHelper.DataLoaderCacheInfo cacheInfoByFilePath = TTVideoEngine.getCacheInfoByFilePath(aVar.p(), aVar.gc());
        if (cacheInfoByFilePath != null) {
            boolean zI = aVar.i();
            this.z = cacheInfoByFilePath.mCacheSizeFromZero;
            int iG = aVar.g() > 0 ? aVar.g() : aVar.m();
            if (zI) {
                iG = (int) aVar.wp();
            }
            if (cacheInfoByFilePath.mCacheSizeFromZero >= iG) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z.g
    public long g(a aVar) {
        return this.z;
    }
}
