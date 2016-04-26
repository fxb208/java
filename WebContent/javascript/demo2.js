//函数是对象，函数名是指针
function sum(num1,num2){
	return num1+num2;
}
console.log(sum(10,10));
var anotherSum=sum;
console.log(anotherSum(10,10));
sum=null;
console.log(anotherSum(10,10));
/*
 * 以上代码首先定义了一个名为sum()的函数，用于求两个值的和。然后，又声明了变量anotherSum，
 * 并将其设置为与sum 相等（将sum 的值赋给anotherSum）。注意，使用不带圆括号的函数名是访问函
 * 数指针，而非调用函数。此时，anotherSum 和sum 就都指向了同一个函数，因此anotherSum()也
 * 可以被调用并返回结果。即使将sum 设置为null，让它与函数“断绝关系”，但仍然可以正常调用
 * anotherSum()
 * 
*/


/*将函数名想象为指针，也有助于理解为什么ECMAScript 中没有函数重载的概念*/
function addSomeNumber1(num){
	return num+100;
}

function addSomeNumber1(num){
	return num+200;
}

var result1 = addSomeNumber1(100);
console.log(result1);//300
/*这个例子中声明了两个同名函数，而结果则是后面的函数覆盖了前面的函数。
 * 以上代码实际上与下面的代码没有什么区别。
 */

var addSomeNumber2=function(num){
	return num+100;
}
var addSomeNumber2=function(num){
	return num+200;
}
var result2=addSomeNumber2(100);
console.log(result2);//300


/*
 * 实际上，解析器在向执行环境中加载数据时，对函数声明和函数表达式并非一视同仁。
 * 解析器会率先读取函数声明，并使其在执行任何代码之前可用（可以访问）；
 * 至于函数表达式，则必须等到解析器执行到它所在的代码行，才会真正被解释执行
 */
