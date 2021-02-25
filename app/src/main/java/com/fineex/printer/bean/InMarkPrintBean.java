package com.fineex.printer.bean;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Parcel;
import android.text.TextUtils;

import com.fineex.printer.FineExPrinter;
import com.fineex.printer.Printer;
import com.fineex.printer.QRCodeUtils;
import com.fineex.printer.R;
import com.fineex.printer.jpl.Barcode;
import com.fineex.printer.jpl.Image;
import com.fineex.printer.jpl.JPL;
import com.fineex.printer.jpl.Page;
import com.fineex.printer.jpl.Text.TEXT_ENLARGE;

import java.util.List;

/**
 * @Author： Chen
 * @Date： 2020/7/6
 * @Desc：
 */
public class InMarkPrintBean implements Printer {

    private String OrderDate;
    private String BoxMark;
    private String WarehouseMember;
    private String InCode;
    private String SyncId;
    private String CommodityName;
    private String BarCode;
    private List<KeyValue> MarkConfig;

    private String MemberNo;
    private String BoxGauge;
    private String BatchCode;
    private String ShelfLife;
    private String TentativePeriod;

    private String Count;
    private String Remark;
    private String PrintUser;
    private String PrintDate;
    private Resources resources;

    public String getBoxMark() {
        if (TextUtils.isEmpty(BoxMark)) return "";
        return BoxMark;
    }

    public void setBoxMark(String boxMark) {
        BoxMark = boxMark;
    }

    public String getWarehouseMember() {
        if (TextUtils.isEmpty(WarehouseMember)) return "";
        return WarehouseMember;
    }

    public void setWarehouseMember(String warehouseMember) {
        WarehouseMember = warehouseMember;
    }

    public String getInCode() {
        if (TextUtils.isEmpty(InCode)) return "";
        return InCode;
    }

    public void setInCode(String inCode) {
        InCode = inCode;
    }

    public String getSyncId() {
        if (TextUtils.isEmpty(SyncId)) return "";
        return SyncId;
    }

    public void setSyncId(String syncId) {
        SyncId = syncId;
    }

    public String getCommodityName() {
        if (TextUtils.isEmpty(CommodityName)) return "";
        return CommodityName;
    }

    public void setCommodityName(String commodityName) {
        CommodityName = commodityName;
    }

    public String getBarCode() {
        if (TextUtils.isEmpty(BarCode)) return "";
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }

    public List<KeyValue> getMarkConfig() {
        return MarkConfig;
    }

    public void setMarkConfig(List<KeyValue> markConfig) {
        MarkConfig = markConfig;
    }

    public String getMemberNo() {
        if (TextUtils.isEmpty(MemberNo)) return "";
        return MemberNo;
    }

    public void setMemberNo(String memberNo) {
        MemberNo = memberNo;
    }

    public String getBoxGauge() {
        if (TextUtils.isEmpty(BoxGauge)) return "";
        return BoxGauge;
    }

    public void setBoxGauge(String boxGauge) {
        BoxGauge = boxGauge;
    }

    public String getBatchCode() {
        if (TextUtils.isEmpty(BatchCode)) return "";
        return BatchCode;
    }

    public void setBatchCode(String batchCode) {
        BatchCode = batchCode;
    }

    public String getShelfLife() {
        if (TextUtils.isEmpty(ShelfLife)) return "";
        return ShelfLife;
    }

    public void setShelfLife(String shelfLife) {
        ShelfLife = shelfLife;
    }

    public String getTentativePeriod() {
        if (TextUtils.isEmpty(TentativePeriod)) return "";
        return TentativePeriod;
    }

    public void setTentativePeriod(String tentativePeriod) {
        TentativePeriod = tentativePeriod;
    }

    public String getCount() {
        if (TextUtils.isEmpty(Count)) return "";
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public String getRemark() {
        if (TextUtils.isEmpty(Remark)) return "";
        return Remark;
    }

    public void setRemark(String Remark) {
        this.Remark = Remark;
    }

    public String getPrintUser() {
        if (TextUtils.isEmpty(PrintUser)) return "";
        return PrintUser;
    }

    public void setPrintUser(String PrintUser) {
        this.PrintUser = PrintUser;
    }

    public String getPrintDate() {
        if (TextUtils.isEmpty(PrintDate)) return "";
        return PrintDate;
    }

    public void setPrintDate(String PrintDate) {
        this.PrintDate = PrintDate;
    }

    public String getOrderDate() {
        if (TextUtils.isEmpty(OrderDate)) return "";
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public InMarkPrintBean(Resources resources) {
        this.resources = resources;
    }

    public static final int PRINT_WIDTH = 556;
    public static final int PRINT_HEIGHT = 972;

    @Override
    public void print(FineExPrinter printer) {
        int fontSize = 22;
        int lineWidth = 2;
        int fontHeight = 36;

        printer.jpl.page.start(0, 0, PRINT_WIDTH, PRINT_HEIGHT, Page.PAGE_ROTATE.x0);
        printer.jpl.image.drawOut(6, 0, resources, R.mipmap.fineex_print_logo, Image.IMAGE_ROTATE.ANGLE_0);

        printer.jpl.text.drawOut(FineExPrinter.ALIGN.RIGHT, 8, "单据日期：" + getOrderDate(), 22, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);

        //打印区域横线
        /**
         *   ***************
         *   *             *
         *   *             *
         *   *             *
         *   *             *
         *   ***************
         */
        //横线
        printer.jpl.graphic.line(new Point(6, 40), new Point(PRINT_WIDTH, 40), lineWidth);
        printer.jpl.graphic.line(new Point(6, PRINT_HEIGHT - 60), new Point(PRINT_WIDTH, PRINT_HEIGHT - 60), lineWidth);
        //竖线
        printer.jpl.graphic.line(new Point(6, 40), new Point(6, PRINT_HEIGHT - 60), lineWidth);
        printer.jpl.graphic.line(new Point(PRINT_WIDTH, 40), new Point(PRINT_WIDTH, PRINT_HEIGHT - 60), lineWidth);

        //入库箱号及其条码
        printer.jpl.text.drawOut(12, 69, "箱号：", 22);
        printer.jpl.barcode.code128(FineExPrinter.ALIGN.CENTER, 50, 50, Barcode.BAR_UNIT.x2, Barcode.BAR_ROTATE.ANGLE_180, getBoxMark());
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.CENTER, 106, getBoxMark(), 22, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        printer.jpl.graphic.line(new Point(6, 140), new Point(PRINT_WIDTH, 140), lineWidth);

        //仓库信息
        printer.jpl.text.drawOut(12, textStartY(160, fontHeight, 1), "仓库会员：" + getWarehouseMember(), fontSize, false);
        printer.jpl.text.drawOut(12, textStartY(160, fontHeight, 2), "入库单号：" + getInCode(), fontSize, false);
        printer.jpl.text.drawOut(12, textStartY(160, fontHeight, 3), "外部单号：" + getSyncId(), fontSize, false);
        printer.jpl.text.drawOut(12, textStartY(160, fontHeight, 4), "商品名称：" + getCommodityName(), fontSize, false);
        printer.jpl.graphic.line(new Point(6, 320), new Point(PRINT_WIDTH, 320), lineWidth);

        //配置信息
        for (int i = 0; i < getMarkConfig().size(); i++) {
            KeyValue value = getMarkConfig().get(i);
            printer.jpl.text.drawOut(12, textStartY(330, fontHeight, i + 1), value.getKey() + "：" + value.getValue(), fontSize, false);
        }
        printer.jpl.graphic.line(new Point(6, 550), new Point(PRINT_WIDTH, 550), lineWidth);


        printer.jpl.text.drawOut(12, 600, "商品条码：", 22);
        printer.jpl.barcode.code128(FineExPrinter.ALIGN.CENTER, 570, 50, Barcode.BAR_UNIT.x2, Barcode.BAR_ROTATE.ANGLE_0, getBarCode());
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.CENTER, 630, getBarCode(), 22, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        printer.jpl.graphic.line(new Point(6, 670), new Point(PRINT_WIDTH, 670), lineWidth);

        printer.jpl.text.drawOut(12, textStartY(680, fontHeight, 1), "数量：", fontSize, false);
        printer.jpl.text.drawOut(12, textStartY(680, fontHeight, 2), getCount(), fontSize, true);

        printer.jpl.graphic.line(new Point(100, 670), new Point(100, PRINT_HEIGHT - 60), lineWidth);
        printer.jpl.graphic.line(new Point(PRINT_WIDTH - 250, 670), new Point(PRINT_WIDTH - 250, PRINT_HEIGHT - 60), lineWidth);

        String remark = "备注：" + getRemark();
        int remarkLength = remark.length();
        if (remarkLength <= 11) {
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 1), remark, fontSize);
        } else if (remarkLength <= 22) {
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 1), remark.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 2), remark.substring(11), fontSize);
        } else if (remarkLength <= 33) {
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 1), remark.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 2), remark.substring(11, 22), fontSize);
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 3), remark.substring(22), fontSize);
        } else {
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 1), remark.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 2), remark.substring(11, 22), fontSize);
            printer.jpl.text.drawOut(106, textStartY(680, fontHeight, 3), remark.substring(22, 32) + "…", fontSize);
        }

        String text = getBoxMark() + "/" + getMemberNo() + "/" + getInCode() + "/" + getBoxGauge() + "/" + getBatchCode() + "/" + getShelfLife() + "/" + getTentativePeriod();
        Bitmap qrImage = QRCodeUtils.createQRCode(text, 230);
        printer.jpl.image.drawOut(PRINT_WIDTH - 240, 680, 230, 230, printer.jpl.image.CovertImageHorizontal(qrImage, 128), false, Image.IMAGE_ROTATE.ANGLE_0, 0, 0);
//        printer.jpl.barcode.QRCode(PRINT_WIDTH - 230, 690, 1, Barcode.QRCODE_ECC.LEVEL_H, Barcode.BAR_UNIT.x10, JPL.ROTATE.ROTATE_0, "32435646324356463243564632435646");

        printer.jpl.text.drawOut(12, textStartY(PRINT_HEIGHT - 50, fontHeight, 1), "打印人：" + getPrintUser(), fontSize);
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.RIGHT, textStartY(PRINT_HEIGHT - 50, fontHeight, 1), "打印日期：" + getPrintDate(), fontSize, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);

        printer.jpl.page.end();
        printer.jpl.page.print();
        printer.jpl.feedMarkOrGap(0);//printer.jpl.feedNextLabelEnd(48);
    }

    private int textStartY(int startY, int fontHeight, int line) {
        if (startY < 0)
            return 0;
        if (fontHeight < 0)
            return 0;
        if (line < 1)
            return 0;
        return startY + fontHeight * (line - 1);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.OrderDate);
        dest.writeString(this.BoxMark);
        dest.writeString(this.WarehouseMember);
        dest.writeString(this.InCode);
        dest.writeString(this.SyncId);
        dest.writeString(this.CommodityName);
        dest.writeString(this.BarCode);
        dest.writeTypedList(this.MarkConfig);
        dest.writeString(this.MemberNo);
        dest.writeString(this.BoxGauge);
        dest.writeString(this.BatchCode);
        dest.writeString(this.ShelfLife);
        dest.writeString(this.TentativePeriod);
        dest.writeString(this.Count);
        dest.writeString(this.Remark);
        dest.writeString(this.PrintUser);
        dest.writeString(this.PrintDate);
    }

    protected InMarkPrintBean(Parcel in) {
        this.OrderDate = in.readString();
        this.BoxMark = in.readString();
        this.WarehouseMember = in.readString();
        this.InCode = in.readString();
        this.SyncId = in.readString();
        this.CommodityName = in.readString();
        this.BarCode = in.readString();
        this.MarkConfig = in.createTypedArrayList(KeyValue.CREATOR);
        this.MemberNo = in.readString();
        this.BoxGauge = in.readString();
        this.BatchCode = in.readString();
        this.ShelfLife = in.readString();
        this.TentativePeriod = in.readString();
        this.Count = in.readString();
        this.Remark = in.readString();
        this.PrintUser = in.readString();
        this.PrintDate = in.readString();
    }

    public static final Creator<InMarkPrintBean> CREATOR = new Creator<InMarkPrintBean>() {
        @Override
        public InMarkPrintBean createFromParcel(Parcel source) {
            return new InMarkPrintBean(source);
        }

        @Override
        public InMarkPrintBean[] newArray(int size) {
            return new InMarkPrintBean[size];
        }
    };
}
