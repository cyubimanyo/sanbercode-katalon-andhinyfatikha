import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.demoBlazeURL)

WebUI.click(findTestObject('Sign Up/a_Sign up'))

def username = 'lihat.langit'
def password = 'Test123!'

// Case: Without username and password

WebUI.click(findTestObject('Sign Up/button_Sign up'))
	
WebUI.acceptAlert()

// Case: Without username

WebUI.setText(findTestObject('Sign Up/input_Password'), password)

WebUI.click(findTestObject('Sign Up/button_Sign up'))

WebUI.acceptAlert()
	
// Case: Without password
WebUI.setText(findTestObject('Sign Up/input_Username'), username)

WebUI.delay(3)

WebUI.clearText(findTestObject('Sign Up/input_Password'))

WebUI.delay(3)

WebUI.click(findTestObject('Sign Up/button_Sign up'))

WebUI.acceptAlert()

WebUI.navigateToUrl(GlobalVariable.demoBlazeURL)

