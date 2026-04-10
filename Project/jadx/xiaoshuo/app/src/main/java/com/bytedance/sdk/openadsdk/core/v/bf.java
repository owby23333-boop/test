package com.bytedance.sdk.openadsdk.core.v;

import com.bytedance.sdk.component.utils.wu;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes10.dex */
public class bf extends e {
    private int bf;
    private volatile boolean d;
    private int e;

    public bf(int i, int i2) {
        this.e = 15;
        this.bf = 3;
        if (i <= 0) {
            throw new IllegalArgumentException("Max count must be positive number!");
        }
        this.e = i;
        this.bf = i2;
    }

    private void d(List<File> list) {
        long jBf = bf(list);
        int size = list.size();
        if (e(jBf, size)) {
            return;
        }
        for (File file : list) {
            long length = file.length();
            if (file.delete()) {
                size--;
                jBf -= length;
                wu.d("TotalCountLruDiskFile", "Cache file " + file + " is deleted because it exceeds cache limit");
            } else {
                wu.d("TotalCountLruDiskFile", "Error deleting file " + file + " for trimming cache");
            }
            if (e(file, jBf, size)) {
                return;
            }
        }
    }

    private void tg(List<File> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                long jBf = bf(list);
                int size = list.size();
                boolean zE = e(jBf, size);
                if (zE) {
                    wu.d("splashLoadAd", "不满足删除条件，不执行删除操作(true)" + zE);
                    return;
                }
                TreeMap treeMap = new TreeMap();
                for (File file : list) {
                    treeMap.put(Long.valueOf(file.lastModified()), file);
                }
                for (Map.Entry entry : treeMap.entrySet()) {
                    if (entry != null && !zE) {
                        wu.vn("splashLoadAd", "LRUDeleteFile deleting fileTime " + ((Long) entry.getKey()).longValue());
                        File file2 = (File) entry.getValue();
                        long length = file2.length();
                        if (file2.delete()) {
                            size--;
                            jBf -= length;
                            wu.d("splashLoadAd", "删除 一个 Cache file 当前总个数：" + size);
                        } else {
                            wu.vn("splashLoadAd", "Error deleting file " + file2 + " for trimming cache");
                        }
                        if (e(file2, jBf, size)) {
                            wu.d("splashLoadAd", "停止删除 当前总个数 totalCount：" + size + " 最大值存储上限个数 maxCount " + this.e + " 最小个数 " + this.bf);
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.v.e
    public boolean e(long j, int i) {
        return i <= this.e;
    }

    @Override // com.bytedance.sdk.openadsdk.core.v.e
    public boolean e(File file, long j, int i) {
        return i <= this.bf;
    }

    @Override // com.bytedance.sdk.openadsdk.core.v.e
    public void e(List<File> list) {
        if (this.d) {
            tg(list);
            this.d = false;
        } else {
            d(list);
        }
    }
}
