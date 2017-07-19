# ticker

The ticker app is an easy to launch [Spring Boot](https://projects.spring.io/spring-boot/) app that will only focus to gather public [Bitcoin](https://www.youtube.com/watch?v=Um63OQz3bjo) prices from different exchanges.  In doing so, it persists the ticker values to a database .  This ticker app will then also expose a REST API which can be used by other code-crafter-like apps to achieve autonomous goals.  Prices from all platforms will be based on USD (by using [fixer.io](http://api.fixer.io/latest?base=USD)).  For now the focus is in Bitcoin, but importing prices for alternative coins will be considered once there are at least 5+ exchanges to pull data from.

#### Pulling prices from these exchanges
- [luno.com](https://www.luno.com/)
- [bitstamp.net](https://www.bitstamp.net/)
- [cex.io](https://www.cex.io/) (integration in progress)
- [poloniex.com](https://poloniex.com/support/api/) (on road map)
- [spectrocoin.com](https://spectrocoin.com/scapi/ticker/USD/BTC) (on road map)

#### Checkout

Pull the latest code from repository

```markdown
git clone git@github.com:arnoe/codecrafter.git
cd codecrafter
cd ticker
```````

#### Run

Run the ticker service either using the remote (central) or local database.   Getting up and running with the remote 
DB you will need an internet connection, and has not setup overhead other than running it like this:

```markdown
../gradlew bootRun
```````

#### View

Now you are ready to view your locally running [ticker service](http://localhost:8080), have fun!


## REST API

Latest tickers: [http://localhost:8080/tickers](http://localhost:8080/tickers)

Refer to [REST API pagination in Spring](http://www.baeldung.com/rest-api-pagination-in-spring) to understand pagination 
of spring objects

#### Current REST objects

Profile viewable [here](http://localhost:8080/profile)

* Ticker (/ticker)
* Order (/order)

