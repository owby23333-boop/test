package cn.bmob.v3;

import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobRelation;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.BmobClient;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.util.BLog;
import cn.bmob.v3.util.JsonUtil;
import com.anythink.expressad.d.a.b;
import com.google.gson.JsonElement;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobObject implements Serializable {
    protected static JSONObject data;
    protected static List<JSONObject> increments = new ArrayList();
    private BmobACL ACL;
    private String _c_;
    private String createdAt;
    private String objectId;
    private String updatedAt;

    public BmobObject() {
        this._c_ = getClass().getSimpleName();
        BLog.e(this._c_);
        data = new JSONObject();
    }

    private JSONObject addFieldOperation(String str, Collection<?> collection) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("__op", str);
        JSONArray jSONArray = new JSONArray();
        for (Object obj : collection) {
            if (obj instanceof String) {
                jSONArray.put(obj);
            } else {
                jSONArray.put(new JSONObject(GsonUtil.toJson(obj)));
            }
        }
        jSONObject.put("objects", jSONArray);
        return jSONObject;
    }

    private JSONObject buildParams() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject currentData = getCurrentData();
            currentData.remove("createdAt");
            currentData.remove("updatedAt");
            currentData.remove("objectId");
            jSONObject.put("data", currentData);
            jSONObject.put("c", getTableName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private RxBmob deleteRequest(String str, UpdateListener updateListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("objectId", str);
            jSONObject.put("c", getTableName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByContext(str, " objectId can't be empty ")).nextTest(BmobURL.getDefault().getUrl(b.az), jSONObject).mapVoid().subscribe(updateListener).build();
    }

    public static JSONObject disposePointerType(BmobObject bmobObject, JSONObject jSONObject) throws JSONException {
        for (Field field : bmobObject.getClass().getDeclaredFields()) {
            if (BmobUser.class.isAssignableFrom(field.getType())) {
                if (!jSONObject.isNull(field.getName())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("__type", "Pointer");
                    jSONObject2.put("objectId", jSONObject.optJSONObject(field.getName()).optString("objectId", "null"));
                    jSONObject2.put("className", "_User");
                    jSONObject.put(field.getName(), jSONObject2);
                }
            } else if (BmobInstallation.class.isAssignableFrom(field.getType())) {
                if (!jSONObject.isNull(field.getName())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("__type", "Pointer");
                    jSONObject3.put("objectId", jSONObject.optJSONObject(field.getName()).optString("objectId", "null"));
                    jSONObject3.put("className", "_Installation");
                    jSONObject.put(field.getName(), jSONObject3);
                }
            } else if (BmobRole.class.isAssignableFrom(field.getType())) {
                if (!jSONObject.isNull(field.getName())) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("__type", "Pointer");
                    jSONObject4.put("objectId", jSONObject.optJSONObject(field.getName()).optString("objectId", "null"));
                    jSONObject4.put("className", "_Role");
                    jSONObject.put(field.getName(), jSONObject4);
                }
            } else if (BmobObject.class.isAssignableFrom(field.getType()) && !jSONObject.isNull(field.getName())) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("__type", "Pointer");
                jSONObject5.put("objectId", jSONObject.optJSONObject(field.getName()).optString("objectId", "null"));
                jSONObject5.put("className", field.getType().getSimpleName());
                jSONObject.put(field.getName(), jSONObject5);
            }
        }
        return jSONObject;
    }

    private Object parseValue(Object obj) throws JSONException {
        if ((obj instanceof BmobDate) || (obj instanceof BmobFile) || (obj instanceof BmobGeoPoint) || (obj instanceof BmobRelation)) {
            return new JSONObject(GsonUtil.toJson(obj));
        }
        if (obj instanceof BmobObject) {
            BmobObject bmobObject = (BmobObject) obj;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__type", "Pointer");
            jSONObject.put("objectId", bmobObject.getObjectId() == null ? "" : bmobObject.getObjectId());
            jSONObject.put("className", bmobObject.getTableName());
            return jSONObject;
        }
        if ((obj instanceof String) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Character) || (obj instanceof Boolean)) {
            return obj;
        }
        if (!(obj instanceof Collection)) {
            return new JSONObject(GsonUtil.toJson(obj));
        }
        JSONArray jSONArray = new JSONArray();
        for (Object obj2 : (Collection) obj) {
            if (obj2 instanceof String) {
                jSONArray.put(obj2);
            } else {
                jSONArray.put(new JSONObject(GsonUtil.toJson(obj2)));
            }
        }
        return jSONArray;
    }

    private RxBmob saveReq(SaveListener<String> saveListener) {
        return new RxBmob.Builder().check(BmobFactory.rBySave(getTableName())).nextTest(BmobURL.getDefault().getUrl("create"), buildParams()).map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.BmobObject.3
            @Override // io.reactivex.functions.Function
            public String apply(JsonElement jsonElement) {
                String string = JsonUtil.getString(jsonElement, "objectId");
                String string2 = JsonUtil.getString(jsonElement, "createdAt");
                BmobObject.this.setObjectId(string);
                BmobObject.this.setCreatedAt(string2);
                return string;
            }
        }).subscribe(saveListener).build();
    }

    private RxBmob saveRequest(SaveListener<String> saveListener) {
        return new RxBmob.Builder().checkTest(true, BmobFactory.rBySave(getTableName()), saveListener).nextTest(BmobURL.getDefault().getUrl("create"), buildParams()).map(new Function<JsonElement, String>() { // from class: cn.bmob.v3.BmobObject.2
            @Override // io.reactivex.functions.Function
            public String apply(JsonElement jsonElement) {
                String string = JsonUtil.getString(jsonElement, "objectId");
                String string2 = JsonUtil.getString(jsonElement, "createdAt");
                BmobObject.this.setObjectId(string);
                BmobObject.this.setCreatedAt(string2);
                return string;
            }
        }).subscribe(saveListener).build();
    }

    private JSONObject updateParams(String str, BmobFactory.CheckInfo checkInfo) {
        checkInfo.work();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject currentData = getCurrentData();
            currentData.remove("createdAt");
            currentData.remove("updatedAt");
            currentData.remove("objectId");
            if (BmobInstallation.class.isAssignableFrom(getClass())) {
                currentData.remove("deviceType");
                currentData.remove("installationId");
            } else if (BmobRole.class.isAssignableFrom(getClass())) {
                currentData.remove("name");
            }
            jSONObject.put("c", getTableName());
            if (increments.size() > 0) {
                for (JSONObject jSONObject2 : increments) {
                    String strOptString = jSONObject2.optString("key");
                    jSONObject2.remove("key");
                    currentData.put(strOptString, jSONObject2);
                }
                increments.clear();
            }
            jSONObject.put("data", currentData);
            jSONObject.put("objectId", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    private RxBmob updateRequest(String str, UpdateListener updateListener) {
        return new RxBmob.Builder().check(BmobFactory.rByContext(str, " objectId can't be empty ")).nextTest(BmobURL.getDefault().getUrl("update"), updateParams(str, BmobFactory.checkNull(str))).map(new Function<JsonElement, Object>() { // from class: cn.bmob.v3.BmobObject.1
            @Override // io.reactivex.functions.Function
            public Object apply(JsonElement jsonElement) {
                BmobObject.this.setUpdatedAt(JsonUtil.getString(jsonElement, "updatedAt"));
                return new BmobException();
            }
        }).subscribe(updateListener).build();
    }

    public void add(String str, Object obj) {
        addAll(str, Arrays.asList(obj));
    }

    public void addAll(String str, Collection<?> collection) {
        try {
            data.put(str, addFieldOperation("Add", collection));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addAllUnique(String str, Collection<?> collection) {
        try {
            data.put(str, addFieldOperation("AddUnique", collection));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addUnique(String str, Object obj) {
        addAllUnique(str, Arrays.asList(obj));
    }

    @Deprecated
    protected Disposable delete() {
        return delete(null);
    }

    public Observable<Exception> deleteObservable(String str) {
        return deleteRequest(str, null).getObservable();
    }

    public BmobACL getACL() {
        return this.ACL;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    protected JSONObject getCurrentData() {
        JSONObject jSONObject;
        JSONObject jSONObjectDisposePointerType = null;
        try {
            jSONObject = new JSONObject(GsonUtil.toJson(this));
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            jSONObjectDisposePointerType = disposePointerType(this, jSONObject);
            jSONObjectDisposePointerType.remove("_c_");
            if (data.length() > 0) {
                Iterator<String> itKeys = data.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObjectDisposePointerType.put(next, data.opt(next));
                }
            }
        } catch (JSONException e3) {
            e = e3;
            jSONObjectDisposePointerType = jSONObject;
            e.printStackTrace();
        }
        return jSONObjectDisposePointerType;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public String getTableName() {
        return this._c_;
    }

    public String getUpdatedAt() {
        return this.updatedAt;
    }

    public void increment(String str) {
        increment(str, 1);
    }

    public void remove(String str) {
        try {
            data.put(str, new JSONObject().put("__op", "Delete"));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void removeAll(String str, Collection<?> collection) {
        try {
            data.put(str, addFieldOperation("Remove", collection));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public Disposable save(SaveListener<String> saveListener) {
        return saveRequest(saveListener).getDisposable();
    }

    public Observable<String> saveObservable() {
        return saveRequest(null).getObservable();
    }

    public String saveSync() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject currentData = getCurrentData();
            currentData.remove("createdAt");
            currentData.remove("updatedAt");
            currentData.remove("objectId");
            jSONObject.put("data", currentData);
            jSONObject.put("c", getTableName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return BmobClient.getInstance().saveSync(jSONObject);
    }

    public void setACL(BmobACL bmobACL) {
        this.ACL = bmobACL;
    }

    protected void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public void setTableName(String str) {
        this._c_ = str;
    }

    public void setUpdatedAt(String str) {
        this.updatedAt = str;
    }

    public void setValue(String str, Object obj) {
        try {
            data.put(str, parseValue(obj));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public Disposable update(UpdateListener updateListener) {
        return update(getObjectId(), updateListener);
    }

    public Observable<BmobException> updateObservable(String str) {
        return updateRequest(str, null).getObservable();
    }

    public String updateSync(String str) {
        String strUpdateSync = BmobClient.getInstance().updateSync(updateParams(str, new BmobFactory.CheckInfo(str, "objectId")));
        if (strUpdateSync != null) {
            setUpdatedAt(strUpdateSync);
        }
        return strUpdateSync;
    }

    public Disposable delete(UpdateListener updateListener) {
        return delete(getObjectId(), updateListener);
    }

    public void increment(String str, Number number) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("__op", "Increment");
            jSONObject.put("amount", number);
            jSONObject.put("key", str);
            increments.add(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public Disposable update(String str, UpdateListener updateListener) {
        return updateRequest(str, updateListener).getDisposable();
    }

    public Observable<BmobException> updateObservable() {
        return updateObservable(getObjectId());
    }

    public Disposable delete(String str, UpdateListener updateListener) {
        return deleteRequest(str, updateListener).getDisposable();
    }

    public String updateSync() {
        String strUpdateSync = BmobClient.getInstance().updateSync(updateParams(getObjectId(), new BmobFactory.CheckInfo(this.objectId, "objectId")));
        if (strUpdateSync != null) {
            setUpdatedAt(strUpdateSync);
        }
        return strUpdateSync;
    }

    public BmobObject(String str) {
        this._c_ = str;
        data = new JSONObject();
    }
}
