package com.miui.micloud;

import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.kss.DownloadRequestResult;
import cn.kuaipan.android.utils.ApiDataHelper;
import java.util.Map;
import java.util.zip.DataFormatException;

/* JADX INFO: loaded from: classes17.dex */
public class MiCloudDownloadRequestResult extends DownloadRequestResult implements ApiDataHelper.IKscData {
    public static final ApiDataHelper.IKscData.Parser<MiCloudDownloadRequestResult> PARSER = new ApiDataHelper.IKscData.Parser<MiCloudDownloadRequestResult>() { // from class: com.miui.micloud.MiCloudDownloadRequestResult.1
        @Override // cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser
        public /* bridge */ /* synthetic */ ApiDataHelper.IKscData parserMap(Map map, String[] strArr) throws DataFormatException, KscException {
            return parserMap((Map<String, Object>) map, strArr);
        }

        @Override // cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser
        public MiCloudDownloadRequestResult parserMap(Map<String, Object> map, String... strArr) throws DataFormatException, KscException {
            return new MiCloudDownloadRequestResult(map);
        }
    };

    public MiCloudDownloadRequestResult(Map<String, Object> map) throws KscException {
        super(map);
    }
}
