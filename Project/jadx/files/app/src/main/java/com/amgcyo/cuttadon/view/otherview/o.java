package com.amgcyo.cuttadon.view.otherview;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;
import com.amgcyo.cuttadon.utils.otherutils.r0;

/* JADX INFO: compiled from: WebLinkMethod.java */
/* JADX INFO: loaded from: classes.dex */
public class o extends LinkMovementMethod {
    private Context a;
    private boolean b;

    public o(Context context, boolean z2) {
        this.a = context;
        this.b = z2;
    }

    @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1 || action == 0) {
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            int totalPaddingLeft = x2 - textView.getTotalPaddingLeft();
            int totalPaddingTop = y2 - textView.getTotalPaddingTop();
            int scrollX = totalPaddingLeft + textView.getScrollX();
            int scrollY = totalPaddingTop + textView.getScrollY();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
            URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, URLSpan.class);
            if (uRLSpanArr.length != 0) {
                if (action == 1) {
                    String url = uRLSpanArr[0].getURL();
                    if (this.b) {
                        Toast.makeText(this.a, "正在使用手机默认浏览器打开", 0).show();
                        com.amgcyo.cuttadon.view.webview.b.startActivity(this.a, url);
                    } else {
                        r0.a(this.a, url);
                    }
                } else {
                    Selection.setSelection(spannable, spannable.getSpanStart(uRLSpanArr[0]), spannable.getSpanEnd(uRLSpanArr[0]));
                }
                return true;
            }
            Selection.removeSelection(spannable);
        }
        return super.onTouchEvent(textView, spannable, motionEvent);
    }
}
