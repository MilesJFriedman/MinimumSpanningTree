Underground Cables

A city wants to get rid of their unsightly power poles by moving their power cables
underground. They have a list of points that all need to be connected, but they
have some limitations. Their tunneling equipment can only move in straight lines
between points. They only have room for one underground cable at any location except
at the given points, so no two cables can cross. Given a list of points, what is the
least amount of cable necessary to make sure that every pair of points is connected,
either directly, or indirectly through other points?

Input
There will be several test cases in the input. Each test case will begin with an
integer N(2≤N≤1,000), which is the number of points in the city. On each of the next
N lines will be two integers, X and Y(-1,000≤X, Y≤1,000), which are the (X,Y) 
locations of the N points. Within a test case, all points will be distinct. The
input will end with a line with a single 0.

Output
For each test case, output a single real number, representing the least amount of
cable the city will need to connect all of its points. Print this number with exactly
two decimal places, rounded. Print each number on its own line with no spaces. Do
not print any blank lines between answers. 

Sample Input
4
0 0
0 10
10 0
10 10
2
0 0
10 10
0

Sample Output
30.00
14.14