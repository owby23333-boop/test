package cn.kuaipan.kss.appmaster;

import cn.kuaipan.kss.KssDef;
import cn.kuaipan.kss.KssDownload;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestDownloadParse implements KssDownload.RequestDownloadInfo {
    private KssDef.KssAPIResult m_Result = KssDef.KssAPIResult.Error;
    private String m_secureKey = null;
    private int m_fileSize = 0;
    private List<_BlockInfo> m_blockInfos = new ArrayList();

    @Override // cn.kuaipan.kss.KssDownload.RequestDownloadInfo
    public int getBlockCount() {
        return this.m_blockInfos.size();
    }

    @Override // cn.kuaipan.kss.KssDownload.RequestDownloadInfo
    public KssDownload.BlockDownloadInfo getBlockInfos(int i) {
        if (i < 0 || i >= this.m_blockInfos.size()) {
            return null;
        }
        return this.m_blockInfos.get(i);
    }

    @Override // cn.kuaipan.kss.KssDownload.RequestDownloadInfo
    public int getFileSize() {
        return this.m_fileSize;
    }

    @Override // cn.kuaipan.kss.KssDownload.RequestDownloadInfo
    public KssDef.KssAPIResult getResult() {
        return this.m_Result;
    }

    @Override // cn.kuaipan.kss.KssDownload.RequestDownloadInfo
    public String getSecureKey() {
        return this.m_secureKey;
    }

    public boolean parseRequestDownloadInfo(JSONObject jSONObject) {
        this.m_fileSize = 0;
        try {
            if (!jSONObject.get("stat").equals("OK")) {
                return false;
            }
            this.m_Result = KssDef.KssAPIResult.OK;
            this.m_secureKey = jSONObject.getString("secure_key");
            JSONArray jSONArray = jSONObject.getJSONArray("blocks");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                _BlockInfo _blockinfo = new _BlockInfo(i);
                _blockinfo.parseBlockInfo(jSONObject2);
                this.m_blockInfos.add(_blockinfo);
                this.m_fileSize += _blockinfo.getBlockSize();
            }
            return true;
        } catch (Exception unused) {
            this.m_fileSize = 0;
            return false;
        }
    }

    public boolean parseRequestDownloadInfo(String str) {
        try {
            return parseRequestDownloadInfo(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
