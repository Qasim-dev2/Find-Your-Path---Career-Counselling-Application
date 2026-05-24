package com.example.frontend_of_project;


public class Career {



    public Career() {
    }




    public static String suggestFieldBefore10(double accumulativeResult) {
        if (accumulativeResult > 80.0) {
            return "Highly Recommended";
        } else if (accumulativeResult > 50 && accumulativeResult < 80.0) {
            return "Can Go . Have to Struggle";
        } else {
            return "Give Another Try";
        }

    }


    public static void suggestFieldBefore12(double testScore) {

        if (testScore > 80) {
            System.out.println("Eligible");
        } else if (testScore < 80 && testScore > 50) {
            System.out.println("Recommended but have to Work Hard");
        } else  {
            System.out.println("Not eligible, Might Consider Any Other");

        }
    }



    public static MedicalSubField suggestMedicalField(double merit)
    {
        if (merit >= 90 && merit <= 100) {
            return MedicalSubField.MBBS;
        } else if (merit >= 85 && merit <= 89) {

            return MedicalSubField.BDS;
        } else if (merit >= 75 && merit <= 84) {

            return MedicalSubField.DPt;
        } else if (merit >= 60 && merit <= 74) {

            return MedicalSubField.PHARMACY;
        } else if (merit >= 50 && merit <= 59) {

            return MedicalSubField.NURSING;
        } else {

            return MedicalSubField.DIPLOMA;
        }
    }


    public static EngineeringSubField suggestEngineeringField(double merit) {
        if (merit >= 90 && merit <= 100) {
            return EngineeringSubField.COMPUTER_SCIENCE;
        } else if (merit >= 85 && merit <= 89) {
            return  EngineeringSubField.CIVIL_ENGINEERING;
        } else if (merit >= 75 && merit <= 84) {
            return EngineeringSubField.INDUSTRIAL_ENGINEERING;
        } else if (merit >= 60 && merit <= 74) {
            return EngineeringSubField.ELECTRICAL_ENGINEERING;
        } else  {
            return EngineeringSubField.DIPLOMAS;
        }
    }


    public static ArtsSubField suggestArtsField(double merit) {
        if (merit >= 90 && merit <= 100) {

            System.out.println( "Based on your merit of " + merit + ", you are eligible for .");
            return ArtsSubField.FINE_ARTS;
        } else if (merit >= 85 && merit <= 89) {
            System.out.println( "Based on your merit of " + merit + ", you are eligible for Literature or Linguistics.");
            return ArtsSubField.LITERATURE;
        } else if (merit >= 75 && merit <= 84) {

            System.out.println("Based on your merit of " + merit + ", you are eligible for Media Studies or History.");
            return ArtsSubField.MEDIA_STUDIES;
        } else if (merit >= 60 && merit <= 74) {
            System.out.println( "Based on your merit of " + merit + ", you are eligible for Psychology, Sociology, or Education.");
            return ArtsSubField.PSYCHOLOGY;
        } else if (merit >= 50 && merit <= 59) {
            System.out.println( "Based on your merit of " + merit + ", you are eligible for diplomas in Visual Arts, Design, or other creative courses.");
            return ArtsSubField.ARCHITECTURE;
        } else {
            System.out.println( "Based on your merit of " + merit + ", you may consider basic certifications in creative arts or humanities.");
            return ArtsSubField.DIPLOMA;
        }
    }


}



