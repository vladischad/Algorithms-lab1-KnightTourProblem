# Lab #1: The Knight Tour problem

* Author:   Vladyslav (Vlad) Maliutin
* Class:    CS 421 - Algorithms
* Semester: Sp25 

## Overview
This project implements the **Knight's Tour** problem using backtracking with three different search strategies:
1. **Basic Search (searchType = 0)** - Tries all possible moves in a fixed **clockwise order**.
2. **Heuristic I (searchType = 1)** - Prioritizes moves that are closer to the **board edges**.
3. **Heuristic II (searchType = 2, Warnsdorff’s Rule)** - Chooses the move with the **fewest onward moves**.

Given a board size **n × n** and a starting position **(x, y)**, the program finds a sequence of moves that allows the knight to visit every square **exactly once**. If a solution is found, the program prints the board with move numbers; otherwise, it reports **"No solution found"**.

## Compiling and Using
Ensure that you have installed. To compile all Java files, use:

<pre>
javac *.java
</pre>

Run the program using the following command:

<pre>
java KnightTour &lt;searchType&gt; &lt;boardSize&gt; &lt;startX&gt; &lt;startY&gt;
</pre>

searchType:
    0 → Basic Search;
    1 → Heuristic I (Border Distance);
    2 → Heuristic II (Warnsdorff’s Rule);

boardSize: Integer greater than 2 (e.g., 6 for a 6×6 board).

startX: Starting row position (0-based index).

startY: Starting column position (0-based index).

## Results 
Run your program three times, one for each search option, with n = 7; x = 1; y = 1:

<pre>
PS C:\Users\vladm\OneDrive\Desktop\CS421 - Algorithms\Labs\Algorithms-lab1> java KnightTour 0 7 1 1
The total number of moves is 254727174
21 46 41  2 23 26  9
40  1 22 27 10  3 24
47 20 45 42 25  8 11
44 39 34 19 28 15  4
33 48 43 36  7 12 29
38 35 18 31 14  5 16
49 32 37  6 17 30 13

PS C:\Users\vladm\OneDrive\Desktop\CS421 - Algorithms\Labs\Algorithms-lab1> java KnightTour 1 7 1 1
The total number of moves is 810
21 44 11  2 23 36 13
10  1 22 43 12  3 24
45 20  9 40 35 14 37
 8 33 42 49 38 25  4
19 46 39 34 41 28 15
32  7 48 17 30  5 26
47 18 31  6 27 16 29

PS C:\Users\vladm\OneDrive\Desktop\CS421 - Algorithms\Labs\Algorithms-lab1> java KnightTour 2 7 1 1
The total number of moves is 172
49 44 11  2 29 42 13
10  1 46 43 12  3 28
45 48  9 30 41 14 35
 8 25 40 47 36 27  4
39 22 31 26 17 34 15
24  7 20 37 32  5 18
21 38 23  6 19 16 33
</pre>

## Sources used

N/A