package com.bytedance.msdk.core.admanager.reward.rewardagain;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.tb;

/* JADX INFO: loaded from: classes2.dex */
public class GMRewardAgainDialogActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(tb.e(this, "reward_again_dialog"));
        ImageView imageView = (ImageView) findViewById(tb.m(this, "ra_pic"));
        TextView textView = (TextView) findViewById(tb.m(this, "ra_title"));
        TextView textView2 = (TextView) findViewById(tb.m(this, "ra_btn_ok"));
        TextView textView3 = (TextView) findViewById(tb.m(this, "ra_btn_cancel"));
        g gVar = dl.dl().z;
        if (gVar != null) {
            textView.setText(gVar.g());
            textView2.setText(gVar.a());
            textView3.setText(gVar.gc());
            if (!TextUtils.isEmpty(gVar.dl())) {
                new com.bytedance.msdk.z.gc.g(imageView).z((Object[]) new String[]{gVar.dl()});
            }
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GMRewardAgainDialogActivity.this.finish();
                Runnable runnable = dl.dl().g;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.msdk.core.admanager.reward.rewardagain.GMRewardAgainDialogActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GMRewardAgainDialogActivity.this.finish();
                Runnable runnable = dl.dl().dl;
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
