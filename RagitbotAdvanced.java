import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;

public class RagitbotAdvanced {

    private JFrame frame;
    private JTextField textField;
    private JButton startButton;
    private JButton breakbutton;
    private volatile boolean isSpamming = false;
    private JLabel resultLabel;
    private JComboBox<String> CounterBox;
    private int selectedWordCount = 10;
    private JComboBox<String> CounterTime;
    private int selectedTimeCount = 10;


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RagitbotAdvanced().createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        
        breakbutton = new JButton("Break");
        breakbutton.setBackground(Color.GRAY);
        breakbutton.setForeground(Color.WHITE);
        breakbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isSpamming = false;
                resultLabel.setText("Spamming stopped!");
            }
        
        });
                
        frame = new JFrame("RagitBOT version 1.1.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        
        int frameWidth =  500;
        int frameHeight = 300;
        
        
        frame.setSize(frameWidth, frameHeight);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        JTextField username = new JTextField(50);
        JLabel label2 = new JLabel("Username you want to use for this session:");
        
        JButton Ok = new JButton("Ok");
        Ok.setBackground(Color.PINK);
        Ok.setForeground(Color.WHITE);
        Ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label2.setText("Username accepted!");
                String usernameText = username.getText();
                if (usernameText.isEmpty()) {
                    label2.setText("Username not accepted, try again");
                    frame.setTitle("RagitBOT version 1.1.1 - Username not found by 'air' -");
                    startButton.setVisible(false);
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221A");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221B");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221C");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221D");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221E");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221F");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221G");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221H");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221I");
                    System.out.println("err.' '.not.accepted.name.' '.err19#1271.33221J");
                    System.out.println("err.aTOj");
                    
                }
                if (!usernameText.isEmpty()) {
                    frame.setTitle("RagitBOT version 1.1.1 - Welcome " + usernameText + " -");
                    startButton.setVisible(true);
                }
            }
        });
        
        JLabel label = new JLabel(" Enter the text you want to spam below");
        textField = new JTextField(50);
        startButton = new JButton("Start");
        startButton.setBackground(Color.PINK);
        startButton.setForeground(Color.WHITE);
        
        resultLabel = new JLabel("");
        
        
        
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(Color.PINK);
        updateButton.setForeground(Color.WHITE);
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Updating...");
                JFrame updateFrame = new JFrame("Update Window");
                updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                updateFrame.setSize(400, 300);
                
                Timer timer1 = new Timer(10000, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        label.setText("RagitBOT update completed!");
                        updateButton.setVisible(false);
                        frame.setTitle("RagitBot version 1.1.4 - Welcome Updated.Ragit.User#1010");
                        
                        Timer timer2 = new Timer(2000, new ActionListener() {
                            public void actionPerformed(ActionEvent evt) {
                                label.setText("Enter the text you want to spam below");
                            }
                        });
                        timer2.setRepeats(false);
                        timer2.start();
                    }
                });
                
                
                timer1.start();
                
            }
        });
                
        
        JButton closeButton = new JButton("Close");
        closeButton.setBackground(Color.PINK);
        closeButton.setForeground(Color.WHITE);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        JLabel words = new JLabel("Select the number of words you want to spam");
        
        
        final String[] wordCounts = {"10", "50", "100", "500", "1000", "5000", "10000", "Coming soon"};
        CounterBox = new JComboBox<>(wordCounts);
        CounterBox.setSelectedIndex(0);
        
        
        String[] messageRates = {"10", "20", "30", "40", "50", "Coming soon "}; 
        CounterTime = new JComboBox<>(messageRates);
        CounterTime.setSelectedIndex(0);
        
        CounterTime.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedValue = (String) CounterTime.getSelectedItem();
                selectedTimeCount = Integer.parseInt(selectedValue);
            }
        });
        
        
        
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startRagitBOT();
                resultLabel.setText("Pasting completed.");
            }
        });
       
        panel.add(label2);
        panel.add(username);
        panel.add(Ok);
        panel.add(Box.createVerticalStrut(10));
       
        panel.add(label);
        panel.add(textField);
        panel.add(startButton);
        panel.add(closeButton);
        panel.add(resultLabel);
        panel.add(updateButton);
        panel.add(updateButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(words);
        panel.add(CounterBox);
        panel.add(Box.createVerticalStrut(10));
        
        
        
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); 
        frame.setLocationRelativeTo(null);
        frame.setSize(frameWidth, frameHeight);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0); 
            }
        });
    }

    private void startRagitBOT() {
       isSpamming = true;
    
       SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {

		@Override
		protected Void doInBackground() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
    	   
       };
       try {
            Robot robot = new Robot();
            String text = textField.getText();
            StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);

            System.out.println("Wait 3 seconds...");
            frame.setTitle("working...");
            Thread.sleep(3000);
            
            
            String selectedValue = (String) CounterBox.getSelectedItem();
            int selectedWordCount = Integer.parseInt(selectedValue);
            
            int x = 0;
            while (x < selectedWordCount) {
                Thread.sleep(1); 

                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);

                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);

                x++;
            }
           
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            
            
        } catch (AWTException | InterruptedException ex) {
            System.err.println("-An error occurred- " + ex.getMessage());
        }finally {
        	 Timer t = new Timer(2000, new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
        	
        }
       
    });
        	 t.setRepeats(false); 
             t.start();
    
    }
    
}
}
