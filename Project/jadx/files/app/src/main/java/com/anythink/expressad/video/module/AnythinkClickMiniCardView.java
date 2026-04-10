package com.anythink.expressad.video.module;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import androidx.annotation.RequiresApi;
import com.anythink.core.common.b.n;
import com.anythink.expressad.atsignalcommon.windvane.WindVaneWebView;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.t;
import com.anythink.expressad.video.signal.factory.b;
import com.anythink.expressad.videocommon.b.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AnythinkClickMiniCardView extends AnythinkH5EndCardView {
    private static final float A = 0.7f;
    private boolean B;

    public AnythinkClickMiniCardView(Context context) {
        super(context);
        this.B = false;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final String a() {
        c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        c.C0205c c0205cM = cVar.M();
        String strD = c0205cM != null ? c0205cM.d() : null;
        if (TextUtils.isEmpty(strD) || !strD.contains(".zip")) {
            return strD;
        }
        String strC = i.a().c(strD);
        return !TextUtils.isEmpty(strC) ? strC : strD;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    protected final RelativeLayout.LayoutParams b() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        return layoutParams;
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    @RequiresApi(api = 11)
    protected final void e() {
        super.e();
        if (this.f11788f) {
            setBackgroundResource(findColor("anythink_reward_minicard_bg"));
            a(this.f11822p);
            setClickable(true);
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    @RequiresApi(api = 11)
    public void onSelfConfigurationChanged(Configuration configuration) {
        if (this.f11788f) {
            a(this.f11822p);
        }
        super.onSelfConfigurationChanged(configuration);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(b bVar) {
        super.preLoadData(bVar);
        setCloseVisible(0);
    }

    public void resizeMiniCard(int i2, int i3) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        View viewFindViewById = ((Activity) this.a).getWindow().findViewById(R.id.content);
        int width = viewFindViewById.getWidth();
        int height = viewFindViewById.getHeight();
        if (i2 <= 0 || i3 <= 0 || i2 > width || i3 > height) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f11822p.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.f11822p.setLayoutParams(layoutParams);
    }

    public void setAnythinkClickMiniCardViewClickable(boolean z2) {
        setClickable(z2);
    }

    public void setAnythinkClickMiniCardViewTransparent() {
        setBackgroundColor(0);
    }

    public void setMiniCardLocation(int i2, int i3, int i4, int i5) {
        this.B = true;
        resizeMiniCard(i4, i5);
    }

    public void setRadius(int i2) {
        if (i2 > 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(t.b(getContext(), i2));
            gradientDrawable.setColor(-1);
            if (Build.VERSION.SDK_INT >= 16) {
                this.f11825s.setBackground(gradientDrawable);
            } else {
                this.f11825s.setBackgroundDrawable(gradientDrawable);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.f11825s.setClipToOutline(true);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.h
    public void webviewshow() {
        WindVaneWebView windVaneWebView = this.f11825s;
        if (windVaneWebView != null) {
            windVaneWebView.post(new Runnable() { // from class: com.anythink.expressad.video.module.AnythinkClickMiniCardView.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        o.a(AnythinkBaseView.TAG, "webviewshow");
                        String string = "";
                        try {
                            int[] iArr = new int[2];
                            AnythinkClickMiniCardView.this.f11825s.getLocationOnScreen(iArr);
                            o.d(AnythinkBaseView.TAG, "coordinate:" + iArr[0] + "--" + iArr[1]);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("startX", t.a(n.a().g(), (float) iArr[0]));
                            jSONObject.put("startY", t.a(n.a().g(), (float) iArr[1]));
                            string = jSONObject.toString();
                        } catch (Throwable th) {
                            o.b(AnythinkBaseView.TAG, th.getMessage(), th);
                        }
                        String strEncodeToString = Base64.encodeToString(string.toString().getBytes(), 2);
                        j.a();
                        j.a((WebView) AnythinkClickMiniCardView.this.f11825s, "webviewshow", strEncodeToString);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }

    public AnythinkClickMiniCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
    }

    @RequiresApi(api = 11)
    private void a(View view) {
        int iF = t.f(this.a);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) ((iF * 0.7f) + 0.5f);
        layoutParams.height = (int) ((t.e(this.a) * 0.7f) + 0.5f);
        view.setLayoutParams(layoutParams);
    }
}
