package com.example.frontend_of_project;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonalityController {

    @FXML
    private Label questionLabel;

    @FXML
    private ComboBox<String> answerComboBox;

    @FXML
    private Button nextButton;

    @FXML
    private ListView<String> resultListView;

    private List<PersonalityQuestions> questions;
    private int currentIndex = 0;

    String mainField, mainsubfield;

    // Personality score idher
    private int analytical = 0;
    private int creative = 0;
    private int social = 0;
    private int enterprising = 0;
    private int investigative = 0;

    @FXML
    public void initialize() {

        questions = PersonalityQuestions.personalityQuestions();


        loadQuestion(currentIndex);
    }

    private void loadQuestion(int index) {

        PersonalityQuestions currentQuestion = questions.get(index);
        questionLabel.setText(currentQuestion.questionText);
        answerComboBox.setItems(FXCollections.observableArrayList(currentQuestion.options));
        answerComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    private void handleNextButton() {

        String selectedAnswer = answerComboBox.getValue();
        if (selectedAnswer == null) {
            showAlert("please select an option!!!!");
            return;
        }


        PersonalityQuestions currentQuestion = questions.get(currentIndex);
        if (selectedAnswer.equalsIgnoreCase("Yes")) {
            switch (currentQuestion.personality) {
                case ANALYTICAL:
                    analytical++;
                    break;
                case CREATIVE:
                    creative++;
                    break;
                case SOCIAL:
                    social++;
                    break;
                case ENTERPRISING:
                    enterprising++;
                    break;
                case INVESTIGATIVE:
                    investigative++;
                    break;
            }
        }


        currentIndex++;
        if (currentIndex < questions.size()) {
            loadQuestion(currentIndex);
        } else {
            displayResults();
        }
    }



    private void displayResults() {

        int maxScore = Math.max(Math.max(Math.max(analytical, creative),
                Math.max(enterprising, investigative)), social);

        Personality dominantPersonality;
        if (maxScore == analytical) {
            dominantPersonality = Personality.ANALYTICAL;
        } else if (maxScore == creative) {
            dominantPersonality = Personality.CREATIVE;
        } else if (maxScore == enterprising) {
            dominantPersonality = Personality.ENTERPRISING;
        } else if (maxScore == investigative) {
            dominantPersonality = Personality.INVESTIGATIVE;
        } else {
            dominantPersonality = Personality.SOCIAL;
        }


        questionLabel.setText("Your personality type is: " + dominantPersonality);
        answerComboBox.setVisible(false);
        nextButton.setVisible(false);


        resultListView.setEditable(true);
        resultListView.setVisible(true);

        if (mainField.equals("medical")) {
            MedicalSubField medicalSubField = MedicalSubField.valueOf(mainsubfield);
            suggestMedicalJob(medicalSubField, dominantPersonality);
            backto12();
        } else if (mainField.equals("engineering")) {
            EngineeringSubField engineeringSubField = EngineeringSubField.valueOf(mainsubfield);
            suggestEngineeringJob(engineeringSubField, dominantPersonality);
            backto12();
        } else if (mainField.equals("arts")) {
            ArtsSubField financeSubField = ArtsSubField.valueOf(mainsubfield);
            suggestArtsJob(financeSubField, dominantPersonality);
            backto12();
        }


    }

    public void suggestMedicalJob(MedicalSubField medicalSubfield, Personality personality) {

        {
            if (medicalSubfield == MedicalSubField.MBBS) {

                if (personality == Personality.ANALYTICAL || personality == Personality.INVESTIGATIVE) {
                    showAlert("Suggested Job: Specialist Doctor (e.g., Cardiologist, Neurologist)");
                } else if (personality == Personality.SOCIAL || personality == Personality.ENTERPRISING) {
                    showAlert("Suggested Job: General Practitioner or Medical Director");
                } else {
                    showAlert("Suggested Job: Medical Officer");
                }
            }


            if (medicalSubfield == MedicalSubField.BDS) {
                if (personality == Personality.CREATIVE) {
                    showAlert("Suggested Job: Cosmetic Dentist");
                } else if (personality == Personality.ANALYTICAL) {
                    showAlert("Suggested Job: Orthodontist or Prosthodontist");
                } else {
                    showAlert("Suggested Job: General Dentist");
                }
            }
            if (medicalSubfield == MedicalSubField.DPt) {
                if (personality == Personality.SOCIAL) {
                    showAlert("Suggested Job: Rehabilitation Specialist or Physiotherapist");
                } else if (personality == Personality.INVESTIGATIVE) {
                    showAlert("Suggested Job: Researcher in Physical Therapy");
                } else {
                    showAlert("Suggested Job: General Physical Therapist");
                }
            }

            if (medicalSubfield == MedicalSubField.PHARMACY) {
                if (personality == Personality.ANALYTICAL) {
                    showAlert("Suggested Job: Clinical Pharmacist or Drug Development Specialist");
                } else if (personality == Personality.ENTERPRISING) {
                    showAlert("Suggested Job: Pharmacy Manager or Pharmaceutical Sales Expert");
                } else {
                    showAlert("Suggested Job: Community Pharmacist");
                }
            }

            if (medicalSubfield == MedicalSubField.NURSING) {
                if (personality == Personality.SOCIAL) {
                    showAlert("Suggested Job: Patient Care Nurse or Public Health Nurse");
                } else if (personality == Personality.ENTERPRISING) {
                    showAlert("Suggested Job: Nurse Manager or Administrator");
                } else {
                    showAlert("Suggested Job: General Nurse");
                }

            }
            if (medicalSubfield == MedicalSubField.DIPLOMA) {
                if (personality == Personality.SOCIAL) {
                    showAlert("Suggested Job: Community Health Worker or Medical Assistant");
                } else if (personality == Personality.ANALYTICAL) {
                    showAlert("Suggested Job: Lab Technician");
                } else {
                    showAlert("Suggested Job: General Diploma Holder in Medical Fields");
                }
            }

        }
    }


    public void suggestEngineeringJob(EngineeringSubField engineeringSubfield, Personality personality) {
        if (engineeringSubfield == EngineeringSubField.COMPUTER_SCIENCE) {
            if (personality == Personality.ANALYTICAL || personality == Personality.INVESTIGATIVE) {
                showAlert("Suggested Job: Software Engineer or Data Scientist");
            } else if (personality == Personality.CREATIVE) {
                showAlert("Suggested Job: UI/UX Designer or Game Developer");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Tech Startup Founder or Project Manager");
            } else {
                showAlert("Suggested Job: IT Specialist");
            }
        }

        if (engineeringSubfield == EngineeringSubField.ELECTRICAL_ENGINEERING) {
            if (personality == Personality.ANALYTICAL) {
                showAlert("Suggested Job: Power Systems Engineer or Circuit Design Engineer");
            } else if (personality == Personality.INVESTIGATIVE) {
                showAlert("Suggested Job: Research Engineer in Electronics");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Project Manager in Electrical Engineering");
            } else {
                showAlert("Suggested Job: General Electrical Engineer");
            }
        }

        if (engineeringSubfield == EngineeringSubField.CIVIL_ENGINEERING) {
            if (personality == Personality.ANALYTICAL || personality == Personality.INVESTIGATIVE) {
                showAlert("Suggested Job: Structural Engineer or Urban Planner");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Construction Manager");
            } else if (personality == Personality.CREATIVE) {
                showAlert("Suggested Job: Architectural Engineer");
            } else {
                showAlert("Suggested Job: General Civil Engineer");
            }
        }

        if (engineeringSubfield == EngineeringSubField.DIPLOMAS) {
            if (personality == Personality.SOCIAL) {
                showAlert("Suggested Job: Technical Support Specialist or Field Technician");
            } else if (personality == Personality.ANALYTICAL) {
                showAlert("Suggested Job: Lab Technician or CAD Specialist");
            } else {
                showAlert("Suggested Job: General Diploma Holder in Engineering Fields");
            }
        }

        if (engineeringSubfield == EngineeringSubField.INDUSTRIAL_ENGINEERING) {
            if (personality == Personality.ANALYTICAL) {
                showAlert("Suggested Job: Operations Analyst or Quality Control Engineer");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Production Manager or Supply Chain Manager");
            } else if (personality == Personality.CREATIVE) {
                showAlert("Suggested Job: Process Design Engineer");
            } else {
                showAlert("Suggested Job: General Industrial Engineer");
            }
        }
    }


    public void suggestArtsJob(ArtsSubField artsSubfield, Personality personality) {
        if (artsSubfield == ArtsSubField.FINE_ARTS) {
            if (personality == Personality.CREATIVE) {
                showAlert("Suggested Job: Painter, Sculptor, or Digital Artist");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Art Director or Gallery Manager");
            } else {
                showAlert("Suggested Job: Art Teacher or Craft Specialist");
            }
        }

        if (artsSubfield == ArtsSubField.ARCHITECTURE) {
            if (personality == Personality.ANALYTICAL || personality == Personality.CREATIVE) {
                showAlert("Suggested Job: Architect or Urban Designer");
            } else if (personality == Personality.INVESTIGATIVE) {
                showAlert("Suggested Job: Architectural Researcher");
            } else {
                showAlert("Suggested Job: Interior Designer or CAD Specialist");
            }
        }

        if (artsSubfield == ArtsSubField.LITERATURE) {
            if (personality == Personality.CREATIVE) {
                showAlert("Suggested Job: Novelist, Poet, or Screenwriter");
            } else if (personality == Personality.SOCIAL) {
                showAlert("Suggested Job: Editor, Teacher, or Public Speaker");
            } else if (personality == Personality.INVESTIGATIVE) {
                showAlert("Suggested Job: Literary Critic or Researcher");
            } else {
                showAlert("Suggested Job: Freelance Writer");
            }
        }

        if (artsSubfield == ArtsSubField.MEDIA_STUDIES) {
            if (personality == Personality.CREATIVE) {
                showAlert("Suggested Job: Filmmaker, Graphic Designer, or Content Creator");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Media Manager or Advertising Executive");
            } else if (personality == Personality.SOCIAL) {
                showAlert("Suggested Job: Journalist or TV Anchor");
            } else {
                showAlert("Suggested Job: General Media Professional");
            }
        }

        if (artsSubfield == ArtsSubField.PSYCHOLOGY) {
            if (personality == Personality.SOCIAL) {
                showAlert("Suggested Job: Clinical Psychologist or Counselor");
            } else if (personality == Personality.INVESTIGATIVE) {
                showAlert("Suggested Job: Research Psychologist or Neuropsychologist");
            } else if (personality == Personality.ENTERPRISING) {
                showAlert("Suggested Job: Organizational Psychologist or HR Specialist");
            } else {
                showAlert("Suggested Job: General Psychologist");
            }
        }
    }

    public void fieldfinder(String field, String subfield) {
        mainField = field;
        mainsubfield = subfield;
    }



    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public void backto12(){
        try {

            Stage currentStage = (Stage) answerComboBox.getScene().getWindow();


            FXMLLoader loader = new FXMLLoader(getClass().getResource("After12Controller.fxml"));
            Parent root = loader.load();





            currentStage.setScene(new Scene(root));
            currentStage.show();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}