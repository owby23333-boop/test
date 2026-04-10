package com.miui.micloud;

import cn.kuaipan.android.exception.KscException;
import cn.kuaipan.android.utils.ApiDataHelper;
import java.util.Map;
import java.util.zip.DataFormatException;

/* JADX INFO: loaded from: classes17.dex */
public class MiCloudCommitResult implements ApiDataHelper.IKscData {
    public static final ApiDataHelper.IKscData.Parser<MiCloudCommitResult> PARSER = new ApiDataHelper.IKscData.Parser<MiCloudCommitResult>() { // from class: com.miui.micloud.MiCloudCommitResult.1
        @Override // cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser
        public /* bridge */ /* synthetic */ ApiDataHelper.IKscData parserMap(Map map, String[] strArr) throws DataFormatException, KscException {
            return parserMap((Map<String, Object>) map, strArr);
        }

        @Override // cn.kuaipan.android.utils.ApiDataHelper.IKscData.Parser
        public MiCloudCommitResult parserMap(Map<String, Object> map, String... strArr) throws DataFormatException, KscException {
            return new MiCloudCommitResult(map);
        }
    };
    public final String stat;

    private MiCloudCommitResult(Map<String, Object> map) {
        this.stat = ApiDataHelper.asString(map, "stat");
    }
}
