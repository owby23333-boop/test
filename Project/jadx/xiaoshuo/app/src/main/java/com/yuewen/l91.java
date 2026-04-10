package com.yuewen;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class l91 extends n91 {
    public static final String w = "precision highp float;uniform mat4 u_VtxMatrix;attribute vec4 a_VtxCoord;attribute vec2 a_TexCoord;varying vec2 v_TexCoord;void main() {\tgl_Position = u_VtxMatrix * a_VtxCoord;\tv_TexCoord = a_TexCoord;}";
    public static final String x = "precision highp float;uniform sampler2D u_TexNum;uniform float u_Alpha;varying vec2 v_TexCoord;void main() {\tgl_FragColor = texture2D(u_TexNum, v_TexCoord) * u_Alpha;}";
    public static final int y = 30;
    public static final float z = 0.333f;
    public final Bitmap f;
    public int g;
    public FloatBuffer h;
    public FloatBuffer i;
    public ShortBuffer j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public final Bitmap s;
    public int t;
    public FloatBuffer u;
    public ShortBuffer v;

    public l91(Bitmap bitmap) {
        this(bitmap, null);
    }

    @Override // com.yuewen.n91
    public void b() {
        int i = this.m;
        if (i > 0) {
            GLES20.glDeleteProgram(i);
            this.m = 0;
            GLES20.glDeleteShader(this.k);
            this.k = 0;
            GLES20.glDeleteShader(this.l);
            this.l = 0;
        }
        int i2 = this.g;
        if (i2 > 0) {
            GLES20.glDeleteTextures(1, new int[]{i2}, 0);
            this.g = 0;
        }
        int i3 = this.t;
        if (i3 > 0) {
            GLES20.glDeleteTextures(1, new int[]{i3}, 0);
            this.t = 0;
        }
    }

    @Override // com.yuewen.n91
    public void c() {
        GLES20.glUseProgram(this.m);
        GLES20.glActiveTexture(33984);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        float[] fArrH = h();
        float[] fArrG = g();
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, 0, fArrH, 0, fArrG, 0);
        if (this.s != null) {
            FloatBuffer floatBufferB = m91.b(m(30.0f / Matrix.length(fArrG[0], fArrG[4], fArrG[8])));
            GLES20.glBindTexture(3553, this.t);
            GLES20.glUniformMatrix4fv(this.n, 1, false, fArr, 0);
            GLES20.glEnableVertexAttribArray(this.o);
            GLES20.glVertexAttribPointer(this.o, 2, 5126, false, 0, (Buffer) floatBufferB);
            GLES20.glEnableVertexAttribArray(this.p);
            GLES20.glVertexAttribPointer(this.p, 2, 5126, false, 0, (Buffer) this.u);
            GLES20.glUniform1f(this.r, f());
            GLES20.glUniform1i(this.q, 0);
            GLES20.glDrawElements(4, this.v.capacity(), 5123, this.v);
        }
        GLES20.glBindTexture(3553, this.g);
        GLES20.glUniformMatrix4fv(this.n, 1, false, fArr, 0);
        GLES20.glEnableVertexAttribArray(this.o);
        GLES20.glVertexAttribPointer(this.o, 3, 5126, false, 0, (Buffer) this.h);
        GLES20.glEnableVertexAttribArray(this.p);
        GLES20.glVertexAttribPointer(this.p, 2, 5126, false, 0, (Buffer) this.i);
        GLES20.glUniform1f(this.r, f());
        GLES20.glUniform1i(this.q, 0);
        GLES20.glDrawElements(4, this.j.capacity(), 5123, this.j);
        GLES20.glDisable(3042);
        GLES20.glDisableVertexAttribArray(this.o);
        GLES20.glDisableVertexAttribArray(this.p);
        GLES20.glUseProgram(0);
    }

    @Override // com.yuewen.n91
    public void d() {
        if (this.m == 0) {
            int iGlCreateShader = GLES20.glCreateShader(35633);
            this.k = iGlCreateShader;
            GLES20.glShaderSource(iGlCreateShader, w);
            GLES20.glCompileShader(this.k);
            int iGlCreateShader2 = GLES20.glCreateShader(35632);
            this.l = iGlCreateShader2;
            GLES20.glShaderSource(iGlCreateShader2, x);
            GLES20.glCompileShader(this.l);
            int iGlCreateProgram = GLES20.glCreateProgram();
            this.m = iGlCreateProgram;
            GLES20.glAttachShader(iGlCreateProgram, this.k);
            GLES20.glAttachShader(this.m, this.l);
            GLES20.glLinkProgram(this.m);
            GLES20.glPixelStorei(3317, 1);
            this.n = GLES20.glGetUniformLocation(this.m, "u_VtxMatrix");
            this.o = GLES20.glGetAttribLocation(this.m, "a_VtxCoord");
            this.p = GLES20.glGetAttribLocation(this.m, "a_TexCoord");
            this.q = GLES20.glGetUniformLocation(this.m, "u_TexNum");
            this.r = GLES20.glGetUniformLocation(this.m, "u_Alpha");
        }
        if (this.g == 0) {
            int iD = m91.d();
            this.g = iD;
            GLES20.glBindTexture(3553, iD);
            GLUtils.texImage2D(3553, 0, this.f, 0);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            this.h = m91.b(new float[]{(-this.f.getWidth()) / 2.0f, this.f.getHeight() / 2.0f, 0.0f, this.f.getWidth() / 2.0f, this.f.getHeight() / 2.0f, 0.0f, this.f.getWidth() / 2.0f, (-this.f.getHeight()) / 2.0f, 0.0f, (-this.f.getWidth()) / 2.0f, (-this.f.getHeight()) / 2.0f, 0.0f});
            this.i = m91.b(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
            this.j = m91.c(new short[]{0, 1, 2, 0, 2, 3});
        }
        if (this.s == null || this.t != 0) {
            return;
        }
        int iD2 = m91.d();
        this.t = iD2;
        GLES20.glBindTexture(3553, iD2);
        GLUtils.texImage2D(3553, 0, this.s, 0);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        float[] fArr = new float[32];
        m91.a(fArr, 0, 0.0f, 0.667f, 0.333f, 0.333f);
        m91.a(fArr, 8, 0.667f, 0.667f, 0.333f, 0.333f);
        m91.a(fArr, 16, 0.667f, 0.0f, 0.333f, 0.333f);
        m91.a(fArr, 24, 0.0f, 0.0f, 0.333f, 0.333f);
        this.u = m91.b(fArr);
        this.v = m91.c(new short[]{0, 1, 2, 0, 2, 3, 1, 4, 7, 1, 7, 2, 4, 5, 6, 4, 6, 7, 7, 6, 9, 7, 9, 8, 8, 9, 10, 8, 10, 11, 13, 8, 11, 13, 11, 14, 12, 13, 14, 12, 14, 15, 3, 2, 13, 3, 13, 12});
    }

    public final float[] m(float f) {
        float[] fArr = new float[32];
        m91.a(fArr, 0, ((-this.f.getWidth()) / 2.0f) - f, this.f.getHeight() / 2.0f, f, f);
        m91.a(fArr, 8, this.f.getWidth() / 2.0f, this.f.getHeight() / 2.0f, f, f);
        m91.a(fArr, 16, this.f.getWidth() / 2.0f, ((-this.f.getHeight()) / 2.0f) - f, f, f);
        m91.a(fArr, 24, ((-this.f.getWidth()) / 2.0f) - f, ((-this.f.getHeight()) / 2.0f) - f, f, f);
        return fArr;
    }

    public Bitmap n() {
        return this.f;
    }

    public Bitmap o() {
        return this.s;
    }

    public l91(Bitmap bitmap, Bitmap bitmap2) {
        this.g = 0;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = -1;
        this.o = -1;
        this.p = -1;
        this.q = -1;
        this.r = -1;
        this.t = 0;
        this.u = null;
        this.v = null;
        this.f = bitmap;
        this.s = bitmap2;
    }
}
