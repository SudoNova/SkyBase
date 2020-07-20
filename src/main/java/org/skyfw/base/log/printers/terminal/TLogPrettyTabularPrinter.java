package org.skyfw.base.log.printers.terminal;

// TODO add to build.gradle
import com.jakewharton.fliptables.FlipTable;
import org.skyfw.base.log.printers.TLogPrinter_Interface;
import org.skyfw.base.mcodes.TMCodeSeverity;
import org.skyfw.base.log.TLogRecord;
import org.skyfw.base.system.terminal.TTerminal;
import org.skyfw.base.system.terminal.TTerminalTextColor;

import java.text.SimpleDateFormat;

/**
 * <p>
 * an implementation of {@link TLogPrinter_Interface} that colorizes the output,
 * and prints it in a tabular like style, with the following columns:
 * <ul>
 * <li>Log Time</li>
 * <li>Type which is an instance of {@link TMCodeSeverity}</li>
 * <li>Class Name of the log record</li>
 * <li>Method Name of the log record</li>
 * <li>Method Name of the log record</li>
 * <li>File name //TODO update
 * <li>A {@code boolean} which shows if this record is an exception.</li>
 * </ul>
 * </p>
 */
public class TLogPrettyTabularPrinter implements TLogPrinter_Interface {

    @Override
    public void print(TLogRecord logRecord) {

        // Var
        String mainTable;
        String detailsTable;

        String[] headers = { "log Time", "Type", "Class Name", "Method Name", "file Name", " exception" };
        String[][] data = { { new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(logRecord.getTimeStamp()),
                logRecord.getType().toString(), logRecord.getClassName(), logRecord.getMethodName(),
                logRecord.getFileName(), new Boolean(logRecord.isException()).toString() }
                // , {"TEEEEEEEEEEEEEEEST"}
        };

        detailsTable = FlipTable.of(headers, data);
        // system.out.println(mainTable.trim());
        // system.out.println("---");

        headers = new String[] { detailsTable };

        data = new String[][] { { logRecord.getDescription() } };

        mainTable = FlipTable.of(headers, data);

        // mainTable=
        // mainTable.replace("<DetailTableColor>",TTerminalTextColor.RED.toString());
        // mainTable=
        // mainTable.replace("</DetailTableColor>",TTerminalTextColor.CYAN.toString());
        // mainTable= mainTable.replace("╔══",TTerminalTextColor.RED.toString() +
        // "╔══");
        // mainTable= mainTable.replace("══╝","══╝" +
        // detailsTable+TTerminalTextColor.CYAN.toString());

        TTerminal.reset();

        switch (logRecord.getType()) {
            case DEBUG:
                TTerminal.setTextColor(TTerminalTextColor.WHITE);
                break;
            case TRACE:
                TTerminal.setTextColor(TTerminalTextColor.BLUE);
                break;
            case INFO:
                TTerminal.setTextColor(TTerminalTextColor.CYAN);
                break;
            case WARNING:
                TTerminal.setTextColor(TTerminalTextColor.YELLOW);
                break;
            case ERROR:
                TTerminal.setTextColor(TTerminalTextColor.RED);
                break;
            case FATAL:
                TTerminal.setTextColor(TTerminalTextColor.RED_BOLD);
                break;
        }

        System.out.println(mainTable.trim());
        TTerminal.reset();

    }
}
