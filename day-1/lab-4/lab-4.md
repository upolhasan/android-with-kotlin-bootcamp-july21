# 🖥 Lab 4: Building a Game Counter App

We're going to build a simple game life points counter app.

## Objectives
Update MainActivity in the following ways
1. Add a `TextView` to display the target point total
2. Add a `TextView` to display the user's current points
   1. This should start at 0
3. Add a +1 `Button` that the user can click to increment their score by 1
4. Every time the +1 button is clicked, the users current points label should be updated
5. When the target points total has been reached, display a feedback `Toast` to the user saying they won
6. When the target points total has been reached, display a Reset `Button`
7. When the Reset `Button` is clicked, reset the user's points to 0 and hide the Reset `Button`

## Challenges
1. Update the color of the user's current score to represent how close they are to winning.  ex. Start with Red text, move to Yellow, and get to Green
2. Update the screen to support 2 users, and include which user won in the feedback `Toast`
3. Add additional buttons such as +3 or -1