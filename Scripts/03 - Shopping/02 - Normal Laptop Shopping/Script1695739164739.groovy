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
import org.openqa.selenium.WebElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('02 - Login/01 - Normal Login'), [:], FailureHandling.STOP_ON_FAILURE)

TestData data = findTestData('Data Files/Shopping/Laptop Product')

WebUI.scrollToPosition(0, 400)

WebUI.click(findTestObject('Shopping/category_Laptops'))

for (int i = 1; i <= data.getRowNumbers(); i++) {
	
	def laptopProduct = data.getValue('laptop_product', i)
	
	boolean foundProduct = false
	
	// Check if the desired object is present on the first page
	def desiredProductFirstPage = WebUI.verifyElementPresent(findTestObject('Shopping/select_product', [('product') : laptopProduct]), 5, FailureHandling.OPTIONAL)
	
	if (desiredProductFirstPage != null) {
		WebUI.click(findTestObject('Shopping/category_Laptops'))
		
		WebUI.click(findTestObject('Shopping/select_product', [('product') : laptopProduct]))
		
		foundProduct = true
	
	} else {
		
		WebUI.click(findTestObject('Shopping/category_Laptops'))
		
		WebUI.click(findTestObject('Shopping/button_Next'))
		
		def desiredProductSecondPage = WebUI.verifyElementPresent(findTestObject('Shopping/select_product', [('product') : laptopProduct]), 5, FailureHandling.OPTIONAL)
		
		if (desiredProductSecondPage != null) {
			// If the desired object is not present, click "Next" and then click the product
			
			WebUI.click(findTestObject('Shopping/select_product', [('product') : laptopProduct]))
			
			foundProduct = true
		}
	}
	
	if (foundProduct) {
        WebUI.click(findTestObject('Shopping/a_Add to cart'))
		
        WebUI.click(findTestObject('Shopping/a_Product Store'))
		
    } else {
		
        KeywordUtil.logInfo("Product '$laptopProduct' not found.")
		
    }
}