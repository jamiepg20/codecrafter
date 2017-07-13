# ticker

The ticker app is an easy to launch [Spring Boot](https://projects.spring.io/spring-boot/) app that only focus to gather 
public [Bitcoin](https://www.youtube.com/watch?v=Um63OQz3bjo) prices from different platforms.  In doing so, it persists the values to a database .  This ticker service will then also expose a REST API which can be used by more autonomous services.  Prices from all platforms will be based on USD (by using [fixer.io](http://api.fixer.io/latest?base=USD)).

#### Currently integrated with
- [luno.com](https://www.luno.com/)
- [bitstamp.net](https://www.bitstamp.net/)
- [cex.io](https://www.cex.io/) (integration in progress)

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

Viewable [here](http://localhost:8080/profile)

* Ticker (/ticker)
* Order (/order)

