package com.sntech.ads.page;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.sntech.ads.R;

/* JADX INFO: loaded from: classes3.dex */
public class WarnActivity extends Activity {
    public static final String WARN_BUTTON = "warn_button";
    public static final String WARN_CLOSABLE = "warn_closable";
    public static final String WARN_MSG = "warn_msg";
    private boolean mClosable = false;

    static void a(View view) {
        Process.killProcess(Process.myPid());
    }

    public static void start(Context context, String str, String str2) {
        start(context, str, str2, false);
    }

    @Override // android.app.Activity
    public void finish() {
        if (this.mClosable) {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_warn);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(WARN_MSG);
            String stringExtra2 = intent.getStringExtra(WARN_BUTTON);
            this.mClosable = intent.getBooleanExtra(WARN_CLOSABLE, false);
            ((TextView) findViewById(R.id.warn_msg)).setText(stringExtra);
            if (TextUtils.isEmpty(stringExtra2)) {
                findViewById(R.id.warn_button).setVisibility(8);
            } else {
                ((TextView) findViewById(R.id.warn_button)).setText(stringExtra2);
            }
        }
        findViewById(R.id.warn_button).setOnClickListener(new View.OnClickListener() { // from class: com.sntech.ads.page.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WarnActivity.a(view);
            }
        });
    }

    public static void start(Context context, String str, String str2, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) WarnActivity.class);
        intent.putExtra(WARN_MSG, str);
        intent.putExtra(WARN_BUTTON, str2);
        intent.putExtra(WARN_CLOSABLE, z2);
        intent.addFlags(268468224);
        context.startActivity(intent);
    }
}
