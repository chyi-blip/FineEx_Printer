package com.fineex.printer.bean;


import android.content.res.Resources;
import android.graphics.Point;
import android.os.Parcel;
import android.text.TextUtils;

import com.fineex.printer.FineExPrinter;
import com.fineex.printer.Printer;
import com.fineex.printer.PrinterApplication;
import com.fineex.printer.R;
import com.fineex.printer.jpl.Barcode;
import com.fineex.printer.jpl.Image;
import com.fineex.printer.jpl.JPL;
import com.fineex.printer.jpl.Page;
import com.fineex.printer.jpl.Text.TEXT_ENLARGE;

/**
 * @Author： Chen
 * @Date： 2020/7/6
 * @Desc： B2B出库质检箱唛打印模板（76x130）
 */
public class MarkPrintBean implements Printer {

    /**
     * StoreCode : 436546
     * BoxNum : 436546
     * Consignee : 收货方
     * ConsigneePhone : 17601236985
     * ConsigneeAddress : 上海市宝山区呼兰路
     * Sender : 收货方
     * SenderWarehouse : 发网
     * SenderPhone : 17601236985
     * SenderAddress : 上海市宝山区呼兰路
     * OrderCode : 94030
     * TransportCode : 94030
     * Weight : 23.1
     * Volume : 24.1
     * SKU : 10
     * Count : 10
     * SumBoxCount : 10
     * BoxOrder : 2
     * Remark : 备注
     * PrintUser : 吴永健
     * PrintDate : 2020-01-01 10:45
     * OrderDate : 2020-01-01
     */

    private String StoreCode;
    private String StoreName = "T湖北武汉海林广场店";
    private String StoreCodeName;
    private String BoxNum;
    private String Consignee;
    private String ConsigneePhone;
    private String ConsigneeAddress;
    private String Sender;
    private String SenderWarehouse;
    private String SenderPhone;
    private String SenderAddress;
    private String OrderCode;
    private String TransportCode;
    private String Weight;
    private String Volume;
    private String SKU;
    private String Count;
    private String SumBoxCount;
    private String BoxOrder;
    private String Remark;
    private String PrintUser;
    private String PrintDate;
    private String DocumentDate;
    private String OrderDate;
    private String TemplateType = "9802";

    public String getStoreName() {
        if (TextUtils.isEmpty(StoreName)) return "";
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getTemplateType() {
        if (TextUtils.isEmpty(TemplateType)) return "";
        return TemplateType;
    }

    public void setTemplateType(String templateType) {
        TemplateType = templateType;
    }

    public String getStoreCode() {
        if (TextUtils.isEmpty(StoreCode)) return "";
        return StoreCode;
    }

    public void setStoreCode(String StoreCode) {
        this.StoreCode = StoreCode;
    }

    public String getBoxNum() {
        if (TextUtils.isEmpty(BoxNum)) return "";
        return BoxNum;
    }

    public void setBoxNum(String BoxNum) {
        this.BoxNum = BoxNum;
    }

    public String getConsignee() {
        if (TextUtils.isEmpty(Consignee)) return "";
        return Consignee;
    }

    public void setConsignee(String Consignee) {
        this.Consignee = Consignee;
    }

    public String getConsigneePhone() {
        if (TextUtils.isEmpty(ConsigneePhone)) return "";
        return ConsigneePhone;
    }

    public void setConsigneePhone(String ConsigneePhone) {
        this.ConsigneePhone = ConsigneePhone;
    }

    public String getConsigneeAddress() {
        if (TextUtils.isEmpty(ConsigneeAddress)) return "";
        return ConsigneeAddress;
    }

    public void setConsigneeAddress(String ConsigneeAddress) {
        this.ConsigneeAddress = ConsigneeAddress;
    }

    public String getSender() {
        if (TextUtils.isEmpty(Sender)) return "";
        return Sender;
    }

    public void setSender(String Sender) {
        this.Sender = Sender;
    }

    public String getSenderWarehouse() {
        if (TextUtils.isEmpty(SenderWarehouse)) return "";
        return SenderWarehouse;
    }

    public void setSenderWarehouse(String SenderWarehouse) {
        this.SenderWarehouse = SenderWarehouse;
    }

    public String getSenderPhone() {
        if (TextUtils.isEmpty(SenderPhone)) return "";
        return SenderPhone;
    }

    public void setSenderPhone(String SenderPhone) {
        this.SenderPhone = SenderPhone;
    }

    public String getSenderAddress() {
        if (TextUtils.isEmpty(SenderAddress)) return "";
        return SenderAddress;
    }

    public void setSenderAddress(String SenderAddress) {
        this.SenderAddress = SenderAddress;
    }

    public String getOrderCode() {
        if (TextUtils.isEmpty(OrderCode)) return "";
        return OrderCode;
    }

    public void setOrderCode(String OrderCode) {
        this.OrderCode = OrderCode;
    }

    public String getTransportCode() {
        if (TextUtils.isEmpty(TransportCode)) return "";
        return TransportCode;
    }

    public void setTransportCode(String TransportCode) {
        this.TransportCode = TransportCode;
    }

    public String getWeight() {
        if (TextUtils.isEmpty(Weight)) return "";
        return Weight;
    }

    public void setWeight(String Weight) {
        this.Weight = Weight;
    }

    public String getVolume() {
        if (TextUtils.isEmpty(Volume)) return "";
        return Volume;
    }

    public void setVolume(String Volume) {
        this.Volume = Volume;
    }

    public String getSKU() {
        if (TextUtils.isEmpty(SKU)) return "";
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getCount() {
        if (TextUtils.isEmpty(Count)) return "";
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }

    public String getSumBoxCount() {
        if (TextUtils.isEmpty(SumBoxCount)) return "";
        return SumBoxCount;
    }

    public void setSumBoxCount(String SumBoxCount) {
        this.SumBoxCount = SumBoxCount;
    }

    public String getBoxOrder() {
        if (TextUtils.isEmpty(BoxOrder)) return "";
        return BoxOrder;
    }

    public void setBoxOrder(String BoxOrder) {
        this.BoxOrder = BoxOrder;
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
        if (TextUtils.isEmpty(DocumentDate)) return "";
        return DocumentDate;
    }

    public void setOrderDate(String OrderDate) {
        this.DocumentDate = OrderDate;
    }

    public MarkPrintBean() {
    }

    public static final int PRINT_WIDTH = 556;
    public static final int PRINT_HEIGHT = 972;

    @Override
    public void print(FineExPrinter printer) {
        if ("9802".equalsIgnoreCase(TemplateType)) {
            newBalance(printer);
        } else {
            common(printer);
        }
    }

    public void common(FineExPrinter printer) {
        int fontSize = 22;
        int lineWidth = 2;
        int fontHeight = 36;

        printer.jpl.page.start(0, 0, PRINT_WIDTH, PRINT_HEIGHT, Page.PAGE_ROTATE.x0);
        printer.jpl.image.drawOut(6, 0, PrinterApplication.getInstance().getResource(), R.mipmap.fineex_print_logo, Image.IMAGE_ROTATE.ANGLE_0);

        printer.jpl.text.drawOut(FineExPrinter.ALIGN.RIGHT, 0, "单据日期：" + getOrderDate(), 22, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);

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

        //出库箱号及其条码
        printer.jpl.text.drawOut(12, 69, "箱号：", 22);
        printer.jpl.barcode.code128(FineExPrinter.ALIGN.CENTER, 46, 44, Barcode.BAR_UNIT.x2, Barcode.BAR_ROTATE.ANGLE_0, getBoxNum());
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.CENTER, 94, getBoxNum(), 18, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        printer.jpl.graphic.line(new Point(6, 120), new Point(PRINT_WIDTH, 120), lineWidth);

        //收货方 发货方
        printer.jpl.graphic.line(new Point(6, 350), new Point(PRINT_WIDTH, 350), lineWidth);
        printer.jpl.text.drawOut(12, 210, "收货方", 32, true, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        printer.jpl.text.drawOut(12, 430, "发货方", 32, true, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        int textWidth = printer.jpl.text.calcTextWidth(32, "收货方") + 12;
        printer.jpl.graphic.line(new Point(textWidth, 120), new Point(textWidth, 580), lineWidth);
        printer.jpl.graphic.line(new Point(6, 580), new Point(PRINT_WIDTH, 580), lineWidth);

        //收货信息
        int consigneeLength = getConsignee().length();
        if (consigneeLength > 15) {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 1), "收货人：" + getConsignee().substring(consigneeLength - 15) + "…", fontSize);
        } else {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 1), "收货人：" + getConsignee(), fontSize);
        }

        printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 2), "电话：" + getConsigneePhone(), fontSize);

        int consigneeAddressLength = getConsigneeAddress().length();
        if (consigneeAddressLength > 15) {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 3), "地址：" + getConsigneeAddress().substring(0, 15), fontSize);
            if (consigneeAddressLength > 32)
                printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 4), getConsigneeAddress().substring(consigneeAddressLength - 17) + "…", fontSize);
            else
                printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 4), getConsigneeAddress().substring(15), fontSize);
        } else {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(130, fontHeight, 3), "地址：" + getConsigneeAddress(), fontSize);
        }

        //发货信息
        int senderLength = getSender().length();
        if (senderLength > 15) {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 1), "发货人：" + getSender() + "…", fontSize);
        } else {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 1), "发货人：" + getSender(), fontSize);
        }

        printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 2), "电话：" + getSenderPhone(), fontSize);

        int senderCompanyLength = getSenderWarehouse().length();
        if (senderCompanyLength > 15) {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 3), "仓库：" + getSenderWarehouse().substring(0, 15), fontSize);
            if (senderCompanyLength > 32)
                printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 4), getSenderWarehouse().substring(senderCompanyLength - 17) + "…", fontSize);
            else
                printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 4), getSenderWarehouse().substring(15), fontSize);
        } else {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, 3), "仓库：" + getSenderWarehouse(), fontSize);
        }

        int senderAddressLength = getSenderAddress().length();
        if (senderAddressLength > 15) {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, senderCompanyLength > 15 ? 5 : 4), "地址：" + getSenderAddress().substring(0, 15), fontSize, false);
            if (senderAddressLength > 32)
                printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, senderCompanyLength > 15 ? 6 : 5), getSenderAddress().substring(senderAddressLength - 17) + "…", fontSize);
            else
                printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, senderCompanyLength > 15 ? 6 : 5), getSenderAddress().substring(15), fontSize);
        } else {
            printer.jpl.text.drawOut(textWidth + 10, textStartY(360, fontHeight, senderCompanyLength > 15 ? 5 : 4), "地址：" + getSenderAddress(), fontSize, false);
        }

        //业务信息
        printer.jpl.text.drawOut(12, textStartY(586, fontHeight, 1), "订单号码：" + getOrderCode(), fontSize, true);
        printer.jpl.text.drawOut(12, textStartY(586, fontHeight, 2), "运单号码：" + getTransportCode(), fontSize, true);

        printer.jpl.text.drawOut(12, textStartY(586, fontHeight, 3), "箱重量：" + getWeight(), fontSize);
        printer.jpl.text.drawOut(12, textStartY(586, fontHeight, 4), "箱体积：" + getVolume(), fontSize);

        printer.jpl.text.drawOut(12, textStartY(586, fontHeight, 5), "SKU：" + getSKU(), fontSize);
        printer.jpl.text.drawOut(PRINT_WIDTH / 2, textStartY(586, fontHeight, 5), "总数量：" + getCount(), fontSize);

        printer.jpl.text.drawOut(12, textStartY(586, fontHeight, 6), "总箱数 / 第几箱：", fontSize, true);

        printer.jpl.graphic.line(new Point(6, 802), new Point(PRINT_WIDTH, 802), lineWidth);
        printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 1), "门店代码：", fontSize, false);
        printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 2), getStoreCode() + getStoreName(), fontSize, true);
        printer.jpl.graphic.line(new Point(PRINT_WIDTH / 2 - 3, 802), new Point(PRINT_WIDTH / 2 - 3, PRINT_HEIGHT - 60), lineWidth);

        String storeCode = "门店代码：" + getStoreCode();
        int storeCodeLength = storeCode.length();
        if (storeCodeLength <= 11) {
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 1), storeCode, fontSize);
        } else if (storeCodeLength <= 22) {
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 1), storeCode.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 2), storeCode.substring(11), fontSize);
        } else if (storeCodeLength <= 33) {
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 1), storeCode.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 2), storeCode.substring(11, 22), fontSize);
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 3), storeCode.substring(22), fontSize);
        } else {
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 1), storeCode.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 2), storeCode.substring(11, 22), fontSize);
            printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 3), storeCode.substring(22, 32) + "…", fontSize);
        }

        String remark = "备注：" + getRemark();
        int remarkLength = remark.length();
        if (remarkLength <= 11) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 1), remark, fontSize);
        } else if (remarkLength <= 22) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 1), remark.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 2), remark.substring(11), fontSize);
        } else if (remarkLength <= 33) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 1), remark.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 2), remark.substring(11, 22), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 3), remark.substring(22), fontSize);
        } else {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 1), remark.substring(0, 11), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 2), remark.substring(11, 22), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 3, textStartY(808, fontHeight, 3), remark.substring(22, 32) + "…", fontSize);
        }

        printer.jpl.text.drawOut(12, textStartY(PRINT_HEIGHT - 50, fontHeight, 1), "打印人：" + getPrintUser(), fontSize);
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.RIGHT, textStartY(PRINT_HEIGHT - 50, fontHeight, 1), "打印日期：" + getPrintDate(), fontSize, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);

        printer.jpl.page.end();
        printer.jpl.page.print();
        printer.jpl.feedMarkOrGap(0);//printer.jpl.feedNextLabelEnd(48);
    }

    private void newBalance(FineExPrinter printer) {
        int fontSize = 22;
        int lineWidth = 2;
        int fontHeight = 36;
        int PRINT_WIDTH = 570;
        int PRINT_HEIGHT = 980;

        printer.jpl.page.start(0, 0, PRINT_WIDTH, PRINT_HEIGHT, Page.PAGE_ROTATE.x0);

        //打印区域横线
        /**
         *   ***************
         *   *             *
         *   *             *
         *   *             *
         *   *             *
         *   ***************
         */
        int padding = 5;
        //横线
        printer.jpl.graphic.line(new Point(padding, padding), new Point(PRINT_WIDTH - padding, padding), lineWidth);
        printer.jpl.graphic.line(new Point(padding, PRINT_HEIGHT - 36 - padding), new Point(PRINT_WIDTH - padding, PRINT_HEIGHT - 36 - padding), lineWidth);
        //竖线
        printer.jpl.graphic.line(new Point(padding, padding), new Point(padding, PRINT_HEIGHT - 36 - padding), lineWidth);
        printer.jpl.graphic.line(new Point(PRINT_WIDTH - padding, padding), new Point(PRINT_WIDTH - padding, PRINT_HEIGHT - 36 - padding), lineWidth);

        //出库箱号及其条码
        printer.jpl.text.drawOut(12, 40, "箱号：", 52, true);
        printer.jpl.barcode.code128(FineExPrinter.ALIGN.CENTER, 22, 64, Barcode.BAR_UNIT.x2, Barcode.BAR_ROTATE.ANGLE_0, getBoxNum());
        printer.jpl.text.drawOut(FineExPrinter.ALIGN.CENTER, 96, getBoxNum(), 18, false, false, false, false, TEXT_ENLARGE.x1, TEXT_ENLARGE.x1, JPL.ROTATE.ROTATE_0);
        printer.jpl.graphic.line(new Point(padding, 120), new Point(PRINT_WIDTH, 120), lineWidth);

        printer.jpl.text.drawOut(12, 145, "门店代码：", 48, true);
        printer.jpl.text.drawOut(260, 140, getStoreCode(), 62, true);

        if (getStoreName().length() <= 11) {
            printer.jpl.text.drawOut(12, 210, getStoreName(), 58, true);
        } else {
            printer.jpl.text.drawOut(12, 210, getStoreName().substring(0, 11), 58, true);
            printer.jpl.text.drawOut(12, 280, getStoreName().substring(11), 58, true);
        }
        printer.jpl.graphic.line(new Point(padding, 360), new Point(PRINT_WIDTH, 360), lineWidth);

        printer.jpl.text.drawOut(12, 395, "第几箱/总箱数：", 42, true);
        printer.jpl.text.drawOut(PRINT_WIDTH / 2 + 12, 390, "(" + getBoxOrder() + "/      )", 52, false);
        printer.jpl.graphic.line(new Point(padding, 460), new Point(PRINT_WIDTH, 460), lineWidth);

        //收货方
        printer.jpl.text.drawOut(12, 606, "收货方", 32, true);
        int textWidth = printer.jpl.text.calcTextWidth(32, "收货方") + 32;
        printer.jpl.graphic.line(new Point(textWidth, 460), new Point(textWidth, 860), lineWidth);
        printer.jpl.graphic.line(new Point(padding, 780), new Point(PRINT_WIDTH - padding, 780), lineWidth);

        printer.jpl.graphic.line(new Point(textWidth, 540), new Point(PRINT_WIDTH - padding, 540), lineWidth);
        printer.jpl.graphic.line(new Point(textWidth, 620), new Point(PRINT_WIDTH - padding, 620), lineWidth);

        printer.jpl.graphic.line(new Point(PRINT_WIDTH / 2 - 30, 360), new Point(PRINT_WIDTH / 2 - 30, 780), lineWidth);

        //收货信息
        printer.jpl.text.drawOut(textWidth + 10, 490, "收货人：", fontSize);
        printer.jpl.text.drawOut(textWidth + 10, 570, "电话：", fontSize);
        printer.jpl.text.drawOut(textWidth + 10, 690, "地址：", fontSize);
        int consigneeLength = getConsignee().length();
        if (consigneeLength >= 12) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(468, fontHeight, 1), getConsignee().substring(0, 12), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(468, fontHeight, 2), getConsignee().substring(12, Math.min(consigneeLength, 24)), fontSize);
        } else {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(468, fontHeight, 1), getConsignee(), fontSize);
        }

        printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 5, 570, getConsigneePhone(), fontSize);

        int consigneeAddressLength = getConsigneeAddress().length();
        if (consigneeAddressLength <= 12) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 1), getConsigneeAddress(), fontSize);
        } else if (consigneeAddressLength <= 24) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 1), getConsigneeAddress().substring(0, 12), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 2), getConsigneeAddress().substring(12), fontSize);
        } else if (consigneeAddressLength <= 36) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 1), getConsigneeAddress().substring(0, 12), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 2), getConsigneeAddress().substring(12, 24), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 3), getConsigneeAddress().substring(24), fontSize);
        } else if (consigneeAddressLength <= 48) {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 1), getConsigneeAddress().substring(0, 12), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 2), getConsigneeAddress().substring(12, 24), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 2), getConsigneeAddress().substring(24, 36), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 3), getConsigneeAddress().substring(36), fontSize);
        } else {
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 1), getConsigneeAddress().substring(0, 12), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 2), getConsigneeAddress().substring(12, 24), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 2), getConsigneeAddress().substring(24, 36), fontSize);
            printer.jpl.text.drawOut(PRINT_WIDTH / 2 - 15, textStartY(626, fontHeight, 3), getConsigneeAddress().substring(36, 46) + "...", fontSize);
        }

        printer.jpl.text.drawOut(12, textStartY(808, fontHeight, 1), "出库单号：", fontSize, false);
        printer.jpl.text.drawOut(textWidth + 10, textStartY(808, fontHeight, 1), getOrderCode(), fontSize, true);
        printer.jpl.graphic.line(new Point(padding, 860), new Point(PRINT_WIDTH - padding, 860), lineWidth);


        String remark = "备注：" + getRemark();
        int remarkLength = remark.length();
        if (remarkLength <= 16) {
            printer.jpl.text.drawOut(12, textStartY(870, fontHeight, 1), remark, fontSize);
        } else if (remarkLength <= 32) {
            printer.jpl.text.drawOut(12, textStartY(870, fontHeight, 1), remark.substring(0, 16), fontSize);
            printer.jpl.text.drawOut(12, textStartY(870, fontHeight, 2), remark.substring(16), fontSize);
        } else {
            printer.jpl.text.drawOut(12, textStartY(870, fontHeight, 1), remark.substring(0, 16), fontSize);
            printer.jpl.text.drawOut(12, textStartY(870, fontHeight, 2), remark.substring(16, 30) + "…", fontSize);
        }

        printer.jpl.text.drawOut(textStartY(PRINT_HEIGHT - 36, fontHeight, 1), "打印时间" + getPrintDate(), fontSize, false, FineExPrinter.ALIGN.RIGHT);

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

    public String getStoreCodeName() {
        return StoreCodeName;
    }

    public void setStoreCodeName(String StoreCodeName) {
        this.StoreCodeName = StoreCodeName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.StoreCode);
        dest.writeString(this.StoreName);
        dest.writeString(this.StoreCodeName);
        dest.writeString(this.BoxNum);
        dest.writeString(this.Consignee);
        dest.writeString(this.ConsigneePhone);
        dest.writeString(this.ConsigneeAddress);
        dest.writeString(this.Sender);
        dest.writeString(this.SenderWarehouse);
        dest.writeString(this.SenderPhone);
        dest.writeString(this.SenderAddress);
        dest.writeString(this.OrderCode);
        dest.writeString(this.TransportCode);
        dest.writeString(this.Weight);
        dest.writeString(this.Volume);
        dest.writeString(this.SKU);
        dest.writeString(this.Count);
        dest.writeString(this.SumBoxCount);
        dest.writeString(this.BoxOrder);
        dest.writeString(this.Remark);
        dest.writeString(this.PrintUser);
        dest.writeString(this.PrintDate);
        dest.writeString(this.DocumentDate);
        dest.writeString(this.OrderDate);
        dest.writeString(this.TemplateType);
    }

    protected MarkPrintBean(Parcel in) {
        this.StoreCode = in.readString();
        this.StoreName = in.readString();
        this.StoreCodeName = in.readString();
        this.BoxNum = in.readString();
        this.Consignee = in.readString();
        this.ConsigneePhone = in.readString();
        this.ConsigneeAddress = in.readString();
        this.Sender = in.readString();
        this.SenderWarehouse = in.readString();
        this.SenderPhone = in.readString();
        this.SenderAddress = in.readString();
        this.OrderCode = in.readString();
        this.TransportCode = in.readString();
        this.Weight = in.readString();
        this.Volume = in.readString();
        this.SKU = in.readString();
        this.Count = in.readString();
        this.SumBoxCount = in.readString();
        this.BoxOrder = in.readString();
        this.Remark = in.readString();
        this.PrintUser = in.readString();
        this.PrintDate = in.readString();
        this.DocumentDate = in.readString();
        this.OrderDate = in.readString();
        this.TemplateType = in.readString();
    }

    public static final Creator<MarkPrintBean> CREATOR = new Creator<MarkPrintBean>() {
        @Override
        public MarkPrintBean createFromParcel(Parcel source) {
            return new MarkPrintBean(source);
        }

        @Override
        public MarkPrintBean[] newArray(int size) {
            return new MarkPrintBean[size];
        }
    };
}
