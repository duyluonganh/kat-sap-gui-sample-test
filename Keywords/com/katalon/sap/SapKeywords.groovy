package com.katalon.sap

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import com.jacob.activeX.*;
import com.jacob.com.*;

public class SapKeywords {

	private static ActiveXComponent session;

	@Keyword
	def static startSAPSession() {
		ComThread.InitSTA();

		ActiveXComponent SAPROTWr, GUIApp, Connection, obj;
		Variant[] arg;
		Dispatch ROTEntry;
		Variant ScriptEngine;
		String cnt = "0";

		SAPROTWr = new ActiveXComponent("SapROTWr.SapROTWrapper");
		ROTEntry = SAPROTWr.invoke("GetROTEntry", "SAPGUI").toDispatch();
		//-Set application = SapGuiAuto.GetScriptingEngine----------------
		ScriptEngine = Dispatch.call(ROTEntry, "GetScriptingEngine");
		GUIApp = new ActiveXComponent(ScriptEngine.toDispatch());

		session = new ActiveXComponent(
				GUIApp.invoke("findById", "con[0]/ses[0]").toDispatch()
				);
	}

	@Keyword
	static ActiveXComponent  getSession() {
		return session
	}

	@Keyword
	def static releaseSession() {
		session = null;
		ComThread.Release()
	}

	@Keyword
	def static login(String username, String password) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/txtRSYST-BNAME").toDispatch());
		obj.setProperty("text", "BPINST");
		obj = new ActiveXComponent(session.invoke("findById", "wnd[0]/usr/pwdRSYST-BCODE").toDispatch());
		obj.setProperty("text", "Welcome1");
		obj = new ActiveXComponent(session.invoke("findById", "wnd[0]").toDispatch());
		obj.invoke("sendVKey", 0);
	}

	@Keyword
	def static getElementProperty(String locator, String propertyName) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", locator).toDispatch());
		return obj.getProperty(propertyName).toJavaObject()
	}

	@Keyword
	def static invokeElementAction(String locator, String action) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", locator).toDispatch());
		obj.invoke(action)
	}

	@Keyword
	def static invokeElementAction(String locator, String action, String args) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", locator).toDispatch());
		obj.invoke(action, args)
	}

	@Keyword
	def static setText(String locator, String text) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", locator).toDispatch());
		obj.setProperty('text', text)
	}

	@Keyword
	def static click(String locator) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", locator).toDispatch());
		obj.invoke('press')
	}
	
	@Keyword
	def static sendKey(String locator, int key) {
		def obj;
		obj = new ActiveXComponent(session.invoke("findById", locator).toDispatch());
		obj.invoke('sendVKey', key)
	}
}
