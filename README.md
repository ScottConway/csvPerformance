# csvPerformance
Test the performance of java csv libraries.

## Issues
For writing cannot pick the directory so it must be an existing file.  Use touch 
or mktemp to create files.  Plus they must be in the directory the source code is 
in. 

So from the csvPerformance directory I run the following commands to set up the initial, empty, test files for me to create later:

    touch rfc4180ParserA10.csv
    touch rfc4180ParserA50.csv
    touch rfc4180ParserS10.csv
    touch rfc4180ParserS50.csv
    touch csvParserA10.csv
    touch csvParserA50.csv
    touch csvParserS10.csv
    touch csvParserS50.csv

## Running Performance Tests

I use the performanceTest.sh shell script to start the tests to ensure a set amount of memory.  
When attaching JProfiler I use the performanceTestJProfiler.sh script.  

Once started open a browser and go to http://localhost:8080/writeTest to run the write tests and 
http://localhost:8080/readTest to run the read tests. 