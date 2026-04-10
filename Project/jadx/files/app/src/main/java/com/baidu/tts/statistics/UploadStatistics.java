package com.baidu.tts.statistics;

import android.content.Context;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.UrlEnum;
import com.baidu.tts.modelmanager.ModelMediator;
import com.baidu.tts.network.HttpClientUtil;
import com.baidu.tts.tools.CommonUtility;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UploadStatistics {
    private static final String TAG = "UploadStatistics";
    private Context context;
    private FutureTask<Integer> futureTask;
    private GetStatisticsInfo mGetStatisticsInfo;
    private ModelMediator mModelMediator;
    private int startId = 0;
    private int endId = 0;
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public class UploadWork implements Callable<Integer> {
        public UploadWork() {
        }

        private String getEntity() {
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = UploadStatistics.this.mModelMediator.selectStatisticsData().get("listId");
            if (arrayList.size() != 0) {
                UploadStatistics.this.startId = ((Integer) arrayList.get(0)).intValue();
                UploadStatistics.this.endId = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            JSONArray jSONArray = new JSONArray((Collection) UploadStatistics.this.mModelMediator.selectStatisticsData().get("list"));
            try {
                jSONObject.put("deviceInfo", GetStatisticsInfo.getDeviceInfo(UploadStatistics.this.context));
                jSONObject.put("appinfo", GetStatisticsInfo.getAPPInfo(UploadStatistics.this.context));
                jSONObject.put("methodinfo", jSONArray);
                LoggerProxy.d(UploadStatistics.TAG, "StatisticsData= " + jSONObject.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            map.put("d", jSONObject.toString());
            try {
                return CommonUtility.urlEncoded(map);
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Integer call() throws Exception {
            HttpClientUtil httpClientUtil = new HttpClientUtil();
            String url = UrlEnum.STATISTICS_MODELLOAD_SERVER.getUrl();
            String entity = getEntity();
            UploadStatisticsHandler uploadStatisticsHandler = new UploadStatisticsHandler();
            httpClientUtil.post(url, entity, uploadStatisticsHandler);
            final int result = uploadStatisticsHandler.getResult();
            UploadStatistics.this.executorService.submit(new Runnable() { // from class: com.baidu.tts.statistics.UploadStatistics.UploadWork.1
                @Override // java.lang.Runnable
                public void run() {
                    if (result == 0) {
                        LoggerProxy.d(UploadStatistics.TAG, "delete database code==" + UploadStatistics.this.mModelMediator.deleteStatisticsData(UploadStatistics.this.startId, UploadStatistics.this.endId));
                    }
                }
            });
            return Integer.valueOf(result);
        }
    }

    public UploadStatistics(Context context) {
        this.context = context;
        this.mModelMediator = new ModelMediator(context);
    }

    public void stop() {
        this.futureTask.cancel(true);
    }

    public FutureTask<Integer> uplaoadStatisticsInfo() {
        this.futureTask = new FutureTask<>(new UploadWork());
        this.executorService.submit(this.futureTask);
        return this.futureTask;
    }
}
