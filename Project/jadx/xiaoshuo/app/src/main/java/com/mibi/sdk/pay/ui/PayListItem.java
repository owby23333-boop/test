package com.mibi.sdk.pay.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mibi.sdk.component.recharge.RechargeType;
import com.mibi.sdk.pay.ui.imageloader.ImageHelper;

/* JADX INFO: loaded from: classes15.dex */
public class PayListItem extends LinearLayout implements Checkable {
    private static final int[] f = {android.R.attr.state_checked};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f7151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextView f7152b;
    private TextView c;
    private RechargeType d;
    private boolean e;

    public PayListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a() {
        this.f7151a = (ImageView) findViewById(R.id.icon);
        this.f7152b = (TextView) findViewById(R.id.label);
        this.c = (TextView) findViewById(R.id.sub_label);
    }

    public RechargeType getPayType() {
        return this.d;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (!this.e) {
            return super.onCreateDrawableState(i);
        }
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        View.mergeDrawableStates(iArrOnCreateDrawableState, f);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.e != z) {
            this.e = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.e);
    }

    public void a(RechargeType rechargeType) {
        this.d = rechargeType;
        if (rechargeType != null) {
            this.f7152b.setText(rechargeType.mTitle);
            if (!TextUtils.isEmpty(rechargeType.mTitleHint)) {
                this.c.setVisibility(0);
                this.c.setText(rechargeType.mTitleHint);
            }
            if (TextUtils.isEmpty(rechargeType.mIcon)) {
                if (rechargeType.mLocalIconRes != -1) {
                    this.f7151a.setImageDrawable(getResources().getDrawable(rechargeType.mLocalIconRes));
                    return;
                } else {
                    this.f7151a.setImageDrawable(getResources().getDrawable(R.drawable.mibi_ic_recharge_item_default));
                    return;
                }
            }
            ImageHelper.get(getContext()).load(ImageHelper.getAbsoluteUrl(rechargeType.mIcon)).placeholder(R.drawable.mibi_ic_recharge_item_default).into(this.f7151a);
            return;
        }
        throw new IllegalArgumentException("mRechargeType in PayType should not be null");
    }
}
