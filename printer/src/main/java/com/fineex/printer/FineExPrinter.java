package com.fineex.printer;

import android.bluetooth.BluetoothAdapter;

import com.fineex.printer.esc.ESC;
import com.fineex.printer.jpl.JPL;

/**
 * @Author： Chen
 * @Date： 2020/9/23
 * @Desc：
 */
public class FineExPrinter {
    private static FineExPrinter mInstance;

    /**
     * 打印类型枚举
     */
    public static enum PRINTER_TYPE {
        VMP02,
        VMP02_P,
        JLP351,
        JLP351_IC,
        ULT113x,
        ULT1131_IC,
    }

    /**
     * 枚举类型：对齐方式
     */
    public static enum ALIGN {
        LEFT,
        CENTER,
        RIGHT;
    }

    public FineExPrinterInfo printerInfo = new FineExPrinterInfo();
    private PRINTER_TYPE printerType;
    private Port port = null;
    public ESC esc = null;
    public JPL jpl = null;
    public boolean isOpen = false;
    private boolean isInit = false;
    private byte[] state = {0, 0};

    private FineExPrinter() {

    }

    public static FineExPrinter getInstance() {
        if (mInstance == null) {
            mInstance = new FineExPrinter();
        }
        return mInstance;
    }

    private FineExPrinter(String btDeviceString) {
        if (btDeviceString == null) {
            isInit = false;
            return;
        }
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            isInit = false;
            return;
        }
        port = new Port(btAdapter, btDeviceString);
        isInit = true;
    }

    public static FineExPrinter getInstance(String btDeviceString) {
        if (mInstance == null) {
            mInstance = new FineExPrinter(btDeviceString);
        }
        return mInstance;
    }

    public void initPrinter(String btDeviceString){
        if (btDeviceString == null) {
            isInit = false;
            return;
        }
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            isInit = false;
            return;
        }
        port = new Port(btAdapter, btDeviceString);
        isInit = true;
    }

    public boolean open(PRINTER_TYPE printer_type) {
        if (!isInit)
            return false;
        printerType = printer_type;
        if (isOpen)
            return true;

        if (!port.open(3000))
            return false;

        esc = new ESC(port, printer_type);
        jpl = new JPL(port, printer_type);
        isOpen = true;
        return true;
    }

    public boolean open(PRINTER_TYPE printer_type, int timeout) {
        if (!isInit)
            return false;
        printerType = printer_type;
        if (isOpen)
            return true;

        if (!port.open(timeout))
            return false;

        esc = new ESC(port, printer_type);
        jpl = new JPL(port, printer_type);
        isOpen = true;
        return true;
    }

    public boolean open(String btDeviceString, PRINTER_TYPE printer_type) {
        if (btDeviceString == null)
            return false;
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null)
            return false;
        port = new Port(btAdapter, btDeviceString);
        if (port == null)
            return false;
        isInit = true;

        return open(printer_type, 3000);
    }

    public boolean close() {
        if (!isOpen)
            return false;

        isOpen = false;
        return port.close();
    }

    public Port.PORT_STATE getPortState() {
        return port.getState();
    }

    public boolean wakeUp() {
        if (!isInit)
            return false;

        if (!port.writeNULL())
            return false;
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return esc.text.init();
    }

    public boolean feedRightMark() {
        if (!isInit)
            return false;

        byte[] cmd = {0x00, 0x00};
        switch (this.printerType) {
            case JLP351: //JLP351系列没有右黑标传感器，只能使用中间的标签缝传感器代替有右黑标传感器
            case JLP351_IC:
                cmd[0] = 0x1D;
                cmd[1] = 0x0C;
                return port.write(cmd, 2);//指令0x1D 0x01C 等效于 0x0E
            default:
                cmd[0] = 0x0C;
                return port.write(cmd, 1);
        }
    }

    public boolean feedLeftMark() {
        if (!isInit)
            return false;

        switch (this.printerType) {
            case JLP351: //JLP351系列没有右黑标传感器，只能使用中间的标签缝传感器代替有右黑标传感器
            case JLP351_IC:
                return port.write((byte) 0x0c);//0x0C
            default:
                return port.write((byte) 0x0e);
        }
    }

    public boolean getPrinterState(int timeout_read) {
        if (!isInit)
            return false;

        printerInfo.stateReset();
        if (!esc.getState(state, timeout_read))
            return false;
        if ((state[0] & FineExPrinterInfo.STATE_NOPAPER_UNMASK) != 0) {
            printerInfo.isNoPaper = true;
        }
        if ((state[0] & FineExPrinterInfo.STATE_BATTERYLOW_UNMASK) != 0) {
            printerInfo.isBatteryLow = true;
        }
        if ((state[0] & FineExPrinterInfo.STATE_COVEROPEN_UNMASK) != 0) {
            printerInfo.isCoverOpen = true;
        }
        if ((state[0] & FineExPrinterInfo.STATE_OVERHEAT_UNMASK) != 0) {
            printerInfo.isOverHeat = true;
        }
        if ((state[0] & FineExPrinterInfo.STATE_PRINTING_UNMASK) != 0) {
            printerInfo.isPrinting = true;
        }
        return true;
    }
}
