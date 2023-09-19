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
import java.util.Random

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.demoBlazeURL)

WebUI.click(findTestObject('Sign Up/a_Sign up'))

// Function to generate a random string of specified length
def generateRandomString(int length) {
	def chars = ('ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789').toCharArray()
	def random = new Random()
	def sb = new StringBuilder()

	(0..length - 1).each {
		sb.append(chars[random.nextInt(chars.length)])
	}

	return sb.toString()
}

// Generate a random username
def randomUsername = generateRandomString(8)

// Generate a random password
def randomPassword = generateRandomString(10)

WebUI.setText(findTestObject('Sign Up/input_Username'), randomUsername)

WebUI.setText(findTestObject('Sign Up/input_Password'), randomPassword)

WebUI.click(findTestObject('Sign Up/button_Sign up'))

WebUI.navigateToUrl(GlobalVariable.demoBlazeURL)
