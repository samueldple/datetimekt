# Changelog

## Version 1.3.1

-   Changed implementation of `Date.today()`, `Month.thisMonth()`, `Time.now()` (and consequently `DateTime.now()`) to support java versions < 1.8.

## Version 1.3.0

-   Added `toPosixSeconds()` method and `fromPosixSeconds()` function onto `Date` and `DateTime`.
-   Fix: `Date.fromDays()` now returns `null` if the number of days is greater than those in the maximum date. It previously returned a date in the year 9999 depending on the number additional days above the maximum.

## Version 1.2.0

-   `Duration` now has a `toDays()` method for getting the number of days within it, ignoring hours, minutes, and seconds.

## Version 1.1.0

-   `Duration`'s internal number of seconds is now `Long` to account for durations of up to the maximum date
    minus the minimum date.
-   The method `between` on `Duration` has been added to allow the user to find the difference between two
    `DateTime`s as a `Duration`.
-   The `Duration(totalSeconds: Int)` constructor has been _deprecated_ in favour of `Duration(totalSeconds: Long)`. This will be _removed_ in version 2.0.0.

## Version 1.0.2

-   Fixed package naming
-   Added getters to `DateTime`

## Version 1.0.1 - **unusable**

-   Fix module name

## Version 1.0.0 - **unusable**

-   API stabilised
