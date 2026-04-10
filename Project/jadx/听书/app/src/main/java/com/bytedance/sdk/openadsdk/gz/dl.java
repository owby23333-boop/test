package com.bytedance.sdk.openadsdk.gz;

import com.bytedance.sdk.component.m.h;
import com.bytedance.sdk.component.m.wp;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements h {
    private static int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1437a;
    private long dl;
    private long g = 0;
    private String gc;

    public dl() {
        z++;
        this.gc = "image_request_" + z;
    }

    @Override // com.bytedance.sdk.component.m.h
    public void onStepStart(String str, wp wpVar) {
        if (!this.f1437a) {
            wpVar.getUrl();
            wpVar.getWidth();
            wpVar.getHeight();
            this.f1437a = true;
        }
        this.g = System.currentTimeMillis();
        z(str, wpVar);
    }

    @Override // com.bytedance.sdk.component.m.h
    public void onStepEnd(String str, wp wpVar) {
        this.dl += System.currentTimeMillis() - this.g;
        z(str, wpVar);
    }

    private String z(String str, wp wpVar) {
        com.bytedance.sdk.component.m.dl.z zVarKb;
        if (str == null) {
            return str;
        }
        str.hashCode();
        switch (str) {
            case "success":
                return "成功";
            case "raw_cache":
                return "查询RAW内存缓存";
            case "image_type":
                return "判断图片类型：";
            case "disk_cache":
                return "查询文件缓存";
            case "decode":
                return "解码";
            case "failed":
                if (!(wpVar instanceof com.bytedance.sdk.component.m.dl.dl) || (zVarKb = ((com.bytedance.sdk.component.m.dl.dl) wpVar).kb()) == null) {
                    return "失败";
                }
                Throwable thDl = zVarKb.dl();
                return "失败：code:" + zVarKb.z() + ", msg:" + zVarKb.g() + ", exception:" + (thDl != null ? thDl.getMessage() : "null \r\n");
            case "check_duplicate":
                return "检查重复请求";
            case "memory_cache":
                return "查询Bitmap内存缓存";
            case "net_request":
                return "请求网络";
            case "generate_key":
                return "生成KEY:" + wpVar.getMemoryCacheKey();
            case "cache_policy":
                return "查询缓存策略";
            default:
                return str;
        }
    }
}
