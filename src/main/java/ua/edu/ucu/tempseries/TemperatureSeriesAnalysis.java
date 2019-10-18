package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    public static final int MIN_TEMPERATURE_VALUE = -273;
    public static final double ZERO_TO_COMPARE_DOUBLES = 0.000000001;
    private double[] temperatures;

    public TemperatureSeriesAnalysis(double[] temperature) {
        setTemperatures(temperature);
    }

    public double[] getTemperatures() {
        return new TemperatureSeriesAnalysis(this.temperatures).temperatures;
    }

    public void setTemperatures(double[] temperature) {
        this.temperatures = new double[temperature.length];
        for (int i = 0; i < temperature.length; i++) {
            if (temperature[i] < MIN_TEMPERATURE_VALUE) {
                this.temperatures = new double[0];
                throw new InputMismatchException();
            }
            this.temperatures[i] = temperature[i];
        }
    }


    public double average() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < temperatures.length; i++) {
            sum += temperatures[i];
        }
        return sum/temperatures.length;
    }

    public double deviation() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double tempAverage = average();
        double sumOfDeviations = 0;
        for (int i = 0; i < temperatures.length; i++) {
            sumOfDeviations += (temperatures[i] - tempAverage)
                    * (temperatures[i] - tempAverage);
        }
        return Math.sqrt(sumOfDeviations/temperatures.length);
    }

    public double min() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double minimum = temperatures[0];
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] < minimum) {
                minimum = temperatures[i];
            }
        }
        return minimum;
    }

    public double max() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double maximum = MIN_TEMPERATURE_VALUE;
        for (int i = 0; i < temperatures.length; i++) {
            if (maximum < temperatures[i]) {
                maximum = temperatures[i];
            }
        }
        return maximum;
    }

    public double findTempClosestToZero() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestTemp = temperatures[0];
        for (int i = 1; i < temperatures.length; i++) {
            if (Math.abs(closestTemp) > Math.abs(temperatures[i])) {
                closestTemp = temperatures[i];
            } else if (Math.abs(Math.abs(closestTemp)
                    - Math.abs(temperatures[i]))
                    < ZERO_TO_COMPARE_DOUBLES
                    && temperatures[i] != closestTemp) {
                closestTemp = Math.abs(closestTemp);
            }
        }
        return closestTemp;
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestToValue = temperatures[0];
        for (int i = 1; i < temperatures.length; i++) {
            if (Math.abs(temperatures[i] - tempValue)
                    < Math.abs(closestToValue - tempValue)) {
                closestToValue = temperatures[i];
            } else if (Math.abs(Math.abs(temperatures[i] - tempValue)
                    - Math.abs(closestToValue - tempValue))
                    < ZERO_TO_COMPARE_DOUBLES
                    && closestToValue < temperatures[i]) {
                closestToValue = temperatures[i];
            }
        }
        return closestToValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] tempsLessThenValue = new double[temperatures.length];
        int curIndex = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] < tempValue) {
                tempsLessThenValue[curIndex] = temperatures[i];
                curIndex += 1;
            }
        }
        return tempsLessThenValue;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] tempsGreaterThenValue = new double[temperatures.length];
        int curIndex = 0;
        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] > tempValue) {
                tempsGreaterThenValue[curIndex] = temperatures[i];
                curIndex += 1;
            }
        }
        return tempsGreaterThenValue;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(average(), deviation(), min(), max());
    }

    public int addTemps(double... temps) {
        double[] newTemp = new double[temperatures.length + temps.length];
        for (int i = 0; i < temperatures.length + temps.length; i++) {
            if (i < temperatures.length) {
                newTemp[i] = temperatures[i];
            } else {
                newTemp[i] = temps[i-temperatures.length];
            }
        }
        setTemperatures(newTemp);
        return temperatures.length;
    }
}
