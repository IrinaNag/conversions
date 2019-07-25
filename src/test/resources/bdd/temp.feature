Feature:   Temperature

  Scenario: Convert Celsius to Fahrenheit
    Given temperature value with Celsius
    When I convert the temperature to Fahrenheit
    Then the temperature value with Fahrenheit is equal to temperature value with Celsius  * 1.8 + 32