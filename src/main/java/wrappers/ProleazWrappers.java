package wrappers;

public class ProleazWrappers extends CommonWrappers {
	
	public void appLogin() throws InterruptedException {
		
		enterTextById("txtusr", "mk");
		enterTextById("txtpswd", "12345");
		clickById("btnlogin");
	}

}

/*lp.userName("txtusr", "mk");
lp.passWord("txtpswd", "12345");
lp.loginSubmit("btnlogin");*/