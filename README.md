# govetech-assignment-java
GovTech Assignment Java Test

## File Format

`````
Application is now scan and filter only .js, .json & .java files

``````

## To run the code

```
1.Checkout as Maven Project
2. Build the Maven Project (Pom.xml)
3. Run the Main Class - SerchTextFromDir.Java
4. Ater run It will ask for user to input following details.
          
          ## Please input a directory to read files
             ./src/main/resource
          ## Please input a search string
             TODO
```

## Sample output:

```
.\src\main\resource\subfolder\file1.js
.\src\main\resource\subfolder\file2.js
.\src\main\resource\subfolder\subfolder1\other-subfolder1\file3.js
.\src\main\resource\subfolder\subfolder1\todo-test.js
.\src\main\resource\subfolder\subfolder2\file4.js
.\src\main\resource\subfolder\subfolder2\test1.json
.\src\main\resource\subfolder\subfolder2\todo.js
```

## To run unit test

```
src\test\java\code\test\assignment\AppTest.java - Run as Junit Test
```

## test folder structure

```
./resource
       - subfolder
	file1.js 
	file2.js
	- subfolder1
		- other-subfolder1
			file3.js 
			test.json
		todo-test.js
	- subfolder2
		file4.js
		test1.json 
		todo.js 
```
