package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class WebCardVideoPositionHandler implements com.kwad.sdk.core.webview.b.a {
    private a Ug;
    private VideoPosition Uf = new VideoPosition();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public static final class VideoPosition extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        private static final long serialVersionUID = -3445790097441569428L;
        public int borderRadius;
        public KSAdJSCornerModel cornerRadius;
        public int height;
        public double heightWidthRation;
        public int leftMargin;
        public double leftMarginRation;
        public int topMargin;
        public double topMarginRation;
        public int width;
        public double widthRation;

        public static class KSAdJSCornerModel extends com.kwad.sdk.core.response.kwai.a implements Serializable {
            private static final long serialVersionUID = -1503191931449786332L;
            public double bottomLeft;
            public double bottomRight;
            public double topLeft;
            public double topRight;
        }

        @Override // com.kwad.sdk.core.response.kwai.a
        public final void afterParseJson(@Nullable JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            if (jSONObject.has("cornerRadius")) {
                this.cornerRadius = new KSAdJSCornerModel();
                this.cornerRadius.parseJson(jSONObject.optJSONObject("cornerRadius"));
            }
        }
    }

    public interface a {
        void a(VideoPosition videoPosition);
    }

    public WebCardVideoPositionHandler(a aVar) {
        this.Ug = aVar;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        try {
            this.Uf.parseJson(new JSONObject(str));
            if (this.Ug != null) {
                this.mHandler.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.WebCardVideoPositionHandler.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebCardVideoPositionHandler.this.Ug.a(WebCardVideoPositionHandler.this.Uf);
                    }
                });
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        cVar.a(null);
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "videoPosition";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.mHandler.removeCallbacksAndMessages(null);
    }
}
