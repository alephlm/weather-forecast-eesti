# Weather Forecast Example App

## Summary
This application consumes the XML weather API available [here](http://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng) that returns weatehr conditions for some estonian cities.

We are using a SpringBoot application calling this API every 30min and saving the results in the database. A static page consumes this data from our database in JSON format and shows the result on a html page.

## What is needed to run:
- Maven
- java 8

## How to run:

Execute the command `mvn spring-boot:run` and then a page is accesible at `localhost:8080`.
