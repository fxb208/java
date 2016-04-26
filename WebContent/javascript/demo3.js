/*
 * 因为ECMAScript 中的函数名本身就是变量，所以函数也可以作为值来使用。
 * 也就是说，
 * 1,不仅可以像传递参数一样把一个函数传递给另一个函数，
 * 2,而且可以将一个函数作为另一个函数的结果返回。
 */
function callSomeFunction(someFunction,someArgument){
	return someFunction(someArgument);
}

function add(num){
	return num+10;
}
var result1=callSomeFunction(add,10);
console.log(result1);

function getName(name){
	return "hello,"+name;
}
var result2=callSomeFunction(getName,"fxb");
console.log(result2);
/*这里的callSomeFunction()函数是通用的，即无论第一个参数中传递进来的是什么函数，
 * 它都会返回执行第一个参数后的结果。
 * 要访问函数的指针而不执行函数的话，必须去掉函数名后面的那对圆括号。
 * 因此上面例子中传递给callSomeFunction()的是add 和getName，
 * 而不是执行它们之后的结果。*/



/*
 * 可以从一个函数中返回另一个函数，而且这也是极为有用的一种技术
 * js自定义排序
 * 假设有一个对象数组，我们想要根据某个对象属性对数组进行排序。
 * 而传递给数组sort()方法的比较函数要接收两个参数，即要比较的值。
 * 可是，我们需要一种方式来指明按照哪个属性来排序。
 * 要解决这个问题，可以定义一个函数，它接收一个属性名，然后根据这个属性名来创建一个比较函数，
 * 下面就是这个函数的定义。
 */
function createComparisonFunction(propertyName){
	return function(object1,object2){
		var value1=object1[propertyName];
		var value2=object2[propertyName];
		if(value1>value2){
			return 1;
		}else if(value1<value2){
			return -1;
		}else{
			return 0;
		}
		
	};
}

var data=[{name:"xlj",age:"27"},{name:"fxb",age:"25"}];
console.log(data[0]);
data.sort(createComparisonFunction("age"));
console.log(data[0]);