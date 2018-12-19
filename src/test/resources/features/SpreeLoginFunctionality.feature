Feature: Spree login functionality
  Background:
    Given Not a validated user
    When User browse to the site
    Then Spree home page should display
    When User click login link
    Then Browser display Login page
  @smoke
  @debug
  Scenario: 1.Valid user with valid password
    When User enter user email as "shiftqa1@gmail.com"
    And User enter password as "shiftedtech"
    And User click login button
    Then Home page should display
    And Login success message display