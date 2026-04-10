package com.kwad.components.ad.draw.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.i.a;

/* JADX INFO: loaded from: classes2.dex */
public class DrawDownloadProgressBar extends FrameLayout {
    private TextProgressBar dl;
    private View dm;
    private Context mContext;

    public DrawDownloadProgressBar(@NonNull Context context) {
        super(context);
        D(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        D(context);
    }

    public DrawDownloadProgressBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        D(context);
    }

    private void D(Context context) {
        this.mContext = context;
        a.inflate(this.mContext, R.layout.ksad_draw_download_bar, this);
        this.dl = (TextProgressBar) findViewById(R.id.ksad_download_progress);
        this.dm = findViewById(R.id.ksad_download_progress_cover);
        this.dm.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.draw.view.DrawDownloadProgressBar.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DrawDownloadProgressBar.this.performClick();
            }
        });
    }

    public final void f(String str, int i2) {
        View view;
        int i3;
        if (i2 == 0 || i2 == getMax()) {
            view = this.dm;
            i3 = 0;
        } else {
            view = this.dm;
            i3 = 8;
        }
        view.setVisibility(i3);
        this.dl.f(str, i2);
    }

    public int getMax() {
        return this.dl.getMax();
    }

    public void setTextColor(int i2) {
        this.dl.setTextColor(i2);
    }

    public void setTextSize(int i2) {
        this.dl.setTextDimen(com.kwad.sdk.b.kwai.a.a(getContext(), i2));
    }
}
