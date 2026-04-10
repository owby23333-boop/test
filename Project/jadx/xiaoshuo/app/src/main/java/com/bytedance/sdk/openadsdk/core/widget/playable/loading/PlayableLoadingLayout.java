package com.bytedance.sdk.openadsdk.core.widget.playable.loading;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.openadsdk.core.bf.tg;
import com.bytedance.sdk.openadsdk.widget.TTLoadingProgressBar;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class PlayableLoadingLayout extends LinearLayout {
    protected TTLoadingProgressBar bf;
    protected TextView d;
    protected View e;
    protected JSONObject ga;
    protected TextView tg;

    public PlayableLoadingLayout(Context context, JSONObject jSONObject) {
        super(context);
        this.ga = jSONObject;
    }

    public void bf() {
        setVisibility(0);
    }

    public void e(Context context) {
        setVisibility(8);
        LayoutInflater.from(context).inflate(dt.vn(context, "tt_playable_loading_default_layout"), (ViewGroup) this, true);
        TTLoadingProgressBar tTLoadingProgressBar = (TTLoadingProgressBar) findViewById(dt.ga(context, "tt_playable_pb_view"));
        this.bf = tTLoadingProgressBar;
        tTLoadingProgressBar.getProgressBar().setBackgroundColor(Color.parseColor("#FC625C"));
        this.d = (TextView) findViewById(dt.ga(context, "tt_playable_progress_tip"));
        this.tg = (TextView) findViewById(dt.ga(context, "tt_playable_play"));
        JSONObject jSONObject = this.ga;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("button_text");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.tg.setText(strOptString);
        }
    }

    public void setBtnPlayOnClickListener(tg tgVar) {
        TextView textView = this.tg;
        if (textView == null || tgVar == null) {
            return;
        }
        textView.setOnClickListener(tgVar);
    }

    public void setBtnPlayOnTouchListener(tg tgVar) {
        TextView textView = this.tg;
        if (textView == null || tgVar == null) {
            return;
        }
        textView.setOnTouchListener(tgVar);
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        TTLoadingProgressBar tTLoadingProgressBar = this.bf;
        if (tTLoadingProgressBar != null) {
            tTLoadingProgressBar.setProgress(i);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf(i)));
        }
    }

    public PlayableLoadingLayout(Context context) {
        super(context);
    }

    public void e() {
        setVisibility(8);
    }
}
