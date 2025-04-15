package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickDropdown();

        String option = "Option 1";
        dropDownPage.selectFromDropdown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1,"Wrong number of selected options");
        assertTrue(selectedOptions.contains(option),"Wrong option selected");
    }
}
