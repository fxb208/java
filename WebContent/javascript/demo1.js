/*
 * 参考：http://www.jb51.net/article/30883.htm
 *  1、每个函数都包含两个非继承而来的方法：apply()和call()。 
 *	2、他们的用途相同，都是在特定的作用域中调用函数。 
 *	3、接收参数方面不同，apply()接收两个参数，一个是函数运行的作用域(this)，另一个是参数数组。
 *	call()方法第一个参数与apply()方法相同，但传递给函数的参数必须列举出来。 
 *	4、bind()方法
 */
//demo1.1
var firstName="diz";
var lastName="song";
var myObject={firstName:"My",lastName:"Object"}
function HelloName() { 
	console.log("Hello " + this.firstName + " " + this.lastName, " glad to meet you!"); 
} 
HelloName.apply(this);
HelloName.call(myObject);


//demo1.2
function sum(sum1,sum2){
	return sum1+sum2;
}
console.log(sum.apply(this, [12,25]));
console.log(sum.call(this,12,25));

//demo1.3
/**
 * 想让HelloName()函数的作用域在对象myObject上，
 * 我们需要动态创建myObject的HelloName属性，
 * 此属性作为指针指向HelloName()函数，
 * 这样，当我们调用myObject.HelloName()时，
 * 函数内部的this变量就指向myObjecct，也就可以调用该对象的内部其他公共属性了。 
 * 通过分析，我们可以看到call()和apply()函数的真正运用之处
 * 
 */
HelloName();
myObject.helloName=HelloName;
myObject.helloName();

//demo1.4 函数中定义函数时，this变量的情况 
function temp1() { 
	console.log(this); //Object {} 
	function temp2() { 
		console.log(this); //Window 
	} 
	temp2(); 
} 
var Obj = {}; 
temp1.call(Obj); 


function temp11() { 
	console.log(this); //Object {} 
	temp22(); 
} 
function temp22() { 
	console.log(this); //Window 
} 
var Obj = {}; 
temp11.call(Obj); 


//demo1.5
/*
 * sayColor()调用bind()方法，并传入o对象，
 * 返回了OSayColor()函数，在OSayColor()中，this的值就为o对象。
 */
window.color="red";
var o={color:"blue"};
function sayColor(){
	alert(this.color); 
}
var oSayColor=sayColor.bind(o);
oSayColor(); //blue