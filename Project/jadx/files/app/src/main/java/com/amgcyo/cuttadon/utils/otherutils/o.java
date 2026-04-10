package com.amgcyo.cuttadon.utils.otherutils;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.fatcatfat.io.R;
import java.util.Locale;

/* JADX INFO: compiled from: CountDownTimerUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends CountDownTimer {
    private TextView a;

    public o(TextView textView, long j2, long j3) {
        super(j2, j3);
        this.a = textView;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        this.a.setText("重新获取验证码");
        this.a.setEnabled(true);
        this.a.setClickable(true);
        this.a.setTextColor(com.amgcyo.cuttadon.f.o.b(R.color.colorPrimary));
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j2) {
        this.a.setClickable(false);
        this.a.setText(String.format(Locale.getDefault(), "%d秒后可重新发送", Long.valueOf(j2 / 1000)));
        this.a.setTextColor(Color.parseColor("#dddddd"));
        SpannableString spannableString = new SpannableString(this.a.getText().toString());
        spannableString.setSpan(new ForegroundColorSpan(SupportMenu.CATEGORY_MASK), 0, 2, 17);
        this.a.setText(spannableString);
    }
}
