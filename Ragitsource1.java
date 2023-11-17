
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Ragitsource1 {

    public static void main(String[] args) {
        int x = 0;
        Robot robot;
        try {
            robot = new Robot();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your text here:");
            String text = scanner.nextLine();

            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            System.out.println("RagitBOT will start in 3 seconds");
            Thread.sleep(3000);

            while (x <= 100) {
                Thread.sleep(1);

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                x++;
            }

            scanner.close();
        } catch (AWTException | InterruptedException ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }
}

	

		