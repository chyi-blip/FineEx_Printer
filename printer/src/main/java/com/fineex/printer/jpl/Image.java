package com.fineex.printer.jpl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

public class Image extends BaseJPL {
    public enum IMAGE_ROTATE {
        ANGLE_0,
        ANGLE_90,
        ANGLE_180,
        ANGLE_270
    }

    public Image(JPL_Param param) {
        super(param);
    }

    public boolean drawOut(int x, int y, int width, int height, char[] data) {
        if (width < 0 || height < 0)
            return false;
        byte[] cmd = {0x1A, 0x21, 0x00};
        int HeightWriteUnit = 10;
        int WidthByte = ((width - 1) / 8 + 1);
        int HeightWrited = 0;
        int HeightLeft = height;
        while (true) {
            if (HeightLeft <= HeightWriteUnit) {
                port.write(cmd);
                port.write((short) x);
                port.write((short) y);
                port.write((short) width);
                port.write((short) HeightLeft);
                int index = HeightWrited * WidthByte;
                for (int i = 0; i < HeightLeft * WidthByte; i++) {
                    port.write((byte) data[index++]);
                }
                return true;
            } else {
                port.write(cmd);
                port.write((short) x);
                port.write((short) y);
                port.write((short) width);
                port.write((short) HeightWriteUnit);
                int index = HeightWrited * WidthByte;
                for (int i = 0; i < HeightWriteUnit * WidthByte; i++) {
                    port.write((byte) data[index++]);
                }
                y += HeightWriteUnit;
                HeightWrited += HeightWriteUnit;
                HeightLeft -= HeightWriteUnit;
            }
        }
    }

    public boolean drawOut(int x, int y, int width, int height, byte[] data, boolean Reverse, IMAGE_ROTATE Rotate, int EnlargeX, int EnlargeY) {
        if (width < 0 || height < 0)
            return false;

        short ShowType = 0;
        if (Reverse) ShowType |= 0x0001;
        ShowType |= (Rotate.ordinal() << 1) & 0x0006;
        ShowType |= (EnlargeX << 8) & 0x0F00;
        ShowType |= (EnlargeY << 14) & 0xF000;

        byte[] cmd = {0x1A, 0x21, 0x01};
        int HeightWriteUnit = 10;
        int WidthByte = ((width - 1) / 8 + 1);
        int HeightWrited = 0;
        int HeightLeft = height;
        while (true) {
            if (HeightLeft <= HeightWriteUnit) {
                port.write(cmd);
                port.write((short) x);
                port.write((short) y);
                port.write((short) width);
                port.write((short) HeightLeft);
                port.write((short) ShowType);
                int index = HeightWrited * WidthByte;
                for (int i = 0; i < HeightLeft * WidthByte; i++) {
                    port.write((byte) data[index++]);
                }
                return true;
            } else {
                port.write(cmd);
                port.write((short) x);
                port.write((short) y);
                port.write((short) width);
                port.write((short) HeightWriteUnit);
                port.write((short) ShowType);

                int index = HeightWrited * WidthByte;
                for (int i = 0; i < HeightWriteUnit * WidthByte; i++) {
                    port.write((byte) data[index++]);
                }
                y += HeightWriteUnit;
                HeightWrited += HeightWriteUnit;
                HeightLeft -= HeightWriteUnit;
            }
        }
    }

    private boolean PixelIsBlack(int color, int gray_threshold) {
        int red = ((color & 0x00FF0000) >> 16);
        int green = ((color & 0x0000FF00) >> 8);
        int blue = color & 0x000000FF;
        int grey = (int) ((float) red * 0.299 + (float) green * 0.587 + (float) blue * 0.114);
        return (grey < gray_threshold);
    }

    public byte[] CovertImageHorizontal(Bitmap bitmap, int gray_threshold) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int BytesPerLine = (width - 1) / 8 + 1;

        byte[] data = new byte[BytesPerLine * height];
        for (int i = 0; i < data.length; i++) {
            data[i] = 0;
        }
        int index = 0;

        int x = 0, y = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < BytesPerLine; j++) {
                for (int k = 0; k < 8; k++) {
                    x = (j << 3) + k;
                    y = i;
                    if (x >= width) {
                        continue;
                    } else {
                        if (PixelIsBlack(bitmap.getPixel(x, y), gray_threshold)) {
                            data[index] |= (byte) (0x01 << k);
                        }
                    }
                }
                index++;
            }
            x = 0;
        }
        return data;
    }

    /**
     * 调整图片大小
     *
     * @param bitmap 源
     * @param dst_w  输出宽度
     * @param dst_h  输出高度
     * @return 位图
     */
    public static Bitmap imageScale(Bitmap bitmap, int dst_w, int dst_h) {
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        float scale_w = ((float) dst_w) / src_w;
        float scale_h = ((float) dst_h) / src_h;
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        return Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
    }

    public boolean drawOut(int x, int y, Resources res, int id, IMAGE_ROTATE rotate) {
        Bitmap bitmap = BitmapFactory.decodeResource(res, id);
        Bitmap scale = imageScale(bitmap, 150, 50);
        int width = scale.getWidth();
        int height = scale.getHeight();
        if (width > param.pageWidth || height > param.pageHeight)
            return false;
        return drawOut(x, y, width, height, CovertImageHorizontal(scale, 128), false, rotate, 0, 0);
    }
}
