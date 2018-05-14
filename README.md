/**
* This project is Created by Sonal Patel
*
*/

**API Framework Stack:**

>Rest-assured.io - API automation Framework

>TestNG - Testing Framework

>Java

>Hamcrest - For Assertion




### To Run,
Open tmdbapis/src/test/java/org/themoviedb/constants/Auth.java and use your api_key of TMDB

##### Example API
I have already automated TV Season > Get Details API - /tv/{tv_id}/season/{season_number}

However, I have created files for below apis
TV Season > Get Credits - /tv/{tv_id}/season/{season_number}/credits
TV Season > Get External IDs - /tv/{tv_id}/season/{season_number}/external_ids


#### Assertions
1) I verify response_code=200 for each test. It is defined in RestUtilities
   However, I have written 1 method to display that how to verify status code in actual test (Method: statusCodeVerificationWithValidData() ).

2) I have also verified Response time of API. Currently I have set it to 5 Seconds. If API takes longer than that, it will fail

3) My Framework also supports different way to get response and use hamcrest assertion
   Please Check - verifyResponseReturnsExternalIds()

4) Soft Assertion
   I have intentionally created soft assertion (Even though 1st assertion fails, test continues and verify other assertion)
   Example - verifyItReturnsCorrectSeason()
