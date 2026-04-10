package com.kwad.components.ad.reward.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.components.ad.reward.i.c;
import com.kwad.sdk.R;
import com.kwad.sdk.i.a;
import com.kwad.sdk.widget.DividerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RewardTaskStepView extends LinearLayout {
    private List<c> Bb;
    private String qL;

    public RewardTaskStepView(Context context) {
        super(context);
        this.Bb = new ArrayList();
        kt();
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Bb = new ArrayList();
        kt();
    }

    public RewardTaskStepView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Bb = new ArrayList();
        kt();
    }

    @RequiresApi(api = 21)
    public RewardTaskStepView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.Bb = new ArrayList();
        kt();
    }

    private void a(int i2, String str, String str2, boolean z2) {
        ViewGroup viewGroup = (ViewGroup) a.a(getContext(), z2 ? R.layout.ksad_reward_task_step_item_checked : R.layout.ksad_reward_task_step_item_unchecked, this, false);
        if (z2) {
            a(viewGroup, str);
        } else {
            a(viewGroup, i2, str2);
        }
        addView(viewGroup);
    }

    private void a(ViewGroup viewGroup, int i2, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(String.format(str, this.qL));
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_icon_text)).setText(String.valueOf(i2));
    }

    private static void a(ViewGroup viewGroup, String str) {
        ((TextView) viewGroup.findViewById(R.id.ksad_reward_task_step_item_text)).setText(str);
    }

    private void af(boolean z2) {
        DividerView dividerView = (DividerView) a.a(getContext(), R.layout.ksad_reward_task_dialog_dash, this, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_icon_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.ksad_reward_apk_info_card_step_divider_height);
        dividerView.setDividerColor(getResources().getColor(z2 ? R.color.ksad_reward_main_color : R.color.ksad_reward_undone_color));
        addView(dividerView, dimensionPixelSize, dimensionPixelSize2);
    }

    private void kt() {
        setOrientation(1);
    }

    private void ku() {
        int size = this.Bb.size();
        int i2 = 0;
        while (i2 < size) {
            c cVar = this.Bb.get(i2);
            int i3 = i2 + 1;
            a(i3, cVar.jH(), cVar.jI(), cVar.isCompleted());
            if (i2 < size - 1) {
                af(this.Bb.get(i3).isCompleted());
            }
            i2 = i3;
        }
    }

    public final void a(List<c> list, String str) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.qL = str;
        this.Bb.clear();
        this.Bb.addAll(list);
        ku();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
