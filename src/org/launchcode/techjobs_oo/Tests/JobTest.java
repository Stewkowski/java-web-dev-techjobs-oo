package org.launchcode.techjobs_oo.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs_oo.*;

public class JobTest {

    Job jobOne;
    Job jobTwo;
    Job jobThree;
    Job jobFour;
    Job jobFive;
    Job jobSix;

    @Before
    public void createCar() {

        jobOne = new Job();
        jobTwo = new Job();
        jobThree = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        jobFour = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"),
                new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        jobFive = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"),
                new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        jobSix = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));
    }

    @Test
    public void testSettingJobId(){

        assertTrue(jobTwo.getId() == jobOne.getId()+1 && jobThree.getId() == jobTwo.getId()+1);

    }

    @Test
    public void testJobConstructorSetsAllFields() {

        assertTrue(jobThree.getEmployer() instanceof Employer);
        assertTrue(jobThree.getEmployer().getValue().equals("ACME"));

        assertTrue(jobThree.getLocation() instanceof Location);
        assertTrue(jobThree.getLocation().getValue().equals("Desert"));

        assertTrue(jobThree.getPositionType() instanceof PositionType);
        assertTrue(jobThree.getPositionType().getValue().equals("Quality control"));

        assertTrue(jobThree.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(jobThree.getCoreCompetency().getValue().equals("Persistence"));
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(jobFour.equals(jobFive));
}

    @Test
    public void testToStringOne(){
        assertTrue(jobThree.toString().substring(0,1).equals("\n"));
        assertTrue(jobThree.toString().substring(jobThree.toString().length()-1).equals("\n"));
        //System.out.println(jobThree.toString());
    }

    @Test
    public void testToStringTwo(){
        assertEquals("\n"+
                "ID: " + jobThree.getId() + "\n" +
                "Name: " + jobThree.getName() + "\n" +
                "Employer: " + jobThree.getEmployer() + "\n" +
                "Location: " + jobThree.getLocation() + "\n" +
                "Position: " + jobThree.getPositionType() + "\n" +
                "Core Competency: " + jobThree.getCoreCompetency() +
                 "\n", jobThree.toString());
    }

    @Test
    public  void testToStringThree(){
        assertEquals( "\n"+
                "ID: " + jobSix.getId() + "\n" +
                "Name: " + "Data not available" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position: " + "Data not available" + "\n" +
                "Core Competency: " + "Data not available" +
                "\n", jobSix.toString());
    }

    @Test (expected = NullPointerException.class)
    public void testToStringFour(){
        jobOne.toString();
        fail("OOPS! This job does not seem to exist.");
    }


}
