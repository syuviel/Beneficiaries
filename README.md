For this project, I implemented recycler view to hold the data I parced from json. I used Gson to convert json file into my data class to use with my views. I programmatically set each view on a linear layout.

I decided on a recycler view since it can hold many objects and, with a click listener, pass the current object to the next screen/layout.

Updates I would make: I would use more const or enums where needed. I would not use strings directly (I would use resource if the app needed translation into multiple langues, or consts at least). I would implement a fragment instead of using one screen (I had some trouble getting the layout to inflate programmatically). I would have an extension class and use extension functions. I would use .let and .apply more for code efficiency. I would update the colors on the app, make the divider more noticable, and add more padding. I would also add a toolbar and some proper titles.

Thank you for checking out my app!
