package com.kwad.components.core.webview.jshandler;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.bh;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ak implements com.kwad.sdk.core.webview.b.a {

    @Nullable
    private com.kwad.sdk.core.webview.b.c St;
    private b Ua;

    public static final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int visibility;
    }

    public interface b {
        @MainThread
        void a(a aVar);
    }

    public ak(b bVar) {
        this.Ua = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        b bVar = this.Ua;
        if (bVar != null) {
            bVar.a(aVar);
        }
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
        this.St = cVar;
        final a aVar = new a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
        bh.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.ak.1
            @Override // java.lang.Runnable
            public final void run() {
                ak.this.b(aVar);
                if (ak.this.St != null) {
                    ak.this.St.a(null);
                }
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.b.a
    @NonNull
    public final String getKey() {
        return "setHeaderBar";
    }

    @Override // com.kwad.sdk.core.webview.b.a
    public final void onDestroy() {
        this.Ua = null;
        this.St = null;
    }
}
