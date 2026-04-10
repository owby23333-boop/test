package com.baidu.tts.download.trace;

import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.DbManager;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ModelFileFlyweight {
    private Map<String, String> mDbFileInfoMap = new HashMap();
    private String mModelFileId;

    public ModelFileFlyweight(String str) {
        this.mModelFileId = str;
    }

    public String getAbsPath() {
        return DataTool.getMapValue(this.mDbFileInfoMap, KeyEnum.ABS_PATH.getFullName());
    }

    public Map<String, String> getDbFileInfoMap() {
        return this.mDbFileInfoMap;
    }

    public String getLength() {
        return DataTool.getMapValue(this.mDbFileInfoMap, KeyEnum.LENGTH.getFullName());
    }

    public String getMd5() {
        return DataTool.getMapValue(this.mDbFileInfoMap, KeyEnum.MD5.getFullName());
    }

    public String getModelFileId() {
        return this.mModelFileId;
    }

    public void insertModelFileBags(ModelFileBags modelFileBags, DbManager dbManager) {
        dbManager.insertModelFileBags(modelFileBags);
        isDbModelFileValid(dbManager);
    }

    public boolean isDbModelFileValid(DbManager dbManager) {
        this.mDbFileInfoMap = dbManager.selectModelFileInfo(this.mModelFileId);
        if (DataTool.isMapEmpty(this.mDbFileInfoMap)) {
            return false;
        }
        String str = this.mDbFileInfoMap.get(KeyEnum.ABS_PATH.getFullName());
        if (StringTool.isEmpty(str)) {
            dbManager.deleteModelFileItem(this.mModelFileId);
            return false;
        }
        TracePool.getInstance().getFsFileMemory(str).setFileId(this.mModelFileId);
        return true;
    }

    public void setDbFileInfoMap(Map<String, String> map) {
        this.mDbFileInfoMap = map;
    }
}
