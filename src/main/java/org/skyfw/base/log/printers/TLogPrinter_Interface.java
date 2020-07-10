package org.skyfw.base.log.printers;

import org.skyfw.base.log.TLogRecord;

//TODO maybe TLogPrinter is better than TLogPrinter_Interface #suggestion
public interface TLogPrinter_Interface {

    public void print(TLogRecord logRecord);


}
