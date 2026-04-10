package com.kathline.horizontalrefresh.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kathline.horizontalrefresh.R$drawable;
import com.kathline.horizontalrefresh.R$id;
import com.kathline.horizontalrefresh.R$layout;
import com.kathline.horizontalrefresh.b;

/* JADX INFO: compiled from: NiceRefreshHeader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements b {
    private final Context a;
    private ProgressBar b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f16416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f16417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16418e;

    public a(Context context, String str) {
        this.a = context;
        this.f16418e = str;
    }

    @Override // com.kathline.horizontalrefresh.b
    @NonNull
    public View a(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.a).inflate(R$layout.nice_refresh_header, viewGroup, false);
        this.b = (ProgressBar) viewInflate.findViewById(R$id.progressbar);
        this.f16416c = (ImageView) viewInflate.findViewById(R$id.static_loading);
        this.f16417d = (TextView) viewInflate.findViewById(R$id.tv_tips);
        this.f16417d.setText(this.f16418e);
        this.b.setVisibility(4);
        return viewInflate;
    }

    @Override // com.kathline.horizontalrefresh.b
    public void b(View view) {
    }

    @Override // com.kathline.horizontalrefresh.b
    public void a(int i2, View view) {
        this.f16416c.setVisibility(0);
        this.b.setVisibility(4);
    }

    @Override // com.kathline.horizontalrefresh.b
    public void a(float f2, float f3, View view) {
        switch ((int) (f3 * 10.0f)) {
            case 1:
            case 4:
            case 7:
                this.f16416c.setBackgroundResource(R$drawable.pic_loadpose_lib1);
                break;
            case 2:
            case 5:
            case 8:
                this.f16416c.setBackgroundResource(R$drawable.pic_loadpose_lib2);
                break;
            case 3:
            case 6:
            case 9:
                this.f16416c.setBackgroundResource(R$drawable.pic_loadpose_lib1);
                break;
        }
    }

    @Override // com.kathline.horizontalrefresh.b
    public void a(View view) {
        this.f16416c.setVisibility(4);
        this.b.setVisibility(0);
    }
}
