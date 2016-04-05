`To change the parameters for the stadium,
Please change in the seatsInformation.json file.`

To build/test the application
=

Go to the project directory( contains the POM.XML) In the command line,
Type commands:

    
**For Install**  
_mvn install_  
**For Test**  
_mvn  test_


   Assumptions: 
=
1. Assumption 
-
The lower seats are better than higher seats, which are further from the stage.

2. Assumption
-
The group seats are better when they sit together. When change rows, start from the end of the next row. So they can sit closer.

