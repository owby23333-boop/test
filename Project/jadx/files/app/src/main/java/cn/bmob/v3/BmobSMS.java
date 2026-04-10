package cn.bmob.v3;

import cn.bmob.v3.datatype.BmobSmsState;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.http.bean.R1;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.UpdateListener;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobSMS {
    private static RxBmob createRequest(List<R1> list, String str, JSONObject jSONObject, QueryListener<Integer> queryListener) {
        return new RxBmob.Builder().check(list).nextTest(str, jSONObject).map(new Function<JsonElement, Integer>() { // from class: cn.bmob.v3.BmobSMS.1
            @Override // io.reactivex.functions.Function
            public Integer apply(JsonElement jsonElement) {
                return Integer.valueOf(jsonElement.getAsJsonObject().get("smsId").getAsInt());
            }
        }).subscribe(queryListener).build();
    }

    private static RxBmob createSMSCodeRequest(String str, String str2, QueryListener<Integer> queryListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mobilePhoneNumber", str);
            jSONObject2.put("template", str2);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException unused) {
        }
        return createRequest(BmobFactory.rByNull(str, "phoneNumber can't be empty", str2, "template can't be empty"), BmobURL.getDefault().getUrl("request_sms_code"), jSONObject, queryListener);
    }

    private static RxBmob createSMSRequest(String str, String str2, String str3, QueryListener<Integer> queryListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mobilePhoneNumber", str);
            jSONObject2.put("content", str2);
            jSONObject2.put("sendTime", str3);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return createRequest(BmobFactory.rByNull(str, "phoneNumber can't be empty", str2, "smsContent can't be empty", str3, "sendTime can't be empty"), BmobURL.getDefault().getUrl("request_sms"), jSONObject, queryListener);
    }

    private static RxBmob createSmsStateRequest(Integer num, QueryListener<BmobSmsState> queryListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("smsId", num);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByNull(num, "smsId is null!")).nextTest(BmobURL.getDefault().getUrl("query_sms"), jSONObject).map(new Function<JsonElement, BmobSmsState>() { // from class: cn.bmob.v3.BmobSMS.2
            @Override // io.reactivex.functions.Function
            public BmobSmsState apply(JsonElement jsonElement) {
                return new BmobSmsState(jsonElement.getAsJsonObject().get("sms_state").getAsString(), jsonElement.getAsJsonObject().get("verify_state").getAsString());
            }
        }).subscribe(queryListener).build();
    }

    private static RxBmob createVerifyRequest(String str, String str2, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mobilePhoneNumber", str);
            jSONObject2.put("smsCode", str2);
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByNull(str, "phoneNumber can't be empty", str2, "smsCode can't be empty")).nextTest(BmobURL.getDefault().getUrl("verify_sms_code"), jSONObject).mapVoid().subscribe(updateListener).build();
    }

    public static Disposable querySmsState(Integer num, QueryListener<BmobSmsState> queryListener) {
        return createSmsStateRequest(num, queryListener).getDisposable();
    }

    public static Observable<BmobSmsState> querySmsStateObservable(Integer num) {
        return createSmsStateRequest(num, null).getObservable();
    }

    private static Disposable requestSMS(String str, String str2, String str3, QueryListener<Integer> queryListener) {
        return createSMSRequest(str, str2, str3, queryListener).getDisposable();
    }

    public static Disposable requestSMSCode(String str, String str2, QueryListener<Integer> queryListener) {
        return createSMSCodeRequest(str, str2, queryListener).getDisposable();
    }

    public static Observable<Integer> requestSMSCodeObservable(String str, String str2) {
        return createSMSCodeRequest(str, str2, null).getObservable();
    }

    private static Observable<Integer> requestSMSObservable(String str, String str2, String str3) {
        return createSMSRequest(str, str2, str3, null).getObservable();
    }

    public static Disposable verifySmsCode(String str, String str2, UpdateListener updateListener) {
        return createVerifyRequest(str, str2, updateListener).getDisposable();
    }

    public static Observable<Void> verifySmsCodeObservable(String str, String str2) {
        return createVerifyRequest(str, str2, null).getObservable();
    }
}
