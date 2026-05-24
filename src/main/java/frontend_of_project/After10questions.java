package com.example.frontend_of_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class After10questions extends Questions {
    public After10questions(String questionText, List<String> options, int correctOption) {
        super(correctOption, options, questionText);
    }


    static List<After10questions> getScienceQuestions() {
        List<After10questions> scienceQuestions = new ArrayList<>();
        try {
            scienceQuestions.add(new After10questions("What is the basic unit of life in all living organisms?", Arrays.asList("Molecule", "Cell", "Tissue", "Organ"), 2));
            scienceQuestions.add(new After10questions("Which organ in the human body is responsible for detoxification?", Arrays.asList("Lungs", "Heart", "Liver", "Kidneys"), 3));
            scienceQuestions.add(new After10questions("Which is the longest bone in the human body?", Arrays.asList("Humerus", "Femur", "Tibia", "Radius"), 2));
            scienceQuestions.add(new After10questions("What is the main component of the human brain?", Arrays.asList("Muscle", "Bone", "Nervous tissue", "Cartilage"), 3));
            scienceQuestions.add(new After10questions("Which gas is necessary for photosynthesis in plants?", Arrays.asList("Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"), 2));
            scienceQuestions.add(new After10questions("What is Newton's First Law of Motion also called?", Arrays.asList("Law of Gravitation", "Law of Inertia", "Law of Energy", "Law of Momentum"), 2));
            scienceQuestions.add(new After10questions("What is the unit of electric current?", Arrays.asList("Joule", "Ohm", "Ampere", "Watt"), 3));
            scienceQuestions.add(new After10questions("Which law explains the relationship between voltage, current, and resistance?", Arrays.asList("Boyle's Law", "Ohm's Law", "Faraday's Law", "Kirchhoff's Law"), 2));
            scienceQuestions.add(new After10questions("What is the speed of light in a vacuum?", Arrays.asList("3 x 10^6 m/s", "3 x 10^8 m/s", "3 x 10^4 m/s", "3 x 10^7 m/s"), 2));
            scienceQuestions.add(new After10questions("Which substance is commonly used as a semiconductor?", Arrays.asList("Copper", "Silicon", "Iron", "Gold"), 2));
        } catch (Exception e) {
            System.out.println("Error adding science questions: " + e.getMessage());
        }


        Collections.shuffle(scienceQuestions);
        return scienceQuestions.subList(0, 5);
    }


    static List<After10questions> getIcsQuestions() {
        List<After10questions> engineeringQuestions = new ArrayList<>();
        try {
            engineeringQuestions.add(new After10questions("What is Ohm's Law?", Arrays.asList("V = IR", "E = mc^2", "P = VI", "F = ma"), 1));
            engineeringQuestions.add(new After10questions("Which is a programming language?", Arrays.asList("HTML", "Java", "CSS", "Photoshop"), 2));
            engineeringQuestions.add(new After10questions("What is the SI unit of force?", Arrays.asList("Watt", "Joule", "Newton", "Pascal"), 3));
            engineeringQuestions.add(new After10questions("Which material is the best conductor of electricity?", Arrays.asList("Gold", "Silver", "Copper", "Aluminum"), 2));
            engineeringQuestions.add(new After10questions("What does CAD stand for in engineering?", Arrays.asList("Computer Aided Design", "Computer Automatic Drawing", "Computer Aided Drafting", "Computer Assisted Development"), 1));
            engineeringQuestions.add(new After10questions("Which of these is not a type of mechanical stress?", Arrays.asList("Tensile", "Compressive", "Rotational", "Shear"), 3));
            engineeringQuestions.add(new After10questions("What is the basic unit of electrical current?", Arrays.asList("Volt", "Watt", "Ampere", "Ohm"), 3));
            engineeringQuestions.add(new After10questions("In binary, what is 1 + 1?", Arrays.asList("1", "2", "10", "11"), 3));
            engineeringQuestions.add(new After10questions("Which law states that energy cannot be created or destroyed?", Arrays.asList("Newton's First Law", "Law of Conservation of Energy", "Boyle's Law", "Faraday's Law"), 2));
            engineeringQuestions.add(new After10questions("What type of engine uses spark plugs?", Arrays.asList("Diesel Engine", "Petrol Engine", "Steam Engine", "Jet Engine"), 2));
        } catch (Exception e) {
            System.out.println("Error adding Engineering questions: " + e.getMessage());
        }Collections.shuffle(engineeringQuestions);
        return engineeringQuestions.subList(0,5);
    }

    static List<After10questions> getArtsQuestions() {
        List<After10questions> artsQuestions = new ArrayList<>();
        try {
            artsQuestions.add(new After10questions("Who painted the Mona Lisa?", Arrays.asList("Van Gogh", "Da Vinci", "Picasso", "Michelangelo"), 2));
            artsQuestions.add(new After10questions("What is a haiku?", Arrays.asList("A short poem", "A painting style", "A type of sculpture", "A dance form"), 1));
            artsQuestions.add(new After10questions("Who is known as the 'Father of Modern Art'?", Arrays.asList("Picasso", "Van Gogh", "Cézanne", "Da Vinci"), 3));
            artsQuestions.add(new After10questions("Which country is famous for the traditional dance 'Flamenco'?", Arrays.asList("Italy", "Spain", "France", "Greece"), 2));
            artsQuestions.add(new After10questions("What is the medium used in watercolor painting?", Arrays.asList("Oil", "Acrylic", "Water", "Charcoal"), 3));
            artsQuestions.add(new After10questions("Which composer created the opera 'The Magic Flute'?", Arrays.asList("Beethoven", "Mozart", "Bach", "Haydn"), 2));
            artsQuestions.add(new After10questions("What is the term for a painting done on wet plaster?", Arrays.asList("Fresco", "Mural", "Canvas", "Etching"), 1));
            artsQuestions.add(new After10questions("Which ancient civilization built the Parthenon?", Arrays.asList("Romans", "Egyptians", "Greeks", "Babylonians"), 3));
            artsQuestions.add(new After10questions("In theatre, what is a 'soliloquy'?", Arrays.asList("A group song", "A dance sequence", "A monologue", "A stage direction"), 3));
            artsQuestions.add(new After10questions("Who wrote the famous play 'Romeo and Juliet'?", Arrays.asList("Christopher Marlowe", "Oscar Wilde", "William Shakespeare", "Charles Dickens"), 3));

        } catch (Exception e) {
            System.out.println("Error adding Arts questions: " + e.getMessage());
        }
        Collections.shuffle(artsQuestions);
        return artsQuestions.subList(0,5);
    }
}
