package cn.bmob.v3.util;

import android.content.Context;
import android.text.TextUtils;
import cn.bmob.v3.BmobConstants;
import cn.bmob.v3.helper.GsonUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CacheManager {
    private static volatile CacheManager instance;
    Context context;

    private CacheManager(Context context) {
        this.context = context;
    }

    private String cast(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject2.get(next);
                if (next.contains(".")) {
                    parseKey(next, obj, jSONObject);
                } else if (obj instanceof JSONObject) {
                    parseJSONObject(next, (JSONObject) obj, jSONObject);
                } else if (obj instanceof JSONArray) {
                    jSONObject.put(next, (JSONArray) obj);
                } else {
                    jSONObject.put(next, obj);
                }
            }
            return jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static CacheManager getInstance(Context context) {
        if (instance == null) {
            synchronized (CacheManager.class) {
                if (instance == null) {
                    instance = new CacheManager(context);
                }
            }
        }
        return instance;
    }

    private void parseByObjects(String str, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONArray jSONArray;
        JSONArray jSONArray2 = new JSONArray();
        int i2 = 0;
        if (jSONObject.has("objects") && (jSONArray = jSONObject.getJSONArray("objects")) != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                jSONArray2.put(jSONArray.get(i3));
            }
        }
        String string = jSONObject.getString("__op");
        if (string.equals("Remove")) {
            if (!jSONObject2.has(str)) {
                BLog.e(BmobConstants.TAG, "no key remove");
                return;
            }
            ArrayList<Object> arrayListJsonArray2List = Utils.jsonArray2List(jSONObject2.getJSONArray(str));
            ArrayList<Object> arrayListJsonArray2List2 = Utils.jsonArray2List(jSONArray2);
            if (arrayListJsonArray2List2.size() <= 0) {
                BLog.e(BmobConstants.TAG, "no data remove");
                return;
            }
            int size = arrayListJsonArray2List2.size();
            while (i2 < size) {
                arrayListJsonArray2List.remove(arrayListJsonArray2List2.get(i2));
                i2++;
            }
            jSONObject2.put(str, Utils.list2JSONArray(arrayListJsonArray2List));
            return;
        }
        if (string.equals("AddUnique")) {
            if (!jSONObject2.has(str)) {
                jSONObject2.put(str, jSONArray2);
                return;
            }
            ArrayList<Object> arrayListJsonArray2List3 = Utils.jsonArray2List(jSONObject2.getJSONArray(str));
            arrayListJsonArray2List3.addAll(Utils.jsonArray2List(jSONArray2));
            jSONObject2.put(str, Utils.list2JSONArray(Utils.removeDuplicate(arrayListJsonArray2List3)));
            return;
        }
        if (!string.equals("Add")) {
            BLog.e(BmobConstants.TAG, "其他类型：" + string);
            return;
        }
        if (!jSONObject2.has(str)) {
            jSONObject2.put(str, jSONArray2);
            return;
        }
        if (jSONArray2.length() <= 0) {
            BLog.e(BmobConstants.TAG, "no data add");
            return;
        }
        int length2 = jSONArray2.length();
        while (i2 < length2) {
            jSONObject2.accumulate(str, jSONArray2.get(i2));
            i2++;
        }
    }

    private void parseJSONObject(String str, JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        if (!jSONObject.has("__op")) {
            jSONObject2.put(str, jSONObject);
            return;
        }
        String string = jSONObject.getString("__op");
        if (string.equals("Increment")) {
            int i2 = jSONObject.has("amount") ? jSONObject.getInt("amount") : 0;
            if (jSONObject2.has(str)) {
                i2 += jSONObject2.getInt(str);
            }
            jSONObject2.put(str, i2);
            return;
        }
        if (!string.equals("Delete")) {
            parseByObjects(str, jSONObject, jSONObject2);
        } else if (jSONObject2.has(str)) {
            jSONObject2.remove(str);
        } else {
            BLog.e(BmobConstants.TAG, "no key Delete");
        }
    }

    private void parseKey(String str, Object obj, JSONObject jSONObject) {
        try {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length < 2) {
                BLog.e(BmobConstants.TAG, "key length less than 2.");
                return;
            }
            String str2 = strArrSplit[0];
            if (strArrSplit.length == 2) {
                String str3 = strArrSplit[1];
                try {
                    int i2 = Integer.parseInt(str3);
                    JSONArray jSONArray = jSONObject.has(str2) ? jSONObject.getJSONArray(str2) : new JSONArray();
                    jSONArray.put(i2, obj);
                    jSONObject.put(str2, jSONArray);
                    return;
                } catch (Exception unused) {
                    JSONObject jSONObject2 = jSONObject.has(str2) ? jSONObject.getJSONObject(str2) : new JSONObject();
                    jSONObject2.put(str3, obj);
                    jSONObject.put(str2, jSONObject2);
                    return;
                }
            }
            if (strArrSplit.length != 3) {
                BLog.e(BmobConstants.TAG, "key length (" + strArrSplit.length + ") is not support.");
                return;
            }
            JSONArray jSONArray2 = jSONObject.has(str2) ? jSONObject.getJSONArray(str2) : new JSONArray();
            int i3 = Integer.parseInt(strArrSplit[1]);
            String str4 = strArrSplit[2];
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i3);
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            jSONObject3.put(str4, obj);
            jSONArray2.put(i3, jSONObject3);
            jSONObject.put(str2, jSONArray2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public <T> void changeCurrentUser(String str, String str2, Class<T> cls) {
        String user = BmobContentProvider.getUser();
        if (!TextUtils.isEmpty(user)) {
            Map<String, Object> map = GsonUtil.toMap(user);
            Map<String, Object> map2 = GsonUtil.toMap(str);
            if (map2.size() > 0 && map.size() > 0) {
                for (Map.Entry<String, Object> entry : map2.entrySet()) {
                    map.put(entry.getKey(), map2.get(entry.getKey()));
                }
            }
            str = GsonUtil.mapToJson(map);
        }
        BmobContentProvider.updateUser(cast(str, str2), cls);
    }
}
