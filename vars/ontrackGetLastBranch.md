## `ontrackGetLastBranch`

This step returns the last branch of a project based on a regex pattern.

Note that the _Ontrack branch name_ is used for matching
and the value being returned.

Parameters:

* `project` - required - the name of the Ontrack project
* `pattern` - defaults to `.*` - regular expression to
match against the Ontrack branch name

Returns:

* the name of the last Ontrack branch of the project which matches the `pattern` regular expression. `null` is returned is nothing is found.

Example:

```groovy
String branch = ontrackGetLastBranch(project: "PRJ", pattern: "release-.*")
```
