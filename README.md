# govetech-assignment-nodejs
GovTech Assignment Test

## File Format

`````
Application is now scan and filter only .js & .json files and can be scan other files like .java & .txt with small modification like 

if (file.endsWith('.json') || file.endsWith('.js'))
          filelist.push(dir + file);

``````

## To run the code

```
npm run start
```

## Sample output:

```
./node_modules/camelcase/index.js
./node_modules/chai/sauce.browsers.js
./node_modules/debug/dist/debug.js
./node_modules/debug/src/browser.js
./node_modules/es-abstract/es2015.js
./node_modules/glob/common.js
./node_modules/js-yaml/dist/js-yaml.js
./node_modules/js-yaml/lib/js-yaml/loader.js
./node_modules/js-yaml/lib/js-yaml/type.js
./node_modules/line-reader/test.js
./node_modules/minimatch/minimatch.js
./node_modules/mocha/lib/reporters/html.js
./node_modules/mocha/lib/utils.js
./node_modules/p-try/index.js
./node_modules/yargs/lib/validation.js
./search-app.js
./sub-dir/child-dir/test.dummy.js
./test/folder1/folder2/test.json
./test/folder1/test.dummy.js
./node_modules/yargs/lib/usage.js
./test/search-app-test.js
./node_modules/mocha/mocha.js
./node_modules/yargs/yargs.js
./test/folder1/folder2/todo.js
```

## To run unit test

```
npm run test
```

## test folder structure

```
./test/
  - folder1
    - folder2
      - test.json
      - textFile.txt
      - todo.js
    - test.dummy.js
    - todo-test.js
  - search-app-test.js
 - other-test.js
```

## Sample output:

```
  check search operation only for  files
    √ get all files in the directory and check

  check if files folder1/folder2/todo.js contains "TODO"
    √ get all files in the directory and check

  check if file "todo-test.js" does not contain "TODO"
    √ call perform-search to scan the file

  check if file "./test/folder1/folder2/test.json" contains "TODO"
    √ call perform-search to scan the file

  4 passing (119ms)


  6 passing (11ms)
```
