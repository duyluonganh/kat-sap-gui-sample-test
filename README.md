#Katalon SAP GUI Client sample project

##Prequiresites:
- Katalon Studio v7+
- WinAppDriver 1.1+
- SAP Scripting Tracker: https://tracker.stschnell.de/
- Enabling SAP Scripting mode: https://help.sap.com/viewer/8ecea00c1f854fd0a433c4aef5da1ea2/Cloud/en-US/001675913cc54719930aa8197478dcde.html

###Login
- Open Profiles/default and change the username and password for your SAP account.

##How to record test script using Scripting Tracker
- Create new test case and copy the script content from Common/TestCaseTemplate
- Start SAPLogon and login
- Start Scripting Tracker and start recording
- Stop recording then copy and paste the content from Scripting Tracker into the test case script