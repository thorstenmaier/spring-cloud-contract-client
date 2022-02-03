# Spring Cloud Contract Client

## Demo steps

* First of all implement Spring Cloud Contract Service
* Generate this project with two dependencies
  * `spring-boot-starter-web`
  * `spring-cloud-starter-contract-stub-runner`
* Add class `CustomerClient`
  * Implement with dummy and empty `ArrayList`
* Add test class `CustomerClientTest`
  * `BDDAssertions.then(this.customerClient.getAllCustomers()).size().isEqualTo(0);`
* Run test
* Use RestTemplate for remote call
* Run test without starting the remote service
  * Of course the tests fails. But this is exactly the problem in a distributed system 
* Change port of client to `8081`
* Use wiremock for mocking the service in `CustomerClientTest`
* This does work, but only until the interface of the service changes
* Go back to service and implement contract based testing
* Come back here and use `@AutoConfigureStubRunner(ids = "com.trivadis:spring-cloud-contract-service:+:8080", stubsMode = StubRunnerProperties.StubsMode.LOCAL)` for test