package fm.qingting.open.bridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.webkit.WebView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f21016a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final WebView f21017b;

    @NotNull
    private final LocalBroadcastManager c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public b(@NotNull WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.f21017b = webView;
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(webView.getContext().getApplicationContext());
        Intrinsics.checkNotNullExpressionValue(localBroadcastManager, "getInstance(webView.context.applicationContext)");
        this.c = localBroadcastManager;
    }

    public final void a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fm.qingting.open.mini.bridge.calljs.ACTION");
        try {
            this.c.registerReceiver(this, intentFilter);
        } catch (Exception unused) {
        }
    }

    public final void b() {
        try {
            this.c.unregisterReceiver(this);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "fm.qingting.open.mini.bridge.calljs.ACTION")) {
            String stringExtra = intent.getStringExtra("method");
            String stringExtra2 = intent.getStringExtra("data");
            this.f21017b.loadUrl("javascript:" + ((Object) stringExtra) + "('" + ((Object) stringExtra2) + "')");
        }
    }
}
