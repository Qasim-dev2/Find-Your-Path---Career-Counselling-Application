
package com.example.frontend_of_project;

public class TestResult {
    int iqscore;
    double testscore;

    public TestResult(int iqscore, double testscore) {
        this.iqscore = iqscore;
        this.testscore = testscore;

    }

    public  double accumulativeResult()
    {

        return ( iqscore) + ( testscore);
    }







}
