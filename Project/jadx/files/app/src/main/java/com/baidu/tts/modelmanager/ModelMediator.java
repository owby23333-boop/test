package com.baidu.tts.modelmanager;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.BasicHandler;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.LibEngineParams;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.DbManager;
import com.baidu.tts.database.StatisticsDbManager;
import com.baidu.tts.download.DownloadParams;
import com.baidu.tts.download.DownloaderClient;
import com.baidu.tts.enumtype.KeyEnum;
import com.baidu.tts.modelmanager.info.ModelInfoManager;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ModelMediator {
    private static final String TAG = "GetServerModelsWork";
    private Context mContext;
    private DbManager mDbManager;
    private DownloaderClient mDownloader;
    private ModelInfoManager mModelInfoManager;
    private StatisticsDbManager mStatisticsDbManager;

    public ModelMediator(Context context) {
        this.mContext = context;
        createColleague();
    }

    private void createColleague() {
        this.mDbManager = new DbManager(this);
        this.mStatisticsDbManager = new StatisticsDbManager(this);
        this.mModelInfoManager = new ModelInfoManager(this);
        this.mDownloader = new DownloaderClient();
        this.mDownloader.setModelMediator(this);
        this.mDownloader.start();
    }

    public String checkModelsUpdate(Set<String> set) {
        int i2;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        if (set == null || set.size() == 0 || set.isEmpty()) {
            return "params error";
        }
        try {
            Iterator<String> it = set.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                Conditions conditions = new Conditions();
                conditions.appendId(next);
                ModelBags modelBags = getLocalModels(conditions, false).get();
                JSONArray json = modelBags.toJson();
                if (modelBags.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    if (Pattern.compile("^[0-9]+$").matcher(next).find()) {
                        jSONObject.put("id", Integer.valueOf(next));
                        jSONObject.put("needUpdate", 2);
                        jSONArray.put(jSONObject);
                    } else {
                        LoggerProxy.e(TAG, "params error id " + next + " is not int");
                    }
                } else {
                    jSONArray2.put(json.get(0));
                }
            }
            if (jSONArray2.length() != 0) {
                String str = this.mModelInfoManager.checkModelsUpdate(jSONArray2).get();
                if (str.equals("")) {
                    LoggerProxy.d(TAG, "servers return result is empty");
                } else {
                    JSONArray jSONArray3 = new JSONArray(str);
                    for (i2 = 0; i2 < jSONArray3.length(); i2++) {
                        jSONArray.put(jSONArray3.get(i2));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }

    public int deleteStatisticsData(int i2, int i3) {
        return this.mStatisticsDbManager.delteData(i2, i3);
    }

    public DownloadHandler download(DownloadParams downloadParams) {
        return this.mDownloader.download(downloadParams);
    }

    public Context getContext() {
        return this.mContext;
    }

    public DbManager getDbManager() {
        return this.mDbManager;
    }

    public LibEngineParams getEngineParams() {
        return this.mModelInfoManager.getEngineParams();
    }

    public BasicHandler<ModelFileBags> getLocalModelFileInfos(Set<String> set) {
        return this.mModelInfoManager.getLocalModelFileInfos(set);
    }

    public BasicHandler<ModelBags> getLocalModels(Conditions conditions, boolean z2) {
        return this.mModelInfoManager.getLocalModels(conditions, z2);
    }

    public String getModelFileAbsPath(String str, String str2) {
        return this.mDbManager.getModelFileAbsPath(str, str2);
    }

    public ModelInfoManager getModelInfoManager() {
        return this.mModelInfoManager;
    }

    public BasicHandler<ModelBags> getServerDefaultModels() {
        return this.mModelInfoManager.getServerDefaultModels();
    }

    public BasicHandler<ModelFileBags> getServerModelFileInfos(Set<String> set) {
        return this.mModelInfoManager.getServerModelFileInfos(set);
    }

    public BasicHandler<ModelBags> getServerModels(Conditions conditions) {
        return this.mModelInfoManager.getServerModels(conditions);
    }

    public void insertModelBags(ModelBags modelBags) {
        this.mDbManager.insertModelBags(modelBags);
    }

    public void insertModelFileBags(ModelFileBags modelFileBags) {
        this.mDbManager.insertModelFileBags(modelFileBags);
    }

    public void insertStatisticsData(String str) {
        this.mStatisticsDbManager.insertData(str);
    }

    public boolean isModelFileValid(String str) {
        Map<String, String> mapSelectModelFileInfo = this.mDbManager.selectModelFileInfo(str);
        if (DataTool.isMapEmpty(mapSelectModelFileInfo)) {
            return false;
        }
        String str2 = mapSelectModelFileInfo.get(KeyEnum.ABS_PATH.getFullName());
        String str3 = mapSelectModelFileInfo.get(KeyEnum.LENGTH.getFullName());
        String str4 = mapSelectModelFileInfo.get(KeyEnum.MD5.getFullName());
        File file = new File(str2);
        return file.exists() && file.length() == Long.parseLong(str3) && MD5.getInstance().getBigFileMd5(file).equalsIgnoreCase(str4);
    }

    public boolean isModelValid(String str) {
        Map<String, String> mapSelectModelInfo = this.mDbManager.selectModelInfo(str);
        if (DataTool.isMapEmpty(mapSelectModelInfo)) {
            return false;
        }
        return isModelFileValid(mapSelectModelInfo.get(KeyEnum.TEXT_DATA_ID.getFullName())) && isModelFileValid(mapSelectModelInfo.get(KeyEnum.SPEECH_DATA_ID.getFullName()));
    }

    public Map<String, ArrayList> selectStatisticsData() {
        return this.mStatisticsDbManager.selectData();
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void stop() {
        this.mDownloader.stop();
    }

    public void updataStatisticsData(String str, String str2, String str3) {
        this.mStatisticsDbManager.update(str, str2, str3);
    }
}
