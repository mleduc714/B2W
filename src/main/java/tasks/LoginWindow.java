package tasks;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class LoginWindow implements Runnable {
    
	String sUserName = "";
	String sPassword = "";
	
	public LoginWindow(String sName, String sPwd){
		sUserName = sName;
		sPassword = sPwd;
		
	}
    @Override
    public void run() {
        try {
            login();
        } catch (Exception ex) {
            System.out.println("Error in Login Thread: " + ex.getMessage());
        }
    }
           
    public void login() throws Exception {
       
        Thread.sleep(5000);
       
        Robot rb = new Robot();

        //Enter user name by ctrl-v
        StringSelection username = new StringSelection(sUserName);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);            
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);

        //tab to password entry field
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        //Enter password by ctrl-v
        StringSelection pwd = new StringSelection(sPassword);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
       
        //press enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
       
        //wait
        Thread.sleep(5000);
    }                         
}

