package com.bytedance.sdk.openadsdk.core.uy;

import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    private volatile boolean dl;
    private int g;
    private int z;

    public g(int i, int i2) {
        this.z = 15;
        this.g = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.z = i;
        this.g = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.uy.z
    protected boolean z(long j, int i) {
        return i <= this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.uy.z
    protected boolean z(File file, long j, int i) {
        return i <= this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.uy.z
    protected void z(List<File> list) {
        if (this.dl) {
            a(list);
            this.dl = false;
        } else {
            dl(list);
        }
    }

    private void dl(List<File> list) {
        long jG = g(list);
        int size = list.size();
        if (z(jG, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jG -= length;
                wp.z("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                wp.z("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (z(file, jG, size)) {
                return;
            }
        }
    }

    private void a(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long jG = g(list);
                int size = list.size();
                boolean z = z(jG, size);
                if (z) {
                    wp.z("splashLoadAd", "不满足删除条件，不执行删除操作(true)".concat(String.valueOf(z)));
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !z) {
                        wp.a("splashLoadAd", "LRUDeleteFile deleting fileTime ".concat(String.valueOf(((Long) entry.getKey()).longValue())));
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jG -= length;
                            wp.z("splashLoadAd", "删除 一个 Cache file 当前总个数：".concat(String.valueOf(size)));
                        } else {
                            wp.a("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (z(file2, jG, size)) {
                            wp.z("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.z + " 最小个数 " + this.g);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
