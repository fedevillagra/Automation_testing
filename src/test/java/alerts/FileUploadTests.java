package alerts;

import base.BaseTests;
import com.epam.automation.pages.FileUploadPage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTests extends BaseTests {
    FileUploadPage fileUpload;

    @Test
    public void testFileUpload(){
        fileUpload = homePage.clickFileUpload();
        String filePath = "C:\\Users\\federico_villagra\\Desktop\\Projects\\webdriver_java\\src\\main\\resources\\ejercicios_sql_resueltos.sql";
        fileUpload.uploadFile(filePath);
        assertEquals(fileUpload.getUploadedFileName(),"ejercicios_sql_resueltos.sql", "Uploaded file name is not as expected");
    }
}
