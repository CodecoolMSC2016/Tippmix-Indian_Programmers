# Laptop

## Description
This class represents the student's laptop at the BFA.

## Parent Class
None

## Attributes
* ```power_on```
  * data type: bool
  * description: stores the state of the laptop
* ```memory_limit```
  * data type: integer
  * description: stores how much memory the laptop has
* ```memory_usage```
  * data type: integer
  * description: stores how much memory the laptop is currently using
* ```battery_level```
  * data type: integer
  * description: stores how much battery the laptop has
* ```cpu_temperature```
  * data type: integer
  * description: stores the temperature of tthe cpu



## Class methods
None

## Instance methods
### ```__init__```
The constructor of the object.
### ```turn_on```
Changes power_on attribute to True
### ```turn_off```
Changes power_on attribute to False
### ```run_code```
Increases memory_usage, cput_temperature and lowers battery level.
### ```charge```
Increases battery_level.





