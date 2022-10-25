# **Adapted CodePoint Code Kata?**
In this kata, every character has an associated code (a numerical value(int), and vice versa each code
can be mapped to an individual character.

To find out what character is mapped to a code we can implement the following code:
```java
CodePointList.from(code).makeString()
```
To learn more about Characters and Code Points in Java, [here is a link](https://docs.oracle.com/javase/tutorial/i18n/text/characterClass.html).


In [CodePointKataTest](src/test/java/bnymellon/codekatas/codepointkata/CodePointKataTest.java)
there are 2 tests (and we don't want you to touch the tests):

* translateTheSecretMessage() -> which reads from a file called `codepoints.txt` containing a bunch of codes. This test is currently
throwing an Exception. We would like you to fix the code so that the test passes, plus decode the secret message. 
n.b. If the first or last character is whitespace then we can ignore it.

* codePointsToHelloWorldHowAreYou() -> is just a test to make sure we translate a bunch of codes to an expected message. 
The test is currently failing, we'd like you to fix the implementation to make it pass.

Things you will need:
* Java 17
* Maven
* Possibly an IDE!

