package teamred;


import java.util.*;

public class OddTest {
    
    @DriverTest
    void dataSetRecords(){
        // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(30, 22.0, 0, 2000.0, "northwest", "no","male"),
            new InsuranceRecord(40, 28.0, 1, 3000.0, "southeast", "yes", "female"),
            new InsuranceRecord(50, 35.0, 2, 4000.0, "southwest", "no", "male")
        );
        // Act
        List<InsuranceRecord> result = InsuranceProblems.getFirstNRecords(records, 2);
        // Assert
        assertEquals(2, result.size());
        assertEquals(20, result.get(0).age);
        assertEquals(30, result.get(1).age);

    }

    @DriverTest
    public void testHorizontalHistogram(){
         // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(30, 22.0, 0, 2000.0, "northwest", "no","male"),
            new InsuranceRecord(40, 28.0, 1, 3000.0, "southeast", "yes", "female"),
            new InsuranceRecord(50, 35.0, 2, 4000.0, "southwest", "no", "male")
        );

        // Act
        String histogram = InsuranceProblems.horizontalAgeHistogram(records);

        // Assert
        assertTrue(histogram.contains("20: **"));
        assertTrue(histogram.contains("30: *"));
    }


    

    
}
