package fi.harism.curl;

import android.graphics.PointF;
import android.graphics.RectF;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.yuewen.w51;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes8.dex */
public class CurlMesh {
    private Array<Vertex> mArrIntersections;
    private Array<Vertex> mArrOutputVertices;
    private Array<Vertex> mArrRotatedVertices;
    private Array<Double> mArrScanLines;
    private Array<ShadowVertex> mArrShadowDropVertices;
    private Array<ShadowVertex> mArrShadowSelfVertices;
    private Array<ShadowVertex> mArrShadowTempVertices;
    private Array<Vertex> mArrTempVertices;
    private FloatBuffer mBufNormals;
    private FloatBuffer mBufShadowPenumbra;
    private FloatBuffer mBufShadowVertices;
    private FloatBuffer mBufTexCoords;
    private FloatBuffer mBufVertices;
    private int mCountShadowDrop;
    private int mCountShadowSelf;
    private int mCountVertices;
    private int mMaxCurlSplits;
    private final CurlPage mPage = new CurlPage();
    private final Vertex[] mRectangle = new Vertex[4];
    private int[] mTextureIds = null;
    private int mBackReverse = 0;

    public class ShadowVertex {
        public double mPenumbraA;
        public double mPenumbraX;
        public double mPenumbraY;
        public double mPosX;
        public double mPosY;
        public double mPosZ;

        private ShadowVertex() {
        }
    }

    public class Vertex {
        public double mPenumbraX;
        public double mPenumbraY;
        public double mNormalY = w51.l;
        public double mNormalX = w51.l;
        public double mNormalZ = 1.0d;
        public double mTexY = w51.l;
        public double mTexX = w51.l;
        public double mPosZ = w51.l;
        public double mPosY = w51.l;
        public double mPosX = w51.l;

        public Vertex() {
        }

        public void rotateZ(double d) {
            double dCos = Math.cos(d);
            double dSin = Math.sin(d);
            double d2 = this.mPosX;
            double d3 = this.mPosY;
            double d4 = -dSin;
            this.mPosX = (d2 * dCos) + (d3 * dSin);
            this.mPosY = (d2 * d4) + (d3 * dCos);
            double d5 = this.mNormalX;
            double d6 = this.mNormalY;
            this.mNormalX = (d5 * dCos) + (d6 * dSin);
            this.mNormalY = (d5 * d4) + (d6 * dCos);
            double d7 = this.mPenumbraX;
            double d8 = this.mPenumbraY;
            this.mPenumbraX = (d7 * dCos) + (dSin * d8);
            this.mPenumbraY = (d7 * d4) + (d8 * dCos);
        }

        public void set(Vertex vertex) {
            this.mPosX = vertex.mPosX;
            this.mPosY = vertex.mPosY;
            this.mPosZ = vertex.mPosZ;
            this.mTexX = vertex.mTexX;
            this.mTexY = vertex.mTexY;
            this.mNormalX = vertex.mNormalX;
            this.mNormalY = vertex.mNormalY;
            this.mNormalZ = vertex.mNormalZ;
            this.mPenumbraX = vertex.mPenumbraX;
            this.mPenumbraY = vertex.mPenumbraY;
        }

        public void translate(double d, double d2) {
            this.mPosX += d;
            this.mPosY += d2;
        }
    }

    public CurlMesh(int i) {
        this.mMaxCurlSplits = i < 1 ? 1 : i;
        this.mArrScanLines = new Array<>(i + 2);
        this.mArrOutputVertices = new Array<>(7);
        this.mArrRotatedVertices = new Array<>(4);
        this.mArrIntersections = new Array<>(2);
        this.mArrTempVertices = new Array<>(11);
        for (int i2 = 0; i2 < 11; i2++) {
            this.mArrTempVertices.add(new Vertex());
        }
        this.mArrShadowSelfVertices = new Array<>((this.mMaxCurlSplits + 2) * 2);
        this.mArrShadowDropVertices = new Array<>((this.mMaxCurlSplits + 2) * 2);
        this.mArrShadowTempVertices = new Array<>((this.mMaxCurlSplits + 2) * 2);
        for (int i3 = 0; i3 < (this.mMaxCurlSplits + 2) * 2; i3++) {
            this.mArrShadowTempVertices.add(new ShadowVertex());
        }
        for (int i4 = 0; i4 < 4; i4++) {
            this.mRectangle[i4] = new Vertex();
        }
        Vertex[] vertexArr = this.mRectangle;
        Vertex vertex = vertexArr[0];
        Vertex vertex2 = vertexArr[1];
        Vertex vertex3 = vertexArr[3];
        vertex3.mPenumbraY = -1.0d;
        vertex2.mPenumbraY = -1.0d;
        vertex2.mPenumbraX = -1.0d;
        vertex.mPenumbraX = -1.0d;
        Vertex vertex4 = vertexArr[2];
        vertex3.mPenumbraX = 1.0d;
        vertex4.mPenumbraY = 1.0d;
        vertex4.mPenumbraX = 1.0d;
        vertex.mPenumbraY = 1.0d;
        int i5 = (this.mMaxCurlSplits * 2) + 6;
        int i6 = i5 * 3 * 4;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(i6).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mBufVertices = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.position(0);
        FloatBuffer floatBufferAsFloatBuffer2 = ByteBuffer.allocateDirect(i5 * 2 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mBufTexCoords = floatBufferAsFloatBuffer2;
        floatBufferAsFloatBuffer2.position(0);
        FloatBuffer floatBufferAsFloatBuffer3 = ByteBuffer.allocateDirect(i6).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mBufNormals = floatBufferAsFloatBuffer3;
        floatBufferAsFloatBuffer3.position(0);
        int i7 = (this.mMaxCurlSplits + 2) * 2 * 2 * 3 * 4;
        FloatBuffer floatBufferAsFloatBuffer4 = ByteBuffer.allocateDirect(i7).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mBufShadowVertices = floatBufferAsFloatBuffer4;
        floatBufferAsFloatBuffer4.position(0);
        FloatBuffer floatBufferAsFloatBuffer5 = ByteBuffer.allocateDirect(i7).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mBufShadowPenumbra = floatBufferAsFloatBuffer5;
        floatBufferAsFloatBuffer5.position(0);
    }

    private void addVertex(Vertex vertex) {
        this.mBufVertices.put((float) vertex.mPosX);
        this.mBufVertices.put((float) vertex.mPosY);
        this.mBufVertices.put((float) vertex.mPosZ);
        this.mBufTexCoords.put((float) vertex.mTexX);
        this.mBufTexCoords.put((float) vertex.mTexY);
        this.mBufNormals.put((float) vertex.mNormalX);
        this.mBufNormals.put((float) vertex.mNormalY);
        this.mBufNormals.put((float) vertex.mNormalZ);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private fi.harism.curl.CurlMesh.Array<fi.harism.curl.CurlMesh.Vertex> getIntersections(fi.harism.curl.CurlMesh.Array<fi.harism.curl.CurlMesh.Vertex> r17, int[][] r18, double r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            fi.harism.curl.CurlMesh$Array<fi.harism.curl.CurlMesh$Vertex> r5 = r0.mArrIntersections
            r5.clear()
            r5 = 0
            r6 = r5
        Lf:
            int r7 = r2.length
            if (r6 >= r7) goto L8b
            r7 = r2[r6]
            r7 = r7[r5]
            java.lang.Object r7 = r1.get(r7)
            fi.harism.curl.CurlMesh$Vertex r7 = (fi.harism.curl.CurlMesh.Vertex) r7
            r8 = r2[r6]
            r9 = 1
            r8 = r8[r9]
            java.lang.Object r8 = r1.get(r8)
            fi.harism.curl.CurlMesh$Vertex r8 = (fi.harism.curl.CurlMesh.Vertex) r8
            double r9 = r7.mPosX
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 <= 0) goto L82
            double r11 = r8.mPosX
            int r13 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r13 >= 0) goto L82
            double r13 = r3 - r11
            double r9 = r9 - r11
            double r13 = r13 / r9
            fi.harism.curl.CurlMesh$Array<fi.harism.curl.CurlMesh$Vertex> r9 = r0.mArrTempVertices
            java.lang.Object r9 = r9.remove(r5)
            fi.harism.curl.CurlMesh$Vertex r9 = (fi.harism.curl.CurlMesh.Vertex) r9
            r9.set(r8)
            r9.mPosX = r3
            double r10 = r9.mPosY
            r15 = r6
            double r5 = r7.mPosY
            double r1 = r8.mPosY
            double r5 = r5 - r1
            double r5 = r5 * r13
            double r10 = r10 + r5
            r9.mPosY = r10
            double r1 = r9.mTexX
            double r5 = r7.mTexX
            double r10 = r8.mTexX
            double r5 = r5 - r10
            double r5 = r5 * r13
            double r1 = r1 + r5
            r9.mTexX = r1
            double r1 = r9.mTexY
            double r5 = r7.mTexY
            double r10 = r8.mTexY
            double r5 = r5 - r10
            double r5 = r5 * r13
            double r1 = r1 + r5
            r9.mTexY = r1
            double r1 = r9.mPenumbraX
            double r5 = r7.mPenumbraX
            double r10 = r8.mPenumbraX
            double r5 = r5 - r10
            double r5 = r5 * r13
            double r1 = r1 + r5
            r9.mPenumbraX = r1
            double r1 = r9.mPenumbraY
            double r5 = r7.mPenumbraY
            double r7 = r8.mPenumbraY
            double r5 = r5 - r7
            double r5 = r5 * r13
            double r1 = r1 + r5
            r9.mPenumbraY = r1
            fi.harism.curl.CurlMesh$Array<fi.harism.curl.CurlMesh$Vertex> r1 = r0.mArrIntersections
            r1.add(r9)
            goto L83
        L82:
            r15 = r6
        L83:
            int r6 = r15 + 1
            r1 = r17
            r2 = r18
            r5 = 0
            goto Lf
        L8b:
            fi.harism.curl.CurlMesh$Array<fi.harism.curl.CurlMesh$Vertex> r1 = r0.mArrIntersections
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: fi.harism.curl.CurlMesh.getIntersections(fi.harism.curl.CurlMesh$Array, int[][], double):fi.harism.curl.CurlMesh$Array");
    }

    private void setTexCoords(double d, double d2, double d3, double d4) {
        Vertex[] vertexArr = this.mRectangle;
        Vertex vertex = vertexArr[0];
        vertex.mTexX = d;
        vertex.mTexY = d2;
        Vertex vertex2 = vertexArr[1];
        vertex2.mTexX = d;
        vertex2.mTexY = d4;
        Vertex vertex3 = vertexArr[2];
        vertex3.mTexX = d3;
        vertex3.mTexY = d2;
        Vertex vertex4 = vertexArr[3];
        vertex4.mTexX = d3;
        vertex4.mTexY = d4;
    }

    public void curl(PointF pointF, PointF pointF2, double d) {
        double d2;
        double d3;
        double d4;
        int i;
        this.mBufVertices.position(0);
        this.mBufTexCoords.position(0);
        this.mBufNormals.position(0);
        double dAcos = Math.acos(pointF2.x);
        if (pointF2.y > 0.0f) {
            dAcos = -dAcos;
        }
        this.mArrTempVertices.addAll(this.mArrRotatedVertices);
        this.mArrRotatedVertices.clear();
        for (int i2 = 0; i2 < 4; i2++) {
            Vertex vertexRemove = this.mArrTempVertices.remove(0);
            vertexRemove.set(this.mRectangle[i2]);
            vertexRemove.translate(-pointF.x, -pointF.y);
            vertexRemove.rotateZ(-dAcos);
            while (i < this.mArrRotatedVertices.size()) {
                Vertex vertex = this.mArrRotatedVertices.get(i);
                double d5 = vertexRemove.mPosX;
                double d6 = vertex.mPosX;
                i = (d5 <= d6 && (d5 != d6 || vertexRemove.mPosY <= vertex.mPosY)) ? i + 1 : 0;
            }
            this.mArrRotatedVertices.add(i, vertexRemove);
        }
        int[][] iArr = {new int[]{0, 1}, new int[]{0, 2}, new int[]{1, 3}, new int[]{2, 3}};
        Vertex vertex2 = this.mArrRotatedVertices.get(0);
        Vertex vertex3 = this.mArrRotatedVertices.get(2);
        Vertex vertex4 = this.mArrRotatedVertices.get(3);
        double d7 = vertex2.mPosX;
        double d8 = dAcos;
        double d9 = vertex3.mPosX;
        double d10 = (d7 - d9) * (d7 - d9);
        double d11 = vertex2.mPosY;
        double d12 = vertex3.mPosY;
        double dSqrt = Math.sqrt(d10 + ((d11 - d12) * (d11 - d12)));
        double d13 = vertex2.mPosX;
        double d14 = vertex4.mPosX;
        double d15 = (d13 - d14) * (d13 - d14);
        double d16 = vertex2.mPosY;
        double d17 = vertex4.mPosY;
        if (dSqrt > Math.sqrt(d15 + ((d16 - d17) * (d16 - d17)))) {
            iArr[1][1] = 3;
            iArr[2][1] = 2;
        }
        this.mCountVertices = 0;
        this.mArrShadowTempVertices.addAll(this.mArrShadowDropVertices);
        this.mArrShadowTempVertices.addAll(this.mArrShadowSelfVertices);
        this.mArrShadowDropVertices.clear();
        this.mArrShadowSelfVertices.clear();
        double d18 = d * 3.141592653589793d;
        this.mArrScanLines.clear();
        if (this.mMaxCurlSplits > 0) {
            this.mArrScanLines.add(Double.valueOf(w51.l));
        }
        int i3 = 1;
        while (true) {
            int i4 = this.mMaxCurlSplits;
            if (i3 >= i4) {
                break;
            }
            this.mArrScanLines.add(Double.valueOf(((-d18) * ((double) i3)) / ((double) (i4 - 1))));
            i3++;
        }
        this.mArrScanLines.add(Double.valueOf(this.mArrRotatedVertices.get(3).mPosX - 1.0d));
        double d19 = this.mArrRotatedVertices.get(0).mPosX + 1.0d;
        int i5 = 0;
        while (i5 < this.mArrScanLines.size()) {
            double dDoubleValue = this.mArrScanLines.get(i5).doubleValue();
            int i6 = 0;
            while (i6 < this.mArrRotatedVertices.size()) {
                Vertex vertex5 = this.mArrRotatedVertices.get(i6);
                double d20 = vertex5.mPosX;
                if (d20 < dDoubleValue || d20 > d19) {
                    d4 = dDoubleValue;
                } else {
                    Vertex vertexRemove2 = this.mArrTempVertices.remove(0);
                    vertexRemove2.set(vertex5);
                    d4 = dDoubleValue;
                    Array<Vertex> intersections = getIntersections(this.mArrRotatedVertices, iArr, vertexRemove2.mPosX);
                    if (intersections.size() == 1 && intersections.get(0).mPosY > vertex5.mPosY) {
                        this.mArrOutputVertices.addAll(intersections);
                        this.mArrOutputVertices.add(vertexRemove2);
                    } else if (intersections.size() <= 1) {
                        this.mArrOutputVertices.add(vertexRemove2);
                        this.mArrOutputVertices.addAll(intersections);
                    } else {
                        this.mArrTempVertices.add(vertexRemove2);
                        this.mArrTempVertices.addAll(intersections);
                    }
                }
                i6++;
                dDoubleValue = d4;
            }
            double d21 = dDoubleValue;
            Array<Vertex> intersections2 = getIntersections(this.mArrRotatedVertices, iArr, d21);
            if (intersections2.size() == 2) {
                Vertex vertex6 = intersections2.get(0);
                Vertex vertex7 = intersections2.get(1);
                d2 = d21;
                if (vertex6.mPosY < vertex7.mPosY) {
                    this.mArrOutputVertices.add(vertex7);
                    this.mArrOutputVertices.add(vertex6);
                } else {
                    this.mArrOutputVertices.addAll(intersections2);
                }
            } else {
                d2 = d21;
                if (intersections2.size() != 0) {
                    this.mArrTempVertices.addAll(intersections2);
                }
            }
            while (this.mArrOutputVertices.size() > 0) {
                Vertex vertexRemove3 = this.mArrOutputVertices.remove(0);
                this.mArrTempVertices.add(vertexRemove3);
                if (i5 == 0) {
                    vertexRemove3.mNormalX = w51.l;
                    vertexRemove3.mNormalY = w51.l;
                    vertexRemove3.mNormalZ = 1.0d;
                    d3 = d8;
                } else {
                    if (i5 == this.mArrScanLines.size() - 1 || d18 == w51.l) {
                        vertexRemove3.mPosX = -(vertexRemove3.mPosX + d18);
                        vertexRemove3.mPosZ = d * 2.0d;
                        vertexRemove3.mNormalX = w51.l;
                        vertexRemove3.mNormalY = w51.l;
                        vertexRemove3.mNormalZ = -1.0d;
                        vertexRemove3.mPenumbraX = -vertexRemove3.mPenumbraX;
                    } else {
                        double d22 = (vertexRemove3.mPosX / d18) * 3.141592653589793d;
                        vertexRemove3.mPosX = d * Math.sin(d22);
                        vertexRemove3.mPosZ = d - (Math.cos(d22) * d);
                        vertexRemove3.mNormalX = Math.sin(d22);
                        vertexRemove3.mNormalY = w51.l;
                        vertexRemove3.mNormalZ = Math.cos(d22);
                        vertexRemove3.mPenumbraX *= Math.cos(d22);
                    }
                    d3 = d8;
                }
                vertexRemove3.rotateZ(d3);
                double d23 = d18;
                vertexRemove3.translate(pointF.x, pointF.y);
                addVertex(vertexRemove3);
                this.mCountVertices++;
                double d24 = vertexRemove3.mPosZ;
                if (d24 > w51.l && d24 <= d) {
                    ShadowVertex shadowVertexRemove = this.mArrShadowTempVertices.remove(0);
                    shadowVertexRemove.mPosX = vertexRemove3.mPosX;
                    shadowVertexRemove.mPosY = vertexRemove3.mPosY;
                    double d25 = vertexRemove3.mPosZ;
                    shadowVertexRemove.mPosZ = d25;
                    double d26 = d > w51.l ? d25 / d : w51.l;
                    double d27 = d26 * d26 * (3.0d - (d26 * 2.0d));
                    shadowVertexRemove.mPenumbraX = Math.sqrt(d27) * d * 0.8d * ((double) (-pointF2.x));
                    shadowVertexRemove.mPenumbraY = Math.sqrt(d27) * d * 0.8d * ((double) (-pointF2.y));
                    shadowVertexRemove.mPenumbraA = (d27 * 0.5d) + 0.5d;
                    this.mArrShadowDropVertices.add((this.mArrShadowDropVertices.size() + 1) / 2, shadowVertexRemove);
                }
                if (vertexRemove3.mPosZ > d) {
                    ShadowVertex shadowVertexRemove2 = this.mArrShadowTempVertices.remove(0);
                    shadowVertexRemove2.mPosX = vertexRemove3.mPosX;
                    shadowVertexRemove2.mPosY = vertexRemove3.mPosY;
                    double d28 = vertexRemove3.mPosZ;
                    shadowVertexRemove2.mPosZ = d28;
                    double d29 = d > w51.l ? (d28 - d) / d : 0.0d;
                    double d30 = d29 * d29 * (3.0d - (d29 * 2.0d));
                    double d31 = d30 * d * 0.4d;
                    shadowVertexRemove2.mPenumbraX = ((double) pointF2.x) * d31;
                    shadowVertexRemove2.mPenumbraY = d31 * ((double) pointF2.y);
                    shadowVertexRemove2.mPenumbraA = (d30 * 0.3d) + 0.3d;
                    this.mArrShadowSelfVertices.add((this.mArrShadowSelfVertices.size() + 1) / 2, shadowVertexRemove2);
                }
                d18 = d23;
                d8 = d3;
            }
            i5++;
            d19 = d2;
            d18 = d18;
            d8 = d8;
        }
        this.mBufVertices.position(0);
        this.mBufTexCoords.position(0);
        this.mBufNormals.position(0);
        this.mBufShadowVertices.position(0);
        this.mBufShadowPenumbra.position(0);
        this.mCountShadowSelf = 0;
        this.mCountShadowDrop = 0;
        for (int i7 = 0; i7 < this.mArrShadowDropVertices.size(); i7++) {
            ShadowVertex shadowVertex = this.mArrShadowDropVertices.get(i7);
            this.mBufShadowVertices.put((float) shadowVertex.mPosX);
            this.mBufShadowVertices.put((float) shadowVertex.mPosY);
            this.mBufShadowVertices.put((float) shadowVertex.mPosZ);
            this.mBufShadowPenumbra.put(0.0f);
            this.mBufShadowPenumbra.put(0.0f);
            this.mBufShadowPenumbra.put((float) shadowVertex.mPenumbraA);
            this.mBufShadowVertices.put((float) shadowVertex.mPosX);
            this.mBufShadowVertices.put((float) shadowVertex.mPosY);
            this.mBufShadowVertices.put((float) shadowVertex.mPosZ);
            this.mBufShadowPenumbra.put((float) shadowVertex.mPenumbraX);
            this.mBufShadowPenumbra.put((float) shadowVertex.mPenumbraY);
            this.mBufShadowPenumbra.put(0.0f);
            this.mCountShadowDrop += 2;
        }
        for (int i8 = 0; i8 < this.mArrShadowSelfVertices.size(); i8++) {
            ShadowVertex shadowVertex2 = this.mArrShadowSelfVertices.get(i8);
            this.mBufShadowVertices.put((float) shadowVertex2.mPosX);
            this.mBufShadowVertices.put((float) shadowVertex2.mPosY);
            this.mBufShadowVertices.put((float) shadowVertex2.mPosZ);
            this.mBufShadowPenumbra.put(0.0f);
            this.mBufShadowPenumbra.put(0.0f);
            this.mBufShadowPenumbra.put((float) shadowVertex2.mPenumbraA);
            this.mBufShadowVertices.put((float) shadowVertex2.mPosX);
            this.mBufShadowVertices.put((float) shadowVertex2.mPosY);
            this.mBufShadowVertices.put((float) shadowVertex2.mPosZ);
            this.mBufShadowPenumbra.put((float) shadowVertex2.mPenumbraX);
            this.mBufShadowPenumbra.put((float) shadowVertex2.mPenumbraY);
            this.mBufShadowPenumbra.put(0.0f);
            this.mCountShadowSelf += 2;
        }
        this.mBufShadowVertices.position(0);
        this.mBufShadowPenumbra.position(0);
    }

    public int getBackReverse() {
        return this.mBackReverse;
    }

    public int getDropShadowCount() {
        return this.mCountShadowDrop;
    }

    public FloatBuffer getNormals() {
        return this.mBufNormals;
    }

    public CurlPage getPage() {
        return this.mPage;
    }

    public int getSelfShadowCount() {
        return this.mCountShadowSelf;
    }

    public FloatBuffer getShadowPenumbra() {
        return this.mBufShadowPenumbra;
    }

    public FloatBuffer getShadowVertices() {
        return this.mBufShadowVertices;
    }

    public FloatBuffer getTexCoords() {
        return this.mBufTexCoords;
    }

    public int[] getTextures() {
        if (this.mTextureIds == null) {
            int[] iArr = new int[3];
            this.mTextureIds = iArr;
            GLES20.glGenTextures(3, iArr, 0);
            for (int i : this.mTextureIds) {
                GLES20.glBindTexture(3553, i);
                GLES20.glTexParameterf(3553, 10241, 9728.0f);
                GLES20.glTexParameterf(3553, 10240, 9728.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
        }
        if (this.mPage.getBitmapsChanged()) {
            GLES20.glPixelStorei(3317, 1);
            GLES20.glBindTexture(3553, this.mTextureIds[0]);
            GLUtils.texImage2D(3553, 0, this.mPage.getBitmap(1), 0);
            GLES20.glBindTexture(3553, this.mTextureIds[1]);
            GLUtils.texImage2D(3553, 0, this.mPage.getBitmap(2), 0);
            GLES20.glBindTexture(3553, this.mTextureIds[2]);
            GLUtils.texImage2D(3553, 0, this.mPage.getBitmap(3), 0);
            this.mPage.recycle();
        }
        return this.mTextureIds;
    }

    public int getVertexCount() {
        return this.mCountVertices;
    }

    public FloatBuffer getVertices() {
        return this.mBufVertices;
    }

    public void reset() {
        this.mBufVertices.position(0);
        this.mBufTexCoords.position(0);
        this.mBufNormals.position(0);
        for (int i = 0; i < 4; i++) {
            Vertex vertex = this.mArrTempVertices.get(0);
            vertex.set(this.mRectangle[i]);
            addVertex(vertex);
        }
        this.mCountVertices = 4;
        this.mBufVertices.position(0);
        this.mBufTexCoords.position(0);
        this.mBufNormals.position(0);
        this.mCountShadowSelf = 0;
        this.mCountShadowDrop = 0;
    }

    public void resetTextures() {
        this.mTextureIds = null;
    }

    public void setBackReverse(int i) {
        this.mBackReverse = i;
    }

    public void setRect(RectF rectF) {
        Vertex[] vertexArr = this.mRectangle;
        Vertex vertex = vertexArr[0];
        float f = rectF.left;
        vertex.mPosX = f;
        float f2 = rectF.top;
        vertex.mPosY = f2;
        Vertex vertex2 = vertexArr[1];
        vertex2.mPosX = f;
        float f3 = rectF.bottom;
        vertex2.mPosY = f3;
        Vertex vertex3 = vertexArr[2];
        float f4 = rectF.right;
        vertex3.mPosX = f4;
        vertex3.mPosY = f2;
        Vertex vertex4 = vertexArr[3];
        vertex4.mPosX = f4;
        vertex4.mPosY = f3;
    }

    public void setTexture() {
        setTexCoords(w51.l, w51.l, 1.0d, 1.0d);
    }

    public class Array<T> {
        private Object[] mArray;
        private int mCapacity;
        private int mSize;

        public Array(int i) {
            this.mCapacity = i;
            this.mArray = new Object[i];
        }

        public void add(int i, T t) {
            int i2;
            if (i < 0 || i > (i2 = this.mSize) || i2 >= this.mCapacity) {
                throw new IndexOutOfBoundsException();
            }
            while (i2 > i) {
                Object[] objArr = this.mArray;
                objArr[i2] = objArr[i2 - 1];
                i2--;
            }
            this.mArray[i] = t;
            this.mSize++;
        }

        public void addAll(Array<T> array) {
            if (this.mSize + array.size() > this.mCapacity) {
                throw new IndexOutOfBoundsException();
            }
            for (int i = 0; i < array.size(); i++) {
                Object[] objArr = this.mArray;
                int i2 = this.mSize;
                this.mSize = i2 + 1;
                objArr[i2] = array.get(i);
            }
        }

        public void clear() {
            this.mSize = 0;
        }

        public T get(int i) {
            if (i < 0 || i >= this.mSize) {
                throw new IndexOutOfBoundsException();
            }
            return (T) this.mArray[i];
        }

        public T remove(int i) {
            if (i < 0 || i >= this.mSize) {
                throw new IndexOutOfBoundsException();
            }
            T t = (T) this.mArray[i];
            while (true) {
                int i2 = this.mSize;
                if (i >= i2 - 1) {
                    this.mSize = i2 - 1;
                    return t;
                }
                Object[] objArr = this.mArray;
                int i3 = i + 1;
                objArr[i] = objArr[i3];
                i = i3;
            }
        }

        public int size() {
            return this.mSize;
        }

        public void add(T t) {
            int i = this.mSize;
            if (i < this.mCapacity) {
                Object[] objArr = this.mArray;
                this.mSize = i + 1;
                objArr[i] = t;
                return;
            }
            throw new IndexOutOfBoundsException();
        }
    }
}
