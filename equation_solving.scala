// Author Hsyao Liu
// Pennsylvania State University
// Solving Equation using Bisecton or Newton Method


// test function: f(x) = 2x^3-3x^2-17x-50
// You can change your function here.

def fun(x:Double)={
    2*x*x*x-3*x*x-17*x-50
}

// bisection
// low and high are the value of the boundary of a section for x

def bisection(low:Double,high:Double):Double={

    if (isGoodEnough(fun((low+high)/2))) (low+high)/2; 
    else {
         if (fun((low+high)/2)*fun(low)<0) bisection(low,(low+high)/2);
         else bisection((low+high)/2,high)
         }
                
}

// good enough x where |f(x)| < epsilon=0.000001
// you can put your required epsilon here

def isGoodEnough(result:Double)={
    (result> -0.000001)&(result< 0.000001) 
}

//  Newton Method
//  guess is the initial guessing number of the solution

def Newton(guess:Double):Double={

    if (isGoodEnough(fun(guess))) guess; 
    else Newton(guess-fun(guess)/differential(guess))
}

// Newton differential

def differential(x:Double):Double= {
	6*x*x-6*x-17
}


//  test case
val A=bisection(-10,10)
val B=Newton(3)
println("bisection="+A)
println("Newton="+B)
