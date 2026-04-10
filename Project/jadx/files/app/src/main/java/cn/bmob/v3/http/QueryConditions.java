package cn.bmob.v3.http;

import android.text.TextUtils;
import cn.bmob.v3.BmobArticle;
import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobRole;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobDate;
import cn.bmob.v3.datatype.BmobGeoPoint;
import cn.bmob.v3.datatype.BmobPointer;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.util.Utils;
import com.taobao.aranger.constant.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class QueryConditions {
    public static final int QUERY_TYPE_BQL = 5;
    public static final int QUERY_TYPE_COUNT = 3;
    public static final int QUERY_TYPE_STATISTICS = 4;
    public static final int QUERY_TYPE_TABLE = 1;
    public static final int QUERY_TYPE_V3 = 2;
    private String average;
    private String bql;
    private Class<?> clazz;
    private String groupby;
    private String include;
    private String keys;
    private Integer limit;
    private String max;
    private String min;
    private String objectId;
    private String order;
    private int queryType;
    private Integer skip;
    private String sum;
    private boolean hasGroupCount = false;
    private Object[] values = null;
    private JSONObject params = new JSONObject();
    private JSONObject data = new JSONObject();
    private JSONObject where = new JSONObject();
    private JSONObject having = new JSONObject();

    private void addGeoPoint(String str, String str2, BmobGeoPoint bmobGeoPoint, double d2) {
        addCondition(str, "$nearSphere", bmobGeoPoint);
        addCondition(str, str2, Double.valueOf(d2));
    }

    public void addCondition(String str, String str2, Object obj) {
        Object jSONObject;
        Object obj2 = obj;
        try {
            if (TextUtils.isEmpty(str2)) {
                if (obj2 instanceof BmobUser) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("__type", "Pointer");
                    jSONObject2.put("objectId", ((BmobUser) obj2).getObjectId());
                    jSONObject2.put("className", "_User");
                    this.where.put(str, jSONObject2);
                    return;
                }
                if (obj2 instanceof BmobInstallation) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("__type", "Pointer");
                    jSONObject3.put("objectId", ((BmobInstallation) obj2).getObjectId());
                    jSONObject3.put("className", "_Installation");
                    this.where.put(str, jSONObject3);
                    return;
                }
                if (obj2 instanceof BmobObject) {
                    BmobObject bmobObject = (BmobObject) obj2;
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("__type", "Pointer");
                    jSONObject4.put("objectId", bmobObject.getObjectId());
                    jSONObject4.put("className", bmobObject.getClass().getSimpleName());
                    this.where.put(str, jSONObject4);
                    return;
                }
                if (obj2 instanceof BmobGeoPoint) {
                    this.where.put(str, new JSONObject(GsonUtil.toJson(obj)));
                    return;
                }
                if (obj2 instanceof BmobDate) {
                    this.where.put(str, new JSONObject(GsonUtil.toJson(obj)));
                    return;
                }
                if (!(obj2 instanceof ArrayList)) {
                    this.where.put(str, obj2);
                    return;
                }
                ArrayList arrayList = (ArrayList) obj2;
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("__type", "GeoPoint");
                jSONObject5.put("longitude", ((BmobGeoPoint) arrayList.get(0)).getLongitude());
                jSONObject5.put("latitude", ((BmobGeoPoint) arrayList.get(0)).getLatitude());
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("__type", "GeoPoint");
                jSONObject6.put("longitude", ((BmobGeoPoint) arrayList.get(1)).getLongitude());
                jSONObject6.put("latitude", ((BmobGeoPoint) arrayList.get(1)).getLatitude());
                jSONArray.put(jSONObject5);
                jSONArray.put(jSONObject6);
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("$box", jSONArray);
                this.where.put(str, jSONObject7);
                return;
            }
            if (obj2 instanceof BmobGeoPoint) {
                jSONObject = new JSONObject(GsonUtil.toJson(obj));
            } else if (obj2 instanceof BmobUser) {
                JSONObject jSONObject8 = new JSONObject();
                jSONObject8.put("__type", "Pointer");
                jSONObject8.put("objectId", ((BmobUser) obj2).getObjectId());
                jSONObject8.put("className", "_User");
                jSONObject = jSONObject8;
            } else if (obj2 instanceof BmobInstallation) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put("__type", "Pointer");
                jSONObject9.put("objectId", ((BmobInstallation) obj2).getObjectId());
                jSONObject9.put("className", "_Installation");
                jSONObject = jSONObject9;
            } else if (obj2 instanceof BmobObject) {
                BmobObject bmobObject2 = (BmobObject) obj2;
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("__type", "Pointer");
                jSONObject10.put("objectId", bmobObject2.getObjectId());
                jSONObject10.put("className", bmobObject2.getClass().getSimpleName());
                jSONObject = jSONObject10;
            } else if (obj2 instanceof BmobDate) {
                jSONObject = new JSONObject(GsonUtil.toJson(obj));
            } else {
                boolean z2 = obj2 instanceof ArrayList;
                Object obj3 = obj2;
                if (z2) {
                    ArrayList arrayList2 = (ArrayList) obj2;
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject11 = new JSONObject();
                    jSONObject11.put("__type", "GeoPoint");
                    jSONObject11.put("longitude", ((BmobGeoPoint) arrayList2.get(0)).getLongitude());
                    jSONObject11.put("latitude", ((BmobGeoPoint) arrayList2.get(0)).getLatitude());
                    JSONObject jSONObject12 = new JSONObject();
                    jSONObject12.put("__type", "GeoPoint");
                    jSONObject12.put("longitude", ((BmobGeoPoint) arrayList2.get(1)).getLongitude());
                    jSONObject12.put("latitude", ((BmobGeoPoint) arrayList2.get(1)).getLatitude());
                    jSONArray2.put(jSONObject11);
                    jSONArray2.put(jSONObject12);
                    JSONObject jSONObject13 = new JSONObject();
                    jSONObject13.put("$box", jSONArray2);
                    obj3 = jSONObject13;
                }
                jSONObject = obj3;
            }
            JSONObject jSONObject14 = null;
            if (this.where.has(str)) {
                Object obj4 = this.where.get(str);
                if (obj4 instanceof JSONObject) {
                    jSONObject14 = (JSONObject) obj4;
                }
            }
            if (jSONObject14 == null) {
                jSONObject14 = new JSONObject();
            }
            JSONObject jSONObject15 = jSONObject14;
            jSONObject15.put(str2, jSONObject);
            this.where.put(str, jSONObject15);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addQueryKeys(String str) {
        this.keys = str;
    }

    public void addWhereContainedIn(String str, Collection<? extends Object> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends Object> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        addCondition(str, "$in", jSONArray);
    }

    public void addWhereContainsAll(String str, Collection<?> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        addCondition(str, "$all", jSONArray);
    }

    public void addWhereDoesNotExists(String str) {
        addCondition(str, "$exists", false);
    }

    public <E> void addWhereDoesNotMatchQuery(String str, String str2, BmobQuery<E> bmobQuery) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("where", bmobQuery.getWhere());
            jSONObject.put("className", str2);
            addCondition(str, "$notInQuery", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addWhereEqualTo(String str, Object obj) {
        if (!(obj instanceof BmobPointer)) {
            addCondition(str, null, obj);
            return;
        }
        try {
            addCondition(str, null, new JSONObject(GsonUtil.toJson(obj)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addWhereExists(String str) {
        addCondition(str, "$exists", true);
    }

    public void addWhereGreaterThan(String str, Object obj) {
        addCondition(str, "$gt", obj);
    }

    public void addWhereGreaterThanOrEqualTo(String str, Object obj) {
        addCondition(str, "$gte", obj);
    }

    public void addWhereLessThan(String str, Object obj) {
        addCondition(str, "$lt", obj);
    }

    public void addWhereLessThanOrEqualTo(String str, Object obj) {
        addCondition(str, "$lte", obj);
    }

    public void addWhereMatches(String str, String str2) {
        addCondition(str, "$regex", str2);
    }

    public <E> void addWhereMatchesQuery(String str, String str2, BmobQuery<E> bmobQuery) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("where", bmobQuery.getWhere());
            jSONObject.put("className", str2);
            addCondition(str, "$inQuery", jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void addWhereNear(String str, BmobGeoPoint bmobGeoPoint) {
        addCondition(str, "$nearSphere", bmobGeoPoint);
    }

    public void addWhereNotContainedIn(String str, Collection<? extends Object> collection) {
        JSONArray jSONArray = new JSONArray();
        Iterator<? extends Object> it = collection.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        addCondition(str, "$nin", jSONArray);
    }

    public void addWhereNotEqualTo(String str, Object obj) {
        addCondition(str, "$ne", obj);
    }

    public void addWhereRelatedTo(String str, BmobPointer bmobPointer) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", str);
            jSONObject.put("object", new JSONObject(GsonUtil.toJson(bmobPointer)));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        addCondition("$relatedTo", null, jSONObject);
    }

    public void addWhereWithinGeoBox(String str, BmobGeoPoint bmobGeoPoint, BmobGeoPoint bmobGeoPoint2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bmobGeoPoint);
        arrayList.add(bmobGeoPoint2);
        addCondition(str, "$within", arrayList);
    }

    public void addWhereWithinKilometers(String str, BmobGeoPoint bmobGeoPoint, double d2) {
        addGeoPoint(str, "$maxDistanceInKilometers", bmobGeoPoint, d2);
    }

    public void addWhereWithinMiles(String str, BmobGeoPoint bmobGeoPoint, double d2) {
        addGeoPoint(str, "$maxDistanceInMiles", bmobGeoPoint, d2);
    }

    public void addWhereWithinRadians(String str, BmobGeoPoint bmobGeoPoint, double d2) {
        addGeoPoint(str, "$maxDistanceInKilometers", bmobGeoPoint, d2);
    }

    public <T> void and(List<BmobQuery<T>> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<BmobQuery<T>> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getWhere());
        }
        addCondition("$and", null, jSONArray);
    }

    public JSONObject assembleParams() {
        try {
            if (getQueryType() == 1 || getQueryType() == 2) {
                if (getObjectId() != null) {
                    this.params.put("objectId", getObjectId());
                } else if (this.where.length() > 0) {
                    this.data.put("where", this.where);
                }
                if (!TextUtils.isEmpty(this.keys)) {
                    this.data.put(Constants.PARAM_KEYS, this.keys);
                }
                this.data.put("limit", this.limit);
                this.data.put("skip", this.skip);
                if (!TextUtils.isEmpty(this.order)) {
                    this.data.put("order", this.order);
                }
                if (!TextUtils.isEmpty(this.include)) {
                    this.data.put("include", this.include);
                }
            } else {
                int i2 = 0;
                if (getQueryType() == 3) {
                    if (this.where.length() != 0) {
                        this.data.put("where", this.where);
                    }
                    this.data.put("limit", 0);
                    this.data.put("count", true);
                } else if (getQueryType() == 4) {
                    if (this.where.length() != 0) {
                        this.data.put("where", this.where);
                    }
                    this.data.put(Constants.PARAM_KEYS, this.keys);
                    this.data.put("skip", this.skip);
                    this.data.put("limit", this.limit);
                    this.data.put("order", this.order);
                    if (!TextUtils.isEmpty(this.include)) {
                        this.data.put("include", this.include);
                    }
                    this.data.put("sum", this.sum);
                    this.data.put("max", this.max);
                    this.data.put("min", this.min);
                    this.data.put("average", this.average);
                    this.data.put("groupby", this.groupby);
                    if (this.having.length() != 0) {
                        this.data.put("having", this.having);
                    }
                    if (this.hasGroupCount) {
                        this.data.put("groupcount", true);
                    }
                } else if (getQueryType() == 5) {
                    if (!TextUtils.isEmpty(this.bql)) {
                        this.data.put("bql", this.bql);
                    }
                    if (this.values != null && this.values.length > 0) {
                        JSONArray jSONArray = new JSONArray();
                        Object[] objArr = this.values;
                        int length = objArr.length;
                        while (i2 < length) {
                            jSONArray.put(objArr[i2]);
                            i2++;
                        }
                        this.data.put("values", jSONArray);
                    }
                } else {
                    if (getObjectId() != null) {
                        this.params.put("objectId", getObjectId());
                    } else if (this.where.length() > 0) {
                        this.data.put("where", this.where);
                    }
                    if (!TextUtils.isEmpty(this.keys)) {
                        this.data.put(Constants.PARAM_KEYS, this.keys);
                    }
                    this.data.put("limit", this.limit);
                    this.data.put("skip", this.skip);
                    if (!TextUtils.isEmpty(this.order)) {
                        this.data.put("order", this.order);
                    }
                    if (!TextUtils.isEmpty(this.include)) {
                        this.data.put("include", this.include);
                    }
                    if (!TextUtils.isEmpty(this.bql)) {
                        this.data.put("bql", this.bql);
                    }
                    if (this.values != null && this.values.length > 0) {
                        JSONArray jSONArray2 = new JSONArray();
                        Object[] objArr2 = this.values;
                        int length2 = objArr2.length;
                        while (i2 < length2) {
                            jSONArray2.put(objArr2[i2]);
                            i2++;
                        }
                        this.data.put("values", jSONArray2);
                    }
                }
            }
            if (this.clazz != null) {
                if (BmobUser.class.isAssignableFrom(this.clazz)) {
                    this.params.put("c", "_User");
                } else if (BmobInstallation.class.isAssignableFrom(this.clazz)) {
                    this.params.put("c", "_Installation");
                } else if (BmobRole.class.isAssignableFrom(this.clazz)) {
                    this.params.put("c", "_Role");
                } else if (BmobArticle.class.isAssignableFrom(this.clazz)) {
                    this.params.put("c", "_Article");
                } else {
                    this.params.put("c", this.clazz.getSimpleName());
                }
            }
            this.params.put("data", this.data);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.params;
    }

    public void average(String[] strArr) {
        this.average = Utils.parseArray2String(strArr);
    }

    public String getAverage() {
        return this.average;
    }

    public String getBql() {
        return this.bql;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    public JSONObject getHaving() {
        return this.having;
    }

    public String getMax() {
        return this.max;
    }

    public String getMin() {
        return this.min;
    }

    public String getObjectId() {
        return this.objectId;
    }

    public JSONObject getParams() {
        return this.params;
    }

    public int getQueryType() {
        return this.queryType;
    }

    public String getSum() {
        return this.sum;
    }

    public Object[] getValues() {
        return this.values;
    }

    public JSONObject getWhere() {
        return this.where;
    }

    public void groupby(String[] strArr) {
        this.groupby = Utils.parseArray2String(strArr);
    }

    public void having(HashMap<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                this.having.put(entry.getKey(), entry.getValue());
            } catch (JSONException unused) {
            }
        }
    }

    public boolean isHasGroupCount() {
        return this.hasGroupCount;
    }

    public void max(String[] strArr) {
        this.max = Utils.parseArray2String(strArr);
    }

    public void min(String[] strArr) {
        this.min = Utils.parseArray2String(strArr);
    }

    public <T> void or(List<BmobQuery<T>> list) {
        JSONArray jSONArray = new JSONArray();
        Iterator<BmobQuery<T>> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().getWhere());
        }
        addCondition("$or", null, jSONArray);
    }

    public void setBql(String str) {
        this.bql = str;
    }

    public void setClazz(Class<?> cls) {
        this.clazz = cls;
    }

    public void setHasGroupCount(boolean z2) {
        this.hasGroupCount = z2;
    }

    public void setInclude(String str) {
        this.include = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setObjectId(String str) {
        this.objectId = str;
    }

    public void setOrder(String str) {
        this.order = str;
    }

    public void setParams(JSONObject jSONObject) {
        this.params = jSONObject;
    }

    public void setQueryType(int i2) {
        this.queryType = i2;
    }

    public void setSkip(Integer num) {
        this.skip = num;
    }

    public void setValues(Object[] objArr) {
        this.values = objArr;
    }

    public void sum(String[] strArr) {
        this.sum = Utils.parseArray2String(strArr);
    }
}
