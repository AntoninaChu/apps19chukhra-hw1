package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }
    
    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.7416573867739413;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.deviation();
    }

    @Test(expected = InputMismatchException.class)
    public void testSetTemperatures() {
        double[] temperatureSeries = {3.0, 5.0, -4.0, -274.0, 345.0};
        // expect exception here
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.min();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.max();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {30.0, -5.0, 10.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {6.0, 1.0, -5.0, 3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 3.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(2.0);

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempClosestToValue(9.0);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {6.0, 1.0, -5.0, 3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[5];
        expResult[0] = 1.0;
        expResult[1] = -5.0;
        double[] actualResult = seriesAnalysis.findTempsLessThen(2.0);

        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsLessThen(3.0);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {6.0, 1.0, -5.0, 3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = new double[5];
        expResult[0] = 6.0;
        expResult[1] = 3.0;
        expResult[2] = 5.0;
        double[] actualResult = seriesAnalysis.findTempsGreaterThen(2.0);

        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.findTempsGreaterThen(3.0);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics expResult = new TempSummaryStatistics(1.0, 3.7416573867739413, -5.0, 5.0);

        TempSummaryStatistics actualResult = seriesAnalysis.summaryStatistics();

        assertTrue(expResult.getAvgTemp() == actualResult.getAvgTemp() &&
                expResult.getDevTemp() == actualResult.getDevTemp() &&
                expResult.getMaxTemp() == actualResult.getMaxTemp() &&
                expResult.getMinTemp() == actualResult.getMinTemp());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testGetTemperatures() {
        double[] temperatureSeries = {6.0, 1.0, -5.0, 3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {6.0, 1.0, -5.0, 3.0, 5.0};
        double[] actualResult = seriesAnalysis.getTemperatures();

        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }

    @Test
    public void testAddTemperatures() {
        double[] temperatureSeries = {6.0, 1.0, -5.0, 3.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] toAdd = {456.0, 222.0, 27.0};
        double[] expResult = {6.0, 1.0, -5.0, 3.0, 5.0, 456.0, 222.0, 27.0};
        seriesAnalysis.addTemps(toAdd);
        double[] actualResult = seriesAnalysis.getTemperatures();
        assertEquals(Arrays.toString(expResult), Arrays.toString(actualResult));
    }
}
