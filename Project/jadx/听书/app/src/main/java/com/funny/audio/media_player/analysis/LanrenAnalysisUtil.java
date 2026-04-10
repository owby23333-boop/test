package com.funny.audio.media_player.analysis;

import com.funny.audio.core.net.CryptoLib;
import com.funny.audio.models.AlbumTrackAnalysisInfo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.umeng.analytics.pro.z;
import java.io.IOException;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: LanrenAnalysisUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/funny/audio/media_player/analysis/LanrenAnalysisUtil;", "", "()V", "_client", "Lokhttp3/OkHttpClient;", "client", "getClient", "()Lokhttp3/OkHttpClient;", "client$delegate", "Lkotlin/Lazy;", "gson", "Lcom/google/gson/Gson;", "analysis", "Lcom/funny/audio/media_player/analysis/AnalysisResult;", "analysisInfo", "Lcom/funny/audio/models/AlbumTrackAnalysisInfo;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LanrenAnalysisUtil {
    private static OkHttpClient _client;
    public static final LanrenAnalysisUtil INSTANCE = new LanrenAnalysisUtil();

    /* JADX INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private static final Lazy client = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.funny.audio.media_player.analysis.LanrenAnalysisUtil$client$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            if (LanrenAnalysisUtil._client != null) {
                OkHttpClient okHttpClient = LanrenAnalysisUtil._client;
                Intrinsics.checkNotNull(okHttpClient);
                return okHttpClient;
            }
            synchronized (LanrenAnalysisUtil.INSTANCE) {
                LanrenAnalysisUtil lanrenAnalysisUtil = LanrenAnalysisUtil.INSTANCE;
                LanrenAnalysisUtil._client = new OkHttpClient.Builder().build();
                Unit unit = Unit.INSTANCE;
            }
            OkHttpClient okHttpClient2 = LanrenAnalysisUtil._client;
            Intrinsics.checkNotNull(okHttpClient2);
            return okHttpClient2;
        }
    });
    private static final Gson gson = new Gson();

    private LanrenAnalysisUtil() {
    }

    private final OkHttpClient getClient() {
        return (OkHttpClient) client.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r3v12, types: [com.funny.audio.media_player.analysis.AnalysisResult] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v24, types: [com.funny.audio.media_player.analysis.AnalysisResult] */
    public final AnalysisResult analysis(AlbumTrackAnalysisInfo analysisInfo) {
        ?? IsSuccessful;
        String str;
        Intrinsics.checkNotNullParameter(analysisInfo, "analysisInfo");
        AnalysisResult analysisResult = new AnalysisResult();
        analysisResult.setSuccess(false);
        Map<String, Object> extras = analysisInfo.getExtras();
        Intrinsics.checkNotNull(extras);
        Object orDefault = extras.getOrDefault("apiUrl", "");
        Intrinsics.checkNotNull(orDefault, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) orDefault;
        Object orDefault2 = extras.getOrDefault("freeProviderSetting", "");
        Intrinsics.checkNotNull(orDefault2, "null cannot be cast to non-null type kotlin.String");
        Object orDefault3 = extras.getOrDefault("vipProviderSetting", "");
        Intrinsics.checkNotNull(orDefault3, "null cannot be cast to non-null type kotlin.String");
        Gson gson2 = gson;
        JsonObject jsonObject = (JsonObject) gson2.fromJson((String) orDefault2, JsonObject.class);
        JsonObject jsonObject2 = (JsonObject) gson2.fromJson((String) orDefault3, JsonObject.class);
        Map<String, Object> sourceExtras = analysisInfo.getSourceExtras();
        Intrinsics.checkNotNull(sourceExtras);
        Object orDefault4 = sourceExtras.getOrDefault("section", "1");
        Intrinsics.checkNotNull(orDefault4, "null cannot be cast to non-null type kotlin.String");
        String str3 = (String) orDefault4;
        Object orDefault5 = sourceExtras.getOrDefault("entityType", "1");
        Intrinsics.checkNotNull(orDefault5, "null cannot be cast to non-null type kotlin.String");
        String str4 = (String) orDefault5;
        Object orDefault6 = sourceExtras.getOrDefault("vipPriorityEndTime", "0");
        Intrinsics.checkNotNull(orDefault6, "null cannot be cast to non-null type kotlin.String");
        long j = Long.parseLong((String) orDefault6);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis <= j) {
            jsonObject = jsonObject2;
        }
        String asString = jsonObject.get(z.d).getAsString();
        Intrinsics.checkNotNullExpressionValue(asString, "obj.get(\"ua\").asString");
        String asString2 = jsonObject.get("duid").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString2, "obj.get(\"duid\").asString");
        String asString3 = jsonObject.get("lrid").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString3, "obj.get(\"lrid\").asString");
        String asString4 = jsonObject.get("lrid").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString4, "obj.get(\"lrid\").asString");
        String asString5 = jsonObject.get("opType").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString5, "obj.get(\"opType\").asString");
        String asString6 = jsonObject.get("ostar36").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString6, "obj.get(\"ostar36\").asString");
        String asString7 = jsonObject.get("token").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString7, "obj.get(\"token\").asString");
        String asString8 = jsonObject.get("userMode").getAsString();
        Intrinsics.checkNotNullExpressionValue(asString8, "obj.get(\"userMode\").asString");
        ?? r16 = analysisResult;
        String str5 = asString;
        String str6 = "/yyting/v2/gateway/getListenPath?costInfo=&duId=" + asString2 + "&entityId=" + analysisInfo.getSourceAlbumId() + "&entityType=" + str4 + "&id=" + analysisInfo.getSourceTrackId() + "&imei=" + asString3 + "&lrid=" + asString4 + "&mode=0&nwt=1&opType=" + asString5 + "&ostar36=" + asString6 + "&removeBgs=0&section=" + str3 + "&token=" + asString7 + "&ts=" + jCurrentTimeMillis + "&userMode=" + asString8;
        String str7 = str2 + str6 + "&sc=" + CryptoLib.INSTANCE.getSign3(str6);
        int i = 0;
        while (i <= 3) {
            try {
                str = str5;
                try {
                    Response responseExecute = getClient().newCall(new Request.Builder().url(str7).addHeader("User-Agent", str).get().build()).execute();
                    IsSuccessful = responseExecute.isSuccessful();
                    try {
                        if (IsSuccessful == 0) {
                            throw new IOException("Unexpected code " + responseExecute);
                        }
                        ResponseBody responseBodyBody = responseExecute.body();
                        String strString = responseBodyBody != null ? responseBodyBody.string() : null;
                        Intrinsics.checkNotNull(strString);
                        String playUrl = ((JsonObject) gson.fromJson(strString, JsonObject.class)).getAsJsonObject("data").get("path").getAsString();
                        Intrinsics.checkNotNullExpressionValue(playUrl, "playUrl");
                        ?? r3 = r16;
                        r3.setUrl(playUrl);
                        r3.setSuccess(true);
                        return r3;
                    } catch (Exception unused) {
                        continue;
                    }
                } catch (Exception unused2) {
                    IsSuccessful = r16;
                }
            } catch (Exception unused3) {
                IsSuccessful = r16;
                str = str5;
            }
            i++;
            r16 = IsSuccessful;
            str5 = str;
        }
        return r16;
    }
}
