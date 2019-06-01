# Tetranacci
Tetranacci numbers are a different version of Fibonacci numbers and start with four predetermined terms, each term afterwards being the sum of the preceding four terms. The first few Tetranacci numbers are: 0, 0, 0, 1, 1, 2, 4, 8, 15, 29, 56, 108, 208, 401, 773, 1490, …

Formally, the Tetranacci sequence above can be recursively defined as follows:
T(0)=0, T(1)=0, T(2)=0, T(3)=1
T(n) = T(n-1) + T(n-2) + T(n-3) + T(n-4), for n ≥ 4.

In this programming assignment, you will design in pseudo code and implement in Java two versions of Tetranacci calculators and experimentally compare their runtime performances.
  a) In the first version, you will design the pseudocode and implement in Java an exponential version of Tetranacci calculator by directly      implementing the previous recursive definition. You may call it ExponentialTetranacci(n). You will calculate ExponentialTetranacci(5),      ExponentialTetranacci(10), etc. in increments of 5 up to ExponentialTetranacci(50) (or lower value if necessary for your timing            measurement) and measure the corresponding run times. You need to use Java’s built-in time function for this purpose. You should            redirect the output to an out.txt file. You should write about your observations on timing measurements in a separate text or pdf          file. You are required to submit the fully commented Java source files, the compiled executable, and the text/pdf files.
   b) In the second version, you will design the pseudocode and implement in Java a tail recursive version of Tetranacci calculator. You         may call it TRTetranacci(n). Run your timing measurement as in a) above, starting with TRTetranacci(5), and incrementing in steps of       5 up to TRTetranacci(100) (or higher value if necessary). Provide the same deliverables as in a).
