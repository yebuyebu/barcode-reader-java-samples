import com.dynamsoft.dbr.*;

public class HelloWorld {
	public static void main(String[] args) {
		try {
            
			// 1.Initialize license.
            // The organization id 200001 here will grant you a public trial license good for 7 days. Note that network connection is required for this license to work.
            // If you want to use an offline license, please contact Dynamsoft Support: https://www.dynamsoft.com/company/contact/
            // You can also request a 30-day trial license in the customer portal: https://www.dynamsoft.com/customer/license/trialLicense?product=dbr&utm_source=samples&package=java
			DMDLSConnectionParameters para = BarcodeReader.initDLSConnectionParameters();
			para.organizationID = "200001";
			
			BarcodeReader.initLicenseFromDLS(para);
			
		    // 2.Create an instance of Barcode Reader.
		    BarcodeReader dbr = new BarcodeReader();
		    
	        // 3.Decode barcodes from an image file.
			TextResult[] results = dbr.decodeFile("../../images/AllSupportedBarcodeTypes.png", "");
			
			// 4.Output the barcode text.
			if (results != null && results.length > 0) {
				for (int i = 0; i < results.length; i++) {
					TextResult result = results[i];
					System.out.println("Barcode " + i + ":" + result.barcodeText);
				}
			} else {
				System.out.println("No data detected.");
			}
		} catch (BarcodeReaderException ex) {
			ex.printStackTrace();
		}
	}
}
