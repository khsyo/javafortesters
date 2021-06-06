package com.javafortesters.chap015randomData;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class randomData {
    // java.util.random - most of the automation code can be achieve through this one
    // Math.random

    @Test
    public void testMathRandom() {
        double rnd = Math.random();

        System.out.println(
                String.format("generated %f as random number", rnd)
        );

        assertThat(rnd < 1.0d, is(true));
        assertThat(rnd >= 0.0d, is(true));
    }

    @Test
    public void useJavaUtilRandom(){
        Random generate = new Random();

        boolean randomBoolean = generate.nextBoolean();
        int randomInt = generate.nextInt();
        int randomIntRange = generate.nextInt(12);
        long randomLong = generate.nextLong();
        double randomDouble = generate.nextDouble();
        double randomGaussian = generate.nextGaussian();
        byte[] bytes = new byte[generate.nextInt(100)];
        generate.nextBytes(bytes);
    }

    @Test
    public void canGenerateRandomInt(){
        Random generate = new Random();

        int randomInt;

        Set numberSet = new HashSet<Integer>();

        Set comparedSet = new HashSet<Integer>();
        comparedSet.add(15);
        comparedSet.add(16);
        comparedSet.add(17);
        comparedSet.add(18);
        comparedSet.add(19);
        comparedSet.add(20);


        for(int i = 0; i < 1000; i++) {
            randomInt = generate.nextInt(20 - 15 + 1) + 15;

            System.out.println(randomInt);
            assertThat(randomInt <= 20, is(true));
            assertThat(randomInt >= 15, is(true));
            numberSet.add(randomInt);
        }
        assertThat(numberSet, is(comparedSet));
    }

    @Test
    public void canGenerateRandomBoolean(){
        Random generate = new Random();

        int countTrue = 0;
        int countFalse = 0;

        for (int i = 0; i < 1000; i++) {
            boolean randomBoolean = generate.nextBoolean();
            if(randomBoolean) {
                countTrue++;
            } else {
                countFalse++;
            }
        }
        assertThat(countTrue + countFalse, is(1000));
    }

    private double calculateListAverage(List <Double> inputList){
        double sum = 0;
        if(!inputList.isEmpty())
        for(double num : inputList) {
            sum += num;
        }

        return sum/inputList.size();
    }

    @Test
    public void canGenerateGaussianRandom(){
        Random generate = new Random();

        int stdCount1 = 0;
        int stdCount2 = 0;
        int stdCount3 = 0;
        int stdCount4 = 0;

        for(int i = 0; i < 1000; i++){
            double randomGaussian = generate.nextGaussian();

            if(randomGaussian > -1.0d && randomGaussian < 1.0d) {
                stdCount1++;
            }

            if(randomGaussian > -2.0d && randomGaussian < 2.0d) {
                stdCount2++;
            }

            if(randomGaussian > -3.0d && randomGaussian < 3.0d) {
                stdCount3++;
            }

            if(randomGaussian > -4.0d && randomGaussian < 4.0d) {
                stdCount4++;
            }
        }

        float sd1percentage = (stdCount1/1000f) * 100f;
        System.out.println("about 70% one standard deviation = " + sd1percentage);

        float sd2percentage = (stdCount2/1000f) * 100f;
        System.out.println("about 95% one standard deviation = " + sd2percentage);

        float sd3percentage = (stdCount3/1000f) * 100f;
        System.out.println("about 99% one standard deviation = " + sd3percentage);

        float sd4percentage = (stdCount4/1000f) * 100f;
        System.out.println("about 99.9% one standard deviation = " + sd4percentage);

    }

    @Test
    public void countAgeOf35(){
        Random generate = new Random();

        Map<Integer, Integer> ageMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < 1000; i++){
            int age = (int) (generate.nextGaussian() * 5) + 35;

            int ageCount = 0;
            if(ageMap.containsKey(age)) {
                ageCount = ageMap.get(age);
            }
            ageCount++;
            ageMap.put(age, ageCount);
        }

        SortedSet<Integer> agesSorted = new TreeSet(ageMap.keySet());

        for(int age : agesSorted) {
            System.out.println(age + " : " + ageMap.get(age));
        }
    }

    @Test
    public void testSeeding(){
        Random generate = new Random(1234567L);

        assertThat(generate.nextInt(), is(1042961893));
        assertThat(generate.nextLong(), is(-6749250865724111202L));
        assertThat(generate.nextDouble(), is(0.44762832574617084));
        assertThat(generate.nextGaussian(), is(-0.11571220872310763));
        assertThat(generate.nextFloat(), is(0.33144182F));
        assertThat(generate.nextBoolean(), is(false));
    }

    @Test
    public void generateRandomStrings(){
        Random generate = new Random(1234567L);
        String validValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder results = new StringBuilder();

        for(int i = 0; i < 100; i++) {
            int rndIndex = generate.nextInt(validValues.length());
            char rChar = validValues.charAt(rndIndex);

            results.append(rChar);
        }
        assertThat(results.length(), is(100));
        assertThat(results.toString().matches("[A-Z]+"), is(true));
        System.out.println(results.toString());
    }
}
