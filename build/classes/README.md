Graphical Application using JavaFX And MVC Pattern
This is a simple World guessing game like worlde  with a form-based graphical user-interface using JavaFX. JavaFX is a set of classes and tools for creating graphical applications. JavaFX is included in the Java API and Java Development Kit.

 
Overview of GUI Wordle App Design
Applications with a graphical user interface (GUI) divide the code into components, based on functionality:

User Interface or View contains visual components, layout, and formatting of the UI.
Controller handles events from the View, updates the View, and acts as a bridge between the View and the Model.
Model contains the logic and code for the application. It usually has no knowledge of the View and Controller, but responds to requests (method calls) from them. The Model typically consists of many classes and may itself be divided into components or layers.
And one other class:
Application class or Main class that starts the application. It creates initial objects for model, view, and controller, connects them as needed, and starts the UI. Its usually very short.

This project contains a sample game that you can customize or extend. The code is general enough that you can modify it to play other games without modifying the UI (View) much.

class Wordle - user interface using JavaFX (Main Class)
TileBlock.java - controller handles events from UI and updates the UI
TileLineBlock.java ,TilePlaneBlock,StatusWorlde- Thats are model class of game.
WordHandler.java - this class handle the word which can choose and appear on game.
lamda Expression are also used in button events and tile click events.
Using FileReader  Read strings words from txt file store in arraylist.

 