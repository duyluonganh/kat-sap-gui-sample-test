import com.katalon.sap.SapKeywords

import internal.GlobalVariable

SapKeywords.startSAPSession()

SapKeywords.login(GlobalVariable.username, GlobalVariable.password)