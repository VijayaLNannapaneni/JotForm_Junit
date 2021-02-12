$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("StudentRegistration.feature");
formatter.feature({
  "line": 1,
  "name": "Course registration",
  "description": "",
  "id": "course-registration",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Student registration",
  "description": "",
  "id": "course-registration;student-registration",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "The student navigates to registration page on chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The student enters all the data \u003cRow\u003e",
  "keyword": "When "
});
formatter.examples({
  "line": 6,
  "name": "",
  "description": "",
  "id": "course-registration;student-registration;",
  "rows": [
    {
      "cells": [
        "Row"
      ],
      "line": 7,
      "id": "course-registration;student-registration;;1"
    },
    {
      "cells": [
        "2"
      ],
      "line": 8,
      "id": "course-registration;student-registration;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 8,
  "name": "Student registration",
  "description": "",
  "id": "course-registration;student-registration;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@test"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "The student navigates to registration page on chrome browser",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "The student enters all the data 2",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.match({
  "location": "StudentRegistrationStepDef.student_navigates_to_registration_page()"
});
