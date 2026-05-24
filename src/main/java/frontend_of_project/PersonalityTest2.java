package com.example.frontend_of_project;

import java.util.List;
import java.util.Scanner;

public class PersonalityTest2 extends Test {
    MajorField MajorField;
    static Scanner sc = new Scanner(System.in);
    Personality result;
    List<PersonalityQuestions> question;
    Personality personality;

    public PersonalityTest2() {
        super("Personality Test");
        this.question = PersonalityQuestions.personalityQuestions();

    }


    @Override
    public void startTest() {

        System.out.println("U r going to take Personality test");
        int analytical = 0;
        int creative = 0;
        int social = 0;
        int enterprising = 0;
        int investigative = 0;


        for (int i = 0; i < question.size(); i++) {

            System.out.println("Q no " + (i + 1) + " " + question.get(i).questionText);
            System.out.println(question.get(i).personality);
            System.out.println(question.get(i).options);
            System.out.println("1 for yes and 0 for No");

            int answer = sc.nextInt();
            if (answer == 1) {
                switch (question.get(i).personality) {
                    case Personality.ENTERPRISING:
                        enterprising++;
                        break;
                    case Personality.ANALYTICAL:
                        creative++;
                        break;
                    case Personality.INVESTIGATIVE:
                        analytical++;
                        break;
                    case Personality.SOCIAL:
                        investigative++;
                        break;
                    case Personality.CREATIVE:
                        social++;
                        break;
                }
            }

        }

        int maxScore = Math.max(Math.max(Math.max(analytical, creative),
                Math.max(enterprising, investigative)), social);
        if (maxScore == analytical) {
            personality = Personality.ANALYTICAL;
            result = Personality.ANALYTICAL;
        } else if (maxScore == creative) {
            personality = Personality.CREATIVE;
            result = Personality.CREATIVE;
        } else if (maxScore == enterprising) {
            personality = Personality.ENTERPRISING;
            result = Personality.ENTERPRISING;
        } else if (maxScore == investigative) {
            personality = Personality.INVESTIGATIVE;
            result = Personality.INVESTIGATIVE;
        } else {
            personality = Personality.SOCIAL;
            result = Personality.SOCIAL;
        }

        System.out.println("Your personality type is: " + result);

        System.out.println();



    }

    @Override
    public int calculateScore(int correctScore) {
        return 0;
    }

        public void suggestMedicalJob(MedicalSubField medicalSubfield, Personality personality) {

            {
                if (medicalSubfield == MedicalSubField.MBBS) {

                    if (personality == Personality.ANALYTICAL || personality == Personality.INVESTIGATIVE) {
                        System.out.println("Suggested Job: Specialist Doctor (e.g., Cardiologist, Neurologist)");
                    } else if (personality == Personality.SOCIAL || personality == Personality.ENTERPRISING) {
                        System.out.println("Suggested Job: General Practitioner or Medical Director");
                    } else {
                        System.out.println("Suggested Job: Medical Officer");
                    }
                }


                if (medicalSubfield == MedicalSubField.BDS) {
                    if (personality == Personality.CREATIVE) {
                        System.out.println("Suggested Job: Cosmetic Dentist");
                    } else if (personality == Personality.ANALYTICAL) {
                        System.out.println("Suggested Job: Orthodontist or Prosthodontist");
                    } else {
                        System.out.println("Suggested Job: General Dentist");
                    }
                }
                if (medicalSubfield == MedicalSubField.DPt) {
                    if (personality == Personality.SOCIAL) {
                        System.out.println("Suggested Job: Rehabilitation Specialist or Physiotherapist");
                    } else if (personality == Personality.INVESTIGATIVE) {
                        System.out.println("Suggested Job: Researcher in Physical Therapy");
                    } else {
                        System.out.println("Suggested Job: General Physical Therapist");
                    }
                }

                if (medicalSubfield == MedicalSubField.PHARMACY)
                {
                    if (personality == Personality.ANALYTICAL) {
                        System.out.println("Suggested Job: Clinical Pharmacist or Drug Development Specialist");
                    } else if (personality == Personality.ENTERPRISING) {
                        System.out.println("Suggested Job: Pharmacy Manager or Pharmaceutical Sales Expert");
                    } else {
                        System.out.println("Suggested Job: Community Pharmacist");
                    }
                }

                if(medicalSubfield == MedicalSubField.NURSING) {
                    if (personality == Personality.SOCIAL) {
                        System.out.println("Suggested Job: Patient Care Nurse or Public Health Nurse");
                    } else if (personality == Personality.ENTERPRISING) {
                        System.out.println("Suggested Job: Nurse Manager or Administrator");
                    } else {
                        System.out.println("Suggested Job: General Nurse");
                    }

                }
                if(medicalSubfield == MedicalSubField.DIPLOMA) {
                    if (personality == Personality.SOCIAL) {
                        System.out.println("Suggested Job: Community Health Worker or Medical Assistant");
                    } else if (personality == Personality.ANALYTICAL) {
                        System.out.println("Suggested Job: Lab Technician");
                    } else {
                        System.out.println("Suggested Job: General Diploma Holder in Medical Fields");
                    }
                }

            }
        }


    public void suggestEngineeringJob(EngineeringSubField engineeringSubfield, Personality personality) {
        if (engineeringSubfield == EngineeringSubField.COMPUTER_SCIENCE) {
            if (personality == Personality.ANALYTICAL || personality == Personality.INVESTIGATIVE) {
                System.out.println("Suggested Job: Software Engineer or Data Scientist");
            } else if (personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: UI/UX Designer or Game Developer");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Tech Startup Founder or Project Manager");
            } else {
                System.out.println("Suggested Job: IT Specialist");
            }
        }

        if (engineeringSubfield == EngineeringSubField.ELECTRICAL_ENGINEERING) {
            if (personality == Personality.ANALYTICAL) {
                System.out.println("Suggested Job: Power Systems Engineer or Circuit Design Engineer");
            } else if (personality == Personality.INVESTIGATIVE) {
                System.out.println("Suggested Job: Research Engineer in Electronics");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Project Manager in Electrical Engineering");
            } else {
                System.out.println("Suggested Job: General Electrical Engineer");
            }
        }

        if (engineeringSubfield == EngineeringSubField.CIVIL_ENGINEERING) {
            if (personality == Personality.ANALYTICAL || personality == Personality.INVESTIGATIVE) {
                System.out.println("Suggested Job: Structural Engineer or Urban Planner");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Construction Manager");
            } else if (personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: Architectural Engineer");
            } else {
                System.out.println("Suggested Job: General Civil Engineer");
            }
        }

        if (engineeringSubfield == EngineeringSubField.DIPLOMAS) {
            if (personality == Personality.SOCIAL) {
                System.out.println("Suggested Job: Technical Support Specialist or Field Technician");
            } else if (personality == Personality.ANALYTICAL) {
                System.out.println("Suggested Job: Lab Technician or CAD Specialist");
            } else {
                System.out.println("Suggested Job: General Diploma Holder in Engineering Fields");
            }
        }

        if (engineeringSubfield == EngineeringSubField.INDUSTRIAL_ENGINEERING) {
            if (personality == Personality.ANALYTICAL) {
                System.out.println("Suggested Job: Operations Analyst or Quality Control Engineer");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Production Manager or Supply Chain Manager");
            } else if (personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: Process Design Engineer");
            } else {
                System.out.println("Suggested Job: General Industrial Engineer");
            }
        }
    }


    public void suggestArtsJob(ArtsSubField artsSubfield, Personality personality) {
        if (artsSubfield == ArtsSubField.FINE_ARTS) {
            if (personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: Painter, Sculptor, or Digital Artist");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Art Director or Gallery Manager");
            } else {
                System.out.println("Suggested Job: Art Teacher or Craft Specialist");
            }
        }

        if (artsSubfield == ArtsSubField.ARCHITECTURE) {
            if (personality == Personality.ANALYTICAL || personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: Architect or Urban Designer");
            } else if (personality == Personality.INVESTIGATIVE) {
                System.out.println("Suggested Job: Architectural Researcher");
            } else {
                System.out.println("Suggested Job: Interior Designer or CAD Specialist");
            }
        }

        if (artsSubfield == ArtsSubField.LITERATURE) {
            if (personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: Novelist, Poet, or Screenwriter");
            } else if (personality == Personality.SOCIAL) {
                System.out.println("Suggested Job: Editor, Teacher, or Public Speaker");
            } else if (personality == Personality.INVESTIGATIVE) {
                System.out.println("Suggested Job: Literary Critic or Researcher");
            } else {
                System.out.println("Suggested Job: Freelance Writer");
            }
        }

        if (artsSubfield == ArtsSubField.MEDIA_STUDIES) {
            if (personality == Personality.CREATIVE) {
                System.out.println("Suggested Job: Filmmaker, Graphic Designer, or Content Creator");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Media Manager or Advertising Executive");
            } else if (personality == Personality.SOCIAL) {
                System.out.println("Suggested Job: Journalist or TV Anchor");
            } else {
                System.out.println("Suggested Job: General Media Professional");
            }
        }

        if (artsSubfield == ArtsSubField.PSYCHOLOGY) {
            if (personality == Personality.SOCIAL) {
                System.out.println("Suggested Job: Clinical Psychologist or Counselor");
            } else if (personality == Personality.INVESTIGATIVE) {
                System.out.println("Suggested Job: Research Psychologist or Neuropsychologist");
            } else if (personality == Personality.ENTERPRISING) {
                System.out.println("Suggested Job: Organizational Psychologist or HR Specialist");
            } else {
                System.out.println("Suggested Job: General Psychologist");
            }
        }
    }
}

