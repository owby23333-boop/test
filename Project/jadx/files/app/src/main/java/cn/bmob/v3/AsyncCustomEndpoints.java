package cn.bmob.v3;

import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.listener.CloudCodeListener;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AsyncCustomEndpoints {
    private RxBmob createCloudRequest(String str, JSONObject jSONObject, CloudCodeListener cloudCodeListener) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("_e", str);
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String string = itKeys.next().toString();
                    jSONObject3.put(string, jSONObject.get(string));
                }
            }
            jSONObject2.put("data", jSONObject3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByContext("no check", "no check")).nextTest(BmobURL.getDefault().getUrl("functions"), jSONObject2).map(new Function<JsonElement, Object>() { // from class: cn.bmob.v3.AsyncCustomEndpoints.1
            @Override // io.reactivex.functions.Function
            public Object apply(JsonElement jsonElement) {
                try {
                    JsonElement jsonElement2 = jsonElement.getAsJsonObject().get("results");
                    jsonElement = jsonElement2.isJsonObject() ? jsonElement2.getAsJsonObject().toString() : jsonElement2.isJsonArray() ? jsonElement2.getAsJsonArray().toString() : jsonElement2.getAsString().toString();
                    return jsonElement;
                } catch (Exception unused) {
                    String string2 = jsonElement.toString();
                    return string2.startsWith("\"") ? string2.substring(0, string2.length() - 1).substring(1) : string2;
                }
            }
        }).subscribe(cloudCodeListener).build();
    }

    public Disposable callEndpoint(String str, CloudCodeListener cloudCodeListener) {
        return callEndpoint(str, null, cloudCodeListener);
    }

    public Observable<Object> callEndpointObservable(String str) {
        return callEndpointObservable(str, null);
    }

    public Disposable callEndpoint(String str, JSONObject jSONObject, CloudCodeListener cloudCodeListener) {
        return createCloudRequest(str, jSONObject, cloudCodeListener).getDisposable();
    }

    public Observable<Object> callEndpointObservable(String str, JSONObject jSONObject) {
        return createCloudRequest(str, jSONObject, null).getObservable();
    }
}
