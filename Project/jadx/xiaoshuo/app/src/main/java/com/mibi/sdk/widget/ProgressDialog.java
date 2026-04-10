package com.mibi.sdk.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes17.dex */
public class ProgressDialog extends android.app.AlertDialog {
    public static final int STYLE_HORIZONTAL = 1;
    public static final int STYLE_SPINNER = 0;
    private boolean mHasStarted;
    private int mIncrementBy;
    private int mIncrementSecondaryBy;
    private boolean mIndeterminate;
    private Drawable mIndeterminateDrawable;
    private int mMax;
    private CharSequence mMessage;
    private TextView mMessageView;
    private ProgressBar mProgress;
    private Drawable mProgressDrawable;
    private String mProgressNumberFormat;
    private NumberFormat mProgressPercentFormat;
    private int mProgressStyle;
    private int mProgressVal;
    private int mSecondaryProgressVal;
    private Handler mViewUpdateHandler;

    public ProgressDialog(Context context) {
        super(context);
        this.mProgressStyle = 0;
        initFormats();
    }

    private void initFormats() {
        getWindow().setGravity(80);
        this.mProgressNumberFormat = "%1d/%2d";
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        this.mProgressPercentFormat = percentInstance;
        percentInstance.setMaximumFractionDigits(0);
    }

    private void onProgressChanged() {
        Handler handler;
        if (this.mProgressStyle != 1 || (handler = this.mViewUpdateHandler) == null || handler.hasMessages(0)) {
            return;
        }
        this.mViewUpdateHandler.sendEmptyMessage(0);
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2) {
        return show(context, charSequence, charSequence2, false);
    }

    public int getMax() {
        ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.getMax() : this.mMax;
    }

    public int getProgress() {
        ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.getProgress() : this.mProgressVal;
    }

    public int getSecondaryProgress() {
        ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.getSecondaryProgress() : this.mSecondaryProgressVal;
    }

    public void incrementProgressBy(int i) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mIncrementBy += i;
        } else {
            progressBar.incrementProgressBy(i);
            onProgressChanged();
        }
    }

    public void incrementSecondaryProgressBy(int i) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mIncrementSecondaryBy += i;
        } else {
            progressBar.incrementSecondaryProgressBy(i);
            onProgressChanged();
        }
    }

    public boolean isIndeterminate() {
        ProgressBar progressBar = this.mProgress;
        return progressBar != null ? progressBar.isIndeterminate() : this.mIndeterminate;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        View viewInflate;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.AlertDialog, android.R.attr.alertDialogStyle, 0);
        if (this.mProgressStyle == 1) {
            this.mViewUpdateHandler = new Handler() { // from class: com.mibi.sdk.widget.ProgressDialog.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    int length;
                    super.handleMessage(message);
                    int progress = ProgressDialog.this.mProgress.getProgress();
                    int max = ProgressDialog.this.mProgress.getMax();
                    if (ProgressDialog.this.mProgressPercentFormat != null) {
                        double d = ((double) progress) / ((double) max);
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                        if (TextUtils.isEmpty(ProgressDialog.this.mMessage)) {
                            length = 0;
                        } else {
                            length = ProgressDialog.this.mMessage.length();
                            spannableStringBuilder.append(ProgressDialog.this.mMessage);
                        }
                        String str = ProgressDialog.this.mProgressPercentFormat.format(d);
                        spannableStringBuilder.append((CharSequence) str);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(ProgressDialog.this.getContext().getResources().getColor(R.color.mipay_progress_dialog_progress_percent_color)), length, str.length() + length, 34);
                        ProgressDialog.this.mMessageView.setText(spannableStringBuilder);
                    }
                }
            };
            viewInflate = layoutInflaterFrom.inflate(typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_horizontalProgressLayout, R.layout.mipay_alert_dialog_progress), (ViewGroup) null);
        } else {
            viewInflate = layoutInflaterFrom.inflate(typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_progressLayout, R.layout.mipay_progress_dialog), (ViewGroup) null);
        }
        this.mProgress = (ProgressBar) viewInflate.findViewById(android.R.id.progress);
        this.mMessageView = (TextView) viewInflate.findViewById(R.id.message);
        setView(viewInflate);
        typedArrayObtainStyledAttributes.recycle();
        int i = this.mMax;
        if (i > 0) {
            setMax(i);
        }
        int i2 = this.mProgressVal;
        if (i2 > 0) {
            setProgress(i2);
        }
        int i3 = this.mSecondaryProgressVal;
        if (i3 > 0) {
            setSecondaryProgress(i3);
        }
        int i4 = this.mIncrementBy;
        if (i4 > 0) {
            incrementProgressBy(i4);
        }
        int i5 = this.mIncrementSecondaryBy;
        if (i5 > 0) {
            incrementSecondaryProgressBy(i5);
        }
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != null) {
            setProgressDrawable(drawable2);
        }
        Drawable drawable3 = this.mIndeterminateDrawable;
        if (drawable3 != null) {
            setIndeterminateDrawable(drawable3);
        }
        CharSequence charSequence = this.mMessage;
        if (charSequence != null) {
            setMessage(charSequence);
        }
        setIndeterminate(this.mIndeterminate);
        onProgressChanged();
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        this.mHasStarted = true;
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        this.mHasStarted = false;
    }

    public void setIndeterminate(boolean z) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setIndeterminate(z);
        } else {
            this.mIndeterminate = z;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable2) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setIndeterminateDrawable(drawable2);
        } else {
            this.mIndeterminateDrawable = drawable2;
        }
    }

    public void setMax(int i) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mMax = i;
        } else {
            progressBar.setMax(i);
            onProgressChanged();
        }
    }

    @Override // android.app.AlertDialog
    public void setMessage(CharSequence charSequence) {
        if (this.mProgress == null) {
            this.mMessage = charSequence;
            return;
        }
        if (this.mProgressStyle == 1) {
            this.mMessage = charSequence;
        }
        this.mMessageView.setText(charSequence);
    }

    public void setProgress(int i) {
        if (!this.mHasStarted) {
            this.mProgressVal = i;
        } else {
            this.mProgress.setProgress(i);
            onProgressChanged();
        }
    }

    public void setProgressDrawable(Drawable drawable2) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar != null) {
            progressBar.setProgressDrawable(drawable2);
        } else {
            this.mProgressDrawable = drawable2;
        }
    }

    public void setProgressNumberFormat(String str) {
        this.mProgressNumberFormat = str;
        onProgressChanged();
    }

    public void setProgressPercentFormat(NumberFormat numberFormat) {
        this.mProgressPercentFormat = numberFormat;
        onProgressChanged();
    }

    public void setProgressStyle(int i) {
        this.mProgressStyle = i;
    }

    public void setSecondaryProgress(int i) {
        ProgressBar progressBar = this.mProgress;
        if (progressBar == null) {
            this.mSecondaryProgressVal = i;
        } else {
            progressBar.setSecondaryProgress(i);
            onProgressChanged();
        }
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        return show(context, charSequence, charSequence2, z, false, null);
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2) {
        return show(context, charSequence, charSequence2, z, z2, null);
    }

    public ProgressDialog(Context context, int i) {
        super(context, i);
        this.mProgressStyle = 0;
        initFormats();
    }

    public static ProgressDialog show(Context context, CharSequence charSequence, CharSequence charSequence2, boolean z, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle(charSequence);
        progressDialog.setMessage(charSequence2);
        progressDialog.setIndeterminate(z);
        progressDialog.setCancelable(z2);
        progressDialog.setOnCancelListener(onCancelListener);
        progressDialog.show();
        return progressDialog;
    }
}
