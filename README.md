# Grocery Store Simulator 

## Overview
For this assignment, you will be implementing a Post Fix Evaluator to perform basic arithmetic.

### Table of Contents
**[Files to complete](#files-to-complete)**<br>
**[Support Code API](#support-code-api)**<br>
**[Part One: Clone, Branch, and Import Project](#part-one-clone-branch-and-import-project)**<br>
**[Part Two: Implementing LinkedStack](#part-two-implementing-linkedstack)**<br>
**[Part Three: Implement Arithmetic Operators](#part-three-implement-arithmetic-operators)**<br>
**[Part Four: Implement a Postfix Arithmetic Evaluator](#part-four-implement-a-postfix-arithmetic-evaluator)**<br>
**[Part Five: Commit Project and Submit Pull Request](#part-five-commit-project-and-submit-pull-request)**<br>
**[Bonus: Infix Expression Evaluator](#bonus-infix-expression-evaluator)**<br>
**[Additional Notes: Help for the project](#additional-notes)**<br>

## Book
This assignment is based off Chapter 5 in the Java Software Structures book

## Files to complete
You are expected write an implementation for each of the interfaces listed in the classes presented in the **config** package provided. As with the last assignment, you must specify which implementation you would like us to grade in this file.

It will almost certainly be useful for you to write additional class files. Any class file you write that is used by your solution **MUST**  be in the provided **src** folder. When we test your assignment, all files not included in the **src** folder will be ignored.

**Note:** When you submit your solution, be sure to remove **ALL** compilation errors from your project. Any compilation errors in your project may cause the autograder to fail and you will receive a zero for your submission.

### Test files
In the test folder, you are provided with several JUnit test cases that will help you keep on track while completing this assignment. We recommend you run the tests often and use them as a checklist of things to do next. You are not allowed to remove anything from these files. If you have errors in these files, it means the structure of the files found in the src folder have been altered in a way that will cause your submission to lose points. We highly recommend that you add new @Test cases to these files. However, before submitting, make sure that your program compiles with the original test folder provided.

### Support Code API
The Support Code’s comments have been generated into a nicely formatted API that can be found here: 

https://jd12.github.io/grocery-simulator-student/

It is not important that you understand how the support code is implemented but it is important that you understand what the support code offers. It is highly recommended that you spend a day simply reading over the comments in each of the interfaces provided.


## Part One: Clone, Branch, and Import Project 
Begin by cloning the provided project, creating your dev branch, and importing it into your workspace. 

```
git clone <url for github repository>
git branch dev
git checkout dev
```

You should then import it to your IDE of choice. 

By default, your project should have no errors and contain the following root items:

**src** - The source folder where all code you are submitting must go. You can change anything you want in this folder, you can add new files, etc...<br>
**test** - The test folder where all of the public unit tests are available<br>
**support** - This folder contains support code that I encourage you to use (and must be used to pass certain tests). You are not allowed to change anything in this folder.<br>
**JUnit 4** - A library that is used to run the test programs<br>
**JRE System Library** - This is what allows java to run<br>

If you are missing any of the above or errors are present in the project, seek help immediately so you can get started on the project right away. 

## Part Two: Implementing QueueInterface
Create a class that implements `structures.QueueInterface`. The `Queue` you are implementing should be unbounded and meet the big-O time complexities specified in the interface.

**Tip:** Don’t try to implement your entire Queue class all at once. Start by looking at the the tests provided in structures.QueueInterfaceTest. Do these tests look like they cover all the cases presented by the interface? If not, can you come up with additional tests? Add a method to the test file and add the @Test annotation before it. When you run your unit tests, this method will also be executed. Be careful not to change any of the provided unit tests! 

Once you feel like the tests accurately represent what you would like to test, choose the test that looks the least complex. Implement the parts that will allow that test to pass. Once those tests pass. Look for another test to implement. 

**Note**: For this portion of the assignment, you may not use any of the provided Collection classes provided by the java standard API. A list of them can be seen in the “All Known Subinterfaces” and “All Known Implementing Classes” of the following URL: http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html

## Part Three: Implement a NormalLine and an ExpressLine
The `simulator.checkout.CheckoutLineInterface` extends `QueueInterface<Shopper>`. That is, it is just a queue for shoppers to stand in while they wait to be processed. However, there are a few additional requirements for this interface.

First, it defines a `canEnterLine`. This method determines if a shopper is allowed to enter a particular line. This can be used to represent special lines such as “15 items or less”.

Second, the definition for enqueue, is slightly different in that if the `canEnterLine` method returns false on the input, this method should throw an exception.

For this part, you must implement two versions of `CheckoutLineInterface`. The `NormalLine` class should always return true with a call to `canEnterLine`. The `ExpressLine` should return false if the specified `Shopper` has more than 15 items.

**Tip:** You should be able to easily implement this class by extending the class you wrote in part two and @Override `enqueue`.

**Tip:** Write `NormalLine` first then extend it when you implement `ExpressLine` and @Override `canEnterLine`.


## Part Four: Create Groceries
In the `config.Groceries` class, return valid implementations for each of the static methods defined.

**Tip:** You should be able to accomplish this by implementing a single class called `Grocery`.

## Part Five: Commit Project and Submit Pull Request 

For this part of the assignment, you will be extending the abstract class `simulator.AbstractReceipt`. If you look at the definition, you will see there are two abstract methods left for you to implement: `getSubTotal()` and `getSaleValue()`. 

**Tip:** Take advantage of the supplied methods. You shouldn’t need to have fields in your subclass to hold the list or discount. You can access these in your subclass by using `super.getDiscount()` and `super.getGroceries()`.

**Tip:** Take a look at the `List<T>` interface in the Java API to see how it works. You will need to use it to calculate the subtotal. Notice that `List<T>` implements `Iterable<T>`. This means that it can be used in the enhanced for loop! 

**List API:** http://docs.oracle.com/javase/7/docs/api/java/util/List.html<br>
**Iterable API:** http://docs.oracle.com/javase/7/docs/api/java/lang/Iterable.html<br>

### Using Enhanced For Loop w/ List:
Assume there is some `List<String>` called strings. Then we can write:

```java
for(String s : strings){
  System.out.println(s);
}
```

This will print out all of the elements in strings.

### Another Example:
Assume there is some `List<GroceryInterface>` called groceries. Then we can write:

```java
for(GroceryInterface g : groceries){
  System.out.println(g.getCost());
}
```

This will print out the cost of all `GroceryInterface` items in groceries.

## Part Six: Commit Project and Merge Master 
When you have finished your solution and are ready to submit, make your final commit, merge your master branch with your dev branch, and push eveything up to Github. 




