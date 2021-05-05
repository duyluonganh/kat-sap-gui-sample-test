import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.jacob.activeX.ActiveXComponent
import com.jacob.com.Variant
import com.katalon.sap.SapKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Common/StartSapLogon'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/Login'), [:], FailureHandling.STOP_ON_FAILURE)

ActiveXComponent obj;
Variant[] arg;
def session = SapKeywords.getSession()

obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/cntlIMAGE_CONTAINER/shellcont/shell/shellcont[0]/shell").toDispatch());
obj.setProperty("selectedNode", "0000000003");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/cntlIMAGE_CONTAINER/shellcont/shell/shellcont[0]/shell").toDispatch());
obj.invoke("doubleClickNode", "0000000003");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/cntlIMAGE_CONTAINER/shellcont/shell/shellcont[0]/shell").toDispatch());
obj.setProperty("selectedNode", "0000000116");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/cntlIMAGE_CONTAINER/shellcont/shell/shellcont[0]/shell").toDispatch());
obj.invoke("doubleClickNode", "0000000116");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/ctxtS_MSGTP-HIGH").toDispatch());
obj.setProperty("text", "C");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/ctxtS_MSGTP-HIGH").toDispatch());
obj.invoke("setFocus");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/ctxtS_MSGTP-HIGH").toDispatch());
obj.setProperty("caretPosition", 1);
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]").toDispatch());
obj.invoke("sendVKey", 0);

obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/txtS_FLNAM-LOW").toDispatch());
obj.invoke("setFocus");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/txtS_FLNAM-LOW").toDispatch());
obj.setProperty("caretPosition", 0);
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/tbar[1]/btn[18]").toDispatch());
obj.invoke("press");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/tbar[1]/btn[20]").toDispatch());
obj.invoke("press");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/ctxtS_RCVID-LOW").toDispatch());
obj.setProperty("text", "20");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/ctxtS_RCVID-LOW").toDispatch());
obj.invoke("setFocus");
obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/ctxtS_RCVID-LOW").toDispatch());
obj.setProperty("caretPosition", 2);