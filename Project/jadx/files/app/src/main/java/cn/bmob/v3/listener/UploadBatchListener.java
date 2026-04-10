package cn.bmob.v3.listener;

import cn.bmob.v3.datatype.BmobFile;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface UploadBatchListener {
    void onError(int i2, String str);

    void onProgress(int i2, int i3, int i4, int i5);

    void onSuccess(List<BmobFile> list, List<String> list2);
}
