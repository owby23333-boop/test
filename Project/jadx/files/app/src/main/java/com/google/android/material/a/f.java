package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: ImageMatrixProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {
    private final Matrix a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.a = new Matrix();
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(@NonNull ImageView imageView, @NonNull Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(@NonNull ImageView imageView) {
        this.a.set(imageView.getImageMatrix());
        return this.a;
    }
}
