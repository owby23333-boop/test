package cn.bmob.v3.datatype.up;

import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public class ProgressHelper {
    public static ProgressRequestBody addProgressListener(RequestBody requestBody, UpProgressListener upProgressListener) {
        return new ProgressRequestBody(requestBody, upProgressListener);
    }
}
