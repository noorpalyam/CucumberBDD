
@sanityTest
Feature: Login

  Scenario Outline: Login to Securends application

    Given I open Securends Application "<URL>"
    When I Login as admin "<username>","<password>"
    When I Logout of the Application


Examples:
|URL|username|password|
|url|username|password|