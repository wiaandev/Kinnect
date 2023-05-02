
<br />

![GitHub repo size](https://img.shields.io/github/repo-size/WiaanDuvenhage-200307/Kinnect?color=orange)
![GitHub watchers](https://img.shields.io/github/watchers/WiaanDuvenhage-200307/Kinnect?color=green)
![GitHub language count](https://img.shields.io/github/languages/count/WiaanDuvenhage-200307/Kinnect?color=white)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/WiaanDuvenhage-200307/Kinnect?color=black)
[![LinkedIn][linkedin-shield]][linkedin-url]
[![Instagram][instagram-shield]][instagram-url]

<h5 align="center" style="padding:0;margin:0;">Wiaan Duvenhage</h5>
<h5 align="center" style="padding:0;margin:0;">200307</h5>
<h6 align="center">DV302 | Android Expanded</h6>
</br>
<p align="center">

  <a href="https://github.com/WiaanDuvenhage-200307/Kinnect">
    <img src="Images/Kinnect.svg" width="200px">
  </a>

<h3 align="center">Kinnect</h3>

  <p align="center">
    An Android Application built with Kotlin and Firebase, a chat application for households.<br>

   <br />
   <br />
   <a href="https://youtu.be/aY9cDdwKBnE">View Demo</a>
    ·
    <a href="https://github.com/WiaanDuvenhage-200307/Kinnect/issues">Report Bug</a>
    ·
    <a href="https://github.com/WiaanDuvenhage-200307/Kinnect/issues">Request Feature</a>
</p>
<!-- TABLE OF CONTENTS -->

## Table of Contents

- [About the Project](#about-the-project)
    - [Project Description](#project-description)
    - [Built With](#built-with)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [How to install](#how-to-install)
- [Features and Functionality](#features-and-functionality)
- [Concept Process](#concept-process)
    - [Ideation](#ideation)
    - [Wireframes](#wireframes)
- [Development Process](#development-process)
    - [Implementation Process](#implementation-process)
        - [Highlights](#highlights)
        - [Challenges](#challenges)
    - [Future Implementation](#peer-reviews)
- [Final Outcome](#final-outcome)
    - [Mockups](#mockups)
    - [Video Demonstration](#video-demonstration)
- [Conclusion](#conclusion)
- [License](#license)
- [Contact](#contact)
- [Acknowledgements](#acknowledgements)

<!--PROJECT DESCRIPTION-->

## About the Project

<!-- header image of project -->

![image1][image1]

### Project Description

This is Kinnect! A simple quiz app that quizzes users on their knowledge on all types of esports around the world from veteran esports like Counter Strike all the way to new games entering the esports scene like Valorant. This is a fun app that friends can download to see who can get the highest score and ultimately gain XP (experience). People of all ages can play this game, it just has one requirement, be on top of your esports game.

### Built With
[<img src="https://4.bp.blogspot.com/-cE71mKJc94w/VrT2tLTxXTI/AAAAAAAACjU/KdygZ1AN0Nc/s1600/image04.png" width="5%" height="5%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;](https://developer.android.com/studio?gclid=CjwKCAjwuYWSBhByEiwAKd_n_q4WXi5vcCji08peoWOEsv-KHFT7QWNZNmozB_CIiiSNl_HOUL-1JBoCGx8QAvD_BwE&gclsrc=aw.ds)
[<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Kotlin_Icon.svg/512px-Kotlin_Icon.svg.png?20171012085709" width="4%" height="4%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;](https://kotlinlang.org/)
[<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/firebase/firebase-plain.svg" width="4%" height="4%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;](https://firebase.google.com/)

<!-- GETTING STARTED -->
<!-- Make sure to add appropriate information about what prerequesite technologies the user would need and also the steps to install your project on their own mashines -->

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

For development, the latest version of Android Studio is required. The latest version can be downloaded from [Android Studio](https://developer.android.com/studio?gclid=CjwKCAjwuYWSBhByEiwAKd_n_q4WXi5vcCji08peoWOEsv-KHFT7QWNZNmozB_CIiiSNl_HOUL-1JBoCGx8QAvD_BwE&gclsrc=aw.ds)

### Installation

1. Clone the repo
```sh
git clone https://github.com/WiaanDuvenhage-200307/Kinnect.git
```
2. Open the project

Use `File` : `Open` in Android Studio.

<!-- FEATURES AND FUNCTIONALITY-->
<!-- You can add the links to all of your imagery at the bottom of the file as references -->

## Features and Functionality

<!-- note how you can use your gitHub link. Just make a path to your assets folder -->

### Entering your username

![image2][image2]
Enter your name to start with the quiz. This name can be changed if you would want to.

### Choose a category

![image3][image3]
Select a category of the esports game that you wanted to get tested in, by tapping on the image tiles below.

### Answer Quiz Questions

![image4][image4]
Answer the question given to the user on screen by tapping on the red buttons below and your score will be updated depending if you got the quiz question correct

### Display Score
![image5][image5]
After the user has completed the categories' questions, they can view their score for that category and if they have broken or set a high score they will have a more flared up screen indicating so.

### Show & Reset High Score
![image6][image6]
The user can view their high score as well as reset it in the settings page

<!-- CONCEPT PROCESS -->
<!-- Briefly explain your concept ideation process -->
<!-- here you will add things like wireframing, data structure planning, anything that shows your process. You need to include images-->

## Concept Process

I am a very huge fan of dark theme applications and using colors that contrast extremely well, so in conclusion I thought it was a no-brainer to use in black, white and red in conjunction with each other to create the most eye-catching application. By looking at my wireframes you would notice that my answering method differs from the final application outcome. I have come to realise how intricate and dense Kotlin can be so decided to go with a more simpler, yet effective answering method.

### Wireframes

![image7][image7]

### Moodboard
![image8][image8]

### User Flow
![image9][image9]

## Development Process

The `Development Process` is the technical implementations and functionality done for the app.

### Implementation Process

For the entirety of the project, I have used <b>Kotlin 1.7.0</b> for the functionality and I used <b>XML</b> for the front-end of the application.

#### XML

- I implemented `ScrollView` for my <b>Settings</b> & <b>Category</b> activities
- `RelativeLayout` was used for my <b>Home</b> activity
- `ConstraintLayout` was used for my <b>Splash</b> activity
- `LinearLayout` was used for majority of the project

#### Kotlin

- I created a `Constants.kt` object file which held all my question variables and my `sharedPreferences` data
- I created a `Questions.kt` class file, where I created the model of my question, meaning what data my question is to consist of like if it has an image, how many answers this question has and I also passed a key/value pair, that will check if my question is correct
- I created a `UpdateUI()` function that will update the question and its answers on one `Questions.kt` activity file instead of creating a different file for each categories' question.
- I used `Intent` to send and receive data from each activity
- I also incorporated `SharedPreferences` to save and send data to each activity, like the users score and username, which will be saved conditionally using an `if()` statement

#### Highlights

<!-- stipulated the highlight you experienced with the project -->

- A highlight of this project was definitely learning a new language (Kotlin) and working and developing for mobile.
- It was also a high point for me to load my app onto my mobile device and interacting with it
- Fixing all of the bugs I struggled with was also a big plus for me

#### Challenges

<!-- stipulated the challenges you faced with the project and why you think you faced it or how you think you'll solve it (if not solved) -->

- I encountered a bug that will not pass the score if the last question of the category is correct, essentially giving the user a 4/5 score instead of a 5/5, unfortunately I could not get this fixed, but will be in later stages of development of XP
- It was very challenging sending and receiving data using `SharedPreferences` but got it figured out in the end
- I was flabbergasted at how dense Kotlin actually is, so wrapping my head around how the code is written and how data works was a struggle to say the least

### Future Implementation

<!-- TODO Change this! -->

<!-- stipulate functionality and improvements that can be implemented in the future. -->

- I would like to add more questions
- I want to change the answering method, making it more intricate and fun
- I want to implement Firebase or Firestore
- I want to fix my Shared Preferences bug
- I want to add more games that are part of the esports world

<!-- MOCKUPS -->

## Final Outcome

### Mockups

<!-- TODO Change this -->

![image10][image10]
![image11][image11]
![image12][image12]
![image13][image13]
<br>


<!-- VIDEO DEMONSTRATION -->

### Video Demonstration

<!-- TODO Change this -->

To see a run through of Kinnect, click below:

[View Demonstration](https://youtu.be/aY9cDdwKBnE)

See the [open issues](https://github.com/WiaanDuvenhage-200307/Kinnect/issues) for a list of proposed features (and known issues).

<!-- AUTHORS -->

## Authors

- **Wiaan Duvenhage** - [Github](https://github.com/WiaanDuvenhage-200307)

<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE` for more information.\

<!-- LICENSE -->

## Contact

- **Wiaan Duvenhage** - [wiaanduvenhage.dev@gmail.com](mailto:wiaanduvenhage.dev@gmail.com) - [@wiaan.dev](https://www.instagram.com/wiaan.dev/)
- **Project Link** - https://github.com/WiaanDuvenhage-200307/Kinnect

<!-- ACKNOWLEDGEMENTS -->

## Acknowledgements

<!-- all resources that you used and Acknowledgements here -->
<!-- TODO Change this -->

- [Stack Overflow](https://stackoverflow.com/)
- [How to add a splash screen](https://www.youtube.com/watch?v=Q0gRqbtFLcw)
- [Figma](https://www.figma.com/)
- [Lecturer](https://github.com/armandpret)
- [Zlatko Plamenov Mockups](https://www.freepik.com/author/zlatko-plamenov)
- [Vian Du Plessis](https://github.com/Vian-du-Plessis)
- [unDraw](https://undraw.co/)
- [No History Activity Element](https://developer.android.com/guide/topics/manifest/activity-element#nohist)
- [GeeksforGeeks](https://www.geeksforgeeks.org/)

[image1]: Images/aboutproject.jpg
[image2]: Images/entername.jpg
[image3]: Images/choosecategory.jpg
[image4]: Images/answerquiz.jpg
[image5]: Images/results.jpg
[image6]: Images/highscore.jpg
[image7]: Images/wireframes.png
[image8]: Images/moodboard.png
[image9]: Images/userflow.png
[image10]: Images/mockup1.jpg
[image11]: Images/mockup2.jpg
[image12]: Images/mockup3.jpg
[image13]: Images/mockup4.jpg

[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/wiaan-duvenhage-95118823a/
[instagram-shield]: https://img.shields.io/badge/-Instagram-black.svg?style=flat-square&logo=instagram&colorB=555
[instagram-url]: https://www.instagram.com/wiaan.dev/
