package com.kwad.components.core.webview.jshandler;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements com.kwad.sdk.core.webview.b.a {
    private final WebView Lk;
    private Handler Ss;

    @Nullable
    private com.kwad.sdk.core.webview.b.c St;
    private boolean Tj;

    @Nullable
    private b cW;

    public static final class a implements com.kwad.sdk.core.b {
        public int bottomMargin;
        public int height;
        public int leftMargin;
        public int rightMargin;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.height = jSONObject.optInt("height");
            this.leftMargin = jSONObject.optInt("leftMargin");
            this.rightMargin = jSONObject.optInt("rightMargin");
            this.bottomMargin = jSONObject.optInt("bottomMargin");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.s.putValue(jSONObject, "height", this.height);
            com.kwad.sdk.utils.s.putValue(jSONObject, "leftMargin", this.leftMargin);
            com.kwad.sdk.utils.s.putValue(jSONObject, "rightMargin", this.rightMargin);
            com.kwad.sdk.utils.s.putValue(jSONObject, "bottomMargin", this.bottomMargin);
            return jSONObject;
        }
    }

    public interface b {
        @MainThread
        void a(@NonNull a aVar);
    }

    public s(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2) {
        this(bVar, bVar2, true);
    }

    private s(com.kwad.sdk.core.webview.b bVar, @Nullable b bVar2, boolean z2) {
        this.Tj = true;
        this.Ss = new Handler(Looper.getMainLooper());
        this.Lk = bVar.Lk;
        this.cW = bVar2;
        this.Tj = true;
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.St = cVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            final a aVar = new a();
            aVar.parseJson(jSONObject);
            this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.s.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (s.this.Lk != null && s.this.Tj) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) s.this.Lk.getLayoutParams();
                        marginLayoutParams.width = -1;
                        a aVar2 = aVar;
                        marginLayoutParams.height = aVar2.height;
                        marginLayoutParams.leftMargin = aVar2.leftMargin;
                        marginLayoutParams.rightMargin = aVar2.rightMargin;
                        marginLayoutParams.bottomMargin = aVar2.bottomMargin;
                        s.this.Lk.setLayoutParams(marginLayoutParams);
                    }
                    if (s.this.cW != null) {
                        s.this.cW.a(aVar);
                    }
                }
            });
            this.Ss.post(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.s.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (s.this.St != null) {
                        s.this.St.a(null);
                    }
                }
            });
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            cVar.onError(-1, e2.getMessage());
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "initKsAdFrame";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.St = null;
        this.cW = null;
        this.Ss.removeCallbacksAndMessages(null);
    }
}
