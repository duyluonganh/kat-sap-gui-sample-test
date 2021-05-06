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
