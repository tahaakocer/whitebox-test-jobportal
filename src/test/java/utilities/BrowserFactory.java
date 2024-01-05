package utilities;

import java.io.IOException;

import org.junit.Test;

public class BrowserFactory {
	public static Integer port = 9222;
	public static String commandRun;
	final static private String cmd = "cmd.exe";
	final static private String parameter = "/c";

	public BrowserFactory() {
		commandRun = "chrome.exe -remote-debugging-port=" + port + " --user-data-dir=\"C:\\Selenium\\Chrome1\"";
	}

	@Test
	public void runBrowser() {
		ProcessBuilder debuggerBuilder;
		Process process;
		try {
			debuggerBuilder = new ProcessBuilder(cmd, parameter, commandRun);
			process = debuggerBuilder.start();
			System.out.println("chrome.exe debugger mod'ta baslatildi. port=" + port);
			WaitMethods.bekle(2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
