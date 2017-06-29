# Projects

Here are a bunch of micro serices, each runs independantly, also integrates with the other services running in conjunction.

## Ticker

Gathers the latest prices of each of these vendors

#### Vendors
- luno.com _(using fixer.io to convert ZAR to USD)_
- bitstamp.net
- cex.io (incomplete)

### Database

First of all you'll need a database

```markdown
create database repository;
show databases;
create user coder;
grant all on repository.* to 'coder'@'localhost' identified by 'coffee';
```

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

## Equity

Having accounts with some of these following vendors, it would be nice to track your equity.  Ideally this app should be lauched with your own account details, which will track your own equity.

#### Vendors 
- luno.com _(using fixer.io to convert ZAR to USD)_
- bitstamp.net
- cex.io (incomplete)







_ignore any thing below this line for now_
______________________________________________________________________________


## Welcome to GitHub Pages

You can use the [editor on GitHub](https://github.com/arnoe/codecrafter/edit/master/README.md) to maintain and preview the content for your website in Markdown files.

Whenever you commit to this repository, GitHub Pages will run [Jekyll](https://jekyllrb.com/) to rebuild the pages in your site, from the content in your Markdown files.

### Markdown

Markdown is a lightweight and easy-to-use syntax for styling your writing. It includes conventions for

```markdown
Syntax highlighted code block

# Header 1
## Header 2
### Header 3

- Bulleted
- List

1. Numbered
2. List

**Bold** and _Italic_ and `Code` text

[Link](url) and ![Image](src)
```

For more details see [GitHub Flavored Markdown](https://guides.github.com/features/mastering-markdown/).

### Jekyll Themes

Your Pages site will use the layout and styles from the Jekyll theme you have selected in your [repository settings](https://github.com/arnoe/codecrafter/settings). The name of this theme is saved in the Jekyll `_config.yml` configuration file.

### Support or Contact

Having trouble with Pages? Check out our [documentation](https://help.github.com/categories/github-pages-basics/) or [contact support](https://github.com/contact) and we’ll help you sort it out.
