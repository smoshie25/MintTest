# MintTest
docker: docker pull smoshie25/mint-test
Note: the docker image does not contain kafka server 

application UI: http://localhost:8080/swagger-ui.html#

Task 2: Number of hits (Hit Count) : GET /card-scheme/stats?start=1&limit=3
has some modification on hte URL: GET  /card-scheme/stats?:pageNumber=1&size=3
also the response JSON structure on the payload is not as expected.
