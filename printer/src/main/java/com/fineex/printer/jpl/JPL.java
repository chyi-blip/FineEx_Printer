package com.fineex.printer.jpl;

import com.fineex.printer.FineExPrinter.PRINTER_TYPE;
import com.fineex.printer.Port;

public class JPL {
    public static enum ROTATE {
        ROTATE_0(0x00),
        ROTATE_90(0x01),
        ROTATE_180(0x10),
        ROTATE_270(0x11);
        private int _value;

        private ROTATE(int mode) {
            _value = mode;
        }

        public int value() {
            return _value;
        }
    }

    public static enum COLOR {
        White,
        Black,
    }

    private Port port;
    public Page page;
    public Barcode barcode;
    public Text text;
    public JPL_Param param;
    public Graphic graphic;
    public Image image;

    public JPL(Port port, PRINTER_TYPE printer_type) {
        if (port == null)
            return;
        this.port = port;
        this.param = new JPL_Param(port);
        page = new Page(param);
        barcode = new Barcode(param);
        text = new Text(param);
        graphic = new Graphic(param);
        image = new Image(param);
    }

    public boolean feedNextLabelBegin() {
        byte[] cmd = {0x1A, 0x0C, 0x00};
        return port.write(cmd);
    }

    public static enum FEED_TYPE {
        MARK_OR_GAP,
        LABEL_END,
        MARK_BEGIN,
        MARK_END,
        BACK,
    }

    private boolean feed(FEED_TYPE feed_type, int offset) {
        byte[] cmd = {0x1A, 0x0C, 0x01};
        port.write(cmd);
        port.write((byte) feed_type.ordinal());
        return port.write((short) offset);
    }

    public boolean feedBack(int dots) {
        return feed(FEED_TYPE.BACK, dots);
    }

    public boolean feedNextLabelEnd(int dots) {
        return feed(FEED_TYPE.LABEL_END, dots);
    }

    public boolean feedMarkOrGap(int dots) {
        return feed(FEED_TYPE.MARK_OR_GAP, dots);
    }

    public boolean feedMarkEnd(int dots) {
        return feed(FEED_TYPE.MARK_END, dots);
    }

    public boolean feedMarkBegin(int dots) {
        return feed(FEED_TYPE.MARK_BEGIN, dots);
    }
}
