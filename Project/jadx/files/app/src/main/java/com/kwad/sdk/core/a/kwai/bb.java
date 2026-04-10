package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import com.taobao.aranger.constant.Constants;
import java.util.ArrayList;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class bb implements com.kwad.sdk.core.d<BlockEvent> {
    private static void a(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        blockEvent.blockDuration = jSONObject.optLong("blockDuration");
        blockEvent.blockTimeThreshold = jSONObject.optLong("blockTimeThreshold", new Long("1000").longValue());
        blockEvent.blockLoopInterval = jSONObject.optLong("blockLoopInterval", new Long(MessageService.MSG_DB_COMPLETE).longValue());
        blockEvent.calcBlockOverhead = jSONObject.optLong("calcBlockOverhead");
        blockEvent.currentActivity = jSONObject.optString("currentActivity");
        if (blockEvent.currentActivity == JSONObject.NULL) {
            blockEvent.currentActivity = "";
        }
        blockEvent.processName = jSONObject.optString(Constants.PARAM_PROCESS_NAME);
        if (blockEvent.processName == JSONObject.NULL) {
            blockEvent.processName = "";
        }
        blockEvent.stackTraceSample = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("stackTraceSample");
        if (jSONArrayOptJSONArray != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                BlockEvent.a aVar = new BlockEvent.a();
                aVar.parseJson(jSONArrayOptJSONArray.optJSONObject(i2));
                blockEvent.stackTraceSample.add(aVar);
            }
        }
    }

    private static JSONObject b(BlockEvent blockEvent, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = blockEvent.blockDuration;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "blockDuration", j2);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "blockTimeThreshold", blockEvent.blockTimeThreshold);
        com.kwad.sdk.utils.s.putValue(jSONObject, "blockLoopInterval", blockEvent.blockLoopInterval);
        long j3 = blockEvent.calcBlockOverhead;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "calcBlockOverhead", j3);
        }
        String str = blockEvent.currentActivity;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "currentActivity", blockEvent.currentActivity);
        }
        String str2 = blockEvent.processName;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, Constants.PARAM_PROCESS_NAME, blockEvent.processName);
        }
        com.kwad.sdk.utils.s.putValue(jSONObject, "stackTraceSample", blockEvent.stackTraceSample);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BlockEvent) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BlockEvent) bVar, jSONObject);
    }
}
