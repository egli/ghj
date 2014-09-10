# ghj

A command line interface to the Github API

This is probably mostly an excercise in futility. People that want a
_real_ command line interface should look
elsewhere. [git-hub](https://github.com/sociomantic/git-hub),
[github-gem](https://github.com/defunkt/github-gem),
[nodegh](http://nodegh.io/) or even using curl (as outlined in
[this blog entry](https://robinwinslow.co.uk/2013/06/07/create-github-repositories-from-the-command-line/))
should be good candidates.

That being said there are a few pretty big giants to stand on their
shoulders, namely [tools.cli](https://github.com/clojure/tools.cli)
and [tentacles](https://github.com/Raynes/tentacles) by Anthony Grimes
who never seems to sleep. So let's try if we can hack a command line
interface to the Github API in an afternoon :-).

## Installation

Use `lein bin` to install.

## Usage

	$ ghj [options] subcommand

## Options

See usage, i.e.

	$ ghj --help

## Examples

	$ ghj --user=liblouis --repo=liblouis issues
	$ ghj --user=egli repos

### Bugs

- Currently auth is not supported

## License

Copyright © 2014 Christian Egli

Distributed under the GNU General Public License either version 3.0 or
(at your option) any later version.
