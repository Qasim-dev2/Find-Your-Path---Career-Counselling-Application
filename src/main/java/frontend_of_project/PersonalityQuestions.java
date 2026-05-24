package com.example.frontend_of_project;

import java.util.*;
public class PersonalityQuestions {

    String questionText;
    List<String> options;
    Personality personality;

    public PersonalityQuestions(  String questionText,List<String> options,Personality personality) {
        this.options = options;
        this.personality = personality;
        this.questionText = questionText;
    }


    static List<PersonalityQuestions> personalityQuestions()
    {
        List<PersonalityQuestions> personalityQuestions= new ArrayList<>();
        personalityQuestions.add(new PersonalityQuestions("Do you prefer solving problems with logic?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you often feel the need to socialize?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy taking charge of a situation?", Arrays.asList("Yes", "No"), Personality.ENTERPRISING));
        personalityQuestions.add(new PersonalityQuestions("Do you like exploring new ideas and concepts?", Arrays.asList("Yes", "No"), Personality.INVESTIGATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy helping others solve their problems?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you find it easy to engage with strangers?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you prefer a clear plan over unpredictability?", Arrays.asList("Yes", "No"), Personality.ENTERPRISING));
        personalityQuestions.add(new PersonalityQuestions("Do you feel fulfilled when you're able to help others?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you prefer to lead projects instead of following?", Arrays.asList("Yes", "No"), Personality.ENTERPRISING));
        personalityQuestions.add(new PersonalityQuestions("Do you tend to avoid risky situations?", Arrays.asList("Yes", "No"), Personality.INVESTIGATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy organizing events and activities?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you prefer stability and predictability in your work?", Arrays.asList("Yes", "No"), Personality.CREATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you value deep, thoughtful discussions over casual chats?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you like to spend time thinking about complex ideas?", Arrays.asList("Yes", "No"), Personality.INVESTIGATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy motivating people to achieve their best?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy solving puzzles or complex problems?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you find it difficult to work in isolation?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you often take the initiative to start new projects?", Arrays.asList("Yes", "No"), Personality.ENTERPRISING));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy conducting research and experiments?", Arrays.asList("Yes", "No"), Personality.INVESTIGATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy discussing theories and abstract ideas?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you prefer attending social events over staying at home?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you feel satisfied when you achieve your goals?", Arrays.asList("Yes", "No"), Personality.ENTERPRISING));
        personalityQuestions.add(new PersonalityQuestions("Do you like organizing things to make them more efficient?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));
        personalityQuestions.add(new PersonalityQuestions("Do you enjoy working with others to solve problems?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you often take a methodical approach to problem-solving?", Arrays.asList("Yes", "No"), Personality.INVESTIGATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you find joy in understanding how things work?", Arrays.asList("Yes", "No"), Personality.INVESTIGATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you like motivating and inspiring others to take action?", Arrays.asList("Yes", "No"), Personality.SOCIAL));
        personalityQuestions.add(new PersonalityQuestions("Do you prefer routine tasks to unpredictable situations?", Arrays.asList("Yes", "No"), Personality.ENTERPRISING));
        personalityQuestions.add(new PersonalityQuestions("Do you often find yourself coming up with creative solutions?", Arrays.asList("Yes", "No"), Personality.CREATIVE));
        personalityQuestions.add(new PersonalityQuestions("Do you find it difficult to make decisions without having all the facts?", Arrays.asList("Yes", "No"), Personality.ANALYTICAL));


        Collections.shuffle(personalityQuestions);
        return personalityQuestions.subList(0,10);
    }







}
