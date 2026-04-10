package cn.kuaipan.kss.implement;

import cn.kuaipan.android.kss.KssDef;
import cn.kuaipan.kss.KssDef;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class _UploadChunkInfo {
    private String m_stateStr = null;
    private String m_uploadID = null;
    private String m_commitMeta = null;

    private boolean needReRequestMetadata(String str) {
        String[] strArr = {KssDef.ERR_INVALID_FILE_META, KssDef.ERR_INVALID_BLOCK_META, KssDef.ERR_INVALID_UPLOAD_ID, KssDef.ERR_BLOCK_CORRUPTED};
        for (int i = 0; i < 4; i++) {
            if (str.equals(strArr[i])) {
                return true;
            }
        }
        return false;
    }

    public String getCommitMeta() {
        return this.m_commitMeta;
    }

    public String getUploadID() {
        return this.m_uploadID;
    }

    public KssDef.KssAPIResult parseInfo(String str) {
        KssDef.KssAPIResult kssAPIResult = KssDef.KssAPIResult.OK;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("stat");
            this.m_stateStr = string;
            if (string.equals("CONTINUE_UPLOAD")) {
                if (this.m_uploadID == null && jSONObject.has("upload_id")) {
                    this.m_uploadID = jSONObject.getString("upload_id");
                }
                return this.m_uploadID == null ? KssDef.KssAPIResult.Error : kssAPIResult;
            }
            if (!this.m_stateStr.equals("BLOCK_COMPLETED")) {
                return needReRequestMetadata(this.m_stateStr) ? KssDef.KssAPIResult.NeedRequest : kssAPIResult;
            }
            if (!jSONObject.has("commit_meta")) {
                return kssAPIResult;
            }
            this.m_commitMeta = jSONObject.getString("commit_meta");
            return kssAPIResult;
        } catch (Exception e) {
            e.printStackTrace();
            return KssDef.KssAPIResult.Error;
        }
    }

    public void reset() {
        this.m_stateStr = null;
        this.m_uploadID = null;
        this.m_commitMeta = null;
    }
}
