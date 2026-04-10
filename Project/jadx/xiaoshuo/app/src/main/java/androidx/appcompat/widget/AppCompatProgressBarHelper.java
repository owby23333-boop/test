package androidx.appcompat.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.core.graphics.drawable.WrappedDrawable;

/* JADX INFO: loaded from: classes.dex */
class AppCompatProgressBarHelper {
    private static final int[] TINT_ATTRS = {R.attr.indeterminateDrawable, R.attr.progressDrawable};
    private Bitmap mSampleTile;
    private final ProgressBar mView;

    public AppCompatProgressBarHelper(ProgressBar progressBar) {
        this.mView = progressBar;
    }

    private Shape getDrawableShape() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Drawable tileify(Drawable drawable2, boolean z) {
        if (drawable2 instanceof WrappedDrawable) {
            WrappedDrawable wrappedDrawable = (WrappedDrawable) drawable2;
            Drawable wrappedDrawable2 = wrappedDrawable.getWrappedDrawable();
            if (wrappedDrawable2 != null) {
                wrappedDrawable.setWrappedDrawable(tileify(wrappedDrawable2, z));
            }
        } else {
            if (drawable2 instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable2;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i = 0; i < numberOfLayers; i++) {
                    int id = layerDrawable.getId(i);
                    drawableArr[i] = tileify(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    layerDrawable2.setId(i2, layerDrawable.getId(i2));
                }
                return layerDrawable2;
            }
            if (drawable2 instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable2;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (this.mSampleTile == null) {
                    this.mSampleTile = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(getDrawableShape());
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable2;
    }

    private Drawable tileifyIndeterminate(Drawable drawable2) {
        if (!(drawable2 instanceof AnimationDrawable)) {
            return drawable2;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable2;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableTileify = tileify(animationDrawable.getFrame(i), true);
            drawableTileify.setLevel(10000);
            animationDrawable2.addFrame(drawableTileify, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    public Bitmap getSampleTile() {
        return this.mSampleTile;
    }

    public void loadFromAttributes(AttributeSet attributeSet, int i) {
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), attributeSet, TINT_ATTRS, i, 0);
        Drawable drawableIfKnown = tintTypedArrayObtainStyledAttributes.getDrawableIfKnown(0);
        if (drawableIfKnown != null) {
            this.mView.setIndeterminateDrawable(tileifyIndeterminate(drawableIfKnown));
        }
        Drawable drawableIfKnown2 = tintTypedArrayObtainStyledAttributes.getDrawableIfKnown(1);
        if (drawableIfKnown2 != null) {
            this.mView.setProgressDrawable(tileify(drawableIfKnown2, false));
        }
        tintTypedArrayObtainStyledAttributes.recycle();
    }
}
