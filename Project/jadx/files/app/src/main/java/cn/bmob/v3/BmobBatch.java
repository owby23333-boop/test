package cn.bmob.v3;

import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.helper.GsonUtil;
import cn.bmob.v3.http.BmobFactory;
import cn.bmob.v3.http.BmobURL;
import cn.bmob.v3.http.RxBmob;
import cn.bmob.v3.listener.QueryListListener;
import cn.bmob.v3.util.BmobContentProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class BmobBatch {
    private final JSONArray requests = new JSONArray();

    private RxBmob createBatchRequest(QueryListListener<BatchResult> queryListListener) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", new JSONObject().put("requests", this.requests));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new RxBmob.Builder().check(BmobFactory.rByBatch(this.requests)).nextTest(BmobURL.getDefault().getUrl("batch"), jSONObject).mapBatch().subscribe(queryListListener).build();
    }

    private BmobBatch process(String str, List<BmobObject> list) {
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        for (BmobObject bmobObject : list) {
            if (bmobObject instanceof BmobUser) {
                throw new IllegalArgumentException("BmobUser does not support batch operations");
            }
            JSONObject jSONObject = new JSONObject(GsonUtil.toJson(bmobObject));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("method", str);
            if (str.equals("PUT") || str.equals("DELETE")) {
                jSONObject2.put("token", BmobContentProvider.getSessionToken());
                jSONObject2.put("path", "/1/classes/" + bmobObject.getTableName() + "/" + bmobObject.getObjectId());
                jSONObject.remove("createdAt");
                jSONObject.remove("updatedAt");
                jSONObject.remove("objectId");
            } else {
                jSONObject2.put("path", "/1/classes/" + bmobObject.getTableName());
            }
            jSONObject.remove("_c_");
            jSONObject2.put(AgooConstants.MESSAGE_BODY, BmobObject.disposePointerType(bmobObject, jSONObject));
            this.requests.put(jSONObject2);
            return this;
        }
        return this;
    }

    public BmobBatch deleteBatch(List<BmobObject> list) {
        return process("DELETE", list);
    }

    public Disposable doBatch(QueryListListener<BatchResult> queryListListener) {
        return createBatchRequest(queryListListener).getDisposable();
    }

    public Observable<List<BatchResult>> doBatchObservable() {
        return createBatchRequest(null).getObservable();
    }

    public BmobBatch insertBatch(List<BmobObject> list) {
        return process("POST", list);
    }

    public BmobBatch updateBatch(List<BmobObject> list) {
        return process("PUT", list);
    }
}
