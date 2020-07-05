**Coffee-Machine**

A coffee machine having multiple outlets that prepare several drinks
at a time depending upon the count of outlets.

The input is accepted in the form of json. Please refer to [sample](https://github.com/Ashish-sharmaa/Coffee-Machine/blob/master/resources/input.json)

**Assumptions**
* Number of instances a group of consumers can arrive at any point is generated randomly with modulo [limit](https://github.com/Ashish-sharmaa/Coffee-Machine/blob/master/src/com/coffee/simulation/utils/Constants.java#L9)
* Multiple outlets can provide same type of drinks simultaneously.
* A sleep of 2 seconds is added to indicate time interval between two consecutive sets of customer orders.
* Indexing is 0th based

**How to Compile and Run**
* Compile: javac src/com/coffee/simulation/DrinkMachine.java
* Run: java src/com/coffee/simulation/DrinkMachine