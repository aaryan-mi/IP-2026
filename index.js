console.log("Hello World");
let name = "Aaryan";
var department = "CSE(IoT)";
const PI = 3.14;
let mobile = "OPPO";
let seatno = "92";

let bikeDetails = {
    bikeName : "Yamaha",
    bikeType : "Electric",
    bikeNumber : "6642"
}
// PI = 2929 will show error because we cannot resign values to constant again
console.log("let", name); // if defined prev will show error
console.log("var", department); // doesnot show error if defined prev #no reference error
console.log("const", PI);
console.log("let", mobile);

console.log(typeof name);
console.log(typeof department);
console.log(typeof PI); // doesnot identifies it as float
console.log(typeof mobile);
console.log(typeof hilol); // undefined is also a data type
console.log(typeof bikeDetails.bikeType);



console.log(typeof seatno); // string
seatno = Number(seatno);
console.log(seatno);
console.log(typeof seatno); // number


// COMPARISON OPERATORS
console.log(5=="5"); // TRUE
console.log(5==="5"); /* FALSE, 
because when we use triple equals it check both value 
& datatype which is not in case of == */


// Loops

let age = 17;
for(age = 0; age <= 18; age++){
    console.log("eligible");
}

if(age <= 16){
    console.log("Underage");
} else {
    console.log("Overage");
}

// Function definition and usage

function table(a){
    let i = 0;
    for(i = 0; i<=10; i++){
        console.log(a*i);
    }
}

table(10);

// USAGE OF MAP 

let arraynumbers = [61,5,1,61,61,6]
let res = arraynumbers.map((i)=>i*10)
    console.log(res)

