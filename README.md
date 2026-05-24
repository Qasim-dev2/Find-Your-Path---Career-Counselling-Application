# Find-Your-Path---Career-Counselling-Application

## 📌 Project Overview

A JavaFX-based Career Counseling Application designed to guide students in choosing suitable career paths based on their interests, skills, and academic preferences through an interactive and user-friendly desktop interface.

---

## 👥 Target Audience

This application is designed for:
- **Metric Students (Science Group)**: Students who have completed their 10th grade studies in the science stream
- **FSC (Intermediate) Students**: Pre-university students (grades 11-12) pursuing Higher Secondary Education
- **University Students**: Undergraduate and graduate students seeking career guidance and path planning
- **Career Seekers**: Individuals looking to explore different career options and make informed decisions

---

## 🎯 What This Project Means to People

### Importance & Impact:

- **Career Clarity**: Helps students overcome confusion about their future career paths by providing structured guidance
- **Personalized Guidance**: Uses personality traits, IQ levels, and academic interests to provide customized career recommendations
- **Time & Resource Saving**: Eliminates the need for expensive career counselors by providing digital guidance accessible to all
- **Informed Decision Making**: Empowers students to make data-driven career choices based on their strengths and interests
- **Reduced Academic Stress**: Alleviates anxiety by providing clear direction and multiple career options
- **Affordable Access**: Makes quality career counseling accessible to students from all economic backgrounds
- **Self-Discovery**: Encourages students to understand their abilities through personality and IQ assessments

---

## ✨ Key Features

- **User Registration & Authentication**: Secure signup and login system for students
- **Personality Assessment**: Interactive personality tests to identify traits and work preferences
- **IQ Testing**: Comprehensive IQ assessments to evaluate analytical and cognitive abilities
- **Academic Field Selection**: Options for students to select their academic stream:
  - Engineering
  - Medical/Healthcare
  - Arts & Humanities
  - Commerce/Business
- **Career Recommendations**: AI-driven recommendations based on test results and interests
- **Student Dashboard**: View test results, scores, and career path recommendations
- **User-Friendly Interface**: JavaFX-based GUI for smooth and intuitive navigation

---

## 🚀 How to Run This Project

### Prerequisites
Before running the application, ensure you have the following installed:
- **Java 11 or higher** (JDK)
- **Maven** (for dependency management)
- **JavaFX SDK** (for GUI framework)

### Installation & Setup Steps

1. **Clone or Extract the Project**
   ```bash
   cd c:\Users\qasim\Desktop\po 4\Frontend_of_project
   ```

2. **Build the Project using Maven**
   ```bash
   mvn clean install
   ```

3. **Run the Application**
   ```bash
   mvn javafx:run
   ```
   
   **Or** using the Maven wrapper:
   ```bash
   mvnw javafx:run
   ```

4. **Alternative: Run from IDE**
   - Open the project in your favorite IDE (IntelliJ IDEA, Eclipse, or VS Code)
   - Run the `HelloApplication.java` or `Main.java` class as a Java Application

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── frontend_of_project/
│   │       ├── HelloApplication.java       # Application Entry Point
│   │       ├── IQTestController.java       # IQ Test Logic
│   │       ├── PersonalityController.java  # Personality Test Logic
│   │       ├── Students.java               # Student Data Model
│   │       ├── Registration.java           # User Registration
│   │       ├── Menu.java                   # Main Menu
│   │       └── ...
│   └── resources/
│       └── com/example/frontend_of_project/
│           ├── *.fxml                      # JavaFX UI Layouts
│           └── Images/                     # Application Images
└── test/                                   # Unit Tests
```

---

## 📊 Test Types Available

1. **IQ Test (Before 10)**
   - Assesses logical reasoning and problem-solving skills
   - Questions designed for metric and intermediate students

2. **Advanced IQ Test (After 10 & 12)**
   - In-depth cognitive assessment
   - Measures advanced analytical abilities

3. **Personality Test**
   - Evaluates personality traits using standardized questionnaires
   - Matches personality types with suitable careers

---

## 🛠 Technologies Used

- **Language**: Java
- **GUI Framework**: JavaFX
- **Build Tool**: Maven
- **Database**: (Local storage/File-based or integrated database)
- **IDE**: Any Java-compatible IDE (IntelliJ IDEA, Eclipse, VS Code)

---

## 📋 System Requirements

- **OS**: Windows, macOS, or Linux
- **RAM**: Minimum 2GB
- **Disk Space**: 200MB for installation
- **Java Version**: JDK 11 or higher

---

## 🎓 How It Works

1. **Registration**: Students create an account with basic information
2. **Assessment**: Students take personality and IQ tests
3. **Analysis**: The system analyzes responses and calculates scores
4. **Recommendations**: Based on results, the system recommends suitable careers and educational paths
5. **Results**: Students can view detailed results and career path suggestions

---

## 🎨 Gallery & Screenshots

### Splash Screen
The application features an attractive splash screen that welcomes users upon startup:

![Splash Screen](src/main/resources/com/example/frontend_of_project/Images/splash.png)

### Application Interface
The main interface provides an intuitive and user-friendly experience for students to navigate through various assessments and career recommendations.

---

## 🤝 Contributing

If you'd like to improve this project, feel free to:
- Report bugs and issues
- Suggest new features
- Optimize existing code
- Improve the UI/UX

---

## 📞 Support & Contact

For questions, suggestions, or issues, please reach out to the development team.

---

## 📄 License

This project is designed for educational and career counseling purposes.

---

**Last Updated**: May 2026  
**Version**: 1.0
