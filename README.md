# GroupProject1
ReadMe Author: Shane Mayo\n
Group: The Lucky Seven
ICS 372: Object Oriented Design and Implementation
Assignment: Group Project 1 - Read Me
Due: 2/7/18
Professor: Timmothy Carlson

General Information
The program allows a user to choose a JSON file as the input file, then
processes the information within the file, and outputs the file into a newly created
file.
The program, in order to interact with a file in the JSON format, requires an
external .jar file, which can be found here: http://www.java2s.com/Code/Jar/j/Downloadjavajsonjar.htm
The file implements functions that allow the program to interact with the JSON
objects in the file.

Program Breakdown
The program is implemented using four classes in total: an input class, a patient
class, an  export class, and a main class. Each class will be further described
below, along with its place and functions within the process.

The Input class opens a system dialog allowing a user to choose a file (in this case
the file should be of type JSON format). Once the user has chosen a file, the Input
class then parses the file, storing it as an JSON Object.

The Patient class tracks patient specific information, using that information to
determine if the patient is currently in a trial. The patient class checks the
a local patient id against an incoming JSONObject's id, specifying if the patient
is currently participating in a trial.

The ExportAllReadings handles the compilation of the data into a JSON format for output.
The class accomplishes this through the use of a linked hash map, then storing each
object in a JSONArray.

The Readings class(main class) manipulates data from the input file, tracking if patient
ids are already available, and if not, then adding a new patient if the id is not found.
