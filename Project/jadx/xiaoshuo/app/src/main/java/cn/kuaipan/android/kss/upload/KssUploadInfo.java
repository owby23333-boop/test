package cn.kuaipan.android.kss.upload;

import android.util.Log;
import cn.kuaipan.android.kss.IKssUploadRequestResult;
import cn.kuaipan.android.kss.KssDef;
import cn.kuaipan.android.utils.OAuthTimeUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class KssUploadInfo implements KssDef {
    private static final String LOG_TAG = "KssUploadInfo";
    boolean mBroken;
    ServerExpect mExpectInfo;
    private final UploadFileInfo mFileInfo;
    private final long mGenerateTime;
    private final IKssUploadRequestResult mRequestResult;

    public KssUploadInfo(UploadFileInfo uploadFileInfo, IKssUploadRequestResult iKssUploadRequestResult) {
        this(uploadFileInfo, iKssUploadRequestResult, OAuthTimeUtils.currentTime());
    }

    public String getCommitString() {
        Object obj;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("file_meta", this.mRequestResult.getFileMeta());
            int blockCount = this.mRequestResult.getBlockCount();
            JSONArray jSONArray = new JSONArray();
            if (this.mRequestResult != null && blockCount > 0) {
                for (int i = 0; i < blockCount; i++) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("commit_meta", this.mRequestResult.getBlock(i).meta);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("commit_metas", jSONArray);
            obj = jSONObject;
        } catch (JSONException unused) {
            Log.w(LOG_TAG, "Failed generate Json String for UploadRequestResult");
            obj = null;
        }
        return String.valueOf(obj);
    }

    public UploadFileInfo getFileInfo() {
        return this.mFileInfo;
    }

    public long getGenerateTime() {
        return this.mGenerateTime;
    }

    public IKssUploadRequestResult getRequestResult() {
        return this.mRequestResult;
    }

    public boolean isBroken() {
        return this.mBroken;
    }

    public boolean isCompleted() {
        IKssUploadRequestResult iKssUploadRequestResult = this.mRequestResult;
        return iKssUploadRequestResult != null && iKssUploadRequestResult.isCompleted();
    }

    public void markBroken() {
        this.mBroken = true;
    }

    public KssUploadInfo(UploadFileInfo uploadFileInfo, IKssUploadRequestResult iKssUploadRequestResult, long j) {
        this.mBroken = false;
        this.mExpectInfo = null;
        this.mFileInfo = uploadFileInfo;
        this.mRequestResult = iKssUploadRequestResult;
        this.mGenerateTime = j;
    }
}
