**Coffee-Machine**

A coffee machine having multiple outlets that prepare several drinks
at a time depending upon the count of outlets.

The input is accepted in the form of json. Please refer to [sample](https://github.com/Ashish-sharmaa/Coffee-Machine/blob/master/resources/input.json)


**How to Compile and Run**
* Update the input: `resources/input.json`
* Entrypoint: `src/com/coffee/simulation/DrinkMachine`

**Assumptions**
* Number of instances a group of consumers can arrive at any point is generated randomly within [1, [limit](https://github.com/Ashish-sharmaa/Coffee-Machine/blob/master/src/com/coffee/simulation/utils/Constants.java#L9)]
* Multiple outlets can provide same type of drinks simultaneously.
* A delay of 2 seconds is added to indicate time interval between two consecutive sets of customer orders.
* 0th based indexing is used.