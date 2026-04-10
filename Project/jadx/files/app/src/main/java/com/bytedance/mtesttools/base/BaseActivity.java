package com.bytedance.mtesttools.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.example.adtesttool.R$id;
import com.example.adtesttool.R$layout;

/* JADX INFO: loaded from: classes2.dex */
public class BaseActivity extends Activity {
    ImageView a;
    TextView b;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseActivity.this.finish();
        }
    }

    protected int a() {
        return R$layout.ttt_activity_base;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(a());
        this.a = (ImageView) findViewById(R$id.back_view);
        this.b = (TextView) findViewById(R$id.title);
    }

    public void a(String str, boolean z2) {
        if (z2) {
            this.a.setVisibility(0);
            this.a.setOnClickListener(new a());
        } else {
            this.a.setVisibility(8);
        }
        this.b.setText(str);
    }
}
