package com.electricity.seller.enums;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ETokenStatusTest {

    @Test
    public void testEnumValues(){
        boolean ETokenStatusTestHasRequiredValues = false;
        String expectedValue1 = "USED";
        String expectedValue2 = "NOTUSED";

        ETokenStatus values[] = ETokenStatus.values();

        if( ! (expectedValue1.equals(values[0]) || (expectedValue2.equals(values[1]) ))){
            ETokenStatusTestHasRequiredValues = true;
        }

        assertEquals(true, ETokenStatusTestHasRequiredValues, "EToken Status should have USED and NOTUSED as Values");
    }
}
