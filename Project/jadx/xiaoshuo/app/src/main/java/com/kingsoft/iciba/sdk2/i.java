package com.kingsoft.iciba.sdk2;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
final class i implements Runnable {
    private File J;
    private Context K;
    private long L;

    public i(File file, Context context, long j) {
        this.J = file;
        this.K = context;
        this.L = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.J.exists() || this.J.length() <= 0) {
                return;
            }
            HashMap map = (HashMap) new ObjectInputStream(new FileInputStream(this.J)).readObject();
            if (map.size() > 0) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", 2);
                if (map.containsKey("click_event")) {
                    JSONObject jSONObject2 = new JSONObject();
                    HashMap map2 = (HashMap) map.get("click_event");
                    for (String str : map2.keySet()) {
                        jSONObject2.put(str, new JSONObject((String) map2.get(str)).getInt("click_number"));
                    }
                    jSONObject.put("click_event", jSONObject2);
                }
                if (map.containsKey("search_history")) {
                    JSONArray jSONArray = new JSONArray();
                    HashMap map3 = (HashMap) map.get("search_history");
                    for (String str2 : map3.keySet()) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONArray.put(jSONObject3);
                        jSONObject3.put("word", str2);
                        jSONObject3.put("word_history", new JSONObject((String) map3.get(str2)));
                    }
                    jSONObject.put("search_history", jSONArray);
                }
                String strB = d.b(this.K, jSONObject, this.L);
                HttpPost httpPost = new HttpPost("https://counter.kingsoft.com/index2.php");
                if (strB.getBytes().length >= 2048) {
                    httpPost.setHeader("Content-Encoding", "gzip");
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new BasicNameValuePair("q", strB));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
                if (200 == d.e().execute(httpPost).getStatusLine().getStatusCode()) {
                    this.J.delete();
                }
            }
        } catch (Exception e) {
            Log.e("KStatistics", "Upload data failed", e);
        }
    }
}
