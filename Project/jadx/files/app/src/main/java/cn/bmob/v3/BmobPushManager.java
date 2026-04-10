package cn.bmob.v3;

import android.text.TextUtils;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.listener.PushListener;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobPushManager<T> {
    private BmobQuery<T> query;

    private RxBmob createJSONRequest(JSONObject jSONObject, JSONObject jSONObject2, PushListener pushListener) {
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("data", jSONObject);
            if (jSONObject2 != null) {
                jSONObject4.put("where", jSONObject2);
            }
            jSONObject3.put("data", jSONObject4);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(Collections.emptyList()).nextTest(BmobURL.getDefault().getUrl("push"), jSONObject3).mapVoid().subscribe(pushListener).build();
    }

    private RxBmob createStringRequest(String str, String str2, JSONObject jSONObject, PushListener pushListener) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("alert", str);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("data", jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("where", jSONObject);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject2.put("push_time", str2);
                jSONObject2.put("expiration_interval", 518400);
            }
            jSONObject2.put("data", jSONObject4);
            System.out.println("params:" + jSONObject2.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(Collections.emptyList()).nextTest(BmobURL.getDefault().getUrl("push"), jSONObject2).mapVoid().subscribe(pushListener).build();
    }

    public BmobQuery<T> getQuery() {
        return this.query;
    }

    public Disposable pushMessage(String str) {
        return pushMessageTime(str, null, new PushListener() { // from class: cn.bmob.v3.BmobPushManager.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // cn.bmob.v3.listener.PushListener, cn.bmob.v3.listener.BmobCallback1
            public void done(BmobException bmobException) {
            }
        });
    }

    public Disposable pushMessageAll(JSONObject jSONObject) {
        return pushMessageAll(jSONObject, null);
    }

    public Observable<Void> pushMessageAllObservable(String str) {
        return createStringRequest(str, null, null, null).getObservable();
    }

    public Disposable pushMessageTime(String str, String str2) {
        return pushMessageTime(str, str2, new PushListener() { // from class: cn.bmob.v3.BmobPushManager.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // cn.bmob.v3.listener.PushListener, cn.bmob.v3.listener.BmobCallback1
            public void done(BmobException bmobException) {
            }
        });
    }

    public void setQuery(BmobQuery<T> bmobQuery) {
        this.query = bmobQuery;
    }

    public Disposable pushMessage(String str, PushListener pushListener) {
        return pushMessageTime(str, null, pushListener);
    }

    public Disposable pushMessageAll(String str, String str2, PushListener pushListener) {
        return createStringRequest(str, str2, null, pushListener).getDisposable();
    }

    public Observable<Void> pushMessageAllObservable(JSONObject jSONObject) {
        return createJSONRequest(jSONObject, null, null).getObservable();
    }

    public Disposable pushMessageTime(String str, String str2, PushListener pushListener) {
        BmobQuery<T> bmobQuery = this.query;
        return bmobQuery != null ? createStringRequest(str, str2, bmobQuery.getWhere(), pushListener).getDisposable() : pushMessageAll(str, str2, pushListener);
    }

    public Disposable pushMessage(JSONObject jSONObject) {
        return pushMessage(jSONObject, new PushListener() { // from class: cn.bmob.v3.BmobPushManager.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // cn.bmob.v3.listener.PushListener, cn.bmob.v3.listener.BmobCallback1
            public void done(BmobException bmobException) {
            }
        });
    }

    public Disposable pushMessageAll(JSONObject jSONObject, PushListener pushListener) {
        return createJSONRequest(jSONObject, null, pushListener).getDisposable();
    }

    public Disposable pushMessage(JSONObject jSONObject, PushListener pushListener) {
        BmobQuery<T> bmobQuery = this.query;
        if (bmobQuery != null) {
            return createJSONRequest(jSONObject, bmobQuery.getWhere(), pushListener).getDisposable();
        }
        return pushMessageAll(jSONObject, pushListener);
    }
}
