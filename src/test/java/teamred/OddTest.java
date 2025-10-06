package teamred;


import java.util.*;

public class OddTest {
    
    @DriverTest
    void testDataSetRecords(){
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
            new InsuranceRecord(20, 22.0, 0, 2000.0, "northwest", "no","male"),
            new InsuranceRecord(20, 28.0, 1, 3000.0, "southeast", "yes", "female"),
            new InsuranceRecord(30, 35.0, 2, 4000.0, "southwest", "no", "male")
        );

        // Act
        String histogram = InsuranceProblems.horizontalAgeHistogram(records);

        // Assert
        assertTrue(histogram.contains("20: **"));
        assertTrue(histogram.contains("30: *"));
    }
    @DriverTest
    public void testCountByChildren(){
        // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(20, 22.0, 1, 2000.0, "northwest", "no","male"),
            new InsuranceRecord(30, 28.0, 1, 3000.0, "southeast", "yes", "female"),
            new InsuranceRecord(40, 35.0, 2, 4000.0, "southwest", "no", "male")
        );

        // Act
        Map<Integer, Integer> result = InsuranceProblems.countByChildren(records);

        // Assert
        assertEquals(2, result.get(1));
        assertEquals(1, result.get(2));

    }
    @DriverTest
    public void testIsBMIRangeChargesHigher(){
        // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(20, 35.0, 0, 2000.0, "northwest", "no","male"),
            new InsuranceRecord(25, 36.0, 1, 4500.0, "southeast", "yes", "female"),
            new InsuranceRecord(30, 20.0, 1, 4000.0, "southwest", "no", "male")
        );
        // Act
        boolean result = InsuranceProblems.isBmiRangeChargesHigher(records);

        // Assert
        assertTrue(result);
    }
    @DriverTest
    public void testDoSmokersHaveHigherCharges(){
        // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(20, 22.0, 0, 1000.0, "northwest", "no","male"),
            new InsuranceRecord(30, 25.0, 1, 5000.0, "southeast", "yes", "female")
        );

        // Act
        boolean result = InsuranceProblems.doSmokersHaveHigherCharges(records); 

        // Assert
        assertTrue(result);
    }
   @DriverTest
   public void testPearsonCorrelationChargesChildren(){
        // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(20, 22.0, 0, 1000.0, "northwest", "no","male"),
            new InsuranceRecord(30, 25.0, 1, 2000.0, "southeast", "yes", "female"),
            new InsuranceRecord(40, 28.0, 2, 3000.0, "southwest", "no", "male")
        );
        // Act
        double result = InsuranceProblems.pearsonCorrelationChargesChildren(records);

        // Assert
        assertTrue(result > 0);
   }
    @DriverTest
    public void testIsRegionFair(){
        // Arrange
        List<InsuranceRecord> records = Arrays.asList(
            new InsuranceRecord(20, 22.0, 0, 1000.0, "northwest", "no","male"),
            new InsuranceRecord(30, 25.0, 1, 2000.0, "southeast", "yes", "female"),
            new InsuranceRecord(40, 28.0, 2, 3000.0, "southwest", "no", "male"),
            new InsuranceRecord(50, 30.0, 3, 4000.0, "northeast", "yes", "female"),
        );
        // Act
        boolean result = InsuranceProblems.isRegionFair(records);
        // Assert
        assertTrue(result);

    
}
