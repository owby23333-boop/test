package com.miui.micloud;

import cn.kuaipan.android.exception.ErrorCode;
import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.kss.UploadRequestResult;
import cn.kuaipan.android.utils.ApiDataHelper;
import cn.kuaipan.android.utils.IObtainable;
import cn.kuaipan.android.utils.JsonUtils;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.zip.DataFormatException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes17.dex */
public class MiCloudUploadRequestResult extends UploadRequestResult implements ApiDataHelper.IKscData {
    public static final String MAP_KEY_KSS = "kss_map";
    public static final String MAP_KEY_REQUEST_ID = "requestId";
    public static final String MAP_KEY_RESULT = "result_map";
    public static final ApiDataHelper.IKscData.Parser<MiCloudUploadRequestResult> PARSER = new ApiDataHelper.IKscData.Parser<MiCloudUploadRequestResult>() { // from class: com.miui.micloud.MiCloudUploadRequestResult.1
        @Override // cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser
        public /* bridge */ /* synthetic */ ApiDataHelper.IKscData parserMap(Map map, String[] strArr) throws DataFormatException, KscException {
            return parserMap((Map<String, Object>) map, strArr);
        }

        @Override // cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser
        public MiCloudUploadRequestResult parserMap(Map<String, Object> map, String... strArr) throws DataFormatException, KscException {
            return new MiCloudUploadRequestResult(map);
        }
    };
    public final String requestId;

    public MiCloudUploadRequestResult(Map<String, Object> map) throws KscException {
        super(map);
        this.requestId = ApiDataHelper.asString(map, MAP_KEY_REQUEST_ID);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public static MiCloudUploadRequestResult create(String str) throws Throwable {
        Throwable th;
        JSONException e;
        IOException e2;
        try {
            try {
                Map map = (Map) JsonUtils.parser(new StringReader(str));
                try {
                    MiCloudUploadRequestResult miCloudUploadRequestResult = new MiCloudUploadRequestResult(map);
                    if (map != null && (map instanceof IObtainable)) {
                        ((IObtainable) map).recycle();
                    }
                    return miCloudUploadRequestResult;
                } catch (IOException e3) {
                    e2 = e3;
                    throw new KscException(ErrorCode.DATA_IS_EMPTY, "kss is null", e2);
                } catch (JSONException e4) {
                    e = e4;
                    throw new KscException(ErrorCode.DATA_IS_NOT_JSON, "kss is not json", e);
                }
            } catch (IOException e5) {
                e2 = e5;
            } catch (JSONException e6) {
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                if (str != 0) {
                    ((IObtainable) str).recycle();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (str != 0 && (str instanceof IObtainable)) {
                ((IObtainable) str).recycle();
            }
            throw th;
        }
    }

    @Override // cn.kuaipan.android.kss.UploadRequestResult
    public String toString() {
        String string = super.toString();
        try {
            return new JSONObject(string).put(MAP_KEY_REQUEST_ID, this.requestId).toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return string;
        }
    }
}
