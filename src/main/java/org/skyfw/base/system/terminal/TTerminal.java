package org.skyfw.base.system.terminal;

// Add to gradle file
import io.leego.banana.BananaUtils;
import org.skyfw.base.system.debugger.TDebugger;
import org.skyfw.base.system.operatingsystem.TOperatingSystem;
// Add to gradle file
import org.fusesource.jansi.AnsiConsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TTerminal {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static {
        if ((TOperatingSystem.getOS().equals(TOperatingSystem.TOSType.WINDOWS_OS))
                && (!TDebugger.IsDebuggerPresent())) {
            AnsiConsole.systemInstall();
            // AnsiConsole.systemUninstall();
        }
    }

    /**
     * <p>
     * Changes color of the text being printed on the terminal
     * </p>
     * 
     * @param terminalTextColor an instance of {@link TTerminalTextColor}.
     */
    public static void setTextColor(TTerminalTextColor terminalTextColor) {

        // system.out.println(ANSI_GREEN_BACKGROUND + "This text has a green background
        // but default text!" );
        System.out.print(terminalTextColor);

        // system.out.println(Ansi.ansi().eraseScreen().fg(RED).a("Hello").fg(YELLOW).a("
        // World").reset());
        // system.out.println( Ansi.ansi().eraseScreen().render("@|red Hello|@ @|yellow
        // World|@") );

    }

    public static void setBackgroundColor(TTerminalBGColor terminalBGColor) {
        System.out.println(terminalBGColor);
    }

    public static void reset() {
        System.out.println("\033[0m");
    }

    public static void writeFX(String text, TTerminalFXFont font) {

        if (font != null)
            System.out.println(BananaUtils.bananaify(text, font.toString()));
        else
            System.out.println(BananaUtils.bananaify(text));

        /*
         * List<String> fonts = BananaUtils.fonts(); for (String font : fonts) {
         * system.out.println(font);
         * system.out.println(BananaUtils.bananaify("Hello, Github!", font)); }
         */

    }

    public static void writeFX(String text) {
        writeFX(text, null);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void clrscr() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
        }
    }

    /**
     * <p>
     * Moves the cursor to the specific point on the terminal.
     * </p>
     * 
     * @param x horizontal location of the desired point
     * @param y vertical location of the desired point
     */
    public static void goToXY(int x, int y) {
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df", escCode, y, x));
    }

    /**
     * Reads a line from terminal.
     * 
     * @return {@link String} content of the line.
     */
    public static String readLn() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    public static Long readLongLn(Long defaultValue) {

        Long threadsCount = null;
        String inputString = "";
        while (true) {
            try {
                inputString = reader.readLine(); // scan.next();

                if (inputString.isEmpty())
                    return defaultValue;

                threadsCount = Long.valueOf(inputString);

                return threadsCount;

            } catch (Exception e) {
                // system.out.println(inputString + " is not valid for threads count");
            }
        }

    }

}
