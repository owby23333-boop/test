package cn.bmob.v3;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.ErrorCode;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.http.bean.R1;
import cn.bmob.v3.listener.FetchUserInfoListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.util.BmobContentProvider;
import cn.bmob.v3.util.BmobDbOpenHelper;
import cn.bmob.v3.util.CacheManager;
import cn.bmob.v3.util.JsonUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobUser extends BmobObject {
    static JSONObject current = null;
    private static final long serialVersionUID = -1589804003600796026L;
    private String email;
    private Boolean emailVerified;
    private String mobilePhoneNumber;
    private Boolean mobilePhoneNumberVerified;
    private String password;
    private String sessionToken;
    private String username;

    public static class BmobThirdUserAuth {
        public static final String SNS_TYPE_QQ = "qq";
        public static final String SNS_TYPE_WEIBO = "weibo";
        public static final String SNS_TYPE_WEIXIN = "weixin";
        String accessToken;
        String expiresIn;
        String snsType;
        String userId;

        public BmobThirdUserAuth(String str, String str2, String str3, String str4) {
            this.accessToken = str2;
            this.snsType = str;
            this.expiresIn = str3;
            this.userId = str4;
        }

        protected static String getPlatformIdByType(String str) {
            return (SNS_TYPE_QQ.equalsIgnoreCase(str) || SNS_TYPE_WEIXIN.equalsIgnoreCase(str)) ? "openid" : "uid";
        }

        public String getAccessToken() {
            return this.accessToken;
        }

        public String getExpiresIn() {
            return this.expiresIn;
        }

        public String getSnsType() {
            return this.snsType;
        }

        public String getUserId() {
            return this.userId;
        }

        public void setAccessToken(String str) {
            this.accessToken = str;
        }

        public void setExpiresIn(String str) {
            this.expiresIn = str;
        }

        public void setSnsType(String str) {
            this.snsType = str;
        }

        public void setUserId(String str) {
            this.userId = str;
        }

        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(this.snsType)) {
                    jSONObject2.put(getPlatformIdByType(this.snsType), this.userId);
                }
                jSONObject2.put("access_token", this.accessToken);
                if (SNS_TYPE_QQ.equalsIgnoreCase(this.snsType)) {
                    jSONObject2.put("expires_in", Double.parseDouble(this.expiresIn));
                } else if (SNS_TYPE_WEIBO.equalsIgnoreCase(this.snsType)) {
                    jSONObject2.put("expires_in", Long.parseLong(this.expiresIn));
                } else {
                    jSONObject2.put("expires_in", Long.parseLong(this.expiresIn));
                }
                jSONObject.put(this.snsType, jSONObject2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static Disposable associateWithAuthData(BmobThirdUserAuth bmobThirdUserAuth, UpdateListener updateListener) {
        return associateWithAuthDataRequest(bmobThirdUserAuth, updateListener).getDisposable();
    }

    public static Observable<Void> associateWithAuthDataObservable(BmobThirdUserAuth bmobThirdUserAuth, UpdateListener updateListener) {
        return associateWithAuthDataRequest(bmobThirdUserAuth, updateListener).getObservable();
    }

    private static RxBmob associateWithAuthDataRequest(BmobThirdUserAuth bmobThirdUserAuth, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", new JSONObject().put("authData", bmobThirdUserAuth.toJSONObject()));
            jSONObject.put("c", "_User");
            jSONObject.put("objectId", getCurrentUser().getObjectId());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createCheckRequest(BmobFactory.rByNull(getCurrentUser(), " user must be login before associate ", bmobThirdUserAuth, " authInfo is null"), BmobURL.getDefault().getUrl("update"), jSONObject, updateListener);
    }

    public static Disposable dissociateAuthData(String str, UpdateListener updateListener) {
        return dissociateAuthDataRequest(str, updateListener).getDisposable();
    }

    private static RxBmob dissociateAuthDataRequest(String str, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("authData", new JSONObject().put(str, JSONObject.NULL));
            jSONObject.put("data", jSONObject2);
            jSONObject.put("c", "_User");
            jSONObject.put("objectId", getCurrentUser().getObjectId());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createCheckRequest(BmobFactory.rByNull(getCurrentUser(), " user must be login before disassociate ", str, " type  is null"), BmobURL.getDefault().getUrl("update"), jSONObject, updateListener);
    }

    public static <T> void fetchUserInfo(final FetchUserInfoListener<T> fetchUserInfoListener) {
        fetchUserJsonInfo(new FetchUserInfoListener<String>() { // from class: cn.bmob.v3.BmobUser.8
            @Override // cn.bmob.v3.listener.FetchUserInfoListener, cn.bmob.v3.listener.BmobCallback2
            public void done(String str, BmobException bmobException) {
                if (bmobException == null) {
                    Class cls = (Class) ((ParameterizedType) fetchUserInfoListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
                    Object object = GsonUtil.toObject(str, cls);
                    BmobContentProvider.updateUser(str, cls);
                    fetchUserInfoListener.done(object, (BmobException) null);
                    return;
                }
                fetchUserInfoListener.done((Object) null, bmobException);
            }
        });
    }

    public static void fetchUserJsonInfo(final FetchUserInfoListener<String> fetchUserInfoListener) {
        if (getCurrentUser() == null) {
            fetchUserInfoListener.done((String) null, new BmobException(ErrorCode.E9024, ErrorCode.E9024S));
        } else {
            new BmobQuery("_User").getObjectByTable(getCurrentUser().getObjectId(), new QueryListener<JSONObject>() { // from class: cn.bmob.v3.BmobUser.9
                @Override // cn.bmob.v3.listener.QueryListener, cn.bmob.v3.listener.BmobCallback2
                public void done(JSONObject jSONObject, BmobException bmobException) {
                    if (bmobException == null) {
                        fetchUserInfoListener.done(jSONObject.toString(), (BmobException) null);
                    } else {
                        fetchUserInfoListener.done((Object) null, bmobException);
                    }
                }
            });
        }
    }

    public static <T> T getCurrentUser(Class<T> cls) {
        String user = BmobContentProvider.getUser();
        if (TextUtils.isEmpty(user)) {
            return null;
        }
        return (T) GsonUtil.toObject(user, cls);
    }

    public static Object getObjectByKey(String str) {
        String user = BmobContentProvider.getUser();
        if (TextUtils.isEmpty(user)) {
            return null;
        }
        try {
            return new JSONObject(user).opt(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private String getPassword() {
        return this.password;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> String getUserJson(JsonElement jsonElement, Class<T> cls) {
        if (!jsonElement.isJsonObject()) {
            return "";
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject.has("objectId")) {
            setObjectId(asJsonObject.get("objectId").getAsString());
        }
        if (asJsonObject.has("createdAt")) {
            setCreatedAt(asJsonObject.get("createdAt").getAsString());
        }
        if (asJsonObject.has(BmobDbOpenHelper.SESSION_TOKEN)) {
            setSessionToken(jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN).getAsString());
        }
        if (asJsonObject.has("mobilePhoneNumber")) {
            setMobilePhoneNumber(asJsonObject.get("mobilePhoneNumber").getAsString());
        }
        if (asJsonObject.has("mobilePhoneNumberVerified")) {
            setMobilePhoneNumberVerified(Boolean.valueOf(asJsonObject.get("mobilePhoneNumberVerified").getAsBoolean()));
        }
        JSONObject currentData = getCurrentData();
        if (currentData.has("password")) {
            currentData.remove("password");
        }
        String string = currentData.toString();
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN);
        if (jsonElement2 != null) {
            BmobContentProvider.updateSessionToken(jsonElement2.getAsString());
        }
        BmobContentProvider.updateUser(string, cls);
        return string;
    }

    public static boolean isLogin() {
        return getCurrentUser() != null;
    }

    public static void logOut() {
        BmobContentProvider.removeLocalUser();
        BmobContentProvider.updateSessionToken("");
    }

    public static <T> Disposable loginByAccount(String str, String str2, LogInListener<T> logInListener) {
        if (logInListener != null) {
            return loginByAccountRequest((Class) ((ParameterizedType) logInListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], str, str2, logInListener).getDisposable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    public static <T> Observable<T> loginByAccountObservable(Class<T> cls, String str, String str2) {
        if (cls != null) {
            return loginByAccountRequest(cls, str, str2, null).getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    private static <T> RxBmob loginByAccountRequest(Class<T> cls, String str, String str2, LogInListener<T> logInListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("username", str);
            jSONObject2.put("password", str2);
            jSONObject.put("data", jSONObject2);
            jSONObject.put("c", "_User");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createLoginRequest(cls, BmobFactory.rByEmpty(str, " account can't be empty ", str2, " password can't be empty "), BmobURL.getDefault().getUrl("login"), jSONObject, logInListener);
    }

    public static <T> Disposable loginBySMSCode(String str, String str2, LogInListener<T> logInListener) {
        if (logInListener != null) {
            return requestLogin((Class) ((ParameterizedType) logInListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], BmobURL.getDefault().getUrl("login"), str, str2, logInListener).getDisposable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    private <T> RxBmob loginRequest(final Class<T> cls, SaveListener<T> saveListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("username", getUsername());
            jSONObject2.put("password", getPassword());
            jSONObject.put("data", jSONObject2);
            jSONObject.put("c", getTableName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByEmpty(getUsername(), " username can't be empty ", getPassword(), " password can't be empty ")).nextTest(BmobURL.getDefault().getUrl("login"), jSONObject).doOnNext(new Consumer<JsonElement>() { // from class: cn.bmob.v3.BmobUser.3
            @Override // io.reactivex.functions.Consumer
            public void accept(JsonElement jsonElement) {
                String string = jsonElement.getAsJsonObject().toString();
                JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN);
                if (jsonElement2 != null) {
                    BmobContentProvider.updateSessionToken(jsonElement2.getAsString());
                }
                BmobContentProvider.updateUser(string, cls);
            }
        }).map(new Function<JsonElement, Object>() { // from class: cn.bmob.v3.BmobUser.2
            /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public T apply(JsonElement jsonElement) {
                BmobUser.this.setObjectId(JsonUtil.getString(jsonElement, "objectId"));
                BmobUser.this.setCreatedAt(JsonUtil.getString(jsonElement, "createdAt"));
                BmobUser.this.setUpdatedAt(JsonUtil.getString(jsonElement, "updatedAt"));
                BmobUser.this.setSessionToken(JsonUtil.getString(jsonElement, BmobDbOpenHelper.SESSION_TOKEN));
                if (jsonElement.getAsJsonObject().has("emailVerified")) {
                    BmobUser.this.setEmailVerified(Boolean.valueOf(JsonUtil.getBoolean(jsonElement, "emailVerified")));
                }
                return GsonUtil.toObject(jsonElement, cls);
            }
        }).subscribe(saveListener).build();
    }

    public static Disposable loginWithAuthData(BmobThirdUserAuth bmobThirdUserAuth, LogInListener<JSONObject> logInListener) {
        return loginWithAuthDataRequest(bmobThirdUserAuth, logInListener).getDisposable();
    }

    public static Observable<JSONObject> loginWithAuthDataObservable(BmobThirdUserAuth bmobThirdUserAuth) {
        return loginWithAuthDataRequest(bmobThirdUserAuth, null).getObservable();
    }

    private static RxBmob loginWithAuthDataRequest(BmobThirdUserAuth bmobThirdUserAuth, LogInListener<JSONObject> logInListener) {
        final JSONObject jSONObject = bmobThirdUserAuth == null ? new JSONObject() : bmobThirdUserAuth.toJSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", new JSONObject().put("authData", jSONObject));
            jSONObject2.put("c", "_User");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByNull(bmobThirdUserAuth, "authInfo is null")).nextTest(BmobURL.getDefault().getUrl("login_or_signup"), jSONObject2).doOnNext(new Consumer<JsonElement>() { // from class: cn.bmob.v3.BmobUser.7
            @Override // io.reactivex.functions.Consumer
            public void accept(JsonElement jsonElement) {
                try {
                    BmobContentProvider.updateUser(jsonElement.toString(), BmobUser.class);
                    JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN);
                    if (jsonElement2 != null) {
                        BmobContentProvider.updateSessionToken(jsonElement2.getAsString());
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }).map(new Function<JsonElement, Object>() { // from class: cn.bmob.v3.BmobUser.6
            @Override // io.reactivex.functions.Function
            public JSONObject apply(JsonElement jsonElement) {
                return jSONObject;
            }
        }).subscribe(logInListener).build();
    }

    public static Disposable requestEmailVerify(String str, UpdateListener updateListener) {
        return requestEmailVerifyRequest(str, updateListener).getDisposable();
    }

    public static Observable<BmobException> requestEmailVerifyObservable(String str) {
        return requestEmailVerifyRequest(str, null).getObservable();
    }

    private static RxBmob requestEmailVerifyRequest(String str, UpdateListener updateListener) {
        JSONObject jSONObject;
        JSONException e2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e2 = e3;
        }
        try {
            jSONObject.put("data", new JSONObject().put(NotificationCompat.CATEGORY_EMAIL, str));
            jSONObject.put("c", "_User");
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createCheckRequest(BmobFactory.rByContext(str, " email  can't be empty"), BmobURL.getDefault().getUrl("email_verify"), jSONObject, updateListener);
    }

    private static <T> RxBmob requestLogin(Class<T> cls, String str, String str2, String str3, LogInListener<T> logInListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("mobilePhoneNumber", str2);
            jSONObject2.put("smsCode", str3);
            jSONObject.put("data", jSONObject2);
            jSONObject.put("c", "_User");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createLoginRequest(cls, BmobFactory.rByEmpty(str2, " phoneNumber can't be empty ", str3, " smsCode can't be empty "), str, jSONObject, logInListener);
    }

    private <T> Disposable requestSignSubscription(List<R1> list, String str, String str2, SaveListener<T> saveListener) {
        if (saveListener != null) {
            return signRequest((Class) ((ParameterizedType) saveListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], list, str, str2, saveListener).getDisposable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    public static Disposable resetPasswordByEmail(String str, UpdateListener updateListener) {
        return resetPasswordByEmailRequest(str, updateListener).getDisposable();
    }

    public static Observable<BmobException> resetPasswordByEmailObservable(String str) {
        return resetPasswordByEmailRequest(str, null).getObservable();
    }

    private static RxBmob resetPasswordByEmailRequest(String str, UpdateListener updateListener) {
        JSONObject jSONObject;
        JSONException e2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e2 = e3;
        }
        try {
            jSONObject.put("data", new JSONObject().put(NotificationCompat.CATEGORY_EMAIL, str));
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createCheckRequest(BmobFactory.rByContext(str, " email  can't be empty"), BmobURL.getDefault().getUrl("reset"), jSONObject, updateListener);
    }

    public static Disposable resetPasswordBySMSCode(String str, String str2, UpdateListener updateListener) {
        return resetPasswordBySMSCodeRequest(str, str2, updateListener).getDisposable();
    }

    public static Observable<BmobException> resetPasswordBySMSCodeObservable(String str, String str2) {
        return resetPasswordBySMSCodeRequest(str, str2, null).getObservable();
    }

    private static RxBmob resetPasswordBySMSCodeRequest(String str, String str2, UpdateListener updateListener) {
        JSONObject jSONObject;
        JSONException e2;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e3) {
            jSONObject = jSONObject2;
            e2 = e3;
        }
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("smsCode", str);
            jSONObject3.put("password", str2);
            jSONObject.put("data", jSONObject3);
            jSONObject.put("c", "_User");
        } catch (JSONException e4) {
            e2 = e4;
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createCheckRequest(BmobFactory.rByEmpty(str, " Verify code can't be empty", str2, " newPassword can't be empty"), BmobURL.getDefault().getUrl("phone_reset"), jSONObject, updateListener);
    }

    public static <T> Disposable signOrLoginByMobilePhone(String str, String str2, LogInListener<T> logInListener) {
        if (logInListener != null) {
            return requestLogin((Class) ((ParameterizedType) logInListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], BmobURL.getDefault().getUrl("login_or_signup"), str, str2, logInListener).getDisposable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    private <T> RxBmob signRequest(final Class<T> cls, List<R1> list, String str, String str2, SaveListener<T> saveListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject currentData = getCurrentData();
            if (!TextUtils.isEmpty(str2)) {
                currentData.put("smsCode", str2);
            }
            jSONObject.put("data", currentData);
            jSONObject.put("c", getTableName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(list).nextTest(str, jSONObject).map(new Function<JsonElement, Object>() { // from class: cn.bmob.v3.BmobUser.1
            /* JADX WARN: Type inference failed for: r3v4, types: [T, java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public T apply(JsonElement jsonElement) {
                String userJson = BmobUser.this.getUserJson(jsonElement, cls);
                BmobContentProvider.updateUser(userJson, cls);
                JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(BmobDbOpenHelper.SESSION_TOKEN);
                if (jsonElement2 != null) {
                    BmobContentProvider.updateSessionToken(jsonElement2.getAsString());
                }
                return GsonUtil.toObject(userJson, cls);
            }
        }).subscribe(saveListener).build();
    }

    public static Disposable updateCurrentUserPassword(String str, String str2, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            String objectId = getCurrentUser().getObjectId();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("oldPassword", str);
            jSONObject2.put("newPassword", str2);
            jSONObject.put("data", jSONObject2);
            jSONObject.put("objectId", objectId);
            jSONObject.put("c", "_User");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return BmobFactory.getInstance().createCheckRequest(BmobFactory.rByNull(str, " oldPassword can't be empty", str2, " newPassword can't be empty", getCurrentUser(), "Cannot update user password until it has been logined. Please call login first."), BmobURL.getDefault().getUrl("update_user_password"), jSONObject, updateListener).getDisposable();
    }

    private RxBmob updateRequest(final String str, UpdateListener updateListener) {
        final Class<BmobUser> cls = BmobUser.class;
        final JSONObject jSONObject = new JSONObject();
        try {
            current = new JSONObject(GsonUtil.toJson(this));
            JSONObject currentData = getCurrentData();
            currentData.remove("objectId");
            currentData.remove(BmobDbOpenHelper.SESSION_TOKEN);
            currentData.remove("createdAt");
            currentData.remove("updatedAt");
            if (BmobObject.increments.size() > 0) {
                for (JSONObject jSONObject2 : BmobObject.increments) {
                    String strOptString = jSONObject2.optString("key");
                    jSONObject2.remove("key");
                    currentData.put(strOptString, jSONObject2);
                }
                BmobObject.increments.clear();
            }
            jSONObject.put("data", currentData);
            jSONObject.put("c", getTableName());
            jSONObject.put("objectId", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByContext(str, " objectId can't be empty ")).nextTest(BmobURL.getDefault().getUrl("update"), jSONObject).doOnNext(new Consumer<JsonElement>() { // from class: cn.bmob.v3.BmobUser.5
            @Override // io.reactivex.functions.Consumer
            public void accept(JsonElement jsonElement) {
                try {
                    BmobUser.current.put("updatedAt", jsonElement.getAsJsonObject().get("updatedAt").getAsString());
                    if (str.equals(BmobUser.getCurrentUser().getObjectId())) {
                        CacheManager.getInstance(Bmob.getApplicationContext()).changeCurrentUser(BmobUser.current.toString(), jSONObject.getJSONObject("data").toString(), cls);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }).map(new Function<JsonElement, BmobException>() { // from class: cn.bmob.v3.BmobUser.4
            @Override // io.reactivex.functions.Function
            public BmobException apply(JsonElement jsonElement) {
                BmobUser.this.setUpdatedAt(jsonElement.getAsJsonObject().get("updatedAt").getAsString());
                BmobUser.this.setObjectId(str);
                return new BmobException();
            }
        }).subscribe(updateListener).build();
    }

    public Observable<Void> dissociateAuthDataObservable(String str) {
        return dissociateAuthDataRequest(str, null).getObservable();
    }

    public String getEmail() {
        return this.email;
    }

    public Boolean getEmailVerified() {
        return this.emailVerified;
    }

    public String getMobilePhoneNumber() {
        return this.mobilePhoneNumber;
    }

    public Boolean getMobilePhoneNumberVerified() {
        return this.mobilePhoneNumberVerified;
    }

    public String getSessionToken() {
        return BmobContentProvider.getSessionToken();
    }

    @Override // cn.bmob.v3.BmobObject
    public String getTableName() {
        return "_User";
    }

    public String getUsername() {
        return this.username;
    }

    public <T> Disposable login(SaveListener<T> saveListener) {
        if (saveListener != null) {
            return loginRequest((Class) ((ParameterizedType) saveListener.getClass().getGenericSuperclass()).getActualTypeArguments()[0], saveListener).getDisposable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_LISTENER);
    }

    public <T> Observable<T> loginObservable(Class<T> cls) {
        if (cls != null) {
            return loginRequest(cls, null).getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    @Override // cn.bmob.v3.BmobObject
    @Deprecated
    public Disposable save(SaveListener saveListener) {
        throw new IllegalArgumentException(" _User does not support save operation,please use login / signUp method.");
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmailVerified(Boolean bool) {
        this.emailVerified = bool;
    }

    public void setMobilePhoneNumber(String str) {
        this.mobilePhoneNumber = str;
    }

    public void setMobilePhoneNumberVerified(Boolean bool) {
        this.mobilePhoneNumberVerified = bool;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public <T> Disposable signOrLogin(String str, SaveListener<T> saveListener) {
        return requestSignSubscription(BmobFactory.rByContext(str, " Verify code can't be empty "), BmobURL.getDefault().getUrl("login_or_signup"), str, saveListener);
    }

    public <T> Observable<T> signOrLoginObservable(Class<T> cls, String str) {
        if (cls != null) {
            return signRequest(cls, BmobFactory.rByContext(str, " Verify code can't be empty "), BmobURL.getDefault().getUrl("login_or_signup"), str, null).getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    public <T> Disposable signUp(SaveListener<T> saveListener) {
        return requestSignSubscription(BmobFactory.rByContext("no check", " no check "), BmobURL.getDefault().getUrl("signup"), null, saveListener);
    }

    public <T> Observable<T> signUpObservable(Class<T> cls) {
        if (cls != null) {
            return signRequest(cls, BmobFactory.rByContext("no check", " no check "), BmobURL.getDefault().getUrl("signup"), null, null).getObservable();
        }
        throw new IllegalArgumentException(BmobConstants.ERROR_CLASS);
    }

    @Override // cn.bmob.v3.BmobObject
    public Disposable update(UpdateListener updateListener) {
        return update(getObjectId(), updateListener);
    }

    @Override // cn.bmob.v3.BmobObject
    public Observable<BmobException> updateObservable(String str) {
        return updateRequest(str, null).getObservable();
    }

    @Override // cn.bmob.v3.BmobObject
    public Disposable update(String str, UpdateListener updateListener) {
        return updateRequest(str, updateListener).getDisposable();
    }

    public static BmobUser getCurrentUser() {
        return (BmobUser) getCurrentUser(BmobUser.class);
    }
}
