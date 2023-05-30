# CMAS Utility - Confusion Matrix Accuracy Statistics Utility
 Documentation and code for Andrew Unsworth's CMAS Utility 
 CMAS calculates the accuracy stats of a binomial confusion matrix.
 There are currently two versions of CMAS: one written in Python and the other in Java. The Java version lets users enter data using a Swing GUI and view results in the GUI. The Python version takes input from the Python interpreter. 
 
 CMAS Java Files
 One folder contains the CMAS Java Utility. The utility is self-contained, so compile the CMAS and CMASGUI files in the JavaSource/CMAS Utility folder to create the utility.
 The other folder contains the CMAS2 Java file, which is an improved version of CMAS that calculates all the stats in one go via the constructor. Any other class using CMAS2.java can use its getter methods to access results, and get an array that contains all of the results. 
 
 CMAS Python File
 CMASPy2.py is a port of the CMAS2.java class to Python. 
 