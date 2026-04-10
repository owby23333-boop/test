package fi.harism.curl;

import android.opengl.GLES20;
import android.util.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes8.dex */
public final class CurlShader {
    private int mProgram = -1;
    private final HashMap<String, Integer> mShaderHandleMap = new HashMap<>();

    private int loadShader(int i, String str) throws Exception {
        int iGlCreateShader = GLES20.glCreateShader(i);
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            GLES20.glCompileShader(iGlCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                String strGlGetShaderInfoLog = GLES20.glGetShaderInfoLog(iGlCreateShader);
                GLES20.glDeleteShader(iGlCreateShader);
                throw new Exception(strGlGetShaderInfoLog);
            }
        }
        return iGlCreateShader;
    }

    public int getHandle(String str) {
        if (this.mShaderHandleMap.containsKey(str)) {
            return this.mShaderHandleMap.get(str).intValue();
        }
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.mProgram, str);
        if (iGlGetAttribLocation == -1) {
            iGlGetAttribLocation = GLES20.glGetUniformLocation(this.mProgram, str);
        }
        if (iGlGetAttribLocation == -1) {
            Log.d("CurlShader", "Could not get attrib location for " + str);
        } else {
            this.mShaderHandleMap.put(str, Integer.valueOf(iGlGetAttribLocation));
        }
        return iGlGetAttribLocation;
    }

    public int[] getHandles(String... strArr) {
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = getHandle(strArr[i]);
        }
        return iArr;
    }

    public void setProgram(String str, String str2) throws Exception {
        int iLoadShader = loadShader(35633, str);
        int iLoadShader2 = loadShader(35632, str2);
        int iGlCreateProgram = GLES20.glCreateProgram();
        if (iGlCreateProgram != 0) {
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader);
            GLES20.glAttachShader(iGlCreateProgram, iLoadShader2);
            GLES20.glLinkProgram(iGlCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String strGlGetProgramInfoLog = GLES20.glGetProgramInfoLog(iGlCreateProgram);
                GLES20.glDeleteProgram(iGlCreateProgram);
                throw new Exception(strGlGetProgramInfoLog);
            }
        }
        this.mProgram = iGlCreateProgram;
        this.mShaderHandleMap.clear();
    }

    public void useProgram() {
        GLES20.glUseProgram(this.mProgram);
    }
}
