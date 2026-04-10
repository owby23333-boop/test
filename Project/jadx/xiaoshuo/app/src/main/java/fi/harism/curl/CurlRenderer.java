package fi.harism.curl;

import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes8.dex */
public class CurlRenderer implements GLSurfaceView.Renderer {
    public static final int PAGE_LEFT = 1;
    public static final int PAGE_RIGHT = 2;
    public static final int SHOW_ONE_PAGE_LEFT = 0;
    public static final int SHOW_ONE_PAGE_RIGHT = 1;
    public static final int SHOW_TWO_PAGES = 2;
    private Observer mObserver;
    private int mViewportHeight;
    private int mViewportWidth;
    private int mBackgroundColor = -16777216;
    private RectF mMargins = new RectF();
    private final float[] mProjectionMatrix = new float[16];
    private final CurlShader mShaderShadow = new CurlShader();
    private final CurlShader mShaderTexture = new CurlShader();
    private int mViewMode = 1;
    private final RectF mViewRect = new RectF();
    private long mMaxDrawIndex = 0;
    private HashMap<CurlMesh, Long> mCurlMeshIndexs = new HashMap<>();
    private final RectF mPageRectLeft = new RectF();
    private final RectF mPageRectRight = new RectF();

    public interface Observer {
        void afterDrawFrame();

        void onDrawFrame();

        void onPageSizeChanged(int i, int i2);

        void onSurfaceChanged();

        void onSurfaceCreated();
    }

    public CurlRenderer(Observer observer) {
        this.mObserver = observer;
    }

    private void updatePageRects() {
        if (this.mViewRect.width() == 0.0f || this.mViewRect.height() == 0.0f) {
            return;
        }
        int i = this.mViewMode;
        if (i == 0) {
            this.mPageRectLeft.set(this.mViewRect);
            this.mPageRectLeft.left += this.mViewRect.width() * this.mMargins.left;
            this.mPageRectLeft.right -= this.mViewRect.width() * this.mMargins.right;
            this.mPageRectLeft.top += this.mViewRect.height() * this.mMargins.top;
            this.mPageRectLeft.bottom -= this.mViewRect.height() * this.mMargins.bottom;
            this.mPageRectRight.set(this.mPageRectLeft);
            this.mPageRectRight.offset(this.mPageRectLeft.width(), 0.0f);
            this.mObserver.onPageSizeChanged((int) ((this.mPageRectLeft.width() * this.mViewportWidth) / this.mViewRect.width()), (int) ((this.mPageRectLeft.height() * this.mViewportHeight) / this.mViewRect.height()));
            return;
        }
        if (i == 1) {
            this.mPageRectRight.set(this.mViewRect);
            this.mPageRectRight.left += this.mViewRect.width() * this.mMargins.left;
            this.mPageRectRight.right -= this.mViewRect.width() * this.mMargins.right;
            this.mPageRectRight.top += this.mViewRect.height() * this.mMargins.top;
            this.mPageRectRight.bottom -= this.mViewRect.height() * this.mMargins.bottom;
            this.mPageRectLeft.set(this.mPageRectRight);
            this.mPageRectLeft.offset(-this.mPageRectRight.width(), 0.0f);
            this.mObserver.onPageSizeChanged((int) ((this.mPageRectRight.width() * this.mViewportWidth) / this.mViewRect.width()), (int) ((this.mPageRectRight.height() * this.mViewportHeight) / this.mViewRect.height()));
            return;
        }
        if (i == 2) {
            this.mPageRectRight.set(this.mViewRect);
            this.mPageRectRight.left += this.mViewRect.width() * this.mMargins.left;
            this.mPageRectRight.right -= this.mViewRect.width() * this.mMargins.right;
            this.mPageRectRight.top += this.mViewRect.height() * this.mMargins.top;
            this.mPageRectRight.bottom -= this.mViewRect.height() * this.mMargins.bottom;
            this.mPageRectLeft.set(this.mPageRectRight);
            RectF rectF = this.mPageRectLeft;
            float f = (rectF.right + rectF.left) / 2.0f;
            rectF.right = f;
            RectF rectF2 = this.mPageRectRight;
            rectF2.left = f;
            this.mObserver.onPageSizeChanged((int) ((rectF2.width() * this.mViewportWidth) / this.mViewRect.width()), (int) ((this.mPageRectRight.height() * this.mViewportHeight) / this.mViewRect.height()));
        }
    }

    public void addCurlMesh(CurlMesh curlMesh) {
        HashMap<CurlMesh, Long> map = this.mCurlMeshIndexs;
        long j = this.mMaxDrawIndex + 1;
        this.mMaxDrawIndex = j;
        map.put(curlMesh, Long.valueOf(j));
    }

    public void destroyCurlMesh(CurlMesh curlMesh) {
        this.mCurlMeshIndexs.remove(curlMesh);
    }

    public RectF getPageRect(int i) {
        if (i == 1) {
            return this.mPageRectLeft;
        }
        if (i == 2) {
            return this.mPageRectRight;
        }
        return null;
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        this.mObserver.onDrawFrame();
        if (this.mCurlMeshIndexs.isEmpty()) {
            return;
        }
        GLES20.glClearColor(Color.red(this.mBackgroundColor) / 255.0f, Color.green(this.mBackgroundColor) / 255.0f, Color.blue(this.mBackgroundColor) / 255.0f, Color.alpha(this.mBackgroundColor) / 255.0f);
        GLES20.glClear(16384);
        ArrayList<Map.Entry> arrayList = new ArrayList(this.mCurlMeshIndexs.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<CurlMesh, Long>>() { // from class: fi.harism.curl.CurlRenderer.1
            @Override // java.util.Comparator
            public int compare(Map.Entry<CurlMesh, Long> entry, Map.Entry<CurlMesh, Long> entry2) {
                if (entry.getValue().longValue() > entry2.getValue().longValue()) {
                    return 1;
                }
                return entry.getValue() == entry2.getValue() ? 0 : -1;
            }
        });
        boolean z = false;
        for (Map.Entry entry : arrayList) {
            CurlMesh curlMesh = (CurlMesh) entry.getKey();
            if (((Long) entry.getValue()).longValue() >= 0) {
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                this.mShaderShadow.useProgram();
                GLES20.glVertexAttribPointer(this.mShaderShadow.getHandle("aPosition"), 3, 5126, false, 0, (Buffer) curlMesh.getShadowVertices());
                GLES20.glEnableVertexAttribArray(this.mShaderShadow.getHandle("aPosition"));
                GLES20.glVertexAttribPointer(this.mShaderShadow.getHandle("aPenumbra"), 3, 5126, false, 0, (Buffer) curlMesh.getShadowPenumbra());
                GLES20.glEnableVertexAttribArray(this.mShaderShadow.getHandle("aPenumbra"));
                GLES20.glDrawArrays(5, 0, curlMesh.getDropShadowCount());
                GLES20.glDisable(3042);
                this.mShaderTexture.useProgram();
                GLES20.glVertexAttribPointer(this.mShaderTexture.getHandle("aPosition"), 3, 5126, false, 0, (Buffer) curlMesh.getVertices());
                GLES20.glEnableVertexAttribArray(this.mShaderTexture.getHandle("aPosition"));
                GLES20.glVertexAttribPointer(this.mShaderTexture.getHandle("aNormal"), 3, 5126, false, 0, (Buffer) curlMesh.getNormals());
                GLES20.glEnableVertexAttribArray(this.mShaderTexture.getHandle("aNormal"));
                GLES20.glVertexAttribPointer(this.mShaderTexture.getHandle("aTexCoord"), 2, 5126, false, 0, (Buffer) curlMesh.getTexCoords());
                GLES20.glEnableVertexAttribArray(this.mShaderTexture.getHandle("aTexCoord"));
                CurlPage page = curlMesh.getPage();
                GLES20.glUniform4f(this.mShaderTexture.getHandle("uColorScale"), page.getColorScaleR(), page.getColorScaleG(), page.getColorScaleB(), 1.0f);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, curlMesh.getTextures()[0]);
                GLES20.glUniform1i(this.mShaderTexture.getHandle("sTextureFront"), 0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, curlMesh.getTextures()[1]);
                GLES20.glUniform1i(this.mShaderTexture.getHandle("sTextureBack"), 1);
                GLES20.glActiveTexture(33986);
                GLES20.glBindTexture(3553, curlMesh.getTextures()[2]);
                GLES20.glUniform1i(this.mShaderTexture.getHandle("sTextureBack2"), 2);
                GLES20.glUniform1i(this.mShaderTexture.getHandle("sBackReverse"), curlMesh.getBackReverse());
                GLES20.glDrawArrays(5, 0, curlMesh.getVertexCount());
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                this.mShaderShadow.useProgram();
                GLES20.glVertexAttribPointer(this.mShaderShadow.getHandle("aPosition"), 3, 5126, false, 0, (Buffer) curlMesh.getShadowVertices());
                GLES20.glEnableVertexAttribArray(this.mShaderShadow.getHandle("aPosition"));
                GLES20.glVertexAttribPointer(this.mShaderShadow.getHandle("aPenumbra"), 3, 5126, false, 0, (Buffer) curlMesh.getShadowPenumbra());
                GLES20.glEnableVertexAttribArray(this.mShaderShadow.getHandle("aPenumbra"));
                GLES20.glDrawArrays(5, curlMesh.getDropShadowCount(), curlMesh.getSelfShadowCount());
                GLES20.glDisable(3042);
                z = true;
            }
        }
        if (z) {
            this.mObserver.afterDrawFrame();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.mViewportWidth = i;
        this.mViewportHeight = i2;
        float f = i / i2;
        RectF rectF = this.mViewRect;
        rectF.top = 1.0f;
        rectF.bottom = -1.0f;
        float f2 = -f;
        rectF.left = f2;
        rectF.right = f;
        updatePageRects();
        Matrix.orthoM(this.mProjectionMatrix, 0, f2, f, -1.0f, 1.0f, -10.0f, 10.0f);
        this.mShaderTexture.useProgram();
        GLES20.glUniformMatrix4fv(this.mShaderTexture.getHandle("uProjectionM"), 1, false, this.mProjectionMatrix, 0);
        this.mShaderShadow.useProgram();
        GLES20.glUniformMatrix4fv(this.mShaderShadow.getHandle("uProjectionM"), 1, false, this.mProjectionMatrix, 0);
        GLES20.glDisable(2929);
        GLES20.glDisable(2884);
        this.mObserver.onSurfaceChanged();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        try {
            this.mShaderShadow.setProgram(CurlStatic.SHADER_SHADOW_VERTEX, CurlStatic.SHADER_SHADOW_FRAGMENT);
            this.mShaderTexture.setProgram(CurlStatic.SHADER_TEXTURE_VERTEX, CurlStatic.SHADER_TEXTURE_FRAGMENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mObserver.onSurfaceCreated();
    }

    public void removeCurlMesh(CurlMesh curlMesh) {
        this.mCurlMeshIndexs.put(curlMesh, -1L);
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setMargins(float f, float f2, float f3, float f4) {
        RectF rectF = this.mMargins;
        rectF.left = f;
        rectF.top = f2;
        rectF.right = f3;
        rectF.bottom = f4;
        updatePageRects();
    }

    public void setViewMode(int i) {
        if (i == 0) {
            this.mViewMode = i;
            updatePageRects();
        } else if (i == 1) {
            this.mViewMode = i;
            updatePageRects();
        } else if (i == 2) {
            this.mViewMode = i;
            updatePageRects();
        }
    }

    public void translate(PointF pointF) {
        RectF rectF = this.mViewRect;
        pointF.x = rectF.left + ((rectF.width() * pointF.x) / this.mViewportWidth);
        RectF rectF2 = this.mViewRect;
        pointF.y = rectF2.top - (((-rectF2.height()) * pointF.y) / this.mViewportHeight);
    }
}
