package com.qmuiteam.qmui.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.alpha.QMUIAlphaTextView;
import com.qmuiteam.qmui.link.QMUILinkTouchMovementMethod;
import com.qmuiteam.qmui.link.QMUILinkify;
import com.qmuiteam.qmui.span.QMUIOnSpanClickListener;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class QMUILinkTextView extends QMUIAlphaTextView implements QMUIOnSpanClickListener {
    public static int AUTO_LINK_MASK_REQUIRED = 7;
    private static Set<String> AUTO_LINK_SCHEME_INTERRUPTED = null;
    private static final long DOUBLE_TAP_TIMEOUT;
    private static final int MSG_CHECK_DOUBLE_TAP_TIMEOUT = 1000;
    private static final String TAG = "LinkTextView";
    private static final long TAP_TIMEOUT = 200;
    private int mAutoLinkMaskCompat;
    private long mDownMillis;
    private ColorStateList mLinkBgColor;
    private ColorStateList mLinkTextColor;
    private OnLinkClickListener mOnLinkClickListener;
    private OnLinkLongClickListener mOnLinkLongClickListener;
    private CharSequence mOriginText;
    private Handler mSingleTapConfirmedHandler;

    /* JADX INFO: loaded from: classes4.dex */
    public interface OnLinkClickListener {
        void onMailLinkClick(String str);

        void onTelLinkClick(String str);

        void onWebUrlLinkClick(String str);
    }

    /* JADX INFO: loaded from: classes4.dex */
    public interface OnLinkLongClickListener {
        void onLongClick(String str);
    }

    static {
        HashSet hashSet = new HashSet();
        AUTO_LINK_SCHEME_INTERRUPTED = hashSet;
        hashSet.add("tel");
        AUTO_LINK_SCHEME_INTERRUPTED.add("mailto");
        AUTO_LINK_SCHEME_INTERRUPTED.add("http");
        AUTO_LINK_SCHEME_INTERRUPTED.add("https");
        DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    }

    public QMUILinkTextView(Context context) {
        this(context, null);
        this.mLinkBgColor = null;
        this.mLinkTextColor = ContextCompat.getColorStateList(context, R.color.qmui_s_link_color);
    }

    public QMUILinkTextView(Context context, ColorStateList colorStateList, ColorStateList colorStateList2) {
        this(context, null);
        this.mLinkBgColor = colorStateList2;
        this.mLinkTextColor = colorStateList;
    }

    public QMUILinkTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mOriginText = null;
        this.mDownMillis = 0L;
        this.mSingleTapConfirmedHandler = new Handler(Looper.getMainLooper()) { // from class: com.qmuiteam.qmui.widget.textview.QMUILinkTextView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (1000 != message.what) {
                    return;
                }
                Log.d(QMUILinkTextView.TAG, "handleMessage: " + message.obj);
                if (message.obj instanceof String) {
                    String str = (String) message.obj;
                    if (QMUILinkTextView.this.mOnLinkClickListener == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    String lowerCase = str.toLowerCase();
                    if (lowerCase.startsWith("tel:")) {
                        QMUILinkTextView.this.mOnLinkClickListener.onTelLinkClick(Uri.parse(str).getSchemeSpecificPart());
                    } else if (lowerCase.startsWith(MailTo.MAILTO_SCHEME)) {
                        QMUILinkTextView.this.mOnLinkClickListener.onMailLinkClick(Uri.parse(str).getSchemeSpecificPart());
                    } else if (lowerCase.startsWith("http") || lowerCase.startsWith("https")) {
                        QMUILinkTextView.this.mOnLinkClickListener.onWebUrlLinkClick(str);
                    }
                }
            }
        };
        this.mAutoLinkMaskCompat = getAutoLinkMask() | AUTO_LINK_MASK_REQUIRED;
        setAutoLinkMask(0);
        setMovementMethodCompat(QMUILinkTouchMovementMethod.getInstance());
        setHighlightColor(0);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.QMUILinkTextView);
        this.mLinkBgColor = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUILinkTextView_qmui_linkBackgroundColor);
        this.mLinkTextColor = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.QMUILinkTextView_qmui_linkTextColor);
        typedArrayObtainStyledAttributes.recycle();
        CharSequence charSequence = this.mOriginText;
        if (charSequence != null) {
            setText(charSequence);
        }
        setChangeAlphaWhenPress(false);
    }

    public void setOnLinkClickListener(OnLinkClickListener onLinkClickListener) {
        this.mOnLinkClickListener = onLinkClickListener;
    }

    public void setOnLinkLongClickListener(OnLinkLongClickListener onLinkLongClickListener) {
        this.mOnLinkLongClickListener = onLinkLongClickListener;
    }

    public int getAutoLinkMaskCompat() {
        return this.mAutoLinkMaskCompat;
    }

    public void setAutoLinkMaskCompat(int i) {
        this.mAutoLinkMaskCompat = i;
    }

    public void addAutoLinkMaskCompat(int i) {
        this.mAutoLinkMaskCompat = i | this.mAutoLinkMaskCompat;
    }

    public void removeAutoLinkMaskCompat(int i) {
        this.mAutoLinkMaskCompat = (~i) & this.mAutoLinkMaskCompat;
    }

    public void setLinkColor(ColorStateList colorStateList) {
        this.mLinkTextColor = colorStateList;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.mOriginText = charSequence;
        if (!TextUtils.isEmpty(charSequence)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
            QMUILinkify.addLinks(spannableStringBuilder, this.mAutoLinkMaskCompat, this.mLinkTextColor, this.mLinkBgColor, this);
            charSequence = spannableStringBuilder;
        }
        super.setText(charSequence, bufferType);
    }

    @Override // com.qmuiteam.qmui.span.QMUIOnSpanClickListener
    public boolean onSpanClick(String str) {
        if (str == null) {
            Log.w(TAG, "onSpanClick interrupt null text");
            return true;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.mDownMillis;
        Log.w(TAG, "onSpanClick clickUpTime: " + jUptimeMillis);
        if (this.mSingleTapConfirmedHandler.hasMessages(1000)) {
            disallowOnSpanClickInterrupt();
            return true;
        }
        if (TAP_TIMEOUT < jUptimeMillis) {
            Log.w(TAG, "onSpanClick interrupted because of TAP_TIMEOUT: " + jUptimeMillis);
            return true;
        }
        String scheme = Uri.parse(str).getScheme();
        if (scheme != null) {
            scheme = scheme.toLowerCase();
        }
        if (!AUTO_LINK_SCHEME_INTERRUPTED.contains(scheme)) {
            return false;
        }
        long j = DOUBLE_TAP_TIMEOUT - jUptimeMillis;
        this.mSingleTapConfirmedHandler.removeMessages(1000);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1000;
        messageObtain.obj = str;
        this.mSingleTapConfirmedHandler.sendMessageDelayed(messageObtain, j);
        return true;
    }

    @Override // com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView, android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            boolean zHasMessages = this.mSingleTapConfirmedHandler.hasMessages(1000);
            Log.w(TAG, "onTouchEvent hasSingleTap: " + zHasMessages);
            if (!zHasMessages) {
                this.mDownMillis = SystemClock.uptimeMillis();
            } else {
                Log.w(TAG, "onTouchEvent disallow onSpanClick mSingleTapConfirmedHandler because of DOUBLE TAP");
                disallowOnSpanClickInterrupt();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void disallowOnSpanClickInterrupt() {
        this.mSingleTapConfirmedHandler.removeMessages(1000);
        this.mDownMillis = 0L;
    }

    protected boolean performSpanLongClick(String str) {
        OnLinkLongClickListener onLinkLongClickListener = this.mOnLinkLongClickListener;
        if (onLinkLongClickListener == null) {
            return false;
        }
        onLinkLongClickListener.onLongClick(str);
        return true;
    }

    @Override // com.qmuiteam.qmui.widget.textview.QMUISpanTouchFixTextView, android.widget.TextView, android.view.View
    public boolean performLongClick() {
        int selectionEnd = getSelectionEnd();
        if (selectionEnd > 0) {
            return performSpanLongClick(getText().subSequence(getSelectionStart(), selectionEnd).toString()) || super.performLongClick();
        }
        return super.performLongClick();
    }
}
