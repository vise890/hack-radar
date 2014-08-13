# hack-radar
A remix of the data found on the awesome [TW tech radar](http://www.thoughtworks.com/radar)


## Requirements

- git
- lein
- mongodb


## Installation

```bash
$ git clone https://github.com/vise890/hack-radar
$ lein ring server
```
Evaluate `./src/hack_radar/db/seed.clj` to refresh the database.

## Usage
After you start ring, you can:
```
GET /                # show all the techs
GET /:area           # show all the techs in :area
GET /:status         # show all the techs in a :status
GET /:area/:status   # ... you get the picture
```
Where the parameters `:area` and `:status` can be any of:

- `:area`
  - `:techniques`
  - `:tools`
  - `:platforms`
  - `:languages-and-frameworks`

- `:status`
  - `:adopt`
  - `:trial`
  - `:assess`
  - `:hold`

I strongly suggest you get [JSONView](http://jsonview.com/) if intend to
look at all the raw JSON.
