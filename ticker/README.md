# Ticker

Gathers the latest prices of each of these vendors

#### Vendors
- luno.com _(using fixer.io to convert ZAR to USD)_
- bitstamp.net
- cex.io (incomplete)

### Checkout, build, start app

Pull the latest code from repository, execute bootRun, which will clean, build and run the ticker services

```markdown
git clone git@github.com:arnoe/codecrafter.git
cd codecrafter
cd ticker
../gradlew bootRun
```

### Analysis

#### REST
Latest tickers
http://localhost:8000/ticker?sort=timestamp,desc&size=5

Refer to [REST API pagination in Spring](http://www.baeldung.com/rest-api-pagination-in-spring) to view objects

#### MySQL

```markdown
SELECT
  source,
  concat(round(min(price)), ' USD') AS min,
  concat(round(max(price)), ' USD') AS max,
  max(price) - min(price) AS spread
FROM ticker 
GROUP BY source
```
